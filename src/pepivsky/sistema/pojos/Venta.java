/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepivsky.sistema.pojos;

import java.sql.Date;

/**
 *
 * @author PP
 */
public class Venta {
    
    private Double montoVenta;
    private Date fechaVenta;

    public Venta(Double montoVenta, Date fechaVenta) {
        this.montoVenta = montoVenta;
        this.fechaVenta = fechaVenta;
    }

    public Double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(Double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
    
    
    
}
