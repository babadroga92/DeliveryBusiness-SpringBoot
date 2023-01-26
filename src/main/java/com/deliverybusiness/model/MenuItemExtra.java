package com.deliverybusiness.model;

public class MenuItemExtra {
    private int id;
    private String name;
    private String description;
    private double price;
    private MenuItem menuItem;

    public MenuItemExtra() {
    }

    public MenuItemExtra(int id, String name, String description, double price, MenuItem menuItem) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuItem = menuItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String toString() {
        return "MenuItemExtra{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", menuItem=" + menuItem +
                '}';
    }
}
