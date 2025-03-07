package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E3 {
    public static void main(String[] args){

        try (Connection connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM employee";
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            List<Map<String, String>> tableData = new ArrayList<>();

            while (rs.next()) {
                Map<String, String> rowMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) { // Use 1-based indexing
                    String key = rsmd.getColumnName(i);
                    String value = rs.getString(i);
                    rowMap.put(key, value);
                }
                tableData.add(rowMap);
            }
            System.out.println(tableData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
