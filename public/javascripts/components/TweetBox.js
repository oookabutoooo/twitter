/**
 * Created by kabuto on 8/24/16.
 */
import React from "react";
import Banner from "./Banner";
import Tweet from "./Tweet";
import TweetForm from "./TweetForm";
import TweetList from "./TweetList";

export default class TweetBox extends React.Component {

    getInitialState() {
        return {data: {username:'', tw_name:'', tweets:[]}};
    }

    loadCommentsFromServer() {
        $.ajax({
            url: this.props.url,
            dataType: 'json',
            cache: false,
            success: function(data) {
                console.log("autoload")
                console.log(data)
                this.setState({data: data});
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    postCommentToServer(tweet) {
        console.log(tweet)
        if(!tweet){
            return null
        }
        $.ajax({
            url: '/2',
            type: 'POST',
            //cache: false,
            dataType: 'JSON',
            contentType:"application/JSON",
            data: JSON.stringify(tweet),
            success: function(data) {
                this.setState({data: data});
            }.bind(this),
            error: function(xhr, status, err) {
                console.log('aaaa');
            }.bind(this)
        });
    }

    componentDidMount() {
        this.loadCommentsFromServer();
        setInterval(this.loadCommentsFromServer, this.props.pollInterval);
    }

    render() {
        return(
            <div className="tweetBox container">
                <Banner data={this.state.data} />
                <TweetForm onCommentSubmit={this.postCommentToServer} />
                <br />
                <TweetList data={this.state.data} />
            </div>
        );
    }
};