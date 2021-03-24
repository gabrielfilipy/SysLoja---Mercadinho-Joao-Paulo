/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 

import Dao.DaoPromocao;
import Model.ModelProduto;
import Model.ModelPromocao;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerPromocao {
    
    
     private DaoPromocao dao = new DaoPromocao();  
     
     
     
     //SALVAR
     public int salvarController(ModelPromocao mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     //RETORNAR UMA LISTA
     public ArrayList<ModelPromocao> listaModelController(){
     return this.dao.retornarListaDeUsuario();
     }
     
}
