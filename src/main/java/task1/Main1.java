package task1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Клас має метод, який приймає на вхід масив цілих чисел і повертає тільки ті з них, які позитивні,
 * відсортувавши їх за спаданням.
*/
public class Main1 {

    //Method for get positive numbers and sort it
    public static int[] sortPositive(int[] array) {

        //Get positive numbers from array and write in list
        List<Integer> list = getPositiveFromArray(array);

        //Sort numbers and return it
        return sort(list);
    }

    //Method take array and return list with positive numbers
    private static List<Integer> getPositiveFromArray(int[] array) {

        List<Integer> tempList = new ArrayList<>();

        //Check all values if they >= 0
        for (int i : array) {
            if (i >= 0) {
                tempList.add(i); //If yes - add in list
            }
        }

        return tempList;
    }

    //Sort values
    private static int[] sort(List<Integer> list) {

        //Sort list
        Collections.sort(list);

        //Create result array
        int[] backArray = new int[list.size()];

        //Write numbers to array in back order (i for list, j for backArray)
        for (int i = list.size() - 1, j = 0; i >= 0 ; i--, j++) {
            backArray[j] = list.get(i);
        }

        return backArray;
    }
}
