
package ma.ensa.tp5springvt.services;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensa.tp5springvt.models.Product;
import ma.ensa.tp5springvt.repositories.ProductRepository;

@Service
public class ProductsService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() throws InterruptedException {
        Thread.sleep(1000); // simuler la latence réseau
        return productRepository.findAll();
    }

    public String bulkSaveProduct() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Product product = new Product();
            product.setProductName(RandomStringUtils.randomAlphanumeric(5));
            product.setPrice(RandomUtils.nextLong(10, 1000));
            product.setPrice(1L);
            saveOrUpdate(product);
        }
        return "finished";
    }

    public Product getProductsById(Long id) {
        return productRepository.findById(id).get();
    }

    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public void update(Product product, long productid) {
        productRepository.save(product);
    }
}