package net.tilde.punny;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by tilde on 12/20/16.
 */
public class PhraseReaderTest {

  @Test
  public void testPhraseReader() throws IOException {
    PhraseReader phraseReader = new PhraseReader();
    String result = phraseReader.getPhrases();
    System.out.println(result);
    System.out.println(result);

  }
}
