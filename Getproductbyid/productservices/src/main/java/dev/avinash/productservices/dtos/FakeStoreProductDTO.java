package dev.avinash.productservices.dtos;

import dev.avinash.productservices.models.Category;
import dev.avinash.productservices.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {

    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct( ){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setPrice(getPrice());
        product.setDescription(getDescription());
        product.setImage(getImage());

        // Convert the category string to a Category object
        Category categoryObj = new Category();
        categoryObj.setTitle(getCategory());
        product.setCategory(categoryObj);

        return product;
    }
}
