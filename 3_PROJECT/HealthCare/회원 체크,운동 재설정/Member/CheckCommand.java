package Member;
//  실제 기능과 연결하는 command 클래스
// 버튼이 어떤 버튼인지 알고 있어야하고, 그 버튼의 기능과 이 클래스를 연결한다.
/**
 *
 * @author 20173189 김예진
 */
public class CheckCommand implements Command {
 
    private Check check ;
 
  public CheckCommand( Check check) {
      this.check = check;
  }

  public void execute( ) {
       // 체크 버튼 상황(0,1)에 따라 기능이 달라진다.
      if( check.member_check == true )
      { 
          check.yes();
     
      }else {
          check.no();
      
       }
      
  }

  

}
