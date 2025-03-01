package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ian
 */
public class HospitalWriter {
    private List<Hospital> hospitals;
    private String hospitalsFilePath = "\"C:\\\\Java Folder\\\\JavaPPE_1.0\\\\src\\\\hospital.txt\"";
    private String transactionsFilePath;
    private static List<String> hospitalCode = new ArrayList<>(); ////


public HospitalWriter(String hospitalsFilePath, String transactionsFilePath) {
        this.hospitals = new ArrayList<>();
        this.hospitalsFilePath = hospitalsFilePath;
        this.transactionsFilePath = transactionsFilePath;
  }

public List<Hospital> getHospitalCodeList() {
        return hospitals;
    }
 

 public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
        createHospitalsFile(hospital);
    }

   


    public void updateHospitalRecordInFile(Hospital hospital) {
    List<String> lines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("hospital.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }   catch (IOException ex) {
            java.util.logging.Logger.getLogger(HospitalWriter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    try (PrintWriter writer = new PrintWriter(new FileWriter("hospital.txt"))) {
        writer.println("HospitalCode|HospitalName|HospitalAddress");
        for (String line : lines) {
            String[] columns = line.split(",");
            if (columns.length == 3) {
                String fileHospitalCode = columns[0];
                if (fileHospitalCode.equals(hospital.getHospitalCode())) {
                    // Update hospital record in the file
                    writer.println(hospital.getHospitalCode() + "," + hospital.getHospitalName() + "," + hospital.getAddress());
                } else {
                    writer.println(line);
                }
            }
        }
    } catch (IOException ex) {
        System.err.println("Error writing to file: " + ex.getMessage());
    }
}
    

    private void createHospitalsFile(Hospital hospital) {
    try {
        File file = new File(hospitalsFilePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("CONSOLE LOG\n (" + hospitalsFilePath + ")File created successfully!");
                try (PrintWriter writer = new PrintWriter(new FileWriter(hospitalsFilePath, true))) {
                writer.println("HospitalCode|HospitalName|HospitalAddress");
                }
            } 
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(hospitalsFilePath, true))) {
            if (!hospitals.isEmpty()) {
                Hospital lastHospital = hospitals.get(hospitals.size() - 1);
                writer.println(lastHospital.getHospitalCode() + "," + lastHospital.getHospitalName() + "," + lastHospital.getAddress());
            }else
                writer.println(hospital.getHospitalCode() + "," + hospital.getHospitalName() + "," + hospital.getAddress());
            }
         catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    } catch (IOException ex) { 
    throw new RuntimeException(ex);
    }
}
}



