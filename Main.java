
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class Main {
    
    
    static int getSalary(String line){
        int lastSpaceIndex = line.lastIndexOf(' ');
        String salaryStr = line.substring(lastSpaceIndex+1);
        return Integer.valueOf(salaryStr);
    }
    
    static class Box {
        int i;

        public Box(int i) {
            this.i = i;
        }
    }
    
     static String getCountry(String line){
         
        String[] splitted = line.split(" ");
        return splitted[2];
        
    }
    
    
    public static void main(String[] args) {
       
        String fileName = "dane.txt";
                 Box maxSalary = new Box(Integer.MIN_VALUE);
                 Box minSalary = new Box(Integer.MAX_VALUE);
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                   
                        stream
                                .filter(x->(getCountry(x).equals("PL")))
                                .map(x->getSalary(x))
                                .forEach(y->{
                                
                                    if(maxSalary.i < y) {
                                        maxSalary.i = y;
                                    }
                                    
                                    if(minSalary.i > y) {
                                        minSalary.i = y;
                                    }
                                
                                });
                                
                                
                       

		} catch (IOException e) {
			e.printStackTrace();
		}
                
                
                
                try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                    Box secondMaxSalary = new Box(Integer.MIN_VALUE);
                    Box secondMinSalary = new Box(Integer.MAX_VALUE);
                        stream
                                .filter(x->(getCountry(x).equals("PL")))
                                .map(x->getSalary(x))
                                .filter(x->(x<maxSalary.i && x>minSalary.i))
                                .forEach(y->{
                                
                                    if(secondMaxSalary.i < y ) { //&& y!= maxSalary.i
                                        secondMaxSalary.i = y;
                                    }
                                    
                                    if(secondMinSalary.i > y) {
                                        secondMinSalary.i = y;
                                    }
                                
                                });
                                
                                
                        System.out.println(secondMaxSalary.i+maxSalary.i);
                        System.out.println(secondMinSalary.i+minSalary.i);

		} catch (IOException e) {
			e.printStackTrace();
		}
                
                
                 try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                     
                           Map<String,Integer> map = stream.collect(Collectors.toMap(x->getCountry(x),x->(1) , (x,y)->x+y));   
                             
                           System.out.println(map);
                       

		} catch (IOException e) {
			e.printStackTrace();
		}
                
                 
                 
                
                
            
        
    }
    
    
}
