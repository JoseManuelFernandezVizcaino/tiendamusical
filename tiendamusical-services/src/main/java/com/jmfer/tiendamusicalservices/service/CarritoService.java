/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import java.util.List;

import com.jmfer.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfer.tiendamusicalentities.entities.Carrito;
import com.jmfer.tiendamusicalentities.entities.CarritoAlbum;
import com.jmfer.tiendamusicalentities.entities.Factura;

/**
 * @author jmfer
 * Interface que define los metodos de logica de negocio para el carrito de compras.
 */
public interface CarritoService {
	/**
	 * Metodo que permite guardar los albums a comprar en el carrito de compras.
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con la informacion del album en el carrito.
	 * @param carrito {@link Carrito} objeto con la informacion del carrito del usuario.
	 * @param cantidadAlbumSeleccionada {@link Integer} cantidad seleccionada del album por el usuario.
	 */
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada);
	/**
	 * Metodo que permite calcular el total de la compra.
	 * @param carrito {@link Carrito} objeto con la informacion del carrito a calcular.
	 * @return {@link Float} total calculado.
 	 */
	float calcularTotal(Carrito carrito);
	/**
	 * Metodo que permite eliminar un album del carrito.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album del carrito a eliminar.
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	/**
	 * Metodo que permite actualizar la cantidad del album a comprar en el carrito.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album a actualizar en el carrito.
	 * @param carrito {@link Carrito} objeto con el carrito de compras del usuario.
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
	
	/**
	 * Metodo que permite actualizar los registros de los productos comprados por el cliente agregandolos la orden de compra
	 * @param carritoAlbums
	 * @param factura
	 * @return
	 */
	boolean actualizarCarritoAlbum(List<CarritoAlbum> carritoAlbums, Factura factura);
}
