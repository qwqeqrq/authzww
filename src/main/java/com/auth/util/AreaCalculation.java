package com.auth.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zww on 2019-03-11.
 */
public class AreaCalculation {


    //还需要一个方法，能将输入的坐标进行逆时针排序
    public static double[][] antiClockWiseSort(double[][] coordinate) {
        if (coordinate == null || coordinate.length == 0) {
            return null;
        }
        //对X坐标进行降序排列
        for (int i = 0; i < coordinate.length; i++) {
            for (int j = i + 1; j < coordinate.length; j++) {
                if (coordinate[i][0] < coordinate[j][0] /*&& coordinate[i][1]<coordinate[j][1]*/) {
                    double x = coordinate[i][0];
                    double y = coordinate[i][1];
                    coordinate[i][0] = coordinate[j][0];
                    coordinate[i][1] = coordinate[j][1];
                    coordinate[j][0] = x;
                    coordinate[j][1] = y;
                }
            }
        }
        for (int i = 0; i < coordinate.length; i++) {
            System.out.println(coordinate[i][0] + "--" + coordinate[i][1]);
        }
        System.out.println("-----------------------------");
        //对x相同的Y进行升序排列
        for (int i = 0; i < coordinate.length - 1; i++) {
            for (int j = i + 1; j < coordinate.length; j++) {
                double x = coordinate[i][0];
                double y = coordinate[i][1];
                if (x == coordinate[i + 1][0] && y > coordinate[j][1]) {
                    coordinate[i][0] = coordinate[j][0];
                    coordinate[i][1] = coordinate[j][1];
                    coordinate[j][0] = x;
                    coordinate[j][1] = y;
                }
            }
        }
        for (int i = 0; i < coordinate.length; i++) {
            System.out.println(coordinate[i][0] + "--" + coordinate[i][1]);
        }
        System.out.println("-----------------------------");
        //在判断最后一组最小的两个有没有相同的X坐标 这时候需要进行单独交换(达到最终的逆时针)
        for (int i = 0; i < coordinate.length - 1; i++) {
            for (int j = i + 1; j < coordinate.length; j++) {
                double x = coordinate[i][0];
                double y = coordinate[i][1];
                if (x == coordinate[coordinate.length - 1][0] && y < coordinate[j][1]) {
                    coordinate[i][0] = coordinate[j][0];
                    coordinate[i][1] = coordinate[j][1];
                    coordinate[j][0] = x;
                    coordinate[j][1] = y;
                }
            }
        }

        for (int i = 0; i < coordinate.length; i++) {
            System.out.println(coordinate[i][0] + "--" + coordinate[i][1]);
        }
        return coordinate;
    }

   /* public static void main(String[] args) {
        *//*TokenServiceImpl tokenService = new TokenServiceImpl();
              tokenService.getToken();*//*
        //必须要将坐标点按照逆时针方向输入
        double[][] side = {{1, 1}, {3, 1}, {3, 3}, {2, 3}, {2, 4}, {1, 3}};
        double[][] side2 = {{0, 2}, {0, 0}, {1, 2}, {1, 1}, {1, 0}, {2, 0}, {2, 2}};
        double[][] side3 = {{1, 0}, {0, 3}, {2, 6}, {3, 0}};
        double[][] side4 = {{0, 3}, {1, 0}, {2, 6}, {3, 0}};
        //getmianji(side4);
        getmianji(side4);
        side4 = antiClockWiseSort(side4);
        //计算下这四个点围成的正方形的面积
        getmianji(side4);
    }*/

    //算法计算多边形的面积

    /**
     * @描述：
     * @参数： 根据逆时针坐标点的顺序计算多边形的面积
     * @返回值： double
     * @创建人： zhangww
     * @创建时间： 2019-03-11
     * @修改人和其它信息：
     */
    public static double getmianji(double[][] side) {
        double s = 0;
        double d = (side[side.length - 1][0] * side[0][1] - side[0][0] * side[side.length - 1][1]);
        for (int i = 0; i < side.length - 1; i++) {
            s = s + (side[i][0] * side[i + 1][1] - side[i + 1][0] * side[i][1]);
        }
        System.out.println((s + d) / 2);
        return (s + d) / 2;
    }
}
