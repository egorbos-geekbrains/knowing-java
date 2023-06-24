package codes.egorbos.geekbrains.java;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class App {

    private static HashMap<String, List<Integer>> phonebook = new HashMap<String, List<Integer>>();

    private static class ListSizeComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> first, List<Integer> second) {
            return Integer.valueOf(second.size()).compareTo(first.size());
        }
    }

    private static void addPhoneNumber(String name, int number) {
        var numbers = phonebook.containsKey(name) ? phonebook.get(name) : new ArrayList<Integer>();
        numbers.add(number);

        if (!phonebook.containsKey(name)) {
            phonebook.put(name, numbers);
        }
    }

    public static void main(String[] args) {
        addPhoneNumber("Сидоров", 54321);
        addPhoneNumber("Петров", 12345);
        addPhoneNumber("Иванов", 1231234);        
        addPhoneNumber("Иванов", 3456345);
        addPhoneNumber("Петров", 67890);
        addPhoneNumber("Иванов", 5676585);

        var comparator = new ListSizeComparator();

        var sortedIterator = phonebook.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(comparator))
            .iterator();

        while (sortedIterator.hasNext()) {
            var current = sortedIterator.next();
            var name = current.getKey();
            var numbers = current.getValue();
            for (var number : numbers) {
                System.out.printf("%s %d%n", name, number);
            }
        }
    }
}
