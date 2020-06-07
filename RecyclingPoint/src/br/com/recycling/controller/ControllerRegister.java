package br.com.recycling.controller;

import br.com.recycling.exception.FieldValueNotInformed;
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

    public void UserRegistered(String username) throws RegisteredUserException, FieldValueNotInformed {
        if (!username.equals("")) {
            if (consultDAO.consultUser("USERNAME", username)) {
                throw new RegisteredUserException("User Registered");
            }
        } else {
            throw new FieldValueNotInformed("Username not informed");
        }

    }

    public void validPassword(String password, String confirmPassword) throws PasswordsDontMatch, FieldValueNotInformed {
        if (!password.equals(confirmPassword) && (!password.equals("") && !confirmPassword.equals(""))) {
            throw new PasswordsDontMatch("passwords don't match");
        } else if (password.equals("") || confirmPassword.equals("")) {
            throw new FieldValueNotInformed("Password not informed");
        }
    }

    public void validEmailAddress(String email) throws InvalidEmailAddress, FieldValueNotInformed {
        if (!email.equals("") && !email.contains("@")) {
            throw new InvalidEmailAddress("Invalid email address");
        } else if (email.equals("")) {
            throw new FieldValueNotInformed("Email not informed");
        }
    }

    public void validNameLastname(String name, String lastname) throws FieldValueNotInformed {
        if (name.equals("") || lastname.equals("")) {
            throw new FieldValueNotInformed("Field name or lastname not informed");
        }
    }
}
