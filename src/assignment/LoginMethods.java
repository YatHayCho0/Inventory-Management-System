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

// File Read Library -=-=-=-=-=-=-=-=-=-
import java.io.BufferedReader;
import java.io.FileReader;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Error Handler Library -=-=-=-=-=-=-=-
import java.io.IOException;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Array Library, honestly I'd call them List because I got used with Python. Oh Well
import java.util.ArrayList;
import java.util.Arrays;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

public class LoginMethods {
    
    // Global Variables : USER_FILE, SPLIT_CHARACTER, CurrentUserType
    
    private static final String USER_FILE = "users.txt";
    private static final String SPLIT_CHARACTER = "\\|";
    public static String CurrentUserType = "";
    
    // LOGIN VERIFICATION -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    public static boolean LoginVerification(String Login_Username_Input, String Login_Password_Input) throws IOException {
        
        // Local Variables : Login_Username_Input, Password_Input, RowUserFileLine_S_ver, RowUserFileLine_AL_ver, Name_Verification, PW_Verification

        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {
            
            // RowUserFileLine_S_ver basically contain a string of a File Line. 
            // NOTE THAT IT IS A RAW STRING, NOT AN ARRAY
            String RowUserFileLine_S_ver;
            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                ArrayList<String> RowUserFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowUserFileLine_S_ver.split(SPLIT_CHARACTER)));
                String Name_Verification = RowUserFileLine_AL_ver.get(1);
                String PW_Verification = RowUserFileLine_AL_ver.get(2);
                String UserType = RowUserFileLine_AL_ver.get(3);
                if (Name_Verification.equals(Login_Username_Input) && PW_Verification.equals(Login_Password_Input)) {
                    CurrentUserType = UserType;
                    return true; // Verified, methods should return true and allow user to access
                }
            }
            return false; // Failed, methods should return false and allow only up to 3 attempts
        }
    }
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    public static boolean AdminPermission() {
        return CurrentUserType.equals("Admin");
    }
    
    public static boolean StaffPermission() {
        return CurrentUserType.equals("Staff");
    }
    
}
