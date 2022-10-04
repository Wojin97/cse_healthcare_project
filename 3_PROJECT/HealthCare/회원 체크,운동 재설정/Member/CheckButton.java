package Member;
// 인보커. 명령하라고 전달해준다.
/**
 *
 * @author 20173189 김예진
 */
public class CheckButton {
  
  private Command command;
 
  CheckButton() {
      
  }

  public void setCommand(Command command) {
         this.command = command;
  }

  public void buttonWasPressed() {
      command.execute();
  }

  

}
