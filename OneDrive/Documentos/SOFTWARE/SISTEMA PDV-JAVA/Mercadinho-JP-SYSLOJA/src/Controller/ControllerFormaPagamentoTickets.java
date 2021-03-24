/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.DaoFormaPagamentoTickets;
import Model.ModelFormaPagamentoTickets;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerFormaPagamentoTickets {
    
    
     private DaoFormaPagamentoTickets dao = new DaoFormaPagamentoTickets();
     
     
     
     //SALVAR
     public int salvarController(ModelFormaPagamentoTickets mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelFormaPagamentoTickets> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelFormaPagamentoTickets retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelFormaPagamentoTickets mod){
     return this.dao.alterarDao(mod);
     }
     
}
