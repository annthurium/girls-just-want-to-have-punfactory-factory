package net.tilde.punny;
import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/**
 * Created by tilde on 12/19/16.
 */
public class RhymeResponseTest {

  @Test
  public void testRhymeResponse() {
    RhymeResponse rhymeResponse = new RhymeResponse("who", 29, 300, "bc", 1);
    assertThat(rhymeResponse.word).isEqualTo("who");
    assertThat(rhymeResponse.frequency).isEqualTo(29);
    assertThat(rhymeResponse.score).isEqualTo(300);
    assertThat(rhymeResponse.flags).isEqualTo("bc");
    assertThat(rhymeResponse.syllables).isEqualTo(1);
  }
}
