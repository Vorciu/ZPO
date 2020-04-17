
import java.util.Random; 
import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Zad2 {
    
    public static void main(String[] args) {
       int n = Integer.valueOf(args[0]);
       int sigma = Integer.valueOf(args[1]);
       int avg = Integer.valueOf(args[2]);
        NumberFormat nf = NumberFormat.getInstance(new Locale("pl","PL"));
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("D:\\Programowanie\\gauss.bin"))){
            Random r = new Random();
            int delay;
            for(int i = 0 ; i < n ; i++){
                do {
                    double val = r.nextGaussian() * sigma + avg;
                    delay = (int) Math.round(val);
                    dataOut.writeDouble(val);
                } while (delay <= 0);
            }
        
        
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        
        
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("D:\\Programowanie\\gauss.bin"));
             PrintWriter dataOut = new PrintWriter("D:\\Programowanie\\gauss.txt")){
            
            while(dataIn.available() > 0) {

            
                
                        
                    double val = dataIn.readDouble();
                    //dataOut.writeDouble(dataIn.readDouble());
                    dataOut.write(nf.format(val));
                    dataOut.write("\r\n");
                    System.out.println(val);
                              

            
            }
            
        }catch(IOException e){
           throw new RuntimeException(e);
        }
        
        
        
        
        
    }
}
