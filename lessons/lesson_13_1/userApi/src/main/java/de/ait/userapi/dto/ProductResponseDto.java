package de.ait.userapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductResponseDto {
    Long id;
    private String title;
    private BigDecimal price;
    private CategoryResponseDto category;
}
