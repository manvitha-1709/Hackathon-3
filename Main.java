class Appointment {
    String patientName;
    String patientId;
    String doctorName;
    String appointmentType;
    double consultationFee;

    // Parameterized constructor
    Appointment(String patientName, String patientId, String doctorName,
                String appointmentType, double consultationFee) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.appointmentType = appointmentType;
        this.consultationFee = consultationFee;
    }

    // Constructor with fewer details
    Appointment(String patientName, String patientId) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.doctorName = "Not Assigned";
        this.appointmentType = "GENERAL";
        this.consultationFee = 500;
    }

    // Validate appointment details
    boolean validate() {
        return patientName.length() > 0 &&
               patientId.length() > 0 &&
               consultationFee > 0;
    }

    // Display appointment details
    void display() {
        display("Confirmed");
    }

    // Overloaded display method
    void display(String status) {
        System.out.println("Patient Name       : " + patientName.toUpperCase());
        System.out.println("Patient ID         : " + patientId);
        System.out.println("Doctor Name        : " + doctorName.toUpperCase());
        System.out.println("Appointment Type   : " + appointmentType);
        System.out.printf("Consultation Fee   : Rs %.2f%n", consultationFee);
        System.out.println("Appointment Status : " + status);
        System.out.println();
    }

    // Compare patient names
    boolean comparePatient(Appointment a) {
        return patientName.equalsIgnoreCase(a.patientName);
    }

    // Overloaded method to calculate charges
    double calculateCharges() {
        return consultationFee;
    }

    double calculateCharges(int numberOfAppointments) {
        return consultationFee * numberOfAppointments;
    }
}

public class Main {
    public static void main(String[] args) {
        Appointment a1 = new Appointment(
            "Priya Sharma", "P101", "Dr. Kumar", "GENERAL", 500
        );

        Appointment a2 = new Appointment(
            "Rahul Verma", "P102", "Dr. Meena", "SPECIALIST", 800
        );

        System.out.println("========== CLINIC APPOINTMENT SYSTEM ==========");

        a1.display();
        a2.display();

        double total = a1.calculateCharges() + a2.calculateCharges();

        System.out.println("---------- APPOINTMENT SUMMARY ----------");
        System.out.println("Total Appointments : 2");
        System.out.printf("Total Consultation : Rs %.2f%n", total);

        if (a1.comparePatient(a2)) {
            System.out.println("Patient Verification: Names Match");
        } else {
            System.out.println("Patient Verification: Names Do Not Match");
        }

        System.out.println("=============================================");
    }
}