/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 
import Dao.DaoFornecedor;
import Model.ModelCliente;
import Model.ModelFornecedor;
import Model.ModelUsuario;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerFornecedor {
    
    
     private DaoFornecedor dao = new DaoFornecedor();
     
     
     
     //SALVAR
     public int salvarController(ModelFornecedor mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelFornecedor> listaModelController(){
     return this.dao.retornarListaDao();
     }
     
     //RETORNAR UM
     public ModelFornecedor retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelFornecedor mod){
     return this.dao.alterarDao(mod);
     }
     
}
