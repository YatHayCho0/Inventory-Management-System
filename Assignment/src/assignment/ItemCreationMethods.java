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
import java.util.ArrayList;
import java.util.Arrays;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Table -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
import javax.swing.table.DefaultTableModel;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

public class ItemCreationMethods {
    
    // Global Variable : PPE_FILES, SPLIT_CAHRACTERS
    
    private static final String PPE_FILES = "ppe.txt";
    private static final String SUPPLIER_FILES = "supplier.txt";
    private static final String SPLIT_CHARACTER = "\\|";
    
    
    public static void FileWrite(PPE_Encapsulation PPEObject) throws IOException {
        try (FileWriter ppeFile = new FileWriter(PPE_FILES, true)) {
            ppeFile.write(PPEObject.getItemCode() + "|" + PPEObject.getItemName() + "|" + PPEObject.getQuantity() + "|" + PPEObject.getSupplierCode() + "|" + PPEObject.getDateAdded());
            ppeFile.write(System.lineSeparator());
        }
    }
    
    public static boolean ItemExist(String ItemCode_Input) throws IOException {

        // Variable: ItemCode_Input, RowPPEFileLine_S_ver, RowPPEFileLine_AL_ver, ItemCodeHoldingForChecking
        
        try (BufferedReader PPEFileReader = new BufferedReader(new FileReader(PPE_FILES))) {

            String RowPPEFileLine_S_ver;
            while ((RowPPEFileLine_S_ver = PPEFileReader.readLine()) != null) {
                // Splitting the line and converting it to an ArrayList
                ArrayList<String> RowPPEFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowPPEFileLine_S_ver.split(SPLIT_CHARACTER)));
                String ItemCodeHoldingForChecking = RowPPEFileLine_AL_ver.get(0); // First element (Item Code)

                if (ItemCodeHoldingForChecking.equalsIgnoreCase(ItemCode_Input)) {
                    return true; // Existed Item, should return error
                }
            }
        }
        return false;  // Item did not exist, it should be able to create
    }
    
    public static void LoadSuppliers_WILDCARD(DefaultTableModel SupplierTable) throws IOException {

        SupplierTable.setRowCount(0);

        // Local Variables : UserTable, RowUserFileLine_S_ver, RowUserFileLine_AL_ver, UserSingleRow
        
        try (BufferedReader SupplierFileReader = new BufferedReader(new FileReader(SUPPLIER_FILES))) {
            
            SupplierFileReader.readLine();

            String RowSupplierFileLine_S_ver;
            while ((RowSupplierFileLine_S_ver = SupplierFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                ArrayList<String> RowSupplierFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowSupplierFileLine_S_ver.split(SPLIT_CHARACTER)));
                
                // Create a new object from the data, wahoo!!
                Supplier_Encapsulation SupplierSingleRow = new Supplier_Encapsulation(
                    RowSupplierFileLine_AL_ver.get(0), // Supplier_Code
                    RowSupplierFileLine_AL_ver.get(1), // Supplier_Name
                    RowSupplierFileLine_AL_ver.get(2) // Register_Date
                );
                
                // As one say.. "Let's do Encapsulation, Let's do Encapsulation, Encapsulation, ENCAPSULATION IS THAT ALL YOU EVER SAY THAT'S ALL I HEAR, I CAN'T TAKE IT ANYMORE. I HATE ENCAPSULATION!!!"
                // No I lied, no one said that.
                SupplierTable.addRow(new Object[]{ 
                    SupplierSingleRow.getSupplier_Code(), 
                    SupplierSingleRow.getSupplier_Name(), 
                    SupplierSingleRow.getRegister_Date(), 
                });
            }
        }
    }
    
    public static boolean SupplierExists_WILDCARD(String SupplierCode_Input) throws IOException {
        try (BufferedReader SupplierFileReader = new BufferedReader(new FileReader(SUPPLIER_FILES))) {
            
            String RowSupplierFileLine_S_ver;
            while ((RowSupplierFileLine_S_ver = SupplierFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                ArrayList<String> RowSupplierFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowSupplierFileLine_S_ver.split(SPLIT_CHARACTER)));
                String CodeHoldingForChecking = RowSupplierFileLine_AL_ver.get(0);
                if (CodeHoldingForChecking.equalsIgnoreCase(SupplierCode_Input)){
                    return true;
                    // Name existed, it will return an error outside the DuplicateNameCheck method
                }
            }
        }
        return false;
        // Name does not exist, should able to register outside the DuplicateNameCheck method
    }
    
    public static void LoadPPE(DefaultTableModel PPETable) throws IOException {

        PPETable.setRowCount(0);

        // Local Variables : UserTable, RowUserFileLine_S_ver, RowUserFileLine_AL_ver, UserSingleRow
        
        try (BufferedReader SupplierFileReader = new BufferedReader(new FileReader(PPE_FILES))) {
            
            SupplierFileReader.readLine();

            String RowSupplierFileLine_S_ver;
            while ((RowSupplierFileLine_S_ver = SupplierFileReader.readLine()) != null) {
            // It keeps looping and read until there's no more line to read.
            
                ArrayList<String> RowSupplierFileLine_AL_ver = new ArrayList<>(Arrays.asList(RowSupplierFileLine_S_ver.split(SPLIT_CHARACTER)));
                
                // Create a new object from the data, wahoo!!
                PPE_Encapsulation PPESingleRow = new PPE_Encapsulation(
                    RowSupplierFileLine_AL_ver.get(0), // Item_Code
                    RowSupplierFileLine_AL_ver.get(1), // Item_Name
                    RowSupplierFileLine_AL_ver.get(2), // Quantity
                    RowSupplierFileLine_AL_ver.get(3), // Supplier_Code
                    RowSupplierFileLine_AL_ver.get(4) // Date_Added
                );
                
                // As one say.. "Let's do Encapsulation, Let's do Encapsulation, Encapsulation, ENCAPSULATION IS THAT ALL YOU EVER SAY THAT'S ALL I HEAR, I CAN'T TAKE IT ANYMORE. I HATE ENCAPSULATION!!!"
                // No I lied, no one said that.
                PPETable.addRow(new Object[]{ 
                    PPESingleRow.getItemCode(), 
                    PPESingleRow.getItemName(), 
                    PPESingleRow.getQuantity(), 
                    PPESingleRow.getSupplierCode(), 
                    PPESingleRow.getDateAdded()
                });
            }
        }
    }
}
