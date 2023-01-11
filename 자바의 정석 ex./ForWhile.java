import java.util.Arrays;


public class ForWhile {
    public static void main(String[] args) {
        // 1.
        // for(int x = 1; x <= 20; x++) {
        //     if(x > 10 && x < 20) {
        //         System.out.println(x + " = " + "True");
        //     } else System.out.println(x + " = " + "False");
        // } 

        // 2. 
        // char ch = ' ';
        // if(ch == ' ' || ch == ' ') {
        //     System.out.println("True");
        // } else System.out.println("False");

        // 3.
        // char ch = 1;
        // if(ch >= 0 && ch <= 9) {
        //     System.out.println("True");
        // } else System.out.println("False");

        // 4. 
        // int year = 2020;
        // if(year % 400 == 0 || year % 4 == 0) {
        //     System.out.println("True");
        // } else if(year % 100 != 0) { 
        //     System.out.println("False");
        // }

        // 5. 
        // boolean powerOn = false;
        // if(!powerOn) System.out.println("True");

        // 6.
        // int sum = 0;
        // for(int i = 1; i <= 20; i++) {
        //     if(i % 2 != 0 && i % 3 != 0) {
        //         sum += i;
        //     }
        // }
        // System.out.println(sum);

        // 7.
        // int sum = 0;

        // for(int i = 1; i <= 10; i++) {
        //     sum += a(i);
        // }
        // System.out.println(sum);

        // 8.
        // int i = 199, 201;
        // System.out.println(b(i));

        // 9. 
        // String str = "12345";
        // int sum = 0;
        // char[] cs = str.toCharArray();
        
        // for(int i = 0; i < cs.length; i++) {
        //     sum += Character.getNumericValue(cs[i]);
        // } 
        // System.out.println(sum);

        
        // for(int i = 0; i < str.length(); i++) {
        //     char cs = str.charAt(i);
        //     sum += Character.getNumericValue(cs);
        //     System.out.println(sum);
        // }

        // 10.
        // int num = 12345;
        // System.out.println(c(num));
        
    }

    static int c(int n) {
        int a = n, sum = 0;
        while(a > 0) {
            sum += a % 10; 
            a = a / 10;  
        } return sum;
    }

    static int a(int n) {
        if(n <= 10 && n > 0) {
            return n + a(n-1);
        } else return n;
    }

    static int b(int n) {
        int j = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0) {
                j += -i;
            } else j += i;
        } return j;
    }
}