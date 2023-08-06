/**
 * 
 */
package com.jmfv.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmfv.tiendamusicaldata.dao.ArtistaDAO;
import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfv.tiendamusicalservices.service.HomeService;

/**
 * @author jmfer
 * Clase que implementa los metodos de logica de negocio de la interface de LoginService
 */
@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private ArtistaDAO artistaDAOImpl;

	@Override
	public List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro) {
		return this.artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
