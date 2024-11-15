
package ma.ensa.tp5springvt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ensa.tp5springvt.models.Product;
import ma.ensa.tp5springvt.services.ProductsService;

@RestController
public class Controller {
    @Autowired
    ProductsService productsservice;

    @GetMapping("/products")
    private List<Product> getAllProducts() throws InterruptedException {
        return productsservice.getProducts();
    }

    @GetMapping("/products/{productid}")
    private Product getProduct(@PathVariable("productid") long id) {
        return productsservice.getProductsById(id);
    }

    @DeleteMapping("/products/{productid}")
    private void deleteProduct(@PathVariable("productid") int id) {
        productsservice.delete(id);
    }

    @PostMapping("/products")
    private long saveProduct(@RequestBody Product product) {
        productsservice.saveOrUpdate(product);
        return product.getId();
    }

    @PutMapping("/products/{productid}")
    private Product update(@RequestBody Product product, @PathVariable("productid") long id) {
        productsservice.update(product, id);
        return product;
    }

    @PostMapping("/bulksave")
    public String BulkProduct() throws InterruptedException {
        return productsservice.bulkSaveProduct();
    }
}