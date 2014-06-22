package raka.teja.interfaces;


import raka.teja.domain.Person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rakateja
 */
public interface PersonInterface {
    
    public boolean create(Person person);
    
    public boolean delete(int id);
    
    public boolean update(Person person);
    
    public Person findById(int id);
    
    public Person[] findAll();
}
