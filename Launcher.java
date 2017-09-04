//at end, make sure to handle all exceptions from user input!
import java.util.*;
import java.io.*;
import java.text.*;
/**
<h1>Club and Sale Organizer<h1>
*This program allows the user to create clubs, add events(sales) from a club, find all the events under a club, and delete a club. 
@author: Justine Ventura
*/


public class Launcher{

    private static final String FileName = "C:/Users/justi/Documents/bluej/vidtextfile.txt";//place text file name here
    
     

     private String b_club= null;
     private String b_exec = null;
     private String b_id= null;
     private String b_date= null;
     private String b_type = null;
     private String b_cost = null;
     private String b_gross = null;
     private String b_net = null;
  

   public static void main(String[] args)throws Exception{//check exception!!
         
         File file = new File(FileName);
         //String FileName = 
         if(file.createNewFile()){
             //If file does not exist, then it will be created
             //System.out.println("File found");
            }
         else{
             
             
             //System.out.println("File not found");
             
            }
         
         
       
     Launcher objlau = new Launcher();
     int id = 0 ;
     int id_run = 0;
    
     Event [] events= new Event[100];
     Club[] clubs = new Club[100];
  
    
     int club_counter = 0; //counts how many indexes are in the clubs array after each new club is created
     int even_counter = 0; //counts how many indexes are in the events array after each new event is created
   
     String what ="";
 
     id = Integer.valueOf(retID());
     id_run = id + 1;
    
    

       
         while (!what.equals("x")){
        Scanner th = new Scanner(System.in);
        System.out.println("What do you want to do (a-add an event, c- create a club, f-find a club, d-delete a club, x to exit ): ");//add a modify info one-- kind of hard r now
        what = th.nextLine();
      
       if(what.equals("A") || what.equals("a")){
       System.out.println("Create a new event: ");
       try{
          
          
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter the name of your club: ");
           String u_name = sc.nextLine();
           u_name = u_name.toUpperCase();

          boolean check = exists(u_name);
          if(check == false){

                System.out.println("This club does not yet exist. Please create the club first, then exit.");
                //continue
                continue;
                }
                
           
           Scanner en = new Scanner(System.in);
           System.out.println("What was the starting date of your sale (ddmmyyy): ");
           String u_date = en.nextLine();
           
           
           Scanner an = new Scanner(System.in);
           System.out.println("What was sold at your sale: ");
           String u_type = an.nextLine();
        
    
           double u_cost = -9;//initially set as negative so it will enter loop
           while(u_cost  < 0){
               Scanner cs = new Scanner(System.in);
               System.out.println("How much did capital did you have: ");
               System.out.print("$");
               u_cost = cs.nextDouble();
               
               
               
            }
           
                 
          
           double x = objlau.mGross();
           double u_gross = x;
           System.out.println("How much money was made:$ "+ u_gross);
           
           double u_net = objlau.mNet(u_cost, u_gross);
           System.out.println("Your net profit: $ "+ u_net);
           System.out.println(" ");
          
           int clubIDFound = Integer.valueOf(finder(u_name, "clubid"));//converts the ID from type String to an integer
          
          events[even_counter] = new Event(u_date,u_type,u_cost,u_gross,u_net,clubIDFound);
          
       
          even_counter++;
          
        
        }catch(InputMismatchException e ){
            System.out.println("Enter proper values.");
        }
        
    }
    

    
     if(what.equals("C") || what.equals("c")){
        
        try{
         System.out.println("Enter a new club: ");
         
         Scanner clb = new Scanner(System.in);
         System.out.println("Enter the name of your club: ");
         String u_club = clb.nextLine();
         u_club = u_club.toUpperCase();

        if(exists(u_club) == true){

                System.out.println("This club already exists");
                //continue
                continue;
          }
        else {
         
         Scanner exc = new Scanner(System.in);
         System.out.println("Enter the name of the club leader: ");
         String u_exec = exc.nextLine();
         u_exec= u_exec.toUpperCase();
  
        int u_id = id_run;
    
        clubs[club_counter] = new Club(u_club, u_exec, u_id);
       
         
         id_run++;
         club_counter++;
        
        }
      } catch(InputMismatchException e){

            System.out.println("Enter proper values.");

        }
          
      
     }
 
        
    
    else if (what.equals("F") || what.equals("f")){
       
       Scanner ef = new Scanner(System.in);
       System.out.println("Which club do you want to search for? ");
       String cl = ef.nextLine();
       cl = cl.toUpperCase();
        if(exists(cl) == false){
            
            System.out.println("This club could not be found. Sorry.");
            continue;


          }
        
        else{

       
            String foundid= finder(cl, "clubid");//find the club id number
 
            String[] allEvents = eventCollector(foundid);//find all events with the corresponding club id number
            
            
                for(int i =0; i< allEvents.length; i++){

                    if(allEvents[i] == null && i == 0){//check if the partially filled array has a following element

                        //break;
                        System.out.println("There are no events associated with this club.");
                        break;
                        }
                    else if(allEvents[i] == null){

                        break;
                       }
                      int first = ordinal(allEvents[i], "|", 1);
                      int second = ordinal( allEvents[i],"|", 2);
                      int third = ordinal(allEvents[i], "|", 3);
                      int fourth = ordinal(allEvents[i], "|", 4);
                      int fifth = ordinal(allEvents[i], "|", 5);
                      int sixth = ordinal(allEvents[i], "|", 6);

                    System.out.println(allEvents[i]);
                
                    System.out.print("This is date of the sale: ");
                    System.out.println(allEvents[i].substring(first +1, second));

                     System.out.print("This is what was sold: ");
                     System.out.println(allEvents[i].substring(second + 1, third));
                
                     System.out.print("This is the cost of the sale: $ ");
                     System.out.println(allEvents[i].substring(third + 1, fourth));
               
                     System.out.print("This is the how much money was made: $ ");//gross
                     System.out.println(allEvents[i].substring(fourth +1, fifth));
            
                     System.out.print("This is the net amount of money: $ ");
                     System.out.println(allEvents[i].substring(fifth + 1, sixth));
              
                
                    System.out.println("----------------------------------------");




                }
            
                //System.out.println("There are no events");
                            
                      
            
                        
             //System.out.print("This is what was sold: ");
             //System.out.println(allEvents[0].substring(0, 15));
        }
    } 
    else if(what.equals("d") || what.equals("D")){
        

        Scanner scan_del = new Scanner(System.in);
        System.out.println("Enter the club you want to delete: ");
        String del = scan_del.nextLine();
        del = del.toUpperCase();

        if(exists(del) == false){
                
            System.out.println("This club does not exist. ");


          }

        else{
        String foundit = finder(del,"clubid");//find the id number of this club
        String[] foundString = eventCollector(foundit);//find all events with the id number
        
            
        for(int j = 0; j < foundString.length; j++){
                    if(foundString[j] == null){//check if the partially filled array has a following element

                        break;

                        }
                updateLine(foundString[j], "");
            

        }
        
        
            updateLine(finder(del,"delete_event"), "");//deletes the club info altogether
            System.out.println("The club has been deleted.");
        
        
        
        }
        
    }
    
    
 }
 

 objlau.writer(events, even_counter);// calls the writer method to write in all the data for events
 objlau.writer(clubs, club_counter);//calls the writer method to write in all data for clubs

        
}
/**
*This method is used to add bills and coins in a cash box which
*have been collected during a sale
@param args Unused.
@return double This returns sum of input values

*/

 private  double mGross(){
        
        System.out.println("Count your money:");
    
        int tw = validValue("$20", "bills");
        int twenty = tw * 20;
        
        int te = validValue("$10", "bills");
        int ten = te * 10 ;
        
        int fi = validValue("$5", "bills");
        int five = fi * 5;
        
        int to = validValue("$2", "coins");
        int toon = to * 2 ;
        
        int lo = validValue("$1", "coins");
        int loon = lo;
        
        int qu = validValue("$0.25", "coins");
        double quart = qu * 0.25;

        int di = validValue("$0.10", "coins");
        double dime = di * 0.10 ;
        
        int ni = validValue("$0.05", "coins");
        double nick = ni * 0.05 ;
        
        
    
        DecimalFormat f = new DecimalFormat("##.00");
        double sum = twenty +ten + five + toon + loon + quart+ dime + nick;
        //f.format(sum);
      
        return Double.valueOf(f.format(sum));//rounds to two decimal points 
        
    }
    
/**
*This method is used to calculate the net of a sale by subtracting
*the cost of the sale from the gross found in the mGross() method
@param cost This is the cost of the sale
@param gross This is the gross from the sale
@return double This returns the net of the sale
*/  
public  double mNet(double cost, double gross){
        DecimalFormat f = new DecimalFormat("##.00");
        double net = gross - cost;
        return Double.valueOf(f.format(net));
        
    
 }
 
/**
 * This method works with the mGross() method to make sure that the user will enter a value 
 * that is a positive integer when prompted to enter the number of a certain denomination 
 * ex: How many ten dollar bills
 * @param denom This is the denomination
 * @param which This determines whether the denomination is in bills or coins
 * @return This returns a positive integer value, representing how many bills/coins there are of a certain denomination
 */
private static int validValue(String denom, String which){
    Scanner scan = new Scanner(System.in);
    int x_num = 0;
    
        while(1==1){//ensures that program will always go into the while loop
        System.out.println("Enter the number of " + denom + " "+ which);
        x_num = scan.nextInt();
        
        if(x_num >=0){
            
            break;
        }
        else{
            System.out.println("Please enter a positive integer value.");
            
        }
        
    }
    return x_num;
}

/**
*This method is used to find the position of a delimiter (|)
*@param str This is the line of text which contains multiple delimiters
*which are used to separate pieces of information
*@param delim This is the delimiter (|) which the method is looking for
*@param n This is nth occurence of the delimiter in the line
@return int This returns the position of the delimiter
*/
    
 private static int ordinal(String str, String delim, int n){
    int pos = str.indexOf(delim);
    while(--n > 0 && pos != -1)
    
    pos = str.indexOf(delim, pos + 1);
   
    
    return pos;
    //Source: http://programming.guide/java/nth-occurrence-in-string.html


    }

/**
This method reads the text file to search for a particular piece of information
*@param textToFind This is the keyword(s) which one would like to find
*@param which This method is used by many other parts of the program 
*so this parameter narrows down what exactly one wants to find
*@return String This can return many things like the ID number or a word like "true"
*/
    
 private static String finder(String textToFind, String which){
      BufferedReader br = null;
       FileReader fr = null;

     try {

            fr = new FileReader(FileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

    
            while ((sCurrentLine = br.readLine()) != null) {
                
                
                
                if(sCurrentLine.contains(textToFind)){
                    int first = ordinal(sCurrentLine, "|", 1);
                    int second = ordinal(sCurrentLine, "|", 2);
                    int third = ordinal(sCurrentLine, "|", 3);
                    int fourth = ordinal(sCurrentLine, "|", 4);
          
                  
                        
                       if(which.equals("clubid")){
                          
                           return sCurrentLine.substring(third + 1, fourth);
                          
                           
                        }
                        else if(which.equals("clubtoFind")){
                            String check =sCurrentLine.substring(first + 1 , second);
                            if(check.equals(textToFind)){

                                return "true";

                             }
                            else{

                                return "false";
                             }
                            

                          }
                        else{
                            
                            return sCurrentLine;
                            
                        }
                        
          
            
                    }
                }
            
            
         } catch (IOException e) {

            e.printStackTrace();

        } 
    return "String";
     
    }
/**
*This method finds all events with the same club ID and stores all of them to delete
*@param clubID This is the clubID of a club, found using the finder method
*@return String[] This is an array of all the events of a particular club
*/
 private static String[] eventCollector(String clubID ){
     String[] collect = new String[100];
      BufferedReader br = null;
      FileReader fr = null;

     try {

            fr = new FileReader(FileName);
            br = new BufferedReader(fr);

            String sCurrentLine;
            int i = 0;
    
            while ((sCurrentLine = br.readLine()) != null) {
                
                if(sCurrentLine.contains(clubID)){
                    int first = ordinal(sCurrentLine,"|",1);
                    String check = sCurrentLine.substring(0,first);
                    
                    if(check.equals("E")){//this if statement prevents the method from reading the line which contains info about the club 
                                int sixth = ordinal(sCurrentLine,"|", 6);
                                String num = sCurrentLine.substring(sixth +1, sCurrentLine.length());
                                if(num.equals(clubID)){
                                    collect[i] = sCurrentLine;
                                    i++;                            
                              }

                        
                        
                            }
                }
            }
          }catch(IOException e){

                e.printStackTrace();

            }
            return collect;
        }
      
/**
*This method writes data about events into the text file
*@param Event events[] This is the array of events that must be added to the text file
*@param even_counter This is how many events have been created in this run of the program
@return nothing
*/
private void writer(Event events[], int even_counter){
 
       BufferedWriter bw = null;
       FileWriter fw = null;
       try{
           fw = new FileWriter(FileName,true);//true to append
           bw = new BufferedWriter(fw);
           
         for(int i = 0; i < even_counter ; i++){

   
           b_date = events[i].getDate();
           b_type = events[i].getType();
           b_cost = Double.toString( events[i].getCost());
           b_gross = Double.toString(events[i].getGross());
           b_net = Double.toString(events[i].getNet());
           b_id = Integer.toString(events[i].getID());
           
      
           bw.write("E");
           bw.write("|");
           bw.write(b_date);
           bw.write("|");
           bw.write(b_type);
           bw.write("|");
           bw.write(b_cost);
           bw.write("|");
           bw.write(b_gross);
           bw.write("|");
           bw.write(b_net);
           bw.write("|");
           bw.write(b_id);
           //bw.write("\t");
           
           
           bw.write("\n");
          
          }
            bw.close();
          


        


    }catch(IOException e){
            
            e.printStackTrace();
        }
            
       
 }

/**
*This method writes data about clubs into the text file
*@param Club clubs[] This is the array of clubs that must be added to the text file
*@param club_counter This is how many clubs have been created in this run of the program
@return nothing
*/

private void writer(Club clubs[], int club_counter){
 
       BufferedWriter bw = null;
       FileWriter fw = null;
       
       
       try{
           fw = new FileWriter(FileName,true);//true to append
           bw = new BufferedWriter(fw);
           
        
           
           
          
          for(int i = 0; i < club_counter ; i++){
           
           b_club = clubs[i].getClub();
           b_exec = clubs[i].getExec();
           b_id = Integer.toString(clubs[i].getId());

         
         
           bw.write("C");
           bw.write("|");
           bw.write(b_club);
           bw.write("|");
           bw.write(b_exec);
           bw.write("|");
           bw.write(b_id);
           bw.write("|");
         
           
           
           bw.write("\n");
          
        }
         bw.close();
      
        }catch(IOException e){
            
            e.printStackTrace();
        }
            
       
 }
    
/**
*This method allows a line or word to be replace by another 
*@param toUpdate This is the String that will be replaced
*@param updated This is the String that will replace the original String
*@return nothing
*/

private static void updateLine(String toUpdate, String updated)throws IOException{//used to delete/replace
      
      BufferedReader file = new BufferedReader(new FileReader(FileName));
      String line;
      String input = "";
      
      while((line = file.readLine()) != null)
        input += line + System.lineSeparator();
        
      input = input.replace(toUpdate,updated);
      
      FileOutputStream os = new FileOutputStream(FileName);
      os.write(input.getBytes());
      
      file.close();
      os.close();
      
      //Source: http://stackoverflow.com/questions/34845326/how-to-replace-a-line-with-a-new-line-using-java
      
      
    }

/**
*This method is used to test if a club  exists
*It returns true if the club is found
*It returns false if it is not found
*@param clubtoFind is the name of the club
*@return boolean This returns true or false

*/

 private static boolean exists(String clubtoFind){
        //use the finder method to find the club it will return true if the club is found within the text file (use the start to the first delimeter)
       if(finder(clubtoFind,"clubtoFind").equals("true")){
             
            return true;

          }
        
        else{ //club not found

            
            return false;

          }
       }
      
/**
 * This method searches the text file for the highest existing ID number
 * @return It returns the highest existing ID number 
 */private static String retID(){
    BufferedReader br = null;
      FileReader fr = null;
      String numID = null;
      String lastC= null;
      String LastID = "0";// if the file is null, then the ID count starts at zero

   
     try {

            fr = new FileReader(FileName);
            br = new BufferedReader(fr);
           
            
            String sCurrentLine;
           
    
            while ((sCurrentLine = br.readLine()) != null) {
                int first = ordinal(sCurrentLine, "|", 1);
       
                   if(first >= 0){ 
               
                       String check = sCurrentLine.substring(0,first);
              
                       if(check.equals("C")){//checks that the ID value found is one that belongs to a Club line, not an event Line
                    
                   
                           lastC = sCurrentLine;// holds the current line with each iteration, until the last (largest) value is left
                           int third = ordinal(lastC, "|", 3);
                           int fourth = ordinal(lastC, "|", 4);
                    
                           LastID = lastC.substring(third + 1 , fourth);//The line is then split to find the substring which contains the ID number
                    
                        }
              }
               
                
            }
            
              
        }catch(IOException e){
            e.printStackTrace();
            
        }
   
     return LastID;//this is the ID 
       
    }
    

    
    
}
