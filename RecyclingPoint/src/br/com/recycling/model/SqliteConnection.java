package br.com.recycling.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS
 */
public class SqliteConnection {

    public static Connection conection() {

        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            return connection = DriverManager.getConnection("jdbc:sqlite:database/RecyclingDB.db");
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Connection error with the Database");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found");
        }

        return null;
    }

    public static String commandSelect(String table, String[] fields, String[] values) {
        String selectQuery = "";

        if (fields.length != 0 && values.length != 0) {

            selectQuery = "SELECT * FROM " + table + " WHERE ";

            for (int i = 0; i < fields.length; i++) {

                if (i < (fields.length - 1)) {
                    selectQuery += fields[i] + " = " + "'" + values[i] + "'" + " AND ";
                }
                if (i == (fields.length - 1)) {
                    selectQuery += fields[i] + " = " + "'" + values[i] + "'";
                }

            }
        }

        return selectQuery;
    }

    public static String commandInsert(String table, String[] fields, String[] values) {
        int counting = 0;
        String insertQuery = "INSERT INTO " + table + "(";

        while (counting < fields.length) {
            if (counting == (fields.length - 1)) {
                insertQuery += fields[counting] + ") VALUES(";
                counting++;
            } else {
                insertQuery += fields[counting] + ",";
                counting++;
            }
        }
        System.out.println(insertQuery);
        
        counting = 0;
        System.out.println(counting);
        while (counting < fields.length) {
            if (counting == (fields.length - 1)) {
                insertQuery += "'" + values[counting] + "')";
                System.out.println(insertQuery);
                counting++;
            } else {
                insertQuery += "'" + values[counting] + "'" + ",";
                System.out.println(insertQuery);
                counting++;
            }
        }

        return insertQuery;
    }

    public static String commandUpdate(String table, String[] fields, String[] values, String fieldkey, String valuekey) {
        String updateQuery = "UPDATE " + table + " SET ";

        for (int i = 0; i < fields.length; i++) {

            if (i < (fields.length - 1)) {
                updateQuery += fields[i] + " = " + "'" + values[i] + "',";
            }
            if (i == (fields.length - 1)) {
                updateQuery += fields[i] + " = " + "'" + values[i] + "' WHERE " + fieldkey + " = " + "'" + valuekey + "'";
            }

        }

        return updateQuery;
    }

}
