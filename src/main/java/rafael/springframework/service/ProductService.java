package rafael.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rafael.springframework.controller.dto.ProductDto;
import rafael.springframework.converter.ProductDtoToProduct;
import rafael.springframework.domain.Product;
import rafael.springframework.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductDtoToProduct productDtoToProduct;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductDtoToProduct productDtoToProduct) {
        this.productRepository = productRepository;
        this.productDtoToProduct = productDtoToProduct;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        this.productRepository.findAll().forEach(products::add);

        return products;
    }

    public Product getById(UUID id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Product saveOrUpdate(Product product) {
        return this.productRepository.save(product);
    }

    public void delete(UUID id) {
        this.productRepository.deleteById(id);
    }

    public Product saveOrUpdateProductDto(ProductDto productDto) {
        return this.saveOrUpdate(this.productDtoToProduct.convert(productDto));
    }
}