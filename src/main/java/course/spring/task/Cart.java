package course.spring.task;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Component
public class Cart {
    private List<Product> cartProducts;

    public void addProductToCart(Product product){
        cartProducts.add(product);
        log.info("Product {} was added", product.getTitle());
    }

    @PostConstruct
    public void init(){
        cartProducts = new ArrayList<>();
    }
}
