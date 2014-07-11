/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raka.teja.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import raka.teja.config.Database;
import raka.teja.domain.Person;
import raka.teja.interfaces.PersonInterface;

/**
 *
 * @author rakateja
 */
public class PersonDAO extends Database implements PersonInterface{
    public PersonDAO() throws SQLException, InstantiationException, IllegalAccessException
    {
    }
    @Override
    public boolean create(Person person) {
        try {
            
            System.out.println("create person");
            
            //`no_ktp`=?,`nama`=?,`sex`=?,`email`=?,`phone`=?,`city`=?,`bio`=? WHERE `id`=?
            PreparedStatement pStat = this.getConn().prepareStatement(INSERT);
            pStat.setString(1, person.getNoKtp());
            pStat.setString(2, person.getNama());
            pStat.setInt(3, person.getSex());
            pStat.setString(4, person.getEmail());
            pStat.setString(5, person.getPhone());
            pStat.setString(6, person.getCity());
            pStat.setString(7, person.getBio());
            
            return pStat.executeUpdate() == 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement pStat = this.getConn().prepareStatement(DELETE);
            pStat.setInt(1, id);
            return pStat.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(Person person) {
        try {
            System.out.println("update person");
            PreparedStatement pStat = this.getConn().prepareStatement(UPDATE);
            pStat.setString(1, person.getNoKtp());
            pStat.setString(2, person.getNama());
            pStat.setInt(3, person.getSex());
            pStat.setString(4, person.getEmail());
            pStat.setString(5, person.getPhone());
            pStat.setString(6, person.getCity());
            pStat.setString(7, person.getBio());
            pStat.setInt(8, person.getId());
            
            System.out.println("id = "+person.getId());
            return pStat.executeUpdate() == 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Person findById(int id) {
        Person person = new Person();
        try {
            PreparedStatement pStat = this.getConn().prepareStatement(SELECT_BY);
            pStat.setInt(1, id);
            ResultSet rs = pStat.executeQuery();
            if(rs.next()){
                person.setId(rs.getInt("id"));
                person.setNama(rs.getString("nama"));
                person.setNoKtp(rs.getString("no_ktp"));
                person.setPhone(rs.getString("phone"));
                person.setSex(rs.getInt("sex"));
                person.setEmail(rs.getString("email"));
                person.setCity(rs.getString("city"));
                person.setBio(rs.getString("bio"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }

    @Override
    public List<Person> findAll(int offset) {
        List<Person> list = new ArrayList<Person>();
        try {
            
            int page = 5;
            
            PreparedStatement pStat = this.getConn().prepareStatement(SELECT_ALL);
            pStat.setInt(1, (offset-1)*page);
            pStat.setInt(2, page);
            ResultSet rs = pStat.executeQuery();
            
            while(rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setNama(rs.getString("nama"));
                person.setNoKtp(rs.getString("no_ktp"));
                person.setPhone(rs.getString("phone"));
                person.setSex(rs.getInt("sex"));
                person.setEmail(rs.getString("email"));
                person.setCity(rs.getString("city"));
                person.setBio(rs.getString("bio"));
                
                list.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private final String INSERT = "INSERT INTO person(`no_ktp`, `nama`,`sex`,`email`,`phone`,`city`,`bio`) VALUES(?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE `Person` SET `no_ktp`=?,`nama`=?,`sex`=?,`email`=?,`phone`=?,`city`=?,`bio`=? WHERE `id`=?;";
    private final String DELETE = "DELETE FROM `Person` WHERE `id`=?;";
    private final String SELECT_ALL = "SELECT * FROM `Person` limit ?,?";
    private final String SELECT_BY = "SELECT * FROM `Person` WHERE `id`=?";
    
}
