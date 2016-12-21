package net.tilde.punny;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tilde on 12/20/16.
 */
public class PhraseReader {
  // make this a list, but just read one file for now.
  private static String fileSource = "/Users/tilde/code/girls-just-want-to-have-punfactory-factory/phrases/movie-quotes.txt";
  private File file;
  private CharSource source;
  //public String result;
  public PhraseReader() throws FileNotFoundException
  {
    this.file = new File(fileSource);
    this.source = Files.asCharSource(file, Charsets.UTF_8);

  }

  public String getPhrases() throws IOException {
    return source.read();
  }
}