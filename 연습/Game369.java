import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Ex_1 {
    public static void main(String[] args) {

        System.out.println("Game369");
        
        Scanner scan = new Scanner(System.in);
        int i = -1;
        String userInput = "";
        Random r = new Random();

        i = 0;
        System.out.println("Game Start~!");
        while (i <= 98) {
            Double p = r.nextDouble();
            String s2 = computerTurn(i, p); // i+1
            System.out.println(s2);

            if (userInputValid(s2, i)) {
                System.out.print("-> ");
                userInput = scan.nextLine(); // i+2

                if (userInputValid(userInput, i + 1)) {
                    i += 2;
                } else {
                    System.out.println("Invalid input. Game over");
                    return;
                }
            } else {
                System.out.println("Invalid output. You win!");
                return;
            }
        }
    }

    static Boolean userInputValid(String userInput, Integer prevInt) {
        String s = nextValue(prevInt);
        return userInput.equals(s);
    }

    static String nextValue(Integer prevInt) {
        Integer n = prevInt + 1;
        return contains369(n) ? "*" : n.toString();
    }

    static String computerTurn(Integer userInt, double prob) {
        Integer n = userInt + 1;

        double d = (double) n / 100.0;
        // n -> p = n / 100;
        Boolean q = prob < d;
        return contains369(n) ? (q ? n.toString() : "*") : n.toString();

    }

    static Boolean contains369(Integer i) {
        ArrayList<Integer> j = divide(i);
        return j.contains(3) || j.contains(6) || j.contains(9);
    }

    static ArrayList<Integer> divide(Integer i) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int q = 0, r = 0, s = i;
        while (s > 0) {
            q = s / 10; //
            r = s % 10; // s = q * 10 + r
            list.add(r);
            s = q;
        }
        return list;
    }
}

// 1. 컴퓨터와 369 게임하기
// 2. 처음에 0을 입력하면 게임 start
// 3. 처음 1 입력은 컴퓨터가 먼저한다.
// 4. 다음 차례에 사용자가 순차적으로 숫자를 입력한다. (단, 3, 6, 9 숫자가 포함될 때에는 *을 입력한다)
// 5. 컴퓨터의 입력에 있어 확률을 준다.( 숫자가 높아질 수록 틀릴확률 증가)
