/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.PersonaDAO;
import com.jmfer.tiendamusicalentities.entities.Persona;
import com.jmfer.tiendamusicalservices.service.LoginService;

/**
 * @author jmfer
 * Clase que implementa las funciones para la logica de negocio para la pantalla de login.
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private PersonaDAO personaDAO;
	
	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		return this.personaDAO.findByUsuarioAndPassword(usuario, password);
	}

}
