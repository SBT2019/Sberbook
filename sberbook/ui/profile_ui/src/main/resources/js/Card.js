import React from "react";
import '../static/card.css';

class Card extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
         <div className="main-box">

            <div id="profile-pic">
               <img src={require("../static/png/user.png")} alt=""/>
            </div>

            <div id="profile-data">
               <strong>{this.props.data.name}</strong> 
               <img src={require("../static/png/validated-account.jpg")} alt=""/>
               <div id="id"> {this.props.data.login} </div>
            </div>

            <button id="follow-button">
               <img src={require('../static/png/twitter-logo.jpg')} alt=""/> 
                  Follow 
            </button>

            <div id="text">{this.props.data.tweet}</div>

            <div id="time"> <time>{this.props.data.date}</time></div>

            <div id="footer">
               <a id= "retweet" href="/#"> 
                  <img src={require("../static/png/reply.jpg")} alt=""/> 
                  </a>
               <a id="retweeted" href="/#"> 
                  <img src={require("../static/png/retweet.jpg")} alt=""/>
                  {this.props.data.retweets} 
               </a>
               <a id ="likes" href="/#">
                  <img src={require("../static/png/favorite.jpg")} alt=""/>
                  {this.props.data.likes}
               </a>
            </div>

         </div>
        )
    }
}

export default Card;