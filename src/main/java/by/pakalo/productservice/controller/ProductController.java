package by.pakalo.productservice.controller;

import by.pakalo.productservice.dto.ProductRequest;
import by.pakalo.productservice.dto.ProductResponse;
import by.pakalo.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductsByName(@PathVariable String name){
        return  productService.getProductsByName(name);
    }
}
