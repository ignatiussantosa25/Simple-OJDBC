/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JobGrade;
import ojdbc.latihan.Koneksi;

/**
 *
 * @author Ignatius
 */
public class JobGradeDAO{
    public Connection kon;

    public JobGradeDAO() {
        this.kon = new Koneksi().getKoneksi();
    }
    
    /**
    * Fungsi untuk melihat semua data JobGrade
    * @return List semua data JobGrade
    */
    public List<JobGrade> getAllData(){
        return getData("");
    }
    
    /**
    * Fungsi untuk melihat data JobGrade dengan inputan
    * tertentu 
    * @param cari String
    * @return data JobGrade
    */
    public JobGrade getByGradeLevel(String gradeLevel){
        return getData("WHERE grade_level='"
                +gradeLevel+"'").get(0);
    }
    
    /**
    * Fungsi untuk melihat semua data JobGrade dengan inputan
    * tertentu 
    * @param cari String
    * @return semua data List
    */
    public List<JobGrade> search(String category, String cari){
        return getData("WHERE "+category+ 
                " LIKE '%"+cari+"%'");
    }
    
    private List<JobGrade> getData(String query){
        List<JobGrade> datas = new ArrayList<>();
        try {
            PreparedStatement pst =
                    kon.prepareStatement("SELECT * FROM "
                            + "job_grades "+query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JobGrade jd = new JobGrade(
                        rs.getString("grade_level"), 
                        rs.getInt("lowest_sal"), 
                        rs.getInt("highest_sal"));
                datas.add(jd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }
    
    public boolean insert(JobGrade jobGrade){
        try {
            PreparedStatement pst=kon.prepareStatement("INSERT "
                    + "INTO JOB_GRADES VALUES(?,?,?)");
            pst.setString(1, jobGrade.getGradeLevel());
            pst.setInt(2, jobGrade.getLowestSalary());
            pst.setInt(3, jobGrade.getHighestSalary());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean update(JobGrade jobGrade){
        try {
            PreparedStatement pst=kon.prepareStatement(
                    "UPDATE JOB_GRADES "
                    + "SET lowest_sal=?, highest_sal=? "
                    + "WHERE grade_level=?");
            pst.setString(3, jobGrade.getGradeLevel());
            pst.setInt(1, jobGrade.getLowestSalary());
            pst.setInt(2, jobGrade.getHighestSalary());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean delete(String gradeLevel){
        try {
            PreparedStatement pst=kon.prepareStatement(
                    "DELETE FROM JOB_GRADES "
                    + "WHERE grade_level=?");
            pst.setString(1, gradeLevel);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
