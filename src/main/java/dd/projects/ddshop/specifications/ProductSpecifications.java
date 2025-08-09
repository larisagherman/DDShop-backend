package dd.projects.ddshop.specifications;

import dd.projects.ddshop.entity.Product;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProductSpecifications {
    public static Specification<Product> hasCategory(String categoryName) {
        return (root, query, cb) -> {
            if(categoryName==null||categoryName.isEmpty()) {
                return cb.conjunction();
            }
            return cb.equal(root.get("categoryId").get("name"), categoryName);
        };
    }
    public static Specification<Product> hasIngredient(List<String> ingredients) {
        return (root, query, cb) -> {
            if(ingredients==null||ingredients.isEmpty()) {
                return cb.conjunction();
            }
            Join<Object, Object> attributesJoin = root.join("productAttributeSet");

            Predicate namePredicate=cb.equal(attributesJoin.get("name"), "ingredients");
            Predicate valuePredicate=attributesJoin.get("value").in(ingredients);
            return cb.and(namePredicate,valuePredicate);
        };
    }
    public static Specification<Product> hasFlavour(List<String> flavours) {
        return (root, query, cb) ->{
            if(flavours==null||flavours.isEmpty()) {
                return cb.conjunction();
            }
            Join<Object, Object> attributesJoin = root.join("productAttributeSet");
            Predicate namePredicate=cb.equal(attributesJoin.get("name"), "flavour");
            Predicate valuePredicate=attributesJoin.get("value").in(flavours);
            return cb.and(namePredicate,valuePredicate);
        };
    }
}
