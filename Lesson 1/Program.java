import java.util.Scanner;

public class Program {

    private static void taskOne(int number) {
        int summ = 1, factorial = 1;
        for (var i = 2; i <= number; i++) {
            summ += i;
            factorial *= i;
        }
        System.out.printf("Сумма чисел от 1 до %d равна %d\n", number, summ);
        System.out.printf("Факториал числа %d равен %d\n", number, factorial);
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        // Задача № 1
        System.out.println("Задача № 1");
        System.out.print("Введите число: ");
        var number = scanner.nextInt();
        taskOne(number);

        scanner.close();
    }
}