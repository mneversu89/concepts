package manish;

import java.util.HashMap;

/**
 * Created by manish on 2/14/17.
 */
public class LongestSubStringWithOutRepeativeCharacters {

    public int longestSubStringWithoutRepeatingCharacters(String s) {
        if(s==null || s.length() == 0) return 0;
        HashMap<Character,Integer> storeChar = new HashMap<>();
        int max = 0;
        for(int currentStringIndex=0,lastNonRepetativeCharacterPosition=0;currentStringIndex<s.length();currentStringIndex++) {
            if(storeChar.containsKey(s.charAt(currentStringIndex))) {
                //J position is significance is can be know using the example string as abcba. J is the position of the string from where the current character repeation is started
                lastNonRepetativeCharacterPosition = Math.max(lastNonRepetativeCharacterPosition, storeChar.get(s.charAt(currentStringIndex)) + 1);
            }
            int currentSubStringLength = currentStringIndex - lastNonRepetativeCharacterPosition + 1;
            storeChar.put(s.charAt(currentStringIndex), currentStringIndex);
            // we are doing i-j+1 because i will be pointing currently string character j is pointing to the postion till where there is no repetative characters and
            // since we are starting our index from 0 we do +1 to the difference
            max = Math.max(max,currentSubStringLength);
        }
        return max;
    }

    public static void main(String args[]) {
        LongestSubStringWithOutRepeativeCharacters l = new LongestSubStringWithOutRepeativeCharacters();
        System.out.println(l.longestSubStringWithoutRepeatingCharacters("abcba"));
    }

}
