import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        System.out.println("구구단을 외자");
        
        var scan = new Scanner(System.in);
        Integer user = -1;

        while(user != 0){
            var xs = quiz();
            System.out.print(makeEx(xs[0], xs[1]));
            user = scan.nextInt();
            System.out.println(correct(user, xs[0], xs[1]));
        }
    }

    static Integer[] quiz() {
        ArrayList<Integer> x = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Collections.shuffle(x);
        Collections.shuffle(y);

        return new Integer[] { x.get(0), y.get(0) };
    }

    static String makeEx(Integer a, Integer b) { 
        return a + " " + "*" + " " + b + " " + "="; 
    }

    static String correct(Integer user, Integer a, Integer b) {
        return user == a*b ? "정답입니다." : "오답입니다.";
    }
}
    
//  <구구단을 외자.>

//  게임방법 : 
//  컴퓨터가 출력하는 문제의 정답을 입력하는 게임.
//  문제는 2단부터 9단까지 랜덤으로 문제 출력.
//  연속으로 10문제 맞추면 승리. (Q. 정답을 어떻게 판단하지?)



// 1. main : void -> void
// 2. quiz : void -> String(2 * 4 = )
// 3. correct : (integer(user), String(qize)) -> String("정답입니다.") 

// problem_1 : qize와 corrcet연결 How?


// question_1 : 정답이면 다음 문제를 출력하고 정답이 10번이 되면 게임종료를 어떻게 할 수 있을까?
