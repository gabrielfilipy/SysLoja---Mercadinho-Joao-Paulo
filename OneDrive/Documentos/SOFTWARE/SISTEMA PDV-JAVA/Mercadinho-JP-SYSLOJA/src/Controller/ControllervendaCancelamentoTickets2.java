package Controller;




import Dao.DaoVendaCancelamentoTickets2;
import Model.ModelVendaCancelamentoTickets2;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaCancelamentoTickets2 {
 
    private DaoVendaCancelamentoTickets2 daovenda = new DaoVendaCancelamentoTickets2(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaCancelamentoTickets2 pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaCancelamentoTickets2 getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaCancelamentoTickets2> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean 
    */
    public boolean atualizarvendaController(ModelVendaCancelamentoTickets2 pModelvenda){
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
    
     public boolean salvarVendaProdutoController(ArrayList<ModelVendaCancelamentoTickets2> listaModelVendaProduto) {
    return this.daovenda.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
} 