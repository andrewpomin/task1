package task2;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Клас має метод, який на вхід приймає список рядків-текстів, а повертає top-5 найчастіше згаданих хеш-тегів
 * із зазначенням кількості згадки кожного з них.
 */
public class Main2 {

    private static HashMap<String, Integer> hashTags; //Map for storing hashTags and count of its usages

    //Initialize once
    static {
        hashTags = new HashMap<>();
    }

    //Method for get top5 hashTags
    public static List<String> getTop5(List<String> input) {

        //Take each element from list
        for (String string : input) {

            //Looking for hashTags
            getHashTag(string);
        }

        //Return list of top5 hashTags
        return writeTop5InList();
    }

    //Take hashTag form String
    private static void getHashTag(String s) {
        List<String> list = new ArrayList<>();

        //Make char array from taken string
        char[] string = s.toCharArray();

        int begin = -1; //First index for hashtag in string
        int end; //Last index for hashtag in string
        String hashTag; //String for hashTag

        //Take each char from string
        for (int i = 0; i < s.length(); i++) {

            //If char is '#' - this is hashtag, if begin == -1 - we don't look on other hashTag
            if (string[i] == '#' && begin == -1) {

                //Write first index of hashTag
                begin = i;

            //If char is ' ' or '#' and we already wrote begin index - this is end of hashtag
            } else if ((string[i] == ' ' || string[i] == '#') && begin != -1) {

                //Write last index of hashTag
                end = i;

                //Take full hashTag from string
                hashTag = s.substring(begin, end);

                //If we still don't found such hashTag in this string
                if (!list.contains(hashTag)) {

                    //Write in list (for duplicate value in string
                    list.add(hashTag);

                    //Add hashTag to map
                    addToMap(s.substring(begin, end));
                }

                //Clear begin index
                begin = -1;

                //Make step back in loop to check start of another hashTag
                --i;
            }
        }

        //If it is the end of string - write full hashTag
        hashTag = s.substring(begin);

        //Same steps for end of the string
        if (!list.contains(hashTag)) {
            list.add(hashTag);
            addToMap(s.substring(begin));
        }
    }

    //Add hashTag to map
    private static void addToMap(String hashTag) {

        //Default count of hashTag
        int count = 1;

        //If we already have such hashTag
        if (hashTags.containsKey(hashTag)) {

            //Take count of this hashTag and add one more
            count = hashTags.get(hashTag) + 1;
        }

        //Rewrite value in map
        hashTags.put(hashTag, count);
    }

    //Get list of top5 hashTags
    private static List<String> writeTop5InList() {

        //Sort map by values and write it in list
        List<Map.Entry<String, Integer>> tempList = hashTags
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        //List for top5 values
        List<String> backList = new ArrayList<>();

        int i = 0; //Count for position

        //Start writing top values
        for (Map.Entry<String, Integer> entry : tempList) {

            //If it is already five values - stop
            if (i == 5) {
                break;

            //Write top hashTags in list
            } else {
                backList.add(entry.getKey() + " - " + entry.getValue());
                i++;
            }
        }

        return backList;
    }
}
