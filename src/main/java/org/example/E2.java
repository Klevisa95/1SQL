package org.example;

import java.sql.*;

public class E2 {
    public static void main(String[] args) {

        /*
        Results contains the actual data
        ResultSetMetData information about data
         */
        try (Connection connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD)) {
            Statement statement = connection.createStatement();
            String query = "Select * from person";
            ResultSet resultSet=statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            System.out.println(resultSetMetaData.getColumnCount());
            for (int i = 1; i <resultSetMetaData.getColumnCount() ; i++) {
                System.out.println(resultSetMetaData.getCatalogName(i)+ " ");
            }
            while (resultSet.next()){
                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                    System.out.println(resultSet.getString(i)+ " ");
                }
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


