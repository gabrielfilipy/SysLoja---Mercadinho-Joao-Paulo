/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoVendaCliente;
import Model.ModelVendaCliente;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class ControllerVendaCliente {
     DaoVendaCliente daoVendaCliente = new DaoVendaCliente();
     
     
     
    public ArrayList<ModelVendaCliente> getListaVendaClienteController() {
    return this.daoVendaCliente.getListavendaClienteDAO();
    }
    
}
