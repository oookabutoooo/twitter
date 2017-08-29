/**
 * Created by kabuto on 8/24/16.
 */
import React from "react";

export default class Banner extends React.Component {
    render() {
        if(!this.props.data){
            return null
        }
        return (
            <div>
                <div className="row" id="top-menu">
                    <div className="col-xs-3" id="user_info">{this.props.data.username} @{this.props.data.tw_name}</div>
                    <div className="col-xs-6">Mock Twitter</div>
                    <div className="dropdown col-xs-3">
                        <button className="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="menu">Menu<span className="caret"></span></button>
                        <ul className="dropdown-menu">
                            <li><a href="/findusers">Find User</a></li>
                            <li><a href="/follows">Follows</a></li>
                            <li><a href="/followers">Followers</a></li>
                            <li><a href="/logout">Logout</a></li>
                        </ul>
                    </div>
                </div>
                <br />
            </div>
        );
    }
};