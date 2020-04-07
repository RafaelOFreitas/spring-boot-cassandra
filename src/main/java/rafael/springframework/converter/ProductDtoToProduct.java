package rafael.springframework.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import rafael.springframework.controller.dto.ProductDto;
import rafael.springframework.domain.Product;

@Component
public class ProductDtoToProduct implements Converter<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        Product product = new Product();

        if (productDto.getId() != null && !StringUtils.isEmpty(productDto.getId())) {
            product.setId(productDto.getId());
        }

        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());

        return product;
    }
}