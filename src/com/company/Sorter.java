package com.company;

public class Sorter {

    public Sorter () {

    }

    /*

    create a Sorter object that uses sort method to take 2 numbers, and return them, lowest to highest, as an int array

    then recieve this array, take apart, add to sorted[] array

    check this with a boolean = true, run across array, as soon as numbers don't match set false and repeat programme
     */

    public int[] calc (int a, int b){

        int[] r = new int[2];

        if (a <= b){
            r[0] = a;
            r[1] = b;
        }
        else {
            r[0] = b;
            r[1] = a;
        }

        return r;

    }

    public boolean check (int[] intArray){

        for (int i = 0; i < intArray.length - 1; i++){

            if (intArray[i] > intArray[i + 1] ) return false;

        }

        return true;

    }

    public int[] bubbleSort (int[] problemSet){

        boolean isSorting = true;

        while (isSorting) {

            for (int i = 0; i < problemSet.length - 1; i++) {

                int[] sort_return = this.calc(problemSet[i], problemSet[i + 1]);

                problemSet[i] = sort_return[0];
                problemSet[i + 1] = sort_return[1];

                // DEBUG: System.out.println("f1: " + i);

            }

            if (this.check(problemSet)) isSorting = false;

        }

        return problemSet;
    }

}
