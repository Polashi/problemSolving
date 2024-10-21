import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueTupples {
    public static void main(String[] args) {
        String str = "abbccde";
        int len = 2;
        List<String> ans = new ArrayList<>(uniqueTuples(str,len));
        for(String a: ans){
            System.out.println(a);
        }
    }

    public static HashSet<String> uniqueTuples(String input, int len) {
        HashSet<String> tuples = new HashSet<>();
        for (int i = 0; i <= input.length() - len; i++) {
            String tuple = input.substring(i, i + len);
            tuples.add(tuple);
        }
        return tuples;
    }
}
