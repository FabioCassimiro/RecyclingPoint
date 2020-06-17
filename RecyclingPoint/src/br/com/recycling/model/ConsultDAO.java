package br.com.recycling.model;

import br.com.recycling.utils.Cryptography;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio Cassimiro
 */
public class ConsultDAO {

    public static ArrayList<String> values = new ArrayList<>();
    public static String username;

    public boolean consultUser(String table, String field, String value) {
        String[] fields = {field};
        String[] values = {value};
        ResultSet resultSet = null;
        Statement statement = null;

        try {

            statement = SqliteConnection.connection().createStatement();
            statement.setQueryTimeout(30);
            resultSet = statement.executeQuery(SqliteConnection.commandSelect(table, fields, values));
            return resultSet.next();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            SqliteConnection.closeConnection();

        }
        return false;
    }

    public boolean consultCredentials(String user, String password) {
        String[] fields = {"USERNAME"};
        String[] values = {user};
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = SqliteConnection.connection().createStatement();
            statement.setQueryTimeout(30);
            resultSet = statement.executeQuery(SqliteConnection.commandSelect("TB_USER", fields, values));
            if (user.equals(resultSet.getString("USERNAME")) && Cryptography.criptografia(password).equals(resultSet.getString("PASSWORD"))) {
                username = resultSet.getString("USERNAME");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (statement.isClosed() == false) {
                    statement.close();
                }
                if (resultSet.isClosed() == false) {
                    resultSet.close();
                }

                SqliteConnection.closeConnection();
            } catch (SQLException ex) {
            }
        }

        return false;
    }

    public ArrayList<String> valuesItem(String item) {

        String[] field = {"NAME"};
        String[] value = {item};
        ResultSet resultset = null;
        Statement statement = null;
        int i = 0;
        try {
            statement = SqliteConnection.connection().createStatement();
            statement.setQueryTimeout(30);
            resultset = statement.executeQuery(SqliteConnection.commandSelect("TB_ITEMS", field, value));
            values.clear();
            while (resultset.next()) {
                values.add(resultset.getString("NAME"));
                values.add(resultset.getString("TYPE"));
                values.add(resultset.getString("SCORE"));
                values.add(resultset.getString("DECOMPOSITION"));
            }
            return values;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                statement.close();
                resultset.close();
                SqliteConnection.closeConnection();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return null;
    }

    public static String consultScore() {
        String[] field = {"USERNAME"};
        String[] value = {username};
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = SqliteConnection.connection().createStatement();
            resultSet = statement.executeQuery(SqliteConnection.commandSelect("TB_SCORE", field, value));
            return resultSet.getString("SCORE");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                statement.close();
                resultSet.close();
                SqliteConnection.closeConnection();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

        return null;
    }

}
