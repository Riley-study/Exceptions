public class seminar1 {
    public static void main(String[] args) {

//        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints = null;

        int res = findValue(ints, 0);
        System.out.println(res);
    }

    public static int findValue(int[] arr, int value) {
        if (arr == null){
            return -3;
        }
        if (arr.length < 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -2;
    }
}
