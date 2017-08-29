package controllers;

import models.User;
import models.newUser;
import play.mvc.Controller;
import play.data.Form;
import play.mvc.Result;

import services.RegistrationService;
import views.html.registration;

import java.util.List;

/**
 * Created by kabuto on 2/11/16.
 */
public class Registration extends Controller{

    //[Registration] Registration Page
    public Result registration(){
        final List<User> users = RegistrationService.getUsers(); //debug
        return ok(registration.render(" ",users));
    }

    //[Registration] add User
    public Result addUser(){
        final List<User> users = RegistrationService.getUsers(); //debug

        final Form<newUser> form = Form.form(newUser.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest();
        }
        final newUser newuser = form.get();

        //Check Length of Names & Password
        if(!newuser.validLength()){
            final String vl = "Must be Over 0 characters";
            return ok(registration.render(vl,users));
        }

        //Check Availability and addUser
        if(!RegistrationService.addUser(newuser.username, newuser.twitter_name,newuser.password)){
            final String at = "Already Taken";
            return ok(registration.render(at,users));
        }

        return redirect(routes.Login.login());
    }

}
