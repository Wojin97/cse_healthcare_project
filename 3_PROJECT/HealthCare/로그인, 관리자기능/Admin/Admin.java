/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author 한슬기
 */
public class Admin extends UserBehavior{
    private String name;
    private String id;
    private String pw;
    public Admin(){
    }
    public Admin(String id, String pw){
        this.id=id;
        this.pw=pw;
    }
    public Admin(String id, String pw,String name){
        this.id=id;
        this.pw=pw;
        this.name=name;
    }
     public String getId() { 
         return id; 
     } 
     public String getPw() {
         return pw; 
     } 
     public String getName() {
         return name; 
     } 
     public void setId(String id) {
         this.id = id; 
     } 
     public void setPw(String pw) {
         this.pw = pw; 
     } 
     public void setName(String name) {
         this.name = name; 
     }
//     public void display(){
//         System.out.println("관리자입니다.");
//     }
}

