import unittest
from RecommendationService.tweet_recommendation.PortionCalculator import PortionCalculator


class MyTestCase(unittest.TestCase):
    calculator = PortionCalculator()
    """тест нахождения среднего для 3 отправленных эпох порций"""

    def assertDicts(self, user_likes, expected_output):
        my_answer = self.calculator.get_mean_likes(user_likes)
        self.assertEqual(my_answer, expected_output)

    def test_1(self):
        case = [
            {
                'спорт': 4,
                'мир': 3,
                'вася': 2
            },
            {
                'спорт': 2,
                'вася': 1
            },
            {
                'спорт': 3,
                'владимир': 1,
                'мир': 2
            }
        ]
        right_output = {'вася': 2.0, 'владимир': 1.0, 'мир': 2.0, 'спорт': 3.0}
        self.assertDicts(case, right_output)


if __name__ == '__main__':
    unittest.main()
