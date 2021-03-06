package ecommerce.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import ecommerce.spring.enties.Product;
import ecommerce.spring.repository.ProductRepository;
import ecommerce.spring.service.Impl.ProductServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public Page<Product> getAll(Pageable pageable) {
        return this.productServiceImpl.getAll(pageable);
    }

    // @GetMapping("/product/search")
    // public Collection<Product> searchProducts(@RequestParam("keyword") String
    // keyword) {

    // return this.productRepository.searchProducts(keyword);
    // }

    @GetMapping("/category/{category_id}/product")
    public Page<Product> getProductToCategory(@PathVariable(value = "category_id") Long category_id,
            Pageable pageable) {
        return productRepository.findByCategoryId(category_id, pageable);
    }

    @PostMapping("/category/{category_id}/product")
    public Product createProductToCategory(@PathVariable Long category_id, @RequestBody Product product) {
        return this.productServiceImpl.saveProduct(category_id, product);
    }

    @PutMapping("/category/{category_id}/product/{product_id}")
    public Product updateProductToCategory(@PathVariable Long category_id, @PathVariable Long product_id,
            @RequestBody Product product) {

        return this.productServiceImpl.editProduct(category_id, product_id, product);
    }

    @DeleteMapping("/product/{id}")
    public void remove(@PathVariable Long id) {
        this.productServiceImpl.remove(id);
    }

}
