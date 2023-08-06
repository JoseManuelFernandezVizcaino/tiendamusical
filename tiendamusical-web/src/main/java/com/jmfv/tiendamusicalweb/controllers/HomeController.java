/**
 * 
 */
package com.jmfv.tiendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.jmfv.tiendamusicalservices.service.HomeService;

/**
 * @author jmfer
 * Clase que controla el flujo de informacion para la pantalla de home de cualquier tipo de usuario
 */

@ManagedBean
@ViewScoped
public class HomeController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	
	/**
	 * Texto ingresado por el cliente en el buscador
	 */
	private String filtro;
	
	/**
	 * Lista obtenida a partir del fultro ingresado en el buscador
	 */
	private List<ArtistaAlbumDTO> artistaAlbumDTO;
	
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	
	@PostConstruct
	public void init() {
		LOGGER.info("INFOR");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		LOGGER.fatal("FATAL");
	}
	
	/**
	 * Metodo que permite obtener los albums de los artistas encontrados en la BD con respecto
	 * al filtro ingresado por el cliente
	 */
	public void consultarAlbumsArtistaPorFiltro() {
		this.artistaAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistaAlbumDTO != null) {
			this.artistaAlbumDTO.forEach(artistaAlbumDTO -> {
				LOGGER.info("Artista: "+ artistaAlbumDTO.getArtista().getNombre());
			});
		}
	}

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	/**
	 * @return the artistaAlbumDTO
	 */
	public List<ArtistaAlbumDTO> getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	/**
	 * @param artistaAlbumDTO the artistaAlbumDTO to set
	 */
	public void setArtistaAlbumDTO(List<ArtistaAlbumDTO> artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}

	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}

	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
	}
}
