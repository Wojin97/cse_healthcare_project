/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import static Login.DBConnection.sqlDriver;
import static Login.DBConnection.sqlId;
import static Login.DBConnection.sqlPw;
import static Login.DBConnection.sqlURL;
import java.util.Scanner;
/**
 *
 * @author 한슬기
 */
public class UsersDB implements DBConnection{
     @Override 
    public Connection getConnection() throws ClassNotFoundException, Exception {
        Connection con = null;
         //String driver = "com.mysql.cj.jdbc.Driver";
         //String url = "jdbc:mysql://localhost:3306/sedb?serverTimezone=UTC";
        try{ 
            Class.forName(sqlDriver); // JDBC Driver 검색
            con = DriverManager.getConnection(sqlURL,sqlId,sqlPw); // JDBC URL -> DB 연결 
        } catch(ClassNotFoundException e){ // JDBC driver 부재시 예외처리 
            System.out.println("예외처리 1:"+e.getMessage()); // 예외 메시지 (console) 인쇄 
            e.printStackTrace(); 
        } catch(Exception e){ // 모든 예외상황 처리 
            System.out.println("예외처리 2:"+e.getMessage());
            e.printStackTrace(); 
        } finally { // 
            System.out.println("JDBC연결되었습니다"); 
        } 
        return con; 
    }
    public void insertMethod() {	
                 System.out.println("아이디 제한조건은 다음과 같습니다."+"\n");
                 System.out.println("관리자 : a000, 트레이너 : t000, 회원 : h000."+"\n");
		Scanner scan = new Scanner(System.in);
		String sql = "INSERT INTO admin(USER_NAME,USER_ID,USER_PW) VALUES(?, ?, ?)";			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(sqlDriver); // JDBC Driver 검색
                         con = DriverManager.getConnection(sqlURL,sqlId,sqlPw); // JDBC URL -> DB 연결 
			pstmt = con.prepareStatement(sql);
			
			System.out.printf("이름을 입력하세요 : ");
			String name = scan.next();
			System.out.printf("아이디를 입력하세요 : ");
			String id = scan.next();			
			System.out.printf("비밀번호를 입력하세요 : ");
			String pw = scan.next();			
			
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
		
			int cnt = pstmt.executeUpdate(); 
                         System.out.println("회원가입성공!");
			System.out.println("이름: "+name+"\nID : "+id+"\nPassword: "+pw);			
                        
		}
		catch (Exception e) {System.out.println(e.getMessage());}
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
			}
		}
    }
    @Override 
    public ArrayList<Users> getMembers() throws SQLException, Exception { 
        Connection con = null;
        PreparedStatement pstmt = null; 
        //Statement pstmt = null;
        ResultSet rs = null; 
        
        ArrayList<Users> members = new ArrayList<Users>(); 
        Users member; 
        // DB Table 의 1개의 레코드(record : row)를 불러오기 위한 temp(임시) 변수 
        
        con = getConnection();
        String sql = "SELECT * FROM Admin";
        try { 
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();           
            
            
            while(rs.next()){ 
                member = new Users();// temp 
                member.setId(rs.getString("USER_ID")); // id 필드값을 가져옴 
                member.setPw(rs.getString("USER_PW")); // pw 필드값을 가져옴 
                members.add(member); 
            }  
            rs.close(); 
            pstmt.close();
            con.close();
        }catch(SQLException e) {
            System.out.println("예외처리 3:"+e.getMessage()); 
            // 예외 메시지 (console) 인쇄 
            e.printStackTrace(); 
        } catch(Exception e) { 
            System.out.println("예외처리 4:"+e.getMessage()); 
                e.printStackTrace(); 
        } return members; 
    }

}
