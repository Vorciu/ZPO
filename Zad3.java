import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zad3 {
    
    public static void main(String[] args) {
            
        Random random = new Random();
        Map<Integer,List<String>> map = new HashMap <> ();
        
         String fileName = "1500.txt";
         try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                     
                Iterator <String> it = stream.iterator();
                int k = 3;

                        for(int i = 0; i < 10 ; i++){
                           
                          System.out.println("Dzien "+ (i+1));  
                          System.out.print("Nowe słowa: ");
                          List<String> list = new ArrayList <>();
                          String word1 = it.next();
                          list.add(word1); 
                          System.out.print(word1+" ");
                          String word2 = it.next();
                          list.add(word2); 
                          System.out.println(word2);  
                          map.put(i,list);
                          //System.out.println("Słowa zapomniane dnia " +i);
                           
                          
                          List<String> forgettableWords = new ArrayList <> ();
                          for(int j=0; j <= i-k ; j++){
                               
                              // System.out.println(map.get(j)); //zapomniane słowa
                               forgettableWords.addAll(map.get(j));  
                               
                           }
                           if(i>=k){ //
                             int index1 = random.nextInt(forgettableWords.size());  
                             int index2 = random.nextInt(forgettableWords.size());
                             while(index1 == index2){
                                  index2 = random.nextInt(forgettableWords.size());
                             }
                             System.out.print("Zapomniane słowa: ");
                             boolean flag = false;
                             for(int j = 0; j <= i-k; j++){
                                 List<String> words = map.get(j);
                                 if(random.nextBoolean()){
                                     if(words.remove(forgettableWords.get(index1))){
                                         System.out.print(forgettableWords.get(index1)+" ");
                                         flag = true;
                                     } 
                                    
                                     
                                 }
                                 if(random.nextBoolean()){
                                    if(words.remove(forgettableWords.get(index2))){
                                         System.out.println(forgettableWords.get(index2));
                                         flag = true;
                                     } 
                                   
                                 }
                             }
                             if(flag == false){
                                 System.out.println("---");
                             }
                            
                             
                           }
                          
                            System.out.println(map.values().stream().flatMap(x->x.stream()).collect(Collectors.toList()));
                            
                        }
             
                            
                           //Map<String,Integer> map = stream.collect(Collectors.toMap());   
                             
                           
                       

		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
