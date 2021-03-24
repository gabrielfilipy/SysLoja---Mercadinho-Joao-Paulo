package Controller;


import Dao.DaoVendaAbandono;
import Model.ModelVendaAbandono;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaAbandono {
 
    private DaoVendaAbandono daovenda = new DaoVendaAbandono(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaAbandono pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaAbandono getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaAbandono> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean 
    */
    public boolean atualizarvendaController(ModelVendaAbandono pModelvenda){
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
}