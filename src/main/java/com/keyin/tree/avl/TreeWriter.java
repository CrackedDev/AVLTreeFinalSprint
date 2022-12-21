package com.keyin.tree.avl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class TreeWriter {
    public void writeTreeJSON(AVLTreeInterface tree, String fileName){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(fileName + ".json");

        try{
            mapper.writeValue(file, tree);
            System.out.println(file.getName() + "has been written to disk...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public AVLTreeInterface readTreeJSON(String fileName){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName + ".json");

        try{
            AVLTree root = mapper.readValue(file, AVLTree.class);
            AVLTreeInterface tree = new AVLTree(root.getRoot());
            System.out.println(file.getName() + "has been loaded into memory...");
            return tree;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
