/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.DaoSangria;
import Model.ModelSangria;
import java.util.ArrayList;
 
/**
 *
 * @author Monet
 */
     public class ControllerSangria {
    
    
     private DaoSangria dao = new DaoSangria();
     
     
     
     //SALVAR
     public int salvarController(ModelSangria mod){
     return dao.SalvarDao(mod);
     }

     //RETORNAR UMA LISTA
     public ArrayList<ModelSangria> listaModelController(){
     return this.dao.retornarLista();
     }
    
     //ALTERAR 
     public boolean alterarController(ModelSangria mod){
     return this.dao.alterarDao(mod);
     }
     
}
