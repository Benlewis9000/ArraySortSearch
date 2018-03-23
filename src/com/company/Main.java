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

        int problemSize = 10;

        int[] unorderedList = generator.generateProblemArray(problemSize);
        System.out.println("Problem set:\n" + Arrays.toString(unorderedList));

        int[] orderedList = sorter.bubbleSort(unorderedList);

        System.out.println("Sorted set:\n" + Arrays.toString(orderedList));

        CommandHandler cmd = new CommandHandler(unorderedList, orderedList);

        SearchEngine searchEngine = new SearchEngine();

        //searchEngine.search(orderedList, 1);

    }
}

