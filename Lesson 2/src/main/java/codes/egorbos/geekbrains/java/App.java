package codes.egorbos.geekbrains.java;

import org.json.JSONObject;
import org.json.JSONException;

public class App 
{
    // Задача № 1
    private static boolean allFieldsNull(JSONObject object) {
        var keys = object.keySet();
        if (keys.size() == 0) return true;
        for (String key : object.keySet()) {
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

    public static String buildSqlQuery(String input) throws JSONException {
        var object = new JSONObject(input);
        var builder = new StringBuilder("SELECT * FROM students");
        if (allFieldsNull(object)) {
            return builder.toString();
        }

        builder.append(" WHERE");

        var andNeeded = false;
        for (String key : object.keySet()) {
            var value = object.get(key);
            if (!value.equals(null)) {
                var param = String.format("%s = %s", key, convertFieldValueToString(value));
                var part = String.format("%s%s", andNeeded ? " AND " : " ", param);
                builder.append(part);
                andNeeded = true;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //
        System.out.println("Задача № 1");
        var inputData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":null, \"age\":33}";
        var sqlQuery = buildSqlQuery(inputData);
        System.out.printf("Входные данные: %s%n", inputData);
        System.out.printf("Результат: %s%n", sqlQuery);
    }
}
