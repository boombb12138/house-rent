package houserent.service;

import houserent.domain.House;
import houserent.view.houseView;

/**
 * 1 定义房屋数组
 * 2 实现对房屋数组的增删改查
 * 3 响应 houseView 的调用
 */
public class houseService {

    private House[] houses;
    int count = 1;//用于表示 目前有多少房子
    int houseId = 1;//用于表示 房子的id

    public houseService(int houseNum) {
        houses = new House[houseNum];
        houses[0] = new House(1, "nancy", "219999", "海淀区", 900, "已出租");
    }

    public House[] list() {
        return houses;
    }

    //添加房子信息的方法
    public boolean addHouse(House newhouse) {
        //判断是否还可以再添加
        if (count == houses.length) {
            System.out.println("已满，不能再添加");
            return false;
        }
        //将新增的房子添加到已有的房子后面
        houses[count] = newhouse;
        count++;
        //更新房子的id
        houseId++;
        newhouse.setId(houseId);
        return true;
    }

    public boolean deleteHouse(int houseId) {
        int index = -1;
        //房子的下标 不等于 房子的编号减1
        for (int i = 0; i < houses.length; i++) {
            if (houseId == houses[i].getId()){
                index = i;
                houses[i] = houses[i + 1];
            }else {
                houses[i] = houses[i + 1];
            }
        }
        if (index == -1){
            return false;
        }
    }
}
