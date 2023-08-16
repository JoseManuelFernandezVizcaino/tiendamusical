/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import java.util.List;

import com.jmfer.tiendamusicalentities.entities.Album;
import com.jmfer.tiendamusicalentities.entities.Artista;
import com.jmfer.tiendamusicalentities.entities.Disquera;

/**
 * @author jmfer
 * Interface que permite realizar la logica de negocio para la administracion de albums
 */
public interface AdminAlbumsService {
	
	/**
	 * Metodo que permite consultar el catalago de disqueras
	 * @return
	 */
	List<Disquera> consultarDisqueras();
	
	/**
	 * Metodo que permite consultar el catalago de artistas
	 * @return
	 */
	List<Artista> consultarArtistas();
	
	/**
	 * Metodo que permite guardar un album
	 * @param album
	 * @return
	 */
	Album guardarAlbum(Album album);
}
