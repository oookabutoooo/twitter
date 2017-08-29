package services;

import com.avaje.ebean.Model;
import models.Tweet;
import models.User;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kabuto on 1/5/16.
 */

public class TweetService {

    //Get Tweets from table
   public static List<Tweet> getTweets(final String tw_name){
       final User user = getUser(tw_name);

       final List<User> follows = FollowsService.getFollows(user);
       follows.add(user);

       final List<Tweet> all_tweets = new ArrayList();

       try {
       for(User follow: follows){
           for(Tweet tweet: follow.user_tweets){
                all_tweets.add(tweet);
           }
       }

           //Sort By TimeStamp
           Collections.sort(all_tweets, new Comparator<Tweet>() {
               public int compare(Tweet text1, Tweet text2) {
                   // compare timestamps from the SMSs
                   return text2.postdate.compareTo(text1.postdate);
               }
           });

           return all_tweets;
       }
       catch(NullPointerException npe){
           return null;
       }

   }



    //Find User Info from twittername
    public static User getUser(final String tw_name){
     final Model.Finder<String, User> finder = new Model.Finder<>(User.class);
     final User user = finder.where().eq("twitter_name",tw_name).findUnique();

        return user;
    }

    public static List<User> getAllUser(final User user){
        final Model.Finder<String, User> finder = new Model.Finder<>(User.class);
        final List<User> users = finder.all();

        users.remove(user);

        return users;
    }

    //Insert Tweet into table
   public static void addTweet(final String tw_name ,final String comment){
       User user = getUser(tw_name);
       Tweet tweet = new Tweet(user,comment);
       user.user_tweets.add(tweet);
       tweet.save();
   }
}
