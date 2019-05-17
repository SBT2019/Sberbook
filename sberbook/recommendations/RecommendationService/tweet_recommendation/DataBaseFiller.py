from pymongo import MongoClient

import random
import pprint

from RecommendationService.tweet_recommendation.DatabaseManager import DatabaseManager

pp = pprint.PrettyPrinter(indent=4)
random.seed(42)


class DataBaseFiller:
    """заполняем базы данных для функционирования системы"""

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
        self.user_likes_on_tweets = self.mongo_database.user_likes_on_tweetsb

        self.DataBaseManager = DatabaseManager('localhost:27017')

        # также очистим все коллекции перед тем как заполнять
        self.user_subscriptions.remove({})

    def fill_user_subscription(self):
        """заполняем коллекцию user_subscriptions подписками пользователей"""
        for user_id in range(100):
            subs_amount = random.randint(1, 7)
            subs = random.sample(range(1, 100), subs_amount)
            user_subs = {'user_id': user_id,
                         'subs': subs}
            self.user_subscriptions.insert_one(user_subs)
        print("USER_SUBSCRIPTIONS IS FILLED!")

    def fill_user_current_portion(self):
        for user_id in range(100):
            subs_amount = len(self.user_subscriptions.find_one(user_id)['subs'])
            user_portion = {'user_id': user_id,
                            'portion': [5] * subs_amount}
            self.user_current_portion.insert_one(user_portion)
        print("USER_CURRENT_PORTION IS FILLED!")

    def fill_user_likes_on_tweets(self):
        for user_id in range(100):
            # каждый пользователь мог пролакать свои порции от 1 до n раз, так что заполним соответсвенно так эту
            # коллекцию
            liked_epochs = random.randint(1, 4)
            for epoch in range(liked_epochs):
                # достаем из базы его подписки и каждой подписке ставим в соответсвие какое количество лайков
                # достаем все подписки конкретного пользователя и размеры порций твитов для этих подписок
                user_subs = self.DataBaseManager.get_user_subscriptions(user_id=user_id)
                user_portion_per_sub = self.DataBaseManager.get_current_portion_info(user_id=user_id)
                # проверим что количесвто ключей равно количеству подписчеков
                assert len(user_subs) == len(user_portion_per_sub)
                # для каждой подписки генерим количесвто лайков от 0 до user_portion_per_sub[sub]
                user_like_epoch = {}
                for sub in user_subs:
                    user_like_epoch[sub] = random.randint(0, user_portion_per_sub[sub])
                collection_document = {
                    'user_id': user_id,
                    'likes': user_like_epoch,
                }
                self.user_likes_on_tweets.insert_one(collection_document)
        print('LIKES ON USER TWEETS WAS FILLED!')


    def fill_user_recieved_tweets(self):
        pass

    def fill_user_tweets(self):
        pass

    def fill_user_handles_to_service(self):
        for user_id in range(100):
            collection_document = {'user_id': user_id,
                                   'handle_amount': random.randint(1, 7)}
            self.handles_to_service.insert_one(collection_document)
        print('USER HANDLES TO SERVICE WAS FILLED')



if __name__ == '__main__':
    db_filler = DataBaseFiller('localhost:27017')
    db_filler.fill_user_subscription()
