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
        boolean running = true;
        
        while(running){
        String fullinput = reader.nextLine();
        String[] input = fullinput.split(" ");
      
         for (int i = 0; i < input.length; i++){
          if (input[0].equals("quit"))
          running = false;
         }
           File script = new File ("./8YearOld.sh");
          readScript(input, script, fullinput);

        }
        
    
    


    }
    public static void readScript(String[] input, File script, String fullinput){
       try{ Scanner reader = new Scanner(script);
        List<String> key = new ArrayList<String>();
        List<String> decomp = new ArrayList<String>();
        List<String> reassem = new ArrayList<String>();
       

        key = getKeywords(input, script);
        ListIterator<String> listIterator = key.listIterator();
        while(listIterator.hasNext()){
            String test = listIterator.next();
            for (int i = 0; i < input.length; i++){
             if(input[i].matches(test)){
                decomp = getDecomposition(test, script);
                 ListIterator<String> listIterator2 = decomp.listIterator();
                 
       while(listIterator2.hasNext()){
              
            String decompo = listIterator2.next();
          
             Pattern dec = Pattern.compile(decompo);
             Matcher doo = dec.matcher(fullinput);
               reassem = getReassem(decompo, script);
              if(doo.find()){
              
               
                ListIterator<String> ListIterator3 = reassem.listIterator();
               
               while(ListIterator3.hasNext()){
                Random rand = new Random();
                int randomIndex = rand.nextInt(reassem.size());
               
                String randomElement = reassem.get(randomIndex);
                System.out.println(randomElement);
                break;
                  
                  


                }


                

           }
            

           

        }
                
              
                return;
             }
             
            }
        }
        
       }


       catch (FileNotFoundException e) {
			System.err
					.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
       
        }
        
     
    
        
        public static List<String> getKeywords(String[] input, File script){
             List<String> keywords = new ArrayList<String>();
            try{ Scanner reader = new Scanner(script);
            
       while (reader.hasNext()){
       String line = reader.nextLine();
       
       if (line.startsWith("Key: ")){
        line = line.replaceAll("Key: ", "");
        Scanner readLine = new Scanner (line);

       
        while (readLine.hasNext()){
        keywords.add(readLine.nextLine());
       
        }
    
               
       }

       
       }
        return keywords;
       
        }
        catch (FileNotFoundException e) {
			System.err
					.println("ERROR: Script file is not in the specified location.");
			System.exit(0);
		} 
        return keywords;
        
        }
          public static List<String> getDecomposition(String key, File script){
              List<String> decomp = new ArrayList<String>();
       try{ Scanner reader = new Scanner(script);
       while (reader.hasNext()){
        String line = reader.nextLine();
        if (line.startsWith("Key: "+key)){
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
        if (line.startsWith("    Decomp: "+key)){
            while (reader.hasNext()){
                String reassemble = reader.nextLine();
                if (reassemble.startsWith("        Reassem: ")){
                reassemble = reassemble.replaceAll("        Reassem: ", "");
                
                reassem.add(reassemble); 
        
                }
             
                if(reassemble.startsWith("    Decomp: ")){
                    return reassem;
                    
                   
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
       
        
       return reassem;
        
        }
        
        




    }




















