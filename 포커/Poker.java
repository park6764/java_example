import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] userDeck = new String[6];
        String[] unkown = new String[1];
        String[] comp = new String[6];
        
    }

    public static String game(Scanner s, PrintStream out, String[] cards) {
        out.print("Game Start!");


    }

    public String[] start(String[] cards, String[] comp, String[] userDeck, String unkown) {
        comp[0] = CardDeck.shuffle();
    }
}

class CardDeck {
    public static String[] cards() {
        String[] cards = {"[♥️ : A]", "[♥️ : 2]", "[♥️ : 3]", "[♥️ : 4]", "[♥️ : 5]", "[♥️ : 6]", "[♥️ : 7]", "[♥️ : 8]", "[♥️ : 9]", "[♥️ : 10]",
        "[♥️ : J]", "[♥️ : Q]", "[♥️ : K]",
        "[♠ : A]", "[♠ : 2]", "[♠ : 3]", "[♠ : 4]", "[♠ : 5]", "[♠ : 6]", "[♠ : 7]", "[♠ : 8]", "[♠ : 9]", "[♠ : 10]",
        "[♠ : J]", "[♠ : Q]", "[♠ : K]",
        "[♣ : A]", "[♣ : 2]", "[♣ : 3]", "[♣ : 4]", "[♣ : 5]", "[♣ : 6]", "[♣ : 7]", "[♣ : 8]", "[♣ : 9]", "[♣ : 10]",
        "[♣ : J]", "[♣ : Q]", "[♣ : K]",
        "[♦️ : A]", "[♦️ : 2]", "[♦️ : 3]", "[♦️ : 4]", "[♦️ : 5]", "[♦️ : 6]", "[♦️ : 7]", "[♦️ : 8]", "[♦️ : 9]", "[♦️ : 10]",
        "[♦️ : J]", "[♦️ : Q]", "[♦️ : K]"};
        return cards;
    }

    public static String[] shuffle(String[] cards) {
        Collections.shuffle(Arrays.asList(cards));
        return cards;
    }
}

/*
 카드 생성
 셔플
 컴퓨터와 대결
 1. 기본카드 두장씩 받고 둘중에 한장 보여줌 (컴의 카드가 보이는거 보이지 않는거를 나눠야함.) comp -> user -> 나란히 보이게 셋팅
 2. Thor 먼저 카드를 받음, 돌아가면서 카드가 돌아감(배팅은 없고 중간에 포기는 "다이"입력시 게임 종료)
 3. 카드는 손에 있는 카드를 포함하여 6장까지,
 4. 포커 점수계산.

 */