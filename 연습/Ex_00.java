import java.util.ArrayList;
import java.util.Arrays;

public class Ex_00{
    public static void main(String[] args) {
        System.out.println("연습 코드");
        
        var l = new ArrayList<Integer>(Arrays.asList(1, 3, 5));
        var l_ = new ArrayList<Integer>();
        l.addAll(l_);
        System.out.println(l);
        System.out.println(l_);
    }
}



// class Shop {
//     private String shopName;
//     private ArrayList<Menu> menus;

//     Shop(String name, ArrayList<Menu> menus) {
//         shopName = name;
//         this.menus = menus;
//     }

//     public String getShopName() { return shopName; }
//     public ArrayList<Menu> getMenus() { return menus; }
// }

// class Menu {
//     private String foodName;
//     private Integer price;

//     Menu(String name, Integer price) {
//         foodName = name;
//         this.price = price;
//     }
//     public String getName() { return foodName; }
//     public Integer getPrice() { return price; }
// }

// class Order {
//     private String customerName;
//     private Shop shop;
//     private ArrayList<Menu> orderedMenus;

//     Order(String customerName, Shop shop, ArrayList<Menu> orderingMenus) {
//         this.customerName = customerName;
//         this.shop = shop;
//         orderedMenus = orderingMenus;
//     }
//     public String getCustomerName() { return customerName; }
//     public Shop getShop() { return shop; }
//     public ArrayList<Menu> getOrderedMenus() { return orderedMenus; }
// }

// class Review {
//     Order order;
//     Integer grade;

//     Review(Order order, Integer grade) {
//         this.order = order;
//         this.grade = grade;
//     }

//     public Order getOrder() { return order; }
//     public Integer getGrade() { return grade; }
// }

// -------------------------------------------------------- //

