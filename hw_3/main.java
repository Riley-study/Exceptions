package hw_3;

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

Медведева Наталья Сергеевна, 24.04.1988, 89654322345, f
     */

    public static void main(String[] args) {

        String initUserAnswer = requestFromUser();
        String [] parsingAnswer = parsingUserAnswer(initUserAnswer);
        for (int i = 0; i < parsingAnswer.length; i++) {
            System.out.print("[ " + parsingAnswer[i] + " ] ");
        }
        System.out.println("код ошибки: " + sizeValidation(parsingAnswer));

    }


    public static String requestFromUser() {
        Scanner request = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения (dd.mm.yyyy), номер телефона (89111111111), пол (f/m)");
        String userUnswer = request.nextLine();
        return userUnswer;
    }

    public static String[] parsingUserAnswer(String userUnswer) {
        return userUnswer.split("[,]");
    }

    public static int sizeValidation(String [] userUnswerAfterParsing){
        int amountOfElements = 4;
        int errorCode = 0;
        if (userUnswerAfterParsing.length > amountOfElements){
            errorCode = 1;
        }
        if (userUnswerAfterParsing.length < amountOfElements) {
            errorCode = 2;
        }
        return errorCode;
    }




}
