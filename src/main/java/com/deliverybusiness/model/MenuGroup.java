package com.deliverybusiness.model;

import javax.persistence.*;

@Entity
@Table(name = "MenuGroup")
public class MenuGroup {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "ID")
    private Menu menu;

    public MenuGroup() {
    }

    public MenuGroup(int id, String name, Menu menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "MenuGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                '}';
    }
}
