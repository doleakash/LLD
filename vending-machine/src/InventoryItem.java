public class InventoryItem {
    private final int id;
    private final int price;
    private final String name;


    public InventoryItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Press " + id + " for : " + name + "," + " price: " + price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
