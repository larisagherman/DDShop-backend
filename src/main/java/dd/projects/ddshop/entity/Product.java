package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
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

    @ManyToMany(mappedBy = "productSet",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<ProductAttribute> productAttributeSet;
    @OneToOne(mappedBy = "productId")
    private CartEntry cartEntry;
    @PreRemove
    private void removeAssociations() {
        for (ProductAttribute attribute : productAttributeSet) {
            attribute.getProductSet().remove(this); // Step 1: remove this product from each attribute's set
        }
        productAttributeSet.clear(); // Step 2: clear this product's reference to attributes
    }

}
