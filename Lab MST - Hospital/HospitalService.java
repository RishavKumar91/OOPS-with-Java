package com.hospital;

import java.io.*;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String msg) {
        super(msg);
    }
}

class DuplicatePatientException extends Exception {
    public DuplicatePatientException(String msg) {
        super(msg);
    }
}

public class HospitalService {

    String file = "patients.txt";

    public void addPatient(Patient p) throws Exception {

        if (p.getAge() < 0 || p.getAge() > 120)
            throw new InvalidAgeException("Invalid Age");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {

            String data[] = line.split(",");

            if (Integer.parseInt(data[0]) == p.getPatientId()) {
                br.close();
                throw new DuplicatePatientException("Duplicate Patient ID");
            }
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        bw.write(p.getPatientId() + "," + p.getPatientName() + "," + p.getAge() + "," + p.getDisease());
        bw.newLine();

        bw.close();

        if (p.getAge() > 60 && p.getDisease().equalsIgnoreCase("Heart Problem"))
            System.out.println("Priority Patient – Immediate Attention Required");

        System.out.println("Patient Added Successfully");
    }

    public void displayPatients() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Age: " + data[2]);
                System.out.println("Disease: " + data[3]);
                System.out.println("----------------");
            }

            br.close();

        } catch (Exception e) {
            System.out.println("File Error");
        }
    }

    public void searchPatient(int id) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {

            String data[] = line.split(",");

            if (Integer.parseInt(data[0]) == id) {

                System.out.println("Patient Found");
                System.out.println("Name: " + data[1]);
                System.out.println("Age: " + data[2]);
                System.out.println("Disease: " + data[3]);

                found = true;
                break;
            }
        }

        br.close();

        if (!found)
            throw new PatientNotFoundException("Patient Not Found");
    }
}
