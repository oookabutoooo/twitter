/**
 * Created by kabuto on 8/24/16.
 */
import React from "react";

export default class Tweet extends React.Component {
    render() {
        return(
            <div className="tweet">
                {this.props.username} <span className="tw_name">@{this.props.tw_name}</span>
                <br />
                {this.props.children}
                <br />
                <span className="tw_name">{this.props.postdate}</span>
            </div>
        );
    }
};