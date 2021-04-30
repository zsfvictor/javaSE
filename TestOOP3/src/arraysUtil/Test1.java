package arraysUtil;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] arr1 = {1,7,5,4,6,4};
        ArraysUtil.sortASC(arr1);
        System.out.println(Arrays.toString(arr1));

        int a = ArraysUtil.indexOf(arr1,4);
        System.out.println(a);
        int b = ArraysUtil.containTimes(arr1, 4);
        System.out.println(b);
        boolean c = ArraysUtil.isOne(arr1,4);
        System.out.println(c);
    }
}
