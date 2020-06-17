package br.com.recycling.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fabio Cassimiro
 */

public class ChangeDAO {

    public void updateScore(String field, String value) {
        String[] fields = {field};
        String[] values = {value};
        Statement statement = null;
        try {
            statement = SqliteConnection.connection().createStatement();
            statement.setQueryTimeout(15);
            statement.executeUpdate(SqliteConnection.commandUpdate("TB_SCORE", fields, values, "USERNAME", ConsultDAO.username));
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                SqliteConnection.closeConnection();
                statement.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
    }
}
