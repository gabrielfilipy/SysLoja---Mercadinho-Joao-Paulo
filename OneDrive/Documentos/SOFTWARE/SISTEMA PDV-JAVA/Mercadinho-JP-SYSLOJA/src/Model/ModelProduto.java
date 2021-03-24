/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Conexao.Conectar;
import View.ViewListaProduto;
import View.ViewProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Monet
 */
public class ModelProduto {
 DecimalFormat df = new DecimalFormat("#.00");
    /**
     * @return the preco_venda
     */
    public Double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    /**
     * @return the preco_custo
     */
    public Double getPreco_custo() {
        return preco_custo;
    }

    /**
     * @param preco_custo the preco_custo to set
     */
    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }
    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
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
     * @return the cod_barras
     */
    public String getCod_barras() {
        return cod_barras;
    }

    /**
     * @param cod_barras the cod_barras to set
     */
    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the validade
     */
    public String getValidade() { 
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the atributo
     */
    public String getAtributo() {
        return atributo;
    }

    /**
     * @param atributo the atributo to set
     */
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    /**
     * @return the ind_atributo
     */
    public String getInd_atributo() {
        return ind_atributo;
    }

    /**
     * @param ind_atributo the ind_atributo to set
     */
    public void setInd_atributo(String ind_atributo) {
        this.ind_atributo = ind_atributo;
    }

    /**
     * @return the ncm
     */
    public String getNcm() {
        return ncm;
    }

    /**
     * @param ncm the ncm to set
     */
    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    private int id;
    private String nome;
    private String cod_barras;
    private String departamento;
    private String validade;
    private int estoque;
    private String atributo;
    private String ind_atributo;
    private String ncm;
    private String fornecedor;
    private Double preco_venda;
    private Double preco_custo;
    
     
    
    
    
    public static void listarCat(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ViewProduto.tabela.getModel();
        while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
        sql = Dao.DaoProduto.LISTAR;
        } else {
        sql = "SELECT * FROM tbl_produto WHERE (nome like'" + busca + "%' or nome like'" + busca + "%') "
        + "or nome='" + busca + "' ORDER BY nome";       
        }
        String dados[] = new String[12];
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
        dados[0] = rs.getString("pk_id_produto");
        dados[1] = rs.getString("nome");
        dados[2] = rs.getString("estoque");
        dados[3] = rs.getString("cod_barras");   
        
        dados[4] = rs.getString("departamento");
        dados[5] = rs.getString("atributo");
        dados[6] = rs.getString("ind_atributo");
        dados[7] = rs.getString("ncm");   
        
        dados[8] = rs.getString("fornecedor");
        dados[9] = rs.getString("prazo_validade"); 
        dados[10] = rs.getString("preco_custo"); 
dados[11] = rs.getString("preco_venda"); 
        modelo.addRow(dados);
        }
        } catch (SQLException ex) {
        Logger.getLogger(ModelProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void listar2(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ViewListaProduto.tabela.getModel();
        while (modelo.getRowCount() > 0) { 
        modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
        sql = Dao.DaoProduto.LISTAR;
        } else {
        sql = "SELECT * FROM tbl_produto WHERE (nome like'" + busca + "%' or nome like'" + busca + "%') "
        + "or nome='" + busca + "' ORDER BY nome";       
        }
        String dados[] = new String[12];
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
        dados[0] = rs.getString("pk_id_produto");
        dados[1] = rs.getString("nome");
        dados[2] = rs.getString("preco_venda");
        dados[3] = rs.getString("cod_barras");   
        
        dados[4] = rs.getString("departamento");
        dados[5] = rs.getString("atributo");
        dados[6] = rs.getString("ind_atributo");
        dados[7] = rs.getString("ncm");   
        
        dados[8] = rs.getString("fornecedor");
        dados[9] = rs.getString("prazo_validade"); 
      dados[10] = rs.getString("preco_custo"); 
dados[11] = rs.getString("estoque"); 
        modelo.addRow(dados);
        }
        } catch (SQLException ex) {
        Logger.getLogger(ModelProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
