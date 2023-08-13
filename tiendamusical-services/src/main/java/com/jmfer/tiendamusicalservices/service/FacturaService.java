/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import com.jmfer.tiendamusicalentities.entities.Factura;
import com.jmfer.tiendamusicalentities.entities.Persona;
import com.paypal.orders.Order;

/**
 * @author jmfer
 * Interface que define los metodos de logica de negocio para la generación de la factura
 */
public interface FacturaService {
	
	/**
	 * Metodo que permite generar la factura de la compra del pedido del cliente
	 * @param factura
	 * @param order
	 * @param persona
	 */
	Factura guardarFactura(Factura factura, Order order, Persona persona);
}
