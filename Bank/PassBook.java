package Bank;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PassBook {
    private String name;
    private String tellphone;
    private int birth;
    private int bankNum;

    PassBook(String name, String tellphone, int birth, int bankNum) { 
        this.name = name; 
        this.tellphone = tellphone; 
        this.birth = birth; 
        this.bankNum = bankNum; 
    }

    public String getName() {
        return name;
    }
    public String getTellphone() {
        return tellphone;
    }
    public int getBirth() {
        return birth;
    }
    public int getBankNum() {
        return bankNum;
    }

    public static ArrayList<PassBook> add(Scanner s, PrintStream out, ArrayList<PassBook> PB) {
        out.print("Create PassBook");
        out.println("Name : ");
        var name = s.nextLine();

        if(found(PB, name) < 0) {
            out.println("TellPhone number : ");
            var tp = s.nextLine();
            out.println("Birth : ");
            var b = s.nextLine();
        }
    }

    public static int found(ArrayList<PassBook> PB, String n) {
        for(int i = 0; i < PB.size(); i++) {
            if(PB.get(i).getName().equals(n) || PB.get(i).getTellphone().equals(n)) {
                return i;
            } else continue;
        } return -1;
    }
}
