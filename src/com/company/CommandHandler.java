package com.company;

import java.util.Scanner;

public class CommandHandler {

    int[] unorderedList;
    int[] orderedList;

    public int[] getUnorderedList() {
        return unorderedList;
    }

    public void setUnorderedList(int[] unorderedList) {
        this.unorderedList = unorderedList;
    }

    public int[] getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(int[] orderedList) {
        this.orderedList = orderedList;
    }

    public CommandHandler (int[] unorderedList, int[] orderedList){

        this.setUnorderedList(unorderedList);
        this.setOrderedList(orderedList);

        Scanner sc = new Scanner(System.in);
        boolean scanning = true;

        while (scanning) {

            System.out.println("What would you like to do?");

            String command = sc.nextLine();

            switch (command) {
                case "sort":
                    System.out.println("To do...");
                    break;
                case "new":
                    System.out.println("To do...");
                    // Generate new array - in future, take args?
                case "search":
                    this.search();
                    scanning = false;
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanning = false;
                    break;
                default:
                    System.out.println("Command not recognised. Type \"help\" for more commands.");
            }

        }

    }

    public void search (){

        Scanner sc = new Scanner(System.in);
        SearchEngine se = new SearchEngine();

        System.out.println("Enter the number to search for:");

        boolean run = true;

        while(run) {

            int test;

            try {
                test = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Input was not an integer. Please try again:");
                continue;
            }

            se.searchArray(this.getOrderedList(), test);
            run = false;

        }


    }

}
