/**
 * 
 */
package com.jmfv.tiendamusicalweb.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jmfv.tiendamusicalentities.entities.Persona;

/**
 * @author jmfer
 * Clase que mantendrá la información en la sesion del usuario
 */
@ManagedBean
@SessionScoped
public class SessionBean {
	
	/**
	 * Objeto persona que se mantendra en la sesion.
	 */
	private Persona persona;
	
	public void init() {
		System.out.println("Creando sesion...");
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
