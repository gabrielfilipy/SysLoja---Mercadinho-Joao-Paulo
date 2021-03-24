/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoBairro;
import Model.ModelBairro;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerBairro {
    
    
     private DaoBairro dao = new DaoBairro();
     
     
     
     //SALVAR
     public int salvarController(ModelBairro mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelBairro> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelBairro retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelBairro mod){
     return this.dao.alterarDao(mod);
     }
     
}
