package net.tilde.punny;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reads phrases from multiple files.
 * TODO make this a proper singleton.
 */
public final class PhraseReader {
  private static List<String> FILE_SOURCES = Arrays.asList("beatles-songs.txt", "best-selling-books.txt", "movie-quotes.txt", "oscar-winning-movies.txt", "wikipedia-idioms.txt");
  private ArrayList<String> quotes;
  private ArrayList<String> rhymes;

  public PhraseReader() throws FileNotFoundException
  {
    this.quotes = new ArrayList<String>();
  }

  public boolean processLine(String line) {
    System.out.println(line);
    return true;
  }

  public List<String> getPhrases(Set<String> rhymes) throws IOException {
    for (String filename : FILE_SOURCES) {
      List<String> list = new ArrayList<>();
      String FILE_PATH = "/Users/tilde/code/girls-just-want-to-have-punfactory-factory/phrases/" + filename;
      try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
        list = stream

        .filter(line -> this.processLine(line))
        .collect(Collectors.toList());

      } catch (IOException e) {
        e.printStackTrace();
      }
      quotes.addAll(list);
      // jesus fucking christ why is it so hard to read a file line by line in java

    }
    return quotes;
  }

}
