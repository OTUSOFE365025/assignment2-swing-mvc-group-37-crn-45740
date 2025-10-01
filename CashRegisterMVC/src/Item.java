public class Item {
    private final int upc;
    private final String name;
    private final float price;

    public Item(int upc, String name, float price) {
        this.upc = upc;
        this.name = name;
        this.price = price;
    }

    public int getUpc() {
        return upc;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
