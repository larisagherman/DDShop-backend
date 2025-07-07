package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_entry")
public class CartEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_entry_seq")
    @SequenceGenerator(name = "cart_entry_seq", sequenceName = "cart_entry_seq", allocationSize = 1)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product productId;
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @Column(name = "price_per_piece",nullable = false)
    private int pricePerPiece;
    @Column(name = "total_price_per_entry",nullable = false)
    private int totalPricePerEntry;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cartId;





}
