package kataoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kataoracle {
    private static final String URL="jdbc:oracle:thin:@10.22.146.238:1521:orcl";
    private static final String USER="system";
    private static final String PASSWORD="orcl";
    
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from cambio_eur_a");
        while (resultset.next())
        {
            System.out.print(resultset.getString("divisa")+" ");
            System.out.println(resultset.getBigDecimal("cambio"));       
        }
        connection.close();
    }
}
