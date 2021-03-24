/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.ConexaoMySql;
import Dao.DaoParcelamento;
import Model.ModelParcelamento;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *  
 * @author Monet
 */
public class ControllerParcelamento {
     private DaoParcelamento daovenda = new DaoParcelamento(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelParcelamento pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    } 

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelParcelamento getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelParcelamento> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */
    public boolean atualizarvendaController(ModelParcelamento pModelvenda){
        return this.daovenda.atualizarvendaDAO(pModelvenda);
    }

    /**
    * exclui venda
    * @param pIdVenda
    * return boolean
    */
    public boolean excluirvendaController(int pIdVenda){
        return this.daovenda.excluirvendaDAO(pIdVenda);
    }
     public boolean gerarRelatorio(int cod) { 
        return daovenda.gerarRelatorio(cod); 
    }
}
