package com.day6proj2.repository;

import java.util.List;

import com.day6proj2.entity.Bug;

public interface BugRepository {
    void insertBug(Bug bug);

    List<Bug> getAllBugs();

    void deleteBugById(int id);

    void updateBugStatus(int id, String status);
}
