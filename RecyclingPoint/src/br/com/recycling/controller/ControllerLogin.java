package br.com.recycling.controller;

import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.UserNotFound;
import br.com.recycling.model.ConsultDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            throw new UserNotFound("Invalid or unregistered credentials");
        }
    }
}
