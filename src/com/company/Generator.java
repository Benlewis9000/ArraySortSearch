package com.company;

import java.util.HashMap;
import java.util.Random;

public class Generator {

    public Generator (){

    }

    /*
        HashMap Generator <int, pair(int, int)>
     */

    public HashMap<Integer, Pair> generateProblemMap(int problemSize, int problemRange){
        HashMap<Integer, Pair> problemSet = new HashMap<>();

        for (int i = 0; i < problemSize; i++){
            Pair pair = new Pair(i, (new Random().nextInt(problemRange)));
            problemSet.put(i, pair);
        }

        return problemSet;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
        Array Generator
     */

    public int[] generateProblemArray (int problemSize) {

        int[] problemSet = new int[problemSize];

        for (int i = 0; i < problemSize; i++){
            //problemSet[i] = 1; /* DEBUG */
            problemSet[i] = new Random().nextInt(10);
        }

        return problemSet;
    }

}
