package de.ait.userapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String title;
   private BigDecimal price;
   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;
}
