# 前缀树

## 简介
> 前缀树是N叉树的一种特殊形式。通常来说，一个前缀树是用来存储字符串的。前缀树的每一个节点代表一个字符串（前缀）。每一个节点会有多个子节点，通往不同子节点的路径上有着不同的字符。子节点代表的字符串是由节点本身的原始字符串，以及通往该子节点路径上所有的字符组成的。

![前缀树](https://img2018.cnblogs.com/blog/1519578/201907/1519578-20190724132134884-1903210243.png)

## 插入
> 当我们在二叉搜索树中插入目标值时，在每个节点中，我们都需要根据 `节点值` 和 `目标值` 之间的关系，来确定目标值需要去往哪个子节点。同样地，当我们向前缀树中插入一个目标值时，我们也需要根据插入的 目标值 来决定我们的路径。
> 如果我们在前缀树中插入一个字符串 S，我们要从根节点开始。 我们将根据 S[0]（S中的第一个字符），选择一个子节点或添加一个新的子节点。然后到达第二个节点，并根据 S[1] 做出选择。 再到第三个节点，以此类推。 最后，我们依次遍历 S 中的所有字符并到达末尾。 末端节点将是表示字符串 S 的节点。

![插入](https://img2018.cnblogs.com/blog/1519578/201907/1519578-20190724132128364-709713908.gif)

## 查询

> 正如我们在前缀树的简介中提到的，所有节点的后代都与该节点相对应字符串的有着共同前缀。因此，很容易搜索以特定前缀开头的任何单词。
同样地，我们可以根据给定的前缀沿着树形结构搜索下去。一旦我们找不到我们想要的子节点，搜索就以失败终止。否则，搜索成功。为了更具体地解释搜索的过程，我们提供了下列示例：

![查询](https://img2018.cnblogs.com/blog/1519578/201907/1519578-20190724132122536-1472744566.gif)

# 代码实现

```java

public class PrefixTree {


    public static void main(String[] args) {
        Trie trie = new Trie();
        
        
        trie.insert("abc");
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("baa");


        System.out.println(trie.search("baaa"));
        
    }
    
}


class Node {
    // 字节通过次数
    public int pass;

    // 字节结尾次数
    public int end;

    // node
    HashMap<Integer, Node> nexts;

    public Node() {
        this.pass = 0;
        this.end = 0;
        nexts = new HashMap<>();
    }
}

class Trie {

    // 初始化一个头结点
    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }

        Node node = root;
        node.pass++;
        final char[] chars = word.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {

            int index = (int) chars[i];

            if (!node.nexts.containsKey(index)) {
                node.nexts.put(index, new Node());
            }

            node = node.nexts.get(index);
            node.pass++;
        }

        node.end++;
    }


    /**
     * 删除
     * @param word
     */
    public void delete(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }
        
        // 查询是否有这个字段

        if (search(word) == 0) {
            return;
        }

        Node node = root;
        node.pass--;
        final char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i];

            if (--node.nexts.get(index).pass == 0) {
                node.nexts.remove(index);
                return;
            }

            node = node.nexts.get(index);
        }
        node.end--;
    }

    /**
     * word这个单词之前加入过几次
     * @param word
     * @return
     */
    public int search(String word) {
        if (StringUtils.isEmpty(word)) {
            return 0;
        }

        Node node = root;
        final char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            final int index = chars[i];

            // 中途如果不存在下一个则就是不存在
            if (!node.nexts.containsKey(index)) {
                return 0;
            }

            node = node.nexts.get(index);
        }
        
        return node.end;
    }


    /**
     * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
     * @param word
     */
    public int prefixNumber(String word) {
        if (StringUtils.isEmpty(word)) {
            return 0;
        }
        
        Node node = root;
        final char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            final int index = chars[i];

            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.pass;
    }
}
```