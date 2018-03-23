package com.company;

import java.util.Random;

public class Generator {

    public Generator (){

    }

    public int[] generateProblemArray (int problemSize) {

        int[] problemSet = new int[problemSize];

        for (int i = 0; i < problemSize; i++){
            //problemSet[i] = 1; /* DEBUG */
            problemSet[i] = new Random().nextInt(10);
        }

        return problemSet;
    }

}
