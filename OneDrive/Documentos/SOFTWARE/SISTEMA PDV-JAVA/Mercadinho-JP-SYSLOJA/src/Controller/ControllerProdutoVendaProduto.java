/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoProdutoVendaProduto;
import Model.ModelProdutoVendaProduto;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerProdutoVendaProduto {
     private DaoProdutoVendaProduto dao = new DaoProdutoVendaProduto();
     public ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProduto (int pCod){
         return dao.getListProdutoVendaProdutoDao(pCod);
     }
     
     //cancelar venda do servidor
     public ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProdutoNoServidor (int pCod){
         return dao.getListProdutoVendaProdutoDaoNoServidor(pCod);
     }
     
     
     public ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProdutoCartao (int pCod){
         return dao.getListProdutoVendaProdutoCartaoDao(pCod);
     }
     
     public ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProdutoTickts (int pCod){
         return dao.getListProdutoVendaProdutotICKETSDao(pCod);
     }
}
