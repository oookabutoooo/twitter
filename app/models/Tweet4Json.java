package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kabuto on 7/7/16.
 */
public class Tweet4Json {
    public int id;
    public String username;
    public String twitter_name;
    public String comment;
    public String postdate;
    public Date postdateLong;

    public Tweet4Json(final Tweet tweet){
        this.id = tweet.id;
        this.username = tweet.user.username;
        this.twitter_name = tweet.user.twitter_name;
        this.comment = tweet.comment;
        this.postdate = tweet.postdate.toString();
        this.postdateLong = tweet.postdate;
    }

    public static List<Tweet4Json> toJsonList(final List<Tweet> tweets){
      final List<Tweet4Json> jsonTweets = new ArrayList<>();
      for(final Tweet tweet: tweets){
          final Tweet4Json jsonTweet = new Tweet4Json(tweet);
          jsonTweets.add(jsonTweet);
      }
        return jsonTweets;
    }
}

