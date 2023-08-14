/**
 * 
 */
package com.jmfer.tiendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jmfer.tiendamusicalentities.entities.Carrito;
import com.jmfer.tiendamusicalentities.entities.CarritoAlbum;
import com.jmfer.tiendamusicalentities.entities.Factura;
import com.jmfer.tiendamusicalservices.service.FacturaService;
import com.jmfer.tiendamusicalweb.session.SessionBean;

/**
 * @author jmfer
 * Clase que controla el flujo de informacion de la pantalla de mis compras del cliente
 */
@ManagedBean
@ViewScoped
public class MisComprasController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(MisComprasController.class);
	
	/**
	 * Lista a mostrase en la tabla de facturas del cliente
	 */
	private List<Factura> facturas;
	
	/**
	 * Lista de albums en el carrito comprados de la factura
	 */
	private List<CarritoAlbum> carritosAlbum;
	
	/**
	 * Objeto que contiene los metodos para realizar la logica de negocio para las facturas
	 */
	@ManagedProperty("#{facturaServiceImpl}")
	private FacturaService facturaServiceImpl;
	
	/**
	 * Objeto que contiene la información en sesion de la persona
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando pantalla de mis compras...");
		consultarFacturasPorPersona();
	}
	
	/**
	 * Metodo que permite consultar la lista de facturas por persona
	 */
	public void consultarFacturasPorPersona() {
		String nombreCompleto = this.sessionBean.getPersona().getNombre() + " " 
						+ this.sessionBean.getPersona().getPrimerApellido() + " " 
						+ this.sessionBean.getPersona().getSegundoApellido();
		
		LOGGER.info("Consultando las facturas de " + nombreCompleto);
		this.facturas = this.facturaServiceImpl.consultarFacturasPersona(this.sessionBean.getPersona());
	}
	
	/**
	 * Metodo que permite mostrar la informacion del detalle de la compra
	 * @param carritosAlbum
	 */
	public void mostrarDetalle(List<CarritoAlbum> carritosAlbum) {
		this.carritosAlbum = carritosAlbum;
	}

	/**
	 * @return the facturas
	 */
	public List<Factura> getFacturas() {
		return facturas;
	}

	/**
	 * @param facturas the facturas to set
	 */
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	/**
	 * @return the facturaServiceImpl
	 */
	public FacturaService getFacturaServiceImpl() {
		return facturaServiceImpl;
	}

	/**
	 * @param facturaServiceImpl the facturaServiceImpl to set
	 */
	public void setFacturaServiceImpl(FacturaService facturaServiceImpl) {
		this.facturaServiceImpl = facturaServiceImpl;
	}

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	/**
	 * @return the carritosAlbums
	 */
	public List<CarritoAlbum> getCarritosAlbum() {
		return carritosAlbum;
	}

	/**
	 * @param carritosAlbums the carritosAlbums to set
	 */
	public void setCarritosAlbum(List<CarritoAlbum> carritosAlbum) {
		this.carritosAlbum = carritosAlbum;
	}
	
	
}
