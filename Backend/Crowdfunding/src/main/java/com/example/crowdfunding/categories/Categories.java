package com.example.crowdfunding.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE_CATEGORY")
    @SequenceGenerator(name = "SEQUENCE_CATEGORY", sequenceName = "categories_category_id_seq", allocationSize = 1)
    private Long categoryId;
    private String categoryName;
}
