/**
 * Created by kabuto on 8/24/16.
 */
import React from "react";

export default class TweetList extends React.Component {
    render() {
        if(this.props.data) {
            var tweets = this.props.data.tweets.map(function (tweet) {
                return (
                    <tr key={tweet.id}>
                        <td key={tweet.id}>
                            <Tweet key={tweet.id} username={tweet.username} tw_name={tweet.twitter_name}
                                   postdate={tweet.postdate}>
                                {tweet.comment}
                            </Tweet>
                        </td>
                    </tr>
                );
            });
        }
        return (
            <table className="tweetList table">
                <tbody>
                {tweets}
                </tbody>
            </table>
        );
    }
};