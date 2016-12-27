package net.tilde.punny;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Takes a word, returns a list of cringeworthy puns phrases based around that word.
 * Example: "heart" -> "heart before the horse (pun of cart before the horse)".
 */
public class PunfactoryMain {
  public static void main(String[] args) throws IOException, JSONException {
    ApiClient client = new ApiClient();
    String originalWord = args[0];
    String result = client.getRhymes(originalWord);

    JSONArray array = new JSONArray(result);
    Set<String> rhymes = new HashSet<String>();
    for (int i = 0; i < array.length(); i++) {
      JSONObject object = array.getJSONObject(i);
      Integer score = Integer.parseInt(String.valueOf(object.get("score")));
      if (score >= 300) {
        rhymes.add(String.valueOf(object.get("word")));
      }

    }
    RhymeGetter rhymeGetter = new RhymeGetter(rhymes, originalWord);
    List rhymingPhrases = rhymeGetter.getRhymingPhrases();
    System.out.println(rhymingPhrases);

  }
}
