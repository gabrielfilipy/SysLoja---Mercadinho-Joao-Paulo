package Dao;

import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelVendaProdutoTickets2;

import java.util.ArrayList;

/**
* 
* @author monet
*/
public class DaoVendaProdutoTickets2 extends ConexaoMySql2 {

    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int 
    */
    public int salvarVendaProdutoDAO(ModelVendaProdutoTickets2 pModelvendaDinheiroPro){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_tickets_produto2 ("
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                         + "nome_produto"
                + ") VALUES ("
                    + "'" + pModelvendaDinheiroPro.getProduto() + "',"
                    + "'" + pModelvendaDinheiroPro.getVenda() + "',"
                    + "'" + pModelvendaDinheiroPro.getUsuario() + "',"
                    + "'" + pModelvendaDinheiroPro.getValorVenda() + "',"
                    + "'" + pModelvendaDinheiroPro.getQuantidade() + "',"
                   + "'" + pModelvendaDinheiroPro.getNome_produto() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProdutoTickets2 getVendaProdutoDAO(int pIdVendaDinheiroPro){
        ModelVendaProdutoTickets2 modelvendaDinheiroPro = new ModelVendaProdutoTickets2();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_vendaProduto,"
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                         + "nome_produto"
                 + " FROM"
                     + " tbl_venda_tickets_produto2"
                 + " WHERE"
                     + " pk_id_vendaProduto = '" + pIdVendaDinheiroPro + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvendaDinheiroPro.setIdVendaDinheiroPro(this.getResultSet().getInt(1));
                modelvendaDinheiroPro.setProduto(this.getResultSet().getInt(2));
                modelvendaDinheiroPro.setVenda(this.getResultSet().getInt(3));
                modelvendaDinheiroPro.setUsuario(this.getResultSet().getInt(4));
                modelvendaDinheiroPro.setValorVenda(this.getResultSet().getDouble(5));
                modelvendaDinheiroPro.setQuantidade(this.getResultSet().getInt(6));
                modelvendaDinheiroPro.setNome_produto(this.getResultSet().getString(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelvendaDinheiroPro;
    }

    /**
    * recupera uma lista de vendaDinheiroPro
        * return ArrayList
    */
    public ArrayList<ModelVendaProdutoTickets2> getListaVendaProdutoDAO(){
        ArrayList<ModelVendaProdutoTickets2> listamodelvendaDinheiroPro = new ArrayList();
        ModelVendaProdutoTickets2 modelvendaDinheiroPro = new ModelVendaProdutoTickets2();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                  
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                        + "nome_produto"
                 + " FROM"
                     + " tbl_venda_tickets_produto2"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvendaDinheiroPro = new ModelVendaProdutoTickets2();
               
                modelvendaDinheiroPro.setProduto(this.getResultSet().getInt(2));
                modelvendaDinheiroPro.setVenda(this.getResultSet().getInt(3));
                modelvendaDinheiroPro.setUsuario(this.getResultSet().getInt(4));
                modelvendaDinheiroPro.setValorVenda(this.getResultSet().getDouble(5));
                modelvendaDinheiroPro.setQuantidade(this.getResultSet().getInt(6));
                 modelvendaDinheiroPro.setNome_produto(this.getResultSet().getString(7));
                listamodelvendaDinheiroPro.add(modelvendaDinheiroPro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelvendaDinheiroPro;
    }

    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean 
    */
    public boolean atualizarVendaProdutoDAO(ModelVendaProdutoTickets2 pModelvendaDinheiroPro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_venda_tickets_produto2 SET "
                    + "pk_id_vendaProduto = '" + pModelvendaDinheiroPro.getIdVendaDinheiroPro() + "',"
                    + "fk_produto = '" + pModelvendaDinheiroPro.getProduto() + "',"
                    + "fk_venda = '" + pModelvendaDinheiroPro.getVenda() + "',"
                    + "fk_usuario = '" + pModelvendaDinheiroPro.getUsuario() + "',"
                    + "valor_venda = '" + pModelvendaDinheiroPro.getValorVenda() + "',"
                    + "quantidade = '" + pModelvendaDinheiroPro.getQuantidade() + "',"
                             + "nome_produto = '" + pModelvendaDinheiroPro.getNome_produto() + "'"
                + " WHERE "
                    + "pk_id_vendaProduto = '" + pModelvendaDinheiroPro.getIdVendaDinheiroPro() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return boolean
    */
    public boolean excluirVendaProdutoDAO(int pIdVendaDinheiroPro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda_tickets_produto2 "
                + " WHERE "
                    + "pk_id_vendaProduto = '" + pIdVendaDinheiroPro + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

     public boolean excluirVendaProdutoDAOCodVenda(int pIdVendaDinheiroPro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda_tickets_produto2 "
                + " WHERE "
                    + "fk_venda = '" + pIdVendaDinheiroPro + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao(); 
        }
    }
     
     
     
     
     
    public boolean salvarListaVendaProdutoDAO(ArrayList<ModelVendaProdutoTickets2> pListaModelVendaProduto) {
    try {
            this.conectar();
            int contando = pListaModelVendaProduto.size();
            for (int i = 0; i < contando; i++) {
            this.insertSQL(
                "INSERT INTO tbl_venda_tickets_produto2 ("
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario," 
                    + "valor_venda,"  
                    + "quantidade," 
                    + "nome_produto,"
                    + "ano,"
                    + "mes" 
                + ") VALUES ("
                    + "'" + pListaModelVendaProduto.get(i).getProduto()+ "',"
                    + "'" + pListaModelVendaProduto.get(i).getVenda() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getUsuario() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorVenda() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getQuantidade() + "',"
                   + "'" + pListaModelVendaProduto.get(i).getNome_produto() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getAno() + "',"
                   + "'" + pListaModelVendaProduto.get(i).getMes() + "'"
                + ");"
            );
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao(); 
        }    
    
    }
} 
    
    
  