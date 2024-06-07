package dev.avinash.productservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {

    private String Title;
    private String Description;
    private String Price;
    private String Category;
    private String image;
}
