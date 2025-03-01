/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

// Dylan Denny TP074879

// TO WHOEVER ACCESS MY SOURCE CODE, BY READING THIS YOU AGREE TO NOT STEAL ANY OF MY SOURCE CODE.
// I HAVE GO THROUGH MY WAYS AND STAY UP 4AM JUST TO UNDERSTAND HOW JAVA PROGRAMMING WORKS, PLEASE DON'T QUESTION MY SANITY.
// HONESTLY WHOEVER READS MY CODE ENJOY HAVING BUNCH OF COMMENTS BECAUSE THIS IS HOW I CODE.
// BEST OF LUCK TO ALL MY FRIENDS THIS SEMESTER.
// CODE MAY BE REDUNDANT AND NOT FLEXIBLE FOR OTHER TEAMMATE CODE, HOWEVER MY CODE IS PROBABLY ONLY FLEXIBLE WITHIN MY RANGE.

public class PPE_Encapsulation {
    private String ItemCode;
    private String ItemName;
    private String Quantity;
    private String SupplierCode;
    private String DateAdded;

    // Constructor =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public PPE_Encapsulation(String ItemCode, String ItemName, String Quantity, String SupplierCode, String DateAdded) {
        this.ItemCode = ItemCode;
        this.ItemName = ItemName;
        this.Quantity = Quantity;
        this.SupplierCode = SupplierCode;
        this.DateAdded = DateAdded;
    }
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public void setSupplierCode(String SupplierCode) {
        this.SupplierCode = SupplierCode;
    }

    // Setter =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public void setDateAdded(String DateAdded) {
        this.DateAdded = DateAdded;
    }

    // Getter =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public String getItemCode() {
        return ItemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getSupplierCode() {
        return SupplierCode;
    }

    public String getDateAdded() {
        return DateAdded;
    }
}
