package com.jason.design.composite;

/**
 * @author 王政
 * @date 2022/8/31 11:14
 */
public class Tree {

    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode treeNodeB = new TreeNode("B");
        TreeNode treeNodeC = new TreeNode("C");
        treeNodeB.add(treeNodeC);
        tree.root.add(treeNodeB);
        System.out.println("build the tree finished!");
    }

}
