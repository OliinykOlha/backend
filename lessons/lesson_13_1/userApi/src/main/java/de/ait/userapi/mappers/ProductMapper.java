package de.ait.userapi.mappers;


import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
     List<ProductResponseDto> toResponseDtoList(List<Product> products);
     ProductResponseDto toResponseDto(Product product);
     Product fromRequestDto(ProductRequestDto dto);

}
