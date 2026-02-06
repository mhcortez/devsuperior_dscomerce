package com.devsuperior.dscomerce.dto;

import com.devsuperior.dscomerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class ProductDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "O nome deve conter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String name;
    @Size(min = 10, message = "A descrição deve conter no mínimo 10 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String description;
    @Positive(message = "O preço deve ser um valor positivo")
    private Double price;
    private String imageUrl;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imageUrl)  {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imageUrl = entity.getImageUrl();
    }
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public String getImageUrl() {
        return imageUrl;
    }
     

}
