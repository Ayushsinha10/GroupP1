import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
class Engine{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Scanner start = new Scanner(System.in);
        boolean running = true;
        System.out.println("Choose Script: \n Doctor [1] \n Child [2] \n Pirate[3]");
        int choice = start.nextInt();
        if (choice == 2){
            System.out.println("You are chatting with a child say hi! [Type !quit to exit]");
            File script = new File ("./8YearOld.sh");
             while(running){
            
        String fullinput = reader.nextLine();
        String[] input = fullinput.split(" ");
      
         for (int i = 0; i < input.length; i++){
          if (input[i].equals("!quit")){
          running = false;
          System.out.println("Thanks for chatting!");
          return;
          }
          
         }
          
          readScript(input, script, fullinput);

        }

        }
        else if (choice == 1){
            System.out.println("You are chatting with a doctor say hi! [Type !quit to exit]");
            File script = new File ("./Doctor.sh");
             while(running){
            
        String fullinput = reader.nextLine();
        String[] input = fullinput.split(" ");
      
         for (int i = 0; i < input.length; i++){
          if (input[i].equals("!quit")){
          running = false;
           System.out.println("Hope to see you for another session.");
          return;
          }
         }
          
          readScript(input, script, fullinput);

        }

        }
        else if (choice == 3){
            System.out.println("You are chatting with a pirate say hi! [Type !quit to exit]");
            File script = new File ("./Pirate.sh");
             while(running){
            
        String fullinput = reader.nextLine();
        String[] input = fullinput.split(" ");
      
         for (int i = 0; i < input.length; i++){
          if (input[i].equals("!quit")){
             System.out.println("See you another time matey.");
          running = false;
          return;
          }
         }
          
          readScript(input, script, fullinput);

        }

        }
        
        
        
    
    


    }
    public static void readScript(String[] input, File script, String fullinput){
       try{ Scanner reader = new Scanner(script);
        List<String> key = new ArrayList<String>();
        List<String> decomp = new ArrayList<String>();
        List<String> reassem = new ArrayList<String>();

       
    // Get keywords for script
        key = getKeywords(input, script);
        ListIterator<String> listIterator = key.listIterator();
        while(listIterator.hasNext()){
            String test = listIterator.next();
            Pattern regextest = Pattern.compile(test);
            for (int i = 0; i < input.length; i++){
                Matcher regexkey = regextest.matcher(input[i]);
             if(regexkey.find()){
                // get list of decompostions for the keyword.
                decomp = getDecomposition(test, script);
                 ListIterator<String> listIterator2 = decomp.listIterator();
                 
       while(listIterator2.hasNext()){
              
            String decompo = listIterator2.next();
          
             Pattern decompregex = Pattern.compile(decompo);
             Matcher inputregex = decompregex.matcher(fullinput);
              
              if(inputregex.find()){
                reassem = getReassem(decompo, script);
                Random rand = new Random();
                int randomIndex = rand.nextInt(reassem.size());
               
                String randomElement = reassem.get(randomIndex);
                System.out.println("Eliza: "+randomElement);
                return;


                

              }
         }
        
                
              
                
             }
             
             
            }
             }
             decomp = getDecomposition("D34F4L7", script);
                 ListIterator<String> listIterator2 = decomp.listIterator();
                 
            while(listIterator2.hasNext()){
              
            String decompo = listIterator2.next();
          
             Pattern decompregex = Pattern.compile(decompo);
             Matcher inputregex = decompregex.matcher(fullinput);
               reassem = getReassem(decompo, script);
              if(inputregex.find()){
                Random rand = new Random();
                int randomIndex = rand.nextInt(reassem.size());
               
                String randomElement = reassem.get(randomIndex);
                System.out.println("Eliza: "+randomElement);
                return;
                 }

            

           

        }
                
              
               
                   

        
       }


       catch (FileNotFoundException e) {
			System.err.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
       
        }
        
     
    
        
        public static List<String> getKeywords(String[] input, File script){
             List<String> keywords = new ArrayList<String>();
            try{ Scanner reader = new Scanner(script);
            // read script
            
            
       while (reader.hasNext()){
       String line = reader.nextLine();
       // find all lines that have a keyword
       if (line.startsWith("Key: ")){
        //
        line = line.replaceAll("Key: ", "");
        Scanner readLine = new Scanner (line);

       
        while (readLine.hasNext()){
            // add keywords to list
        keywords.add(readLine.nextLine());
       
        }
    
               
       }

       
       }
        return keywords;
       
        }
        catch (FileNotFoundException e) {
			System.err.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
        return keywords;
        
        }
          public static List<String> getDecomposition(String key, File script){
              List<String> decomp = new ArrayList<String>();
       try{ Scanner reader = new Scanner(script);
       while (reader.hasNext()){
        String line = reader.nextLine();
        if (line.equals("Key: "+key)){
            while (reader.hasNext()){
                String decomposition = reader.nextLine();
                if (decomposition.startsWith("    Decomp: ")){
                decomposition = decomposition.replaceAll("    Decomp: ", "");
                
                decomp.add(decomposition); 
        
                }
             
                if(decomposition.startsWith("Key: ")){
                    return decomp;
                   
                     }
                 
                }
            }

        }
         
       
    

      
        
       }
       catch (FileNotFoundException e) {
			System.err
					.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
       
        
       return decomp;
        
        }

        public static List<String> getReassem(String key, File script){
              List<String> reassem = new ArrayList<String>();
       try{ Scanner reader = new Scanner(script);
       while (reader.hasNext()){
        String line = reader.nextLine();
        if (line.equals("    Decomp: "+key)){
            while (reader.hasNext()){
                String reassemble = reader.nextLine();
                if (reassemble.startsWith("        Reassem: ")){
                reassemble = reassemble.replaceAll("        Reassem: ", "");
                
                reassem.add(reassemble); 
        
                }
             
                if(reassemble.startsWith("    Decomp: ") || reassemble.startsWith("Key: ")){
                    return reassem;
                    
                   
                     }
                 
                }
            }

        }
         
       
    

      
        
       }


       catch (FileNotFoundException e) {
			System.err.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
       
        
       return reassem;
        
        }
        
        




    }