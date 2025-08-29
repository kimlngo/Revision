package revision.solving.pattern;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCounter {
    public static void main(String[] args) {
        String input = "Hello World";
        var freqMap = createFreqCounter(input.replaceAll("\\s+", ""));
        System.out.println(freqMap);

        System.out.println(isSame(Arrays.asList(1, 2, 3), Arrays.asList(4, 1, 9))); //true
        System.out.println(isSame(Arrays.asList(1, 2, 3), Arrays.asList(1, 9))); //false
        System.out.println(isSame(Arrays.asList(1, 2, 1), Arrays.asList(4, 4, 1))); //false
    }

    private static Map<Character, Long> createFreqCounter(String input) {
        return input.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static boolean isSame(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Long> map1 = numberFreqCounter(list1);
        Map<Integer, Long> map2 = numberFreqCounter(list2);

        for (var entry : map1.entrySet()) {
            Integer square = entry.getKey() * entry.getKey();
            if (map2.get(square) == null) {
                return false;
            }

            Long f1 = entry.getValue();
            Long f2 = map2.get(square);
            if (!f1.equals(f2)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, Long> numberFreqCounter(List<Integer> list) {
        return list.stream()
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
