package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
//to get only the id and the names of the categories
@Data
@AllArgsConstructor
public class CategoryDTOResponse2 {
    private int id;
    private String name;
}
