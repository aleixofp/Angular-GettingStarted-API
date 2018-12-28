package com.fpa.agsapipluralsight.service.product;

import com.fpa.agsapipluralsight.api.exception.ProductNotFoundException;
import com.fpa.agsapipluralsight.api.product.dto.ProductDTO;
import com.fpa.agsapipluralsight.component.ProductMapper;
import com.fpa.agsapipluralsight.data.product.model.ProductModel;
import com.fpa.agsapipluralsight.data.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO getProduct(Long productId) throws ProductNotFoundException {
        return findProduct(productId);
    }

    public List<ProductDTO> listProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO productDTO){
        return saveProduct(productDTO);
    }

    public ProductDTO editProduct(ProductDTO productDTO) throws ProductNotFoundException {

        Long productId = productDTO.getId();
        ProductDTO productDB = findProduct(productId);

        productDB.setName(productDTO.getName());
        productDB.setCode(productDTO.getCode());
        productDB.setReleaseDate(productDTO.getReleaseDate());
        productDB.setDescription(productDTO.getDescription());
        productDB.setStarRating(productDTO.getStarRating());
        productDB.setPrice(productDTO.getPrice());
        productDB.setImageUrl(productDTO.getImageUrl());

        return saveProduct(productDB);
    }

    private ProductDTO saveProduct(ProductDTO productDTO){
        ProductModel productModel = productMapper.dtoToModel(productDTO);
        ProductModel savedProduct = productRepository.save(productModel);

        return productMapper.modelToDto(savedProduct);
    }

    private ProductDTO findProduct(Long productId) throws ProductNotFoundException {
        ProductModel productModel = productRepository.findById(productId).orElse(null);

        if (productModel != null){
            return productMapper.modelToDto(productModel);
        } else {
            throw new ProductNotFoundException(productId);
        }
    }

}
