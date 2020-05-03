
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Lab1_3 {

    private static Map<Character, String> initializeMap() {

        Map<Character, String> map = new HashMap<Character, String>();

        map.put('-', "minus");
        map.put('0', "zero");
        map.put('1', "jeden");
        map.put('2', "dwa");
        map.put('3', "trzy");
        map.put('4', "cztery");
        map.put('5', "pięć");
        map.put('6', "sześć");
        map.put('7', "siedem");
        map.put('8', "osiem");
        map.put('9', "dziewięć");

        return map;
    }

    static void main(String[] args) {

        Map<Character, String> map = initializeMap();

        Scanner input = new Scanner(System.in);
        System.out.println("Podaj liczbę");
        String number = input.nextLine();

        //wyrażenie regularne
        if (!number.matches("-?\\d{3}")) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < number.length(); i++) {
            char znak = number.charAt(i);
            String slowo = map.get(znak);
            System.out.print(slowo + " ");
        }

    }
}
