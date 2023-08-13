/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.CarritoAlbumDAO;
import com.jmfer.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfer.tiendamusicalentities.entities.Carrito;
import com.jmfer.tiendamusicalentities.entities.CarritoAlbum;
import com.jmfer.tiendamusicalentities.entities.Factura;
import com.jmfer.tiendamusicalservices.service.CarritoService;

/**
 * @author jmfer
 * Clase que implementa los metodos de la logica de negocio de Carrito Service
 * para el carrito de compras.
 */
@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	private CarritoAlbumDAO carritoAlbumDAO;
	
	@Override
	public CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada) {

		CarritoAlbum carritoAlbum = new CarritoAlbum();
		carritoAlbum.setAlbum(artistaAlbumDTO.getAlbum());
		carritoAlbum.setCarrito(carrito);
		carritoAlbum.setCantidad(cantidadAlbumSeleccionada);
		carritoAlbum.setEstatus("PENDIENTE");
		
		this.carritoAlbumDAO.save(carritoAlbum);
		
		return carritoAlbum;
	}

	@Override
	public float calcularTotal(Carrito carrito) {
		
		float total = 0.0F;
		
		//Se realiza el calculo del total de la compra.
		for (CarritoAlbum carritoAlbum : carrito.getCarritosAlbum()) {
			total += (carritoAlbum.getAlbum().getValor() * carritoAlbum.getCantidad());
		}
		
		return total;
	}

	@Override
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		this.carritoAlbumDAO.delete(carritoAlbum);
	}

	@Override
	public float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito) {
		
		this.carritoAlbumDAO.save(carritoAlbum);
		
		return this.calcularTotal(carrito);
	}

	@Override
	public boolean actualizarCarritoAlbum(List<CarritoAlbum> carritoAlbums, Factura factura) {
		boolean actualizados = false;
		
		//Se cambia el estatus de los productos a PAGADO y se asigna la fecha de compra y la factura
		for (CarritoAlbum carritoAlbum : carritoAlbums) {
			carritoAlbum.setEstatus("PAGADO");
			carritoAlbum.setFechaCompra(LocalDateTime.now());
			carritoAlbum.setFactura(factura);
		}
		
		Iterable<CarritoAlbum> carritosAcutalizados = this.carritoAlbumDAO.saveAll(carritoAlbums);
		
		carritosAcutalizados.forEach(ca -> {
			ca.getAlbum();
		});
		
		if (carritosAcutalizados != null) {
			
			actualizados = true;
		}
		
		return actualizados;
	}

}
