package no.UiB.CrashCourse.OOConcepts.abstraction;

/**
 * This class represents a car with a brand, model, color, year and price.
 * It is a good example of abstraction, as there is no need to know how the car works internally to use it.
 */
public class Car {
    
    private String brand;
    private String model;
    private String color;
    private int year;
    private int price;
    
    public Car(String brand, String model, String color, int year, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Price: " + price;
    }
    
    public boolean equals(Car car) {
        return this.brand.equals(car.getBrand()) && this.model.equals(car.getModel()) && this.color.equals(car.getColor()) && this.year == car.getYear() && this.price == car.getPrice();
    }
    
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", "Red", 2019, 20000);
        Car car2 = new Car("Toyota", "Corolla", "Red", 2019, 20000);
        Car car3 = new Car("Toyota", "Corolla", "Red", 2019, 20000);
        
        System.out.println(car1.equals(car2));
        System.out.println(car2.equals(car3));
    }
}
