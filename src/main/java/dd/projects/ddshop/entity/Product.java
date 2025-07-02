package dd.projects.ddshop.entity;

import jakarta.persistence.*;

import java.sql.Date;

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
    @Column(name = "categoryId", nullable = false)
    private int categoryId;

    protected Product() {}

    public Product(int id, String name, String description, int price, int availabilityQuantity, Date addedDate, int categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availabilityQuantity = availabilityQuantity;
        this.addedDate = addedDate;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvailableQuantity(int availabilityQuantity) {
        this.availabilityQuantity = availabilityQuantity;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availabilityQuantity;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public int getCategoryId() {
        return categoryId;
    }


}
