package com.company;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.awt.*;
import java.util.*;

public class SearchEngine {

    public SearchEngine(){

    }

    public int aquireTarget(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("What number would you like to search for?");

        int target;

        while(true) {

            String input = scanner.nextLine();

            try {
                target = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex){
                System.out.println("Please enter a number:");
            }
        }

        return target;

    }

    /*
        Search Map
     */

    public void searchMap(HashMap<Integer, Pair> map, int target){

        System.out.println("Searching for: " + target);

        int index = map.size()/2;

        while (true) {
            //0, 0, 7, 9, 4, 5, 2, 1, 8, 0, test

            if (map.isEmpty()){
                System.out.println("Target could not be found.");
                break;
            }

            // Maybe use a hashset? The chopped array isn't garunteed to start at 0
            //else if (map.size() == 1 && map.get(0).getValue() != target){
            else if (map.size() == 1 && map.get(0 /*map.keySet().toArray()[0]*/).getValue() != target){
                System.out.println("Target could not be found.");
                break;
            }

            else if (index > map.size()){
                index = index/2;
                continue;
            }

            // Not a garunteed value
            System.out.println("Index: " + index);
            //for (Pair p : map.values()){
            //    System.out.println(p.getIndex()+", "+p.getValue());
            //}
            int hit = map.get(index).getValue();

            // TODO
            if (hit == target){
                System.out.println("First found " + target + " at:" +
                        "\nChop map: " + index +
                        "\nOG map: " + map.get(index).getIndex());
                System.out.println("All original indexes of target: ");

                ArrayList<Pair> indexSpan = this.findSpanMap(map, index, target);
                HashSet<Pair> indexSet = new HashSet<>();


                for (Pair p : indexSpan){
                    indexSet.add(p);
                    System.out.print(p.getIndex() + ", ");
                }
                System.out.println();
                for (Pair p : indexSet){
                    System.out.print(p.getIndex() + ", ");
                }

                break;
            }
            else if (hit > target){

                map = this.chopLowMap(map, index);

            }
            else if (hit < target){

                map = this.chopHighMap(map, index);

            }

            index = map.size()/2;

            //for (Pair p : findSpanMap(map, index, target)){
            //    System.out.println(p.getIndex() + " : " + p.getValue());
            //}

        }

    }

    public ArrayList<Pair> findSpanMap(HashMap<Integer, Pair> map, int index, int target){



        //HashMap<Integer, Pair> spanIndexes = new HashMap<>();
        ArrayList<Pair> spanIndexes = new ArrayList<>();

        spanIndexes.add(map.get(index));

        // Search before
        if (!(index == 0)) {
            for (int i = 1; map.get(index -1).getValue() == target; i++) {
                //System.out.println("before: " + i);
                spanIndexes.add(map.get(index - 1));
                if (index - i == 0) break;
            }
        }

        // Search after
        if (!(index == map.size() - 1)) {
            for (int i = 1; map.get(index + i).getValue() == target; i++) {
                //System.out.println("after: " + i);
                spanIndexes.add(map.get(index + i));
                if (index + i == map.size() - 1) break;
            }
        }

        Sorter sorter = new Sorter();

        //return sorter.bubbleSortMap();
        return spanIndexes;

    }

    /*
        TODO:
        Is a chop really necessary?
        Try a boolean that either halves index, or halve + OG index (index = index + index/2) <- acc this would not work
     */
    private HashMap<Integer, Pair> chopLowMap (HashMap<Integer, Pair> map, int index){

        //System.out.println("Low Chop");

        HashMap<Integer, Pair> returnMap = new HashMap<>();

        for (int i = 0; i < index; i++){
            returnMap.put(i, map.get(i));
        }

        return returnMap;

    }

    private HashMap<Integer, Pair> chopHighMap (HashMap<Integer, Pair> map, int index){

        //System.out.println("Low Chop");

        HashMap<Integer, Pair> returnMap = new HashMap<>();

        int base = 0;
        for (int i = index; i < map.size(); i++, base++){
            returnMap.put(base, map.get(i));
        }

        return returnMap;

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
                this.printArrayIndexNumbers(list);
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

    private void printArrayIndexNumbers (int[] list){

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println(Arrays.toString(list));

    }

}
