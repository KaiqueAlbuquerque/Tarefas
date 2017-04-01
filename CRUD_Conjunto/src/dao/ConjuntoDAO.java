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
      String sqlInsert = "insert into conjunto (tamanho, salas, valor, observacao, situacao) values (?,?,?,?,?) ";
                 
      try
      (
         Connection conn = ConnectionFactory.obtemConexao();
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
      )
      {
    	 stm.setDouble(1, to.getTamanho());
    	 stm.setInt(2, to.getSalas());
    	 stm.setDouble(3, to.getValor());
    	 stm.setString(4,  to.getObservacao());
    	 stm.setInt(5, to.getSituacao());
    	 
         stm.execute();    
         
         String sql2 = "select last_insert_id()";
		
         try(PreparedStatement ps2 = conn.prepareStatement(sql2))
         {	
			ResultSet rs = ps2.executeQuery();
			if(rs.next())
			{
				to.setAndar(rs.getInt(1));
			}
			sucesso = true;
         }
         catch (SQLException e)
         {
            e.printStackTrace();
         }
      }  
      catch (SQLException e1) 
      {
         e1.getStackTrace();
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
         e1.getStackTrace();
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
        e1.getStackTrace();
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
   
   public boolean deletarConjunto(int andar)
   {
	   String sqlDelete = "DELETE FROM conjunto WHERE andar = ?";
	   boolean sucesso = false;
	   try
	      (
	         Connection conn = ConnectionFactory.obtemConexao();
	         PreparedStatement stm = conn.prepareStatement(sqlDelete);
	      )
	      {  
	         stm.setInt(1, andar);
	         
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