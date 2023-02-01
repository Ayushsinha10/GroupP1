  import java.util.*;
class Doctor {
 
  
     public static void main(String[] args) {
        System.out.println("Hello, I am Doctor Eliza what seems to be the problem? (quit to exit)");
        Scanner reader = new Scanner(System.in);
        boolean running = true;
        while (running){
        String[] input = reader.nextLine().split(" ");
         for (int i = 0; i < input.length; i++){
          if (input[0].equals("quit"))
          running = false;
         }
        processInput(input);
        
       
        }
       
       





    }
  public static void processInput(String[] input){
    while (sorryMethod(input)){
      return;
    }
    while (noMethod(input)){
      return;
    }
    while (happyMethod(input)){
      return;
    }
    while (believeMethod(input)){
      return;
    }
  }
public static boolean sorryMethod(String[] input){
        for (int i = 0; i < input.length; i++){
       if (input[i].startsWith("sorry") || input[i].startsWith("Sorry") ){
             int random = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
             if (random == 1 ){
            System.out.println("No need to be sorry");
             }
              if (random == 2){
            System.out.println("Why so guilty?");
             }
              if (random == 3){
            System.out.println("You should be.");
             }

            return true;
             }
            
             
         }
         return false;
  }
public static boolean believeMethod(String[] input){
   for (int i = 0; i < input.length; i++){
       if (input[i].startsWith("believe") || input[i].startsWith("Believe") ){
         int random = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
         if (random == 1){
          System.out.println("Why do you believe that?");
         }
         if (random == 2){
          System.out.println("Do you really believe that?");
         }
         if (random == 3){
          System.out.println("What is it you really believe?");
         }
         return true;
        
         }
        
   }
   return false;
}
public static boolean happyMethod(String[] input){
   for (int i = 0; i < input.length; i++){
       if (input[i].startsWith("happy") || input[i].startsWith("Happy") ){
         int random = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
         if (random == 1){
          System.out.println("Are you always happy?");
         }
         if (random == 2){
          System.out.println("What makes you happy");
         }
         if (random == 3){
          System.out.println("Are you really happy?");
         }
         return true;
        
         }
        
   }
   return false;
} 
public static boolean noMethod(String[] input){
   for (int i = 0; i < input.length; i++){
       if (input[i].matches("no") || input[i].matches("No") || input[i].matches("No.") 
       || input[i].matches("No!") || input[i].matches("no.") || input[i].matches("no!") ||
        input[i].matches("no,") || input[i].matches("No,")  ){
         int random = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
         if (random == 1){
          System.out.println("Why not?");
         }
         if (random == 2){
          System.out.println("Are you just being contrarian");
         }
         if (random == 3){
          System.out.println("No?");
         }
         return true;
        
         }
        
   }
   return false;
} 
public static void contrarianMethod(String[] input){
  for (int i = 0; i < input.length; i++){
       if (input[i].startsWith("Don't") || input[i].startsWith("don't")
       ){}
  }
}




}




