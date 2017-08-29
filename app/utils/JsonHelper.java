package utils;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.JsonComment;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kabuto on 7/14/16.
 */
public class JsonHelper {
    private static final HttpClient client = HttpClients.createDefault();

    public static String getHTMLContent(final String url) throws IOException{
            final HttpGet get = new HttpGet(url);
            final HttpResponse response = client.execute(get);
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                final StringBuilder builder = new StringBuilder();
                String str;
                while((str = bufferedReader.readLine()) != null) {
                    builder.append(str);
                }
                return builder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            return null;
        }

    public static String getJsonFromURL(final String url){
        try {
            final String content = getHTMLContent(url);
            return content;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonComment jsonToObject(final String url){
        final String content = getJsonFromURL(url);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            final JsonComment jsonComment = objectMapper.readValue(content, JsonComment.class);
            return jsonComment;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
