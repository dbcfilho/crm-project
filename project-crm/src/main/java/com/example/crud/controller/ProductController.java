package com.example.crud.controller;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "productList"; // Nome da view (HTML) que será retornada
    }

    @GetMapping("/products/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm"; // Nome da view para o formulário de criação
    }

    @PostMapping("/products")
    public String createProduct(Product product) {
        productRepository.save(product);
        return "redirect:/products"; // Redireciona para a lista após salvar
    }

    @GetMapping("/products/{id}/edit")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "productForm"; // Reutiliza a mesma view do formulário para editar
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, Product product) {
        product.setId(id); // Assegura que o ID é setado para a atualização
        productRepository.save(product);
        return "redirect:/products"; // Redireciona para a lista após atualizar
    }

    @PostMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id); // Lógica para deletar o produto
        return "redirect:/products"; // Redireciona para a lista de produtos
    }
}
