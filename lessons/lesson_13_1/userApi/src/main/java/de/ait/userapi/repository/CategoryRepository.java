package de.ait.userapi.repository;

import de.ait.userapi.model.Category;
import de.ait.userapi.model.Product;
import de.ait.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findAll();

    public Optional <Category> findById(Long id);

    public Category save(Category category);
}
