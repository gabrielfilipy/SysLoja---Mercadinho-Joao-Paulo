package Controller;


import Dao.DaoVendaProduto2;
import Model.ModelVendaProduto2;
import java.util.ArrayList;


/**
* 
* @author monet  
*/
public class ControllerVendaProduto2 {
 
    private DaoVendaProduto2 daoVendaProduto = new DaoVendaProduto2();

    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int
    */
    public int salvarVendaProdutoController(ModelVendaProduto2 pModelVendaProduto){
        return this.daoVendaProduto.salvarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProduto2 getVendaProdutoController(int pIdVendaPro){
        return this.daoVendaProduto.getVendaProdutoDAO(pIdVendaPro);
    }

    /**
    * recupera uma lista devendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ArrayList
    */
    public ArrayList<ModelVendaProduto2> getListaVendaProdutoController(){
        return this.daoVendaProduto.getListaVendaProdutoDAO();
    }

    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean
    */ 
    public boolean atualizarVendaProdutoController(ModelVendaProduto2 pModelVendaProduto){
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
    public boolean salvarVendaProdutoController(ArrayList<ModelVendaProduto2> listaModelVendaProduto) {
    return this.daoVendaProduto.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}