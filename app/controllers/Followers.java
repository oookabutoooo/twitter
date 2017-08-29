package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import models.User;

import java.util.List;

import play.mvc.Security;
import services.FollowersService;
import services.TweetService;
import views.html.followers;

/**
 * Created by kabuto on 2/21/16.
 */
@Security.Authenticated(Secured.class)
public class Followers extends Controller {

    public Result followers() {
        try {
            final String tw_name = session("tw_name");
            final User user = TweetService.getUser(tw_name);
            final List<User> users = FollowersService.getFollowers(user);

            if (users == null || user == null) {
                return redirect(routes.Logout.logout());
            }

            return ok(followers.render(users, user));
        }
        catch(NullPointerException npe){
            return redirect(routes.Logout.logout());
        }
    }
}
