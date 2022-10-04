/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trainer_FoodManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

import Trainer_FoodManager.DietMenu;
import Trainer_FoodManager.FoodManager;

/**
 *
 * @author user
 */
public class Trainer_FoodManageMent_TestDriver {

    public static void main(String[] args) {
        //   HashMap<String, String> map = new HashMap<String, String>();

        Scanner scan = new Scanner(System.in);
        int cmdNo = 0;
        DietMenu DM = new DietMenu();
        //FoodManager manager=new FoodManager();
        //manager.printGoal();
        
        while (true) {
            System.out.println("");
            System.out.println("★ MEMBER DIET FOOD MANAGEMENT ★");
            System.out.println("1.Member Inquiry and Diet Food Manage 2.Diet Food of Member 3.Delete of Member Diet Food 4. Quit");
            cmdNo = scan.nextInt();

            if (cmdNo == 1) {
                DM.insertMenu(); // 식단 입력 클래스 객체 생성
            } else if (cmdNo == 2) {
                DM.inquiryMenu(); // 식단 조회 클래스 객체 생성
            } else if (cmdNo == 3) {
                DM.deleteMenu(); //식단 삭제 클래스 객체 생성
            } else {
                scan.close();
                System.out.println("종료합니다.");
                break;
            }

        }
    }
}
