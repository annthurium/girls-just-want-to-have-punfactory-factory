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
public final class RhymeGetter {
  private static List<String> FILE_SOURCES = Arrays.asList("beatles-songs.txt", "best-selling-books.txt", "movie-quotes.txt", "oscar-winning-movies.txt", "wikipedia-idioms.txt");
  private ArrayList<String> quotes;
  private Set<String> rhymes;
  //private Set<String> rhymesCopy;
  private String wordToReplace;
  private String newWord;

  public RhymeGetter(Set<String> rhymes, String wordToReplace) throws FileNotFoundException
  {
    this.quotes = new ArrayList<String>();
    this.rhymes = rhymes;
    this.wordToReplace = wordToReplace;
  }

  public String punnifyString(String line) {
    String punPhrase = line.replace(this.newWord, this.wordToReplace);
    String punAndOriginalPhrase = String.format("%s (pun of %s)", punPhrase, line);
    return punAndOriginalPhrase;
  }

  public boolean containsRhyme(String line) {
    // If "part" is a rhyme, we should match "part and parcel" but not "crash the party"
    // Split on word boundaries to ensure exact rhyme matching.
    Set<String> parts = new HashSet<String>(Arrays.asList(line.split("\\s+")));
    Set<String> rhymesCopy = new HashSet<>(this.rhymes);
    /*
    Reducing time complexity here by doing set membership comparison
    instead of iterating though the list of rhymes every time.
    Tradeoff: taking more space by making a new set every time.
    */
    rhymesCopy.retainAll(parts);
    if (!rhymesCopy.isEmpty()) {
      // if there are more than 2 rhymes in the phrase, just take the first one
      this.newWord = rhymesCopy.iterator().next();
    }
    return !rhymesCopy.isEmpty();
  }

  public List<String> getRhymingPhrases() throws IOException {
    for (String filename : FILE_SOURCES) {
      List<String> list = new ArrayList<>();
      String FILE_PATH = "/Users/tilde/code/girls-just-want-to-have-punfactory-factory/phrases/" + filename;
      try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
        list = stream

        .filter(line -> this.containsRhyme(line))
            .map(line -> this.punnifyString(line))
        .collect(Collectors.toList());

      } catch (IOException e) {
        e.printStackTrace();
      }
      quotes.addAll(list);
    }
    System.out.println(quotes);
    return quotes;
  }

}
