import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarDealership dealership = new CarDealership();

        while (true) {
            System.out.println("\n1. Добавить машину");
            System.out.println("2. Найти по производителю");
            System.out.println("3. Средняя цена по типу");
            System.out.println("4. Сортировка по году");
            System.out.println("5. Статистика по типу");
            System.out.println("6. Самая старая/новая машина");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("VIN: ");
                    String vin = scanner.nextLine();
                    System.out.print("Производитель: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Год выпуска: ");
                    int year = scanner.nextInt();
                    System.out.print("Пробег: ");
                    int mileage = scanner.nextInt();
                    System.out.print("Цена: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Тип (SEDAN, SUV, ELECTRIC, TRUCK, HATCHBACK): ");
                    String typeStr = scanner.nextLine().toUpperCase();

                    CarType type;
                    try {
                        type = CarType.valueOf(typeStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный тип машины. Используется SEDAN по умолчанию.");
                        type = CarType.SEDAN;
                    }

                    Car car = new Car(vin, manufacturer, model,  year, mileage, price, type);
                    if (dealership.addCar(car)) {
                        System.out.println("Машина добавлена.");
                    } else {
                        System.out.println("Машина с таким VIN уже существует.");
                    }
                    break;

                case 2:
                    System.out.print("Производитель: ");
                    String maker = scanner.nextLine();
                    dealership.findByManufacturer(maker).forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Тип (SEDAN, SUV, ELECTRIC, TRUCK, HATCHBACK): ");
                    try {
                        CarType carType = CarType.valueOf(scanner.nextLine().toUpperCase());
                        System.out.println("Средняя цена: " + dealership.averagePriceByType(carType));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный тип машины.");
                    }
                    break;

                case 4:
                    dealership.sortByYearDesc().forEach(System.out::println);
                    break;

                case 5:
                    dealership.countByType().forEach((t, c) -> System.out.println(t + ": " + c));
                    break;

                case 6:
                    System.out.println("Старая: " + dealership.getOldestCar().orElse(null));
                    System.out.println("Новая: " + dealership.getNewestCar().orElse(null));
                    break;

                case 0:
                    System.out.println("Выход...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}
