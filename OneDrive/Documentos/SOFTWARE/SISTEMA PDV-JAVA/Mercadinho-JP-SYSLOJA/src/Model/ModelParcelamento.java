/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Monet
 */
public class ModelParcelamento {

    /**
     * @return the nomeClie
     */
    public String getNomeClie() {
        return nomeClie;
    }

    /**
     * @param nomeClie the nomeClie to set
     */
    public void setNomeClie(String nomeClie) {
        this.nomeClie = nomeClie;
    }

    /**
     * @return the cpfCli
     */
    public String getCpfCli() {
        return cpfCli;
    }

    /**
     * @param cpfCli the cpfCli to set
     */
    public void setCpfCli(String cpfCli) {
        this.cpfCli = cpfCli;
    }

    

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @return the codVenda
     */
    public int getCodVenda() {
        return codVenda;
    }

    /**
     * @param codVenda the codVenda to set
     */
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    /**
     * @return the numeroParc
     */
    public int getNumeroParc() {
        return numeroParc;
    }

    /**
     * @param numeroParc the numeroParc to set
     */
    public void setNumeroParc(int numeroParc) {
        this.numeroParc = numeroParc;
    }

    /**
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the valorParcela
     */
    public float getValorParcela() {
        return valorParcela;
    }

    /**
     * @param valorParcela the valorParcela to set
     */
    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }
 
    /**
     * @return the dataVenc
     */
    public String getDataVenc() {
        return dataVenc;
    } 

    /**
     * @param dataVenc the dataVenc to set
     */
    public void setDataVenc(String dataVenc) {
        this.dataVenc = dataVenc;
    }

   
  
  private int id;
    private int codVenda;
    private int numeroParc;
    private float valorVenda;
    private float valorTotal; 
    private float valorParcela;
    private String dataVenc; 
    private String estado;
    private int cliente; 
    private String nomeClie;
    private String cpfCli;
  
}
