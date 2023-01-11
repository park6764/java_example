package 단어장;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.*;

public class Word {
    public static void main(String[] args) {
        ArrayList<WordBook> list = new ArrayList();
        Scanner s = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("-> ");
            var user = Integer.parseInt(s.nextLine());

            switch (user) {
                case 1:
                    list = WordBook.add(s, System.out, list);
                    break;
                case 2:
                    list = WordBook.del(s, System.out, list);
                    break;
                case 3:
                    WordBook.quiz(s, System.out, list);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("0 ~ 3 사이의 수를 입력하세요.");
            }
        }
    }

    static void menu() {
        System.out.println("""

                ----------
                단어 추가 : 1
                단어 삭제 : 2
                문제 풀기 : 3
                종    료 : 0
                ----------
                """);
    }
}

class WordBook {
    private String word;
    private String meaning;

    WordBook(String w, String m) {
        word = w;
        meaning = m;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return word + " : " + meaning;
    }

    public static ArrayList<WordBook> add(Scanner s, PrintStream out, ArrayList<WordBook> list) {
        out.print("add word");
        out.print("-> ");
        var w = s.nextLine();

        if (idxWordMaybe(list, w).isPresent()) {
            out.print("exist");
        } else {
            out.print("add meaning");
            out.print("-> ");
            var m = s.nextLine();

            list.add(new WordBook(w, m));
            out.println(list.toString());
        }
        return list;
    }

    public static Optional<String> shuffle(ArrayList<WordBook> list) {
        Collections.shuffle(list);
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            var w = list.get(0).getWord();
            return Optional.of(w);
        }
    }

    public static boolean bool(ArrayList<WordBook> list, String m) {
        // // isPresent 값이 있냐 없냐 bool
        // if(i.isPresent()) {
        // // optional class의 get().
        // return list.get(i.get()).getMeaning().equals(m);
        // } else return false;

        return idxWordMaybe(list, m)
                .map((index) -> list.get(index).getMeaning().equals(m))
                .orElse(false);
    }

    public static ArrayList<WordBook> quiz(Scanner s, PrintStream out, ArrayList<WordBook> list) {
        out.println("quiz");
        var w = WordBook.shuffle(list);

        if (w.isPresent()) {
            out.print(w.get() + "-> ");
            var m = s.nextLine();

            for (var wb : list) {
                if (wb.getWord().equals(w.get()) && wb.getMeaning().equals(m)) {
                    out.println("correct");
                    return list;
                } else
                    continue;
            }

            out.println("wrong");
        } else {
            out.println("cannot quiz on an empty list");
        }

        return list;
    }

    public static ArrayList<WordBook> del(Scanner s, PrintStream out, ArrayList<WordBook> list) {
        out.print("del word");
        out.print("-> ");
        var w = s.nextLine();

        if (idxWordMaybe(list, w).isEmpty()) {
            out.print("is empty");
        } else {
            list.remove((int) idxWordMaybe(list, w).get());
            out.print("is delete");
            out.println(list.toString());
        }
        return list;
    }

    // 타입이 바뀐다.(정수 or null) 한눈에 보기 좋지
    public static Optional<Integer> idxWordMaybe(ArrayList<WordBook> list, String w) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord().equals(w) || list.get(i).getMeaning().equals(w)) {
                return Optional.of(i); // i 값으로 optional을 만들어서 반환.
            } else
                continue;
        }
        return Optional.empty(); // 비어있는 값으로 optional을 만들어서 반환.
    }

    public static Optional<WordBook> wordMaybe(ArrayList<WordBook> list, String w) {
        for (var wb : list) {
            if (wb.getWord().equals(w) || wb.getMeaning().equals(w)) {
                return Optional.of(wb); // i 값으로 optional을 만들어서 반환.
            } else
                continue;
        }
        return Optional.empty(); // 비어있는 값으로 optional을 만들어서 반환.
    }
}