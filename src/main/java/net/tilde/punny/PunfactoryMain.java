package net.tilde.punny;

import java.io.IOException;
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

    for (int i = 0; i < array.length(); i++) {
      JSONObject object = array.getJSONObject(i);
      System.out.println(object);
      System.out.println("\n");
    }

  }
}
