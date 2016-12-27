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
public class RhymeGetterTest {

  @Test
  public void testPhraseReader() throws IOException {
    String[] heartRhymes = {"art", "mart", "part", "start", "cart", "smart", "dart", "rampart",
                            "impart", "counterpart", "tart", "depart", "chart", "apart"};
    String rhyme = "heart";
    Set<String> set = new HashSet<String>(Arrays.asList(heartRhymes));
    RhymeGetter rhymeGetter = new RhymeGetter(set, rhyme);
    List rhymingPhrases = rhymeGetter.getRhymingPhrases();
    assertThat(rhymingPhrases.size()).isEqualTo(32);

  }
}