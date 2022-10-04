package Trainer;

import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author 20173189 ±è¿¹Áø
 */
public class frame_values {
    
    static String user_id;
    static String user_name;
    String health_name;
    String health_set;
    String health_count;
    String health_time;
    JTable table;

    public void setTable(JTable table) {
        this.table = table;
    }

        
    public void setUser_id(JTextField id) {
        this.user_id = id.getText();
    }
    
      static  public void setUser_id(String id) {
        frame_values.user_id = id;
      }
      
    public void setUser_name(JTextField name) {
        this.user_name = name.getText();
    }

    public void setHealth_name(JTextField health_name) {
        this.health_name = health_name.getText();
    }

    public void setHealth_set(JTextField health_set) {
        this.health_set = health_set.getText();
    }

    public void setHealth_count(JTextField health_count) {
        this.health_count = health_count.getText();
    }

    public void setHealth_time(JTextField health_time) {
        this.health_time = health_time.getText();
    }

    public String getUser_id() {
        return user_id;
    }

    public static String getUser_name() {
        return user_name;
    }

    public String getHealth_name() {
        return health_name;
    }

    public String getHealth_set() {
        return health_set;
    }

    public String getHealth_count() {
        return health_count;
    }

    public String getHealth_time() {
        return health_time;
    }
    
       public JTable getTable() {
        return table;
    }
    
    
}
