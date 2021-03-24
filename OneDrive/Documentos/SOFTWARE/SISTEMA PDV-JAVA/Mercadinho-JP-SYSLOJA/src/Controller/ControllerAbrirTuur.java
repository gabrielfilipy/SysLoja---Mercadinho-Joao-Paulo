/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 

import Dao.DaoAbrirTurno;
import Dao.DaoUsuario;
import Model.ModelAbrirTurno;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerAbrirTuur {
    
    
     private DaoAbrirTurno daoAbrirTurno = new DaoAbrirTurno();
     
     
     
      //ALTERAR 
     public boolean alterarController(ModelAbrirTurno mod){
     return this.daoAbrirTurno.alterarDao(mod);
     }
     
     //SALVAR
     public int salvarAbrirTurnoController(ModelAbrirTurno modelAbrirTurno){
     return daoAbrirTurno.SalvarAbrirTurnoDao(modelAbrirTurno);
     }
     
     //RETORNAR UM
     public ModelAbrirTurno retornarTurnoController(int cod){
     return this.daoAbrirTurno.retornarAbrirTurnoDao(cod);
     }
  
      //RETORNAR UMA LISTA
     public ArrayList<ModelAbrirTurno> listaModelUsuarioController(){
     return this.daoAbrirTurno.retornarListaDeUsuario();
     }
     
    
     
}
