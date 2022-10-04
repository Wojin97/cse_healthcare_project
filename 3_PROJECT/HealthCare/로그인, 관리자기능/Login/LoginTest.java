/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.Scanner; 
import Login.UsersDB; 
import Login.Users;
/**
 *
 * @author 한슬기
 */
public class LoginTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        //Member dao= new Member();
        Scanner scan = new Scanner(System.in);
	int cmdNo = 0;
        
        UsersDB dao = new UsersDB();
	while (true) {
            System.out.println("");
            System.out.println("원하는 메뉴를 선택하십시오.");
            System.out.println("1.회원가입 2.로그인  3.종료");
            cmdNo = scan.nextInt();
            
            if (cmdNo == 1) {
                 dao.insertMethod(); // 입력 클래스의 객체 생성
            }
	    else if (cmdNo == 2) {
		
                 ArrayList<Users> members = new ArrayList<Users>();
                 try { 
                    members = dao.getMembers();
                    for(int i=0; i<members.size();i++) 
                    map.put(members.get(i).getId(),members.get(i).getPw()); 
                    Scanner s = new Scanner(System.in); // 화면으로부터 라인단위로 입력받는다.
                    while(true) { 
                        System.out.println("아이디 제한조건은 다음과 같습니다."+"\n");
                        System.out.println("관리자 : a000, 트레이너 : t000, 회원 : h000."+"\n");
                        System.out.println("ID, Password를 입력해주세요.");
                        System.out.print("ID :"); 
                        String id = s.nextLine().trim(); 
                        System.out.print("Password :"); 
                        String password = s.nextLine().trim();
                        System.out.println(); 
                        if(!map.containsKey(id)) { 
                        System.out.println("로그인 실패"+"\n");
                        System.out.println("입력하신 아이디는 존재하지 않습니다. 다시 입력해주세요.");
                        continue;
                        } else { 
                            if(!(map.get(id)).equals(password)) { 
                                System.out.println("로그인 실패"+"\n");
                                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                            } else { 
                                System.out.println("로그인 성공"+"\n");
                                System.out.println("아이디와 비밀번호가 일치합니다.");
                                who use=new who(id,password);
                                use.whoer(id,password);
                                break;
                            } 
                        } 
                    } // while
                } catch(SQLException e) {
                    System.out.println("예외처리 5:"+e.getMessage());// 예외 메시지 (console) 인쇄 
                    e.printStackTrace();
                }catch(Exception e) {
                    System.out.println("예외처리 6:"+e.getMessage());
                    e.printStackTrace();       
                }
            }
            else {
		scan.close();
                    System.out.println("종료합니다.");
                 break;
            }
        
        }
    
    }
}
