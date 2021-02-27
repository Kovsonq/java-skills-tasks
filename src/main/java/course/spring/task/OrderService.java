package course.spring.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private Cart cart;

    @Autowired
    public OrderService(Cart cart) {
        this.cart = cart;
    }

    public void makeOrderFromCart(){
        double sum = 0;
         for (Product product : this.cart.getCartProducts()) {
             sum+=product.getCost();
         }
         log.info("All items: {}, \n Total sum: {}", this.cart.getCartProducts(), sum);
    }
}
