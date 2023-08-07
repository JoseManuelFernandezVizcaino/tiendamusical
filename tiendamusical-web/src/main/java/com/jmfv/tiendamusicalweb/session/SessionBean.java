/**
 * 
 */
package com.jmfv.tiendamusicalweb.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;
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
	
	/**
	 * Objeto que contendrá la informacion del detalle del album seleccionado por el cliente
	 */
	private ArtistaAlbumDTO artistaAlbumDTO;
	
	/**
	 * Total generado de la compra en sesion
	 */
	private float totalCompra;
	
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

	/**
	 * @return the artistaAlbumDTO
	 */
	public ArtistaAlbumDTO getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	/**
	 * @param artistaAlbumDTO the artistaAlbumDTO to set
	 */
	public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}

	/**
	 * @return the totalCompra
	 */
	public float getTotalCompra() {
		return totalCompra;
	}

	/**
	 * @param totalCompra the totalCompra to set
	 */
	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}
	
}
