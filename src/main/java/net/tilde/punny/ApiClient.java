package net.tilde.punny;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by tilde on 12/17/16.
 */
public class ApiClient {
  private static String URL = "http://rhymebrain.com/talk?function=getRhymes&word=";
  private static String RHYME = "heart";
  private static OkHttpClient client;

  public ApiClient() {
    this.client = new OkHttpClient();

  }

  public String getRhymes(String rhyme) throws IOException {
    Request request = new Request.Builder()
        .url(this.URL + this.RHYME)
        .build();

    Response response = client.newCall(request).execute();
    return response.body().string();
  }
}
