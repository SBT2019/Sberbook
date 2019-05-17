from flask import Flask, request
from RecommendationService.tweet_recommendation.TweetRecommender import TweetRecommender

app = Flask(__name__)
tweet_recommender = TweetRecommender('localhost:27017')


@app.route('/GetTweetRecommendations')
def get_tweet_recommendations():
    try:
        user_id = int(request.args.get('user_id', ''))
        tweet_recommender.run(user_id, 'localhost:27017')
    except Exception as e:
        print(e)
        return 'No argument was given, try again'



if __name__ == '__main__':
    app.run(host='127.0.0.1', port=9600, debug=True)
