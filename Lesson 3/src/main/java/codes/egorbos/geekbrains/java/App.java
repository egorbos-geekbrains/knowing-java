package codes.egorbos.geekbrains.java;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class App {

    private static <T> String listToString(List<T>  list) {
        var strBuilder = new StringBuilder("{");
        if (list.size() != 0) {
            for (var i = 0; i < list.size(); i++) {
                if (i != 0) {
                    strBuilder.append(",");
                }
                strBuilder.append(String.format(" %d", list.get(i)));
            }
        }
        strBuilder.append(" }");
        return strBuilder.toString();
    }

    public static void main( String[] args )
    {
        List<Integer> list = new ArrayList<Integer>();

        var random = new Random();
        for (var i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 50));
        }

        System.out.printf("Задан список: %s%n", listToString(list));

        var amount = 0.;
        var minValue = 0;
        var maxValue = 0;

        var listIterator = list.iterator();

        while (listIterator.hasNext()) {
            var current = listIterator.next();

            if (current % 2 == 0) {
                listIterator.remove();
            } else {
                if (minValue == 0 || current < minValue) {
                    minValue = current;
                }
                if (maxValue == 0 || current > maxValue) {
                    maxValue = current;                    
                }
                amount += current;
            }
        }

        System.out.printf("Список после преобразования: %s%n", listToString(list));
        System.out.printf("Минимальный элемент: %d%n", minValue);
        System.out.printf("Максимальный элемент: %d%n", maxValue);
        System.out.printf("Среднее значение: %.2f%n", amount == 0 ? 0 : amount / list.size());
    }
}