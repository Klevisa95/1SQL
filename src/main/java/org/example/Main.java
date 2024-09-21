package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {



        //jdbc --> api that we are planning to use from java
        //my sql --> name of the database to which we are connecting
        //3.239.253.255:3306 --> address of the computer that as our database 3306 --> port of the application
        //syntaxhrm_mysql --> name of the database
        String dbURL = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName ="syntax_hrm";
        String password ="syntaxhrm123";

        //Helps us establish the connection
        try {    //Connect to the database.
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
              //helps us take the query on the db server execute it and bring the results back
            Statement statement = connection.createStatement();
            //Run the query to get all data from the person table.
            String query = "select * from person";
            ResultSet resultSet = statement.executeQuery(query);
            //Loop through the results and print the firstname, age, and city for each row.
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                int age = resultSet.getInt("age");
                String city = resultSet.getString("city");
                System.out.println(firstname + " "+ age + " "+ city);
            }
        }catch (SQLException e) {  //If an error occurs, it will print the error details.
            e.printStackTrace();

            //Connect to the database.
            //Run the query to get all data from the person table.
            //Loop through the results and print the firstname, age, and city for each row.
            //If an error occurs, it will print the error details.

        }
    }
}
