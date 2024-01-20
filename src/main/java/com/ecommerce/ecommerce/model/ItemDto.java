package com.ecommerce.ecommerce.model;

public class ItemDto {
    private Long id;
    private String title;
    private String photo;
    private Double price;
    private Integer quantity = 0;
    private Integer availableStock;
    private Long serial;
    public ItemDto(){}

    public ItemDto(Long id, String title, String photo, Double price, Integer quantity, Integer availableStock, Long serial) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.quantity = quantity;
        this.availableStock = availableStock;
        this.serial = serial;
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

    public Long getSerial() {
        return serial;
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

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public Item toItem() {
        Item item = new Item();
        item.setId(this.getId());
        item.setTitle(this.getTitle());
        item.setPhoto(this.getPhoto());
        item.setPrice(this.getPrice());
        item.setAvailableStock(this.getAvailableStock());
        return item;
    }
}
