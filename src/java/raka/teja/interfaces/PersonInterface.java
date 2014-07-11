package raka.teja.interfaces;


import raka.teja.domain.Person;
import java.util.List;
/*
 * Aplikasi web crud sederhana 
 * menggunakan java servlet
 */

/**
 *
 * @author I Made Raka Teja
 * @link rakateja.wordpress.com
 */
public interface PersonInterface {
    
    public boolean create(Person person);
    
    public boolean delete(int id);
    
    public boolean update(Person person);
    
    public Person findById(int id);
    
    public List<Person> findAll(int offset);
}
