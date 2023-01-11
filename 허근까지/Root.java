import java.util.*;

public class Root {
   public static void main(String[] args) {
    var s = new Scanner(System.in);
    
    System.out.print("a b c: ");
    var list = s.nextLine().split(" ");
    System.out.println(answer(Integer.parseInt(list[0]), Integer.parseInt(list[1]), Integer.parseInt(list[2])));
   }

   // ax^2 + bx + c = 0
   public static ArrayList<Complex> answer(Integer a, Integer b, Integer c) {
    var list = new ArrayList<Complex>();
    var d = b*b - (4*a*c); // 판별식
    if(d > 0) {
        list.add(new Complex((int)(Math.round(-b+Math.sqrt(d))/(2*a)), 0));
        list.add(new Complex((int)(Math.round(-b-Math.sqrt(d))/(2*a)), 0));
        return list;
    } else if(d == 0) {
        list.add(new Complex((int)Math.round((-b)/(2*a)), 0));
        return list;
    } else {
        list.add(new Complex((int)Math.round((-b)/(2*a)), (int)Math.round(Math.sqrt(-d)/(2*a))));
        list.add(new Complex((int)Math.round((-b)/(2*a)), (int)Math.round(Math.sqrt(-d)/(-2*a))));
        return list;
    }
   }
}

class Complex { // 복소수
    Integer real; // 실수
    Integer imaginary; // 허수

    Complex(int r, int i) { real = r; imaginary = i; }

    public Integer getReal() { return real; }
    public Integer getImaginary() { return imaginary; }

    @Override
    public String toString() {
        if(imaginary == 0) return real.toString();
        else if(real == 0) return imagToString(imaginary);
        else {
            if(imaginary > 0) return real.toString() + " + " + imagToString(imaginary);
            else return real.toString() + imagToString(imaginary);
        }
    }

    private static String imagToString(Integer i) {
        if(i == 1) return "i";
        else if(i == -1) return "-i";
        else return i.toString() + "i";
    }
}


   /*
전에 올라온 이차방정식 문제가 2개 있었지만, 허근 표기는 하지 않았습니다.
이 문제에서는 허근까지 나타내어야 합니다.
실근, 중근의 경우에는 수치로 나타내지만, 허근의 경우에는 a+bi(단, i=루트 -1) 꼴의 문자열로 나타내어야 합니다.
허근일 경우, a가 0이면 bi 꼴로만 출력해야 하며, b가 1이면 a+i 꼴로만 출력해야 합니다.
입력값은 이차항의 계수, 일차항의 계수, 상수항이며, 해를 구하기 위해 어떤 방식을 사용할지는 자유입니다.
해는 실수부분과 허수부분이 모두 정수가 되도록 반올림해야 합니다.
    */
