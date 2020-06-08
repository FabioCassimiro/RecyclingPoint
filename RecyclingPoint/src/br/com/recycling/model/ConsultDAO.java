package br.com.recycling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS
 */
public class ConsultDAO {

    public static ArrayList<String> values = new ArrayList<>();

    public boolean consultUser(String field, String value) {
        String[] fields = {field};
        String[] values = {value};
        ResultSet row;
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            statement.setQueryTimeout(30);
            row = statement.executeQuery(SqliteConnection.commandSelect("TB_USER", fields, values));
            return row.next();

        } catch (SQLException ex) {
            //Adicionar tratamento de exception
        } finally {
            try {
                if (SqliteConnection.conection() != null) {
                    SqliteConnection.conection().close();
                }
            } catch (SQLException e) {
            }

        }
        return false;
    }

    public boolean consultCredentials(String user, String password) {
        String[] fields = {"USERNAME"};
        String[] values = {user};
        ResultSet row;
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            statement.setQueryTimeout(30);
            row = statement.executeQuery(SqliteConnection.commandSelect("TB_USER", fields, values));
            if (user.equals(row.getString("USERNAME")) && password.equals(row.getString("PASSWORD"))) {
                return true;
            }
        } catch (SQLException ex) {
            //Adicionar tratamento de exception
        } finally {
            try {
                if (SqliteConnection.conection() != null) {
                    SqliteConnection.conection().close();
                }
            } catch (SQLException e) {
            }

        }
        return false;
    }

    public ArrayList<String> valuesItem(String item) {

        String[] field = {"NAME"};
        String[] value = {item};
        ResultSet result;
        int i = 0;
        try {
            Statement statement = SqliteConnection.conection().createStatement();
            statement.setQueryTimeout(30);
            result = statement.executeQuery(SqliteConnection.commandSelect("TB_ITEMS", field, value));
            values.clear();
            while (result.next()) {
                values.add(result.getString("NAME"));
                values.add(result.getString("TYPE"));
                values.add(result.getString("SCORE"));
                values.add(result.getString("YEARS"));
            }
            return values;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
