package com.deliverybusiness.model;

import javax.persistence.*;

@Entity
@Table(name = "MenuItem")
public class MenuItem {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "MenuGroup_ID", referencedColumnName = "ID")
    private MenuGroup menuGroup;

    public MenuItem() {
    }

    public MenuItem(int id, String name, String description, double price, MenuGroup menuGroup) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuGroup = menuGroup;
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

    public MenuGroup getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroup menuGroup) {
        this.menuGroup = menuGroup;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", menuGroup=" + menuGroup +
                '}';
    }
}
