/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import java.util.List;

import com.jmfer.tiendamusicalentities.dto.AlbumTopTenDTO;
import com.jmfer.tiendamusicalentities.entities.Album;

/**
 * @author jmfer
 * Interface que contiene los metodos de la logica de negocio de los albums
 */
public interface AlbumService {
	
	/**
	 * Metodo que permite consultar la lista de albums en el top ten de mas vendidos
	 * @return
	 */
	List<AlbumTopTenDTO> consultarAlbumsTopTen();
	
	/**
	 * Metodo que permite consultar el listado de albums
	 * @return
	 */
	List<Album> consultarAlbums();
}
