/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressapp.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


//import database.ConnectToDatabase;
/**
 *
 * @author AnaPimenta
 */
public class PersonDaoImpl implements PersonDao{
   
    //private final Connection conn = ConnectToDatabase.createConnection();
    
    private final String SQL_NEW_PERSON = 
            "INSERT INTO person (firstName, lastName, street, postalCode, city, birthday) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_EDIT_PERSON = 
            "UPDATE person SET firstName=?, lastName=?, street=?, postalCode=?, city=?, birthday=? WHERE personId=?";
    private final String SQL_DELETE_PERSON = 
            "DELETE FROM person WHERE personId=?";
    
   @Override
   public void newPerson();
   @Override
   public void editPerson();
   @Override
   public void deletePerson();
}
