### 时间复杂度
#### Big O notation
1. O(1):常数复杂度
2. O(log n):对数复杂度
3. O(n):线性时间复杂度
4. O(n^2):平方
5. O(n^3):立方
6. O(2^n):指数
7. O(n!):阶乘

#### O(1)

```
int n = 1000;
System.out.println("Hey - you input is:"+n);

//可以说成是O(3)但也是常数复杂度
System.out.println("Hey - you input is:"+n);
System.out.println("Hmm.. Iam doing more stuff with:"+n);
System.out.println("And more:"+n);
```
### O(log(n))

```
for(int i=1;i<n; i=i*2){
    System.out.println("Hey - i am busy looking at :"+n);
}
```

#### O(n)

```
for(int i=1;i<=n;i++){
    System.out.println("Hey - i am busy looking at :"+n);
}
//两个for并列还是O(n)的时间复杂度
for(int i=1;i<=n;i++){
    System.out.println("Hey - i am busy looking at :"+n);
}
```
#### O(n^2)

```
for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
        System.out.println("Hey - i am busy looking at :"+i+"and"+j);
    }
}
```
### O(n^3)

```
for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
        for(int k=1;k<=n;k++){
            System.out.println("Hey - i am busy looking at :"+i+"and"+j);
        }
    }
}
```
#### O(2^n)

```
int fib(int n){
    if(n<2)return n;
    return fib(n-1)+fib(n-2);
}
```
#### 时间复杂度曲线
![image](https://tva1.sinaimg.cn/large/0081Kckwly1gkei5ue3srj319f0u0q7s.jpg)

![image](https://tva1.sinaimg.cn/large/0081Kckwly1gksj5vomesj31jz0u0h37.jpg)

面试题
```
二叉树遍历-前序、中序、后序的时间复杂度: O(n)每个节点只访问一次且仅访问一次,线性与二叉树的节点总数 
图的遍历时间复杂度: O(n)每个节点只访问一次且仅访问一次
搜索算法DFS(深度优先)、BFS(广度优先)时间复杂度: O(n)每个节点只访问一次 
二分查找时间复杂度: O(log n)一分为二
```
### 空间复杂度
1. 数组的长度
2. 递归的深度

```
一维数组 O(n)
二维数组 0(n^2)
```
