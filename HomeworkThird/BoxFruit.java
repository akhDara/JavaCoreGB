package HomeworkThird;

import java.util.ArrayList;
import java.util.Collection;

public class BoxFruit<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public BoxFruit(){

    }

    public boolean compare(BoxFruit boxFruit){
        return (boxFruit.getBoxWeight() - this.getBoxWeight() == 0);
    }

    public void addFruits(BoxFruit<T> boxFruit){
        if(boxFruit.getFruits().getClass().equals(fruits.getClass())){
            this.fruits.addAll((Collection<? extends T>) boxFruit.getFruits());
            boxFruit.setFruits(new ArrayList<>());
        }
    }

    public T createFruit(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }

    public void addFruit(Fruit fruit){
        this.fruits.add((T) fruit);
    }

    public float getBoxWeight(){
        return this.fruits.stream().map(Fruit::getWeight).reduce(0f, Float::sum);
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public ArrayList<? extends Fruit> getFruits() {
        return fruits;
    }
}
