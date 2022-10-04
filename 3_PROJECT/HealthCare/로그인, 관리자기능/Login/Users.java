/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author 한슬기
 */
public class Users {
    
     private String id; // id field (varchar2(20) : PK) 
     private String pw; // pw field (varchar2(20)) 
     private DBConnection dbc;
     public String getId() { 
         return id; 
     } 
     public String getPw() {
         return pw; 
     } 
     public void setId(String id) {
         this.id = id; 
     } 
     public void setPw(String pw) {
         this.pw = pw; 
     }
     public void display(){
         System.out.println("헬스케어 사용자입니다.");
     }
     public void logOut(){
          System.out.println("로그아웃 되었습니다.");
      }
     
}
