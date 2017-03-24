package dao;

import model.Conjunto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;

//Não precisa mais da Classe AcessoBD
public class ConjuntoDAO
{      
   public boolean cadastraConjunto(Conjunto to)
   {
      boolean sucesso = false;
      String sqlInsert = "insert into conjunto values (?,?,?,?,?,?) ";
                 
      try
      (
         Connection conn = ConnectionFactory.obtemConexao();
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
      )
      {
    	 stm.setInt(1, to.getAndar());
    	 stm.setDouble(2, to.getTamanho());
    	 stm.setInt(3, to.getSalas());
    	 stm.setDouble(4, to.getValor());
    	 stm.setString(5,  to.getObservacao());
    	 stm.setInt(6, to.getSituacao());
    	 
         stm.execute();         
         sucesso = true;
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }   
      return sucesso;   
   }
   
   public Conjunto consultarConjunto(int andar)
   {
      String sqlSelect = "SELECT * FROM conjunto WHERE andar = ?";
      Conjunto c = new Conjunto();
      
      try 
      (
         Connection conn = ConnectionFactory.obtemConexao();
         PreparedStatement stm = conn.prepareStatement(sqlSelect);
      )
      {
         stm.setInt(1, andar);
         try
         (
            ResultSet rs = stm.executeQuery();
         )
         {
            if (rs.next())
            {
               c.setAndar(andar);
               c.setTamanho(rs.getDouble(2));
               c.setSalas(rs.getInt(3));
               c.setValor(rs.getDouble(4));
               c.setObservacao(rs.getString(5));
               c.setSituacao(rs.getInt(6));
            }
         }
         catch (SQLException e)
         {
            e.printStackTrace();
         }
      }  
      catch (SQLException e1) 
      {
         System.out.print(e1.getStackTrace());
      }
      return c;
   }
   
   public ArrayList<Conjunto> consultarTodosConjuntos()
   {
      String sqlSelect = "SELECT * FROM conjunto";
      ArrayList<Conjunto> listC = new ArrayList<Conjunto>();
      
      try
      (
         Connection conn = ConnectionFactory.obtemConexao();
         PreparedStatement stm = conn.prepareStatement(sqlSelect);
      )
      {   
         try
         (
            ResultSet rs = stm.executeQuery();
         )
         {
            while (rs.next())
            {
               Conjunto c = new Conjunto();
               c.setAndar(rs.getInt(1));
               c.setTamanho(rs.getDouble(2));
               c.setSalas(rs.getInt(3));
               c.setValor(rs.getDouble(4));
               c.setObservacao(rs.getString(5));
               c.setSituacao(rs.getInt(6));
               listC.add(c);
            }            
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      catch (SQLException e1)
      {
         System.out.print(e1.getStackTrace());
      }  
      return listC;
   }
   
   public boolean alterarConjunto(Conjunto to)
   {
      boolean sucesso = false;
      String sqlUpdate = "update conjunto set tamanho = ?, salas = ?,valor = ?, observacao = ?, situacao = ? where andar = ?";
            
      try
      (
         Connection conn = ConnectionFactory.obtemConexao();
         PreparedStatement stm = conn.prepareStatement(sqlUpdate);
      )
      {  
         stm.setDouble(1, to.getTamanho());
         stm.setInt(2, to.getSalas());
         stm.setDouble(3, to.getValor());
         stm.setString(4, to.getObservacao());
         stm.setInt(5, to.getSituacao());
         stm.setInt(6, to.getAndar());
         
         stm.execute();
         sucesso = true;
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return sucesso;
   }
}