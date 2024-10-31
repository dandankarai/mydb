package Controller;

import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.web.bind.annotation.*;

import Model.Category;
import Repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null); //

    }
    @GetMapping("/byName/{categoryName}")
    public Category getCategoryByNameJpql(@PathVariable String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @GetMapping("/byNameSql/{categoryName}")
    public Category getCategoryByNameSql(@PathVariable String categoryName) {
        return categoryRepository.findCategoryByNameSQL(categoryName);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}") // Mapeia o método para responder a requisições PUT com um parâmetro de caminho (ID).
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id).orElse(null); // Busca a categoria existente pelo ID.
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName()); // Atualiza o nome da categoria.
            return categoryRepository.save(existingCategory); // Salva a categoria atualizada no banco de dados.
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}