package com.yuemei.okhttpsourcecode.leetcodetest1.week8.lrucache;

import com.yuemei.okhttpsourcecode.okio.Source;

import org.junit.Test;

public class LRUTest {

    @Test
    public void test(){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int i = lruCache.get(1);
        System.out.println(i);
        lruCache.put(3,3);
        int i1 = lruCache.get(2);
        System.out.println(i1);
        lruCache.put(4,4);
        int i2 = lruCache.get(1);
        System.out.println(i2);
        int i3 = lruCache.get(3);
        System.out.println(i3);
        int i4 = lruCache.get(4);
        System.out.println(i4);

    }


}
