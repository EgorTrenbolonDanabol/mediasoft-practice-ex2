import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Car implements Comparable<Car> {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private int price;
    private CarType type; // нет по заданию, но я добавил

    public Car(String vin, String manufacturer, String model,  int year, int mileage, int price, CarType type) {
        this.vin = vin;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year);
    }

    @Override
    public String toString() {
        return String.format("VIN: %s, Производитель: %s, Модель: %s, Год: %d, Пробег: %d км, Цена: %d, Тип: %s",
                vin, manufacturer, model, year, mileage, price, type);
    }


    public String getVin() { return vin; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public int getPrice() { return price; }
    public CarType getType() { return type; }

    // Тест метода main для проверки HashSet и Comparable
    public static void main(String[] args) {
        Set<Car> carSet = new HashSet<>();

        Car car1 = new Car("VIN001", "Toyota", "Camry", 2015, 10000, 20000, CarType.SEDAN);
        Car car2 = new Car("VIN002", "BMW", "X5", 2019, 50000, 35000, CarType.SUV);
        Car car3 = new Car("VIN001", "Toyota", "Corolla", 2021, 15000, 18000, CarType.SEDAN); // Дубликат VIN с car1

        carSet.add(car1);
        carSet.add(car2);
        boolean added = carSet.add(car3);

        System.out.println("Добавлен ли car3? " + added);
        System.out.println("Машины в HashSet (без дубликатов VIN):");
        for (Car c : carSet) {
            System.out.println(c);
        }

        System.out.println("\nМашины в TreeSet (от новых к старым):");
        Set<Car> sortedCars = new TreeSet<>(carSet);
        for (Car c : sortedCars) {
            System.out.println(c);
        }
    }
}
