package net.tilde.punny;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tilde on 12/20/16.
 */
public class PhraseReaderTest {

  @Test
  public void testPhraseReader() throws IOException {
    PhraseReader phraseReader = new PhraseReader();
    Set<String> set = new HashSet<String>();
    set.add("foo");
    List result = phraseReader.getPhrases(set);

    assertThat(result.size()).isEqualTo(6813);

  }
}
