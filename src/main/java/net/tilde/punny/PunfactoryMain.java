package net.tilde.punny;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tilde on 12/19/16.
 */
public class PunfactoryMain {
  public static void main(String[] args) throws IOException, JSONException {
    ApiClient client = new ApiClient();
    String rhyme = "heart";
    String result = client.getRhymes(rhyme);

    JSONArray array = new JSONArray(result);
    Set<String> rhymes = new HashSet<String>();
    for (int i = 0; i < array.length(); i++) {
      JSONObject object = array.getJSONObject(i);
      Integer score = Integer.parseInt(String.valueOf(object.get("score")));
      if (score >= 300) {
        rhymes.add(String.valueOf(object.get("word")));
      }

    }
    PhraseReader phraseReader = new PhraseReader(rhymes, rhyme);
    List rhymingPhrases = phraseReader.getRhymingPhrases();
    System.out.println(rhymingPhrases);
    System.out.println(rhymes);

  }
}
