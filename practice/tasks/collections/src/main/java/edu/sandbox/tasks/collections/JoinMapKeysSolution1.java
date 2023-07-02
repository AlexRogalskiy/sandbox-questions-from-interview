package edu.sandbox.tasks.collections;

import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Please implement the sortedKeyList method above that should do the following:
 * Extract all the keys from both maps into a single data structure containing all the keys
 * Make sure it has no duplicates
 * Convert the keys to strings
 * Sort the strings into ascending order
 * Build and return one big string, by concatenating all the key strings, using ", " as a separator Return "<none>" if both maps are empty
 */
// TODO: write unit test for this solution
public class JoinMapKeysSolution1 {

    public static String sortedKeyList(Map<?, ?> map1, Map<?, ?> map2) {
        if (MapUtils.isNotEmpty(map1) && MapUtils.isNotEmpty(map2)) {
            return Stream.of(map1.keySet(), map2.keySet())
                    .flatMap(Collection::stream)
                    .map(Object::toString)
                    .sorted()
                    .distinct()
                    .collect(Collectors.joining(", "));
        }
        return "<none>";
    }

    public static void main(String[] args) {
        Map<String, Integer> test1 = Map.of("test1", 1, "test2", 2);
        Map<String, Integer> test2 = Map.of("test3", 1, "test4", 2);
        System.out.println(sortedKeyList(test1, test2));
    }
}