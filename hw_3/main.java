package hw_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

    /*    Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных
не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и
создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией,
что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Медведева Наталья Сергеевна 24.04.1988 89654322345 f
Медведева Наталья Сергеевна, 24.04.1988, 89654322345, f
     */

    public static void main(String[] args) {
        // Запрашиваем у юзера данные в определенном порядке
        String initUserAnswer = requestFromUser();
        // парсим полученную строку и проверяем количество элементов в массиве, если количество не совпадает
        // с требованиями, выдает код ошибки и текстовые комментарии, что пошло не так.

        String [] parsingAnswer = parsingUserAnswer(initUserAnswer);
        for (int i = 0; i < parsingAnswer.length; i++) {
            System.out.print("[ " + parsingAnswer[i] + " ] ");
        }

        if (!sizeValidation(parsingAnswer)) {
            return;
        }
        // далее проверяем каждый элемент введенных данных с выбрасыванием исключений, если что-то не соответствует запросу
        if (!isValidFullName(parsingAnswer[1])) {
            System.out.println("фио");
            return;
        }
        if (!isValidFullName(parsingAnswer[2])) {
            System.out.println("фио");
            return;
        }
        if (!isValidFullName(parsingAnswer[3])) {
            System.out.println("фио");
            return;
        }
        if (!isValidGender(parsingAnswer[6])) {
            System.out.println("Некорректный пол");
            return;
        }
        if (!isValidPhoneNumber(parsingAnswer[5])) {
            System.out.println("Некорректный номер телефона");
            return;
        }
        if (!isValidBirthDate(parsingAnswer[4])) {
            System.out.println("Некорректная дата рождения");
            return;
        }



    }

    /////////////////////////////////////////////////////////////////////////////////////////////////


    public static String requestFromUser() {
        Scanner request = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения (dd.mm.yyyy), номер телефона (89111111111), пол (f/m) через пробел");
        String userUnswer = request.nextLine();
        return userUnswer;
    }

    public static String[] parsingUserAnswer(String userUnswer) {
       // return userUnswer.split("[,]");
        return userUnswer.trim().replaceAll("\\s+ ", " ").split(" ");
    }

    public static boolean sizeValidation(String [] userUnswerAfterParsing){
        int amountOfElements = 6;
        int errorCode = 0;
        if (userUnswerAfterParsing.length > amountOfElements){
            errorCode = 1;
            System.out.println("\nКод ошибки: " + errorCode + "\nВведено больше параметров, чем требовалось, " +
                    "либо неверный формат данных");
            return false;
        } else if (userUnswerAfterParsing.length < amountOfElements) {
            errorCode = 2;
            System.out.println("\nКод ошибки: " + errorCode + "\nВведено меньше параметров, чем требовалось, " +
                    "либо неверный формат данных");
            return false;
        } else {
            //System.out.println("\nПроверка прошла успешно.");
            return true;
        }
    }

    // Проверка корректности ФИО
    public static boolean isValidFullName(String name) throws IllegalArgumentException {
        try {

            if (name.matches("\\s[А-Яа-я]+\\s")) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректное ФИО");
            return false;
        }
    }

    // Проверка корректности номера телефона
    public static boolean isValidPhoneNumber(String phoneNumber) throws IllegalArgumentException {
         if (phoneNumber.matches("\\d{11}")) {
             return true;
         } else {
             throw new IllegalArgumentException("Некорректный номер телефона");
         }
    }

    // Проверка корректности даты рождения
    public static boolean isValidBirthDate(String birthDate) throws IllegalArgumentException {
        if (birthDate.matches(" \\d{2}\\.\\d{2}\\.\\d{4} +")) {
            return true;
        } else {
            throw new IllegalArgumentException("Некорректная дата рождения");
        }
    }

    // Проверка корректности пола
    public static boolean isValidGender(String gender) throws IllegalArgumentException {
        if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f")) {
            return true;
        } else {
            throw new IllegalArgumentException("Некорректно введен пол");
        }
    }
}
