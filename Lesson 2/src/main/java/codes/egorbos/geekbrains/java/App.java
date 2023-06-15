package codes.egorbos.geekbrains.java;

import org.json.JSONObject;
import org.json.JSONException;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

    // Задача № 1
    private static boolean allFieldsNull(JSONObject object) {
        var keys = object.keySet();
        if (keys.size() == 0) return true;
        for (var key : object.keySet()) {
            if (object.get(key) != null) {
                return false;
            }
        }
        return true;
    }

    private static String convertFieldValueToString(Object value) {
        if (value instanceof Integer) {
            return value.toString();
        }
        return String.format("'%s'", value);
    }

    private static String buildSqlQuery(String input) throws JSONException {
        var object = new JSONObject(input);
        var strBuilder = new StringBuilder("SELECT * FROM students");
        if (allFieldsNull(object)) {
            return strBuilder.toString();
        }

        strBuilder.append(" WHERE");

        var andNeeded = false;
        for (var key : object.keySet()) {
            var value = object.get(key);
            if (!value.equals(null)) {
                var param = String.format("%s = %s", key, convertFieldValueToString(value));
                var part = String.format("%s%s", andNeeded ? " AND " : " ", param);
                strBuilder.append(part);
                andNeeded = true;
            }
        }
        return strBuilder.toString();
    }

    // Задача № 2
    private static int[] bubbleSort(int[] array, Logger logger) {
        var temp = 0;
        var step = 0;
        var count = array.length;
        var sorted = new int[count];
        System.arraycopy(array, 0, sorted, 0, count);

        for (var i = 0; i < count; i++) {
            for (var j = 1; j < (count - i); j++) {
                if (sorted[j - 1] > sorted[j]) {
                    temp = sorted[j - 1];
                    sorted[j - 1] = sorted[j];
                    sorted[j] = temp;

                    if (logger != null) {
                        var message = String.format("Шаг %o - %s", ++step, arrayToString(sorted));
                        logger.info(message);
                    }
                }
            }
        }

        return sorted;
    }

    private static String arrayToString(int[] array) {
        var strBuilder = new StringBuilder("{");
        if (array.length != 0) {
            for(var i = 0; i < array.length; i++) {
                if (i != 0) {
                    strBuilder.append(",");
                }
                strBuilder.append(String.format(" %o", array[i]));
            }
        }
        strBuilder.append(" }");
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        //
        System.out.println("Задача № 1");
        var inputData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":null, \"age\":33}";
        
        try {
            var sqlQuery = buildSqlQuery(inputData);
            System.out.printf("Входные данные: %s%n", inputData);
            System.out.printf("Результат: %s%n", sqlQuery);
        } catch (JSONException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }

        //
        System.out.println("\nЗадача № 2");
        int[] inputArray = { 7, 2, 14, 21, 1, 6, 9 };
        System.out.printf("Массив до сортировки: %s%n", arrayToString(inputArray));

        try {
            var logger = Logger.getLogger("MainLogger");
            var formatter = new SimpleFormatter();
            var fileHandler = new FileHandler("log.txt");

            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            
            var sortedArray = bubbleSort(inputArray, logger);
            System.out.printf("Отсортированый массив: %s%n", arrayToString(sortedArray));
        } catch (Exception e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
        }
    }
}
