
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab1 {

    static Map<Character, List<Character>> neighbours = initializeMap();

    private static Map<Character, List<Character>> initializeMap() {

        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();

        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for (String row : rows) {
            for (int i = 0; i < row.length(); i++) {
                List<Character> list = new ArrayList<>();
                if (i == 0) {
                    list.add(row.charAt(1));
                } else if (i == row.length() - 1) {
                    list.add(row.charAt(row.length() - 2));
                } else {
                    list.add(row.charAt(i - 1));
                    list.add(row.charAt(i + 1));
                }

                map.put(row.charAt(i), list);
            }
        }

        return map;
    }

    static List<String> Deletion(String string) {
        List<String> list = new ArrayList<>(); //"kot"

        for (int i = 0; i < string.length(); i++) {
            String right = string.substring(i + 1, string.length());
            String left = string.substring(0, i);

            list.add(left + right);
        }

        return list;
    }

    static List<String> Insertion(String string) {
        List<String> list = new ArrayList<>(); //"kot"

        for (int i = 0; i <= string.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String left = string.substring(0, i);
                String right = string.substring(i);

                list.add(left + j + right);
            }
        }
        return list;
    }

    static List<String> Substitution(String string) {//kot
        List<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String right = string.substring(i + 1, string.length());
                String left = string.substring(0, i);

                list.add(left + j + right);
            }

        }

        return list;
    }

    static List<String> CloseSubstitution(String string) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (char j : neighbours.get(string.charAt(i))) {
                String right = string.substring(i + 1, string.length());
                String left = string.substring(0, i);

                list.add(left + j + right);
            }

        }

        return list;
    }

    static double LevQWERTY(String s1, String s2) { //mapa kot
        Map<Double, List<String>> map = new HashMap<>();

        map.put(0.0, Collections.singletonList(s1));

        double currentDistance = 0;

        while (!map.get(currentDistance).contains(s2)) {

            List<String> current = map.get(currentDistance);
            List<String> current05 = map.getOrDefault(currentDistance + 0.5, new ArrayList<>());
            List<String> current10 = map.getOrDefault(currentDistance + 1, new ArrayList<>());
            for (String c : current) {
                current05.addAll(CloseSubstitution(c));
                current10.addAll(Deletion(c));
                current10.addAll(Insertion(c));
                current10.addAll(Substitution(c));
            }

            map.put(currentDistance + 0.5, current05);
            map.put(currentDistance + 1, current10);

            currentDistance += 0.5;
        }

        return currentDistance;
    }

    public static void main(String[] args) {

        //System.out.println(Deletion("małpa")); 
        // System.out.println(Insertion("małpa")); 
        // System.out.println(CloseSubstitution("sdfg")); 
        System.out.println(LevQWERTY("kot", "kita"));

    }

}
