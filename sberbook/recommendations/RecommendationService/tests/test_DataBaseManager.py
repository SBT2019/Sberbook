import unittest
from pymongo import MongoClient
from RecommendationService.tweet_recommendation.DatabaseManager import DatabaseManager


class MyTestCase(unittest.TestCase):
    informant = DatabaseManager('localhost:27017')

    def setUp(self) -> None:
        self.informant = DatabaseManager('localhost:27017')

        client = MongoClient('localhost:27017')
        self.db = client.recommendation_DB
        # очистим используемые коллекции
        self.db.user_current_portion.delete_many({'user_id': 0})
        self.db.handles_to_service.delete_many({'user_id': 0})
        self.db.user_likes_on_tweets.delete_many({'user_id': 0})

    def test_get_user_handles_to_service(self):
        user_handle = {'user_id': 0,
                       'user_handles': 5}
        self.db.handles_to_service.insert_one(user_handle)

        user_id = 0
        result = 5
        select_result = self.informant.get_amount_of_handles_to_recommend_service(user_id)
        self.assertEqual(select_result, result)

    def test_get_user_likes_on_subs_tweets(self):
        user_likes_1 = {'user_id': 0,
                        'likes': {
                            'спорт': 3,
                            'мир': 2,
                            'май': 1
                        }}
        self.db.user_likes_on_tweets.insert_one(user_likes_1)

        user_likes_1 = {'user_id': 0,
                        'likes': {
                            'май': 2,
                            'музыка': 2
                        }}
        self.db.user_likes_on_tweets.insert_one(user_likes_1)

        user_likes_1 = {'user_id': 0,
                        'likes': {
                            'алкоголь': 1
                        }}
        self.db.user_likes_on_tweets.insert_one(user_likes_1)

        user_id = 0
        result = [{'спорт': 3, 'мир': 2, 'май': 1},
                  {'май': 2, 'музыка': 2},
                  {'алкоголь': 1}]
        select_result = self.informant.get_user_likes_on_subs_tweets(user_id)
        self.assertEqual(select_result, result)

    def test_update_current_portion(self):
        # добавляем документ
        document = {'user_id': 0,
                    'portion': {
                        'варкрафт': 5,
                        'экономика': 2
                    }}
        self.db.user_current_portion.insert_one(document)
        # обновляем документ
        new_portion = {'варкрафт': 5, 'мир': 2,  'май': 1}
        self.informant.update_current_portion(user_id=0, current_portion=new_portion)
        # достаем изменненое значение
        select_result = self.informant.get_current_portion_info(user_id=0)
        expected_result = new_portion
        self.assertEqual(select_result, expected_result)


if __name__ == '__main__':
    unittest.main()
