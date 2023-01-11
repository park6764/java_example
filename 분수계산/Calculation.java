package 분수계산;

import java.io.PrintStream;
import java.util.Scanner;


public class Calculation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("분수 계산기 (단, 분수 두개만 계산 가능)");
        System.out.print("분수 1 : ");
        var f1 = Fraction.fromString(s, System.out);
        System.out.print("(+, -, *, /) 중 하나 입력 : ");
        var f = s.nextLine();
        System.out.print("분수 2 : ");
        var f2 = Fraction.fromString(s, System.out);

        Fraction n = Fraction.inString();
        Fraction m = Fraction.inString();

        if(f == "+") {
            System.out.println(Fraction.add(f1, f2));
        } else if(f == "-") {
            System.out.println(Fraction.sub(f1, f2));
        } else if(f == "*") {
            System.out.println(Fraction.mul(f1, f2));
        } else if(f == "/") {
            System.out.println(Fraction.div(f1, f2));
        } else {
            System.out.println(Fraction.add(n, m));
        } 
    }
}

class Fraction  {
    private int num;
    private int den; 

    Fraction(int n, int d) { num = n; den = d; }

    public int getNum() {
        return num;
    }
    public int getDen() {
        return den;
    }

    @Override
    public String toString() {
        if(num == den) {
            return "1";
        } else return num + "/" + den;
    }

    public static Fraction fromString(Scanner s, PrintStream out) {
        var str = s.nextLine();
        var strs = str.split("/");
        return new Fraction(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
    }

    public Fraction recip() {
        return new Fraction(den, num);
    }

    public static int gcd(int a, int b) {
        // a = b*q + r
        // a > b
        int r = a % b;
        if(r == 0) {
            return b;
        } else {
            return gcd(b, r);
        }
    }

    public static int lcm(int a, int b) {
        var ab = Math.abs(a*b);
        return ab / gcd(a, b);
    }

    public Fraction reduce() {
        var g = gcd(num, den);
        return new Fraction(num / g, den / g);
    }

    public static Fraction add(Fraction a, Fraction b) {
        return new Fraction((a.getNum() * b.getDen()) + (b.getNum() * a.getDen()), (a.getDen() * b.getDen())).reduce();
    }
// 1 + (-2) = 1 + (-1)*2
    public static Fraction sub(Fraction a, Fraction b) {
        return add(a, new Fraction((-1) * b.getNum(), b.getDen()));
    }

    public static Fraction mul(Fraction a, Fraction b) {
        return new Fraction(a.getNum() * b.getNum(), a.getDen() * b.getDen()).reduce();
    }

    public static Fraction div(Fraction a, Fraction b) {
        return mul(a, b.recip());
    }

    public static Fraction def(Fraction a, Fraction b) {
        return new Fraction(1, 1);
    }

    public static Fraction multi(Scanner s, Fraction a, Fraction b) {
        var f = s.nextLine();
        
        if(f != "+" || f != "-" || f != "*" || f != "/") {
            System.out.println(Fraction.add(a, b));
        } if(f == "+") {
            System.out.println(Fraction.add(a, b));
        } else if(f == "-") {
            System.out.println(Fraction.sub(a, b));
        } else if(f == "*") {
            System.out.println(Fraction.mul(a, b));
        } else {
            System.out.println(Fraction.div(a, b));
        }
    }

    public static Fraction inString() {
        var s1 = "1/1";
        var strs = s1.split("/");
        return new Fraction(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
    }
}


        // var f1 = Fraction.fromString(s, System.out);
        // var f2 = Fraction.fromString(s, System.out);
        // System.out.println(Fraction.mul(f1, f2));