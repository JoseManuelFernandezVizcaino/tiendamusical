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

import com.jmfer.tiendamusicaldata.dao.AlbumDAO;
import com.jmfer.tiendamusicaldata.dao.ArtistaDAO;
import com.jmfer.tiendamusicaldata.dao.DisqueraDAO;
import com.jmfer.tiendamusicalentities.entities.Album;
import com.jmfer.tiendamusicalentities.entities.Artista;
import com.jmfer.tiendamusicalentities.entities.Disquera;
import com.jmfer.tiendamusicalservices.service.AdminAlbumsService;

/**
 * @author jmfer
 * Clase que implementa los metodos de la logica de negocio para la administracion de albums
 */
@Service
public class AdminAlbumsServiceImpl implements AdminAlbumsService {
	
	@Autowired
	private ArtistaDAO artistaDAOImpl;
	
	@Autowired
	private DisqueraDAO disqueraDAOImpl;
	
	@Autowired
	private AlbumDAO albumDAOImpl;
	
	@Override
	public List<Disquera> consultarDisqueras() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("descripcion"));
		Page<Disquera> page = this.disqueraDAOImpl.findAll(pageable);
		return page.getContent();
	}

	@Override
	public List<Artista> consultarArtistas() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("nombre"));
		Page<Artista> page = this.artistaDAOImpl.findAll(pageable);
		return page.getContent();
	}

	@Override
	public Album guardarAlbum(Album album) {
		
		if (album.getIdAlbum() != null) {
			album.setFechaActualizacion(LocalDateTime.now());
		}else {
			album.setFechaCreacion(LocalDateTime.now());
			album.setEstatus(true);
		}
		
		return this.albumDAOImpl.save(album);
	}

}
