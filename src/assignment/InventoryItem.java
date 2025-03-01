package assignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ian
 */

    



public class InventoryItem {
    private String itemCode;
    private String supplierCode;
    private int quantity;

    public InventoryItem(String itemCode, String supplierCode, int quantity) {
        this.itemCode = itemCode;
        this.supplierCode = supplierCode;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplierCode() {
        return supplierCode;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String toString() {
        return "item Code: " + itemCode + ", SupplierID: " + supplierCode + ", Boxes: " + quantity;
    }
}


