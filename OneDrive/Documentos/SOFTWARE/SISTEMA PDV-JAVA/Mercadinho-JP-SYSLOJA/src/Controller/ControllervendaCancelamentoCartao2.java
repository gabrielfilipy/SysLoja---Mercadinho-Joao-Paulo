package Controller;




import Dao.DaoVendaCancelamentoCartao2;
import Model.ModelVendaCancelamentoCartao2;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaCancelamentoCartao2 {
 
    private DaoVendaCancelamentoCartao2 daovenda = new DaoVendaCancelamentoCartao2(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaCancelamentoCartao2 pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaCancelamentoCartao2 getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaCancelamentoCartao2> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean 
    */
    public boolean atualizarvendaController(ModelVendaCancelamentoCartao2 pModelvenda){
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
    
     public boolean salvarVendaProdutoController(ArrayList<ModelVendaCancelamentoCartao2> listaModelVendaProduto) {
    return this.daovenda.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}