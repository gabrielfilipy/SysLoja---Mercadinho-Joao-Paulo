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
public class ModelBaixaParcela {

    /**
     * @return the dataVen
     */
    public String getDataVen() {
        return dataVen;
    }

    /**
     * @param dataVen the dataVen to set
     */
    public void setDataVen(String dataVen) {
        this.dataVen = dataVen;
    }

    /**
     * @return the codVen
     */
    public int getCodVen() {
        return codVen;
    }

    /**
     * @param codVen the codVen to set
     */
    public void setCodVen(int codVen) {
        this.codVen = codVen;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
 
    /**
     * @return the codParc
     */
    public int getCodParc() {
        return codParc;
    }

    /**
     * @param codParc the codParc to set
     */
    public void setCodParc(int codParc) {
        this.codParc = codParc;
    }
    private int codParc;
    private String dataVen;
    private int codVen;
    private float valor;
}
