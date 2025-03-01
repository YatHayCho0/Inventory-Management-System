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
import java.io.FileWriter;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Error Handeler Library -=-=-=-=-=-=-=
import java.io.IOException;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Array Library, honestly I'd call them List because I got used with Python. Wait.. I think they call these List too right?
import java.util.ArrayList;
import java.util.Arrays;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Matching and Pattern Library to Generate ID and Check
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

public class RegisterMethods {
    
    // Global Variables : USER_FILE, SPLIT_CHARACTER
    
    private static final String USER_FILE = "users.txt";
    private static final String SPLIT_CHARACTER = "\\|";
    
    // UNIQUE ID METHODS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static String GenerateUniqueID() throws IOException {
        
        // Local Variable : PREFIX, MaxID, Current_Id, RowUserFileLine_S_ver
        String PREFIX = "ID";
        int MaxID = 0;

        // Patterns, which is the ID and the four random digits. 
        Pattern UserIDPattern = Pattern.compile(PREFIX + "(\\d{4})");

        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {
            
            // RowUserFileLine_S_ver basically contain a string of a File Line.
            // NOTE THAT IT IS A RAW STRING, NOT AN ARRAY
            String RowUserFileLine_S_ver;
            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                Matcher ID_Matcher = UserIDPattern.matcher(RowUserFileLine_S_ver);
                if (ID_Matcher.find()) {
                    int Current_Id = Integer.parseInt(ID_Matcher.group(1));
                    /* It converts the four digits "0000" into an int, if is "ID0001" it will be "1" for int. 
                    *  You should understand that Ian
                    */
                    if (Current_Id > MaxID) {
                        MaxID = Current_Id;
                    }
                }
            }
        }
        return PREFIX + String.format("%04d", MaxID + 1);
        // Ian, the "%04d" is a format specifier, I don't think lecturer taught us this but I did some searching on w3school
        // % is the format specifier, and 0 is the pad number if it's shorter than specified width
        // 4 is basically well, how many 0's we are doing. and D stand for decimal.
        // Website : https://www.w3schools.com/java/java_regex.asp
        
        // Oh yea Ian, I notice doing Matcher and Pattern this way is easier since we don't need to
        // convert them into ArrayList and find them, we can do this method which is more flexible
    }
    
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    // DUPLICATE NAME CHECKER -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    public static boolean DuplicateNameCheck(String Register_Name_Input) throws IOException {
        
        // Variables : Register_Name_Input, RowUserFileLine_S_ver, RowUserFileLine_AL_ver, NameHoldingForChecking
        
        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {
            
            // RowUserFileLine_S_ver basically contain a string of a File Line. 
            // NOTE THAT IT IS A RAW STRING, NOT AN ARRAY
            String RowUserFileLine_S_ver;
            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                ArrayList<String> RowUserFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowUserFileLine_S_ver.split(SPLIT_CHARACTER)));
                String NameHoldingForChecking = RowUserFileLine_AL_ver.get(1);
                if (NameHoldingForChecking.equalsIgnoreCase(Register_Name_Input)){
                    return true;
                    // Name existed, it will return an error outside the DuplicateNameCheck method
                }
            }
        }
        return false;
        // Name does not exist, should able to register outside the DuplicateNameCheck method
    }
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    // TO CHECK IF THE INPUT ARE EMPTY -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static String EmptyInputValidation(String Name, String Password, boolean AdminSelected, boolean StaffSelected) {
        StringBuilder ErrorOptions = new StringBuilder();

        if (Name.isEmpty()) ErrorOptions.append("<!> Name cannot be empty.\n"); // If Name is empty
        if (Password.isEmpty()) ErrorOptions.append("<!> Password cannot be empty.\n"); // If Password is empty
        if (!AdminSelected && !StaffSelected) ErrorOptions.append("<!> User type must be selected.\n"); // If Selection is empty

        return ErrorOptions.toString(); // Returns the appended message as strings
    }
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    // FILE WRITER -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static void FileWrite(User_Encapsulation UserObject) throws IOException {
        try (FileWriter userFile = new FileWriter(USER_FILE, true)) {
            userFile.write(UserObject.getUserID() + "|" + UserObject.getName() + "|" + UserObject.getPassword() + "|" + UserObject.getUserType() + "|" + UserObject.getDateRegister());
            userFile.write(System.lineSeparator());
        }
    }
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
}
