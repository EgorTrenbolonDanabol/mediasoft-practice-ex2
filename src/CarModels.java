import java.util.*;

public class CarModels {
    public static void main(String[] args) {
        List<String> models = new ArrayList<>(Arrays.asList(
            "Toyota Camry", "BMW X5", "Tesla Model S", "Audi Q7", "BMW X5", "Tesla Model 3"
        ));

        Set<String> uniqueModels = new TreeSet<>(Collections.reverseOrder());
        for (String model : models) {
            if (model.contains("Tesla")) {
                uniqueModels.add("ELECTRO_CAR");
            } else {
                uniqueModels.add(model);
            }
        }
        uniqueModels.forEach(System.out::println);
        Set<String> finalSet = new HashSet<>(uniqueModels);
    }
}
