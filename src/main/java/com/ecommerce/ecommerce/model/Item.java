package com.ecommerce.ecommerce.model;

public class Item {
    private Long id;
    private String title;
    private Double price;
    private String photo;
    private Long availableStock;

    public Item(Long id, String title, Double price, String photo, Long availableStock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.photo = photo;
        this.availableStock = availableStock;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    public Long getAvailableStock() {
        return availableStock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setAvailableStock(Long availableStock) {
        this.availableStock = availableStock;
    }
}
