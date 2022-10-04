/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;


import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author 한슬기
 */
public abstract class DBConnection {
    static final String sqlDriver="com.mysql.cj.jdbc.Driver";
    static final String sqlURL="jdbc:mysql://localhost:3306/healthdb?serverTimezone=UTC";
    static final String sqlId="root"; 
    static final String sqlPw="dkfmatmd1"; // JDBC 연결 메소드(method) 
    protected Observer observer;
    
    abstract public void userInsert();
    abstract public void userInquiry();
    abstract public void userUpdate();
    abstract public void userDelete();
}
