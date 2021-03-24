package Controller;



import Dao.DaoVendaAbandono2;
import Model.ModelVendaAbandono2;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaAbandono2 {
 
    private DaoVendaAbandono2 daovenda = new DaoVendaAbandono2(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaAbandono2 pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaAbandono2 getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaAbandono2> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean 
    */
    public boolean atualizarvendaController(ModelVendaAbandono2 pModelvenda){
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
    
     public boolean salvarVendaProdutoController(ArrayList<ModelVendaAbandono2> listaModelVendaProduto) {
    return this.daovenda.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}