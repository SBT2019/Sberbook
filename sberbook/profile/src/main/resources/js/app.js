import 'bootstrap/dist/css/bootstrap.min.css'
import React from "react";
import ReactDOM from "react-dom";
import Profile from "./Profile.js";

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
            <div>
                <Profile/>
            </div>
        )
    }
}

ReactDOM.render(
<App />,
    document.getElementById('react')
);