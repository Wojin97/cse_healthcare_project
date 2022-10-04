/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 한슬기
 */
public interface DBConnection {
    static final String sqlDriver="com.mysql.cj.jdbc.Driver";
    static final String sqlURL="jdbc:mysql://localhost:3306/healthdb?serverTimezone=UTC";
    static final String sqlId="root"; 
    static final String sqlPw="dkfmatmd1"; // JDBC 연결 메소드(method) 
    public Connection getConnection() throws ClassNotFoundException, Exception; // 인원현황을 얻어오는 메소드 : select * from member2
    public ArrayList<Users> getMembers() throws SQLException, Exception; 
    public void insertMethod();
}
