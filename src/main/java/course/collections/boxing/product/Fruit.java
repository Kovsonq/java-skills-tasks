package course.collections.boxing.product;

import lombok.Data;

@Data
public abstract class Fruit {
    private float weight;

    protected Fruit(float weight) {
        this.weight = weight;
    }
}
