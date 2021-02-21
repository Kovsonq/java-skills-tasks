package course.collections.boxing.box;

import course.collections.boxing.product.Fruit;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Box<T extends Fruit> {
    ArrayList<T> arrayList = new ArrayList<>();
    private float boxWeight;

    public float getWeight() {
        if (this.arrayList.isEmpty()) {
            return 0;
        }
        return arrayList.size() * arrayList.get(0).getWeight();
    }

    public void addFruit(T fruit) {
        arrayList.add(fruit);
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.boxWeight - box.boxWeight) < 0.001;
    }

    public void changeBoxes(Box<T> box) {
        if (this.arrayList == box.arrayList) {
            return;
        }
        box.arrayList.addAll(this.arrayList);
        this.arrayList.clear();
    }

    public int getFruitQuantity() {
        return this.arrayList.size();
    }
}
