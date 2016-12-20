package net.tilde.punny;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * Created by tilde on 12/19/16.
 */
public class PunfactoryMain {
  public static void main(String[] args) throws IOException, JSONException {
    ApiClient client = new ApiClient();
    String result = client.getRhymes("foo");

    JSONArray array = new JSONArray(result);
    List<RhymeResponse> rhymeResponseList = new ArrayList<RhymeResponse>();
    for (int i = 0; i < array.length(); i++) {
      JSONObject object = array.getJSONObject(i);
      Integer score = Integer.parseInt(String.valueOf(object.get("score")));
      if (score >= 300) {
        String word = String.valueOf(object.get("word"));
        // jfc.  really?  Shouldn't there be a better way to do this?
        Integer frequency = Integer.parseInt(String.valueOf(object.get("freq")));
        String flags = String.valueOf(object.get("flags"));
        Integer syllables = Integer.parseInt(String.valueOf(object.get("syllables")));
        RhymeResponse rhymeResponse = new RhymeResponse(word, frequency, score, flags, syllables);
        rhymeResponseList.add(rhymeResponse);
      }
    }


  }
}
