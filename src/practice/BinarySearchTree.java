package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchTree {
    public Node root;

    public String get(int key) {
        Node x = root;
        while (x != null) {
            if (key < x.key) x = x.left;
            else if (key > x.key) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(int key, String value) {
        root = put(root, key, value);
    }

    private Node put(Node x, int key, String value) {
        if (x == null) return new Node(key, value);
        if (key < x.key) x.left = put(x.left, key, value);
        else if (key > x.key) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    public void search(int lower, int upper) {
        search(root, lower, upper);
    }

    private void search(Node x, int lower, int upper) {
        if (x == null) return;

        if (x.key < lower) search(x.left, lower, upper);
        else if (x.key > upper) search(x.right, lower, upper);
        else {
            search(x.left, lower, upper);
            System.out.println(x.key + "-" + x.value);
            search(x.right, lower, upper);
        }
    }

    public Iterable<Integer> keys() {
        List<Integer> q = new ArrayList<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, List<Integer> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    public void levelOrder(Node x) {
        if(x==null) return;
        System.out.print(x.key + " ");
        levelOrder(x.left);
        levelOrder(x.right);
    }

    class Node {
        int key;
        String value;
        Node left;
        Node right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test/resources/bst_input.txt"));
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNextLine()) {
            String[] entry = sc.nextLine().split("-");
            bst.put(Integer.parseInt(entry[0]), entry[1]);
        }

        System.out.println("-----------GET----------");
        System.out.println("Get key=2: " + bst.get(2));
        System.out.println("Get key=9: " + bst.get(9));
        System.out.println("Get key=15: " + bst.get(15));
        System.out.println("------------------------");

        System.out.println("-----------KEYS---------");
        for (int k : bst.keys()) System.out.println(k);
        System.out.println("------------------------");

        System.out.println("----------SEARCH--------");
        bst.search(2, 15);
        System.out.println("------------------------");

        System.out.println("----------Q1------------");
        sc = new Scanner("11 56 68 50 70 96 32 18 17 23");
        bst = new BinarySearchTree();
        while (sc.hasNextInt()) bst.put(sc.nextInt(), "");
        bst.levelOrder(bst.root);
        System.out.println();
        System.out.println("------------------------");
    }
}
