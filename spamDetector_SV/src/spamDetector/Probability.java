package spamDetector;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by venujan on 10/03/16.
 */
public class Probability {

    //creating the maps for the spam and ham
    private Map<String, Double> hamWord;
    private Map<String, Double> spamWord;

    //creating probability maps

    public Map<String, Double> spamProbability(Map<String, Double> hamWord, Map<String, Double> spamWord){

        Map<String, Double> spam = new TreeMap<>();
        Set<String> keys=spamWord.keySet();
        Iterator<String> keyIterator=keys.iterator();
        String word;
        while (keyIterator.hasNext()){
            word=keyIterator.next();
            if(!hamWord.containsKey(word)){
                spam.put(word,spamWord.get(word)/spamWord.get(word));
            } else{
                spam.put(word,spamWord.get(word)/(spamWord.get(word)+ hamWord.get(word)));
            }

        }
        return spam;
    }
}
