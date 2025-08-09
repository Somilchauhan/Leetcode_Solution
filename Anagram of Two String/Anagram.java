import java.util.HashMap;

public class Anagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> sCh = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            Character curr = s.charAt(i);
            if(sCh.containsKey(curr)){
                sCh.put(curr, sCh.get(curr)+1);
            } else{
                sCh.put(curr, 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            Character curr = t.charAt(i);
            if(!sCh.containsKey(curr)){
                return false;
            }else{
                sCh.put(curr, sCh.get(curr)-1);
                if(sCh.get(curr) == -1) return false;
            }
        }
        if(!sCh.containsValue(0)) return false;
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Anagram().isAnagram("anagram", "nagaram");
        System.out.println(result); // Output: true
    }
}
