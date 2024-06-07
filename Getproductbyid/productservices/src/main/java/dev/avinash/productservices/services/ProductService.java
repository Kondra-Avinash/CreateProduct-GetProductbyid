package dev.avinash.productservices.services;

import dev.avinash.productservices.models.Product;


public interface ProductService {

    public Product getSingleProduct(Long id);

    public Product createProduct(String Title, String Description , double Price
    , String Category, String image);
}
