import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

public class ContactUs {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        var TB = new ArrayList<NameNumber>();

        while (true) {
            Menu();
            var user = Integer.parseInt(s.nextLine());

            switch(user) {
                case 1: TB = NameNumber.TelephoneBook(s, System.out, TB); break;
                case 2: TB = NameNumber.Del(s, System.out, TB); break;
                case 3: NameNumber.Search(s, System.out, TB); break;
                case 4: System.out.println(TB.toString()); break;
                case 5: System.out.println("프로그램이 종료됩니다."); return;
                default: System.out.println("1~4 사이의 값을 입력하세요");
            }
        } 
    }

    static void Menu () {
        System.out.println("------------");
        System.out.println("연락처 추가 : 1");
        System.out.println("연락처 삭제 : 2");
        System.out.println("연락처 검색 : 3");
        System.out.println("연락처 보기 : 4");
        System.out.println("프로그램 종료 : 5");
        System.out.println("------------");
        System.out.println(" ");
    }
}

class NameNumber {
    private String name;
    private String number;

    NameNumber (String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName () { return name; }
    public String getNumber () { return number; }

    @Override 
    public String toString() { 
        return name + "::" + number ;
    }

    public static boolean isTelephone(String s) { 
        var cs = s.toCharArray(); // toCharArray :: 문자열을 하나씩 쪼개서 char 배열로 만들어주는 녀석
        for (var c : cs) { 
            if (!Character.isDigit(c) && c != '-') { 
                return false;
            } else continue;
        } return true;
    }

    public static int indexOfName(ArrayList<NameNumber> TB, String name) {
        for (int i = 0; i < TB.size(); i++) {
            if (TB.get(i).getName().equals(name)) {
                return i;
            } else continue;
        } return -1;
    }

    public static int indexOfNumber(ArrayList<NameNumber> TB, String number) {
        for (int i = 0; i < TB.size(); i++) {
            if (TB.get(i).getNumber().equals(number)) {
                return i;
            } else continue;
        } return -1;
    }

    public static ArrayList<NameNumber> TelephoneBook(Scanner s, PrintStream out, ArrayList<NameNumber> TB) {
        out.print("연락처 추가하기를 선택하셨습니다. \n추가할 전화번호를 입력하세요. \n전화번호는 XXX-XXXX-XXXX으로 입력하세요. \n(종료를 원하시면 '종료'를 입력하세요.)");
        out.print("-> ");
        var number = s.nextLine();
        //010-1234-5678
        if (indexOfNumber(TB, number) < 0 && isTelephone(number)) {
            out.print("저장할 이름을 입력하세요. \n(종료를 원하시면 '종료'를 입력하세요.)");
            out.print("-> ");
            var name = s.nextLine();

            if (name.equals("종료")) return TB;
            else if (indexOfName(TB, name) < 0) {
                TB.add(new NameNumber(name, number));
                return TB;
            } else out.println("이미 저장된 이름입니다."); // 동명이인은 없다고 가정.
        } else out.println("이미 저장된 전화번호 또는 전화번호가 아닙니다. \n정수로 입력해주세요.");
        return TB; 
    }

    public static ArrayList<NameNumber> Del(Scanner s, PrintStream out, ArrayList<NameNumber> TB) {
            out.print("연락처 삭제하기를 선택하셨습니다. \n삭제할 연락처 이름을 입력하세요. \n(종료를 원하시면 '종료'를 입력하세요.");
            out.print("-> ");
            var name = s.nextLine();

            if (indexOfName(TB, name) >= 0) {
                int i = indexOfName(TB, name);
                TB.remove(TB.get(i)); 
                out.print(name + "(이)가 삭제되었습니다." ); return TB;
            } else
                out.print("전화부에" + name + "(이)가 없습니다.");

                if (name.equals("종료")) return TB;
            return TB;
    }

    public static void Search (Scanner s, PrintStream out, ArrayList<NameNumber> TB) {
            out.print("연락처 검색하기를 선택하셨습니다. \n검색할 연락처의 이름을 입력하세요. \n(종료를 원하시면 '종료'를 입력하세요.");
            out.print("-> ");
            var name = s.nextLine();

            if (indexOfName(TB, name) >= 0) {
                int i = indexOfName(TB, name);
                out.print(TB.get(i).toString()); return; 
            } else
                out.print("전화부에" + name + "(이)가 없습니다.");
                
                if (name.equals("종료")) return;
    }
}
