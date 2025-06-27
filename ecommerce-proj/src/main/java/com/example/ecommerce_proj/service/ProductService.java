package com.example.ecommerce_proj.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce_proj.model.Product;
import com.example.ecommerce_proj.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    // public Product addProduct(Product prod, MultipartFile img) throws IOException {

    //     prod.setImageName(img.getOriginalFilename());
    //     prod.setImageType(img.getContentType());
    //     prod.setImageData(img.getBytes());
    //     return productRepo.save(prod);
    // }

    // public Product updateProduct(Product prod, MultipartFile img) throws IOException {
    //     prod.setImageName(img.getOriginalFilename());
    //     prod.setImageType(img.getContentType());
    //     prod.setImageData(img.getBytes());
    //     return productRepo.save(prod);
    // }

    public Product addOrUpdateProduct(Product prod, MultipartFile img) throws IOException {
        prod.setImageName(img.getOriginalFilename());
        prod.setImageType(img.getContentType());
        prod.setImageData(img.getBytes());
        return productRepo.save(prod);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }

}
