package singlylinkedlist.inventorymanagementsystem;

public class Inventory {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addItemAtEnd("Laptop", 1, 10, 80000);
        inventory.addItemAtBeginning("Mouse", 2, 50, 500);
        inventory.addItemAtPosition("Keyboard", 3, 30, 1500, 2);

        inventory.displayInventory();

        System.out.println("Updating quantity of item ID 1 to 15");
        inventory.updateQuantityById(1, 15);

        inventory.searchItem("Mouse", null);

        System.out.println("Total Inventory Value: " + inventory.calculateTotalValue());

        System.out.println("Sorting inventory by price...");
        inventory.sortInventory(true);
        inventory.displayInventory();

        System.out.println("Removing item ID 2");
        inventory.removeItemById(2);

        inventory.displayInventory();
    }
}
