from flask import Flask,jsonify, request

app = Flask(__name__)


@app.route('/getRecommendations')
def hello_world():
    id = request.args.get('id')
    try:
        return jsonify({"answer":int(id)})
    except (ValueError,TypeError):
        return jsonify({"answer":"please type integer id"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9600, debug=True)
