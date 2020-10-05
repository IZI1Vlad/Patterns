public class AbstractMethod {
}
// Паттерн необходимый для создания всех доступных типов продуктов,
// Где каждая реализация фабрики создает продукты одной из вариаций.
// Клиентский код вызывает методы фабрики для получения продуктов, вместо самостоятельного создания с помощью
// оператора new.При этом фабрика сама следит за тем, чтобы создать продукт нужной вариации.

 interface Auto {
  public void getAuto();
}

 interface Boat {
  public void getBoat();
}

 class BMWAuto implements Auto {
   public void getAuto() {
    System.out.println("We create BMW boat");
    }
}

 class BMWBoat implements Boat {
     public void getBoat() {
         System.out.println("We create BMW boat");
     }
 }


 class PorcheAuto implements Auto {
     public void getAuto() {
         System.out.println("We create Porche Auto");
     }
 }

 class PorcheBoat implements Boat {
     public void getBoat() {
         System.out.println("We create Porche Boat");
     }
 }

 interface AbsFactory {
     Auto createAuto();
     Boat createBoat();
}

   class BMWFactory implements AbsFactory {
    public BMWFactory() {
        System.out.println("Creating Abs factory for BMW");
    }

    @Override
    public Auto createAuto() {
        System.out.println("Creating Auto for BMW");
        return new BMWAuto();
    }

    @Override
    public Boat createBoat() {
        System.out.println("Creating Boat for BMW");
        return new BMWBoat();
    }
}

class PorcheFactory implements AbsFactory {
    public PorcheFactory() {
        System.out.println("Creating Abs factory for Porche");
    }

    @Override
    public Auto createAuto() {
        System.out.println("Creating Auto for Porche");
        return new PorcheAuto();
    }

    @Override
    public Boat createBoat() {
        System.out.println("Creating Boat for Porche");
        return new PorcheBoat();
    }
}

// Код, использующий фабрику, не волнует с какой конкретно фабрикой он работает.
// Все получатели продуктов работают с продуктами через абстрактный интерфейс.

 class Application {
    private Auto auto;
    private Boat boat;

    public Application(AbsFactory factory) {
        auto = factory.createAuto();
        boat = factory.createBoat();
    }

    public void Get() {
        auto.getAuto();
        boat.getBoat();
    }
}

// Приложение выбирает тип и создаёт конкретные фабрики динамически исходя из конфигурации

 class App1 {

    private static Application configureApplication() {
        Application app;
        AbsFactory factory;
        String CarName = System.getProperty("Car.name").toLowerCase();
        if (CarName.contains("BMW")) {
            factory = new BMWFactory();
            app = new Application(factory);
        } else {
            factory = new PorcheFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.Get();
    }
}