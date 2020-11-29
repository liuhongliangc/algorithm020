package com.yuemei.okhttpsourcecode.leetcodetest1.week2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {


    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */
    @Test
    public void test() {
        String [] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams2(strs));

    }

    private List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)return Collections.EMPTY_LIST;
        Map<String,List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!ans.containsKey(key)) ans.put(key,new ArrayList<String>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    private List<List<String>> groupAnagrams2(String [] strs){
        if (strs.length == 0) return Collections.EMPTY_LIST;
        Map<String,List<String>> ans =new HashMap<>();
        int [] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))ans.put(key,new ArrayList<String>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
