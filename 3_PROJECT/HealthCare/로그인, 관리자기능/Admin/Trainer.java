/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author 한슬기
 */
public class Trainer implements SeeViewer,Observer{
    private String name;
    private String id;
    private String pw;
    private Admin ad;
    public Trainer(){
    }

    public Trainer(String id, String pw){
        this.id=id;
        this.pw=pw;
    }
    public Trainer(String id, String pw,String name){
        this.id=id;
        this.pw=pw;
        this.name=name;
    }
    public Trainer(Admin ad){
        this.ad=ad; 
    }
    @Override
    public void display(){
        System.out.println(name+"트레이너의 데이터 추가변동이 생겼습니다.");
    }
    @Override
    public void update(String id,String pw,String name){
         if(id.contains("t")){   
             display();
         }
    }
}
