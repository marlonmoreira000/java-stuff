public class Machine {
    private Item[][] items;

    public Machine(Item[][] items) {
        this.items = new Item[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }

    // return item from vending machine
    public Item getItem(int row, int spot) {
        return new Item(this.items[row][spot]);
    }

    public void setItem(Item item, int row, int spot) {
        this.items[row][spot] = new Item(item);
    }

    // reduce the quantity of an item by 1 after it had been purchased
    public void dispense(int row, int spot) {
        if (items[row][spot].getQuantity() == 0) {
            throw new IllegalArgumentException("cannot dispense item with quantity of 0");
        }
        items[row][spot].setQuantity(items[row][spot].getQuantity() - 1);
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            temp += "\t";
            for (int j = 0; j < items[i].length; j++) {
                temp += items[i][j].toString() + " ";
            }
            temp += "\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }

}
