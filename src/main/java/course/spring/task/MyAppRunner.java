package course.spring.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class MyAppRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        OrderService orderService = context.getBean("orderService", OrderService.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);

        productService.printAll();

        cart.addProductToCart(productService.findByTitle("Apple"));
        cart.addProductToCart(productService.findByTitle("Apple5"));
        cart.addProductToCart(productService.findByTitle("Orange"));
        cart.getCartProducts().forEach(o->log.info(o.toString()));
        orderService.makeOrderFromCart();

    }
}
