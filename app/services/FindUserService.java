package services;

import models.User;
import models.UserFollows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabuto on 2/21/16.
 */
public class FindUserService {

    public static void addFollow(final String current, final String find) {

        final User finduser = TweetService.getUser(find);
        final User currentuser = TweetService.getUser(current);
        boolean flag=true;
        final UserFollows userfollows = new UserFollows(currentuser, finduser);

            for(UserFollows follow: currentuser.follows){
                if(follow.follower.equals(userfollows.follower) && follow.followed.equals(userfollows.followed)){
                  flag=false;
                    break;
                }
            }

               if(flag){
                   currentuser.follows.add(userfollows);
                   userfollows.save();
               }
    }
}