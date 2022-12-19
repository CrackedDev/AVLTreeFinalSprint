package com.keyin.tree;

import com.keyin.tree.avl.AVLMenu;
import com.keyin.tree.avl.AVLTree;
import com.keyin.tree.avl.AVLTreeInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);
        AVLTreeInterface  tree = new AVLTree();
        AVLMenu.runMenu(scanner, tree);
    }

}
