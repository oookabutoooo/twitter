package services;

import com.avaje.ebean.Model;
import models.User;

import java.util.List;

/**
 * Created by kabuto on 2/11/16.
 */
public class RegistrationService {
    //[Registration]Get List of Users
    public static List<User> getUsers(){
        final Model.Finder<String, User> finder = new Model.Finder<>(User.class);
        final List<User> users = finder.all();

        return users;
    }

    //[Registration] Insert User into Database
    public static Boolean addUser(final String username, final String twitter_name, final String password){
        final Model.Finder<String, User> find = new Model.Finder<>(User.class);
        final User info = find.where().eq("twitter_name", twitter_name).findUnique();

        if (info == null) {
            final User user = new User(username,twitter_name,password);
            user.save();
            return true;
        }

        return false;
    }
}
