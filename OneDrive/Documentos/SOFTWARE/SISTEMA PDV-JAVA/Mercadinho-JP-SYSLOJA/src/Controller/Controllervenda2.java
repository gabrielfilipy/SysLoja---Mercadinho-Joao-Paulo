package Controller;


import Dao.DaoVenda2;
import Model.ModelVenda2;
import java.util.ArrayList;

/**
*
* @author monet
*/
public class Controllervenda2 {
 
    private DaoVenda2 daovenda = new DaoVenda2(); 
    
    /**
    * grava venda
    * @param pModelvenda
    * return int 
    */
    public int salvarvendaController(ModelVenda2 pModelvenda){
        return this.daovenda.salvarvendaDAO(pModelvenda);
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVenda2 getvendaController(int pIdVenda){
        return this.daovenda.getvendaDAO(pIdVenda);
    }

    /**
    * recupera uma lista devenda
    * @param pIdVenda
    * return ArrayList
    */
    public ArrayList<ModelVenda2> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */
    public boolean atualizarvendaController(ModelVenda2 pModelvenda){
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
    
    public boolean salvarVendaProdutoController(ArrayList<ModelVenda2> listaModelVendaProduto) {
    return this.daovenda.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
    public boolean gerarRelatorio(String data) {
        return daovenda.gerarRelatorio(data);
    }
}