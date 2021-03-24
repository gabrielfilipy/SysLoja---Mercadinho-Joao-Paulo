/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoId;
import Model.ModelId;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerId {
    
    
     private DaoId dao = new DaoId();
     
     
     
     //SALVAR
     public int salvarController(ModelId mod){
     return dao.SalvarDao(mod);
     }
    
     
      public ModelId buscaIdController(int id){
     return dao.retornarDao(id);
     }
    
     
}
