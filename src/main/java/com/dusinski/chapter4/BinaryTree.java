package com.dusinski.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root = null;

    public BinaryTree() {
    }

    //    converts an array with increasing sorted elements to binary search tree
    public static BinaryTree convertSortedArrayToBST(int[] decreasingArray) {
        BinaryTree bt = new BinaryTree();
        bt.root = cSATBST(null, decreasingArray, 0, decreasingArray.length);
        return bt;
    }

    public static Node cSATBST(Node inputNode, int[] array, int start, int end) {
        Node tmpNode = null;
        if (start != end) {
            tmpNode = new Node(findMiddleValue(array, start, end));
            tmpNode.rightNode = cSATBST(inputNode, array, start, start + (end - start) / 2);
            tmpNode.leftNode = cSATBST(inputNode, array, start + (end - start) / 2 + 1, end);
        }
        return tmpNode;
    }

    private static int findMiddleValue(int[] array, int start, int end) {
        return array[start + (end - start) / 2];
    }

    private Node addRecursive(Node currentNode, int val) {

        if (currentNode == null) {
            return new Node(val);
        } else if (val < currentNode.value) {
            currentNode.leftNode = addRecursive(currentNode.leftNode, val);
        } else {
            currentNode.rightNode = addRecursive(currentNode.rightNode, val);
        }
        return currentNode;
    }

    public void addValue(int val) {
        Node newNode = new Node(val);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node currentNode = this.root;
            Node previousNode = null;
            while (currentNode != null) {
                previousNode = currentNode;
                if (val < currentNode.value) {
                    currentNode = currentNode.leftNode;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
            if (val < previousNode.value) {
                previousNode.leftNode = newNode;
            } else {
                previousNode.rightNode = newNode;
            }
        }
    }

    private int findTreeHightRecursive(Node currentNode) {
        if (currentNode == null) {
            return 0;
        } else
            return 1 + Math.max(findTreeHightRecursive(currentNode.leftNode), findTreeHightRecursive(currentNode.rightNode));
    }

    public int findTreeHight() {
        return findTreeHightRecursive(this.root);
    }

    private String printLevelTraversal(Node currentNode, int level) {
        if (currentNode == null) {
            return "-";
        }
        if (level == 0) {
            return currentNode.value + "";
        } else {
            return
                    printLevelTraversal(currentNode.leftNode, level - 1) + "|" +
                            printLevelTraversal(currentNode.rightNode, level - 1);
        }
    }

    private String printLevelTraversalIterative(Node startNode) {
        Queue<Node> nodeQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int level = 0;
        nodeQueue.add(startNode);


        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();
            if (currentNode != null) {
                sb.append(currentNode.value).append("|");
                nodeQueue.add(currentNode.leftNode);
                nodeQueue.add(currentNode.rightNode);
            }
            if (level % 2 == 0) {
                sb.append("\n");
                level = level + 2;
            }
        }
        return sb.toString();
    }

    public void printAllIterative() {
        System.out.println(printLevelTraversalIterative(this.root));
    }

    public String printAll() {
        int height = findTreeHight();
        StringBuilder sb = new StringBuilder();
        if (height == 0) {
            sb.append("empty");
        }

        for (int i = 0; i < height; i++) {
            sb.append(" ".repeat((height - i)) + printLevelTraversal(this.root, i)).append("\n");
        }
        return sb.toString();
    }

    private int treeHigh(Node currentNode) {
        if (currentNode == null)
            return 0;
        else return 1 + Math.max(treeHigh(currentNode.leftNode), treeHigh(currentNode.rightNode));
    }

    private boolean isBalanced(Node curentNode) {
        if (curentNode == null) return true;
        else if (Math.abs(treeHigh(curentNode.leftNode) - treeHigh(curentNode.rightNode)) > 1) {
            return false;
        } else
            return isBalanced(curentNode.leftNode) || isBalanced(curentNode.rightNode);
    }

    public boolean isTreeBalanced() {
//            return isBalanced(this.root); //another method complexity O(n2)
        return treeHighBalanced(this.root) > -1; //here is complexity O(n)
    }

    private int treeHighBalanced(Node currentNode) {
        if (currentNode == null)
            return 0;

        int highLeft = treeHighBalanced(currentNode.leftNode);
        int highRight = treeHighBalanced(currentNode.rightNode);
        if (highLeft == -1) return -1;
        if (highRight == -1) return -1;

        if (Math.abs(highLeft - highRight) > 1) {
            return -1;
        } else return 1 + Math.max(highLeft, highRight);
    }

    private boolean isBST(Node tempNode) {
        if (tempNode == null) {
            return true;
        }
        int tmpLeft = tempNode.leftNode == null ? tempNode.value : tempNode.leftNode.value;
        int tmpRight = tempNode.rightNode == null ? tempNode.value : tempNode.rightNode.value;

        if (tmpLeft > tempNode.value || tmpRight < tempNode.value) {
            return false;
        }

        return isBST(tempNode.leftNode) && isBST(tempNode.rightNode);

    }

    public boolean isBinarySearchTree() {
        return isBST(this.root);
    }

    private Node findParentNode(int val) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(this.root);
        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();
            if (currentNode != null) {

                if (currentNode.leftNode!=null&&currentNode.leftNode.value == val) {
                    return currentNode;
                }
                if (currentNode.rightNode!=null&&currentNode.rightNode.value == val) {
                    return currentNode;
                }
                nodeQueue.add(currentNode.leftNode);
                nodeQueue.add(currentNode.rightNode);
            }
        }
        return null;
    }

    public void mixNodes(int a, int b) {
        Node tmpNodeA = findParentNode(a);
        Node tmpNodeB = findParentNode(b);
        Node tmp;
        if (tmpNodeB.leftNode.value==b){
            tmp = tmpNodeB.leftNode;
        }
        else{
            tmp = tmpNodeB.rightNode;
        }

        if (tmpNodeA.leftNode.value==a){
            tmpNodeA.leftNode=
        }

    }

}

