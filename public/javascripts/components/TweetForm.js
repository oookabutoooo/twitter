/**
 * Created by kabuto on 8/24/16.
 */
import React from "react";

export default class TweetForm extends React.Component {
    getInitialState() {
        return {tweet: ''};
    }

    handleTextChange(e) {
        this.setState({tweet: e.target.value});
    }

    handleSubmit(e) {
        e.preventDefault();
        var tweet = this.state.tweet.trim();
        if(!tweet) {
            return;
        }
        this.props.onCommentSubmit({tweet: tweet});
        this.setState({tweet: ''});
    }

    render() {
        return(
            <form className="tweetForm" onSubmit={this.handleSubmit}>
                <div className="row">
                    <div className="col-xs-9">
                        <textarea
                            className="form-control"
                            value={this.state.tweet}
                            onChange={this.handleTextChange}
                            name="comment"
                        />
                    </div>
                    <div className="col-xs-1">
                        <button type="submit" className="btn btn-md btn-primary" id="tweet-button">Tweet</button>
                    </div>
                </div>
            </form>
        );
    }
};