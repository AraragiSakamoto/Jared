import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void simulateZoo() {
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getName() + ":");
            animal.makeSound();
            animal.eat();
            animal.sleep();
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Zoo!");

        // Prompt user to add animals interactively
        while (true) {
            System.out.println("\nAdd a new animal to the zoo:");
            System.out.print("Enter animal type (Mammal, Bird, Reptile, Fish): ");
            String type = scanner.next().toLowerCase();
            if (!isValidType(type)) {
                System.out.println("Invalid animal type. Please try again.");
                continue;
            }

            System.out.print("Enter animal name: ");
            String name = scanner.next();
            System.out.print("Enter animal age: ");
            int age = scanner.nextInt();
            System.out.print("Enter animal weight: ");
            double weight = scanner.nextDouble();

            Animal animal = createAnimal(type, name, age, weight);

            zoo.addAnimal(animal);

            System.out.print("Add another animal? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        // Simulate the zoo after adding animals
        System.out.println("\nZoo...");
        zoo.simulateZoo();

        scanner.close();
    }

    private static boolean isValidType(String type) {
        return type.equals("mammal") || type.equals("bird") || type.equals("reptile") || type.equals("fish");
    }

    private static Animal createAnimal(String type, String name, int age, double weight) {
        switch (type) {
            case "mammal":
                return new Mammal(name, age, weight);
            case "bird":
                return new Bird(name, age, weight);
            case "reptile":
                return new Reptile(name, age, weight);
            case "fish":
                return new Fish(name, age, weight);
            default:
                throw new IllegalArgumentException("Invalid animal type: " + type);
        }
    }
}