package net.tilde.punny;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reads phrases from multiple files.
 * Gets a list of phrases that contain one of the passed-in rhymes.
 */
public final class PhraseReader {
  private static List<String> FILE_SOURCES = Arrays.asList("beatles-songs.txt", "best-selling-books.txt", "movie-quotes.txt", "oscar-winning-movies.txt", "wikipedia-idioms.txt");
  private ArrayList<String> quotes;
  private Set<String> rhymes;

  public PhraseReader(Set<String> rhymes) throws FileNotFoundException
  {
    this.quotes = new ArrayList<String>();
    this.rhymes = rhymes;
  }

  public boolean containsRhyme(String line) {
    // If "part" is a rhyme, we should match "part and parcel" but not "crash the party"
    // Split on word boundaries to ensure exact rhyme matching.
    Set<String> parts = new HashSet<String>(Arrays.asList(line.split("\\s+")));
    Set <String> rhymesCopy = new HashSet<>(this.rhymes);
    // Trading space for some time complexity here by doing set membership comparison
    // instead of iterating though the list of rhymes every time.
    rhymesCopy.retainAll(parts);
    return !rhymesCopy.isEmpty();
  }

  public List<String> getRhymingPhrases() throws IOException {
    for (String filename : FILE_SOURCES) {
      List<String> list = new ArrayList<>();
      String FILE_PATH = "/Users/tilde/code/girls-just-want-to-have-punfactory-factory/phrases/" + filename;
      try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
        list = stream

        .filter(line -> this.containsRhyme(line))
        .collect(Collectors.toList());

      } catch (IOException e) {
        e.printStackTrace();
      }
      quotes.addAll(list);
    }
    return quotes;
  }

}
