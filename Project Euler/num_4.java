

public class num_4 {
    public static void main(String[] args) {

        for(int i = 100; i < 1000; i++) {
            for(int j = 100; j < 1000; j++) {
                if(b(i * j)) {
                    System.out.println(i*j);
                }
            }
        }
    }

    static boolean b(int n) {
        String s = String.valueOf(n);
        
        if(s.charAt(0) == s.charAt(5) && s.charAt(1) == s.charAt(4) && 
        s.charAt(2) == s.charAt(3)) {
            return true;
        } else return false;
    }
}
