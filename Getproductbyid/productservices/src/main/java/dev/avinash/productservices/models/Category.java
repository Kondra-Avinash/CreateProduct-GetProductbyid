package dev.avinash.productservices.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private long id;
    private String title;

    public Category() {
        // Default constructor
    }

    public Category(String title) {
        this.title = title;
    }
}
