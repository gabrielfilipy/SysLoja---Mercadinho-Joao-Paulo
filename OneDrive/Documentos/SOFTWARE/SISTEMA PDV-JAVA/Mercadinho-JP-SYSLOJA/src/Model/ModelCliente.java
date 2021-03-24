/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.ModelProduto.cn;
import View.ViewCliente;
import View.ViewListaClientes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Monet
 */
public class ModelCliente {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /** 
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the numero_casa
     */
    public String getNumero_casa() {
        return numero_casa;
    }

    /**
     * @param numero_casa the numero_casa to set
     */
    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }
    private int id;
    private String nome;
    private String nascimento;
    private String bairro;
    private String rua;
    private String cidade;
    private String rg;
    private String telefone;
    private String numero_casa;
    
    
    
    
    
    public static void listarCat(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ViewCliente.tabela.getModel();
        while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
        sql = Dao.DaoCliente.LISTAR;
        } else {
        sql = "SELECT * FROM tbl_clinte WHERE (nome like'" + busca + "%' or nome like'" + busca + "%') "
        + "or nome='" + busca + "' ORDER BY nome";       
        }
        String dados[] = new String[9]; 
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        while (rs.next()) {
        dados[0] = rs.getString("pk_id_cliente");
        dados[1] = rs.getString("nome");
        dados[2] = rs.getString("nascimento");
        dados[3] = rs.getString("bairro");   
        
        dados[4] = rs.getString("rua");
        dados[5] = rs.getString("numero_casa"); 
        dados[6] = rs.getString("cidade");
        dados[7] = rs.getString("rg");   
        
        dados[8] = rs.getString("telefone");
        
        modelo.addRow(dados);
        }
        } catch (SQLException ex) {
        Logger.getLogger(ModelCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void listarListaCliente1(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ViewListaClientes.tabela.getModel();
        while (modelo.getRowCount() > 0) {
        modelo.removeRow(0); 
        }
        String sql = "";
        if (busca.equals("")) {
        sql = Dao.DaoCliente.LISTAR;
        } else {
        sql = "SELECT * FROM tbl_clinte WHERE (nome like'" + busca + "%' or nome like'" + busca + "%') "
        + "or nome='" + busca + "' ORDER BY nome";       
        }
        String dados[] = new String[9]; 
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        while (rs.next()) {
        dados[0] = rs.getString("pk_id_cliente");
        dados[1] = rs.getString("nome");
        dados[2] = rs.getString("nascimento");
        dados[3] = rs.getString("bairro");   
        
        dados[4] = rs.getString("rua");
        dados[5] = rs.getString("numero_casa"); 
        dados[6] = rs.getString("cidade");
        dados[7] = rs.getString("rg");   
        
        dados[8] = rs.getString("telefone");
        
        modelo.addRow(dados);
        }
        } catch (SQLException ex) {
        Logger.getLogger(ModelCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
