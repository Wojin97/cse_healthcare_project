package Trainer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 20173189 김예진
 */
// health 데이터 베이스에서 값을 가지고와서 화면의 테이블에 표시한다.
// 운동 목록
class Display_health_all extends Display_table {
    
 // 데이터를 가지고 오기위해 실행되는 문장 설정
  @Override
  protected void SetStatement() {
        query =  "select * from sedb.health";

  }
  
  // 화면의 테이블에 가지고 온 데이터를 추가
   protected void Addtablerow(){
      
       try {
          String health_name = rs.getString("HEALTH_NAME");
      
          model.addRow(new Object[] {health_name});
      } catch (SQLException ex) {
          Logger.getLogger(Display_trainer_member.class.getName()).log(Level.SEVERE, null, ex);
      }
      
  }
   
}


