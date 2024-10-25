package com.example.crud.service;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        public List<Product> listAll() {
            return productRepository.findAll();
        }

        public Product save(Product product) {
            return productRepository.save(product);
        }

        public Product getById(Long id) {
            return productRepository.findById(id).orElse(null);
        }

        public void delete(Long id) {
            productRepository.deleteById(id);
        }
}
