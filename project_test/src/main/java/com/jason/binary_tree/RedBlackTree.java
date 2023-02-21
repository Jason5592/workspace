package com.jason.binary_tree;

/**
 * @author 王政
 * @date 2023/2/13 16:21
 */
public class RedBlackTree {

    private final static int BLACK = 1;
    private final static int RED = 0;
    private static Node root;

    private static class Node {
        private int color = RED;
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 通过递归往红黑树中插入一个节点
     * @param root 根节点
     * @param data 节点值
     */
    private void insert(Node root, int data) {
        if (root.data > data) {
            if (root.left == null) {
                Node node = new Node(data);
                root.left = node;
                node.parent = root;
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                Node node = new Node(data);
                root.right = node;
                node.parent = root;
            } else {
                insert(root.right, data);
            }
        }
    }


    /**
     * 判断插入新节点后红黑树结构是否需要变化
     * 根据红黑树的定义，两个红色节点不能连接
     *
     * @param newNode 插入的新节点
     * @return 返回true表示插入新节点后破坏了红黑树的结构，需要通过旋转变色来纠正，否则不需要修改
     */
    private boolean checkStruct(Node newNode) {
        return newNode.color == RED && newNode.parent.color == RED;
    }

    /**
     * 将交换后的节点和他上面的节点连接
     *
     * @param node 变换前的轴
     * @param nextParent 变换后的子树
     */
    private static void connectParent(Node node, Node nextParent) {
        if (node.parent != null) {
            if (node.parent.data > node.data) {
                node.parent.left = nextParent;
            } else {
                node.parent.right = nextParent;
            }
        } else {
            RedBlackTree.root = nextParent;
        }
        node.parent = nextParent;
    }

    private static void leftSpin(Node node) {
        Node nextParent = node.right;

    }

}
