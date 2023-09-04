package hw_3;

import java.io.FileWriter;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // Запрашиваем у юзера данные в определенном порядке
        String initUserAnswer = requestFromUser();

        // разбиваем полученную строку по пробелам и проверяем количество элементов в массиве, если количество
        // не совпадает с требованиями, выдаем код ошибки и текстовые комментарии, что пошло не так.

        String [] parsingAnswer = parsingUserAnswer(initUserAnswer);

        if (!sizeValidation(parsingAnswer)) {
            return;
        }

    // далее проверяем каждый элемент введенных данных с выбрасыванием исключения, если что-то не соответствует запросу

        if (!isValidName(parsingAnswer[0])){
            return;
        };
        if (!isValidName(parsingAnswer[1])) {
            return;
        }
        if (!isValidName(parsingAnswer[2])) {
            return;
        }
        if (!isValidBirthDate(parsingAnswer[3])){
            return;
        }
        if (!isValidPhoneNumber(parsingAnswer[4])) {
            return;
        }
        if (!isValidGender(parsingAnswer[5])) {
            return;
        }

        // После успешной проверки создается файл с названием по фамилии, введенной в запросе.
        // Однофамильцы записываются в один и тот же файл, в отдельные строки.

        String path = "hw_3/" + parsingAnswer[0];
        String text = initUserAnswer;
        String filename = parsingAnswer[0];

        try ( FileWriter writer = new FileWriter(path, true)){
            writer.write("\n" + text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    ////////////////////////////////////////////// Methods ///////////////////////////////////////////////////

// запрос данных у пользователя
    public static String requestFromUser() {
        Scanner request = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения (dd.mm.yyyy), номер телефона (89111111111), пол (f/m) через пробел");
        String userUnswer = request.nextLine();
        return userUnswer;
    }

    // разделение запроса на части по пробелам
    public static String[] parsingUserAnswer(String userUnswer) {
        return userUnswer.trim().replaceAll("\\s+ ", " ").split(" ");
    }

// проверка количество элементов в ответе пользователя, вывод кода ошибки
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
            return true;
        }
    }

    // Проверка корректности ФИО
    public static boolean isValidName(String name) {
//        Pattern pattern = Pattern.compile("^[А-Я][а-я]*$"); // регулярное выражение для проверки формата
        if (!name.matches("^[А-Я][а-я]*$")) {
            throw new IllegalArgumentException("Неверный формат ФИО");
        }
        return true;
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
    public static boolean isValidBirthDate(String birthDate) {
        if (birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Некорректно введена дата рождения");
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
