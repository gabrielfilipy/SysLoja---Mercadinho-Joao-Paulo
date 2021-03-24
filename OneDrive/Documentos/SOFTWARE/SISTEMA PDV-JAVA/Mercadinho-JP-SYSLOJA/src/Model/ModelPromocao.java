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
public class ModelPromocao {
public static String ELIMINAR_TUDO = "DELETE FROM tbl_promoção";
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
     * @return the apartir
     */
    public double getApartir() {
        return apartir;
    }

    /**
     * @param apartir the apartir to set
     */
    public void setApartir(double apartir) {
        this.apartir = apartir;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    private int id;
    private double apartir;
    private double valor;
}
