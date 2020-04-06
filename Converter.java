import java.util.Scanner;

 public class Converter {


 static void convert(int base, int number)
{   
    char[] charArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    String s = "";
        while(number > 0)
        {
            s = s + charArray[number%base];
            number = number/base;
        }
        
        for(int i = s.length()-1; i > 0 ; i--)
        {
            System.out.print(s.charAt(i));
        }
    System.out.println("");

}






     public static void main(String[] args) {
        
        int number = 0b1101_1000; 

        Scanner input = new Scanner(System.in);
        System.out.println("Proszę podać podstawę systemu, na który konwertujemy w postaci słownej: trzy, dziesiec lub szesnascie ");
        String baseS = input.nextLine();
        
        if("trzy".equals(baseS))
        {
            int base = 3;
            System.out.println("Konwertujemy na system trójkowy!");
            convert(base,number);
        }
        else if("dziesiec".equals(baseS))
        {
            int base = 10;
            System.out.println("Konwertujemy na system dziesietny!");
            convert(base,number);
        }
        else if("szesnascie".equals(baseS))
        {
            int base = 16;
            System.out.println("Konwertujemy na system szesnastkowy!");
            convert(base,number);
        }
        else
            System.out.println("Podstawa została podana błędnie!");
        

    }
    
}


