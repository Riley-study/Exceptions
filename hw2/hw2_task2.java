package hw2;

public class hw2_task2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int d = 0;
        if (d != 0){
            double catchedRes1 = intArray[8] / d;
            System.out.println(catchedRes1);
        } else {
            System.out.println("Division by zero is restricted!!");
        }
    }

}
