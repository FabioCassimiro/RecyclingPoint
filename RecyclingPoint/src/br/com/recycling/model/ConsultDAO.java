
package br.com.recycling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS
 */
public class ConsultDAO {
    
    
    public void consultUser(String[] informations){
        String[] fields = {"CPF"};
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            ResultSet row = statement.executeQuery(SqliteConnection.commandSelect("TB_USER", fields, informations));
            System.out.println(row.getRow());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
