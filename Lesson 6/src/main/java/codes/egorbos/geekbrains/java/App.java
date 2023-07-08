package codes.egorbos.geekbrains.java;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    private static Set<Notebook> notebooks = new HashSet<Notebook>() {{
        add(new Notebook(OsType.WINDOWS10, Color.GREY, 16, 2000));
        add(new Notebook(OsType.WINDOWS11, Color.WHITE, 32, 4000));
        add(new Notebook(OsType.LINUX, Color.BLACK, 16, 1000));
        add(new Notebook(OsType.NONE, Color.RED, 8, 500));
        add(new Notebook(OsType.LINUX, Color.GREY, 8, 500));
        add(new Notebook(OsType.WINDOWS10, Color.WHITE, 16, 3000));
        add(new Notebook(OsType.NONE, Color.BLACK, 16, 1000));
        add(new Notebook(OsType.WINDOWS11, Color.RED, 64, 8000));
    }};

    private static Map<Integer, Integer> filterParameters = new HashMap<Integer, Integer>();
    
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        addFilterParameters(scanner);
        var filtered = filterNotebooks();

        System.out.println("\nОригинальный список ноутбуков:");
        var originalIterator = notebooks.iterator();
        while (originalIterator.hasNext()) {
            System.out.println(originalIterator.next());
        }
        
        System.out.println("\nОтфильтрованный список ноутбуков:");
        var filteredIterator = filtered.iterator();
        while (filteredIterator.hasNext()) {
            System.out.println(filteredIterator.next());
        }

        scanner.close();
    }

    private static void addFilterParameters(Scanner scanner) {        
        System.out.print("\nВыберите категорию для фильтрации (1 - Цвет, 2 - ОС, 3 - Объем RAM Гб, 4 - Объем HDD Гб, 0 - Приступить к фильтрации): ");
        var category = scanner.nextInt();

        var paramMsgBuilder = new StringBuilder("Введите значение для фильтрации");
        var parameterValue = 0;

        switch (category) {
            case 0: return;
            case 1:
                paramMsgBuilder.append(" (1 - Серый, 2 - Белый, 3 - Черный, 4 - Красный): ");                
                break;
            case 2:
                paramMsgBuilder.append(" (1 - Отсутствует, 2 - Linux, 3 - Windows 10, 4 - Windows 11): ");
                break;
            case 3:
            case 4:
                paramMsgBuilder.append(" (минимальный объем, Гб): ");
                break;
        }

        System.out.print(paramMsgBuilder.toString());
        parameterValue = scanner.nextInt();
        filterParameters.put(category, parameterValue);

        addFilterParameters(scanner);
    }

    private static Set<Notebook> filterNotebooks() {
        var filtered = notebooks.stream()
                            .filter(notebook -> filter(notebook))
                            .collect(Collectors.toSet());
        return filtered;
    }

    private static boolean filter(Notebook notebook) {
        for (var param : filterParameters.entrySet()) {
            var paramValue = param.getValue();
            switch (param.getKey()) {
                case 1:
                    if (paramValue != notebook.getColor().ordinal()) return false;
                    break;
                case 2:
                    if (paramValue != notebook.getOs().ordinal()) return false;
                    break;
                case 3:
                    if (paramValue > notebook.getRamAmount()) return false;
                    break;
                case 4:
                    if (paramValue > notebook.getHddCapacity()) return false;
                    break; 
            }
        }
        return true;
    }
}