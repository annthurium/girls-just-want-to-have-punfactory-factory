package net.tilde.punny;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tilde on 12/20/16.
 */
public class PhraseReaderTest {

  @Test
  public void testPhraseReader() throws IOException {
    String[] heartRhymes = {"art", "mart", "part", "start", "cart", "smart", "dart", "rampart",
                            "impart", "counterpart", "tart", "depart", "chart", "apart"};
    Set<String> set = new HashSet<String>(Arrays.asList(heartRhymes));
    PhraseReader phraseReader = new PhraseReader(set);
    List rhymingPhrases = phraseReader.getRhymingPhrases();
    assertThat(rhymingPhrases.size()).isEqualTo(32);

  }
}
