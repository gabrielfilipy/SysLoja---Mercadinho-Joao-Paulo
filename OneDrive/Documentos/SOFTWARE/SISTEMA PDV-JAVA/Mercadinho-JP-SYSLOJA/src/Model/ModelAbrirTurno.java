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
public class ModelAbrirTurno {

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
    public Double getValor() {
        return valor;
    }

    /** 
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    private int id;
    private String nome; 
    private String data;
    private String hora;
    private Double valor;
    private int pk_id_abrir_turno;
    private String estado;
    private int fkTurno;
} 
