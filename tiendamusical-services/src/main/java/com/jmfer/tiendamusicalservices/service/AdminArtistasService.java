/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import java.util.List;

import com.jmfer.tiendamusicalentities.entities.Album;
import com.jmfer.tiendamusicalentities.entities.Artista;
import com.jmfer.tiendamusicalentities.entities.Disquera;
import com.jmfer.tiendamusicalentities.entities.Genero;
import com.jmfer.tiendamusicalentities.entities.Nacionalidad;
import com.jmfer.tiendamusicalentities.entities.SubGenero;

/**
 * @author jmfer
 * Interface que contiene los metodos de logica de negocio para la administracion de artistas
 */
public interface AdminArtistasService {
	
	/**
	 * Metodo que permite consultar la lista de artistas
	 * @return
	 */
	List<Artista> consultarArtistas();
	
	/**
	 * Metodo que permite consultar el listado de nacionalidades
	 * @return
	 */
	List<Nacionalidad> consultarNacionalidades();
	
	/**
	 * Metodo que permite consultar el listado de generos
	 * @return
	 */
	List<Genero> consultarGeneros();
	
	/**
	 * Metodo que permite consultar el listado de subgeneros
	 * @param idGenero
	 * @return
	 */
	List<SubGenero> consultarSubGeneroPorGenero(Long idGenero);
	
	/**
	 * Metodo que permite guardar un artista en la base de datos
	 * @param artista
	 * @return
	 */
	Artista guardarArtista(Artista artista);
}
