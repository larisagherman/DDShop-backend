package dd.projects.ddshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_attribute")
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_attribute_seq")
    @SequenceGenerator(name = "product_attribute_seq", sequenceName = "product_attribute_seq", allocationSize = 1)
    private int id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "productAttributeSet",fetch = FetchType.EAGER)
    private Set<Product> productSet;
    @Column(name = "value")
    private String value;

}
