import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
class Engine{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        boolean running = true;
        String[] input = reader.nextLine().split(" ");
         for (int i = 0; i < input.length; i++){
          if (input[0].equals("quit"))
          running = false;
          

         }
         File script = new File ("./8YearOld.sh");
         readScript(input, script);
    
    


    }
    public static void readScript(String[] input, File script){
       try{ Scanner reader = new Scanner(script);
        reader.useDelimiter("Key: ");
        System.out.println(reader.nextLine()); }
        catch (FileNotFoundException e) {
			System.err
					.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
    
        }
        




    }




















