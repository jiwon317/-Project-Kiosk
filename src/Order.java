import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Order {
    private ArrayList<Product> shoppingBag = new ArrayList<Product>();
    private HashSet<Product> soldProduct = new HashSet<Product>();
    private int counter = 0;

    public void AddOrder(Product product) {
        Scanner sc = new Scanner(System.in);
        int input;

        if(product.getSizeupPrice() != 0) {
            product.Show();
            Product sizeupProduct = new Product(product.getName(), product.getDescription(), product.getSizeupPrice(), product.getCategory());
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.println("1. Single(W " + product.getPrice() + ")         2. Double(W " + product.getPrice() + ")");
            input = sc.nextInt();
            if (input == 1) {
                question(product);
            } else if (input == 2) {
                question(sizeupProduct);
            }
        } else
            question(product);
    }
    public void question (Product product) {
        Scanner sc = new Scanner(System.in);
        int input;
        product.Show();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        input = sc.nextInt();
        if (input == 1) {
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            shoppingBag.add(product);
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
        }
    }
    public double getShoppingBag() {
        double totalprice = 0;
        int EA;
        HashSet<Product> productCountSet = new HashSet<Product>(shoppingBag);
        for (Product item : productCountSet) {
            EA = Collections.frequency(shoppingBag, item);
            item.Show(EA);
            totalprice += item.getPrice() * EA;
        }
        totalprice=Math.round((totalprice*100))/100.0;
        return totalprice;
    }
    public int CompleteOrder() {
        soldProduct.addAll(shoppingBag);
        shoppingBag.clear();
        counter++;
        return counter;
    }
    public void CancelOrder() {
        shoppingBag.clear();
    }
    public void SoldList(){
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for(Product item : soldProduct) {
            System.out.printf("%-20s | W %s\n", item.getName(), item.getPrice());
        }
    }
}
