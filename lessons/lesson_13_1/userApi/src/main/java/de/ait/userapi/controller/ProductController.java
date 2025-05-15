package de.ait.userapi.controller;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import de.ait.userapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDto> getListOfProducts() {
        return service.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id) {
        return service.findProductById(id);
    }


    @PostMapping("/products")
     public ProductResponseDto addProduct(@RequestBody ProductRequestDto dto) {
        return service.save(dto);
    }
}
