/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.Scanner;

/**
 *
 * @author 한슬기
 */
public class who {
    String id;
    String pw;
    String name;
    int cmdNo = 0;
    Scanner scan = new Scanner(System.in);
    public who(String id,String pw){
        this.id=id;
        this.pw=pw;
    }
    public who(String name, String id,String pw){
        this.name=name;
        this.id=id;
        this.pw=pw;
    }
    public void whoer(String id,String pw){
        if(id.contains("h")){
            Users use=new Member(name,id,pw);
            //Member use=new Member(id,pw);
            use.display();
                while (true) {
                    System.out.println("");
                    System.out.println("원하는 메뉴를 선택하십시오.");
                    System.out.println("1.종료 2.로그아웃 ");
                    cmdNo = scan.nextInt();
            
                    if (cmdNo == 1) {
                        System.out.println("종료");
                        scan.close();
                    }else if (cmdNo == 2) {
                        //System.out.println("로그아웃 되었습니다.");
                        use.logOut();
                        break;
                    }
                }
            }else if(id.contains("t")){
                while (true) {
                    Users train=new Trainer(name,id,pw);
                    train.display();
                    System.out.println("");
                    System.out.println("원하는 메뉴를 선택하십시오.");
                    System.out.println("1.종료 2.로그아웃 ");
                    cmdNo = scan.nextInt();
                    
                    if (cmdNo == 1) {
                        System.out.println("종료");
                        scan.close();
                    }else if (cmdNo == 2) {
                        //System.out.println("로그아웃 되었습니다.");
                        train.logOut();
                    break;
                    }
                }
            //UsersDB dao = new UsersDB();
            
            }else{
                Users adm=new Admin(name,id,pw);
                adm.display(); 
            }
    }
}
