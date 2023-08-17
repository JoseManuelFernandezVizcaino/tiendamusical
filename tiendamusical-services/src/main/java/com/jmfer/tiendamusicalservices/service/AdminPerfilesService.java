/**
 * 
 */
package com.jmfer.tiendamusicalservices.service;

import java.util.List;

import com.jmfer.tiendamusicalentities.entities.Rol;

/**
 * @author jmfer
 * Interface que contiene los metodos de logica de negocio para la pantalla de adminsitracion de perfiles
 */
public interface AdminPerfilesService {
	
	/**
	 * Metodo que permite consultar la lista de perfiles
	 * @return
	 */
	List<Rol> consultarPerfiles();
	
	/**
	 * Metodo que permite guardar un perfil.
	 * @param rol {@link Rol} objeto con el rol o perfil a guardar.
	 * @return {@link Rol} perfil o rol obtenido despues del guardado.
	 */
	Rol guardarPerfil(Rol rol);
}
