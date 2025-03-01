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

public class User_Encapsulation {

    private String UserID;
    private String Name;
    private String Password;
    private String UserType;
    private String DateRegister;

    // Constructor =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public User_Encapsulation(String UserID, String Name, String Password, String UserType, String DateRegister) {
        this.UserID = UserID;
        this.Name = Name;
        this.Password = Password;
        this.UserType = UserType;
        this.DateRegister = DateRegister;
    }
    
    // Setter =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public void setDateRegister(String DateRegister) {
        this.DateRegister = DateRegister;
    }
    
    // Getter =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public String getUserID() {
        return UserID;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserType() {
        return UserType;
    }

    public String getDateRegister() {
        return DateRegister;
    }
    
}
