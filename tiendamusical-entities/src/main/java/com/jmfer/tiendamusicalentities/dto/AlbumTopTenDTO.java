/**
 * 
 */
package com.jmfer.tiendamusicalentities.dto;

import com.jmfer.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author jmfer
 * Clase DTO para generar la grafica de top ten de albums mas vendidos para el administrador
 */
public class AlbumTopTenDTO {
	
	/**
	 * Objeto con la informacion del album del carrito
	 */
	private CarritoAlbum carritoAlbum;
	
	/**
	 * Cantidad total vendida por album
	 */
	private long cantidadSuma;
	
	public AlbumTopTenDTO() {
		super();
	}
	
	/**
	 * Contructor que permite inicializar la informacion del objeto carritoAlbum y cantidad suma del album
	 * @param carritoAlbum
	 * @param cantidadSuma
	 */
	public AlbumTopTenDTO(CarritoAlbum carritoAlbum, long cantidadSuma) {
		this.carritoAlbum = carritoAlbum;
		this.cantidadSuma = cantidadSuma;
	}

	/**
	 * @return the carritoAlbum
	 */
	public CarritoAlbum getCarritoAlbum() {
		return carritoAlbum;
	}

	/**
	 * @param carritoAlbum the carritoAlbum to set
	 */
	public void setCarritoAlbum(CarritoAlbum carritoAlbum) {
		this.carritoAlbum = carritoAlbum;
	}

	/**
	 * @return the cantidadSuma
	 */
	public long getCantidadSuma() {
		return cantidadSuma;
	}

	/**
	 * @param cantidadSuma the cantidadSuma to set
	 */
	public void setCantidadSuma(long cantidadSuma) {
		this.cantidadSuma = cantidadSuma;
	}
}
