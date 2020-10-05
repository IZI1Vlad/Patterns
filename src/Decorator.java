public class Decorator {
}

// Паттерн использующий композицию и агрегацию вместо наследования.
// Мы создаем обьекты обёртки вместо создания дочерних классов.
// Когда он нужен?Например когда класс final и мы не можем создать его наследников.



 interface Car {
    public int getSpeed();
    public int getBaggageWeight();
}


 class SimpleCar implements Car {
    private int speed = 50;
    private int baggageWeight = 100;

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getBaggageWeight() {
        return this.baggageWeight;
    }
}


 class SportCar implements Car {
    private Car car;
    public SportCar(Car car){
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed() + 50;
    }

    @Override
    public int getBaggageWeight() {
        return this.car.getBaggageWeight();
    }
}

 class Truck implements Car {
    private Car car;
    public Truck(Car car){
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed();
    }

    @Override
    public int getBaggageWeight() {
        return this.car.getBaggageWeight() + 1000;
    }
}

 class App4 {
    public static void main(String[] args) {
        Car simpleCar = new SimpleCar();
        System.out.println("Speed of simple car - " + String.valueOf(simpleCar.getSpeed()));
        System.out.println("Simple car can accept baggage with weight " + String.valueOf(simpleCar.getBaggageWeight()));

        Car sportCar = new SportCar(simpleCar);

        System.out.println("Speed of sport car - " + String.valueOf(sportCar.getSpeed()));
        System.out.println("Sport car can accept baggage with weight " + String.valueOf(sportCar.getBaggageWeight()));

        Car truck = new Truck(simpleCar);

        System.out.println("Speed of truck - " + String.valueOf(truck.getSpeed()));
        System.out.println("Truck can accept baggage with weight " + String.valueOf(truck.getBaggageWeight()));
    }
}