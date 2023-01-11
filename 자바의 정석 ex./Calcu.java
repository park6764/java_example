import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Optional;


public class Calcu {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        var f1 = Fraction.fromString(s, System.out);
        var f2 = Fraction.fromString(s, System.out);
        System.out.println(Fraction.mul(f1, f2));
        System.out.println();
        
        /*
         * 1/1 = 1로 출력
         * 정수와의 계산.
         * 연산 입력받기
         * 소수와 분수와의 계산도 구현
         * 혼합계산 -> 2 + (3 * 4/3) - 4 / 3/4 등
         */
    }

    static void calculatorMenu() {
        System.out.println("""
                        0
                < +/- % x
                7  8  9 /
                4  5  6 +
                1  2  3 -
                """);
    }
}

class Fraction {
    int num;
    int den;

    Fraction(int n, int d) { num = n; den = d; }

    public int getNum() { return num; }
    public int getDen() { return den; }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    public static Fraction fromString(Scanner s, PrintStream out) {
        var str = s.nextLine();
        var strs = str.split("/");
        return new Fraction(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
    }

    public static Fraction fromLines(Scanner s, PrintStream out) {
        var numS = s.nextLine();
        var denS = s.nextLine();
        return new Fraction(Integer.parseInt(numS), Integer.parseInt(denS));
    }

    public Fraction recip() { // 역수
        return new Fraction(den, num);
    }

    public static int gcd(int a, int b) { // 최대공약수
        int r = a % b; // 호재법  4 = 12 % 8
        if(r == 0) return b;
        else return gcd(b, r); // 8와 4의 최대공약수도 같다?
    }

    public static int lcm(int a, int b) { // 최소공배수
        int ab = Math.abs(a * b);
        return ab / gcd(a, b);
    }

    public Fraction reduce() {
        int g = gcd(num, den);
        return new Fraction(num / g, den / g);
    }

    public static Fraction multi(Scanner s, PrintStream out, Fraction a, Fraction b) {
        var input = s.nextLine();
        if(input.equals("+")) {
            return Fraction.add(a, b);
        } else if(input.equals("-")) {
            return Fraction.div(a, b);
        } else if(input.equals("*")) {
            return Fraction.mul(a, b);
        } else if(input.equals("/")) {
            return Fraction.div(a, b);
        } else {
            out.print("잘못된 값입니다.");
        }
    }

    public static Fraction add(Fraction a, Fraction b) { // a - b = a + (-b)
        return new Fraction(a.getNum() * b.getDen() + b.getNum() * a.getDen(), a.getDen() * b.getDen()).reduce();
    }

    public static Fraction sub(Fraction a, Fraction b) {
        return add(a, new Fraction((-1) * b.getNum(), b.getDen()));
    }

    public static Fraction mul(Fraction a, Fraction b) {
        return new Fraction(a.getNum() * b.getNum(), a.getDen() * b.getDen()).reduce();
    }
    
    public static Fraction div(Fraction a, Fraction b) {
        return mul(a, b.recip());
    }
}

class Int {
    //    정수의 계산을 다루는 클래스
        int a, b;
    
        Int(int a, int b) {
            this.a = a;
            this.b = b;
        }
    
        public static int getA(int a) { return a; }
        public static int getB(int b) { return b; }
    
        public static int add(int a, int b) {
            int c = a + b;
            return c;
        }
    
        public static int sub(int a, int b) {
            int c = a - b;
            return c;
        }
    
        public static int mul(int a, int b) {
            int c = a * b;
            return c;
        }
    
        public  static String div(int a, int b) {
            int c = a / b;
            int d = a % b;
            return c + ".." + d;
        }
    }

    class QuotRem {
        int quot; // 몫 
        int rem; // 나머지
    
        QuotRem(int q, int r) { quot = q; rem = r; }
        public int getQuot() {
            return quot;
        }
        public int getRem() {
            return rem;
        }

        public static Optional<QuotRem> quotRem(int a, int b) { // a = q * b + r 
            if(b == 0) return Optional.empty();
            else {
                if(a > 0 && b > 0) {
                    if(a < b) return Optional.of(new QuotRem(0, a));
                    else if (a == b) return Optional.of(new QuotRem(1, 0));
                    else {
                        var qr = quotRem(a-b, b);
                        return qr.map(q -> new QuotRem(q.getQuot() + 1, q.getRem()));
                    }
                }
                else return Optional.empty(); //TODO
            }
        }
    }