package assignment;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ian
 */
public class InventoryWriter {
    private static final String PPE_FILE = "ppe.txt";
    private static final String TRANSACTIONS_FILE = "transactions.txt";

    private ArrayList<InventoryItem> inventory;

    public InventoryWriter() {
        inventory = new ArrayList<>();
        loadInventory();
    }

    public void updateInventory(String itemCode, String supplierCode, int quantityReceived) {
        updateQuantity(itemCode, quantityReceived);
        logTransactionReceived(itemCode, supplierCode, quantityReceived);
    }

    public void updateInventoryOffloaded(String itemCode, String hospitalCode, int quantityDistributed) {
        updateQuantity(itemCode, -quantityDistributed);
        logTransactionOffload(itemCode, hospitalCode, quantityDistributed);
    }

    private void updateQuantity(String itemCode, int quantityChange) {
        for (InventoryItem item : inventory) {
            if (item.getItemCode().equals(itemCode)) {
                int newQuantity = item.getQuantity() + quantityChange;
                item.setQuantity(newQuantity);
                System.out.println("Updated quantity for item " + itemCode + ": " + item.getQuantity());

                updateItemRecordInFile(item);
                break;
            }
        }
       
    }

    private void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PPE_FILE))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {  
                String[] columns = line.split("\\|");
                if (columns.length == 5) { // Check if the line has at least 4 columns
                String itemCode = columns[0];
                String code = columns[3];
                int quantity = Integer.parseInt(columns[2]);
                
                inventory.add(new InventoryItem(itemCode, code, quantity));
                for(InventoryItem item: inventory){
                    System.out.println(item);
                }
            } else {
                System.out.println("Invalid line format: " + line);
            }            
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    
    
    public void updateItemRecordInFile(InventoryItem item) {
    List<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("ppe.txt"))) {
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    } catch (IOException ex) {
        System.err.println("Error reading from file: " + ex.getMessage());
    }

    try (PrintWriter writer = new PrintWriter(new FileWriter("ppe.txt"))) {
        writer.println("itemCode|itemName|Quantity|supplierCode|DateAdded");
        for (String line : lines) {
            String[] row = line.split("\\|");
            if (row.length >= 5) {
                String itemID = row[0];
                String itemName = row[1];
                String dateTimeFmt = row[4];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateTime = LocalDate.parse(dateTimeFmt, formatter);
                if (itemID.equals(item.getItemCode())) {
                    // Update hospital record in the file
                    writer.println(item.getItemCode() + "|" + itemName + "|" + item.getQuantity() +"|" + item.getSupplierCode() + "|" + dateTime.format(formatter));
                } else {
                    writer.println(line);
                }
            } else {
                writer.println(line);
            }
        }
        writer.flush(); // Flush the buffer to ensure the changes are written to the file
    } catch (IOException ex) {
        System.err.println("Error writing to file: " + ex.getMessage());
    }
}
    

    private void logTransactionReceived(String itemCode, String code, int quantity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateTime = LocalDateTime.now().format(formatter);
            writer.write("Received Item: "+itemCode + "\n"+
                        "Supplier Code: " + code + "\n" + 
                        "Boxes Acquired: "+quantity + "\n" + 
                        "Date Received: "+dateTime + "\n" +
                        "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    private void logTransactionOffload(String itemCode, String code, int quantity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateTime = LocalDateTime.now().format(formatter);
            writer.write("Item Sent: "+itemCode + "\n"+
                        "Hospital Received: " + code + "\n" + 
                        "Boxes Distributed: "+quantity + "\n" + 
                        "Date Done: "+dateTime + "\n"+
                        "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
    
    
    ///INVENTORY TRACKING
    
//    private void printInputs(String itemCode, int quantityChange) throws FileNotFoundException {
//        BufferedReader  br = new BufferedReader(new FileReader("ppe.txt"));
//        for (InventoryItem item : inventory) {
//            receiveTextArea.setText("");
//            
//        }
//        saveInventory();
//    }
//    
//}

