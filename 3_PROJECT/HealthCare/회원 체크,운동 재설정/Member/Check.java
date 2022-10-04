package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 20173189 김예진
 */
//  yes, no의 동작은 이 클래스에서 작성된다.

// 실질적인 기능 수행을 적는 클래스

public class Check {
  
    // 체크 클래스에서 필요한 변수
    // 화면 테이블에서 선택된 행의 값 , 운동이름, 체크 여부
  boolean member_check ;
  String health_name;
  int selected_row_Index = 0;
  static public String user_id;
  
  // 프레임의 테이블에서 선택된 행의 3번째 열 값을 가지고 와서 yes,no로 바꿔야한다.
  public Check( JTable member_screen_member_check_table ) {
     
     // 테이블의 내용을 가지고 온다.
     // DefaultTableModel model = (DefaultTableModel) member_screen_member_check_table.getModel();
     // 화면 테이블에서 선택된 체크 버튼의 값을 가지고 온다.
     // getValueAt(selected_row_Index,2) : 테이블의 선택된 값 가지고 오는 함수 (행, 열)
     // 선택된 행의 값
     selected_row_Index= member_screen_member_check_table.getSelectedRow();
     member_check = (boolean) member_screen_member_check_table.getValueAt(selected_row_Index,5); 
     health_name =  (String) member_screen_member_check_table.getValueAt(selected_row_Index,1); 
     user_id =  (String) member_screen_member_check_table.getValueAt(selected_row_Index,0); 
  }

  
  public void yes() {
     // 3번째 열의 값이 ( 체크 값) 1이면 member_check 테이블에 work_check에 1값을 넣는다.
        // 템플릿 메서드로 으로 간단하게 만들기
        try{
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sedb?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "yejin123");
           
            PreparedStatement update = con.prepareStatement("UPDATE sedb.trainer SET work_check=  1 WHERE health_name = ? and user_id =?");
            update.setString(1, health_name);
             update.setString(2, user_id);
            update.executeUpdate();
            System.out.println("데이터가 변경되었습니다.");
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        } 
    
  }

  public void no() {
      // 3번째 열의 값이 ( 체크 값) 0이면 member_check 테이블에 work_check에 0값을 넣는다.
        try{
           
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sedb?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "yejin123");
           
            PreparedStatement update = con.prepareStatement("UPDATE sedb.trainer SET work_check=  0 WHERE health_name = ? and user_id =?");
             update.setString(1, health_name);
             update.setString(2, user_id);
            update.executeUpdate();
            System.out.println("데이터가 변경되었습니다.");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
  }

}
