import java.lang.reflect.Field;

public class Car {
    String mark, color, type;

    public Car(String carStr) {
        String className = getClass().getName();
        Field[] fields = getClass().getDeclaredFields();
        carStr = carStr.replace(className + "{", "");
        carStr = carStr.replace("}", "");
        carStr = carStr.replace("'", "");
        String[] splittedLine = carStr.split(", ");
        mark = splittedLine[0].replace(fields[0].getName() + "=", "");
        color = splittedLine[1].replace(fields[1].getName() + "=", "");
        type = splittedLine[2].replace(fields[2].getName() + "=", "");
    }

    public Car(String mark, String color, String type) {
        this.mark = mark;
        this.color = color;
        this.type = type;
    }

    public Car() {
    }

    public void noise() {
        System.out.println("Br-br-br");
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
