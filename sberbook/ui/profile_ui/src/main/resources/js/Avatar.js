import React from "react";
import '../static/avatar.css';
import UserAvatar from '../static/png/user.png';
import ProfileData from './ProfileData.js';

class Avatar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
            <div className="avatar-container">
                <img src={UserAvatar} alt="Avatar" className="avatar"/>
                <ProfileData/>
            </div>
        )
    }
}
export default Avatar;