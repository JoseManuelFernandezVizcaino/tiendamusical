/**
 * 
 */
package com.jmfv.tiendamusicaldata.dao.impl;

import java.util.List;

import com.jmfv.tiendamusicaldata.common.CommonDAO;
import com.jmfv.tiendamusicaldata.dao.ArtistaDAO;
import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfv.tiendamusicalentities.entities.Artista;

/**
 * @author jmfer
 * Clase que implementa el CRUD Generico para realizar las transacciones a la tabla de artista.
 */
public class ArtistaDAOImpl extends CommonDAO<Artista, ArtistaDAO> {

	public List<ArtistaAlbumDTO> consultarArtistaAlbumsPorFiltro(String filtro) {
		return this.repository.consultarArtistaAlbumsPorFiltro(filtro);
	}
}

