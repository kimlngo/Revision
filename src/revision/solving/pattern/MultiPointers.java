package revision.solving.pattern;

import java.util.Arrays;
import java.util.List;

public class MultiPointers {
    public static void main(String[] args) {
        System.out.println(sumZeros(Arrays.asList(-3, -2, -1, 0, 1, 2, 3)));
        System.out.println(sumZeros(Arrays.asList(-2, 0, 1, 3)));
        System.out.println(sumZeros(Arrays.asList(1, 2, 3)));
    }

    private static List<Integer> sumZeros(List<Integer> list) {
        int left = 0, right = list.size() - 1;

        while(left < right) {
            int leftVal = list.get(left);
            int rightVal = list.get(right);
            int sum = leftVal + rightVal;

            if(sum == 0) {
                return Arrays.asList(leftVal, rightVal);
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return List.of();
    }
}
