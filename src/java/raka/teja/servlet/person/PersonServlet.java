/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raka.teja.servlet.person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import raka.teja.dao.PersonDAO;
import raka.teja.domain.Person;

/**
 *
 * @author rakateja
 */
public class PersonServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        switch (action) {
            case "view":
                this.actionView(request, response);
                break;
            case "edit":
                this.actionEdit(request, response);
                break;
            case "delete":
                this.actionDelete(request, response);
                break;
            case "create":
                this.actionCreate(request, response);
                break;
            case "list":
                this.actionList(request, response);
                break;
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                this.actionPostCreate(request, response);
                break;
        }
    }
    
    public void actionPostCreate(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try {
            Person person = new Person();
            PersonDAO personDao = new PersonDAO();
            
            String id = request.getParameter("id");
            System.out.println("id = "+id);
            
            person.setNoKtp(request.getParameter("no_ktp"));
            person.setNama(request.getParameter("nama"));
            person.setPhone(request.getParameter("phone"));
            person.setSex(Integer.parseInt(request.getParameter("sex")));
            person.setEmail(request.getParameter("email"));
            person.setCity(request.getParameter("kota"));
            person.setBio(request.getParameter("bio"));
            
            personDao.connect();
            if(id.equals("0")){
                personDao.create(person);
            }else{
                person.setId(Integer.parseInt(id));
                personDao.update(person);
            }
            personDao.disconnect();
            
            response.sendRedirect("person.jspa?action=list");
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actionCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        raka.teja.domain.Person person = new raka.teja.domain.Person();
        request.setAttribute("person", person);
        request.getRequestDispatcher("/person/create.jsp").forward(request, response);
    }
    
    public void actionView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            raka.teja.domain.Person person = new raka.teja.domain.Person();
            PersonDAO personDao = new PersonDAO();
            personDao.connect();
            person = personDao.findById(Integer.parseInt(request.getParameter("id")));
            personDao.disconnect();
            request.setAttribute("person", person);
            request.getRequestDispatcher("/person/view.jsp").forward(request, response);
            
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        if(id != null){
            try {
                raka.teja.domain.Person person = new raka.teja.domain.Person();
                PersonDAO personDao = new PersonDAO();
                personDao.connect();
                person = personDao.findById(Integer.parseInt(id));
                personDao.disconnect();
                
                request.setAttribute("person", person);
                request.getRequestDispatcher("/person/create.jsp").forward(request, response);
            } catch (SQLException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(PersonServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void actionDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            PersonDAO personDao = new PersonDAO();
            personDao.connect();
            int idPerson = Integer.parseInt(request.getParameter("id"));
            if(personDao.delete(idPerson)){
                personDao.disconnect();
            }
            response.sendRedirect("person.jspa?action=list");
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            PersonDAO personDao = new PersonDAO();
            personDao.connect();
            
            String pageStr = request.getParameter("page");
            int page;
 
            if(pageStr == null) page = 1; else {
                page = Integer.parseInt(pageStr);
            }
            
            System.out.println("page = "+page);
           
            List<Person> list = personDao.findAll(page);
            personDao.disconnect();
            
            int total = list.size();
            
            request.setAttribute("total", total);
            request.setAttribute("total_page",total/5);
            request.setAttribute("current_page", page);
            request.setAttribute("list", list);
            request.getRequestDispatcher("person/list.jsp").forward(request, response);
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
