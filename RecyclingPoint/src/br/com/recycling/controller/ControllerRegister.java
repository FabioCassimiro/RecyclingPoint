package br.com.recycling.controller;

import br.com.recycling.exception.InvalidEmailAddress;
import br.com.recycling.exception.PasswordsDontMatch;
import br.com.recycling.exception.RegisteredUserException;
import br.com.recycling.model.ConsultDAO;
import br.com.recycling.model.InsertDAO;
import br.com.recycling.model.SqliteConnection;

/**
 *
 * @author WINDOWS
 */
public class ControllerRegister {

    InsertDAO insertDAO = new InsertDAO();
    ConsultDAO consultDAO = new ConsultDAO();

    public void createUser(String[] informations) {
        String[] fields = {"CPF", "NAME", "LASTNAME", "SCORE", "USERNAME", "PASSWORD", "REGISTRATIONDATE"};
        insertDAO.createUser(SqliteConnection.commandInsert("TB_USER", fields, informations));
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

    public void validPassword(String password, String confirmPassword) throws PasswordsDontMatch {
        if (!password.equals(confirmPassword) && (!password.equals("") && !confirmPassword.equals(""))) {
            throw new PasswordsDontMatch("passwords don't match");
        }
    }

    public void validEmailAddress(String email) throws InvalidEmailAddress {
        if (!email.contains("@") && !email.equals("")) {
            throw new InvalidEmailAddress("Invalid email address");
        } else if (email.equals("")) {
            throw new InvalidEmailAddress("email not informed");
        }
    }
}
