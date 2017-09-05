package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
* Classe responsável pela conexão com banco de dados MySQL
*/
public class ConnectionFactory
{
   static 
   {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
      } 
      catch (ClassNotFoundException e)
      {
         throw new RuntimeException(e);
      }
   }
   // Obtém conexão com o banco de dados
   public static Connection obtemConexao() throws SQLException
   {
      String user = "root";
      //String password = "87511520";
      String password = "1234567";
      return DriverManager.getConnection("jdbc:mysql://localhost/predio?user="+user+"&password="+password);
   }
}