package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by kabuto on 2/11/16.
 */
public class Logout extends Controller {
    //[Logout] Logout Redirect to Login
    public Result logout() {
        session().clear();

        return redirect(routes.Login.login());
    }
}
