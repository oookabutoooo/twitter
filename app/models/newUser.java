package models;

/**
 * Created by kabuto on 1/5/16.
 */
public class newUser {

    public String username;
    public String twitter_name;
    public String password;

    public Boolean validLength(){
        final int unl = this.username.length();
        final int tnl = this.twitter_name.length();
        final int pwl = this.password.length();

        final int len=0;

        if(unl<=len || tnl <=len || pwl<=len){
            return false;
        }
        return true;
    }
}
