package net.tilde.punny;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


/**
 * Makes a call to RhymeBrain api, returns some json.
 * Example result:
 * [ {"word":"art","freq":25,"score":300,"flags":"bc","syllables":"1"} ]
 */
public class ApiClient {
  private static String URL = "http://rhymebrain.com/talk?function=getRhymes&word=";
  private static OkHttpClient client;

  public ApiClient() {
    this.client = new OkHttpClient();

  }

  public String getRhymes(String rhyme) throws IOException {
    Request request = new Request.Builder()
        .url(this.URL + rhyme)
        .build();

    Response response = client.newCall(request).execute();
    return response.body().string();
  }
}
