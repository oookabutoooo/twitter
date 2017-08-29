package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

import java.util.List;

/**
 * Created by kabuto on 1/5/16.
 */
@Entity
public class User extends Model{

    @Id
    public int user_id;
    public String username;
    public String twitter_name;
    public String password;

    @OneToMany(mappedBy = "follower", cascade=CascadeType.ALL)
    public List<UserFollows> follows;

    @OneToMany(mappedBy = "followed", cascade=CascadeType.ALL)
    public List<UserFollows> followers;

   @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    public List<Tweet> user_tweets;

    public User(final String username, final String twitter_name, final String password){
        this.username=username;
        this.twitter_name=twitter_name;
        this.password=password;
    }
}
