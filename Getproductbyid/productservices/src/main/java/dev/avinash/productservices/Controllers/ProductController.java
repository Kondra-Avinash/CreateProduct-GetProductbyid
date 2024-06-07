package dev.avinash.productservices.Controllers;

import dev.avinash.productservices.dtos.CreateProductRequestDTO;
import dev.avinash.productservices.models.Product;
import dev.avinash.productservices.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    ProductService productservice;

    public ProductController(ProductService productservice) {

        this.productservice = productservice;
    }

    @PostMapping("/products")
    public Product createproduct(@RequestBody CreateProductRequestDTO productRequestDTO) {
        return productservice.createProduct(
                productRequestDTO.getTitle(),
                productRequestDTO.getDescription(),
                Double.parseDouble(productRequestDTO.getPrice()),
                productRequestDTO.getCategory(),
                productRequestDTO.getImage()
        );
    }

    @GetMapping("/products")
    public void getAllProducts(){

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable ("id") Long id){
        return productservice.getSingleProduct(id);

    }

    public void deleteProductBy(Long id){

    }
}


// @RequestBody is used to convert the requestbody that we are getting from fakestoreapi and
// convert it into CreateProductRequestDTO