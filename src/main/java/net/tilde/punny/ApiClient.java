package net.tilde.punny;

/**
 * Created by tilde on 12/17/16.
 */
public class ApiClient {
  private static String URL = "http://rhymebrain.com/talk?function=getRhymes&word=";
  private static String RHYME = "heart";

  public ApiClient() {
  }

  public String getRhymes(String rhyme) {
    return "{}";
  }
}
