
import java.util.Scanner;

class Node {
    int rollNo;
    String name;
    Node next;

    Node(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.next = null;
    }
}

public class Main {

    static Node head = null;

    // Insert student
    static void insert(int rollNo, String name) {
        Node newNode = new Node(rollNo, name);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student added successfully!");
    }

    // Delete student
    static void delete(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully!");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully!");
        }
    }

    // Search student
    static void search(int rollNo) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found!");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found!");
    }

    // Update student
    static void update(int rollNo, String newName) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.name = newName;
                System.out.println("Student updated successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found!");
    }

    // Display all students
    static void display() {
        if (head == null) {
            System.out.println("No student records available!");
            return;
        }

        Node temp = head;

        System.out.println("\nStudent Records:");

        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("-------------------");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, rollNo;
        String name;

        do {
            System.out.println("\n--- Student Registration System ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    name = sc.nextLine();

                    insert(rollNo, name);
                    break;

                case 2:
                    System.out.print("Enter Roll Number to delete: ");
                    rollNo = sc.nextInt();

                    delete(rollNo);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    rollNo = sc.nextInt();

                    search(rollNo);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to update: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();

                    update(rollNo, name);
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Exiting Student Registration System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
