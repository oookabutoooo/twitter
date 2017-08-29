package services;

import com.avaje.ebean.Model;
import models.User;

import java.util.List;

/**
 * Created by kabuto on 1/5/16.
 */
public class LoginService {

    //[Login] Login Authentication
    public static Boolean authenticate(final String twitter_name, final String password) {
        final Model.Finder<String, User> find = new Model.Finder<>(User.class);
        final User find_user = find.where().eq("twitter_name", twitter_name).eq("password", password).findUnique();

        if(find_user == null){
            return false;
        }

        //System.out.printf("%s %s %s",find_user.username,find_user.twitter_name,find_user.password);

        return true;
    }
}
