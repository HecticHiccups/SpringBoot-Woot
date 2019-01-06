package com.example.server.services;


import com.example.server.models.Product;
import com.example.server.repositories.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import javax.validation.Valid;
import java.net.URISyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /**
     * @param product
     * @return ResponseEntity
     * @throws URISyntaxException
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value ="/product")
    public ResponseEntity <Product> createProduct(@Valid @RequestBody Product product) throws URISyntaxException{
        log.info("Request to create product: {}", product);
        Product result = productRepository.save(product);
        return ResponseEntity.created(new URI("/api/product/" + result.getProductID())).body(result);
    }

    /**
     * @param product
     * @return
     */

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/product")
    public ResponseEntity<Product> updateProducts(@Valid @RequestBody Product product){
        log.info("Request to update product: {}", product);
        Product result = productRepository.save(product);
        return ResponseEntity.ok().body(result);
    }


    /**
     * @param prdct
     * @param id
     * @return Product
     * Todo:Need to find a way to return ResponseEntity...
     * Todo:Not updating correctly, it inserts a new Object instead of Updating
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/product/{id}")
    public Product updateProduct(@Valid @RequestBody Product prdct, @PathVariable Long id){
        log.info("Request to update product: {}", prdct);

        return productRepository.findById(id)
                .map(product -> {
                    product.setProductID(product.getProductID());
                    product.setProductDescription(prdct.getProductDescription());
                    product.setProductImage(prdct.getProductImage());
                    product.setProductPrice(prdct.getProductPrice());
                    product.setProductQuantity(prdct.getProductQuantity());
                    Product result = productRepository.save(prdct);
                    return result;
                })
                .orElseGet(() -> {
                    prdct.setProductID(id);
                    return productRepository.save(prdct);
                });
    }

    /**
     *
     * @param id
     * @return
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        log.info("Request to delete product: {}", id);
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    /**
     *
     * @param id
     * @return ResponsiveEntity
     *
     */

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/product/{id}")
    ResponseEntity<?> getProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(res -> ResponseEntity.ok().body(res))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     *
     * @return Iterable
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/products")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }




}
