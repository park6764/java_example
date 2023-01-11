
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;

public class ExampleClass {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        Shop shop = null;
        Order order = null;
        Review review = null;
        
        while(true) {
            System.out.println("1. 가게 및 메뉴 등록 \n2. 주문 \n3. 평점 매기기 \n4. 평점 조회 \n5. 매출 조회 \n6. 종료 ");
            System.out.print("원하시는 기능을 입력하세요: ");
            int i = Integer.parseInt(s.nextLine());
            switch (i) {
                case 1: shop = Shop.register(s, System.out); break;
                case 2: order = Order.mkOrder(shop, s, System.out); break;
                case 3: review = Review.eval(order, s, System.out); break;
                case 4: System.out.println(review.toString()); break;
                case 5: System.out.println("총 매출: " + review.getOrder().getTotalProfit() + "원"); break;
                case 6: return;
            
                default: System.out.println("1~6 사이를 입력하세요");
            }
        }
    }
}

class Shop {
    private String shopName;
    private ArrayList<Menu> menus;

    Shop(String name, ArrayList<Menu> menus) {
        shopName = name;
        this.menus = menus;
    }

    public String getShopName() { return shopName; }
    public ArrayList<Menu> getMenus() { return menus; }

    public static Shop register(Scanner s, PrintStream out) {
        out.print("음식점 이름을 입력하세요: ");
        String name = s.nextLine();
        var menus = Menu.registerMenus(s, out);
        return new Shop(name, menus);
    }
}

class Menu {
    private String foodName;
    private Integer price;

    Menu(String name, Integer price) {
        foodName = name;
        this.price = price;
    }
    public String getName() { return foodName; }
    public Integer getPrice() { return price; }

    @Override
    public String toString() {
        return foodName + " (" + price + "원)";
    }

    public static ArrayList<Menu> registerMenus(Scanner s, PrintStream out) {
        ArrayList<Menu> menus = new ArrayList();
        while(true) {
            out.print("메뉴 이름을 입력하세요\n(입력을 종료하려면 엔터키를 누르세요): ");
            var name = s.nextLine();
            if(name.equals("")) break;
            else {
                out.print("메뉴의 가격을 정수로 입력하세요\n(입력을 종료하려면 엔터키를 누르세요): ");
                var p = s.nextLine();
                if(p.equals("")) break;
                else {
                    var price = Integer.parseInt(p);
                    menus.add(new Menu(name, price));
                }
            }
        }
        return menus;
    }
}

class Order {
    private String customerName;
    private Shop shop;
    private ArrayList<Menu> orderedMenus;

    Order(String customerName, Shop shop, ArrayList<Menu> orderingMenus) {
        this.customerName = customerName;
        this.shop = shop;
        orderedMenus = orderingMenus;
    }
    public String getCustomerName() { return customerName; }
    public Shop getShop() { return shop; }
    public ArrayList<Menu> getOrderedMenus() { return orderedMenus; }

    public Integer getTotalProfit() {
        return orderedMenus.stream().map(Menu::getPrice).reduce(0, Integer::sum);
        // a b c d e -> 1 2 3 4 5 -(reduce)->> (1 + (2 + (3 + (4 + 5))))
    }

    public static Order mkOrder(Shop shop, Scanner s, PrintStream out) {
        out.print("주문하는 고객의 성함을 입력하세요: ");
        var customerName = s.nextLine();
        out.println("주문하시려는 가게 " + shop.getShopName() + "의 메뉴는 다음과 같습니다: ");
        shop.getMenus().forEach(m -> out.println(m.toString()));
        // for (var m : shop.getMenus()) {
        //     out.println(m.toString());
        // }
        ArrayList<Menu> orderingMenus = new ArrayList();
        while (true) {
            out.print("주문하려는 메뉴 이름을 입력하세요\n(입력을 종료하려면 엔터키를 누르세요):");
            var name = s.nextLine();
            if (name.equals("")) break;
            else {
                var menu1 = shop.getMenus().stream().filter(m -> m.getName().equals(name)).findFirst();
                if (menu1.isPresent()) {
                    orderingMenus.add(menu1.get());
                } else {
                    out.println("존재하지 않는 메뉴입니다. 다시 입력해 주세요");
                }
            }
        }
        return new Order(customerName, shop, orderingMenus);
    }
}

class Review {
    Order order;
    Integer grade;

    Review(Order order, Integer grade) {
        this.order = order;
        this.grade = grade;
    }

    public Order getOrder() { return order; }
    public Integer getGrade() { return grade; }

    @Override
    public String toString() {
        return 
            order.getCustomerName() + "가 " + order.getShop().getShopName() + "에서 주문했습니다. \n"
            + "주문한 메뉴는: \n"
            + order.getOrderedMenus().stream().map(Menu::toString).reduce("", (s1, s2) -> s1 + "\n" + s2)
            + "\n평점: " + generateStars(grade);
    }

    public static String generateStars(int i) {
        var s = "";
        for (int j = 0; j < i; j++) {
            s += "⭐️";
        }
        return s;
    }

    public static Review eval(Order order, Scanner s, PrintStream out) {
        Integer grade = 0;
        while(true) {
            out.print("주문하신 음식은 어떠셨나요? 1~5 사이의 평점을 입력해 주세요: ");
            var g = s.nextLine();
            if (!g.equals("")) {
                grade = Integer.parseInt(g);
                if (grade >= 1 && grade <= 5) {
                    return new Review(order, grade);
                } else {
                    out.println("입력한 숫자가 1~5 사이가 아닙니다. 다시 입력해 주세요");
                }
            } else {
                out.println("입력값이 숫자가 아니거나 비어 있습니다. 1~5 사이의 숫자를 입력해주세요");
            }
        }
    }
}