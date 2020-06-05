package br.com.recycling.model;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS
 */
public class InsertDAO {

    public void createUser(String query) {
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "User created", "RecyclingPoint", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to register user", "RecyclingPoint", JOptionPane.ERROR_MESSAGE);
        }

    }
}
