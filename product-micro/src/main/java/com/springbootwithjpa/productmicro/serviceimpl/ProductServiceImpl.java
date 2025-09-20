package com.springbootwithjpa.productmicro.serviceimpl;

import com.springbootwithjpa.productmicro.controller.Controller;
import com.springbootwithjpa.productmicro.entity.Product;
import com.springbootwithjpa.productmicro.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;

@Service
public class ProductServiceImpl {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Value("name")
    String name;

    @Autowired
    ProductRepo prepo;
    public List<Product> getAllProduct(){
        logger.info("hi anuj splunk");

    return prepo.findAll();
    }
    public Optional<Product> getProductById(int pid)

    {
        return prepo.findById(pid);
    }

    public Product saveProduct(Product prod){
        return prepo.save(prod);
    }

    public void deleteProduct(int id){

        prepo.deleteById(id);
    }
    public void updateProduct(Product p){

        prepo.save(p);
    }

}
