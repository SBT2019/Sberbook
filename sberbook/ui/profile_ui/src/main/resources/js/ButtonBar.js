import React from "react";
import Avatar from "./Avatar.js"
import '../static/toolbar.css';

class ButtonBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tweets: 14,
            subscriptions: 141,
            subscribers: 182,
            likes: 354
        };
    }

    tweetHandler = () => {
        console.log("Click tweet")
        this.setState({
            tweets: this.state.tweets + 1
        });
    }

    subscriptionsHandler = () => {
        console.log("Click subscriptions")
        this.setState({
            subscriptions: this.state.subscriptions + 1
        });
    }

    subscribersHandler = () => {
        console.log("Click subscribers")
        this.setState({
            subscribers: this.state.subscribers + 1
        });
    }

    likeHandler = () => {
        console.log("Click my likes")
        this.setState({
            likes: this.state.likes + 1
        });
    }

    render() {
        const {tweets, subscriptions, subscribers, likes} = this.state;
        return (
            <div className="toolbar">
                <Avatar/>
                <div className="toolbar-container">
                    <button className="button toolbar-button1" onClick={this.tweetHandler}>
                        <h5>Твиты</h5>
                        <p>{tweets}</p>
                    </button>
                    <button className="button toolbar-button2" onClick={this.subscriptionsHandler}>
                        <h5>Читаемые</h5>
                        <p>{subscriptions}</p>
                    </button>
                    <button className="button toolbar-button3" onClick={this.subscribersHandler}>
                        <h5>Читатели</h5>
                        <p>{subscribers}</p>
                    </button>
                    <button className="button toolbar-button4" onClick={this.likeHandler}>
                        <h5>Нравится</h5>
                        <p>{likes}</p>
                    </button>
                </div>
            </div>
        )
    }
}
export default ButtonBar;