/**
 * 
 */
package com.jmfv.tiendamusicaldata.dao.impl;

import com.jmfv.tiendamusicalentities.entities.Persona;
import com.jmfv.tiendamusicaldata.common.CommonDAO;
import com.jmfv.tiendamusicaldata.dao.PersonaDAO;

/**
 * @author jmfer
 * Clase que implementa el CRUD Generico y las funciones de la interface de PersonaDAO.
 */
public class PersonaDAOImpl extends CommonDAO<Persona, PersonaDAO> {
	/**
	 * Metodo permite consultar una persona por su usuario y contraseña.
	 * @param usuario {@link String} usuario capturado por la persona.
	 * @param password {@link String} contraseña capturada por la persona. 
	 * @return {@link Persona} persona encontrada.
	 */
	public Persona findUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}
}
