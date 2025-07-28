package com.day6proj2.controller;

import com.day6proj2.entity.Bug;
import com.day6proj2.service.BugService;
import java.util.List;

public class BugController {
    private final BugService service;

    public BugController(BugService service) {
        this.service = service;
    }

    public void createBug(String title, String description, String status) {
        service.addBug(title, description, status);
    }

    public void displayBugs() {
        List<Bug> bugs = service.fetchAllBugs();
        if (bugs.isEmpty()) {
            System.out.println("No bugs found.");
        } else {
            for (Bug b : bugs) {
                System.out.println("ID: " + b.getId() + ", Title: " + b.getTitle() +
                        ", Status: " + b.getStatus() + ", Description: " + b.getDescription());
            }
        }
    }

    public void deleteBug(int id) {
        service.deleteBug(id);
    }

    public void updateBugStatus(int id, String status) {
        service.updateBugStatus(id, status);
    }
}
