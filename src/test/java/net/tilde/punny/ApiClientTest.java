package net.tilde.punny;

import org.junit.Test;

/**
 * Created by tilde on 12/17/16.
 */
public class ApiClientTest {

  @Test
 public void testGetRhymes() {
    ApiClient client = new ApiClient();
    String result = client.getRhymes("foo");

    if (result.length() < 1)
      throw new java.lang.RuntimeException();

  }
}
