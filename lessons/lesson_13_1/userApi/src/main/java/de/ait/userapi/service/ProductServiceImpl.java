package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.mappers.ProductMapper;
import de.ait.userapi.model.Category;
import de.ait.userapi.model.Product;
import de.ait.userapi.repository.CategoryRepository;
import de.ait.userapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper mapper;
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<ProductResponseDto> findAllProducts() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProductResponseDto findProductById(Long id) {
        return repository.findById(id).map(mapper::toResponseDto).orElse(null);
    }

    @Override
    public ProductResponseDto save(ProductRequestDto dto) {
        Product product = mapper.fromRequestDto(dto);
       Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        product.setCategory(category);
       Product saved = repository.save(product);
        return mapper.toResponseDto(saved);
    }
}
