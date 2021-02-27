package course.spring.task;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Service
public class ProductService {
    private List<Product> productList;

    public void printAll(){
        log.info("All products: {}" , productList);
    }

    public Product findByTitle(String title){
        return productList.stream().filter(o->o.getTitle().equals(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void ready(){
        productList = new ArrayList<>();
        productList.add(new Product(1,"Apple",12.3));
        productList.add(new Product(2,"Orange",11.5));
        productList.add(new Product(3,"Meat",5.1));
        productList.add(new Product(4,"Tomato",8.7));
        productList.add(new Product(5,"Cucumber",15.3));
        productList.add(new Product(6,"Potato",14.7));
        productList.add(new Product(7,"Apple2",12.4));
        productList.add(new Product(8,"Apple3",16.3));
        productList.add(new Product(9,"Apple4",12.8));
        productList.add(new Product(10,"Apple5",19.3));
    }
}
