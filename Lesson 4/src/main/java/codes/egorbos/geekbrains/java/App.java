package codes.egorbos.geekbrains.java;

import java.util.Deque;
import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class App {
    private enum CalculateAction {
        SUM,
        MULTIPLY
    }

    private static LinkedList<String> convertNumberToLinkedList(int number) {
        var result = new LinkedList<String>();

        var digits = String.valueOf(number).split("(?<=.)");
        for (var digit : digits) {
            result.add(digit);
        }

        return result;
    }

    private static Deque<String> generateDeque() {
        var result = new ArrayDeque<String>();

        var random = new Random();
        for (var i = 0; i < 3; i++) {
            result.addLast(String.valueOf(random.nextInt(1, 9)));
        }

        var negative = random.nextBoolean();
        if (negative) {
            result.addLast("-");
        }

        return result;
    }

    private static int convertDequeToNumber(Deque<String> queue) {
        var result = "";

        var tempQueue = new ArrayDeque<String>(queue);
        while (tempQueue.size() > 0) {
            result += tempQueue.removeLast();
        }

        return Integer.parseInt(result);
    }

    private static LinkedList<String> calculate(Deque<String> firstQueue, Deque<String> secondQueue, CalculateAction action) {
        var firstNumber = convertDequeToNumber(firstQueue);
        var secondNumber = convertDequeToNumber(secondQueue);

        var number = 0;
        if (action == CalculateAction.SUM) {
            number = firstNumber + secondNumber;
        } else if (action == CalculateAction.MULTIPLY) {
            number = firstNumber * secondNumber;
        }

        return convertNumberToLinkedList(number);
    }

    public static void main(String[] args) {
        var firstQueue = generateDeque();
        var secondQueue = generateDeque();

        System.out.printf("Первая очередь: %s%n", firstQueue);
        System.out.printf("Вторая очередь: %s%n", secondQueue);

        var sumResult = calculate(firstQueue, secondQueue, CalculateAction.SUM);
        var multiplyResult = calculate(firstQueue, secondQueue, CalculateAction.MULTIPLY);

        System.out.printf("Результат сложения: %s%n", sumResult);
        System.out.printf("Результат перемножения: %s%n", multiplyResult);
    }
}