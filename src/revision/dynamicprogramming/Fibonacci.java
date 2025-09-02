package revision.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer> fibMap = new HashMap<>();

    static {
        fibMap.put(0, 1);
        fibMap.put(1, 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("fib(45) = " + fibByDP(45));

        long end = System.currentTimeMillis();
        System.out.println("Execution Time: " + (end - start) + " ms");
    }

    //condition: n >= 0
    private static int fib(int n) {
        if (n < 2)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }

    private static int fibByDP(int n) {
        if(fibMap.get(n) != null)
            return fibMap.get(n);

        int first = fibByDP(n - 1);
        fibMap.putIfAbsent(n - 1, first);

        int second = fibByDP(n - 2);
        fibMap.putIfAbsent(n - 2, second);

        fibMap.putIfAbsent(n, first + second);
        return fibMap.get(n);
    }
}

record Row(int id, String name) {}
