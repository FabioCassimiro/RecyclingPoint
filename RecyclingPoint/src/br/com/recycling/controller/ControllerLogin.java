package br.com.recycling.controller;

import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.UserNotFound;
import br.com.recycling.model.ConsultDAO;

/**
 *
 * @author Fabio Cassimiro
 */
public class ControllerLogin {

    ConsultDAO consultDAO = new ConsultDAO();

    public void validCredentials(String user, String password) throws FieldValueNotInformed {
        if (user.equals("") && password.equals("")) {
            throw new FieldValueNotInformed("Username and password not entered");
        } else if (user.equals("")) {
            throw new FieldValueNotInformed("Username not informed");
        } else if (password.equals("")) {
            throw new FieldValueNotInformed("Password not informed");
        }
    }

    public void searchCredentials(String user, String password) throws UserNotFound {
        if (!consultDAO.consultCredentials(user, password)) {
            throw new UserNotFound("User not found or does exist");
        }
    }
}
