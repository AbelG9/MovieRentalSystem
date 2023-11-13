package Models;

public class RentalItem {
    private String itemName;
    private int itemID;
    private boolean isAvailable;

    public RentalItem(String itemName, int itemID, boolean isAvailable) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.isAvailable = isAvailable;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void showDetails(){
        System.out.println("Item id: " + this.itemID);
        System.out.println("Item name: " + this.itemName);
        System.out.println("Is available: " + this.isAvailable);
    }
}
