/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import Dao.DaoVendaProdutovenda2;
import Model.ModelVendaProdutoVenda2;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerVendaProdutoVenda2 {
     private DaoVendaProdutovenda2 dao = new DaoVendaProdutovenda2();
     
     public ArrayList<ModelVendaProdutoVenda2> listaClienteVendas (int pCod){
         return dao.getListClientesVendas(pCod);
     }
     
     
     public ArrayList<ModelVendaProdutoVenda2> listaVendaPorCliente (int pCod){
         return dao.getListClientesVendas(pCod);
     }
     
     
     
     
     
     public ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque (int pCod){
         return dao.getListUsuarioEstoqueBaixaEstoqueDao(pCod);
     }
     public ArrayList<ModelVendaProdutoVenda2> listaVendaProdutos (int pCod){
         return dao.getListaProdutosDao(pCod);
     }
     public ArrayList<ModelVendaProdutoVenda2> listaVendaProdutosAbandono (int pCod){
         return dao.getListaProdutosAbandonoDao(pCod);
     }
     public ArrayList<ModelVendaProdutoVenda2> listaVendaParcelas (int pCod){
         return dao.getListaParcelasDao(pCod);
     }
     public ArrayList<ModelVendaProdutoVenda2> listaVendaAbandono (int pCod){
         return dao.getListUsuarioVendasAbandonoDao(pCod);
     }
      public ArrayList<ModelVendaProdutoVenda2> listaVendaCartao (int pCod){
         return dao.getListUsuarioVendasCartaoDao(pCod);
     }
      
      public ArrayList<ModelVendaProdutoVenda2> listaVendaTurnoUsuer (int pCod){
         return dao.getListUsuarioVendasTurnoDao(pCod);
     }
      
       public ArrayList<ModelVendaProdutoVenda2> listaVendaTurnoUsuerCartao (int pCod){
         return dao.getListUsuarioVendasCartaoTurnoDao(pCod);
     }
       
       
       
       
      public ArrayList<ModelVendaProdutoVenda2> listaVendaTurnoUsuerTickets (int pCod){
         return dao.getListUsuarioVendasTurnoTicketsDao(pCod);
     }
      
      public ArrayList<ModelVendaProdutoVenda2> listaVendaCancelamnto (int pCod){
         return dao.getListUsuarioVendasCancelDao(pCod);
     } 
       public ArrayList<ModelVendaProdutoVenda2> listaVendaCancelamntoCartao (int pCod){
         return dao.getListUsuarioVendasCancelCartaoDao(pCod);
     } 
        public ArrayList<ModelVendaProdutoVenda2> listaVendaCancelamntoTickets (int pCod){
         return dao.getListUsuarioVendasCancelTicketsDao(pCod);
     } 
      
      public ArrayList<ModelVendaProdutoVenda2> listaVendaCartaoProduto (int pCod){
         return dao.getListaProdutosCartaoDao(pCod);
     }
       public ArrayList<ModelVendaProdutoVenda2> listaVendaTickets (int pCod){
         return dao.getListUsuarioVendasTicketsDao(pCod);
     }
        public ArrayList<ModelVendaProdutoVenda2> listaVendaTicketsProdutos (int pCod){
         return dao.getListaProdutosTicketsDao(pCod);
     }
   
}
