/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressapp.model;

/**
 *
 * @author AnaPimenta
 */
public interface PersonDao {
   public void newPerson(Person person);
   public void editPerson(Person person);
   public void deletePerson(Person person);

}
