package com.keyin.tree.avl;

import java.util.Scanner;

public class AVLMenu {


    public static void  runMenu(Scanner scanner , AVLTreeInterface tree){
        char choice;

        do{
            System.out.println("Select a Option");
            System.out.println("1.Insert a Number into the Tree");
            System.out.println("2.Check if Tree is Empty");
            System.out.println("3.Empty Tree (Clear All Values)");
            System.out.println("4.Display the AVL Tree in Post Order");
            System.out.println("5.Display the AVl Tree in Order");
            System.out.println("6.Display the AVL tree in Pre Order");
            System.out.println();
            System.out.println("Enter Your Choice");
            int selection = scanner.nextInt();
            switch (selection){
                case 1 :
                    System.out.println("Enter a number to insert in AVL Tree. Enter(-1) to quit");
                    while( selection != -1){
                         selection = scanner.nextInt();
                         if(selection != -1){
                             tree.insert(selection);
                             System.out.println(selection + " inserted");
                         }

                    }
                    break;
                case 2 :
                    String message = tree.checkForEmptyTree();
                    System.out.println(message);
                    break;

                case 3 :
                    String clearMessage = tree.clearTree();
                    System.out.println(clearMessage);
                    break;

                case 4 :
                    System.out.println("Display in Post Order");
                    tree.postOrderTraversal();
                    break;
                case 5 :
                    System.out.println("Display in Order");
                    tree.inOrderTraversal();
                    break;
                case 6 :
                    System.out.println("Display in Pre Order");
                    tree.preOrderTraversal();
                    break;

                default:
                    System.out.println("Invalid Entry: Enter a number between (1-8)");
                    break;
            }

            System.out.println(" \n Press (Y) to continue: (any value) to quit \n");
            choice = scanner.next().charAt(0);
        }  while(choice == 'Y' || choice == 'y' );
    }
}
