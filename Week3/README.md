## 递归
* 循环`通函数体来进行的循环`
#### 类似盗梦空间
* 向下进入不同的梦境中，向上又回到原来一层
* 通过声音同步回到上一层
* 每一次的环境和周围的人都是一份拷贝、主角等几个人穿越不同层级的梦境（发生和携带变化）

#### 递归模板

```
privite  void recursion(int level ,int param){
    //1 递归终结条件
    if(level > MAX_LEVEL){
        return;
    }
    
    //2 处理当前层逻辑
    process(level,param);
    
    //3 下探到下一层
    recursion(level+1,newParam);
    
    //4 清理当前层 比如全局变量
}
```
#### 思维要点
* 抵制人肉递归
* 找最近重复性
* 数学归纳法思维


```
//在求解6的阶乘时，递归过程
  private long factorial(int n) {
        if (n <= 1) {
            return 1;
        } 
        return n * factorial(n - 1);
    }
    /**
     * (factorial 6)
     * (* 6 (factorial 5))
     * (* 6 (5 *(factorial 4)))
     * (* 6 (5 *(4 *(factorial 3))))
     * (* 6 (5 *(4 *(3 *(factorial 2)))))
     * (* 6 (5 *(4 *(3 *(2 *(factorial 1))))))
     * (* 6 (5 *(4 *(3 *(2 1)))))
     * (* 6 (5 *(4 *(3 2))))
     * (* 6 (5 *(4 6))))
     * (* 6 (5 24)))
     * (* 6 120))
     * 720
     */

    /*
    关于 递归中 递进和回归的理解*/
    private void recursionDisplay(int n) {
        int temp = n;//保证前后打印的值一样
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursionDisplay(--n);
        }
        System.out.println("回归:" + temp);
    }
    /**
     * 递进:6
     * 递进:5
     * 递进:4
     * 递进:3
     * 递进:2
     * 递进:1
     * 递进:0
     * 回归:0
     * 回归:1
     * 回归:2
     * 回归:3
     * 回归:4
     * 回归:5
     * 回归:6
     */
```


## 分治
#### 分治代码模板

```

private static int divide_conquer(Problem problem, ) {
  //recursion terminator
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  
  //process current problem
  subProblems = split_problem(problem)
  
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  //merge
  result = process_result(res0, res1);
  
  // revert the current level status
  return result;
}
```