package Controller;


import Dao.DaoVendaProdutoTickets;
import java.util.ArrayList;
import Model.ModelVendaProdutoTickets;

/**
* 
* @author monet  
*/
public class ControllerVendaProdutoTickets {
 
    private DaoVendaProdutoTickets daoVendaProduto = new DaoVendaProdutoTickets();

    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int
    */
    public int salvarVendaProdutoController(ModelVendaProdutoTickets pModelVendaProduto){
        return this.daoVendaProduto.salvarVendaProdutoDAO(pModelVendaProduto);
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProdutoTickets getVendaProdutoController(int pIdVendaPro){
        return this.daoVendaProduto.getVendaProdutoDAO(pIdVendaPro);
    }

    /**
    * recupera uma lista devendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ArrayList
    */
    public ArrayList<ModelVendaProdutoTickets> getListaVendaProdutoController(){
        return this.daoVendaProduto.getListaVendaProdutoDAO();
    }
    
     public ArrayList<ModelVendaProdutoTickets> getListaVendaProdutoControllerpeloCodigo(int id){
        return this.daoVendaProduto.getListaVendaProdutoDAOpeloCodigo(id);
    }

    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean
    */ 
    public boolean atualizarVendaProdutoController(ModelVendaProdutoTickets pModelVendaProduto){
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
    public boolean salvarVendaProdutoController(ArrayList<ModelVendaProdutoTickets> listaModelVendaProduto) {
    return this.daoVendaProduto.salvarListaVendaProdutoDAO(listaModelVendaProduto);
        }
}