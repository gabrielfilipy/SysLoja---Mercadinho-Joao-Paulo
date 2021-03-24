package Controller;



import Dao.DaoVendaProdutoCartao2;
import java.util.ArrayList;
import Model.ModelVendaProdutoCartao2;

/**
* 
* @author monet  
*/
public class ControllerVendaProdutoCartao2 {
 
    private DaoVendaProdutoCartao2 daoVendaProduto = new DaoVendaProdutoCartao2();

    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int
    */
    public int salvarVendaProdutoController(ModelVendaProdutoCartao2 pModelVendaProduto){
        return this.daoVendaProduto.salvarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProdutoCartao2 getVendaProdutoController(int pIdVendaPro){
        return this.daoVendaProduto.getVendaProdutoDAO(pIdVendaPro);
    }

    /**
    * recupera uma lista devendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ArrayList
    */
    public ArrayList<ModelVendaProdutoCartao2> getListaVendaProdutoController(){
        return this.daoVendaProduto.getListaVendaProdutoDAO();
    }

    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean
    */ 
    public boolean atualizarVendaProdutoController(ModelVendaProdutoCartao2 pModelVendaProduto){
        return this.daoVendaProduto.atualizarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * exclui vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return boolean
    */
    public boolean excluirVendaProdutoController(int pIdVendaProduto){
        return this.daoVendaProduto.excluirVendaProdutoDAO(pIdVendaProduto);
    }
public boolean excluirVendaProdutoControllerCodVenda(int pIdVendaProduto){
        return this.daoVendaProduto.excluirVendaProdutoDAOCodVenda(pIdVendaProduto);
    }
    public boolean salvarVendaProdutoController(ArrayList<ModelVendaProdutoCartao2> listaModelVendaProduto) {
    return this.daoVendaProduto.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}