package controllers;

import models.User;
import models.newUser;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.FindUserService;
import services.FollowsService;
import services.TweetService;
import views.html.finduser;

import java.util.List;

/**
 * Created by kabuto on 2/21/16.
 */
@Security.Authenticated(Secured.class)
public class FindUser extends Controller{


    public Result findUser(){
        try{
        final String tw_name = session("tw_name");
        final User user = TweetService.getUser(tw_name);

        final List<User> users = TweetService.getAllUser(user);
        final List<User> followed = FollowsService.getFollows(user);
        if(users==null || user==null){
            return redirect(routes.Logout.logout());
        }
        return ok(finduser.render(users,user,followed));
        }
        catch(NullPointerException npe){
            return redirect(routes.Logout.logout());
        }
    }

    public Result addFollow(){

        final String tw_name = session("tw_name");

        final Form<newUser> form = Form.form(newUser.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest();
        }

        final newUser newuser = form.get();
        FindUserService.addFollow(tw_name,newuser.twitter_name);

        return redirect(routes.FindUser.findUser());
    }

}
