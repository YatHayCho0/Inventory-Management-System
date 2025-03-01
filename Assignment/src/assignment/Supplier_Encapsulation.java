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

public class Supplier_Encapsulation {
    private String SupplierCode;
    private String SupplierName;
    private String RegisterDate;

    // Constructor =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Supplier_Encapsulation(String SupplierCode, String SupplierName, String RegisterDate) {
        this.SupplierCode = SupplierCode;
        this.SupplierName = SupplierName;
        this.RegisterDate = RegisterDate;
    }
    
    // Setter =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public void setSupplier_Code(String Supplier_Code) {
        this.SupplierCode = Supplier_Code;
    }

    public void setSupplier_Name(String Supplier_Name) {
        this.SupplierName = Supplier_Name;
    }

    public void setRegister_Date(String Register_Date) {
        this.RegisterDate = Register_Date;
    }
    
    // Getter =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public String getSupplier_Code() {
        return SupplierCode;
    }

    public String getSupplier_Name() {
        return SupplierName;
    }

    public String getRegister_Date() {
        return RegisterDate;
    }
}
