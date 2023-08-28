package hw2;

//  Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
//  значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно
//  запросить у пользователя ввод данных.

import java.util.Scanner;

public class hw2_task1 {
    public static void main(String[] args) {

       float res = entryNumber();
        System.out.println(res);

    }

    public static float entryNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите дробное число. Дробная часть должна быть отделена точкой: ");
        while (true) {
            try {
                return Float.parseFloat(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение. Попробуйте еще раз: ");
            }
        }
    }
}
