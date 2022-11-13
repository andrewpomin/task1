package task3;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Клас має метод, який на вхід приймає колекцію довільних геометричних фігур і сортує
 * їх за об'ємом.
 */
public class Main3 {

    //Method for sort figures by volume
    public static Collection<Figure> sortByVolume(Collection<Figure> collection) {

        //Write in map figures with its volume
        HashMap<Figure, Double> map = new HashMap<>();
        for (Figure f : collection) {
            map.put(f, f.getVolume());
        }

        //Sort by volume
        List<Map.Entry<Figure, Double>> tempList = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Figure, Double>comparingByValue().reversed())
                .toList();

        Collection<Figure> backCollection = new ArrayList<>();

        //Add figures in new order in collection
        for (Map.Entry<Figure, Double> entry : tempList) {
            backCollection.add(entry.getKey());
        }

        return backCollection;
    }
}
