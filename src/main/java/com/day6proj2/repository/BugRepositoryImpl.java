package com.day6proj2.repository;

import com.day6proj2.entity.Bug;
import com.day6proj2.utils.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BugRepositoryImpl implements BugRepository {

    @Override
    public void insertBug(Bug bug) {
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO bugtable (title, description, status) VALUES (?, ?, ?)")) {
            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getStatus());
            ps.executeUpdate();
            System.out.println("Bug inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bugtable")) {
            while (rs.next()) {
                Bug bug = new Bug();
                bug.setId(rs.getInt("id"));
                bug.setTitle(rs.getString("title"));
                bug.setDescription(rs.getString("description"));
                bug.setStatus(rs.getString("status"));
                bugs.add(bug);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bugs;
    }

    @Override
    public void deleteBugById(int id) {
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM bugtable WHERE id=?")) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Bug deleted." : "Bug not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBugStatus(int id, String status) {
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE bugtable SET status=? WHERE id=?")) {
            ps.setString(1, status);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Bug status updated." : "Bug not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
