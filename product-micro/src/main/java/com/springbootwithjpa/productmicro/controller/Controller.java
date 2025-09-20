package com.springbootwithjpa.productmicro.controller;

import com.springbootwithjpa.productmicro.entity.Product;
import com.springbootwithjpa.productmicro.serviceimpl.ProductServiceImpl;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/product")
@Api(tags = "Main Controller API")

public class Controller {
    Logger logger= LoggerFactory.getLogger(Controller.class);



@Autowired
  private ProductServiceImpl pserviceimpl;

   @GetMapping("/")
    public List<Product> getProducts(){
        logger.info("start get product");

      //  ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:8082/customer-services/all",String.class);

       // System.out.println(response);

        return pserviceimpl.getAllProduct();


    }
    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable("id") int pid){

        return pserviceimpl.getProductById(pid);
    }

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product p){

        return pserviceimpl.saveProduct(p);
    }



    @DeleteMapping("{id}")
    public void deleteProducts(@PathVariable("id") int p){

        pserviceimpl.deleteProduct(p);
    }
    @PutMapping ("/prod")
    public void updateProducts(@RequestBody Product product){

        pserviceimpl.updateProduct(product);
    }




}
