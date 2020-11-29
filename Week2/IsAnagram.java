package com.yuemei.okhttpsourcecode.leetcodetest1.week2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 输入: s = "rat", t = "car"
     * 输出: false
     */
    @Test
    public void test() {
        System.out.println(isAnagram("banana","ananab"));
        System.out.println(isAnagram2("banana","ananab"));
        System.out.println(isAnagram3("banana","ananab"));
    }


    /**
     * 排序法
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char [] str1 = s.toCharArray();
        char [] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    /**
     * hash表法
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isAnagram3(String s, String t){
        int [] arr =new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            arr[c - 'a']--;
        }
        for (int i : arr) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }

}
