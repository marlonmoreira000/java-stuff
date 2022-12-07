import java.util.Objects;

public class Pants extends Product implements Discountable {
    private int waist;

    public Pants(int waist, double price, String color, String brand) {
        super(price, color, brand);
        this.waist = waist;
    }

    public Pants(Pants source) {
        super(source);
        this.waist = source.waist;
    }

    public int getWaist() {
        return this.waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pants)) {
            return false;
        }
        Pants pants = (Pants) obj;
        return this.waist == pants.waist &&
                super.getPrice() == pants.getPrice() &&
                super.getColor().equals(pants.getColor()) &&
                super.getBrand().equals(pants.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.waist,
                super.getPrice(),
                super.getColor(),
                super.getBrand());
    }
    
    @Override
    public String toString() {
        return "PANTS" +
                "\t" + this.getWaist() +
                "\t" + super.getPrice() +
                "\t" + super.getColor() +
                "\t" + super.getBrand();
    }

    @Override
    public void fold() {
        System.out.println("folding pants the pants way");
    }

    @Override
    public void discount() {
        super.setPrice(0.5 * super.getPrice());
        System.out.println("New pants price: $" + super.getPrice());
    }
}