/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import static Login.DBConnection.sqlDriver;
import static Login.DBConnection.sqlId;
import static Login.DBConnection.sqlPw;
import static Login.DBConnection.sqlURL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 한슬기
 */
public class Admin extends Users{
    private String id;
    private String pw;
    private String name;
    public Admin(){
    }
    public Admin(String id,String pw){
        this.id=id;
        this.pw=pw;
    }
    public Admin(String name,String id,String pw){
        this.name=name;
        this.id=id;
        this.pw=pw;
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
     public void display(){
         System.out.println("관리자입니다.");
     }
}
