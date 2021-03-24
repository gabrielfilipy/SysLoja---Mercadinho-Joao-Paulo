/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 


import Dao.DaoAbrirTurno2;
import Dao.DaoUsuario;
import Model.ModelAbrirTurno2;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerAbrirTuur2 {
    
    
     private DaoAbrirTurno2 daoAbrirTurno = new DaoAbrirTurno2();
     
     
     
      //ALTERAR 
     public boolean alterarController(ModelAbrirTurno2 mod){
     return this.daoAbrirTurno.alterarDao(mod);
     }
     
     //SALVAR
     public int salvarAbrirTurnoController(ModelAbrirTurno2 modelAbrirTurno){
     return daoAbrirTurno.SalvarAbrirTurnoDao(modelAbrirTurno);
     }
     
     //RETORNAR UM 
     public ModelAbrirTurno2 retornarTurnoController(int cod){
     return this.daoAbrirTurno.retornarAbrirTurnoDao(cod);
     }
  
      //RETORNAR UMA LISTA
     public ArrayList<ModelAbrirTurno2> listaModelUsuarioController(){
     return this.daoAbrirTurno.retornarListaDeUsuario();
     }
     
    public boolean gerarRelatorio(String data) {
        return daoAbrirTurno.gerarRelatorio(data);
    }
     public boolean gerarRelatorioANUAL(String data) {
        return daoAbrirTurno.gerarRelatorioaNUAL(data); 
    }
}
