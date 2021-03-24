/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 
import Dao.DaoCliente;
import Model.ModelCliente;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerCliente {
    
    
     private DaoCliente dao = new DaoCliente();  
     
     
     
     //SALVAR
     public int salvarController(ModelCliente mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelCliente> listaModelUsuarioController(){
     return this.dao.retornarListaDeUsuario();
     }
     
     //RETORNAR UM
     public ModelCliente retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     
     //RETORNAR UM
     public ModelCliente retornarPorNomeController(String nome){
     return this.dao.retornarDao(nome);
     }
     
     //ALTERAR 
     public boolean alterarController(ModelCliente mod){
     return this.dao.alterarDao(mod);
     }
     
}
