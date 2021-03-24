/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 

import Dao.DaoCadastroContas;
import Model.ModelCadastroContas;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerCadastroContas {
    
    
     private DaoCadastroContas dao = new DaoCadastroContas();
     
     
     
     
     
     //SALVAR
     public int salvarUsuarioController(ModelCadastroContas mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirUsuarioController(int id){
     return this.dao.excluirDao(id);
     }
     //ALTERAR 
     public boolean alterarUsuarioController(ModelCadastroContas mod){
     return this.dao.alterarDao(mod);
     }
     //RETORNAR UM
     public ModelCadastroContas retornarUsuarioController(int cod){
     return this.dao.retornarDao(cod);
     }
     //RETORNAR UMA LISTA
     public ArrayList<ModelCadastroContas> listaModelUsuarioController(){
     return this.dao.retornarListaDao();
     }
     
     
     
}
