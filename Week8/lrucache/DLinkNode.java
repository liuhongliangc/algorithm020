package com.yuemei.okhttpsourcecode.leetcodetest1.week8.lrucache;

public class DLinkNode {
    public Integer key;
    public Integer value;
    public DLinkNode prev;
    public DLinkNode next;
    public DLinkNode() {
    }
    public DLinkNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
