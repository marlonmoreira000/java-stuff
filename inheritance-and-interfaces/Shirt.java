import java.util.Objects;

public class Shirt extends Product implements Discountable { 
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    private Size size;
    
    public Shirt(Size size, double price, String color, String brand) {
        super(price, color, brand);
        this.size = size;
    }

    public Shirt(Shirt source) {
        super(source);
        this.size = source.size;
    }
    
    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Shirt)) {
            return false;
        }
        Shirt shirt = (Shirt) obj; // we cast Object --> Shirt

        return this.size.equals(shirt.size) &&
                super.getPrice() == shirt.getPrice() &&
                super.getColor().equals(shirt.getColor()) &&
                super.getBrand().equals(shirt.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.size,
            super.getPrice(),
            super.getColor(),
            super.getBrand()
        );
    }

    @Override
    public String toString() {
        return "SHIRT" +
                "\t" + this.getSize() +
                "\t" + super.getPrice() +
                "\t" + super.getColor() +
                "\t" + super.getBrand();
    }
    
    @Override
    public void fold() {
        System.out.println("folding shirt the shirt way");
    }

    @Override
    public void discount() {
        super.setPrice(0.8 * super.getPrice());
        System.out.println("New shirt price: $" + super.getPrice());
    }
}