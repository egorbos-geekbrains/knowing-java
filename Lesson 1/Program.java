import java.util.Scanner;
import java.util.ArrayList;

public class Program {

    // Задача № 1
    private static void taskOne(int number) {
        int summ = 1, factorial = 1;
        for (var i = 2; i <= number; i++) {
            summ += i;
            factorial *= i;
        }
        System.out.printf("Сумма чисел от 1 до %d равна %d\n", number, summ);
        System.out.printf("Факториал числа %d равен %d\n", number, factorial);
    }

    // Задача № 2
    private static boolean isNumberPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        var bound = (int) Math.floor(Math.sqrt(number));
            
        for (int i = 3; i <= bound; i += 2)
        {
            if (number % i == 0) return false;
        }
        
        return true;        
    }

    // Задача № 3
    private static double calculate(double firstNumber, double secondNumber, String action) {
        switch (action) {
            case "+": return firstNumber + secondNumber;
            case "-": return firstNumber - secondNumber;
            case "*": return firstNumber * secondNumber;
            case "/": return firstNumber / secondNumber;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        //
        System.out.println("Задача № 1");
        System.out.print("Введите число: ");
        var number = scanner.nextInt();
        taskOne(number);

        //
        System.out.println("\nЗадача № 2");
        var primeNumbers = new ArrayList<Integer>();
        for (var i = 1; i <= 1000; i++) {
            if (isNumberPrime(i)) {
                primeNumbers.add(i);
            }
        }
        System.out.println("Простые числа в диапазоне [1; 1000]: " + primeNumbers.toString());

        //
        System.out.println("\nЗадача № 3");
        System.out.print("Введите первое число: ");
        var firstNumber = Double.parseDouble(scanner.next());
        System.out.print("Введите действие: ");
        var action = scanner.next();
        System.out.print("Введите второе число: ");
        var secondNumber = Double.parseDouble(scanner.next());
        var result = calculate(firstNumber, secondNumber, action);
        System.out.printf("%.2f %s %.2f = %.2f\n", firstNumber, action, secondNumber, result);

        scanner.close();
    }
}