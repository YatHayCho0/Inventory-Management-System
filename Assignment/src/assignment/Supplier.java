package assignment;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ian
 */
public class Supplier{
    private String supplierCode;
    private String supplierName;
    private String address;
    
    public Supplier(String supplierCode, String supplierName, String address) {
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.address = address;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital Code: " + supplierCode + "\n, Name: " + supplierName + ", Address: " + address;
    }
}
    
