public class object {
    public static void main(String[] args) {
        // TV t1 = new TV();
        // TV t2 = new TV();
        // t1.channel = 7;
        // t1.channelDown();
        // System.out.println("t1의 값은 " + t1.channel + "입니다.");
        // System.out.println("t2의 값은 " + t2.channel + "입니다.");

        // Card c1 = new Card();
        // c1.kind = "Heart";
        // c1.number = 7;
        // System.out.println("Card.width = " + Card.width);
        // System.out.println("Card.height = " + Card.heigth);

        // Card c2 = new Card();
        // c2.kind = "Spade";
        // c2.number = 2;

        // System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.heigth + ")");
        // System.out.println("c1은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.heigth + ")");

        // System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
        // c1.width = 50;
        // c1.heigth = 80;

        // System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.heigth + ")");
        // System.out.println("c1은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.heigth + ")");

        Student s = new Student("박준수", 2, 201728012, 100, 60, 76);

        System.out.println(s);
    }
}

class TV {
    String color; // 참조형
    boolean power;
    int channel;

    void power() { power = !power; } // 인스턴스 메서드
    void channelUp() { channel++;}
    void channelDown() { channel--;}
}

class Card {
    String kind;
    int number;
    static int width = 100;
    static int heigth = 250;
}

class Student {
    private String name;
    private int ban;
    private int num;
    private int kor;
    private int eng;
    private int math;

    Student(String name, int ban, int num, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.num = num;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public static int total(int kor, int eng, int math) {
        int tot = kor + eng + math;
        return tot;
    }

    public static float average(int tot) {
        float aver = tot / 3;
        return aver;
    }
}