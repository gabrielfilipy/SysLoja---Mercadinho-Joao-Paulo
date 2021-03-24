package Controller;



import Dao.DaoVendaCancelamentoCartao;
import Model.ModelVendaCancelamentoCartao;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class ControllervendaCancelamentoCartao {
 
    private DaoVendaCancelamentoCartao daovenda = new DaoVendaCancelamentoCartao(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVendaCancelamentoCartao pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaCancelamentoCartao getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVendaCancelamentoCartao> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */ 
    public boolean atualizarvendaController(ModelVendaCancelamentoCartao pModelvenda){
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