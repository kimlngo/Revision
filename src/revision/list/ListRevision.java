package revision.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ListRevision {
    public static void main(String[] args) {
        Comparator<Apple> appleComparator = Comparator.comparingInt(Apple::getWeight)
                                                      .reversed()
                                                      .thenComparing(Comparator.comparing(Apple::getOrigin)
                                                                               .reversed());
        PriorityQueue<Apple> applePriorityQueue = new PriorityQueue<>(appleComparator);
        applePriorityQueue.add(new Apple(110, "U.S"));
        applePriorityQueue.add(new Apple(120, "Japan"));
        applePriorityQueue.add(new Apple(170, "China"));
        applePriorityQueue.add(new Apple(170, "Vietnam"));
        applePriorityQueue.add(new Apple(90, "Europe"));

        while (!applePriorityQueue.isEmpty()) {
            System.out.println(applePriorityQueue.poll());
        }
    }
}

class Apple {
    private int weight;
    private String origin;

    public Apple(int weight, String origin) {
        this.weight = weight;
        this.origin = origin;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String toString() {
        return String.format("{origin: %s, weight: %d}", this.origin, this.weight);
    }
}