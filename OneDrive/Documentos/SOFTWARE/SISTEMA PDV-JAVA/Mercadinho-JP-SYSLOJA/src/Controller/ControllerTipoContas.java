/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.DaoTipoContas;
import Model.ModelTipoContas;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerTipoContas {
    
    
     private DaoTipoContas dao = new DaoTipoContas();
     
     
     
     //SALVAR
     public int salvarController(ModelTipoContas mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelTipoContas> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelTipoContas retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelTipoContas mod){
     return this.dao.alterarDao(mod);
     }
     
}
