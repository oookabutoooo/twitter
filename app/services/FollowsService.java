package services;

import models.User;
import models.UserFollows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabuto on 2/21/16.
 */
public class FollowsService {


    public static List<User> getFollows(final User user){

        List<User> followed = new ArrayList();
        try {
            for(UserFollows tmp : user.follows) {
                followed.add(tmp.followed);
                //System.out.println("tmp"+tmp.followed.user_id);
            }
        return followed;
        }
        catch(NullPointerException npe){
            return null;
        }

    }
}
