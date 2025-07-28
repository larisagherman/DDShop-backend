package dd.projects.ddshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    private int id;
    @Column(name = "street_line", nullable = false)
    private String streetLine;
    @Column(name = "postal_code", nullable = false)
    private int postalCode;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 50)
    private String county;
    @Column(nullable = false, length = 50)
    private String country;

    @OneToOne(mappedBy = "defaultDeliveryAddress")
    private User defaultDeliveryAddress;
    @OneToOne(mappedBy = "defaultBillingAddress")
    private User defaultBillingAddress;

    @OneToOne(mappedBy = "deliveryAddress")
    private Order deliveryAddress;
    @OneToOne(mappedBy = "invoiceAddress")
    private Order invoiceAddress;



}
