package net.tilde.punny;

import java.io.IOException;

/**
 * Created by tilde on 12/19/16.
 */
public class PunfactoryMain {
  public static void main(String[] args) throws IOException {
    ApiClient client = new ApiClient();
    String result = client.getRhymes("foo");
    System.out.println(result);

    

  }
}
