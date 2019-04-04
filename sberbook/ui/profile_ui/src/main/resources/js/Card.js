import React from "react";
import '../static/card.css';

class Card extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
            <div className="leftside">
                
                <div className="head">
                    <div className="profilepic">
                        <img src="../static/png/profile-picture.jpg" alt="Profile picture" width="80"></img>
                    </div>

                    <div id="nameheader">
                        <div className="icon"><img src="./img/account-logo.jpg" alt="Account logo" width="15"></img></div>
                        <div className="icon"><h1 id="name">jack</h1></div>
                        <div className="icon"><img src="./img/validated-account.jpg" alt="Validated Account" width="35"></img></div>
                        <div className="userhandle"><h2>@jack</h2></div>
                    </div>
                </div>

                <div className="bottomhalf">
                    <h1 className="userinput">just setting up my twttr</h1>
                    <h2 className="timestamp"><time>9:50 PM - 21 Mar 2006</time></h2>
                    <div readerreactions>
                        <div className="rr"><span className="rrspace1"><img src="./img/reply.jpg" alt="reply" width="20"></img></span></div>
                        <div className="rr"><span className="rrspace2"><img src="./img/retweet.jpg" alt="retweet" width="20"></img></span></div>
                        <div className="rr"><span className="rrspace3"><h2>92,555</h2></span></div>
                        <div className="rr"><span className="rrspace4"><img src="./img/favorite.jpg" alt="favorite" width="20"/></span>
                        <div className="rr"><span className="rrspace5"><h2>71,111</h2></span></div>
                        </div>
                    </div>
                </div>

                <div>
                <button id="followbutton">
                <img src="./img/twitter-logo.jpg" alt="Twitter logo" width="15"></img>
                <b>Follow</b>
                </button>
                </div>
            </div>
        )
    }
}

export default Card;