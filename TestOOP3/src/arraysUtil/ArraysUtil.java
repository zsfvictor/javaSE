package arraysUtil;

public class ArraysUtil {
    /**
     * 升序排列数组
     * @param arr
     */
    public static void sortASC(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列数组
     * @param arr
     */
    public static void sortASC(byte[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j]>arr[j+1]){
                    byte temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int indexOf(int[] arr,int b){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==b){
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断数组里指定元素出现次数
     * @param arr   指定数组
     * @param b     指定元素
     * @return   出现次数
     */
    public static int containTimes(int[] arr,int b){
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==b){
                t++;
            }
        }
        return t;
    }

    public static boolean isOne(int[] arr,int b){
        int i = containTimes(arr,b);
        return i == 1;
    }
}
