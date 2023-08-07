/**
 * 
 */
package com.jmfv.tiendamusicalservices.service;

import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfv.tiendamusicalentities.entities.Carrito;
import com.jmfv.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author jmfer
 * Interface que define los metodos de logica de negocio para el carrito de compra
 */
public interface CarritoService {
	
	/**
	 * Metodo que permite guardar los albums a comprar en el carrito de compras
	 * @param artistaAlbumDTO
	 * @param carrito
	 * @param cantidadAlbumSeleccionada
	 */
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada);
	
	/**
	 * Metodo que permite calcular el total de la compra
	 * @param carrito
	 * @return
	 */
	float calcularTotal(Carrito carrito);
	
	/**
	 * Metodo que permite eliminar un album del carrito
	 * @param carritoAlbum
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	
	/**
	 * Metodo que permite actualizar la cantidad del album a comprar en el carrito
	 * @param carritoAlbum
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
}
