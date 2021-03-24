/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class ModelUsuario {

    /**
     * @return the tipo_conta
     */
    public int getTipo_conta() {
        return tipo_conta;
    }

    /**
     * @param tipo_conta the tipo_conta to set
     */
    public void setTipo_conta(int tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    /**
     * @return the cadastro_cidade
     */
    public int getCadastro_cidade() {
        return cadastro_cidade;
    }

    /**
     * @param cadastro_cidade the cadastro_cidade to set
     */
    public void setCadastro_cidade(int cadastro_cidade) {
        this.cadastro_cidade = cadastro_cidade;
    }

    /**
     * @return the cadastro_usuario
     */
    public int getCadastro_usuario() {
        return cadastro_usuario;
    }

    /**
     * @param cadastro_usuario the cadastro_usuario to set
     */
    public void setCadastro_usuario(int cadastro_usuario) {
        this.cadastro_usuario = cadastro_usuario;
    }

    /**
     * @return the cadastro_estivas
     */
    public int getCadastro_estivas() {
        return cadastro_estivas;
    }

    /**
     * @param cadastro_estivas the cadastro_estivas to set
     */
    public void setCadastro_estivas(int cadastro_estivas) {
        this.cadastro_estivas = cadastro_estivas;
    }

    /**
     * @return the cadastro_cliente
     */
    public int getCadastro_cliente() {
        return cadastro_cliente;
    }

    /**
     * @param cadastro_cliente the cadastro_cliente to set
     */
    public void setCadastro_cliente(int cadastro_cliente) {
        this.cadastro_cliente = cadastro_cliente;
    }

    /**
     * @return the cadastro_estoque
     */
    public int getCadastro_estoque() {
        return cadastro_estoque;
    }

    /**
     * @param cadastro_estoque the cadastro_estoque to set
     */
    public void setCadastro_estoque(int cadastro_estoque) {
        this.cadastro_estoque = cadastro_estoque;
    }

    /**
     * @return the cadastro_fornecedor
     */
    public int getCadastro_fornecedor() {
        return cadastro_fornecedor;
    }

    /**
     * @param cadastro_fornecedor the cadastro_fornecedor to set
     */
    public void setCadastro_fornecedor(int cadastro_fornecedor) {
        this.cadastro_fornecedor = cadastro_fornecedor;
    }

    /**
     * @return the cadastro_departamento
     */
    public int getCadastro_departamento() {
        return cadastro_departamento;
    }

    /**
     * @param cadastro_departamento the cadastro_departamento to set
     */
    public void setCadastro_departamento(int cadastro_departamento) {
        this.cadastro_departamento = cadastro_departamento;
    }

    /**
     * @return the cadastro_bairro
     */
    public int getCadastro_bairro() {
        return cadastro_bairro;
    }

    /**
     * @param cadastro_bairro the cadastro_bairro to set
     */
    public void setCadastro_bairro(int cadastro_bairro) {
        this.cadastro_bairro = cadastro_bairro;
    }

    /**
     * @return the cadastro_rua
     */
    public int getCadastro_rua() {
        return cadastro_rua;
    }

    /**
     * @param cadastro_rua the cadastro_rua to set
     */
    public void setCadastro_rua(int cadastro_rua) {
        this.cadastro_rua = cadastro_rua;
    }

    /**
     * @return the pagar_conta
     */
    public int getPagar_conta() {
        return pagar_conta;
    }

    /**
     * @param pagar_conta the pagar_conta to set
     */
    public void setPagar_conta(int pagar_conta) {
        this.pagar_conta = pagar_conta;
    }

    /**
     * @return the retira_estoque
     */
    public int getRetira_estoque() {
        return retira_estoque;
    }

    /**
     * @param retira_estoque the retira_estoque to set
     */
    public void setRetira_estoque(int retira_estoque) {
        this.retira_estoque = retira_estoque;
    }

    /**
     * @return the relatorio_entrada_estoque
     */
    public int getRelatorio_entrada_estoque() {
        return relatorio_entrada_estoque;
    }

    /**
     * @param relatorio_entrada_estoque the relatorio_entrada_estoque to set
     */
    public void setRelatorio_entrada_estoque(int relatorio_entrada_estoque) {
        this.relatorio_entrada_estoque = relatorio_entrada_estoque;
    }

    /**
     * @return the relatorio_saida_estoque
     */
    public int getRelatorio_saida_estoque() {
        return relatorio_saida_estoque;
    }

    /**
     * @param relatorio_saida_estoque the relatorio_saida_estoque to set
     */
    public void setRelatorio_saida_estoque(int relatorio_saida_estoque) {
        this.relatorio_saida_estoque = relatorio_saida_estoque;
    }

    /**
     * @return the despesa
     */
    public int getDespesa() {
        return despesa;
    }

    /**
     * @param despesa the despesa to set
     */
    public void setDespesa(int despesa) {
        this.despesa = despesa;
    }

    /**
     * @return the relatorio_parcelamento
     */
    public int getRelatorio_parcelamento() {
        return relatorio_parcelamento;
    }

    /**
     * @param relatorio_parcelamento the relatorio_parcelamento to set
     */
    public void setRelatorio_parcelamento(int relatorio_parcelamento) {
        this.relatorio_parcelamento = relatorio_parcelamento;
    }

    /**
     * @return the relatorio_estoque
     */
    public int getRelatorio_estoque() {
        return relatorio_estoque;
    }

    /**
     * @param relatorio_estoque the relatorio_estoque to set
     */
    public void setRelatorio_estoque(int relatorio_estoque) {
        this.relatorio_estoque = relatorio_estoque;
    }

    /**
     * @return the relatorio_venda
     */
    public int getRelatorio_venda() {
        return relatorio_venda;
    }

    /**
     * @param relatorio_venda the relatorio_venda to set
     */
    public void setRelatorio_venda(int relatorio_venda) {
        this.relatorio_venda = relatorio_venda;
    }

    /**
     * @return the relatorio_turno
     */
    public int getRelatorio_turno() {
        return relatorio_turno;
    }

    /**
     * @param relatorio_turno the relatorio_turno to set
     */
    public void setRelatorio_turno(int relatorio_turno) {
        this.relatorio_turno = relatorio_turno;
    }

    /**
     * @return the relatorio_produto_maisVendido
     */
    public int getRelatorio_produto_maisVendido() {
        return relatorio_produto_maisVendido;
    }

    /**
     * @param relatorio_produto_maisVendido the relatorio_produto_maisVendido to set
     */
    public void setRelatorio_produto_maisVendido(int relatorio_produto_maisVendido) {
        this.relatorio_produto_maisVendido = relatorio_produto_maisVendido;
    }

    /**
     * @return the relatorio_conta_pagaga
     */
    public int getRelatorio_conta_pagaga() {
        return relatorio_conta_pagaga;
    }

    /**
     * @param relatorio_conta_pagaga the relatorio_conta_pagaga to set
     */
    public void setRelatorio_conta_pagaga(int relatorio_conta_pagaga) {
        this.relatorio_conta_pagaga = relatorio_conta_pagaga;
    }

    /**
     * @return the cancelar_venda
     */
    public int getCancelar_venda() {
        return cancelar_venda;
    }

    /**
     * @param cancelar_venda the cancelar_venda to set
     */
    public void setCancelar_venda(int cancelar_venda) {
        this.cancelar_venda = cancelar_venda;
    }

    /**
     * @return the parcela_venda
     */
    public int getParcela_venda() {
        return parcela_venda;
    }

    /**
     * @param parcela_venda the parcela_venda to set
     */
    public void setParcela_venda(int parcela_venda) {
        this.parcela_venda = parcela_venda;
    }

    /**
     * @return the dar_desconto
     */
    public int getDar_desconto() {
        return dar_desconto;
    }

    /**
     * @param dar_desconto the dar_desconto to set
     */
    public void setDar_desconto(int dar_desconto) {
        this.dar_desconto = dar_desconto;
    }

    /**
     * @return the fazer_sangria
     */
    public int getFazer_sangria() {
        return fazer_sangria;
    }

    /**
     * @param fazer_sangria the fazer_sangria to set
     */
    public void setFazer_sangria(int fazer_sangria) {
        this.fazer_sangria = fazer_sangria;
    }

    /**
     * @return the abandonar_venda
     */
    public int getAbandonar_venda() {
        return abandonar_venda;
    }

    /**
     * @param abandonar_venda the abandonar_venda to set
     */
    public void setAbandonar_venda(int abandonar_venda) {
        this.abandonar_venda = abandonar_venda;
    }

   

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
     * @return the senha    
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private int id ;
    private String nome ;
    private String senha ; 
    private String tipo ;
    
    private int tipo_conta;
    private int cadastro_cidade;
    private int cadastro_usuario;
    private int cadastro_estivas;
    private int cadastro_cliente;
    private int cadastro_estoque;
    private int cadastro_fornecedor;
    private int cadastro_departamento;
    private int cadastro_bairro;
    private int cadastro_rua;
    private int pagar_conta;
    private int retira_estoque;
    private int relatorio_entrada_estoque;
    private int relatorio_saida_estoque;
    private int despesa;
    private int relatorio_parcelamento;
    private int relatorio_estoque;
    private int relatorio_venda;
    private int relatorio_turno;
    private int relatorio_produto_maisVendido;
    private int relatorio_conta_pagaga;
    private int cancelar_venda;
    private int parcela_venda;
    private int dar_desconto;
    private int fazer_sangria;
    private int abandonar_venda;
    
    
 
    
    
    
}
