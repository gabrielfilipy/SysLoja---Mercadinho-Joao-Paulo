/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoCidade;
import Model.ModelCidade;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerCidade {
    
    
     private DaoCidade dao = new DaoCidade();
     
     
     
     //SALVAR
     public int salvarController(ModelCidade mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelCidade> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelCidade retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelCidade mod){
     return this.dao.alterarDao(mod);
     }
     
}
