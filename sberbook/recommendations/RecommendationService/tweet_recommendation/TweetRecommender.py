# import sqlite3
# from pymongo import MongoClient
# import numpy as np
from RecommendationService.tweet_recommendation.DatabaseManager import DatabaseManager
from RecommendationService.tweet_recommendation.PortionCalculator import PortionCalculator


class TweetRecommender:
    def __init__(self, database_url):
        self.__database_url = database_url
        self.__database_manager = DatabaseManager(self.__database_url)
        self.__calculator = PortionCalculator()
        self.__handle_checkpoint = 3

    def check_user_state(self, user_id):
        """проверка, можно ли обновить данные поцрии твитов у клиента"""
        handles_amount = self.__database_manager.get_amount_of_handles_to_recommend_service(user_id=user_id)
        if handles_amount % self.__handle_checkpoint == 0:
            return True
        else:
            return False

    def send_tweet_portion_to_user(self, user_id) -> dict:
        """отправление порции твитов пользователю"""
        # подписки пользователя
        user_subscriptions = self.__database_manager.get_user_subscriptions(user_id=user_id)
        # список твитов которые рекомендуем пользователю
        # текущее количество твитов в порции
        current_portion = self.__database_manager.get_current_portion_info(user_id=user_id)['sub_id']
        output_tweets_per_sub = dict()
        for sub_id in user_subscriptions:
            # твиты подписчика
            subs_tweets = self.__database_manager.get_subs_tweets(subscription_id=sub_id)
            portion_size = current_portion[sub_id]
            # твиты, которые были отправлены уже этому пользователю от этого подписчека
            user_tweet_history_on_sub = self.__database_manager.get_previous_recieved_tweets(user_id=user_id,
                                                                                             subscription_id=sub_id)
            # формирование исходного словаря со ключом = sub_id и значением = список новых твитов
            output_tweets_per_sub[sub_id] = self.__calculator.form_output_tweets(subs_tweets,
                                                                                 user_tweet_history_on_sub,
                                                                                 portion_size)
        return output_tweets_per_sub

    def calculate_new_portion(self, user_id):
        """рассчет новой порции твитов юзера"""
        likes_on_epoch_list = self.__database_manager.get_user_likes_on_subs_tweets(user_id=user_id)
        previous_portion_info = self.__database_manager.get_current_portion_info(user_id=user_id)
        mean_likes_on_epoch_list = self.__calculator.get_mean_likes(portion_of_likes=likes_on_epoch_list)
        new_portion = self.__calculator.calculate_tweet_portion_per_sub(
            mean_likes_on_prev_n_epochs=mean_likes_on_epoch_list,
            previous_tweet_number=previous_portion_info)
        return new_portion

    def run(self, user_id):
        # создаем обьект класса DatabaseManager для взаимодействия с БД
        database_manager = DatabaseManager(self.__database_url)
        # провекра, сколько раз юзер обратился за новой порцией твитов, если 3 раза, считаем новую статистику
        database_manager.update_handles_to_service(user_id)
        if self.check_user_state(user_id):
            # считаем новую порцию, записываем в БД юзеру
            new_portion = self.calculate_new_portion(user_id)
            # обновляем в бд порцию для юзера
            database_manager.update_current_portion(user_id, new_portion)
            # удаляем инфу о старых лайках юзера
            database_manager.delete_user_likes_on_subs_tweets(user_id)
            # отправляем количество твитов, которые надо отправить
            return self.send_tweet_portion_to_user(user_id)
        else:
            # просто отправляем размер порций, который есть сейчас
            return self.send_tweet_portion_to_user(user_id)

    # TODO: сделать функции которые будут обновлять данные в соответсвующих коллекциях монго

if __name__ == '__main__':
    recommender = TweetRecommender('localhost:27017')
    recommender.run(user_id=0)

    #     #SQL connection
    #     self.database_filename = db_filename
    #     self.conn = sqlite3.connect(self.database_filename, timeout=10)
    #     self.cursor = self.conn.cursor()
    #     #MongoDB connection
    #     self.client = MongoClient('mongodb://localhost:27017/')
    #     #создадим NoSQL базу данных
    #     self.db = self.client.recommendation_service
    #     # количество топиков * изначальное количество твитов на топик
    #     # твитов больше этого количества быть не может
    #     self.max_tweets_per_portion = 25
    #     self.tweets_topic = ['Россия', 'Экономика', 'Спорт', 'Мир', 'Культура']
    #
    #
    # def check_user_handle_number(self, user_id):
    #     """идем в юзер лайкс, првоеряем, настоло ли время создавать новую порцию"""
    #     pass
    #
    # def get_user_tweet_counts(self, user_id: int) -> dict:
    #     query = """Select * from ..."""
    #     pass
    #
    # #not my database, i will use it some service API to access it
    # def get_new_tweets_portion(self, tweet_number_for_topic_dict: dict) -> dict:
    #     tweets_portion_dict = {}
    #     for topic in self.tweets_topic:
    #         tweets_number = tweet_number_for_topic_dict[topic]
    #         query = """SELECT cast(tweet_id as int) from sberbook_tweets
    #                    WHERE rubric like {0}
    #                    ORDER BY random()
    #                    LIMIT {1}""".format(topic, tweets_number)
    #         try:
    #             self.cursor.execute(query)
    #             tweets_ids = list(map(lambda x: x[0], self.cursor.fetchall()))
    #             tweets_portion_dict[topic] = tweets_ids
    #         except:
    #             print("SQL EXECUTION ERROR")
    #
    #     return tweets_portion_dict
    #
    # def calculate_new_portion(self, previous_tweet_number: np.array,
    #                           likes_on_topics: np.array):
    #     conditional_probability = likes_on_topics / previous_tweet_number
    #     full_probability = sum(conditional_probability)
    #     aposterior_probability = conditional_probability / full_probability
    #
    #     new_portion_distribution = np.round(aposterior_probability * self.max_tweets_per_portion)
    #
    #     return new_portion_distribution
    #
    # def get_mean_user_likes_per_subscription(self):
    #     #берем подписки пользователя, смотим под какими твитами из 3 последних порций он поставил лайк
    #     #каждая порция это набор новых твитов от подписок
    #     #
    #     pass
    #
    #
    #     # TODO: Решить каким образом будет достигатсья асинхронность в формировании порции для юзера
    #
    # def recommend_tweets(self, user_id):
    #     #проверим, настало ли время создавать новую порцию
    #     user_check = self.check_user_handle_number(user_id)
    #     if user_check:
    #         pass
