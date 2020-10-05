public class FabrikMethod {
}

// Паттерн необходимый для создания обьектов любого типа,когда мы заранее не знаем какой обьект нам нужен
// По сути мы создаем заготовки для необходимых в программе класов,которые в последствии
// Автоматически создаются при помощи созданного нами интерфейса которые связывает все наши классы

   interface AutoCreator {
   public void setModel();
   public void setType();
   public void setYear();
}

    class BMW implements AutoCreator {

    String model;
    String type;
    int year;

    public void setModel() {
      String model = "530e";
    }

    public void setType() {
      String type = "Sedan";
    }

    public void setYear() {
        int year = 2007;
    }
}

    class Porche implements AutoCreator {

    String model;
    String type;
    int year;

    public void setModel() {
        String model = "Cayenne";
    }

    public void setType() {
        String type = "Crossover";
    }

    public void setYear() {
        int year = 2015;
    }
}

 class App {
    public static void main(String[] args) {
        AutoCreator BMW = new BMW();
        AutoCreator Porche = new Porche();
    }
}