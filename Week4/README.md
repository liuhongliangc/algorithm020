## 深度优先`（Depth First Search）`
代码模板
```
  private List<List<Integer>> depthFirstSearch(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        traversal(root,0,result);
        return result;
    }

    private void traversal(TreeNode root,int level,List<List<Integer>> list){
        if(list.size() == level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        if(root.left != null){
            traversal(root.left,level+1,list);
        }
        if(root.right != null){
            traversal(root.right,level+1,list);
        }
    }
```



## 广度优先`Breadth First Search`

```
private List<List<Integer>> breadthFirstSearch(TreeNode root){
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        List<Integer> list = new ArrayList<>();
        int size = queue.size();
        for(int i = 0; i < size; i++){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        result.add(list);
    }
    return result;
}
```

## 贪心算法   
贪心算法师一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能


```
贪心算法：当下做局部最优判断  
回溯：能够回退  
动态规划：最优判断+回退
```

## 二分查找
#### 二分查找的前提
- 目标函数单调性（单调递增或递减）
- 存在上下界
- 能够通过索引访问

代码模板
```
    private int binarySearch(int[] arry, int target) {
        int left = 0, right = arry.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (arry[mid] == target) {
                return mid;
            } else if (target > arry[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

```
