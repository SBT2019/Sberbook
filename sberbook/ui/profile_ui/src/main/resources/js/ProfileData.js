import React from "react";
import '../static/profiledata.css';

class ProfileData extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "Name User",
            login: "login",
            email: "Email@sberbook.ru",
            phone: "8(800)555-55-35"
        };
    }
    render() {
        return (
            <div className="profile-container">
                <h5>{this.state.name} 
                    <img src={require("../static/png/validated-account.jpg")} 
                         style={{width: "16px", height: "auto", marginLeft: "5px"}}alt=""/>
                </h5>
                <p>{"@"+this.state.login}</p>
                <p className="email">{this.state.email}</p>
            </div>
        )
    }
}
export default ProfileData;