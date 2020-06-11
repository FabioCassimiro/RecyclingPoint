package br.com.recycling.controller;

import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.InvalidEmailAddress;
import br.com.recycling.exception.MinimumAmountOfFieldNotReported;
import br.com.recycling.exception.PasswordsDontMatch;
import br.com.recycling.exception.RegisteredUserException;
import br.com.recycling.model.ConsultDAO;
import br.com.recycling.model.InsertDAO;
import br.com.recycling.model.SqliteConnection;

/**
 *
 * @author Fabio Cassimiro
 */
public class ControllerRegister {

    InsertDAO insertDAO = new InsertDAO();
    ConsultDAO consultDAO = new ConsultDAO();

    public void createUser(String[] informations) {
        String[] fields = {"EMAIL","USERNAME", "PASSWORD"};
        insertDAO.createUser(SqliteConnection.commandInsert("TB_USER", fields, informations));
    }
    
    public void createPeople(String[] informations) {
        String[] fields = {"CPF", "NAME", "LASTNAME"};
        insertDAO.createUser(SqliteConnection.commandInsert("TB_PEOPLE", fields, informations));
    }
    
    public void createScore(String[] informations) {
        String[] fields = {"USERNAME"};
        insertDAO.createUser(SqliteConnection.commandInsert("TB_SCORE", fields, informations));
    }

    public void validUsername(String username) throws MinimumAmountOfFieldNotReported, FieldValueNotInformed {
        
        if (username.equals("")) {
            throw new FieldValueNotInformed("Username not informed");
        }else if (username.length() > 0 && username.length() < 8) {
            throw new MinimumAmountOfFieldNotReported("Username field must be at least 8 characters long");
        }
    }

    public void validPassword(String password, String confirmPassword) throws MinimumAmountOfFieldNotReported, FieldValueNotInformed {   
        if (password.equals("") || confirmPassword.equals("")) {
            throw new FieldValueNotInformed("Password not informed");
        }else if (password.length() > 0 && password.length() < 8) {
            throw new MinimumAmountOfFieldNotReported("Password field must be at least 8 characters long");
        }
    }
    
    public void validNameLastname(String name, String lastname) throws FieldValueNotInformed {
        if (name.equals("") || lastname.equals("")) {
            throw new FieldValueNotInformed("Field name or lastname not informed");
        }
    }

    public void CPFRegistered(String cpf) throws RegisteredUserException {
        if (consultDAO.consultUser("CPF", cpf)) {
            throw new RegisteredUserException("User Registered");
        }
    }

    public void UserRegistered(String username) throws RegisteredUserException {
        if (consultDAO.consultUser("USERNAME", username)) {
            throw new RegisteredUserException("User Registered");
        }
    }

    public void validPasswordEquality(String password, String confirmPassword) throws PasswordsDontMatch {
        if (!password.equals(confirmPassword)) {
            throw new PasswordsDontMatch("passwords don't match");
        }
    }

    public void validEmailAddress(String email) throws InvalidEmailAddress, FieldValueNotInformed {
        if (!email.equals("") && !email.contains("@")) {
            throw new InvalidEmailAddress("Invalid email address");
        } else if (email.equals("")) {
            throw new FieldValueNotInformed("Email not informed");
        }
    }

    
}
