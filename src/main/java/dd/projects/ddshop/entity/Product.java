package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "availability_quantity", nullable = false)
    private int availabilityQuantity;
    @Column(name = "addedDate", nullable = true)
    private Date addedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category categoryId;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImageUrls;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "product_product_attribute",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_attribute_id")
    )
    private Set<ProductAttribute> productAttributeSet;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartEntry> cartEntries = new HashSet<>();

    @PreRemove
    private void removeAssociations() {
        for (ProductAttribute attribute : productAttributeSet) {
            attribute.getProductSet().remove(this); // Step 1: remove this product from each attribute's set
        }
        productAttributeSet.clear(); // Step 2: clear this product's reference to attributes
    }

}
