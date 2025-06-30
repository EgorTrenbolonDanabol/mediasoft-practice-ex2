import java.util.Random;
import java.util.Arrays;

public class ArrayCars {
    public static void main(String[] args) {
        int[] carYears = new int[50];
        Random rand = new Random();
        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = rand.nextInt(2026 - 2000) + 2000;
        }

        System.out.println("Машины после 2015:");
        Arrays.stream(carYears).filter(y -> y > 2015).forEach(System.out::println);

        double avgAge = Arrays.stream(carYears)
                .map(y -> 2025 - y)
                .average().orElse(0);
        System.out.println("Средний возраст авто: " + avgAge);
    }
}