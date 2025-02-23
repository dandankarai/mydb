
package Model;

import jakarta.persistence.Entity; // Importa a anotação de entidade do Jakarta Persistence.
import jakarta.persistence.GeneratedValue; // Importa a anotação de geração automática.
import jakarta.persistence.GenerationType; // Importa a estratégia de geração automática.
import jakarta.persistence.Id; // Importa a anotação de chave primária.
import jakarta.persistence.Column; // Importa a anotação de coluna.
import jakarta.persistence.ManyToOne; // Importa a anotação de relacionamento Many-to-One.
import jakarta.persistence.JoinColumn; // Importa a anotação de coluna de junção.

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária do produto.

    @Column(nullable = false)
    private String name; // Nome do produto, não pode ser nulo.

    @Column(nullable = false)
    private double price; // Preço do produto, não pode ser nulo.

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // Categoria à qual o produto pertence.

    // Getters e setters para as propriedades da entidade Product.

    // Getter para o ID.
    public Long getId() {
        return id;
    }

    // Setter para o ID.
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o nome.
    public String getName() {
        return name;
    }

    // Setter para o nome.
    public void setName(String name) {
        this.name = name;
    }

    // Getter para o preço.
    public double getPrice() {
        return price;
    }

    // Setter para o preço.
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter para a categoria.
    public Category getCategory() {
        return category;
    }

    // Setter para a categoria.
    public void setCategory(Category category) {
        this.category = category;
    }
}
