/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 


import Dao.DaoPagarContas;
import Model.ModelPagarConta;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerPagarContas {
    
    
     private DaoPagarContas dao = new DaoPagarContas();
     
     
     
     
     
     //SALVAR
     public int salvarUsuarioController(ModelPagarConta mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirUsuarioController(int id){
     return this.dao.excluirDao(id);
     }
     //ALTERAR 
     public boolean alterarUsuarioController(ModelPagarConta mod){
     return this.dao.alterarDao(mod);
     }
     //RETORNAR UM
     public ModelPagarConta retornarUsuarioController(int cod){
     return this.dao.retornarDao(cod);
     }
     //RETORNAR UMA LISTA
     public ArrayList<ModelPagarConta> listaModelUsuarioController(){
     return this.dao.retornarListaDao();
     }
     
     
     
}
