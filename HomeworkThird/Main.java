package HomeworkThird;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        BoxFruit<Apple> boxFruit = new BoxFruit<>();
        boxFruit.addFruit(boxFruit.createFruit(Apple.class));
        boxFruit.addFruit(boxFruit.createFruit(Apple.class));
        System.out.println("Weight appleBox: " + boxFruit.getBoxWeight());

        BoxFruit<Orange> boxFruit1 = new BoxFruit<>();
        boxFruit1.addFruit(boxFruit1.createFruit(Orange.class));
        System.out.println("Weight orangeBox: " + boxFruit1.getBoxWeight());

        System.out.println("Weights equals before merging - " + boxFruit.compare( boxFruit1));
        boxFruit1.addFruit(boxFruit1.createFruit(Orange.class));

        System.out.println("____________________________________________");

        BoxFruit<Apple> boxFruit2 = new BoxFruit<>();
        boxFruit2.addFruit(boxFruit.createFruit(Apple.class));
        boxFruit.addFruits(boxFruit2);
        System.out.println("After merging. Quantity box 1: " + boxFruit.getBoxWeight());
        System.out.println("After merging. Quantity box 2: " +boxFruit2.getBoxWeight());

        System.out.println("Weights equals after merging - " + boxFruit.compare(boxFruit1));
    }
}
