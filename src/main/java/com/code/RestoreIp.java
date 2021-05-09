package com.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: guoyongkui
 * @date: 2020/12/12 12:54
 * @projectName: holdon
 * @description:
 */
public class RestoreIp {

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int[] temp = new int[4];

        return list;
    }

    public void dfs(String s, int start, int num, int[] temp, List<String> result){

        if (start < s.length() && num == 4){
            return;
        }

        if (start == s.length() && num < 4){
            return;
        }

        if (start == s.length() && num == 4){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(temp[0])
                    .append(".")
                    .append(temp[1])
                    .append(".")
                    .append(temp[2])
                    .append(".")
                    .append(temp[3]);
            result.add(stringBuilder.toString());
            return;
        }
        if (s.charAt(start) == '0'){
            temp[num] = 0;
            dfs(s, start+1, num+1, temp, result);
        }

        for (int i=start; i<s.length(); i++){
            int segment = Integer.parseInt(s.substring(start, i));
            if (segment > 255) break;

        }



        int a = (int) (Math.random() * 10);
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i=0;i<10;i++){
            System.out.println(random.nextInt(10));

        }
    }

}
