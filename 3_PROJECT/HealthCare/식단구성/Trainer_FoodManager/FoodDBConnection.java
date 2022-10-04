package Trainer_FoodManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodDBConnection {

    static final String sqlDriver = "com.mysql.cj.jdbc.Driver";
    static final String sqlURL = "jdbc:mysql://localhost:3306/healthdb?serverTimezone=UTC";
    static final String sqlId="root"; 
    static final String sqlPw="dkfmatmd1"; // JDBC 연결

    public Connection getConnection() throws ClassNotFoundException, Exception;    
    public ArrayList<FoodManager> getFood() throws SQLException, Exception; 
    public void insertMenu();
    public void inquiryMenu();
    public void deleteMenu();
}
