package Trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 20173189 김예진
 */
public abstract class Display_table {
    
    
    frame_values framevaluse;// 프레임안의 값들
    JTable whosetable; //템플릿이 적용되는 테이블
    String url; 
    String query ; 
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model; 
    
    // 서브 클래스에서 콩동적으로 동작되는 알고리즘
  public final void startdisplay(frame_values tfv) throws ClassNotFoundException, SQLException {
      
      Get_framevalues(tfv); 
      Rest_table();
      GetConnection();
      SetStatement();
      SetTable();
   
  }

  // 화면 테이블이 어떤 것인지 값을 받는다.
  public void Get_framevalues(frame_values tfv) {
        framevaluse = tfv ;
  }
  
  // 화면의 테이블을 초기화한다.
    public void Rest_table(){
         
           model = (DefaultTableModel) framevaluse.table.getModel();
          for (int i = 0; i < model.getRowCount();) {
             model.removeRow(0);
          }
    }
    
    // 테이버 베이스와 연결한다.
  public void GetConnection() throws ClassNotFoundException, SQLException {
             Class.forName("com.mysql.cj.jdbc.Driver");
             url = "jdbc:mysql://localhost:3306/sedb?serverTimezone=UTC"; 
             con = DriverManager.getConnection(url, "root", "yejin123"); 
  }

  //  데이터베이스에 실행될 문장
  protected abstract void SetStatement() ;

  protected abstract void Addtablerow();
  
  // 화면의 테이블  값설정
  public void SetTable() {
      
    try {
          stmt = con.createStatement(); 
          rs = stmt.executeQuery(query);
          
          while(rs.next()) {
              
              Addtablerow();
          }
          
          model.fireTableDataChanged();
          rs.close();
      } catch (SQLException ex) {
          Logger.getLogger(Display_trainer_all.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  
}
