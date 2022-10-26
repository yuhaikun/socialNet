package com.example.socialnet.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/19 19:30
 */
public class test {


    public int hire(int n) {
        Random r = new Random();
        int[] s = new int[n];
        int bestIndex = 0;
        int bestScores = 0;
        ArrayList<Integer> item = new ArrayList<>();
        ArrayList<Integer> results  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s[i] = r.nextInt(100);
            item.add(i);
//            if (s[i] > bestScores) {
//                bestScores = s[i];
//                bestIndex = i;
//                System.out.println("当前最佳面试者为"+bestIndex);
//            }else {
//                System.out.println("当前最佳面试者为"+bestIndex);
//            }
        }
        for (int i = 0; i < n; i++) {
            int myRand = r.nextInt(item.size());

            results.add(item.get(myRand));

            item.remove(myRand);

        }

        for (int i = 0; i < results.size(); i++) {
            if (s[results.get(i)] > bestScores) {
                bestScores = s[results.get(i)];
                bestIndex = results.get(i);
                System.out.println("当前最佳面试者为" + bestIndex);
            } else {
                System.out.println("当前最佳面试者为" + bestIndex);
            }
//            System.out.print(results.get(i)+" ");
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i)+" ");
        }


        System.out.println(Arrays.toString(s));
        return bestIndex;
    }

    public static void main(String[] args) {
        test test1 = new test();
        test1.hire(10);
    }
}
