/**
 * 
 */
package com.jmfer.tiendamusicalservices.enums;

/**
 * @author jmfer
 * Enumeración pera los perfiles del sistema
 */
public enum RolEnum {
	
	CLIENTE(4, "CLIENTE"),
	
	ADMINISTRADOR(3, "ADMINISTRADOR");
	
	/**
	 * Clave del perfil
	 */
	private long clave;
	
	/**
	 * Descripcion del perfil
	 */
	private String descripcion;
	
	/**
	 * Constructor que inicializa las claves y descripciones de los datos de enumaracion para 
	 * los perfiles del sistema
	 * @param clave
	 * @param descripcion
	 */
	private RolEnum(int clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
	}

	/**
	 * @return the clave
	 */
	public long getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(long clave) {
		this.clave = clave;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
