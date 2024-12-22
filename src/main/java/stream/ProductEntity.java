package stream;

public class ProductEntity {
    private final String name;
    private final int price;

    public ProductEntity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
