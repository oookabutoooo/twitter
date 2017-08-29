package models;

import java.util.List;

/**
 * Created by kabuto on 7/8/16.
 */
public class UserDataJson {
    public String username;
    public String tw_name;
    public List<Tweet4Json> tweets;

    public UserDataJson(final String username, final String tw_name, final List tweets) {
        this.username = username;
        this.tw_name = tw_name;
        this.tweets = tweets;
    }


}
