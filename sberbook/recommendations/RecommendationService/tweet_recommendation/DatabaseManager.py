# DatabaseManager - это тот кто знает инфу о пользователе (откуда ее достать)
from pymongo import MongoClient


class DatabaseManager:
    def __init__(self, database_url):
        self.mongo_client = MongoClient(database_url)
        self.mongo_database = self.mongo_client.recommendation_DB
        # подписки пользователя
        self.user_subscriptions = self.mongo_database.user_subscriptions
        # текущая порция твитов пользователю
        self.user_current_portion = self.mongo_database.user_current_portion
        # история твитов отправленных пользователю
        self.user_recieved_tweets = self.mongo_database.user_recieved_tweets
        # база данных твитов
        self.user_tweets = self.mongo_database.tweets_db
        # количество обращений юзера в сервис рекомендаций
        self.handles_to_service = self.mongo_database.handles_to_service
        # лайки пользователя за последние 3 отправленные порции
        self.user_likes_on_tweets = self.mongo_database.user_likes_on_tweets

    def get_user_subscriptions(self, user_id) -> list:
        """подписки пользователя"""
        return self.user_subscriptions.find_one({'user_id': user_id})['subs']

    def get_user_likes_on_subs_tweets(self, user_id) -> list:
        """на выходе список из 3ех словарей -> то есть за 3 отправки что он лайкнул"""
        likes_list = []
        list_of_dicts = self.user_likes_on_tweets.find({'user_id': user_id})
        epochs_amount = 0
        for i in list_of_dicts:
            likes_list.append(i['likes'])
            epochs_amount += 1
            if epochs_amount == 3:
                break
        return likes_list

    def delete_user_likes_on_subs_tweets(self, user_id) -> int:
        """удаляем лайки за последние 3 эпохи"""
        deleted_documents_number = self.user_likes_on_tweets.delete_many({'user_id': user_id})
        return deleted_documents_number

    def get_current_portion_info(self, user_id) -> dict:
        """сколько твитов от подписчиков изера мы сейчас ему отправляем"""
        return self.user_current_portion.find_one({'user_id': user_id})['portion']

    def update_current_portion(self, user_id, current_portion):
        """обновим данные порции в базе данных"""
        my_query = {'user_id': user_id}
        new_value = {'$set': {'portion': current_portion}}
        return self.user_current_portion.update_one(my_query, new_value)

    def get_previous_recieved_tweets(self, user_id, subscription_id) -> list:
        """какие твиты мы уже отправили пользователю"""
        return self.user_recieved_tweets.find_one({'user_id': user_id})['previous_tweets'][subscription_id]

    def get_amount_of_handles_to_recommend_service(self, user_id) -> int:
        """количество ооращений пользователя к сервису"""
        return int(self.handles_to_service.find_one({'user_id': user_id})['user_handles'])

    def update_handles_to_service(self, user_id):
        """обновляем количество обращений к сервису"""
        current_amount = self.get_amount_of_handles_to_recommend_service(user_id=user_id)
        my_query = {'user_id': user_id}
        new_value = {'$set': {'user_handles': current_amount + 1}}
        return self.handles_to_service.update_one(my_query, new_value)

    def get_subs_tweets(self, subscription_id) -> list:
        """твиты пользователя"""
        tweets_id = []
        tweets_obj = self.user_tweets.find({'user_id': subscription_id})
        for tweet_id in tweets_obj:
            tweets_id.append(tweet_id['tweet'])
        return tweets_id

    @staticmethod
    def clean_collection(collection):
        """очистим коллекцию данную"""
        result = collection.delete_many({})
        return result
