
package ma.ensa.tp5springvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensa.tp5springvt.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods can be defined here
}