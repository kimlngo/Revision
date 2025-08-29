package revision.solving.pattern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(Arrays.asList(1, 2, 5, 2, 8, 1, 5), 2));
        System.out.println(maxSubArraySum(Arrays.asList(1, 2, 5, 2, 8, 1, 5), 4));
        System.out.println(maxSubArraySum(Arrays.asList(4, 2, 1, 6), 1));
        System.out.println(maxSubArraySum(Arrays.asList(4, 2, 1, 6, 2), 4));
        System.out.println(maxSubArraySum(List.of(), 4));
    }

    private static int maxSubArraySum(List<Integer> list, int n) {
        if(list.isEmpty()) return -1;
        int curSum = IntStream.range(0, n)
                              .map(list::get)
                              .sum();

        int maxSum = curSum;

        for (int i = 1; i <= list.size() - n; i++) {
            curSum = curSum - list.get(i - 1) + list.get(i + n - 1);
            if (curSum > maxSum)
                maxSum = curSum;
        }

        return maxSum;
    }
}
