public class Car {
    String mark, color, type;

    public Car(String car) {
        int pos;
        pos = car.indexOf("mark='") + 6;
        mark = car.substring(pos, car.indexOf("'", pos));
        pos = car.indexOf("color='", pos) + 7;
        color = car.substring(pos, car.indexOf("'", pos));
        pos = car.indexOf("type='", pos) + 6;
        type = car.substring(pos, car.indexOf("'", pos));
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
