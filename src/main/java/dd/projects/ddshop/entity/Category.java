package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    private String description;
    @OneToMany(mappedBy = "categoryId")
    private List<Product> products;
}
