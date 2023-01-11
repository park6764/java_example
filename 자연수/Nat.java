import java.io.PrintStream;
import java.util.*;
import java.util.function.*;


public class Example {
    public static void main(String[] args) {
        var m = Nat.fromInteger(5).orElse(Nat.zero);
        var n = Nat.fromInteger(8).orElse(Nat.zero);

        System.out.println(Nat.toInteger(Nat.add(m, n)));
        System.out.println(Nat.toInteger(Nat.mult(m, n)));
    }
}

abstract class Nat {

    public static Zero zero = new Zero();

    public static <T> T match(T v, Function<T, T> f, Natural n) {
        if(n instanceof Zero) return v;
        else {
            Succ n_ = (Succ)n;
            var x = match(v, f, n_);
            var nPlus = f.apply(x);

            return nPlus;
        }
    }

    public static Boolean equals(Natural n1, Natural n2) {
        if(n1 instanceof Zero && n2 instanceof Zero) return true;
        else if(n1 instanceof Zero) return false;
        else if(n2 instanceof Zero) return false;
        else {
            Succ n1_ = (Succ)n1;
            Succ n2_ = (Succ)n2;
            return equals(n1_.getN(), n2_.getN());
        }
    }

    public static Boolean greaterThan(Natural n1, Natural n2) { // n1 > n2
        if(n1 instanceof Zero && n2 instanceof Zero) return false;
        else if(n1 instanceof Zero) return false;
        else if(n2 instanceof Zero) return true;
        else {
            Succ n1_ = (Succ)n1;
            Succ n2_ = (Succ)n2;
            return greaterThan(n1_.getN(), n2_.getN());
        }
    }

    public static Natural add(Natural m, Natural n) {
        if(m instanceof Zero && n instanceof Zero) return new Zero();
        else if(m instanceof Zero) return n;
        else if(n instanceof Zero) return m;
        else { // (m+1) + (n+1) == (m+n) + 1 + 1
            Succ m_ = (Succ)m;
            Succ n_ = (Succ)n;
            return new Succ(new Succ(add(m_.getN(), n_.getN())));
        }
    }

    public static Natural mult(Natural m, Natural n) {
        if(m instanceof Zero && n instanceof Zero) return new Zero();
        else if(m instanceof Zero) return new Zero();
        else if(n instanceof Zero) return new Zero();
        else { // (m) * (n) == (m-1)*(n-1) + (m-1) + (n-1) + 1;
            Succ m_ = (Succ)m;
            Succ n_ = (Succ)n;
            return new Succ(add(n_.getN(), add(m_.getN(), mult(m_.getN(), n_.getN()))));
        }
    }

    public static Integer toInteger(Natural n) {
        return match(0, i -> i + 1, n);
    }

    public static Optional<Natural> fromInteger(Integer i) {
        if(i < 0) return Optional.empty();
        else if(i == 0) return Optional.of(new Zero());
        else {
            var j = i - 1;
            var m = fromInteger(j);
            return m.map(n -> new Succ(n));
        }
    }

    abstract class Natural {} // data Natural = Zero | Succ Natural

    class Zero extends Natural {
        Zero() {}
    }

    class Succ extends Natural {
        private final Natural n;

        Succ(Natural n) { this.n = n; }
        public Natural getN() {
            return n;
        }
    }
}