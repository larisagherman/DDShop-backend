package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data//to generate getters and setters
@Entity
@Table(name = "order_")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userId;
    @OneToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cartId;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type",nullable = false)
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn (name = "delivery_address",nullable = false)
    private Address deliveryAddress;
    @ManyToOne
    @JoinColumn(name = "invoice_address",nullable = false)
    private Address invoiceAddress;
    @Column(name = "total_price",nullable = false)
    private int totalPrice;
    @Column(name = "order_date",nullable = false)
    private Date orderDate;


}
