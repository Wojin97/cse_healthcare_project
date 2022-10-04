package Trainer_FoodManager;


public class FoodManager extends DietMenu{
  private FoodDBConnection dbc;
  private String id;
  private String name;
  private GoalBehavior  printGoal;
  

     public String getId() { 
         return id; 
     } 
     public String getName() {
         return name; 
     } 
     public void setId(String id) {
         this.id = id; 
     } 
     public void setPw(String name) {
         this.name = name; 
     }
     
     public void printGoal(){
         
        printGoal.goal();
     }
     @Override
     public void inquiryMenu(){
         
     }
  
}
