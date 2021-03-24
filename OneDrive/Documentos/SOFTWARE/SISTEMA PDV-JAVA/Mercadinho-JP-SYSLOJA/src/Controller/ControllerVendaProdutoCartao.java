package Controller;


import Dao.DaoVendaProdutoCartao;
import java.util.ArrayList;
import Model.ModelVendaProdutoCartao;

/**
* 
* @author monet  
*/
public class ControllerVendaProdutoCartao {
 
    private DaoVendaProdutoCartao daoVendaProduto = new DaoVendaProdutoCartao();

    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int
    */
    public int salvarVendaProdutoController(ModelVendaProdutoCartao pModelVendaProduto){
        return this.daoVendaProduto.salvarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProdutoCartao getVendaProdutoController(int pIdVendaPro){
        return this.daoVendaProduto.getVendaProdutoDAO(pIdVendaPro);
    }

    /**
    * recupera uma lista devendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ArrayList
    */
    public ArrayList<ModelVendaProdutoCartao> getListaVendaProdutoController(){
        return this.daoVendaProduto.getListaVendaProdutoDAO();
    }
    
    public ArrayList<ModelVendaProdutoCartao> getListaVendaProdutoControllerpeloCodigo(int id){
        return this.daoVendaProduto.getListaVendaProdutoDAOpeloCodigo(id);
    }

    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean
    */ 
    public boolean atualizarVendaProdutoController(ModelVendaProdutoCartao pModelVendaProduto){
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
    public boolean salvarVendaProdutoController(ArrayList<ModelVendaProdutoCartao> listaModelVendaProduto) {
    return this.daoVendaProduto.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}