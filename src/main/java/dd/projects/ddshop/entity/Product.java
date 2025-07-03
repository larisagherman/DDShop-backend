package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
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
    @ManyToMany(mappedBy = "productSet")
    private Set<ProductAttribute> productAttributeSet;
    @OneToOne(mappedBy = "productId")
    private CartEntry cartEntry;
}
