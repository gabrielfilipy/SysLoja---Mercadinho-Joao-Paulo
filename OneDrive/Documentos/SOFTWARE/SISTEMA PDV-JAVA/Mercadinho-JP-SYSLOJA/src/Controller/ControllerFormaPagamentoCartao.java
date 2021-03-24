/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.DaoFormaPagamentoCartao;
import Model.ModelFormaPagamentoCartao;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerFormaPagamentoCartao {
    
    
     private DaoFormaPagamentoCartao dao = new DaoFormaPagamentoCartao();
     
     
     
     //SALVAR
     public int salvarController(ModelFormaPagamentoCartao mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelFormaPagamentoCartao> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelFormaPagamentoCartao retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelFormaPagamentoCartao mod){
     return this.dao.alterarDao(mod);
     }
     
}
