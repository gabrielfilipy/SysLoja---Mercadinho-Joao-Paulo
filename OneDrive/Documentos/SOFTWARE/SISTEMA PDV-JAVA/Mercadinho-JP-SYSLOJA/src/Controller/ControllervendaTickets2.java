package Controller;



import Dao.DaoVendaTickets2;
import Model.ModelVendaTickets2;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaTickets2 {
 
    private DaoVendaTickets2 daovenda = new DaoVendaTickets2(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaTickets2 pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaTickets2 getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaTickets2> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */
    public boolean atualizarvendaController(ModelVendaTickets2 pModelvenda){
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
    
    public boolean salvarVendaProdutoController(ArrayList<ModelVendaTickets2> listaModelVendaProduto) {
    return this.daovenda.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        } 
} 