package Trainer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 20173189 ±è¿¹Áø
 */
public class Display_trainer_member_forcheck extends Display_table {

  @Override
  protected  void SetStatement() {
      
   //    String getname = frame_values.getUser_name();
       query =  "select * from sedb.trainer ";
  
  }
  protected void Addtablerow(){
      
      try {
            String user_id = rs.getString("USER_ID");
            String health_name = rs.getString("HEALTH_NAME");
            String health_set = rs.getString("HEALTH_SET");
            String health_count = rs.getString("HEALTH_COUNT");
            String health_time = rs.getString("HEALTH_TIME");
            Boolean work_check = rs.getBoolean("WORK_CHECK");
            
            model.addRow(new Object[] {user_id,health_name,health_set,health_count,health_time,work_check});
      } catch (SQLException ex) {
          Logger.getLogger(Display_trainer_member.class.getName()).log(Level.SEVERE, null, ex);
      }
      
  }

}
