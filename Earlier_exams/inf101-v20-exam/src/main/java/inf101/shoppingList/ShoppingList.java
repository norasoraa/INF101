package inf101.shoppingList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements IShoppingList {

    private List<ShoppingItem> shoppingList;
    private final LocalDate dateCreated;

    public ShoppingList(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        this.shoppingList = new ArrayList<>();
    }

    @Override
    public List<ShoppingItem> getAllItems() {
        return shoppingList;
    }

    @Override
    public void add(ShoppingItem item) {
        if (item == null) {
            throw new IllegalArgumentException("The item is not a valid ShoppingItem.");
        }
        shoppingList.add(item);
    }

    @Override
    public LocalDate getDate() {
        return dateCreated;
    }

    @Override
    public double totalPrice() {
        double totalPrice = 0;
        for (ShoppingItem item : getAllItems()) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public int getItemCount(String itemName) {
        int count = 0;
        for (ShoppingItem item : getAllItems()) {
            if (item.getName().equals(itemName)) {
                count++;
            }
        }
        return count;
    }

}
