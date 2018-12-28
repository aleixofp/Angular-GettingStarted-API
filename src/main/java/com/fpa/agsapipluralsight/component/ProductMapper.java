package com.fpa.agsapipluralsight.component;

import com.fpa.agsapipluralsight.api.product.dto.ProductDTO;
import com.fpa.agsapipluralsight.data.product.model.ProductModel;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProductMapper {

    public ProductDTO modelToDto(ProductModel productModel){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setName(productModel.getName());
        productDTO.setCode(productModel.getCode());

        Date releaseDate = productModel.getReleaseDate();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dtoReleaseDate = formatter.format(releaseDate);
        productDTO.setReleaseDate(dtoReleaseDate);

        productDTO.setDescription(productModel.getDescription());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setStarRating(productModel.getStarRating());
        productDTO.setImageUrl(productModel.getImageUrl());
        return productDTO;
    }

    public ProductModel dtoToModel(ProductDTO productDTO){
        ProductModel productModel = new ProductModel();
        productModel.setName(productDTO.getName());
        productModel.setCode(productDTO.getCode());
        productModel.setDescription(productDTO.getDescription());
        productModel.setImageUrl(productDTO.getImageUrl());
        productModel.setPrice(productDTO.getPrice());

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date parsedDate;
        try {
            parsedDate = formatter.parse( productDTO.getReleaseDate() );
        } catch (ParseException e) {
            parsedDate = null;
            e.printStackTrace();
        }

        productModel.setReleaseDate(parsedDate);
        productModel.setStarRating(productDTO.getStarRating());

        return productModel;
    }

}
