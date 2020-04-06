import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    
   static long numberOfDays(LocalDate begin, LocalDate end) {
       
      return (DAYS.between(begin, end)+1);
   }
   
   static int dayOfYearAndMonth(int day, int year){
       
      LocalDate date =  LocalDate.ofYearDay(year,day);
       
      int monthValue = date.getMonthValue();
      int dayValue = date.getDayOfMonth();
      
      return 100*monthValue + dayValue;
       
   }

   static int sumOfDigits(int number, LocalTime begin, LocalTime end){
       int sum = 0;
       for(LocalTime i = begin; !i.isAfter(end); i = i.plusMinutes(1)){
          if(getNumber(i) == number){
              sum++;
          }
           
       }
       return sum;
   }    
   
   static int getNumber(LocalTime time){
       int minuteValue = time.getMinute();
       int hourValue = time.getHour();
       
       return minuteValue/10+minuteValue%10+hourValue/10+hourValue%10;
   }
   
   static int numberOfLeapYears(LocalDate begin){
       int sum = 0;
       for(LocalDate i = begin; !i.isAfter(LocalDate.now()); i = i.plusDays(1)){
           if(i.getDayOfMonth() == 29 && i.getMonth() == Month.FEBRUARY)
               sum++;
       }
       return sum;
   }
   
   
    public static void main(String[] args) {
        LocalDate beginDate = LocalDate.of(1939,9,1);
        LocalDate endDate = LocalDate.of(1945,5,8);
      
        LocalTime beginTime = LocalTime.of(11, 45);
        LocalTime endTime = LocalTime.of(22, 30);
        
        LocalDate myDate = LocalDate.of(1995,5,22);
        
        int cTester = 3; // Liczba razy, suma cyfr godzin i minut stanowi 16 od 19:00 do 19:30 
        
        if(cTester == (sumOfDigits(16,LocalTime.of(19, 00),LocalTime.of(19, 30)))){
            System.out.println("Test przebiegł pomyślnie");
        }
        else{
            System.out.println("Test przebiegł błędnie");
        }
        
        
        System.out.println("Odpowiedź do a: "+numberOfDays(beginDate,endDate)); 
        System.out.println("Odpowiedź do b: "+dayOfYearAndMonth(68,2016));
        System.out.println("Odpowiedź do c: "+sumOfDigits(15,beginTime,endTime));
        System.out.println("Odpowiedź do d: "+numberOfLeapYears(myDate));
        
  
    }
    
    
    
    
}
