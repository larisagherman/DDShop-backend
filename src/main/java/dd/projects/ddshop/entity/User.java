package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_")
public class User {
    @Id
    private int id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number",nullable = false)
    private Long phoneNumber;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name ="default_delivery_address" , nullable = false)
    private Address defaultDeliveryAddress;
    @ManyToOne
    @JoinColumn(name ="default_billing_address" , nullable = false)
    private Address defaultBillingAddress;

    @OneToMany(mappedBy = "userId")
    private List<Order> orders;
    @OneToOne(mappedBy = "userId")
    private Cart cart;


}
