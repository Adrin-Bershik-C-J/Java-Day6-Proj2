package com.day6proj2.service;

import com.day6proj2.entity.Bug;
import com.day6proj2.repository.BugRepository;
import java.util.List;

public class BugService {
    private final BugRepository repository;

    public BugService(BugRepository repository) {
        this.repository = repository;
    }

    public void addBug(String title, String description, String status) {
        Bug bug = new Bug(title, description, status);
        repository.insertBug(bug);
    }

    public List<Bug> fetchAllBugs() {
        return repository.getAllBugs();
    }

    public void deleteBug(int id) {
        repository.deleteBugById(id);
    }

    public void updateBugStatus(int id, String status) {
        repository.updateBugStatus(id, status);
    }
}
