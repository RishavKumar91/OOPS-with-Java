package com.hospital;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalService service = new HospitalService();

        while (true) {

            System.out.println("\n1 Add Patient");
            System.out.println("2 Display Patients");
            System.out.println("3 Search Patient");
            System.out.println("4 Exit");

            int choice = sc.nextInt();

            try {

                if (choice == 1) {

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    Patient p = new Patient(id, name, age, disease);

                    service.addPatient(p);
                }

                else if (choice == 2) {
                    service.displayPatients();
                }

                else if (choice == 3) {

                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();

                    service.searchPatient(id);
                }

                else if (choice == 4) {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
