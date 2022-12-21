package com.keyin.tree.avl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AVLTreeTest {

    private  AVLTreeInterface tree = new AVLTree();


    @Test
    public void preOrderAVLTreeTest(){
        tree.insert(48);
        tree.insert(13);
        tree.insert(5);
        tree.insert(23);
        tree.insert(45);
        tree.insert(15);
        tree.insert(96);
        tree.insert(45);
        tree.preOrderTraversal();
        List<Integer> balanceTree = tree.getTree();
        List<Integer> startingList = new ArrayList<>();
        startingList.add(48);
        startingList.add(13);
        startingList.add(6);
        startingList.add(33);
        startingList.add(65);
        startingList.add(89);
        startingList.add(25);
        startingList.add(46);
        List<Integer> listToTest = new ArrayList<>();
        listToTest.add(48);
        listToTest.add(13);
        listToTest.add(12);
        listToTest.add(1);
        listToTest.add(21);
        listToTest.add(45);
        listToTest.add(30);
        listToTest.add(45);
        Assertions.assertEquals(listToTest, balanceTree);
        Assertions.assertNotEquals(startingList, balanceTree);

    }


    @Test
    public void emptyClearTreeTest(){
        tree.insert(55);
        tree.insert(45);
        tree.insert(1);
        tree.insert(45);
        tree.insert(23);
        tree.insert(12);
        tree.insert(21);
        tree.insert(30);
        String message = tree.checkForEmptyTree();
        Assertions.assertEquals("Tree is not empty", message);
        tree.clearTree();
        message = tree.checkForEmptyTree();
        Assertions.assertEquals("Tree is Empty", message);
    }



    @Test
    public void inOrderAVLTreeTest(){
        tree.insert(55);
        tree.insert(45);
        tree.insert(1);
        tree.insert(45);
        tree.insert(23);
        tree.insert(12);
        tree.insert(21);
        tree.insert(30);
        tree.inOrderTraversal();
        List<Integer> inOrderTree = tree.getTree();
        List<Integer> startingList = new ArrayList<>();
        startingList.add(55);
        startingList.add(45);
        startingList.add(1);
        startingList.add(45);
        startingList.add(23);
        startingList.add(12);
        startingList.add(21);
        startingList.add(30);
        List<Integer> listToTest = new ArrayList<>();
        listToTest.add(1);
        listToTest.add(12);
        listToTest.add(21);
        listToTest.add(23);
        listToTest.add(30);
        listToTest.add(45);
        listToTest.add(45);
        listToTest.add(55);
        Assertions.assertEquals(listToTest, inOrderTree);
        Assertions.assertNotEquals(startingList, inOrderTree);

    }



    @Test
    public void postOrderAVLTreeTest(){
        tree.insert(55);
        tree.insert(45);
        tree.insert(1);
        tree.insert(45);
        tree.insert(23);
        tree.insert(12);
        tree.insert(21);
        tree.insert(30);
        tree.postOrderTraversal();
        List<Integer> postOrderTree = tree.getTree();
        List<Integer> startingList = new ArrayList<>();
        startingList.add(55);
        startingList.add(45);
        startingList.add(1);
        startingList.add(45);
        startingList.add(23);
        startingList.add(12);
        startingList.add(21);
        startingList.add(30);
        List<Integer> listToTest = new ArrayList<>();
        listToTest.add(1);
        listToTest.add(21);
        listToTest.add(12);
        listToTest.add(30);
        listToTest.add(45);
        listToTest.add(45);
        listToTest.add(23);
        listToTest.add(55);
        Assertions.assertEquals(listToTest, postOrderTree);
        Assertions.assertNotEquals(startingList, postOrderTree);
        tree.clearTree();
        Assertions.assertTrue(postOrderTree.isEmpty());

    }


}
