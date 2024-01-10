package answer_kiosk;

public class Item extends Menu2 {

    Double price;	// 상품 가격

    Item(String name, Double price, String description) {
        super(name, description);
        this.price = price;
    }
}