import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vehicles {

    private static List<Car> makeCarList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("lada", "red", "type1"));
        cars.add(new Car("bmw", "black", "type2"));
        cars.add(new Car("mers", "white", "type3"));
        cars.add(new Car("kia", "red", "type1"));
        cars.add(new Car("ford", "gray", "type2"));
        return cars;
    }

    private static void printToFile(List<Car> cars) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter("cars.txt"))) {
            output.write(cars.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printToFile2(List<Car> cars) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter("cars.txt"))) {
            for (Car car : cars)
                output.write(car.mark + " " + car.color + " " + car.type + System.lineSeparator());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Car> readFromFile() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader("cars.txt"))) {
            String line = input.readLine();
            line = line.substring(1, line.length() - 1);
            String[] dividedLine = line.split("}, ");
            for (String s : dividedLine) {
                cars.add(new Car(s));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    private static List<Car> readFromFile2() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            String[] dividedLine;
            while ((line = input.readLine()) != null) {
                dividedLine = line.split(" ");
                cars.add(new Car(dividedLine[0], dividedLine[1], dividedLine[2]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    public static void main(String[] args) {
        List<Car> cars = makeCarList();
        printToFile2(cars);
        cars = readFromFile2();
        System.out.println(cars);
    }
}