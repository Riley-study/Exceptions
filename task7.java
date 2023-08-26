import java.util.Arrays;

public class task7 {
    public static void main(String[] args) {

        int[] ints1 = {1, 2, 3, 4, 5};
        int[] ints2 = {5, 4, 3, 2};
//        int[] ints2 = null;

        System.out.println(Arrays.toString(joinArray(ints1, ints2)));
    }


    public static int[] joinArray(int[] arr1, int[] arr2) {
        try {
            if (arr1 == null || arr2 == null) {
                throw new NullPointerException();
            }
            if (arr1.length != arr2.length) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
//            e.printStackTrace();
            System.out.println("Null pointer - program ended");
            return null;

        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.println("Массивы не равны.");
        }
        int minArrayLen = Math.min(arr1.length, arr2.length);
        int[] result = new int[minArrayLen];
        for (int i = 0; i < minArrayLen; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }
}
