package br.com.recycling.model;

import br.com.recycling.exception.UserNotFound;
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

    public boolean consultUser(String field, String value) {
        String[] fields = {field};
        String[] values = {value};
        ResultSet row;
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            row = statement.executeQuery(SqliteConnection.commandSelect("TB_USER", fields, values));
            return row.next();

        } catch (SQLException ex) {
            //Adicionar tratamento de exception
        }
        return false;
    }

    public boolean consultCredentials(String user, String password){
        String[] fields = {"USERNAME"};
        String[] values = {user};
        ResultSet row;
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            row = statement.executeQuery(SqliteConnection.commandSelect("TB_USER", fields, values));
            if(user.equals(row.getString("USERNAME")) && password.equals(row.getString("PASSWORD"))){
                return true;
            }
        } catch (SQLException ex) {
            //Adicionar tratamento de exception
        }
        return false;
    }

}
