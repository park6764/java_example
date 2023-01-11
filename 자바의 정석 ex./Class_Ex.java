import java.util.Arrays;

public class Class_Ex {
    public static void main(String[] args) {
        // Car2 c1 = new Car2();
        // Car2 c2 = new Car2("blue"); // 색 명시
        // Car2 c3 = new Car2("red", "stick"); // 색과 기어타입 명시

        // System.out.println("c1의 color = " + c1.color + ", gearType = " + c1.gearType + ", door = " + c1.door);
        // System.out.println("c2의 color = " + c2.color + ", gearType = " + c2.gearType + ", door = " + c2.door);
        // System.out.println("c3의 color = " + c3.color + ", gearType = " + c3.gearType + ", door = " + c3.door);

        Student s = new Student("홍길동", 1, 1, 100, 60, 76);

        String str = s.info();
        System.out.println(str);
        int[] ori = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(shuffle(ori)));
    }

    public static int[] shuffle(int[] ori) {
        int[] result = new int[ori.length];
        int l = ori.length / 2;

        // result[3] = ori[0];
        // result[0] = ori[3];

        if(ori.length % 2 == 0) {
            for(int i = 0; i < l; i++) {
                result[2*i +1] = ori[2*i];
                result[2*i] = ori[2*i +1];
            }
        } else {
            for(int i = 0; i < ori.length; i++) {
                result[2*i +3] = ori[2*i];
                result[2*i] = ori[2*i +3];
            }
        }

        return result;

        
    }
}

class Student {
    String name;
    int ban;
    int num;
    int kor;
    int eng;
    int math;

    Student(String name, int ban, int num, int kor, int eng, int math) {
        super();
        this.name = name;
        this.ban = ban;
        this.num = num;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String info() {
        return name + ", " + ban + ", " + num + ", " + kor + ", " + eng + ", " + math;
    }
}

class Car2 {
    String color;
    String gearType;
    int door;

    Car2() { // 값을 바로 준것(기본값)
        this("white", "auto", 4); // 아래것을 간단히 표현한 것.

        color = "white";
        gearType = "auto";
        door = 4;
    }

    Car2(String color) { // 칼라만 바로 준거
        this(color, "auto", 4);
    }

    Car2(String color, String gearType) { // 칼라와 기어타입을 준거
        this(color, gearType, 4);
    }

    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
} 
