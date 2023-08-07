/**
 * 
 */
package com.jmfv.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jmfv.tiendamusicalentities.entities.CarritoAlbum;
import com.jmfv.tiendamusicalservices.service.CarritoService;
import com.jmfv.tiendamusicalweb.session.SessionBean;

/**
 * @author jmfer
 * Clase que se encarga de controlar el flujo de la pantalla del carrito de compras
 */
@ManagedBean
@ViewScoped
public class CarritoController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);
	
	/**
	 * Objeto que contiene la información en sesion del usuario
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	/**
	 * Objeto que realiza la logica de negocio para el carrito de compra
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	
	/**
	 * Inicializa la informacion de la pantalla del carrito
	 */
	@PostConstruct
	public void init() {
		this.calcularTotal();
	}
	
	/**
	 * Metodo que permite calcular el total de la compra con respecto a los albums en el carrito
	 */
	public void calcularTotal() {
		LOGGER.info("Calculando total...");
		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
	
		this.sessionBean.setTotalCompra(total);
	}
	
	/**
	 * Metodo que permite eliminar un album del carrito del usuario
	 * @param carritoAlbum
	 */
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		LOGGER.info("Eliminando album "+ carritoAlbum.getAlbum().getNombre()+" del carrito...");
		
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		
		this.calcularTotal();
	}
	
	/**
	 * Metodo que permite actualizar la cantidad y los totales del album a comprar
	 * @param carritoAlbum
	 */
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum, this.sessionBean.getPersona().getCarrito());
	
		this.sessionBean.setTotalCompra(totalCompra);
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
	 * @return the carritoService
	 */
	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	/**
	 * @param carritoService the carritoService to set
	 */
	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}
}
