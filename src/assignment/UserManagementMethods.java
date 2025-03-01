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
import java.io.BufferedWriter;
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

// Table -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
import javax.swing.table.DefaultTableModel;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

public class UserManagementMethods {
    
    // Global Variables : USER_FILE, SPLIT_CHARACTER
    
    private static final String USER_FILE = "users.txt";
    private static final String SPLIT_CHARACTER = "\\|";
    
    // LOAD USERS TO JTABLE -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public static void LoadUsers(DefaultTableModel UserTable) throws IOException {

        UserTable.setRowCount(0);

        // Local Variables : UserTable, RowUserFileLine_S_ver, RowUserFileLine_AL_ver, UserSingleRow
        
        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {
            
            UserFileReader.readLine();

            String RowUserFileLine_S_ver;
            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                ArrayList<String> RowUserFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowUserFileLine_S_ver.split(SPLIT_CHARACTER)));
                
                // Create a new object from the data, wahoo!!
                User_Encapsulation UserSingleRow = new User_Encapsulation(
                    RowUserFileLine_AL_ver.get(0), // UserID
                    RowUserFileLine_AL_ver.get(1), // Name
                    RowUserFileLine_AL_ver.get(2), // Password
                    RowUserFileLine_AL_ver.get(3), // UserType
                    RowUserFileLine_AL_ver.get(4)  // DateRegister
                );
                
                // As one say.. "Let's do Encapsulation, Let's do Encapsulation, Encapsulation, ENCAPSULATION IS THAT ALL YOU EVER SAY THAT'S ALL I HEAR, I CAN'T TAKE IT ANYMORE. I HATE ENCAPSULATION!!!"
                // No I lied, no one said that.
                UserTable.addRow(new Object[]{ 
                    UserSingleRow.getUserID(), 
                    UserSingleRow.getName(), 
                    UserSingleRow.getPassword(), 
                    UserSingleRow.getUserType(), 
                    UserSingleRow.getDateRegister()
                });
            }
        }
    }
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    // DELETE USER ROW -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static void DeleteUser(String UserInput) throws IOException {
        
        // Local Variables: UserInput, RemainingUsers, UserFileReader, RowUserFileLine_S_ver, RowUserFileLine_AL_ver

        ArrayList<String> RemainingUsers = new ArrayList<>();

        // Read all the lines from the file and store the remaining ones in the list.
        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {

            // Skip the header line and add the header back for checking guh
            String RowUserFileLine_S_ver = UserFileReader.readLine();
            RemainingUsers.add(RowUserFileLine_S_ver);

            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {

                ArrayList<String> RowUserFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowUserFileLine_S_ver.split(SPLIT_CHARACTER)));

                // Create a new object from the data, wahoo!!
                User_Encapsulation user = new User_Encapsulation(
                        RowUserFileLine_AL_ver.get(0), // UserID
                        RowUserFileLine_AL_ver.get(1), // Name
                        RowUserFileLine_AL_ver.get(2), // Password
                        RowUserFileLine_AL_ver.get(3), // UserType
                        RowUserFileLine_AL_ver.get(4) // DateRegister
                );

                // If the ID is the same it will remove it
                if (!user.getUserID().equals(UserInput)) {
                    RemainingUsers.add(RowUserFileLine_S_ver);
                }
            }
        }

        // Write back the remaining users to the file (this will overwrite the file)
        try (BufferedWriter UserFileWriter = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (String remainingUser : RemainingUsers) {
                UserFileWriter.write(remainingUser);
                UserFileWriter.newLine();
            }
        }

        System.out.println("[!] User with ID " + UserInput + " has been deleted.");
    }
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    
    public static void SearchUsers(DefaultTableModel UserTable, String UserID_Input, String Name_Input, String UserType_Input, String DateOfRegister_Input) throws IOException {
        
        UserTable.setRowCount(0);
        
        // Local Variables : UserTable, RowUserFileLine_S_ver, RowUserFileLine_AL_ver, UserSingleRow and A LOT (I AM TOO LAZY FOR THIS I AM SORRY)
        
        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {
            
            UserFileReader.readLine();
            boolean FilterFound = false;
            String RowUserFileLine_S_ver;
            
            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {
                ArrayList<String> RowUserFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowUserFileLine_S_ver.split(SPLIT_CHARACTER)));
                
                String rowUserID_Data = RowUserFileLine_AL_ver.get(0);
                String rowName_Data = RowUserFileLine_AL_ver.get(1);
                String rowUserType_Data = RowUserFileLine_AL_ver.get(3);
                String rowDateOfRegister_Data = RowUserFileLine_AL_ver.get(4);
                
                // Filter goes through here
                // So let me explain to you,
                // You have A & B, A section first check if it's empty, if is it will be TRUE and the NOT expression will make it FALSE.
                // However if is NOT Empty which mean there's a filter, it will be FALSE and the NOT expression will make it TRUE.
                // On B, if the value in rowUserID_Data contains UserID_Input which is from the user, it will be expressed as TRUE
                // and the NOT expression will make it false.
                
                // In this scenario it will be false and hence skipping the If statement, expressing the Matches is true.
                // Of course, if the A is True and B is True, aka the value DOES NOT match. the "matches" variable will be false.
                boolean matches = true;
                if (!UserID_Input.isEmpty() && !rowUserID_Data.contains(UserID_Input))
                    matches = false;
                if (!Name_Input.isEmpty() && !rowName_Data.contains(Name_Input))
                    matches = false;
                if (!UserType_Input.isEmpty() && !rowUserType_Data.contains(UserType_Input))
                    matches = false;
                if (!DateOfRegister_Input.isEmpty() && !rowDateOfRegister_Data.contains(DateOfRegister_Input))
                    matches = false;
                
                // Honestly why didn't I thought of this during my Python assignment, doesn't matter though is A+ but it was a shame
                // I didn't use this logic on it, it was fun creating.
                
                if (matches) {
                    FilterFound = true;
                    User_Encapsulation UserSingleRow = new User_Encapsulation(
                        rowUserID_Data, 
                        rowName_Data, 
                        RowUserFileLine_AL_ver.get(2), // Since password is not obtained from the get, we just directly do the index/location of the Array.
                        rowUserType_Data,
                        rowDateOfRegister_Data 
                    );
                    
                    UserTable.addRow(new Object[]{ 
                        UserSingleRow.getUserID(), 
                        UserSingleRow.getName(), 
                        UserSingleRow.getPassword(),
                        UserSingleRow.getUserType(),
                        UserSingleRow.getDateRegister() 
                    });
                }
            }
        }
    }
    
    // DELETE USER ROW -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static void ModifyUser(String UserIDInput, String NewName, String NewPassword, String NewUserType) throws IOException {
     
        // Local Variables: UserInput, RemainingUsers, UserFileReader, RowUserFileLine_S_ver, RowUserFileLine_AL_ver
        String UpdatedUserLine = "";
        ArrayList<String> UpdatedUser = new ArrayList<>();
        
        // Read all the lines from the file and store the remaining ones in the list.
        try (BufferedReader UserFileReader = new BufferedReader(new FileReader(USER_FILE))) {

            // Skip the header line and add the header back for checking guh
            String RowUserFileLine_S_ver = UserFileReader.readLine();
            UpdatedUser.add(RowUserFileLine_S_ver);

            while ((RowUserFileLine_S_ver = UserFileReader.readLine()) != null) {

                ArrayList<String> RowUserFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowUserFileLine_S_ver.split(SPLIT_CHARACTER)));

                // Create a new object from the data, wahoo!!
                User_Encapsulation user = new User_Encapsulation(
                        RowUserFileLine_AL_ver.get(0), // UserID
                        RowUserFileLine_AL_ver.get(1), // Name
                        RowUserFileLine_AL_ver.get(2), // Password
                        RowUserFileLine_AL_ver.get(3), // UserType
                        RowUserFileLine_AL_ver.get(4) // DateRegister
                );

                // If the ID is the same it will remove it
                if (!user.getUserID().equals(UserIDInput)) {
                    UpdatedUser.add(RowUserFileLine_S_ver);
                } else {
                    // Modify the user if the ID matches
                    user.setName(NewName);
                    user.setPassword(NewPassword);
                    user.setUserType(NewUserType);

                    // Create the updated user line
                    UpdatedUserLine = String.join("|",
                            user.getUserID(),
                            user.getName(),
                            user.getPassword(),
                            user.getUserType(),
                            user.getDateRegister()
                    );
                    
                    // Update the file
                    UpdatedUser.add(UpdatedUserLine);
                }
            }

            // Write back the remaining users to the file (this will overwrite the file)
            try (BufferedWriter UserFileWriter = new BufferedWriter(new FileWriter(USER_FILE))) {
                for (String UpdateUserRow : UpdatedUser) {
                    UserFileWriter.write(UpdateUserRow);
                    UserFileWriter.newLine();
                }
            }

            System.out.println("[!] User with ID " + UserIDInput + " has been modified.");
        }
        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    }
}
