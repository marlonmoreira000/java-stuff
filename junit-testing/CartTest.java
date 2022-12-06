import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.addItem(new Item("Pepsi", 4.99));
        cart.addItem(new Item("Fanta", 4.99));
    }

    // Cart contains the item after it was added
    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Pepsi", 4.99)));
    }

    // Cart skips duplicate item
    @Test
    public void skipsDuplicateTest() {
        assertFalse(cart.addItem(new Item("Pepsi", 4.99)));
    }

    // Item gets removed after being sold
    @Test
    public void itemRemovedTest() {
        cart.remove("Fanta");
        assertFalse(cart.contains(new Item("Fanta", 4.99)));
    }

    // Subtotal is calculated correctly
    @Test
    public void subtotalCorrectTest() {
        assertEquals(9.98, cart.getSubtotal());
    }

    // Tax is calculated correctly
    @Test
    public void taxCorrectTest() {
        assertEquals(1.00, cart.getTax(9.98));
    }

    // Total is calculated correctly
    @Test
    public void totalCorrectTest() {
        assertEquals(10.98, cart.getTotal(9.98, 1.00));
    }

    // IllegalStateException when trying to remove from an empty cart
    @Test(expected = IllegalStateException.class)
    public void invalidRemoveStateTest() {
        cart.clear();
        cart.remove("Pepsi");
    }

    // IllegalStateException when trying to checkout an empty cart
    @Test(expected = IllegalStateException.class)
    public void invalidCheckoutStateTest() {
        cart.clear();
        cart.checkout();
    }
}
