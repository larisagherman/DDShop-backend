package dd.projects.ddshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_attribute")
public class ProductAttribute {
    @Id
    private int id;
    @Column(name = "name",length = 100,nullable = false)
    private String name;
    @Column(name = "product_id",nullable = false)
    private int productId;
    @Column(name = "value")
    private String value;

    public ProductAttribute() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public String getValue() {
        return value;
    }

    public ProductAttribute(int id, String name, int productId, String value) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.value = value;
    }
}
