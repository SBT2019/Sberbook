# Recommeder - тот кто на основании информации о пользователе формирует список твитов, которые будут отправлены
#  польщователю
import random
import numpy as np

class PortionCalculator:
    def __init__(self):
        self.__initial_portion_size_from_sub = 5

    def get_mean_likes(self, portion_of_likes) -> dict:
        """считаем среднее количество лайков за N предыдущих отправленных порций твитов,
        то в среднем за 1 эпоху сколько лайков поставил юзер твитам от одной из своих подписок"""
        user_likes_amount = dict()
        user_subs_freq = dict()
        user_likes_history = portion_of_likes
        for portion in user_likes_history:
            for key in portion.keys():
                # подсчет частот встречаемости подписки в порции
                if key in user_subs_freq:
                    user_subs_freq[key] += 1
                else:
                    user_subs_freq[key] = 1
                # подсчет лайков у твитов подписок в порции
                if key in user_likes_amount:
                    user_likes_amount[key] += portion[key]
                else:
                    user_likes_amount[key] = portion[key]
        # теперь для двух словарей считаем среднее
        mean_likes_dict = dict()
        for key in user_subs_freq.keys():
            mean_likes_dict[key] = np.round(user_likes_amount[key] / user_subs_freq[key])

        return mean_likes_dict

    def calculate_tweet_portion_per_sub(self, mean_likes_on_prev_n_epochs: dict,
                                        previous_tweet_number: dict) -> dict:
        """считаем условную вероятность того что юзер лайкнет твит от своей подписки и полную вероятность"""
        conditional_probability_dict = dict()
        full_probability = 0
        for key in mean_likes_on_prev_n_epochs.keys():
            if key in previous_tweet_number:
                conditional_probability_dict[key] = mean_likes_on_prev_n_epochs[key] / previous_tweet_number[key]
            else:
                conditional_probability_dict[key] = mean_likes_on_prev_n_epochs[
                                                        key] / self.__initial_portion_size_from_sub

            full_probability += conditional_probability_dict[key]

        # считаем на оснвоании этого апострериорную вероятность
        for key in conditional_probability_dict:
            conditional_probability_dict[key] = conditional_probability_dict[key] / full_probability

        # считаем общее количество твитов в одной порции
        new_portion_tweet_distr = dict()
        tweet_sum = 0
        for key in conditional_probability_dict:
            if key in previous_tweet_number:
                tweet_sum += previous_tweet_number[key]
            else:
                tweet_sum += self.__initial_portion_size_from_sub

        for key in conditional_probability_dict:
            new_portion_tweet_distr[key] = np.round(conditional_probability_dict[key] * tweet_sum)

        return new_portion_tweet_distr

    def form_output_tweets(self, subscribers_tweets, user_hist_tweets_from_sub, tweets_portion_size) -> list:
        """возьмем твиты которые уже были отправлены пользователю, возьмем твиты от подписчика,
        возьмем N твитов(соответсвенно с порцией), которые не пересекаются"""
        subscribers_tweets = set(subscribers_tweets)
        user_hist_tweets = set(user_hist_tweets_from_sub)
        suitable_tweets = random.sample(tuple(subscribers_tweets - user_hist_tweets), k=tweets_portion_size)
        return suitable_tweets


if __name__ == '__main__':
    rec = PortionCalculator()
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
    previous_portion = {
        'спорт': 4,
        'мир': 2,
        'вася': 4
    }
    tweets = [23, 4, 2, 11, 45, 76, 34, 62, 34]
    user_hist = [4, 2, 76]
    print(rec.form_output_tweets(tweets, user_hist, 5))
    # mean_likes = rec.get_mean_likes(case)
    # print(mean_likes)
    # new_portion = rec.calculate_tweet_portion_per_sub(mean_likes_on_prev_n_epochs=mean_likes,
    #                                                   previous_tweet_number=previous_portion)
    # print(new_portion)
