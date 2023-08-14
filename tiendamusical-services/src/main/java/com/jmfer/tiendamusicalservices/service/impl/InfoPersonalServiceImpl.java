/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.PersonaDAO;
import com.jmfer.tiendamusicalentities.entities.Persona;
import com.jmfer.tiendamusicalservices.service.InfoPersonalService;

/**
 * @author jmfer
 *
 */
@Service
public class InfoPersonalServiceImpl implements InfoPersonalService {
	
	@Autowired
	private PersonaDAO personaDaoImpl;
	
	@Override
	public Persona actualizarPersona(Persona persona) {
		persona.setFechaActualizacion(LocalDateTime.now());
		
		return this.personaDaoImpl.save(persona);
	}

}
