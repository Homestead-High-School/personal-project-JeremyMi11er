
import java.util.*;

public class AnagramSolver {

    private final List<String> d;
    private final Map<String, LetterInventory> m;
    

    public AnagramSolver(List<String> list){
        d = list;
        this.m = new HashMap<>();
        for(String w : list){
            this.m.put(w, new LetterInventory(w));
        }
    }

    public void print(String s, int max){
        if(max<0){
            throw new IllegalArgumentException();
        }
        LetterInventory x = new LetterInventory(s);
        List<String> words = getWords(x);
        List<String> c = new ArrayList<>();
        print(x, c, words, max);
    }

    private List<String> getWords(LetterInventory j){
        List<String> words = new ArrayList<>();
        for(String word : d){
            if(j.subtract(m.get(word)) != null){
                words.add(word);
            }   
        }
        return words;   
    }

    private void print(LetterInventory s, List<String> a, List<String> b, int max){
        if(s.isEmpty()){
            System.out.println(a);
        }
        else if(max == 0 || a.size()<max){
            for(String word : b){
                LetterInventory n = s.subtract(m.get(word));
                if(n != null){
                    a.add(word);
                    print(n, a, b, max);
                    a.remove(a.size()-1);
                }
            }
        }
    }

}
