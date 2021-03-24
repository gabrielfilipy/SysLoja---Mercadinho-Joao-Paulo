package Controller;



import Dao.DaoVendaCancelamento2;
import Model.ModelVendaCancelamento2;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaCancelamento2 {
 
    private DaoVendaCancelamento2 daovenda = new DaoVendaCancelamento2(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaCancelamento2 pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaCancelamento2 getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaCancelamento2> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */ 
    public boolean atualizarvendaController(ModelVendaCancelamento2 pModelvenda){
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
    
      public boolean salvarVendaProdutoController(ArrayList<ModelVendaCancelamento2> listaModelVendaProduto) {
    return this.daovenda.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}