package net.tilde.punny;

import org.junit.Test;

import java.io.IOException;

/**
 * Note: if rhyme brain changes their api, or goes down, this test will fail.
 * It would be better to create an interface so we can easily mock the api response in tests.
 */
public class ApiClientTest {

  @Test
 public void testGetRhymes() throws IOException {
    ApiClient client = new ApiClient();
    String result = client.getRhymes("foo");

    if (result.length() < 1)
      throw new java.lang.RuntimeException();
  }
}
