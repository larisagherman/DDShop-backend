package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userId;
    @Column(name = "total_price",nullable = false)
    private int totalPrice;
    @OneToMany(mappedBy = "cartId",cascade = CascadeType.ALL)
    private List<CartEntry> cartEntries;
}
