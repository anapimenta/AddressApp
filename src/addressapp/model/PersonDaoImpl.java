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
import addressapp.util.DateUtil;


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
   public void newPerson(Person person){
       //connection ainda não implementado 
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_NEW_PERSON, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2,person.getLastName());
            pstmt.setString(3, person.getStreet());
            pstmt.setInt(4, person.getPostalCode());
            pstmt.setString(5, person.getCity());
            //aparentemente a data vai ter que ser string
            pstmt.setString(6, DateUtil.format(person.getBirthday()) );
            
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                   // .setPersonId(generatedKeys.getInt(1)); ainda não implementado
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   @Override
   public void editPerson(Person person){
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_EDIT_PERSON)) {
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2,person.getLastName());
            pstmt.setString(3, person.getStreet());
            pstmt.setInt(4, person.getPostalCode());
            pstmt.setString(5, person.getCity());
            pstmt.setString(6, DateUtil.format(person.getBirthday()) );
       //     pstmt.setInt(7, person.getPersonId); ainda não implementado
            
            pstmt.executeUpdate();  
        } 
        catch (SQLException ex) {
             Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   @Override
   public void deletePerson(Person person){
       //connection ainda não implementdado
      try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_PERSON)) {            
            //pstmt.setInt(1, personId);   ID ainda não implementado 
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }
}
