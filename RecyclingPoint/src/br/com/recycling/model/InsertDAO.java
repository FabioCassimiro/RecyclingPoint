package br.com.recycling.model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabio Cassimiro
 */
public class InsertDAO {

    public void createUser(String query) {
        try {
            Statement statement = SqliteConnection.connection().createStatement();
            statement.executeUpdate(query);
            statement.setQueryTimeout(30);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to register user", "RecyclingPoint", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            try {
                SqliteConnection.connection().close();
            } catch (SQLException ex) {
                Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
