package controllers;

import models.newUser;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.LoginService;
import views.html.login;

/**
 * Created by kabuto on 2/11/16.
 */
public class Login extends Controller{

    //[Login] Login Page
    public Result login(){
        return ok(login.render(" "));
    }

    //[Login] Login Authentication
    public Result authenticate() {
        Form<newUser> form = Form.form(newUser.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest();
        }
        final newUser newuser = form.get();

        if(!LoginService.authenticate(newuser.twitter_name, newuser.password)){
            final String iuop = "Invalid Username or Password";
            return ok(login.render(iuop));
        }

        session().clear();
        session("tw_name",newuser.twitter_name);

        return redirect(routes.Application.index());
    }
}
