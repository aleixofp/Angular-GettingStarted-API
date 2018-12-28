package com.fpa.agsapipluralsight.data.product.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(generator = "gen_id_product", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(allocationSize = 1, name = "gen_id_product", sequenceName = "seq_product")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @Column(name = "star_rating")
    private Float starRating;

    @Column(name = "image_url")
    private String imageUrl;

    public ProductModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getStarRating() {
        return starRating;
    }

    public void setStarRating(Float starRating) {
        this.starRating = starRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
