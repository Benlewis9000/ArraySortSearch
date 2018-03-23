package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngine {

    public SearchEngine(){

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
        Search Array
     */
    public void searchArray(int[] list, int target){

        System.out.println("Searching for: " + target);

        int index = list.length/2;
        //System.out.println("Starting at: " + index);

        while (true) {

            /* TODO
                    Convert Arraylists to Hashmaps
                    keys are list numbers
                    values are original indexes
                    e.g HashMap<Integer value, Integer index>
                    [5,0 , 3,1 , 8,2 , 2,3 , 6,4 , 5,5]
                    -> ordered values
                    [2,3 , 3,1 5,0 , 5,5 , 6,4 , 8,2]
                    Search: 5
                    Found at indexes: 0, 5

                    Will it be for ordered or unordered?
                    What if I want index before they were ordered?
                    ^ More algo's?

             */

            if (list.length == 0){
                System.out.println("Target could not be found.");
                break;
            }

            else if (list.length == 1 && list[0] != target){
                System.out.println("Target could not be found.");
                break;
            }

            int hit = list[index];


            if (hit == target){
                //System.out.println("First found " + target + " at index " + index);
                System.out.println("All indexes of target: " + Arrays.toString(this.findSpanArray(list, index, target)));
                System.out.println("Array and Index Markup:\n" + Arrays.toString(list));
                this.printIndexNumbers(list);
                break;
            }
            else if (hit > target){

                list = this.chopLowArray(list, index);

            }
            else if (hit < target){

                list = this.chopHighArray(list, index);

            }

            index = list.length/2;

        }

    }

    public int[] findSpanArray(int[] list, int index, int target){

        ArrayList<Integer> spanIndexes = new ArrayList<>();

        spanIndexes.add(index);

        // Search before
        if (!(index == 0)) {
            for (int i = 1; list[index - i] == target; i++) {
                //System.out.println("before: " + i);
                spanIndexes.add(index - i);
                if (index - i == 0) break;
            }
        }

        // Search after
        if (!(index == list.length - 1)) {
            for (int i = 1; list[index + i] == target; i++) {
                //System.out.println("after: " + i);
                spanIndexes.add(index + i);
                if (index + i == list.length - 1) break;
            }
        }

        Sorter sorter = new Sorter();

        return sorter.bubbleSortArray(toIntArray(spanIndexes));

    }

    private int[] chopLowArray (int[] list, int index){

        //System.out.println("Low Chop");

        ArrayList<Integer> returnAL = new ArrayList<>();

        for (int i = 0; i < index; i++){
            returnAL.add(list[i]);
        }

        return toIntArray(returnAL);

    }

    private int[] chopHighArray (int[] list, int index){

        //System.out.println("High Chop");

        ArrayList<Integer> returnAL = new ArrayList<>();

        for (int i = index; i < list.length; i++){
            returnAL.add(list[i]);
        }

        return toIntArray(returnAL);

    }

    /*
        Utilities
     */

    private static int[] toIntArray(ArrayList<Integer> aL){

        int[] array = new int[aL.size()];

        for (int i = 0; i < aL.size(); i++){
            array[i] = aL.get(i);
        }

        return array;
    }

    private void printIndexNumbers (int[] list){

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println(Arrays.toString(list));

    }

}
