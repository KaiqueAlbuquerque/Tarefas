package service;

import java.util.*;

import dao.ConjuntoDAO;
import model.Conjunto; 

public class ConjuntoService
{
   ConjuntoDAO dao;
   
   public ConjuntoService()
   {
      dao = new ConjuntoDAO();
   }
   
   public Conjunto consultarConjunto(int andar)
   {  
      return dao.consultarConjunto(andar);  
   }
   
   public ArrayList<Conjunto> consultarTodosConjuntos()
   {  
      return dao.consultarTodosConjuntos();  
   }
   
   public boolean alterarConjunto(Conjunto to)
   {
      return dao.alterarConjunto(to);	
   }   
     
   public boolean cadastraConjunto(Conjunto to)
   {
      return dao.cadastraConjunto(to);
   }  
   
   public boolean deletarConjunto(int andar)
   {
      return dao.deletarConjunto(andar);
   }  
}