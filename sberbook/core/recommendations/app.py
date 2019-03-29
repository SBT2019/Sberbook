from flask import Flask
from sberbook.recommendations.friends_recommendation import FriendsRecommender
from sberbook.recommendations.tweet_recommendation import TweetRecommender

app = Flask(__name__)
friends_recommender = FriendsRecommender
tweet_recommender = TweetRecommender

@app.route('/GetFriendsRecommendations')
def get_friends_recommendations():
    return "friends recommendations here"

@app.route('/GetTweetRecommendations')
def get_tweet_recommendations():
    return "tweets recommendations here"

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9600, debug=True)
