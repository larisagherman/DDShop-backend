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
@Table(name = "address")
public class Address {
    @Id
    private int id;
    @Column(name = "street_line", nullable = false)
    private int streetLine;
    @Column(name = "postal_code", nullable = false)
    private int postalCode;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 50)
    private String county;
    @Column(nullable = false, length = 50)
    private String country;

    @OneToMany(mappedBy = "defaultDeliveryAddress")
    private List<User> usersWithThisDeliveryAddress;
    @OneToMany(mappedBy = "defaultBillingAddress")
    private List<User> usersWithThisBillingAddress;

    @OneToMany(mappedBy = "deliveryAddress")
    private List<Order> ordersWithThisDeliveryAddress;
    @OneToMany(mappedBy = "invoiceAddress")
    private List<Order> ordersWithThisInvoiceAddress;



}
