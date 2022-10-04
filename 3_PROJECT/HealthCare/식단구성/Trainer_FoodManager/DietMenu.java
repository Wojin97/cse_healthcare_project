package Trainer_FoodManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Trainer_FoodManager.FoodDBConnection.sqlDriver;
import static Trainer_FoodManager.FoodDBConnection.sqlId;
import static Trainer_FoodManager.FoodDBConnection.sqlPw;
import static Trainer_FoodManager.FoodDBConnection.sqlURL;
import java.util.Scanner;

public class DietMenu implements FoodDBConnection {

    @Override
    public Connection getConnection() {
        Connection con = null;
        //String driver = "com.mysql.cj.jdbc.Driver";
        //String url = "jdbc:mysql://localhost:3306/healthdb?serverTimezone=UTC";
        try {
            Class.forName(sqlDriver); // JDBC Driver 검색
            con = DriverManager.getConnection(sqlURL, sqlId, sqlPw); // JDBC URL -> DB 연결 
        } catch (ClassNotFoundException e) { // JDBC driver 부재시 예외처리 
            System.out.println("예외처리 1:" + e.getMessage()); // 예외 메시지 (console) 인쇄 
            e.printStackTrace();
        } catch (Exception e) { // 모든 예외상황 처리 
            System.out.println("예외처리 2:" + e.getMessage());
            e.printStackTrace();
        } finally { // 
            System.out.println("JDBC연결되었습니다");
        }
        return con;
    }

    public void insertMenu() {
        System.out.println("식단을 구성합니다" + "\n");
        Scanner scan = new Scanner(System.in);
        String sql1 = "SELECT * FROM admin";
        String sql2 = "INSERT INTO diet(user_id,user_name,week, Breakfast, lunch, dinner, total_kcal ) VALUES((SELECT user_id FROM admin WHERE user_id=?), (SELECT user_name FROM admin WHERE user_name=?),?,?,?,?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(sqlDriver); // JDBC Driver 검색
            con = DriverManager.getConnection(sqlURL, sqlId, sqlPw); // JDBC URL -> DB 연결 
            pstmt = con.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("USER_NAME");
                String id = rs.getString("USER_ID");
                String pw = rs.getString("USER_PW");

                System.out.println(name + "\t" + id + "\t" + pw);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Class.forName(sqlDriver);
            con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
            pstmt = con.prepareStatement(sql2);

            System.out.printf("회원의 아이디를 입력해주세요 : ");
            String id = scan.next();
            System.out.printf("회원의 이름을 입력하세요: ");
            String name = scan.next();
            System.out.printf("식단을 구성할 요일을 입력하세요 : ");
            String week = scan.next();
            System.out.printf("아침에 먹어야할 음식을 입력하세요 : ");
            String Breakfast = scan.next();
            System.out.printf("점심에 먹어야할 음식을 입력하세요 : ");
            String lunch = scan.next();
            System.out.printf("저녁에 먹어야할 음식을 입력하세요 : ");
            String dinner = scan.next();
            System.out.printf("칼로리 입력하세요 : ");
            String total_kcal = scan.next();

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, week);
            pstmt.setString(4, Breakfast);
            pstmt.setString(5, lunch);
            pstmt.setString(6, dinner);
            pstmt.setString(7, total_kcal);

            int cnt = pstmt.executeUpdate();
            System.out.println(cnt + "건이 실행되었습니다.");

            rs = pstmt.executeQuery("SELECT *FROM diet");
            rs.beforeFirst();
            while (rs.next()) {
                String a = rs.getString("USER_ID");
                String b = rs.getString("USER_NAME");
                String c = rs.getString("week");
                String d = rs.getString("Breakfast");
                String e = rs.getString("lunch");
                String f = rs.getString("dinner");
                String g = rs.getString("total_kcal");

                System.out.println(a + "\t" + b + "\t" + c
                        + "\t" + d + "\t" + e + "\t" + f
                        + "\t" + g + "");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            while (rs.next()) {
                String a = rs.getString("USER_ID");
                String b = rs.getString("USER_NAME");
                String c = rs.getString("week");
                String d = rs.getString("Breakfast");
                String e = rs.getString("lunch");
                String f = rs.getString("dinner");
                String g = rs.getString("total_kcal");

                System.out.println(a + "\t" + b + "\t" + c
                        + "\t" + d + "\t" + e + "\t" + f
                        + "\t" + g);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e) {
            }
        }

    }

    public void inquiryMenu() {
        System.out.println("회원의 식단을 조회합니다" + "\n");
        String sql3 = "SELECT * FROM diet";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(sqlDriver);
            con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
            pstmt = con.prepareStatement(sql3);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("USER_NAME");
                String id = rs.getString("USER_ID");
                String week = rs.getString("week");
                String bre = rs.getString("Breakfast");
                String lun = rs.getString("lunch");
                String din = rs.getString("dinner");
                String kcal = rs.getString("total_kcal");

                System.out.println(name + "\t" + id + "\t" + week
                        + "\t" + bre + "\t" + lun + "\t" + din
                        + "\t" + kcal + "");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
    public void deleteMenu() {
        Scanner scan = new Scanner(System.in);
        String sql4 = "DELETE FROM diet WHERE USER_ID = ?";
        String id = "";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(sqlDriver);
            con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
            pstmt = con.prepareStatement(sql4);

            System.out.println("Choose ID for Delete Diet Food ");
            id = scan.next();

            pstmt.setString(1, id);
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public ArrayList<FoodManager> getFood() throws SQLException, Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        //Statement pstmt = null;
        ResultSet rs = null;

        ArrayList<FoodManager> members = new ArrayList<FoodManager>();
        FoodManager food;
        // DB Table 의 1개의 레코드(record : row)를 불러오기 위한 temp(임시) 변수 

        con = getConnection();
        String sql = "SELECT * FROM Admin";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                food = new FoodManager();// temp 
                food.setId(rs.getString("USER_ID")); // id 필드값을 가져옴 
                food.setPw(rs.getString("USER_PW")); // pw 필드값을 가져옴 
                members.add(food);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("예외처리 3:" + e.getMessage());
            // 예외 메시지 (console) 인쇄 
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("예외처리 4:" + e.getMessage());
            e.printStackTrace();
        }
        return members;
    }

}
