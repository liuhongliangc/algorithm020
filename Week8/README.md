## 位运算

含义 | 运算符 | 实例
---|---|---
左移 | `<<` | `0011 => 0110`
右移 | `>>` | `0110 => 0011`


含义 | 运算符 | 实例
---|---|---
按位或 (不同为一)|`|` |`0011 | 1011=1011`
按位与 (不同为零)| `&`|`0011 & 1011=0011`
按位取反| `~`| `~0011=1100`
按位异或（相同为零不同为一）|`^`|`0011 ^ 1011=1000`

#### XOR-异或
异或：`相同为0，不同为1。也可以用不进位加法来理解`
异或操作的一些特点：

`x^0 = x`

`x^ 1s = ~x //主意1s = ~0`

`x^(~x) = 1s`

`x^x = 0`

#### 指定位置的位运算
* 将x最右边的n位清零：`x&(~0<<n) `
* 获取x的第n位的值(0或者1)：`(x>>n)&1`
* 获取x的第n位的幂值：`x&(1<<n)`
* 仅将第n位置为1：`x|(1<<n)`
* 仅将第n位置为0：`x&(~(1<<n))`
* 将x最高位至第n位（含）清零：`x&((1<<n)-1)`
#### 实战位运算要点
* 判断奇偶
```
x%2 == 1 --> (x&1) == 1(奇数)
x%2 == 0 --> (x&1) == 0(偶数)
```
* x>>1 --> x/2
```
即：x = x/2; --> x = x>>1;
    mid = (left + right)/2; --> mid = (left + right)>>1; 
```
* X = X&(X-1)清零最低位的1
* X&-X => 得到最低位的1
* X&~X => 0

## 布隆过滤器(Bloom Filter)
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。

##### 优点是空间效率和查询时间都远远超过一般的算法。

##### 缺点是有一定的误识别率和删除困难。

## LRU Cache
* 两个要素：大小、替换策略
* HashTable + DoubleLinkedList
* O(1) 查询 O(1)修改、更新

```
/**
 * LRU Cache
 */
public class LRUCache {

    /**
     * 缓存映射
     */
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    /**
     * 缓存大小
     */
    private int size;
    /**
     * 缓存容量
     */
    private int capacity;
    /**
     * 链表头部和尾部
     */
    private DLinkNode head, tail;

    public LRUCache(int capacity) {
        //初始化缓存大小，容量和头尾节点
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部节点
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取节点
     *
     * @param key 节点的键
     * @return 返回节点的值
     */
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //移动到链表头部 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 添加节点
     *
     * @param key   节点的键
     * @param value 节点的值
     */
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkNode newNode = new DLinkNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            //移动到链表头部
            moveToHead(node);
        }
    }

    /**
     * 删除尾结点
     *
     * @return 返回删除的节点
     */
    private DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

    /**
     * 删除节点
     *
     * @param node 需要删除的节点
     */
    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    /**
     * 把节点添加到链表头部
     *
     * @param node 要添加的节点
     */
    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 把节点移动到头部
     *
     * @param node 需要移动的节点
     */
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：对于 put 和 get 都是 O(1)O(1)。
     *
     * 空间复杂度：O(capacity)，因为哈希表和双向链表最多存储 capacity+1 个元素。
     *
     */
}
```


## 排序算法
#### 比较类排序
通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序

#### 非比较类排序
不通过比较类决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序

#### 初级排序-O(n^2)
1. 选择排序：`每次找最小值，然后放到待排序数组的起始位置`

```
/**
* 选择排序    
*/
public class SelectSort {
    private void selectSort(int[] arry) {
        int minIndex, temp;
        for (int i = 0; i < arry.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[j] < arry[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arry[i];
            arry[i] = arry[minIndex];
            arry[minIndex] = temp;
        }
    }
    @Test
    public void test() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

2. 插入排序：`从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入`


```
public class InsertSort {
    private void insertSort(int[] arry) {
        int preIndex, current;
        for (int i = 1; i < arry.length; i++) {
            preIndex = i - 1;
            current = arry[i];
            while (preIndex >= 0 && arry[preIndex] > current) {
                arry[preIndex + 1] = arry[preIndex];
                preIndex--;
            }
            arry[preIndex + 1] = current;
        }
    }
    @Test
    public void test() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

3. 冒泡排序：`嵌套循环，每次查看相邻的元素如果逆序，则交换`

```
/**
 * 冒泡排序
 */
public class BubbleSort {
    private void bubbleSort(int[] arr) {
        int temp;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    @Test
    public void test() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```


#### 高级排序-O(nlogn)
* 快速排序：`数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排，已达到整个序列有序`

```
/**
 * 快速排序
 */
public class QuickSort {
    private void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        //pivot:标杆位置 counter:小于pivot的元素个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

    @Test
    public void test() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
```

* 归并排序-分治

    `1.把长队为n的束缚序列分成两个长度为n/2的子序列`

    `2.对这两个子序列分别采用归并排序`

    `3.将两个排序好的子序列合并成一个最终的排序序列`


```
/**
 * 归并排序
 */
public class MergeSort {
    private void mergeSort(int[] arry, int left, int right) {
        if (right <= left) return;
        int mid = (right + left) >> 1;

        mergeSort(arry, left, mid);
        mergeSort(arry, mid + 1, right);
        merge(arry, left, mid, right);
    }

    private void merge(int[] arry, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//中间数组
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            temp[k++] = arry[i] <= arry[j] ? arry[i++] : arry[j++];
        }
        
        while (i <= mid) temp[k++] = arry[i++];
        while (j <= right) temp[k++] = arry[j++];

        for (int p = 0; p < temp.length; p++) {
            arry[left + p] = temp[p];
        }
        //也可以用 System.arraycopy(a, start1, b, start2, length)
    }
}
```

```
归并和快排具有相似性，单步骤顺序相反
归并：先排序左右子数组，然后合并两个有序子数组
快排：先调配出左右子数组，然后对于左右子数组进行排序
```
* 堆排序 -堆插入O(logn)，取最大/小值O(1)

    `1.数组元素依次简历小顶堆`

    `2.依次取堆顶元素，并删除`

#### 特殊排序 O(n)
* 计数排序

    `计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中，然后依次把计数大于1的填充回原数组`

* 桶排序

    `桶排序的工作原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）`
* 基数排序

    `基数排序是按照低位先排序，然后收集，再按照高位排序，然后再收集，依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序`


#### 算法复杂度
排序算法 | 时间复杂度（平均）| 时间复杂度（最坏）|时间复杂度（最好）|空间复杂度|稳定性
---|---|---|---|---|---
插入排序 | O(n^2^) | O(n^2^) | O(n) |O(1)|稳定
希尔排序 | O(n^1.3^) | O(n^2^) | O(n) |O(1)|不稳定
选择排序 | O(n^2^) | O(n^2^) | O(n^2^) |O(1)|不稳定
冒泡排序 | O(n^2^) | O(n^2^) | O(n) |O(1)|稳定
堆排序 | O(nlog~2~n) | O(nlog~2~n) | O(nlog~2~n) |O(1)|不稳定
快速排序 | O(nlog~2~n) | O(n^2^) | O(nlog~2~n) |O(nlog~2~n)|不稳定
归并排序 | O(nlog~2~n) | O(nlog~2~n) | O(nlog~2~n) |O(n)|稳定
||||
计数排序 | O(n+k) | O(n+k) | O(n+k) |O(n+k)|稳定
桶排序 | O(n+k) | O(n^2^) | O(n) |O(n+k)|稳定
基数排序 | O(n*k) | O(n*k) | O(n*k) |O(n+k)|稳定

相关概念
* 稳定：`如果a原本在b前面，而a=b，排序之后a仍然在b的前面。`
* 不稳定：`如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。`
* 时间复杂度：`对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。`
* 空间复杂度：`是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。 `