package houserent.view;

import houserent.domain.House;
import houserent.service.houseService;
import houserent.utils.Utility;

import java.util.Scanner;

/**
 * 1 显示主菜单
 * 2 接收用户输入
 * 3 调用Houseservice 实现房屋信息的各种操作
 */
public class houseView {
    public void mainMenu() {
        boolean loop = true;
        char key = ' ';
        do {
            System.out.println("----------房屋出租系统------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出");
            System.out.println("请输入需求");
            //接收用户输入
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouses();
                    break;
                case '2':
                    System.out.println("查 找 房 屋");
                    break;
                case '3':
                    System.out.println("删 除 房 屋");
                    break;
                case '4':
                    System.out.println("修 改 房 屋 信 息");
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    System.out.println("退 出");
                    break;
            }
        } while (loop);
    }

    houseService houseService = new houseService(10);

    public void listHouses() {
        System.out.println("------------------------房屋列表------------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();//得到所有房屋的信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                System.out.println(houses[i]);
            }
        }
        System.out.println("----------------------房屋列表完成------------------------");
    }

    public void addHouses() {

        System.out.println("---------------------添加房屋---------------------");
        System.out.println("姓名；" );
        String name = Utility.readString(7);
        System.out.println("电话：" );
        String phone = Utility.readString(7);
        System.out.println("地址：" );
        String address = Utility.readString(7);
        System.out.println("月租：" );
        int rent = Utility.readInt();
        System.out.println("状态（未出租/已出租）：" );
        String status = Utility.readString(7);
        House house = new House(5, name, phone, address, rent, status);
        if (houseService.addHouse(house)) {
            System.out.println("---------------------添加完成---------------------");
        }else {
            System.out.println("---------------------添加失败---------------------");
        }
    }
    public void deleteHouse(){
        System.out.println("----------------删除房屋--------------");
        System.out.println("请选择待删除房屋的编号（-1退出）：");
        int houseId;
        houseId = Utility.readInt();
        if (houseId == -1){
            System.out.println("退出删除");
        }
        System.out.println("请输入你的选择(Y/N)");
        char choice;
        choice = Utility.readChar();
        if (houseService.deleteHouse(1)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
