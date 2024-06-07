package dev.avinash.productservices.services;

import dev.avinash.productservices.dtos.FakeStoreProductDTO;
import dev.avinash.productservices.models.Category;
import dev.avinash.productservices.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate
                .getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDTO.getTitle());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product createProduct(String title, String description, double price, String category, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image); // Ensure image is set correctly
        fakeStoreProductDTO.setCategory(category); // Set category as String

        FakeStoreProductDTO response = restTemplate
                .postForObject("https://fakestoreapi.com/products",
                        fakeStoreProductDTO, FakeStoreProductDTO.class );

        return response.toProduct();
    }
}
