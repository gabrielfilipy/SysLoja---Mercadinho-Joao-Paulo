package Controller;


import Dao.DaoVendaProdutoAbandono;
import Model.ModelVendaProdutoAbandono;
import java.util.ArrayList;

/**
*  
* @author monet  
*/
public class ControllerVendaProdutoAbandono {
 
    private DaoVendaProdutoAbandono daoVendaProduto = new DaoVendaProdutoAbandono();

    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int
    */
    public int salvarVendaProdutoController(ModelVendaProdutoAbandono pModelVendaProduto){
        return this.daoVendaProduto.salvarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProdutoAbandono getVendaProdutoController(int pIdVendaPro){
        return this.daoVendaProduto.getVendaProdutoDAO(pIdVendaPro);
    }

    /**
    * recupera uma lista devendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ArrayList
    */
    public ArrayList<ModelVendaProdutoAbandono> getListaVendaProdutoController(){
        return this.daoVendaProduto.getListaVendaProdutoDAO();
    }

    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean
    */ 
    public boolean atualizarVendaProdutoController(ModelVendaProdutoAbandono pModelVendaProduto){
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
    public boolean salvarVendaProdutoController(ArrayList<ModelVendaProdutoAbandono> listaModelVendaProduto) {
    return this.daoVendaProduto.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}