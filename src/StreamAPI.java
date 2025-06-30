
import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("1", "Audi", "A4", 2022, 10000, 40000, CarType.SEDAN),
                new Car("2", "Toyota", "Camry", 2018, 60000, 25000, CarType.SEDAN),
                new Car("3", "Tesla", "Model S", 2023, 3000, 75000, CarType.ELECTRIC),
                new Car("4", "BMW", "X5", 2021, 45000, 50000, CarType.SUV),
                new Car("5", "Audi", "Q7", 2020, 5000, 60000, CarType.SUV)
        );

        // Фильтр по пробегу
        List<Car> lowMileage = cars.stream()
                .filter(c -> c.getMileage() < 50000)
                .collect(Collectors.toList());

        // Сортировка по цене (убыв.)
        List<Car> topByPrice = lowMileage.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Топ-3 дорогие машины:");
        topByPrice.forEach(System.out::println);

        double avgMileage = cars.stream().mapToInt(Car::getMileage).average().orElse(0);
        System.out.println("Средний пробег: " + avgMileage + " км");

        // Группировка по производителю
        Map<String, List<Car>> grouped = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("Группировка по производителю:");
        grouped.forEach((k, v) -> System.out.println(k + " => " + v.size() + " машин"));
    }
}
