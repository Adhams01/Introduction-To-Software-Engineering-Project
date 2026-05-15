package ui;

import controller.PatientController;

import java.util.Scanner;

public class RegisterPatientConsoleUI {
    private final PatientController patientController;

    public RegisterPatientConsoleUI(PatientController patientController) {
        this.patientController = patientController;
    }

    public void run(Scanner scanner) {
        System.out.println("UC-02 Register Patient (Console UI)");

        System.out.print("Enter Patient National ID: ");
        String nationalId = scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        String result = patientController.registerPatient(nationalId, name);
        System.out.println(result);
    }
}
