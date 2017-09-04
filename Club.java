public class Club{
    private String clubname;
    private String exec;
    private int id;
    //private String exec2;
    public Club(String clubname, String exec, int id){
        //System.out.println("The name of the club is: " + name);
        //System.out.println("The names of the executives are: " + exec1 + " and " + exec2);
        //System.out.println("The date of the first sale is (dd/mm/yy): " + s_date1 + "to " +e_date1);
        
        //more things to construct: gross, net, cost, what did they sell
        
        //exec2 = p2;
        
       this.clubname = clubname;
       this.exec = exec;
       this.id = id;
    }
    
    public void setClub(String name){
        
       clubname = name;
       
    }
    
    public String getClub(){
        
      return clubname;
      
    }
    
    public void setExec(String p1){
        
        exec = p1;     
        
    }
    
    public String getExec(){
        
        
        return exec;   
        
        
    }
    
    public void setId(int num){
        
        id = num;
    }
    
    
    public int getId(){
        
       return id;
    }
    
    
    
    
    
    
    
    
}

