package br.com.recycling.controller;

import br.com.recycling.exception.UserNotFound;
import br.com.recycling.model.ConsultDAO;

/**
 *
 * @author WINDOWS
 */
public class ControllerLogin {
    
    ConsultDAO consultDAO = new ConsultDAO();
    public void searchCredentials(String user, String password) throws UserNotFound{
        if(!consultDAO.consultCredentials(user, password)){
            throw new UserNotFound("User not found or does exist");
        }
    }
}
