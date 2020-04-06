
package pesel;

import java.time.LocalDate;
import java.util.Scanner;

public class Pesel {
    
    String gender;
    LocalDate birthDate;
    
    static boolean validatePesel(long pesel)
    {
        //long rok =  pesel/1000000000;
        
        long month = (pesel/10000000)%100;

        long day = (pesel/100000)%100;

        if( String.valueOf(pesel).length() != 11)
        {
           return false;
        }
        
       if(month == 0 || (month > 12 && month < 21) || month > 32)
       {    
           return false;
       }
       
        if (day == 0 || day > 31)
        {
            return false;
        }
        
        
       int validationNumber = (int)(pesel%10); 
       int[] array = {7,9,1,3,7,9,1,3,7,9};
       
       int sum = 0;
       long dzielnik = 0;
       for(int i = 0; i < 10 ; i++)
       {
           
           dzielnik = (long)(Math.pow(10,i+1));
           long number = (pesel/dzielnik)%10;
           sum +=  number*array[i];
       }
       
       sum%=10;
       return (sum == validationNumber);
            
        
    }
    
    static Pesel parse(long pesel)
    {
        Pesel p = new Pesel(); 
       
        if((pesel/10) % 2 == 0)
        {   
            p.gender = "Kobieta";
        }
        else 
        {
            p.gender = "Mezczyzna";
        }
             
        
        long year =  pesel/1000000000;
        
        
        long month = (pesel/10000000)%100;

        long day = (pesel/100000)%100;
        

        int century;
        if(month < 21)
        {
            century = 1900;
        }
        else
        {
            century = 2000;
        }
        
        p.birthDate = LocalDate.of((int)year+century, (int)month, (int)day);
        
        
        return p;
    }
    
    
        
   public static void main(String[] args) {
       
        
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj swój numer PESEL");
        long pesel = input.nextLong();
        
        if(!validatePesel(pesel))
        {
            System.out.println("Podany PESEL jest niepoprawny!");
        }    
        else
        {
            Pesel p = parse(pesel);
            System.out.println("Plec: "+ p.gender+", " + "Data urodzenia: "+p.birthDate);
        }    
        
        
        
       
        
       
        
        
     
        
    }
    
    
        
    
}
