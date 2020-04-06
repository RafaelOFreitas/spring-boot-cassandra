package rafael.springframework.repository;

import org.springframework.data.repository.CrudRepository;
import rafael.springframework.domain.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
