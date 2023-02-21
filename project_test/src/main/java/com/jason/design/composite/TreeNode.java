package com.jason.design.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 王政
 * @date 2022/8/31 10:59
 * 组合模式
 */
public class TreeNode {

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * 添加孩子节点
     * @param treeNode
     */
    public void add(TreeNode treeNode) {
        children.add(treeNode);
    }

    /**
     * 删除孩子节点
     * @param treeNode
     */
    public void remove(TreeNode treeNode) {
        children.remove(treeNode);
    }

    /**
     * 获取孩子节点
     * @return
     */
    public Enumeration<TreeNode> getChildren() {
        return children.elements();
    }

}
