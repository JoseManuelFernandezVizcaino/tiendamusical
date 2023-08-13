/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.FacturaDAO;
import com.jmfer.tiendamusicalentities.entities.Factura;
import com.jmfer.tiendamusicalentities.entities.Persona;
import com.jmfer.tiendamusicalservices.service.FacturaService;
import com.paypal.orders.Order;

/**
 * @author jmfer
 * Clase que implementa los metodos de logica de negocio para la tabla de factura.
 */
@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaDAO facturaDAO;
	
	@Override
	public Factura guardarFactura(Factura factura, Order order, Persona persona) {
		double envio = Double.parseDouble(order.purchaseUnits().get(0).amountWithBreakdown().amountBreakdown().shipping().value());
		double envioDescuento = Double.parseDouble(order.purchaseUnits().get(0).amountWithBreakdown().amountBreakdown().shippingDiscount().value());
		double handling = Double.parseDouble(order.purchaseUnits().get(0).amountWithBreakdown().amountBreakdown().handling().value());
		double total = Double.parseDouble(order.purchaseUnits().get(0).amountWithBreakdown().amountBreakdown().itemTotal().value());
		double impuestoTotal = Double.parseDouble(order.purchaseUnits().get(0).amountWithBreakdown().amountBreakdown().taxTotal().value());
		
		
		factura.setOrderId(order.id());
		factura.setFechaCreacion(LocalDateTime.now());
		factura.setEstatus(true);
		factura.setPais(order.payer().addressPortable().adminArea1());
		factura.setCiudad(order.payer().addressPortable().adminArea2());
		factura.setCodigoPostal(order.payer().addressPortable().postalCode());
		factura.setDireccion(order.payer().addressPortable().addressLine1() + ", " + order.payer().addressPortable().addressLine2());
		factura.setDivisa(order.purchaseUnits().get(0).amountWithBreakdown().currencyCode());
		factura.setEnvio(envio);
		factura.setEnvioDescuento(envioDescuento);
		factura.setHandling(handling);
		factura.setTotal(total);
		factura.setImpuestoTotal(impuestoTotal);
		factura.setPersona(persona);
		
		return this.facturaDAO.save(factura);
	}

}