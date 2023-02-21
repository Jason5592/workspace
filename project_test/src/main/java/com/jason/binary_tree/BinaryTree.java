package com.jason.binary_tree;

/**
 * @author 王政
 * @date 2023/2/13 10:37
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTree {
    //节点个数
    private int size;
    //根节点
    private Node root;

    public BinaryTree() {

    }

    //有参构造方法
    public BinaryTree(Integer[] c) {
        this();
        root = addAllRecur(c);
    }

    //前序遍历数据创建二叉树（递归）
    private Node addAllRecur(Integer[] c) {
        Integer var = c[size++];
        if (var == null) {
            return null;
        }
        Node node = new Node(var);
        node.left = addAllRecur(c);
        node.right = addAllRecur(c);
        return node;
    }

    //第K大节点
    public Integer kThNode(int k) {
        if (root == null) {
            return -1;
        }
        Node current = root;
        List<Integer> nodes = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                Node pop = stack.pop();
                nodes.add(pop.data);
                current = pop.right;
            }
        }

        List<Integer> newNodes = new ArrayList<>();
        for (int i = nodes.size() -1; i >= 0; i--) {
            newNodes.add(nodes.get(i));
        }

        if (newNodes.size() > k) {
            return newNodes.get(k);
        }

        return -1;
    }

    private static class Node {
        Integer data;
        Node right;
        Node left;

        Node(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{5, 3, 2, null, null, 4, null, null, 7, 6, null, null, 8, null, null};
        BinaryTree binaryTree = new BinaryTree(nodes);
        System.out.println(binaryTree.kThNode(2));
    }

}

