/**
 * 
 */
package com.jmfer.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jmfer.tiendamusicaldata.dao.AlbumDAO;
import com.jmfer.tiendamusicalentities.dto.AlbumTopTenDTO;
import com.jmfer.tiendamusicalentities.entities.Album;
import com.jmfer.tiendamusicalservices.service.AlbumService;

/**
 * @author jmfer
 * Clase que implementa los metodos del contrata para la logica de negocio de albums
 */
@Service
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumDAO albumDAO;
	
	@Override
	public List<AlbumTopTenDTO> consultarAlbumsTopTen() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<AlbumTopTenDTO> page = this.albumDAO.consultarAlbumsTopTen(pageable);
		return page.getContent();
	}

	@Override
	public List<Album> consultarAlbums() {
		Pageable pageable = PageRequest.of(0, 20, Sort.by("nombre"));
		Page<Album> page = this.albumDAO.findAll(pageable);
		return page.getContent();
	}

}
