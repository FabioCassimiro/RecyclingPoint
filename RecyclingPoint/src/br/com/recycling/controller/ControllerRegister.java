package br.com.recycling.controller;

import br.com.recycling.exception.RegistedUserException;
import br.com.recycling.model.ConsultDAO;
import br.com.recycling.model.InsertDAO;
import br.com.recycling.model.SqliteConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS
 */
public class ControllerRegister {

    InsertDAO insertDAO = new InsertDAO();
    ConsultDAO consultDAO = new ConsultDAO();
    
    public void Registed(String[] informations){
        try {
            registedUser(informations);
            createUser(informations);
        } catch (RegistedUserException ex) {
            JOptionPane.showMessageDialog(null, "User registed");
        }
        
    }

    public void createUser(String []informations) {
        String[] fields = {"CPF", "NAME", "LASTNAME", "PUNCTUATION", "USERNAME", "PASSWORD", "REGISTRATIONDATE"};
        insertDAO.createUser(SqliteConnection.commandInsert("TB_USER", fields, informations));
    }
    
    public void registedUser(String[] informations) throws RegistedUserException{
        consultDAO.consultUser(informations);
        
    }
}
