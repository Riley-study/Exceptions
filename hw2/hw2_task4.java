package hw2;

import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно
// показаться сообщение, что пустые строки вводить нельзя.
public class hw2_task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String massage = scanner.nextLine();
        emptyStringProtection(massage);

    }

    public static void emptyStringProtection(String massage) {
        if (massage.isEmpty()) {
            System.out.println("Exception: пустые строки вводить нельзя");
        } else {
            System.out.println(massage);
        }

    }
}
