package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_entry")
public class CartEntry {
    @Id
    private int id;
    @Column(name = "product_id",nullable = false)
    private int productId;
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @Column(name = "price_per_piece",nullable = false)
    private int pricePerPiece;
    @Column(name = "total_price_per_entry",nullable = false)
    private int totalPricePerEntry;
    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cartId;





}
