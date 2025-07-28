package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
    @SequenceGenerator(name = "cart_seq", sequenceName = "cart_seq", allocationSize = 1)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY) // Use @ManyToOne if user can have many carts
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "total_price",nullable = false)
    private int totalPrice;

    @Column(name = "active",nullable = false)
    private boolean active=true;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartEntry> cartEntries;
}
