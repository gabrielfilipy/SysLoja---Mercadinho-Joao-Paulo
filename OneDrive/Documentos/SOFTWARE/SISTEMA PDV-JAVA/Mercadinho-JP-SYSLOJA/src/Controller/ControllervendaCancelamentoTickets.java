package Controller;




import Dao.DaoVendaCancelamentoTickets;
import Model.ModelVendaCancelamentoTickets;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaCancelamentoTickets {
 
    private DaoVendaCancelamentoTickets daovenda = new DaoVendaCancelamentoTickets(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaCancelamentoTickets pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaCancelamentoTickets getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaCancelamentoTickets> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */ 
    public boolean atualizarvendaController(ModelVendaCancelamentoTickets pModelvenda){
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