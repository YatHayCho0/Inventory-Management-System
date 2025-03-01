package assignment;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ian
 */
public class Hospital{
    private String hospitalCode;
    private String hospitalName;
    private String address;
    
    public Hospital(String hospitalCode, String hospitalName, String address) {
        this.hospitalCode = hospitalCode;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital Code: " + hospitalCode + "\n, Name: " + hospitalName + ", Address: " + address;
    }
}
    
