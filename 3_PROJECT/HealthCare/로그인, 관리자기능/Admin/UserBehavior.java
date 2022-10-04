/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import static Admin.DBConnection.sqlDriver;
import static Admin.DBConnection.sqlId;
import static Admin.DBConnection.sqlPw;
import static Admin.DBConnection.sqlURL;
import Admin.Member; 
/**
 *
 * @author 한슬기
 * public void userInsert();
    public void userInquiry();
    public void userUpdate();
    public void userDelete();
 */
public class UserBehavior extends DBConnection{
    private String id;
    private String pw;
    private String name;

    @Override
    public void userInquiry(){
		String sql = "SELECT * FROM Admin";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(sqlDriver);
			con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				String name = rs.getString("USER_NAME"); 
				String id = rs.getString("USER_ID"); 
				String pw = rs.getString("USER_PW");
				
				System.out.println(name + "\t" + id + "\t" + pw );
                                
			}
		}		
		catch (Exception e) {
                    System.out.println(e.getMessage());
                }finally {
			try {rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {}
		}
    }
    @Override 
    public void userInsert() {
        Scanner scan = new Scanner(System.in);
		String sql = "INSERT INTO admin(USER_NAME,USER_ID,USER_PW) VALUES(?, ?, ?)";			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(sqlDriver);
			con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
			pstmt = con.prepareStatement(sql);
			System.out.println("사용자 추가합니다.");
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
			System.out.println(cnt + "건이 실행되었습니다.");	
                        if(id.contains("h")){
                             Member mem=new Member(id,pw,name);
                             mem.update(id,pw,name);
                         }else if(id.contains("t")){
                             Trainer trainer=new Trainer(id,pw,name);
                             trainer.update(id,pw,name);
                         }
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
    public void userUpdate() {
        Scanner scan = new Scanner(System.in);
		String sql = "UPDATE Admin SET USER_NAME = ?, USER_PW = ? WHERE USER_ID = ?";			
		Connection con = null;
		PreparedStatement pstmt = null;		
		try {
			Class.forName(sqlDriver);
			con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
			pstmt = con.prepareStatement(sql);
			System.out.println("사용자 수정입니다.");
			System.out.printf("아이디 입력하세요: ");
			String id = scan.next();
			System.out.printf("변경할 이름을 입력하세요: ");
			String name = scan.next();			
			System.out.printf("변경할 비밀번호을 입력하세요: ");
			String pw = scan.next();	
                         
                         pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, id);
			int cnt = pstmt.executeUpdate(); 
                         
			System.out.println(cnt + "건이 실행되었습니다.");
                        if(id.contains("h")){
                             Member mem=new Member(id,pw,name);
                             mem.update(id,pw,name);
                         }else if(id.contains("t")){
                             Trainer trainer=new Trainer(id,pw,name);
                             trainer.update(id,pw,name);
                         }
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
    public void userDelete() {
        Scanner scan = new Scanner(System.in);
		String sql = "DELETE FROM Admin WHERE USER_ID = ?";
		String id = "";
                
		Connection con = null;
		PreparedStatement pstmt = null;		
		try {
			Class.forName(sqlDriver);
			con = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
			pstmt = con.prepareStatement(sql);
			
			System.out.print("삭제할 아이디를 입력하세요 : ");
			id = scan.next();
			
			pstmt.setString(1, id);
			int cnt = pstmt.executeUpdate(); 
			System.out.println(cnt);
                        
                         if(id.contains("h")){
                             Member mem=new Member(id,pw,name);
                             System.out.println(id+"삭제되었습니다.");
                         }else if(id.contains("t")){
                             Trainer trainer=new Trainer(id,pw,name);
                             System.out.println(id+"삭제되었습니다.");
                         }
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
}
