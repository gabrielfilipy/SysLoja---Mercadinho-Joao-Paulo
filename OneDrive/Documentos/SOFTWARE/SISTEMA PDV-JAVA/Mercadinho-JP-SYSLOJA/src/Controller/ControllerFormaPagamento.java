/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.DaoFormaPagamento;
import Model.ModelFormaPagamento;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerFormaPagamento {
    
    
     private DaoFormaPagamento dao = new DaoFormaPagamento();
     
     
     
     //SALVAR
     public int salvarController(ModelFormaPagamento mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelFormaPagamento> listaModelController(){
     return this.dao.retornarLista();
     }
     //RETORNAR UMA LISTA
     public ArrayList<ModelFormaPagamento> listaModelParcController(){
     return this.dao.retornarListaFormParcelamento();
     }
     //RETORNAR UM
     public ModelFormaPagamento retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelFormaPagamento mod){
     return this.dao.alterarDao(mod);
     }
     
}
