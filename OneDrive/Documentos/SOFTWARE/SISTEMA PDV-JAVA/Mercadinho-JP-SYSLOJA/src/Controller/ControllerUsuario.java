/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 
import Dao.DaoUsuario;
import Model.ModelUsuario;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerUsuario {
    
    
     private DaoUsuario daoUsuario = new DaoUsuario();
     
     
     
     
      //RETORNAR UM
     public ModelUsuario retornarPorNomeController(String nome){
     return this.daoUsuario.retornarDao(nome);
     }
     //SALVAR
     public int salvarUsuarioController(ModelUsuario modelUsuario){
     return daoUsuario.SalvarUsuarioDao(modelUsuario);
     }
     //EXCLUIR
     public boolean excluirUsuarioController(int idUsuario){
     return this.daoUsuario.excluirUsuarioDao(idUsuario);
     }
     //ALTERAR 
     public boolean alterarUsuarioController(ModelUsuario modelUsuario){
     return this.daoUsuario.alterarUsuarioDao(modelUsuario);
     }
     //RETORNAR UM
     public ModelUsuario retornarUsuarioController(int cod){
     return this.daoUsuario.retornarUsuarioDao(cod);
     }
     //RETORNAR UMA LISTA
     public ArrayList<ModelUsuario> listaModelUsuarioController(){
     return this.daoUsuario.retornarListaDeUsuario();
     }

    public boolean getUsuarioController(ModelUsuario mod) {
     return this.daoUsuario.retornarListaDeUsuario(mod);    }
     
     
     
}
