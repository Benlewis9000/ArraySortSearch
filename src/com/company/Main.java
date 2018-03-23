package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
                Now working on hashmap branch
         */

        Sorter sorter = new Sorter();
        Generator generator = new Generator();

        int problemSize = 50;
        int problemRange = 100;

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
        for (int i = 0; i < unorderedMap.size(); i++){
            System.out.print(orderedMap.get(i).getValue() + ", ");
        }

        /*
        System.out.println("Sorted set:\n" + Arrays.toString(orderedList));

        CommandHandler cmd = new CommandHandler(unorderedList, orderedList);
        */

        //SearchEngine searchEngine = new SearchEngine();

        //searchEngine.search(orderedList, 1);

    }
}

