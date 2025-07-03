package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_attribute")
public class ProductAttribute {
    @Id
    private int id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "product_product_attribute", // join table name
            joinColumns = @JoinColumn(name = "product_attribute_id"), // this entity's FK
            inverseJoinColumns = @JoinColumn(name = "product_id") // FK to Product
    )
    private Set<Product> productSet;
    @Column(name = "value")
    private String value;

}
