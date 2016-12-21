package net.tilde.punny;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads phrases from multiple files.
 * TODO make this a proper singleton.
 */
public class PhraseReader {
  private static List<String> FILE_SOURCES = Arrays.asList("beatles-songs.txt", "best-selling-books.txt", "movie-quotes.txt", "oscar-winning-movies.txt", "wikipedia-idioms.txt");

  private ArrayList<String> quotes;

  public PhraseReader() throws FileNotFoundException
  {
    this.quotes = new ArrayList<String>();
  }

  public List<String> getPhrases() throws IOException {
    for (String filename : FILE_SOURCES) {
      String FILE_PATH = "/Users/tilde/code/girls-just-want-to-have-punfactory-factory/phrases/";
      File file = new File(FILE_PATH + filename);
      CharSource source = Files.asCharSource(file, Charsets.UTF_8);
      List<String> lines = Files.readLines(file, Charsets.UTF_8);
      quotes.addAll(lines);

    }
    System.out.println(quotes.get(0));
    return quotes;
  }
}
