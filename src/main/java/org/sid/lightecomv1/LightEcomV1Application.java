package org.sid.lightecomv1;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecomv1.dao.CategoryRepository;
import org.sid.lightecomv1.dao.ProductRepository;
import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

//For test
// implements commandlinerunner
// creer nos repository
// ajouter dans la method run de commandlinerunner la creation des elemnts en DB

@SpringBootApplication
public class LightEcomV1Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(LightEcomV1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null, "Computer", null, null));
        categoryRepository.save(new Category(null, "Printer", null, null));
        categoryRepository.save(new Category(null, "Smart phone", null, null));


        Random rdn = new Random();

        categoryRepository.findAll().forEach(c -> {

            for (int i = 0; i < 10 ; i++) {
                Product product = new Product();
                product.setName(RandomString.make(18));
                product.setCurrentPrice(100 + rdn.nextInt(10000));
                product.setAvailable(rdn.nextBoolean());
                product.setPromotion(rdn.nextBoolean());
                product.setSelected(rdn.nextBoolean());
                product.setCategory(c);
                productRepository.save(product);
            }

        });

    }
}
