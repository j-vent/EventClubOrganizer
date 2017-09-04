 import java.util.Scanner;

public class Event{
    
    private String date;
    private String type;
    private double cost;
    private double gross;
    private double net;
    private int club_id;
    
    private double m_Gross;
    
    //might need to change all cost to doubles
    
    public Event(String date, String type, double cost, double gross, double net, int club_id){
        
        
        this.date = date;
        this.type = type;
        this.cost = cost;
        this.gross = gross;
        this.net = net;
        this.club_id = club_id;
       
        
    }
    
    
    public void setDate(String date){
        
        date = date;
        
    }
    
    public String getDate(){
        
        //System.out.println("The date of the sale was: " + date1);
        return date;
    }
    
    
    public void setType(int p_type){
        
        int type = p_type;
        
    }
    
    public String getType(){
        
        //System.out.println("The cost of the sale was: $ " + cost);
        return type;
    }
    
    
    
    public void setCost(double p_cost){
        
        double cost = p_cost;
        
    }
    
    public double getCost(){
        
        //System.out.println("The cost of the sale was: $ " + cost);
        return cost;
    }
    
    
    
     public void setGross(double p_gross){//prev: double p_gross
        
        //double gross = p_gross;
        double gross = p_gross;
        
    }
    
    public double getGross(){
        
        //System.out.println("The cost of the sale was: $ " + cost);
        return gross;
    }
    
    
     public void setNet(double p_Net){
        
        double net = p_Net ;
        
    }
    
    public double getNet(){
        
        //System.out.println("The cost of the sale was: $ " + cost);
        return net;
    }
    
       
     public void setID(int pclub_id){
        
        this.club_id = pclub_id ;
        
    }
    
    public int getID(){
        
        return club_id;
    }
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
