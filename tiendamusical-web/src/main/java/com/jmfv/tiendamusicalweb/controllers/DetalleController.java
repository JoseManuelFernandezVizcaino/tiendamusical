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

import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfv.tiendamusicalentities.entities.CarritoAlbum;
import com.jmfv.tiendamusicalservices.service.CarritoService;
import com.jmfv.tiendamusicalweb.session.SessionBean;

/**
 * @author jmfer
 * Clase que controla el flujo de la pantalla de detalle.xhtml
 */
@ManagedBean
@ViewScoped
public class DetalleController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(DetalleController.class);
	
	/**
	 * Cantidad del producto seleccionado
	 */
	private int cantidadAlbumSeleccionada;
	
	/**
	 * Objetio que contiene los metodos de logica de negocio
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	/**
	 * Inicializa la pantalla del detalle
	 */
	@PostConstruct
	public void init() {
		this.cantidadAlbumSeleccionada = 1;
	}
	
	/**
	 * Metodo que permite agregar el album seleccionado por el usuario al carrito de compra
	 * @param artistaAlbumDTO
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		LOGGER.info("Agregando album al carrito de compras..." + ", Cantidad: " + this.cantidadAlbumSeleccionada);
		
		CarritoAlbum carritoAlbumAgregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(), cantidadAlbumSeleccionada);
	
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritoAlbumAgregado);
	}

	/**
	 * @return the cantidadAlbumSeleccionada
	 */
	public int getCantidadAlbumSeleccionada() {
		return cantidadAlbumSeleccionada;
	}

	/**
	 * @param cantidadAlbumSeleccionada the cantidadAlbumSeleccionada to set
	 */
	public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
		this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
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
}
