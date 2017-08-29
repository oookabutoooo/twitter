package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by kabuto on 2/21/16.
 */
    @Entity
public class UserFollows extends Model{

    @Id
    public int relation_id;

    @ManyToOne
   public User follower;

    @ManyToOne
    public User followed;

    public UserFollows(final User a, final User b){
        this.follower=a;
        this.followed=b;
    }
}
