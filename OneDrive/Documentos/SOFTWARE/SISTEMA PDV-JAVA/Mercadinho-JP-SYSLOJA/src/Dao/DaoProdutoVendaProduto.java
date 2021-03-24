/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ModelProduto;
import Model.ModelProdutoVendaProduto;  
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import java.util.ArrayList;
import Model.ModelVendaProduto;
import Model.ModelVendaProduto2;
import Model.ModelVendaProdutoCartao;
import Model.ModelVendaProdutoTickets; 

/** 
 * 
 * @author Monet    
 */  
public class DaoProdutoVendaProduto extends ConexaoMySql{
    ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProduto = new ArrayList<>();
    ModelProdutoVendaProduto modelProdutoVendaProduto = new ModelProdutoVendaProduto();
    
    
    
    public ArrayList<ModelProdutoVendaProduto> getListProdutoVendaProdutoDao(int pCodVenda){
  
    ModelProduto modelProduto = new ModelProduto();
    ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_produto.pk_id_produto, "
                    + "tbl_produto.estoque, "
                    + "tbl_produto.nome, "
                    + "tbl_produto.preco_venda, "
                    
                    + "tbl_venda_produto.fk_produto, "
                    + "tbl_venda_produto.fk_venda, "
                    + "tbl_venda_produto.pk_id_vendaProduto, "
                    + "tbl_venda_produto.quantidade, "
                    + "tbl_venda_produto.valor_venda "
                    + "FROM tbl_venda_produto "
                    + "INNER JOIN tbl_produto ON tbl_produto.pk_id_produto = tbl_venda_produto.fk_produto "
                    + "WHERE tbl_venda_produto.fk_venda = '"+pCodVenda+"';");
            while(this.getResultSet().next()){
            modelProdutoVendaProduto = new ModelProdutoVendaProduto();
            modelProduto = new ModelProduto();
            modelVendaProduto = new ModelVendaProduto();
            
            
            
            modelProduto.setId(this.getResultSet().getInt(1));
            modelProduto.setEstoque(this.getResultSet().getInt(2));
            modelProduto.setNome(this.getResultSet().getString(3));
            modelProduto.setPreco_venda(this.getResultSet().getDouble(4));
            
            modelVendaProduto.setProduto(this.getResultSet().getInt(5));
            modelVendaProduto.setVenda(this.getResultSet().getInt(6));
            modelVendaProduto.setIdVendaDinheiroPro(this.getResultSet().getInt(7));
            modelVendaProduto.setQuantidade(this.getResultSet().getInt(8));
            modelVendaProduto.setValorVenda(this.getResultSet().getDouble(9));

            modelProdutoVendaProduto.setModelProduto(modelProduto);
            modelProdutoVendaProduto.setModelVendaProduto(modelVendaProduto);
            listaProdutoVendaProduto.add(modelProdutoVendaProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaProdutoVendaProduto;
    }
    
    public ArrayList<ModelProdutoVendaProduto> getListProdutoVendaProdutoDaoNoServidor(int pCodVenda){
    ModelProduto modelProduto = new ModelProduto();
    ModelVendaProduto2 modelVendaProduto = new ModelVendaProduto2();
    try {
    this.conectar();
    this.executarSQL("SELECT "
                    + "tbl_produto.pk_id_produto, "
                    + "tbl_produto.estoque, "
                    + "tbl_produto.nome, "
                    + "tbl_produto.preco_venda, "
                    
                    + "tbl_venda_produto2.fk_produto, "
                    + "tbl_venda_produto2.fk_venda, "
                    + "tbl_venda_produto2.pk_id_vendaProduto, "
                    + "tbl_venda_produto2.quantidade, "
                    + "tbl_venda_produto2.valor_venda "
                    + "FROM tbl_venda_produto2 "
                    + "INNER JOIN tbl_produto ON tbl_produto.pk_id_produto = tbl_venda_produto2.fk_produto "
                    + "WHERE tbl_venda_produto2.fk_venda = '"+pCodVenda+"';");
    while(this.getResultSet().next()){
    modelProdutoVendaProduto = new ModelProdutoVendaProduto();
    modelProduto = new ModelProduto();
    modelVendaProduto = new ModelVendaProduto2();
      
    modelProduto.setId(this.getResultSet().getInt(1));
    modelProduto.setEstoque(this.getResultSet().getInt(2));
    modelProduto.setNome(this.getResultSet().getString(3));
    modelProduto.setPreco_venda(this.getResultSet().getDouble(4));
            
    modelVendaProduto.setProduto(this.getResultSet().getInt(5));
    modelVendaProduto.setVenda(this.getResultSet().getInt(6));
    modelVendaProduto.setIdVendaDinheiroPro(this.getResultSet().getInt(7));
    modelVendaProduto.setQuantidade(this.getResultSet().getInt(8));
    modelVendaProduto.setValorVenda(this.getResultSet().getDouble(9));

    modelProdutoVendaProduto.setModelProduto(modelProduto);
    modelProdutoVendaProduto.setModelVendaProduto2(modelVendaProduto);
    listaProdutoVendaProduto.add(modelProdutoVendaProduto);
    }
    } catch (Exception e) {
    e.printStackTrace();
    }finally{
    this.fecharConexao();
    }
    return listaProdutoVendaProduto;
    }
    
    
     public ArrayList<ModelProdutoVendaProduto> getListProdutoVendaProdutoCartaoDao(int pCodVenda){
    
    ModelProduto modelProduto = new ModelProduto();
         ModelVendaProdutoCartao modelVendaProduto = new ModelVendaProdutoCartao();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_produto.pk_id_produto, "
                    + "tbl_produto.estoque, "
                    + "tbl_produto.nome, "
                    + "tbl_produto.preco_venda, "
                    
                    + "tbl_venda_cartao_produto.fk_produto, "
                    + "tbl_venda_cartao_produto.fk_venda, "
                    + "tbl_venda_cartao_produto.pk_id_vendaProduto, "
                    + "tbl_venda_cartao_produto.quantidade, "
                    + "tbl_venda_cartao_produto.valor_venda "
                    + "FROM tbl_venda_cartao_produto "
                    + "INNER JOIN tbl_produto ON tbl_produto.pk_id_produto = tbl_venda_cartao_produto.fk_produto "
                    + "WHERE tbl_venda_cartao_produto.fk_venda = '"+pCodVenda+"';");
            while(this.getResultSet().next()){
            modelProdutoVendaProduto = new ModelProdutoVendaProduto();
            modelProduto = new ModelProduto();
            modelVendaProduto = new ModelVendaProdutoCartao();
            
            
            
            modelProduto.setId(this.getResultSet().getInt(1));
            modelProduto.setEstoque(this.getResultSet().getInt(2));
            modelProduto.setNome(this.getResultSet().getString(3));
            modelProduto.setPreco_venda(this.getResultSet().getDouble(4));
            
            modelVendaProduto.setProduto(this.getResultSet().getInt(5));
            modelVendaProduto.setVenda(this.getResultSet().getInt(6));
            modelVendaProduto.setIdVendaDinheiroPro(this.getResultSet().getInt(7));
            modelVendaProduto.setQuantidade(this.getResultSet().getInt(8));
            modelVendaProduto.setValorVenda(this.getResultSet().getDouble(9));

            modelProdutoVendaProduto.setModelProduto(modelProduto);
            modelProdutoVendaProduto.setModelVendaProdutoCartao(modelVendaProduto);
            listaProdutoVendaProduto.add(modelProdutoVendaProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaProdutoVendaProduto;
    }
     
     
     
     public ArrayList<ModelProdutoVendaProduto> getListProdutoVendaProdutotICKETSDao(int pCodVenda){
    
    ModelProduto modelProduto = new ModelProduto();
         ModelVendaProdutoTickets modelVendaProduto = new ModelVendaProdutoTickets();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_produto.pk_id_produto, "
                    + "tbl_produto.estoque, "
                    + "tbl_produto.nome, "
                    + "tbl_produto.preco_venda, "
                    
                    + "tbl_venda_tickets_produto.fk_produto, "
                    + "tbl_venda_tickets_produto.fk_venda, "
                    + "tbl_venda_tickets_produto.pk_id_vendaProduto, "
                    + "tbl_venda_tickets_produto.quantidade, "
                    + "tbl_venda_tickets_produto.valor_venda "
                    + "FROM tbl_venda_tickets_produto "
                    + "INNER JOIN tbl_produto ON tbl_produto.pk_id_produto = tbl_venda_tickets_produto.fk_produto "
                    + "WHERE tbl_venda_tickets_produto.fk_venda = '"+pCodVenda+"';");
            while(this.getResultSet().next()){
            modelProdutoVendaProduto = new ModelProdutoVendaProduto();
            modelProduto = new ModelProduto();
                modelVendaProduto = new ModelVendaProdutoTickets();
            
            
            
            modelProduto.setId(this.getResultSet().getInt(1));
            modelProduto.setEstoque(this.getResultSet().getInt(2));
            modelProduto.setNome(this.getResultSet().getString(3));
            modelProduto.setPreco_venda(this.getResultSet().getDouble(4));
            
            modelVendaProduto.setProduto(this.getResultSet().getInt(5));
            modelVendaProduto.setVenda(this.getResultSet().getInt(6));
            modelVendaProduto.setIdVendaDinheiroPro(this.getResultSet().getInt(7));
            modelVendaProduto.setQuantidade(this.getResultSet().getInt(8));
            modelVendaProduto.setValorVenda(this.getResultSet().getDouble(9));

            modelProdutoVendaProduto.setModelProduto(modelProduto);
            modelProdutoVendaProduto.setModelVendaProdutoTickets(modelVendaProduto);
            listaProdutoVendaProduto.add(modelProdutoVendaProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaProdutoVendaProduto;
    }
     
     
     
}
 