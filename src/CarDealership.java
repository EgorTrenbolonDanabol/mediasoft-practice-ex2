import java.util.*;
import java.util.stream.*;

public class CarDealership {
    private List<Car> cars = new ArrayList<>();

    public boolean addCar(Car car) {
        if (cars.stream().anyMatch(c -> c.equals(car))) return false;
        return cars.add(car);
    }

    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double averagePriceByType(CarType type) {
        return cars.stream()
                .filter(c -> c.getType() == type)
                .mapToInt(Car::getPrice)
                .average().orElse(0);
    }

    public List<Car> sortByYearDesc() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> countByType() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }

    public Optional<Car> getOldestCar() {
        return cars.stream().min(Comparator.comparingInt(Car::getYear));
    }

    public Optional<Car> getNewestCar() {
        return cars.stream().max(Comparator.comparingInt(Car::getYear));
    }
}