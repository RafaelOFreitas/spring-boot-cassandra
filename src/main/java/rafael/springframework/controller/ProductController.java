package rafael.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rafael.springframework.controller.dto.ProductDto;
import rafael.springframework.converter.ProductToProductDto;
import rafael.springframework.domain.Product;
import rafael.springframework.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductToProductDto productToProductDto;

    @Autowired
    public void setProductToProductDto(ProductToProductDto productToProductDto) {
        this.productToProductDto = productToProductDto;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getAll();
    }

    @PostMapping
    public Product saveOrUpdateProduct(@Valid @RequestBody ProductDto productDto) {
        return this.productService.saveOrUpdateProductDto(productDto);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return this.productService.getById(UUID.fromString(id));
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable String id) {
        Product product = this.productService.getById(UUID.fromString(id));

        return this.productToProductDto.convert(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.productService.delete(UUID.fromString(id));
    }
}