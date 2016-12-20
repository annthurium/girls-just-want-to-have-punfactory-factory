package net.tilde.punny;

/**
 * Created by tilde on 12/19/16.
 */

// {"word":"who","freq":29,"score":300,"flags":"bc","syllables":"1"},
public class RhymeResponse {
  String word;
  Integer frequency;
  Integer score;
  String flags;
  Integer syllables;


  public RhymeResponse(String word, Integer frequency, Integer score, String flags, Integer syllables) {
    this.word = word;
    this.frequency = frequency;
    this.score = score;
    this.flags = flags;
    this.syllables = syllables;
  }

}
