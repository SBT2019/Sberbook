import React from "react";
import Background from "./Background";
import ButtonBar from './ButtonBar.js';
import Card from "./Card.js"

class Profile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
            <div className="container">
                <div className="row justify-content-md-center" >
                    <Background/>
                    <ButtonBar/> 
                    {/* <Card/>                   */}
                </div>
            </div>
        )
    }
}

export default Profile;