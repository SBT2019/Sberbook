import React from "react";
import '../static/my-card.css';

class Profile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
            <div className="container">
                <div className="row justify-content-md-center" >
                    <div style={upback}>
                        {/*<p>Variable width content</p>*/}
                    </div>
                </div>
            </div>
        )
    }
}

const upback = {
    backgroundColor: "#99DDFF",
    height: "320px",
    boxShadow: "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
    width: "100%"
};

const photo = {
    backgroundColor: "#99DDFF",
    height: "320px",
    width: "100%"
};
export default Profile;