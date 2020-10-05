public class Bridge {
}

// Паттерн который может разделить большой и сложный класс на две подгруппы "Абстракция" и "реализация"
// К примеру такие пары как "Марка" авто и "Цвет".
// Или более применимое в разработке "Приложение" и "Опер. система" (Windows,Linux,Mac OS)
// Для чего это нужно? 1) Если необходимо расширить количество сущностей в две стороны.
// 2) Если есть желание разделить большой класс, который не отвечает принципу Single responsibility.
// 3) Если есть необходимость спрятать реализацию.
// Данный паттер это прямая реализация принципов OpenClose и SingleResponsibility Solid.

 interface Color {
   public void fillColor();
}

 class BlackColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in black color");
    }
}

 class GreenColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in green color");
    }
}

 class RedColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in red color");
    }
}

 class Brand {
    protected Color color;

    public Brand(Color color) {
        this.color = color;
    }

    public void create() {}
}

 class BMW2 extends Brand {

    public BMW2(Color color) {
        super(color);
        this.color = color;
    }

    @Override
    public void create() {
        System.out.println("Creating BMW");
        color.fillColor();
    }
}

 class Porche2 extends Brand {

    public Porche2(Color color) {
        super(color);
        this.color = color;
    }

    @Override
    public void create() {
        System.out.println("Creating Porche");
        color.fillColor();
    }
}

 class App3 {
    public static void main(String[] args) {
        paintCar(new BMW2());
        paintCar(new Porche2());
    }

    public static void paintCar(Color color) {
        System.out.println("Painting our car.");
        Brand brand = new Brand(color);
        brand.create();
        color.fillColor();
    }
}