package com.ecommerce.ecommerce.model;

public class ItemDto {
    private Long id;
    private String title;
    private String photo;
    private Double price;
    private Integer quantity = 0;
    private Integer availableStock;
    public ItemDto(){}

    public ItemDto(Long id, String title, String photo, Double price, Integer quantity, Integer availableStock) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.quantity = quantity;
        this.availableStock = availableStock;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getPhoto() {
        return photo;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }
}
