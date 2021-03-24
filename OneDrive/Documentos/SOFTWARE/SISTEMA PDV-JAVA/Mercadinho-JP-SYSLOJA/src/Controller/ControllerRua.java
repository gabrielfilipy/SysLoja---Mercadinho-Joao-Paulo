/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoBairro;
import Dao.DaoRua;
import Model.ModelBairro;
import Model.ModelRua;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerRua {
    
    
     private DaoRua dao = new DaoRua();
     
     
     
     //SALVAR
     public int salvarController(ModelRua mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelRua> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelRua retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelRua mod){
     return this.dao.alterarDao(mod);
     }
     
}
