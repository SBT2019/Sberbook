import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../static/logoutButton.css';
import IconLogo from "../static/png/icon.png";
import {logout} from "./api/backService.js";

const navItemStyle = {
    fontSize:"14px"
}

const logoutHandler = () => {
    console.log("Logout")
    logout().then(response => console.log(response));
}

const Header = () => {
    return(
        <div>
            <nav className="navbar navbar-expand-sm navbar-light bg-light">
            <img src={IconLogo} width="30" height="30" className="d-inline-block align-top ml-5" alt=""/>
                <a className="navbar-brand" style={{color: "#00aaff", fontSize:"14px"}} href="/">Sberbook</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div className="navbar-nav mr-auto">
                        <a className="nav-item nav-link active" style={navItemStyle} href="/">Главная <span className="sr-only">(current)</span></a>
                        {/* <a className="nav-item nav-link" href="/activityList">Список</a> */}
                    </div>                   
                </div>
                <div>                        
                    <button 
                     className="navbar-text ml-2 logout-button"  
                     onClick={logoutHandler}
                     href="">
                     Выйти
                     </button>             
                </div>
                </nav>
        </div>
    );
};

export default Header;