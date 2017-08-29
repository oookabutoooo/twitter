package services;

import models.User;
import models.UserFollows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabuto on 2/22/16.
 */
public class FollowersService {

    public static List<User> getFollowers(final User user){

        List<User> follower = new ArrayList();
        try {
            for(UserFollows tmp : user.followers) {
                follower.add(tmp.follower);
                //System.out.println("tmp"+tmp.followed.user_id);
            }
            return follower;
        }
        catch(NullPointerException npe){
            return null;
        }

    }
}
