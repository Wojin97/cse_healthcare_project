/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.util.Scanner;

/**
 *
 * @author 한슬기
 */
public class AdminTestDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("관리자 권한입니다.");
       Scanner scan = new Scanner(System.in);
		int cmdNo = 0;
                 Admin ad=new Admin();
                 //Admin ad=new Admin(id,pw);
		while (true) {
			System.out.println("");
			System.out.println("원하는 메뉴를 선택하십시오.");
			System.out.println("1.사용자 조회 2.사용자 수정 3.사용자 삭제 4.사용자 추가 5.종료");
			cmdNo = scan.nextInt();

			if (cmdNo == 1) {
                                ad.userInquiry();
			}
			else if (cmdNo == 2) {
                                ad.userUpdate();
			}
			else if (cmdNo == 3) {
                                ad.userDelete();
			}
			else if (cmdNo == 4) {
                                ad.userInsert();	
			}
			else {
				scan.close();
                                 System.out.println("종료합니다.");
			break;
			}			
		}
    }
    
}
