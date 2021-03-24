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
public class ModelAbrirTurno2 {

    /**
     * @return the DataAnual
     */
    public String getDataAnual() {
        return DataAnual;
    }

    /**
     * @param DataAnual the DataAnual to set
     */
    public void setDataAnual(String DataAnual) {
        this.DataAnual = DataAnual;
    }

    /**
     * @return the DataRelatorio
     */
    public String getDataRelatorio() {
        return DataRelatorio;
    }

    /**
     * @param DataRelatorio the DataRelatorio to set
     */
    public void setDataRelatorio(String DataRelatorio) {
        this.DataRelatorio = DataRelatorio;
    }

    /**
     * @return the hora2
     */
    public String getHora2() {
        return hora2;
    }

    /**
     * @param hora2 the hora2 to set
     */
    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    /**
     * @return the data_fechar
     */
    public String getData_fechar() {
        return data_fechar;
    }

    /**
     * @param data_fechar the data_fechar to set
     */
    public void setData_fechar(String data_fechar) {
        this.data_fechar = data_fechar;
    }

    /**
     * @return the fkTurno
     */
    public int getFkTurno() {
        return fkTurno;
    }

    /**
     * @param fkTurno the fkTurno to set
     */
    public void setFkTurno(int fkTurno) {
        this.fkTurno = fkTurno;
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
     * @return the pk_id_abrir_turno
     */
    public int getPk_id_abrir_turno() {
        return pk_id_abrir_turno;
    }

    /**
     * @param pk_id_abrir_turno the pk_id_abrir_turno to set
     */
    public void setPk_id_abrir_turno(int pk_id_abrir_turno) {
        this.pk_id_abrir_turno = pk_id_abrir_turno;
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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }
 
    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }
 
    /** 
     * @param valor the valor to set
     */  
    public void setValor(String valor) {
        this.valor = valor;
    }
    private int id;
    private String nome; 
    private String data;
    private String hora;
    private String valor;
    private int pk_id_abrir_turno;
    private String estado;
    private int fkTurno;
    private String data_fechar;
    private String hora2;
    private String DataRelatorio;
    private String DataAnual;
    
} 
