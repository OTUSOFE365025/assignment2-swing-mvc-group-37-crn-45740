public class Display {
    public void addItem(Item item){
        String name = item.getName();
        double price = item.getPrice();
        System.out.println(name + " " + price);
    }

    public void setSubtotal(double price){
        System.out.println("Total: $" + price);
    }
}
