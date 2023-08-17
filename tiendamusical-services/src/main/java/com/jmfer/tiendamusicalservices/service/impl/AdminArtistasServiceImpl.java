/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.ArtistaDAO;
import com.jmfer.tiendamusicaldata.dao.GeneroDAO;
import com.jmfer.tiendamusicaldata.dao.NacionalidadDAO;
import com.jmfer.tiendamusicaldata.dao.SubGeneroDAO;
import com.jmfer.tiendamusicalentities.entities.Artista;
import com.jmfer.tiendamusicalentities.entities.Disquera;
import com.jmfer.tiendamusicalentities.entities.Genero;
import com.jmfer.tiendamusicalentities.entities.Nacionalidad;
import com.jmfer.tiendamusicalentities.entities.SubGenero;
import com.jmfer.tiendamusicalservices.service.AdminArtistasService;

/**
 * @author jmfer
 * Clase que implementa los metods de logica de negocio para la administracion de artistas
 */
@Service
public class AdminArtistasServiceImpl implements AdminArtistasService {
	
	@Autowired
	private ArtistaDAO artistaDAOImpl;
	
	@Autowired
	private NacionalidadDAO nacionalidadDAOImpl;
	
	@Autowired
	private GeneroDAO generoDAOImpl;
	
	@Autowired
	private SubGeneroDAO subGeneroDAOImpl;
	
	@Override
	public List<Artista> consultarArtistas() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("nombre"));
		Page<Artista> page = this.artistaDAOImpl.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<Nacionalidad> consultarNacionalidades() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("descripcion"));
		Page<Nacionalidad> page = this.nacionalidadDAOImpl.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<Genero> consultarGeneros() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("descripcion"));
		Page<Genero> page = this.generoDAOImpl.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<SubGenero> consultarSubGeneroPorGenero(Long idGenero) {
        return this.subGeneroDAOImpl.findAllByGenero(idGenero);
	}

	@Override
	public Artista guardarArtista(Artista artista) {
		
		if (artista.getIdArtista() != null) {
			artista.setFechaActualizacion(LocalDateTime.now());
		} else {
			artista.setFechaCreacion(LocalDateTime.now());
			artista.setEstatus(true);
		}
		
		return this.artistaDAOImpl.save(artista);
	}

}
