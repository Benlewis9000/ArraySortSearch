package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
                TODO:
                clean everything up
                document
                any chance for polymorphism in SearchEngine?
         */

        Sorter sorter = new Sorter();
        Generator generator = new Generator();

        int problemSize = 11;
        int problemRange = 10;

        /*
        int[] unorderedList = generator.generateProblemArray(problemSize);
        System.out.println("Problem set:\n" + Arrays.toString(unorderedList));

        int[] orderedList = sorter.bubbleSort(unorderedList);
        */

        HashMap<Integer, Pair> unorderedMap = generator.generateProblemMap(problemSize, problemRange);

        for (int i = 0; i < unorderedMap.size(); i++){
            System.out.print( unorderedMap.get(i).getValue() + ", ");
        }

        HashMap<Integer, Pair> orderedMap = sorter.bubbleSortMap(unorderedMap);


        System.out.println();
        /*
        for (int i = 0; i < unorderedMap.size(); i++){
            System.out.print(orderedMap.get(i).getValue() + ", ");
        }*/

        /*
        System.out.println("Sorted set:\n" + Arrays.toString(orderedList));

        CommandHandler cmd = new CommandHandler(unorderedList, orderedList);
        */

        SearchEngine searchEngine = new SearchEngine();

        int target = searchEngine.aquireTarget();

        searchEngine.searchMap(orderedMap, target);

    }
}

