package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kabuto on 12/15/15.
 */

@Entity
public class Tweet extends Model{

    @Id
    public int id;
    public String comment;

    @ManyToOne
    public User user;

    @CreatedTimestamp
    public Date postdate;

    public Tweet(User user, final String comment){
        this.user=user;
        this.comment=comment;
    }

}
