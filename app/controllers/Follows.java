package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.FollowsService;
import services.TweetService;
import views.html.follows;
import models.User;

import java.util.List;

/**
 * Created by kabuto on 2/21/16.
 */
@Security.Authenticated(Secured.class)
public class Follows extends Controller{

    public Result follows(){
        try {
            final String tw_name = session("tw_name");
            final User user = TweetService.getUser(tw_name);

            final List<User> users = FollowsService.getFollows(user);

            if (users == null || user == null) {
                return redirect(routes.Logout.logout());
            }

            return ok(follows.render(users, user));
        }
        catch(NullPointerException npe){
            return redirect(routes.Logout.logout());
        }
    }
}
