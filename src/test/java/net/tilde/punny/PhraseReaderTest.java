package net.tilde.punny;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;

/**
 * Created by tilde on 12/20/16.
 */
public class PhraseReaderTest {

  @Test
  public void testPhraseReader() throws IOException {
    PhraseReader phraseReader = new PhraseReader();
    List result = phraseReader.getPhrases();

    assertThat(result.get(0)).isEqualTo("\"Frankly, my dear, I don't give a damn.\"");

  }
}
