package com.code;

/**
 * @author: guoyongkui
 * @date: 2020/5/14 22:28
 * @projectName: holdon
 * @description:
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (isSame(s)) return s;
        String result = "";
        if (s.length() >= 1) result = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    String temp = s.substring(i, j + 1);
                    if (isPalindrome(temp) && temp.length() >= result.length()){
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s){
        boolean isSame = true;
        for (int i=0; i< s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    public boolean isSame(String s){
        for (int i=0; i<s.length();i++){
            if (s.charAt(0) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("ac"));
    }

}
