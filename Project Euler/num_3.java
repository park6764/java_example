import java.util.ArrayList;

public class num_3 {    
    public static void main(String[] args) {
        // long n = 600851475143l;
        long n = 13195;

        System.out.println(b(n));
    }

    static boolean a(long n) {
        if(n == 1 || n == 2) return true;

        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            } 
        } return true;
    }

    static long b(long n) {
        ArrayList<Long> list = new ArrayList();

        for(long i = 1; i <= n; i++) {
            if(n % i == 0 && a(i)) {
                list.add(i);
            }
        } return list.get(list.size()-1);
    }
}
