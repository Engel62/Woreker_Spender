package utils;

import java.util.List;

public class RandomSelector {
    public static <T> T selectRandom(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым!");
        }
        return list.get((int) (Math.random() * list.size()));
    }
}
