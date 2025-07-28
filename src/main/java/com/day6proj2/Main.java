package com.day6proj2;

import com.day6proj2.controller.BugController;
import com.day6proj2.repository.BugRepositoryImpl;
import com.day6proj2.service.BugService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BugService service = new BugService(new BugRepositoryImpl());
        BugController controller = new BugController(service);

        while (true) {
            try {
                System.out.println("1. Insert a bug");
                System.out.println("2. View all bugs");
                System.out.println("3. Delete bug by ID");
                System.out.println("4. Update bug status by ID");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number (1-5).");
                    sc.nextLine();
                    continue;
                }

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter status (Open/In Progress/Closed): ");
                        String status = sc.nextLine();
                        controller.createBug(title, desc, status);
                        break;

                    case 2:
                        controller.displayBugs();
                        break;

                    case 3:
                        System.out.print("Enter bug ID to delete: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid ID! Must be a number.");
                            sc.nextLine();
                            break;
                        }
                        int delId = sc.nextInt();
                        sc.nextLine();
                        controller.deleteBug(delId);
                        break;

                    case 4:
                        System.out.print("Enter bug ID to update: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid ID! Must be a number.");
                            sc.nextLine();
                            break;
                        }
                        int updId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new status: ");
                        String newStatus = sc.nextLine();
                        controller.updateBugStatus(updId, newStatus);
                        break;

                    case 5:
                        System.out.println("Exiting Bug Tracker. Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Enter between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
