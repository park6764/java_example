import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {

        System.out.println("가위 바위 보");

        Scanner scan = new Scanner(System.in);
        String user = "";
        String result = "";
        

        do {
            System.out.print("-> ");
            user = scan.nextLine();
            
            if(!user.equals("가위") && !user.equals("바위") && !user.equals("보")) {
                System.out.println("'가위' 또는 '바위' 또는 '보'를 입력하시오. ");
            } else {
                result = RSP(user, computer());
                System.out.println(result);
            }
        } while((!user.equals("가위") && !user.equals("바위") && !user.equals("보")) || result.equals("Draw"));
    }

    static String computer() {
        ArrayList<String> a = new ArrayList<String>(Arrays.asList("가위", "바위", "보"));
        Collections.shuffle(a);
        return a.get(1);
    }

    static String RSP(String user, String comp) {
        System.out.println(comp);
        if(user.equals(comp)) {
            return "Draw";
        } else if(user.equals("가위") && comp.equals("바위")) {
            return "Computer Win";
        } else if(user.equals("바위") && comp.equals("보")) {
            return "Computer Win";
        } else if(user.equals("보") && comp.equals("가위")) {
            return "Computer Win";
        } else if(user.equals("가위") && comp.equals("보")) {
            return "User Win";
        } else if(user.equals("바위") && comp.equals("가위")) {
            return "User Win";
        } else {
            return "User Win";
        }
    }
}


// 2. computer : void -> String
// 3. RSP : (String, String) -> String
// 4. main : void -> void
