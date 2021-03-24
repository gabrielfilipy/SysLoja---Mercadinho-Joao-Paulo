/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
 

import Dao.DaoProduto;
import Model.ModelProduto;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerProduto {
    
    
     private DaoProduto dao = new DaoProduto();
     
     
     
     //SALVAR
     public int salvarController(ModelProduto mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelProduto> listaModelUsuarioController(){
     return this.dao.retornarListaDeUsuario();
     }
     
     //RETORNAR UM
     public ModelProduto retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //RETORNAR PELO CODIGO DE BARRAS
     public ModelProduto retornarCodigoBarrasController(String cod){
     return this.dao.retornarDaoPeloCodigoBarras(cod);
     }
     //RETORNAR NOME
     public ModelProduto retornarPeloNomeController(String nome){
     return this.dao.retornarPeloNomeDao(nome);
     }
     
     //ALTERAR 
     public boolean alterarController(ModelProduto mod){
     return this.dao.alterarDao(mod);
     }

    public boolean alterarEstoqueController(ArrayList<ModelProduto> listaModelProduto) {
    return this.dao.alterarEstoque(listaModelProduto);
    }
     public boolean gerarRelatorio() {
        return dao.gerarRelatorio();
    }
     public boolean gerarRelatorioMes(String data) {
        return dao.gerarRelatorioMes(data);
    }
     public boolean gerarRelatorioANO(String data) {
        return dao.gerarRelatorioANO(data);
    }
     public boolean gerarRelatorioMesCARTAO(String data) {
        return dao.gerarRelatorioMesCARTAO(data);
    }
     public boolean gerarRelatorioAnoCARTAO(String data) {
        return dao.gerarRelatorioAnoCARTAO(data);
    }
     public boolean gerarRelatorioCompletoCARTAO() {
        return dao.gerarRelatorioComPletoCARTAO();
    }
     public boolean gerarRelatorioMesTICKETS(String data) {
        return dao.gerarRelatorioMesTICKETS(data);
    }
     public boolean gerarRelatorioAnoTICKETS(String data) {
        return dao.gerarRelatorioAnoTICKETS(data);
    }
     
     public boolean gerarRelatorioCompletoTICKETS() {
        return dao.gerarRelatorioCompletoTICKETS();
    }
}
