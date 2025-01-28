package singlylinkedlist.inventorymanagementsystem;

class InventoryManagement {
    private InventoryItem head;

    public InventoryManagement() {
        this.head = null;
    }

    // Add an item at the beginning
    public void addItemAtBeginning(String name, int id, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String name, int id, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    // Add an item at a specific position
    public void addItemAtPosition(String name, int id, int quantity, double price, int position) {
        if (position == 1) {
            addItemAtBeginning(name, id, quantity, price);
            return;
        }

        InventoryItem newItem = new InventoryItem(name, id, quantity, price);
        InventoryItem current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove an item by Item ID
    public void removeItemById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        InventoryItem current = head;
        while (current.next != null && current.next.itemId != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item not found");
        } else {
            current.next = current.next.next;
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int id, int quantity) {
        InventoryItem current = head;
        while (current != null) {
            if (current.itemId == id) {
                current.quantity = quantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found");
    }

    // Search for an item by ID or Name
    public void searchItem(String name, Integer id) {
        InventoryItem current = head;
        while (current != null) {
            if ((name != null && current.itemName.equals(name)) || (id != null && current.itemId == id)) {
                System.out.println("Item Found: " + current.itemName + " (ID: " + current.itemId + "), Quantity: " +
                        current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found");
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        double totalValue = 0.0;
        InventoryItem current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Sort the inventory by name or price
    public void sortInventory(boolean sortByPrice) {
        if (head == null || head.next == null) return;

        head = mergeSort(head, sortByPrice);
    }

    private InventoryItem mergeSort(InventoryItem head, boolean sortByPrice) {
        if (head == null || head.next == null) return head;

        InventoryItem middle = getMiddle(head);
        InventoryItem nextToMiddle = middle.next;
        middle.next = null;

        InventoryItem left = mergeSort(head, sortByPrice);
        InventoryItem right = mergeSort(nextToMiddle, sortByPrice);

        return merge(left, right, sortByPrice);
    }

    private InventoryItem merge(InventoryItem left, InventoryItem right, boolean sortByPrice) {
        if (left == null) return right;
        if (right == null) return left;

        InventoryItem result;
        if ((sortByPrice && left.price <= right.price) || (!sortByPrice && left.itemName.compareTo(right.itemName) <= 0)) {
            result = left;
            result.next = merge(left.next, right, sortByPrice);
        } else {
            result = right;
            result.next = merge(left, right.next, sortByPrice);
        }

        return result;
    }

    private InventoryItem getMiddle(InventoryItem head) {
        if (head == null) return head;

        InventoryItem slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display the inventory
    public void displayInventory() {
        InventoryItem current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " +
                    current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}
