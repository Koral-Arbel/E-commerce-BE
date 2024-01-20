package com.ecommerce.ecommerce.model;

public class Item {
    private Long id;
    private String title;
    private String photo;
    private Double price;
    private Integer availableStock;

    public Item(){}

    public Item(Long id, String title, String photo, Double price, Integer availableStock) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.price = price;
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
    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    public ItemDto toItemDto() {
        return new ItemDto(
                this.getId(),
                this.getTitle(),
                this.getPhoto(),
                this.getPrice(),
                toItemDto().getQuantity(),
                this.getAvailableStock()
        );
    }
}
