package com.company;

import java.util.HashMap;

public class Sorter {

    public Sorter () {

    }

    /*

    create a Sorter object that uses sort method to take 2 numbers, and return them, lowest to highest, as an int array

    then recieve this array, take apart, add to sorted[] array

    check this with a boolean = true, run across array, as soon as numbers don't match set false and repeat programme
     */


    /*
        HashMap Sorter
     */

    public HashMap<Integer, Pair> calcMap (Pair pair_a, Pair pair_b){

        //int[] r = new int[2];
        //Pair[] r = new Pair[2];
        HashMap<Integer, Pair> r = new HashMap<>();

        if (pair_a.getValue() <= pair_b.getValue()){
            r.put(0, pair_a);
            r.put(1, pair_b);
        }
        else {
            r.put(0, pair_b);
            r.put(1, pair_a);
        }

        return r;

    }

    public boolean checkMap (HashMap<Integer, Pair> map){

        for (int i = 0; i < map.size() - 1; i++){

            if (map.get(i).getValue() > map.get(i+1).getValue()) return false;

        }

        return true;

    }

    // Index always 0,1,2,3...
    // PAIRS (of og index and vals) are swapped, indexes are used to order in the problemset map

    public HashMap<Integer, Pair> bubbleSortMap (HashMap<Integer, Pair> problemSet){

        boolean isSorting = true;

        while (isSorting) {

            for (int i = 0; i < problemSet.size() - 1; i++) {

                HashMap<Integer, Pair> sort_return = this.calcMap(problemSet.get(i), problemSet.get(i + 1));

                problemSet.put(i, sort_return.get(0));
                problemSet.put(i + 1, sort_return.get(1));

                // DEBUG: System.out.println("f1: " + i);

            }

            if (this.checkMap(problemSet)) isSorting = false;

        }

        return problemSet;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
        Array Sorter
     */

    public int[] calcArray (int a, int b){

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

    public boolean checkArray (int[] intArray){

        for (int i = 0; i < intArray.length - 1; i++){

            if (intArray[i] > intArray[i + 1] ) return false;

        }

        return true;

    }

    public int[] bubbleSortArray (int[] problemSet){

        boolean isSorting = true;

        while (isSorting) {

            for (int i = 0; i < problemSet.length - 1; i++) {

                int[] sort_return = this.calcArray(problemSet[i], problemSet[i + 1]);

                problemSet[i] = sort_return[0];
                problemSet[i + 1] = sort_return[1];

                // DEBUG: System.out.println("f1: " + i);

            }

            if (this.checkArray(problemSet)) isSorting = false;

        }

        return problemSet;
    }

}
