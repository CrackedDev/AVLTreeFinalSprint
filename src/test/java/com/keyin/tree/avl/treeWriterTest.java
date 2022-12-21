package com.keyin.tree.avl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class treeWriterTest {
    public AVLTreeInterface createTree() {
        AVLTreeInterface tree = new AVLTree();
        // Create Tree
        tree.insert(13);
        tree.insert(5);
        tree.insert(12);
        tree.insert(99);
        tree.insert(56);
        tree.insert(85);
        tree.insert(6);
        tree.insert(1);
        tree.insert(52);

        return tree;
    }

    @Test
    void writeTest() {
        AVLTreeInterface tree = createTree();
        TreeWriter writer = new TreeWriter();
        writer.writeTreeJSON(tree, "jsonTestFile");
        File file = new File("jsonTestFile.json");
        file.delete();
    }

    @Test
    void readTest() {
        AVLTreeInterface tree = createTree();
        TreeWriter reader = new TreeWriter();
        reader.writeTreeJSON(tree, "jsonTestFile");
        AVLTreeInterface treeFromFile = reader.readTreeJSON("jsonTestFile");
        Assertions.assertEquals(tree.getRoot().toString(), treeFromFile.getRoot().toString());
        File file = new File("jsonTestFile.json");
        file.delete();
    }


}



