import java.util.ArrayList;
import java.util.Arrays;

public class num_2 {
    // public static void main(String[] args) {
    //     int j = 0;
    //     int i = 0;

    //     while(fib_(i++) <= 4000000) {
    //         if(fib_(i) % 2 == 0) {
    //             j += fib_(i);
    //         }
    //     }
    //     System.out.println(j); //4613732

    // }

    static int num(int a, int b, int c, int n) {
        if(n == 1) return a;
        else if(n == 2) return b;

        else return num(b, c, b+c, n-1);
    }

    static int fib(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else return fib(n-2) + fib(n-1);
    }

    static int fib_(int n) {
        int a = 1;
        int b = 2;
        int c = 3;

        for (int i = 0; i < (n-1); i++) {
            a = b; 
            b = c; 
            c = a + b; 
        }

        return a;
    }

    public static void main(String[] args) {
        int n = 0;
        int i = 0;

        while(fibo(n++) <= 4000000) {
            if(fibo(n) % 2 == 0) {
                i += fibo(n);
            }
        } 

        System.out.println(i);
    }

    static int fibo(int n) {
        if(n <= 1) {
            return n;
        } else return fibo(n-1) + fibo(n-2);
    }
}
