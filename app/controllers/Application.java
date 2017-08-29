package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import play.mvc.Security;
import services.TweetService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utils.JsonHelper;
import views.html.index;
import views.html.index2;

@Security.Authenticated(Secured.class)
public class Application extends Controller {

    //[Index] Twitter Page
    public Result index() {
        final String tw_name = session("tw_name");
        final List<Tweet> tweets = TweetService.getTweets(tw_name);

        if(tweets==null){
            return redirect(routes.Logout.logout());
        }

        final User user = TweetService.getUser(tw_name);
        return ok(index.render(tweets, user));
    }

    public Result index2() {
        final String tw_name = session("tw_name");
        final User user = TweetService.getUser(tw_name);
        return ok(index2.render(user));
    }

    public Result json() {
        final String tw_name = session("tw_name");
        final User user = TweetService.getUser(tw_name);

        final List<Tweet> tweets = TweetService.getTweets(tw_name);
        final List<Tweet4Json> jsonTweets = Tweet4Json.toJsonList(tweets);
        final UserDataJson userDataJson = new UserDataJson(user.username, user.twitter_name, jsonTweets);

        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String json = objectMapper.writeValueAsString(userDataJson);
            return ok(json);
        }
        catch(Exception e){
            e.printStackTrace();
            return badRequest("Could not parse object to json");
        }
    }

    //[Index] add Tweet
    public Result addTweet(){
        final Form<newTweet> form = Form.form(newTweet.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest();
        }
        final newTweet newtweet = form.get();

        final String tw_name = session("tw_name");

        TweetService.addTweet(tw_name, newtweet.comment);

        return redirect(routes.Application.index());
    }

    public Result addTweet2(){
        final String tw_name = session("tw_name");
        final JsonNode requestJson = request().body().asJson();
        //System.out.println(request().body());
        System.out.println("buc "+requestJson);
        if (requestJson == null) {
            System.out.println("YOLO");
            return badRequest();
        }
        TweetService.addTweet(tw_name, requestJson.get("tweet").asText());
        final List<Tweet4Json> tweets = new ArrayList<>(Tweet4Json.toJsonList(TweetService.getTweets(tw_name)));

        return ok(Json.toJson(tweets));
    }

}
