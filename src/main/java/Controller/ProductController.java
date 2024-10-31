package Controller;

import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação de mapeamento GET.
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação de variável de caminho.
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação de mapeamento de requisição.
import org.springframework.web.bind.annotation.RestController; // Importa a anotação de controlador REST. import
import java.util.List;
import java.util.ArrayList;
//import com.example.mysql.model.Product;
//import com.example.mysql.model.Category;
import Repository.ProductRepository;
import Repository.CategoryRepository;

@RestController
    @RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
}

@GetMapping
public List<Model.Product> getAllProducts() {
    return productRepository.findAll();
}

@GetMapping("/category/{categoryId}")
public List<Model.Product> getProductsByCategory(@PathVariable Long categoryId) {
Model.Category category = categoryRepository.findById(categoryId).orElse(null); // Busca a categoria pelo ID.
if (category != null) {
    return productRepository.findByCategory(category);
}
return new ArrayList<>();
}
@GetMapping("/below-price/{maxPrice}")
public List<Model.Product> getProductsBelowMaxPrice(@PathVariable double maxPrice) {
    return productRepository.findProductsBelowMaxPrice(maxPrice);
}
}
