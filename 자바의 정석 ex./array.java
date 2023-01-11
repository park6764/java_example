import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        // 1. 
        // int[][] array = {
        //     {5, 5, 5, 5, 5},
        //     {10, 10, 10},
        //     {20, 20, 20, 20},
        //     {30, 30}
        // };

        // System.out.println(array[3].length); // {30, 30}이므로 길이는 2

        // 2.
        // int[] array = {10, 20, 30, 40, 50};
        // int sum = 0;
        // int n = 0;
        // for(int i = 0; i < array.length; i++) {
        //     n = array[i];
        //     sum += n;
        // }
        // System.out.println(sum);

        // 3.
        int[][] array = {
            {5, 5, 5, 5, 5},
            {10, 10, 10, 10, 10},
            {20, 20, 20, 20, 20},
            {30, 30, 30, 30, 30}
        };

        int total = 0;
        float average = 0f, count = 0f;

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
            count += array[i].length;
            average = total / count;
        }
        System.out.println("total = " + total);
        System.out.println("average = " + average);
        
    }
}
