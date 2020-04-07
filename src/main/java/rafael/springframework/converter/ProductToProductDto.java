package rafael.springframework.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rafael.springframework.controller.dto.ProductDto;
import rafael.springframework.domain.Product;

@Component
public class ProductToProductDto implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
