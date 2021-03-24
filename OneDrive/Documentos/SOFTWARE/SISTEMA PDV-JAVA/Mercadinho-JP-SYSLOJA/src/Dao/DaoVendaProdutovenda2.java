/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import Model.ModelUsuario;
import Conexao.ConexaoMySql;
import Model.ModelAbrirTurno2;
import Model.ModelCliente;
import Model.ModelParcelamento;
import Model.ModelVenda2;
import Model.ModelVendaAbandono2;
import Model.ModelVendaCancelamento2;
import Model.ModelVendaCancelamentoCartao2;
import Model.ModelVendaCancelamentoTickets2;
import Model.ModelVendaCartao2;
import java.util.ArrayList;
import Model.ModelVendaProduto;
import Model.ModelVendaProduto2;
import Model.ModelVendaProdutoAbandono2;
import Model.ModelVendaProdutoCartao2;
import Model.ModelVendaProdutoTickets2;
import Model.ModelVendaProdutoVenda2;
import Model.ModelVendaTickets2;

/** 
 *
 * @author Monet
 */
public class DaoVendaProdutovenda2 extends ConexaoMySql{
    
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioEstoqueBaixaEstoqueDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVenda2 modelVenda2 = new ModelVenda2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda2.fk_venda, "
                    + "tbl_venda2.fk_cliente, "
                    + "tbl_venda2.fk_usuario, " 
                    + "tbl_venda2.data, "     
                    + "tbl_venda2.hora, " 
                    + "tbl_venda2.valor_liquido, "
                    + "tbl_venda2.valor_bruto, "
                    + "tbl_venda2.valor_desconto, "
                    + "tbl_venda2.tipo_pagamento "
                    
                    + "FROM tbl_venda2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVenda2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setIdVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            modelVenda2.setPagamento(this.getResultSet().getString(13)); 
            
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVenda2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
    
    
    public ArrayList<ModelVendaProdutoVenda2> getListaClienteVendasDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelCliente modelUsuario = new ModelCliente();
        ModelVenda2 modelVenda2 = new ModelVenda2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_clinte.pk_id_cliente, "
                    + "tbl_clinte.nome, "
                    + "tbl_clinte.nascimento, "
                    + "tbl_clinte.rg, "
                      
                    + "tbl_venda2.fk_venda, "
                    + "tbl_venda2.fk_cliente, "
                    + "tbl_venda2.fk_usuario, " 
                    + "tbl_venda2.data, "     
                    + "tbl_venda2.hora, " 
                    + "tbl_venda2.valor_liquido, "
                    + "tbl_venda2.valor_bruto, "
                    + "tbl_venda2.valor_desconto, "
                    + "tbl_venda2.tipo_pagamento "
                    
                    + "FROM tbl_venda2 "
                    + "INNER JOIN tbl_clinte ON tbl_clinte.pk_id_cliente = tbl_venda2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelCliente();
            modelVenda2 = new ModelVenda2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setNascimento(this.getResultSet().getString(3));
            modelUsuario.setRg(this.getResultSet().getString(4));
            
           
            modelVenda2.setIdVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            modelVenda2.setPagamento(this.getResultSet().getString(13)); 
            
            modelVendaProdutoVenda2.setModelCliente(modelUsuario);
            modelVendaProdutoVenda2.setModelVenda2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
    
    
    
    public ArrayList<ModelVendaProdutoVenda2> getListClientesVendas(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelCliente modelUsuario = new ModelCliente();
        ModelVenda2 modelVenda2 = new ModelVenda2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_clinte.pk_id_cliente, "
                    + "tbl_clinte.nome, "
                   
                      
                    + "tbl_venda2.fk_venda, "
                    + "tbl_venda2.fk_cliente, "
                    + "tbl_venda2.fk_usuario, " 
                    + "tbl_venda2.data, "     
                    + "tbl_venda2.hora, " 
                    + "tbl_venda2.valor_liquido, "
                    + "tbl_venda2.valor_bruto, "
                    + "tbl_venda2.valor_desconto, "
                    + "tbl_venda2.tipo_pagamento "
                    
                    + "FROM tbl_venda2 "
                    + "INNER JOIN tbl_clinte ON tbl_clinte.pk_id_cliente = tbl_venda2.fk_cliente "
                    + "WHERE tbl_clinte.pk_id_cliente = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelCliente(); 
            modelVenda2 = new ModelVenda2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
             
            
            
            modelVenda2.setIdVenda(this.getResultSet().getInt(3));
            modelVenda2.setCliente(this.getResultSet().getInt(4));
            modelVenda2.setUsuario(this.getResultSet().getInt(5));
            modelVenda2.setData(this.getResultSet().getString(6));
            modelVenda2.setHora(this.getResultSet().getString(7));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(8));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(9));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(10)); 
            modelVenda2.setPagamento(this.getResultSet().getString(11)); 
            
            modelVendaProdutoVenda2.setModelCliente(modelUsuario);
            modelVendaProdutoVenda2.setModelVenda2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    //venda por usuario no cartao
    
    public ArrayList<ModelVendaProdutoVenda2> getListaProdutosCartaoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaProdutoCartao2 modelVendaProduto2 = new ModelVendaProdutoCartao2();
        ModelVendaCartao2 modelVenda2 = new ModelVendaCartao2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_cartao_produto2.fk_venda, "
                    + "tbl_venda_cartao_produto2.fk_produto, "
                   
                    + "tbl_venda_cartao_produto2.fk_usuario, "
                    + "tbl_venda_cartao_produto2.valor_venda, "
                    + "tbl_venda_cartao_produto2.quantidade, " 
                    + "tbl_venda_cartao_produto2.nome_produto, "
                     
                    + "tbl_venda_cartao2.fk_venda, " 
                    + "tbl_venda_cartao2.fk_cliente, "
                    + "tbl_venda_cartao2.fk_usuario, " 
                    + "tbl_venda_cartao2.data, "    
                    + "tbl_venda_cartao2.hora, " 
                    + "tbl_venda_cartao2.valor_liquido, "
                    + "tbl_venda_cartao2.valor_bruto, "
                    + "tbl_venda_cartao2.valor_desconto "
                    
                    
                    + "FROM tbl_venda_cartao2 "
                    + "INNER JOIN tbl_venda_cartao_produto2 ON tbl_venda_cartao_produto2.fk_venda = tbl_venda_cartao2.fk_venda "
                    + "WHERE tbl_venda_cartao_produto2.fk_venda = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelVendaProdutoCartao2();
            modelVenda2 = new ModelVendaCartao2();
            
            modelVendaProduto2.setVenda(this.getResultSet().getInt(1));
            modelVendaProduto2.setProduto(this.getResultSet().getInt(2));
            
            modelVendaProduto2.setUsuario(this.getResultSet().getInt(3));
            modelVendaProduto2.setValorVenda(this.getResultSet().getDouble(4));
            modelVendaProduto2.setQuantidade(this.getResultSet().getInt(5));
            modelVendaProduto2.setNome_produto(this.getResultSet().getString(6));
              
            modelVenda2.setIdVenda(this.getResultSet().getInt(7));
            modelVenda2.setCliente(this.getResultSet().getInt(8));
            modelVenda2.setUsuario(this.getResultSet().getInt(9));
            modelVenda2.setData(this.getResultSet().getString(10));
            modelVenda2.setHora(this.getResultSet().getString(11));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(12));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(13));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(14)); 
          
            
            modelVendaProdutoVenda2.setOdelVendaProdutoCartao2(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelVendaCartao2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
     //venda por usuario no cartao
    
    public ArrayList<ModelVendaProdutoVenda2> getListaProdutosCancelDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaProdutoCartao2 modelVendaProduto2 = new ModelVendaProdutoCartao2();
        ModelVendaCartao2 modelVenda2 = new ModelVendaCartao2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_cartao_produto2.fk_venda, "
                    + "tbl_venda_cartao_produto2.fk_produto, "
                   
                    + "tbl_venda_cartao_produto2.fk_usuario, "
                    + "tbl_venda_cartao_produto2.valor_venda, "
                    + "tbl_venda_cartao_produto2.quantidade, " 
                    + "tbl_venda_cartao_produto2.nome_produto, "
                     
                    + "tbl_venda_cartao2.fk_venda, " 
                    + "tbl_venda_cartao2.fk_cliente, "
                    + "tbl_venda_cartao2.fk_usuario, " 
                    + "tbl_venda_cartao2.data, "    
                    + "tbl_venda_cartao2.hora, " 
                    + "tbl_venda_cartao2.valor_liquido, "
                    + "tbl_venda_cartao2.valor_bruto, "
                    + "tbl_venda_cartao2.valor_desconto "
                    
                    
                    + "FROM tbl_venda_cartao2 "
                    + "INNER JOIN tbl_venda_cartao_produto2 ON tbl_venda_cartao_produto2.fk_venda = tbl_venda_cartao2.fk_venda "
                    + "WHERE tbl_venda_cartao_produto2.fk_venda = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelVendaProdutoCartao2();
            modelVenda2 = new ModelVendaCartao2();
            
            modelVendaProduto2.setVenda(this.getResultSet().getInt(1));
            modelVendaProduto2.setProduto(this.getResultSet().getInt(2));
            
            modelVendaProduto2.setUsuario(this.getResultSet().getInt(3));
            modelVendaProduto2.setValorVenda(this.getResultSet().getDouble(4));
            modelVendaProduto2.setQuantidade(this.getResultSet().getInt(5));
            modelVendaProduto2.setNome_produto(this.getResultSet().getString(6));
              
            modelVenda2.setIdVenda(this.getResultSet().getInt(7));
            modelVenda2.setCliente(this.getResultSet().getInt(8));
            modelVenda2.setUsuario(this.getResultSet().getInt(9));
            modelVenda2.setData(this.getResultSet().getString(10));
            modelVenda2.setHora(this.getResultSet().getString(11));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(12));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(13));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(14)); 
          
            
            modelVendaProdutoVenda2.setOdelVendaProdutoCartao2(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelVendaCartao2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    //venda por usuario no tickets
    
    public ArrayList<ModelVendaProdutoVenda2> getListaProdutosTicketsDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaProdutoTickets2 modelVendaProduto2 = new ModelVendaProdutoTickets2();
        ModelVendaTickets2 modelVenda2 = new ModelVendaTickets2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_tickets_produto2.fk_venda, "
                    + "tbl_venda_tickets_produto2.fk_produto, "
                   
                    + "tbl_venda_tickets_produto2.fk_usuario, "
                    + "tbl_venda_tickets_produto2.valor_venda, "
                    + "tbl_venda_tickets_produto2.quantidade, " 
                    + "tbl_venda_tickets_produto2.nome_produto, "
                     
                    + "tbl_venda_tickets2.fk_venda, "  
                    + "tbl_venda_tickets2.fk_cliente, "    
                    + "tbl_venda_tickets2.fk_usuario, " 
                    + "tbl_venda_tickets2.data, "     
                    + "tbl_venda_tickets2.hora, " 
                    + "tbl_venda_tickets2.valor_liquido, "
                    + "tbl_venda_tickets2.valor_bruto, "
                    + "tbl_venda_tickets2.valor_desconto "
                    
                    
                    + "FROM tbl_venda_tickets2 "
                    + "INNER JOIN tbl_venda_tickets_produto2 ON tbl_venda_tickets_produto2.fk_venda = tbl_venda_tickets2.fk_venda "
                    + "WHERE tbl_venda_tickets_produto2.fk_venda = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelVendaProdutoTickets2();
            modelVenda2 = new ModelVendaTickets2();
            
            modelVendaProduto2.setVenda(this.getResultSet().getInt(1));
            modelVendaProduto2.setProduto(this.getResultSet().getInt(2));
            
            modelVendaProduto2.setUsuario(this.getResultSet().getInt(3));
            modelVendaProduto2.setValorVenda(this.getResultSet().getDouble(4));
            modelVendaProduto2.setQuantidade(this.getResultSet().getInt(5));
            modelVendaProduto2.setNome_produto(this.getResultSet().getString(6));
              
            modelVenda2.setIdVenda(this.getResultSet().getInt(7));
            modelVenda2.setCliente(this.getResultSet().getInt(8));
            modelVenda2.setUsuario(this.getResultSet().getInt(9));
            modelVenda2.setData(this.getResultSet().getString(10));
            modelVenda2.setHora(this.getResultSet().getString(11));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(12));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(13));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(14)); 
          
             
            modelVendaProdutoVenda2.setModelVendaProdutoTickets2(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelVendaTickets2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
    
    
    //salvando venda dos cartoes
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasCartaoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVendaCartao2 modelVenda2 = new ModelVendaCartao2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda_cartao2.fk_venda, "
                    + "tbl_venda_cartao2.fk_cliente, "
                    + "tbl_venda_cartao2.fk_usuario, " 
                    + "tbl_venda_cartao2.data, "     
                    + "tbl_venda_cartao2.hora, " 
                    + "tbl_venda_cartao2.valor_liquido, "
                    + "tbl_venda_cartao2.valor_bruto, "
                    + "tbl_venda_cartao2.valor_desconto "
                   
                    
                    + "FROM tbl_venda_cartao2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda_cartao2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVendaCartao2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setIdVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            
             
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVendaCartao2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasTurnoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVenda2 modelUsuario = new ModelVenda2();
        ModelAbrirTurno2 modelVenda2 = new ModelAbrirTurno2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                     + "tbl_venda2.tipo_pagamento, " 
                     + "tbl_venda2.fk_venda, "   
                    + "tbl_venda2.turno, "
                    + "tbl_venda2.valor_bruto, "
                    + "tbl_venda2.valor_desconto, " 
                    + "tbl_venda2.valor_liquido, "     
                    
           
                    + "tbl_abrir_turno2.fk_turno "
                    
                         
                    + "FROM tbl_venda2 "
                    + "INNER JOIN tbl_abrir_turno2 ON tbl_abrir_turno2.fk_turno = tbl_venda2.turno "
                    + "WHERE  tbl_abrir_turno2.fk_turno = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelVenda2();
            modelVenda2 = new ModelAbrirTurno2();
            
            
          
            modelUsuario.setPagamento(this.getResultSet().getString(1));
            modelUsuario.setIdVenda(this.getResultSet().getInt(2));
            modelUsuario.setTurno(this.getResultSet().getInt(3));
            modelUsuario.setValorBruto(this.getResultSet().getDouble(4));
            modelUsuario.setValorDesconto(this.getResultSet().getDouble(5));
            modelUsuario.setValorLiquido(this.getResultSet().getDouble(6));
            
            modelVenda2.setFkTurno(this.getResultSet().getInt(7));
       
            modelVendaProdutoVenda2.setModelVenda2(modelUsuario);
            modelVendaProdutoVenda2.setModelAbrirTurno2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
     
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasCartaoTurnoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaCartao2 modelUsuario = new ModelVendaCartao2();
        ModelAbrirTurno2 modelVenda2 = new ModelAbrirTurno2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_cartao2.fk_venda, "   
                    + "tbl_venda_cartao2.turno, "
                    + "tbl_venda_cartao2.valor_bruto, "
                    + "tbl_venda_cartao2.valor_desconto, " 
                    + "tbl_venda_cartao2.valor_liquido, "     
                    
            
                    + "tbl_abrir_turno2.fk_turno "
                    
                         
                    + "FROM tbl_venda_cartao2 "
                    + "INNER JOIN tbl_abrir_turno2 ON tbl_abrir_turno2.fk_turno = tbl_venda_cartao2.turno "
                    + "WHERE  tbl_abrir_turno2.fk_turno = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelVendaCartao2();
            modelVenda2 = new ModelAbrirTurno2();
            
            
          
           
            modelUsuario.setIdVenda(this.getResultSet().getInt(1));
            modelUsuario.setTurno(this.getResultSet().getInt(2));
            modelUsuario.setValorBruto(this.getResultSet().getDouble(3));
            modelUsuario.setValorDesconto(this.getResultSet().getDouble(4));
            modelUsuario.setValorLiquido(this.getResultSet().getDouble(5));
            
            modelVenda2.setFkTurno(this.getResultSet().getInt(6));
       
            modelVendaProdutoVenda2.setModelVendaCartao2(modelUsuario);
            modelVendaProdutoVenda2.setModelAbrirTurno2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasTurnoTicketsDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaTickets2 modelUsuario = new ModelVendaTickets2();
        ModelAbrirTurno2 modelVenda2 = new ModelAbrirTurno2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_tickets2.fk_venda, "   
                    + "tbl_venda_tickets2.turno, "
                    + "tbl_venda_tickets2.valor_bruto, "
                    + "tbl_venda_tickets2.valor_desconto, " 
                    + "tbl_venda_tickets2.valor_liquido, "     
                    
           
                    + "tbl_abrir_turno2.fk_turno "
                    
                         
                    + "FROM tbl_venda_tickets2 "
                    + "INNER JOIN tbl_abrir_turno2 ON tbl_abrir_turno2.fk_turno = tbl_venda_tickets2.turno "
                    + "WHERE  tbl_abrir_turno2.fk_turno = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelVendaTickets2();
            modelVenda2 = new ModelAbrirTurno2();
            
            
          
           
            modelUsuario.setIdVenda(this.getResultSet().getInt(1));
            modelUsuario.setTurno(this.getResultSet().getInt(2));
            modelUsuario.setValorBruto(this.getResultSet().getDouble(3));
            modelUsuario.setValorDesconto(this.getResultSet().getDouble(4));
            modelUsuario.setValorLiquido(this.getResultSet().getDouble(5));
            
            modelVenda2.setFkTurno(this.getResultSet().getInt(6));
       
            modelVendaProdutoVenda2.setModelVendaTickets2(modelUsuario);
            modelVendaProdutoVenda2.setModelAbrirTurno2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    //salvando venda dos cartoes
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasAbandonoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVendaAbandono2 modelVenda2 = new ModelVendaAbandono2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda_abandono2.fk_venda, "
                    + "tbl_venda_abandono2.fk_cliente, "
                    + "tbl_venda_abandono2.fk_usuario, " 
                    + "tbl_venda_abandono2.data, "     
                    + "tbl_venda_abandono2.hora, " 
                    + "tbl_venda_abandono2.valor_liquido, "
                    + "tbl_venda_abandono2.valor_bruto, "
                    + "tbl_venda_abandono2.valor_desconto "
                   
                    
                    + "FROM tbl_venda_abandono2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda_abandono2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVendaAbandono2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setFkVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
             
             
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVendaAbandono2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
    
    // venda dos tickets por usuario
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasTicketsDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVendaTickets2 modelVenda2 = new ModelVendaTickets2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda_tickets2.fk_venda, "
                    + "tbl_venda_tickets2.fk_cliente, "
                    + "tbl_venda_tickets2.fk_usuario, " 
                    + "tbl_venda_tickets2.data, "     
                    + "tbl_venda_tickets2.hora, " 
                    + "tbl_venda_tickets2.valor_liquido, "
                    + "tbl_venda_tickets2.valor_bruto, "
                    + "tbl_venda_tickets2.valor_desconto "
                   
                    
                    + "FROM tbl_venda_tickets2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda_tickets2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVendaTickets2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setIdVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            
             
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVendaTickets2(modelVenda2); 
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
    
    
    // venda dos tickets por usuario
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasCancelDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVendaCancelamento2 modelVenda2 = new ModelVendaCancelamento2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda_cancelamento2.fk_venda, "
                    + "tbl_venda_cancelamento2.fk_cliente, "
                    + "tbl_venda_cancelamento2.fk_usuario, " 
                    + "tbl_venda_cancelamento2.data, "     
                    + "tbl_venda_cancelamento2.hora, " 
                    + "tbl_venda_cancelamento2.valor_liquido, "
                    + "tbl_venda_cancelamento2.valor_bruto, "
                    + "tbl_venda_cancelamento2.valor_desconto "
                   
                    
                    + "FROM tbl_venda_cancelamento2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda_cancelamento2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVendaCancelamento2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setFkVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            
             
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVendaCancelamento2(modelVenda2); 
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    // venda canceladas dos cartao por usuario
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasCancelCartaoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVendaCancelamentoCartao2 modelVenda2 = new ModelVendaCancelamentoCartao2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda_cancelamento_cartao2.fk_venda, "
                    + "tbl_venda_cancelamento_cartao2.fk_cliente, "
                    + "tbl_venda_cancelamento_cartao2.fk_usuario, " 
                    + "tbl_venda_cancelamento_cartao2.data, "     
                    + "tbl_venda_cancelamento_cartao2.hora, " 
                    + "tbl_venda_cancelamento_cartao2.valor_liquido, "
                    + "tbl_venda_cancelamento_cartao2.valor_bruto, "
                    + "tbl_venda_cancelamento_cartao2.valor_desconto "
                   
                    
                    + "FROM tbl_venda_cancelamento_cartao2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda_cancelamento_cartao2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVendaCancelamentoCartao2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setFkVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            
              
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVendaCancelamentoCartao2(modelVenda2); 
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    // venda canceladas dos cartao por usuario
    public ArrayList<ModelVendaProdutoVenda2> getListUsuarioVendasCancelTicketsDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelVendaCancelamentoTickets2 modelVenda2 = new ModelVendaCancelamentoTickets2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_usuario.pk_id_usuario, "
                    + "tbl_usuario.nome, "
                    + "tbl_usuario.tipo, "
                    + "tbl_usuario.senha, "
                      
                    + "tbl_venda_cancelamento_tickets2.fk_venda, "
                    + "tbl_venda_cancelamento_tickets2.fk_cliente, "
                    + "tbl_venda_cancelamento_tickets2.fk_usuario, " 
                    + "tbl_venda_cancelamento_tickets2.data, "     
                    + "tbl_venda_cancelamento_tickets2.hora, " 
                    + "tbl_venda_cancelamento_tickets2.valor_liquido, "
                    + "tbl_venda_cancelamento_tickets2.valor_bruto, "
                    + "tbl_venda_cancelamento_tickets2.valor_desconto "
                   
                    
                    + "FROM tbl_venda_cancelamento_tickets2 "
                    + "INNER JOIN tbl_usuario ON tbl_usuario.pk_id_usuario = tbl_venda_cancelamento_tickets2.fk_usuario "
                    + "WHERE tbl_usuario.pk_id_usuario = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelUsuario = new ModelUsuario();
            modelVenda2 = new ModelVendaCancelamentoTickets2();
            modelUsuario.setId(this.getResultSet().getInt(1));
            modelUsuario.setNome(this.getResultSet().getString(2));
            modelUsuario.setTipo(this.getResultSet().getString(3));
            modelUsuario.setSenha(this.getResultSet().getString(4));
            
           
            modelVenda2.setFkVenda(this.getResultSet().getInt(5));
            modelVenda2.setCliente(this.getResultSet().getInt(6));
            modelVenda2.setUsuario(this.getResultSet().getInt(7));
            modelVenda2.setData(this.getResultSet().getString(8));
            modelVenda2.setHora(this.getResultSet().getString(9));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(10));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(11));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(12)); 
            
              
            modelVendaProdutoVenda2.setModelusuario(modelUsuario);
            modelVendaProdutoVenda2.setModelVendaCancelamentoTickets2(modelVenda2); 
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
      public ArrayList<ModelVendaProdutoVenda2> getListaProdutosDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaProduto2 modelVendaProduto2 = new ModelVendaProduto2();
        ModelVenda2 modelVenda2 = new ModelVenda2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_produto2.pk_id_vendaProduto, "
                    + "tbl_venda_produto2.fk_produto, "
                    + "tbl_venda_produto2.fk_venda, "
                    + "tbl_venda_produto2.fk_usuario, "
                    + "tbl_venda_produto2.valor_venda, "
                    + "tbl_venda_produto2.quantidade, " 
                    + "tbl_venda_produto2.nome_produto, "
                     
                    + "tbl_venda2.fk_venda, " 
                    + "tbl_venda2.fk_cliente, "
                    + "tbl_venda2.fk_usuario, " 
                    + "tbl_venda2.data, "    
                    + "tbl_venda2.hora, " 
                    + "tbl_venda2.valor_liquido, "
                    + "tbl_venda2.valor_bruto, "
                    + "tbl_venda2.valor_desconto, "
                    + "tbl_venda2.tipo_pagamento "
                    
                    + "FROM tbl_venda2 "
                    + "INNER JOIN tbl_venda_produto2 ON tbl_venda_produto2.fk_venda = tbl_venda2.fk_venda "
                    + "WHERE tbl_venda_produto2.fk_venda = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelVendaProduto2();
            modelVenda2 = new ModelVenda2();
            modelVendaProduto2.setIdVendaDinheiroPro(this.getResultSet().getInt(1));
            modelVendaProduto2.setProduto(this.getResultSet().getInt(2));
            modelVendaProduto2.setVenda(this.getResultSet().getInt(3));
            modelVendaProduto2.setUsuario(this.getResultSet().getInt(4));
            modelVendaProduto2.setValorVenda(this.getResultSet().getDouble(5));
            modelVendaProduto2.setQuantidade(this.getResultSet().getInt(6));
            modelVendaProduto2.setNom_produto(this.getResultSet().getString(7));
              
            modelVenda2.setIdVenda(this.getResultSet().getInt(8));
            modelVenda2.setCliente(this.getResultSet().getInt(9));
            modelVenda2.setUsuario(this.getResultSet().getInt(10));
            modelVenda2.setData(this.getResultSet().getString(11));
            modelVenda2.setHora(this.getResultSet().getString(12));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(13));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(14));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(15)); 
            modelVenda2.setPagamento(this.getResultSet().getString(16)); 
            
            modelVendaProdutoVenda2.setModelVendaProduto2(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelVenda2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
      
      public ArrayList<ModelVendaProdutoVenda2> getListaProdutosAbandonoDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
          ModelVendaProdutoAbandono2 modelVendaProduto2 = new ModelVendaProdutoAbandono2();
        ModelVendaAbandono2 modelVenda2 = new ModelVendaAbandono2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_produto_abandono2.fk_venda, "
                    + "tbl_venda_produto_abandono2.fk_produto, "                    
                    + "tbl_venda_produto_abandono2.fk_usuario, "
                    + "tbl_venda_produto_abandono2.valor_venda, "
                    + "tbl_venda_produto_abandono2.quantidade, " 
                    + "tbl_venda_produto_abandono2.nome_produto, "
                     
                    + "tbl_venda_abandono2.fk_venda, "    
                    + "tbl_venda_abandono2.fk_cliente, "
                    + "tbl_venda_abandono2.fk_usuario, " 
                    + "tbl_venda_abandono2.data, "    
                    + "tbl_venda_abandono2.hora, " 
                    + "tbl_venda_abandono2.valor_liquido, "
                    + "tbl_venda_abandono2.valor_bruto, "
                    + "tbl_venda_abandono2.valor_desconto, "
                    + "tbl_venda_abandono2.tipo_pagamento "
                    
                    + "FROM tbl_venda_abandono2 "
                    + "INNER JOIN tbl_venda_produto_abandono2 ON tbl_venda_produto_abandono2.fk_venda = tbl_venda_abandono2.fk_venda "
                    + "WHERE tbl_venda_produto_abandono2.fk_venda = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelVendaProdutoAbandono2(); 
            modelVenda2 = new ModelVendaAbandono2();
            modelVendaProduto2.setVenda(this.getResultSet().getInt(1));
            modelVendaProduto2.setProduto(this.getResultSet().getInt(2));
            
            modelVendaProduto2.setUsuario(this.getResultSet().getInt(3));
            modelVendaProduto2.setValorVenda(this.getResultSet().getDouble(4));
            modelVendaProduto2.setQuantidade(this.getResultSet().getInt(5));
            modelVendaProduto2.setNome_produto(this.getResultSet().getString(6));
              
            modelVenda2.setFkVenda(this.getResultSet().getInt(7));
            modelVenda2.setCliente(this.getResultSet().getInt(8));
            modelVenda2.setUsuario(this.getResultSet().getInt(9));
            modelVenda2.setData(this.getResultSet().getString(10));
            modelVenda2.setHora(this.getResultSet().getString(11));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(12));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(13));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(14)); 
            modelVenda2.setPagamento(this.getResultSet().getString(15)); 
            
            modelVendaProdutoVenda2.setModelVendaProdutoAbandono2(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelVendaAbandono2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
      
      
      
    public ArrayList<ModelVendaProdutoVenda2> getListaParcelasDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelParcelamento modelVendaProduto2 = new ModelParcelamento();
        ModelCliente modelVenda2 = new ModelCliente();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_parcela_venda.pk_id_parcela, "
                    + "tbl_parcela_venda.fk_venda, "
                    + "tbl_parcela_venda.valor_venda, "
                    + "tbl_parcela_venda.data, "
                    + "tbl_parcela_venda.quantidade_parcelas, "
                    + "tbl_parcela_venda.valor_parcela, " 
                    + "tbl_parcela_venda.valor_total, "
                    + "tbl_parcela_venda.estado, "
                    
                     
                    + "tbl_clinte.pk_id_cliente, " 
                    + "tbl_clinte.nome "
                     
                    
                    
                    + "FROM tbl_parcela_venda "
                    + "INNER JOIN tbl_clinte ON tbl_clinte.pk_id_cliente = tbl_parcela_venda.fk_cliente "
                    + "WHERE tbl_parcela_venda.fk_cliente = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelParcelamento();
            modelVenda2 = new ModelCliente();
            modelVendaProduto2.setId(this.getResultSet().getInt(1));
            modelVendaProduto2.setCodVenda(this.getResultSet().getInt(2));
            modelVendaProduto2.setValorVenda(this.getResultSet().getFloat(3));
            modelVendaProduto2.setDataVenc(this.getResultSet().getString(4));
            modelVendaProduto2.setNumeroParc(this.getResultSet().getInt(5));
            modelVendaProduto2.setValorParcela(this.getResultSet().getFloat(6));
            modelVendaProduto2.setValorTotal(this.getResultSet().getFloat(7));
            modelVendaProduto2.setEstado(this.getResultSet().getString(8));
            
            
            modelVenda2.setId(this.getResultSet().getInt(9));
            modelVenda2.setNome(this.getResultSet().getString(10));
           
            
            modelVendaProdutoVenda2.setModelParcelamento(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelCliente(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
    
    
    public ArrayList<ModelVendaProdutoVenda2> getListaVendasProdutosDao(int pCod){
    ArrayList<ModelVendaProdutoVenda2> listaEstoqueBaixaEstoque = new ArrayList<>();
    ModelVendaProdutoVenda2 modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
        ModelVendaProduto2 modelVendaProduto2 = new ModelVendaProduto2();
        ModelVenda2 modelVenda2 = new ModelVenda2();
        try { 
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_venda_produto2.pk_id_vendaProduto, "
                    + "tbl_venda_produto2.fk_produto, "
                    + "tbl_venda_produto2.fk_venda, "
                    + "tbl_venda_produto2.fk_usuario, "
                    + "tbl_venda_produto2.valor_venda, "
                    + "tbl_venda_produto2.quantidade, " 
                    + "tbl_venda_produto2.nome_produto, "
                     
                    + "tbl_venda2.fk_venda, " 
                    + "tbl_venda2.fk_cliente, "
                    + "tbl_venda2.fk_usuario, " 
                    + "tbl_venda2.data, "    
                    + "tbl_venda2.hora, " 
                    + "tbl_venda2.valor_liquido, "
                    + "tbl_venda2.valor_bruto, "
                    + "tbl_venda2.valor_desconto, "
                    + "tbl_venda2.tipo_pagamento "
                    
                    + "FROM tbl_venda2 "
                    + "INNER JOIN tbl_venda_produto2 ON tbl_venda_produto2.fk_venda = tbl_venda2.fk_venda "
                    + "WHERE tbl_venda_produto2.fk_venda = '"+pCod+"';");
            while(this.getResultSet().next()){
            modelVendaProdutoVenda2 = new ModelVendaProdutoVenda2();
            modelVendaProduto2 = new ModelVendaProduto2();
            modelVenda2 = new ModelVenda2();
            modelVendaProduto2.setIdVendaDinheiroPro(this.getResultSet().getInt(1));
            modelVendaProduto2.setProduto(this.getResultSet().getInt(2));
            modelVendaProduto2.setVenda(this.getResultSet().getInt(3));
            modelVendaProduto2.setUsuario(this.getResultSet().getInt(4));
            modelVendaProduto2.setValorVenda(this.getResultSet().getDouble(5));
            modelVendaProduto2.setQuantidade(this.getResultSet().getInt(6));
            modelVendaProduto2.setNom_produto(this.getResultSet().getString(7));
              
            modelVenda2.setIdVenda(this.getResultSet().getInt(8));
            modelVenda2.setCliente(this.getResultSet().getInt(9));
            modelVenda2.setUsuario(this.getResultSet().getInt(10));
            modelVenda2.setData(this.getResultSet().getString(11));
            modelVenda2.setHora(this.getResultSet().getString(12));
            modelVenda2.setValorLiquido(this.getResultSet().getDouble(13));
            modelVenda2.setValorBruto(this.getResultSet().getDouble(14));
            modelVenda2.setValorDesconto(this.getResultSet().getDouble(15)); 
            modelVenda2.setPagamento(this.getResultSet().getString(16)); 
            
            modelVendaProdutoVenda2.setModelVendaProduto2(modelVendaProduto2);
            modelVendaProdutoVenda2.setModelVenda2(modelVenda2);
            listaEstoqueBaixaEstoque.add(modelVendaProdutoVenda2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{ 
            this.fecharConexao();
        }
        return listaEstoqueBaixaEstoque;
    }
}
 