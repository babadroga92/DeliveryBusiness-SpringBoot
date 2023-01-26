package com.deliverybusiness.model;

public class OrderItemExtra {
    private int id;
    private int quantity;
    private OrderItem orderItem;
    private MenuItem menuItem;
    private MenuItemExtra menuItemExtra;

    public OrderItemExtra() {
    }

    public OrderItemExtra(int id, int quantity, OrderItem orderItem, MenuItem menuItem, MenuItemExtra menuItemExtra) {
        this.id = id;
        this.quantity = quantity;
        this.orderItem = orderItem;
        this.menuItem = menuItem;
        this.menuItemExtra = menuItemExtra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItemExtra getMenuItemExtra() {
        return menuItemExtra;
    }

    public void setMenuItemExtra(MenuItemExtra menuItemExtra) {
        this.menuItemExtra = menuItemExtra;
    }

    @Override
    public String toString() {
        return "OrderItemExtra{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", orderItem=" + orderItem +
                ", menuItem=" + menuItem +
                ", menuItemExtra=" + menuItemExtra +
                '}';
    }
}
