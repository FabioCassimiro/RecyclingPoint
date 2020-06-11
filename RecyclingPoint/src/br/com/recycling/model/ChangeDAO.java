
package br.com.recycling.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author WINDOWS
 */
public class ChangeDAO {
    public void updateScore(String field, String value){
        String[] fields = {field};
        String[] values = {value};
        Statement statement = null;
        try {
            statement = SqliteConnection.conection().createStatement();
            statement.setQueryTimeout(0);
            statement.executeUpdate(SqliteConnection.commandUpdate("TB_SCORE", fields, values, "USERNAME", ConsultDAO.username));
            
        } catch (SQLException ex) {
            //Adicionar tratamento de exception
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
                SqliteConnection.cancelConnection();
            } catch (SQLException e) {
            }

        }
    }
}
