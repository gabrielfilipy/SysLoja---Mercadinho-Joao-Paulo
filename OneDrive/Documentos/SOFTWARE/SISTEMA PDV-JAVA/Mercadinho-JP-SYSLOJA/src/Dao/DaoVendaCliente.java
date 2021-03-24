/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ModelCliente;
import Model.ModelVendaCliente;
import Conexao.ConexaoMySql;
import java.util.ArrayList;
import Model.ModelVenda;

/**
 *
 * @author Monet
 */
public class DaoVendaCliente extends ConexaoMySql{
    
    
    
      public ArrayList<ModelVendaCliente> getListavendaClienteDAO(){
        ArrayList<ModelVendaCliente> listamodelvendaCliente = new ArrayList();
        ModelVenda modelvenda = new ModelVenda();
          ModelCliente mod = new ModelCliente();
          ModelVendaCliente modelVendaCliente = new ModelVendaCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "tbl_venda.pk_id_venda, "
                    + "tbl_venda.fk_cliente, "
                    + "tbl_venda.fk_usuario, "
                    + "tbl_venda.data, "
                    + "tbl_venda.hora, "
                    + "tbl_venda.valor_liquido, "
                    + "tbl_venda.valor_bruto, "
                    + "tbl_venda.valor_desconto, " 
                        
                    + "tbl_clinte.pk_id_cliente, "
                    + "tbl_clinte.nome, "
                    + "tbl_clinte.nascimento, "
                    + "tbl_clinte.bairro, " 
                    + "tbl_clinte.rua, "
                    + "tbl_clinte.cidade, "
                    + "tbl_clinte.rg, "
                    + "tbl_clinte.telefone, "
                    + "tbl_clinte.numero_casa "
                 + " FROM"
                     + " tbl_venda INNER JOIN tbl_clinte "
                        + "ON tbl_clinte.pk_id_cliente = tbl_venda.fk_cliente; "
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda = new ModelVenda();
                mod = new ModelCliente();
                modelVendaCliente = new ModelVendaCliente();
              
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                
                //CLIENTE
                
                 mod.setId(this.getResultSet().getInt(9));
                 mod.setNome(this.getResultSet().getString(10));
                 mod.setNascimento(this.getResultSet().getString(11));
                 mod.setBairro(this.getResultSet().getString(12));   
                 mod.setRua(this.getResultSet().getString(13));
                 mod.setCidade(this.getResultSet().getString(14));
                 mod.setRg(this.getResultSet().getString(15));
                 mod.setTelefone(this.getResultSet().getString(16));
                 mod.setNumero_casa(this.getResultSet().getString(17));
                 
                   //CLIENTE
                modelVendaCliente.setModelVenda(modelvenda);
                modelVendaCliente.setModelCliente(mod); 
                listamodelvendaCliente.add(modelVendaCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelvendaCliente;
    }
}
