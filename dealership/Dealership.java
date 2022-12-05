public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    public Car getCar(int index) {
        if (this.cars[index] == null) {
            return null;
        }
        return new Car(this.cars[index]);
    }
    
    public void sell(int index) {
        if (this.isEmpty()) {
            throw new IllegalStateException("can't sell car because dealership is empty");
        }
        this.cars[index].drive();
        this.cars[index] = null;
    }

    public boolean isEmpty() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public int getLength() {
        return this.cars.length;
    }
     
    public String toString() {
        String temp = "\n\n";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "\tParking Spot: " + i + "\n";
            if (this.cars[i] == null) {
                temp += "\tEmpty\n\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }


}
