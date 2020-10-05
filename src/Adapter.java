public class Adapter {
}

// Паттерн позволяющий обьектам с несовместимыми интерфейсами работать вместе
// через специальный класс который имплементит необходимый интерфейс.


 interface Road {
    void run();
}

 class Runner {
    private Road road;

    public Runner() {}

    public Runner(Road road){
        this.road = road;
    }

    public void runOnTheRoad() {
        System.out.println("Let's run");
        road.run();
        System.out.println("Finish");
    }
}

 class IceRoad {
    void walk() {
        System.out.println("Someone walk on the ice road");
    };
}

 class IceRoadAdapter implements Road {
    private IceRoad road;

    public IceRoadAdapter() {
        road = new IceRoad();
    }

    public void run() {
        road.walk();
    }
}

 class App2 {
    public static void main(String[] args){
        Runner runner = new Runner(new IceRoadAdapter());
        runner.runOnTheRoad();
    }
}