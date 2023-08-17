/**
 * 
 */
package com.jmfer.tiendamusicalweb.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import com.jmfer.tiendamusicalentities.entities.Artista;
import com.jmfer.tiendamusicalentities.entities.Genero;
import com.jmfer.tiendamusicalentities.entities.Nacionalidad;
import com.jmfer.tiendamusicalentities.entities.SubGenero;
import com.jmfer.tiendamusicalservices.service.AdminArtistasService;
import com.jmfer.tiendamusicalweb.utils.CommonUtils;

/**
 * @author jmfer
 * Clase que controla el flujo de la pantalla de administracion de artistas
 */
@ManagedBean
@ViewScoped
public class AdminArtistasController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
	 */
	private static final Logger LOGGER = LogManager.getLogger(AdminArtistasController.class);
	
	/**
	 * Lista que permite mostrar los artistas en el detatable
	 */
	private List<Artista> artistas;
	
	/**
	 * Lista que permite filtrar los artistas en el detatable
	 */
	private List<Artista> artistasFiltrados;
	
	/**
	 * Lista que permite mostrar la lista de nacionalidades en el combo
	 */
	private List<Nacionalidad> nacionalidades;
	
	/**
	 * Lista que permite mostrar la lista de generos en el combo
	 */
	private List<Genero> generos;
	
	/**
	 * Lista que permite mostrar la lista de subgeneros en el combo
	 */
	private List<SubGenero> subGeneros;
	
	private Artista artista;
	
	/**
	 * Objeto que permite almacenar de forma temporal una imagen o archivo seleccionado
	 */
	private UploadedFile uploadedFile;
	
	/**
	 * Objeto con el contenido del archivo
	 */
	private InputStream inputStream;
	
	/**
	 * Objeto o Bean de Spring para utilizar los metodos de logica de negocio para la administracion de artistas
	 */
	@ManagedProperty("#{adminArtistasServiceImpl}")
	private AdminArtistasService adminArtistasServiceImpl;
	
	/**
	 * Direccion o path donde se guardan las imagenes de artistas
	 */
	private String absolutePath;
	
	/**
	 * Inicializa la pantalla de administracion de artistas
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Cargando la pantalla de administracion de artitas...");
		this.consultar();
		this.cargarCombos();
		this.limpiarComponentes();
		this.inicializarServicios();
	}
	
	/**
	 * Metodo que permite consultar la lista de artistas
	 */
	public void consultar() {
		this.artistas = this.adminArtistasServiceImpl.consultarArtistas();
	}
	
	/**
	 * Metodo que permite inicializar los combos de nacionalidades y generos
	 */
	public void cargarCombos() {
		this.nacionalidades = this.adminArtistasServiceImpl.consultarNacionalidades();
		this.generos = this.adminArtistasServiceImpl.consultarGeneros();
	}
	
	/**
	 * Metodo que permite limpiar o inicializar componentes
	 */
	public void limpiarComponentes() {
		this.artista = new Artista();
		this.artista.setNacionalidad(new Nacionalidad());
		this.artista.setSubGenero(new SubGenero());
		this.artista.getSubGenero().setGenero(new Genero());
	}
	
	/**
	 * Metodo que permite inicializar los servicios y la ruta donde se guardan las imagenes
	 */
	public void inicializarServicios() {
		String relativePath = "resources/imagenes/artistas";
		this.absolutePath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(relativePath);
	}
	
	/**
	 * Metodo que permite obtener la lista de subgeneros de musica por el genero seleccionado
	 */
	public void consultarSubGenerosPorGenero() {
		Long idGenero = this.artista.getSubGenero().getGenero().getIdGenero();
		this.subGeneros = this.adminArtistasServiceImpl.consultarSubGeneroPorGenero(idGenero);
	}
	
	/**
	 * Metodo que permite cargar la imagen seleccionada por el usuario
	 * @param fileUploadEvent
	 */
	public void handleFileUpload(FileUploadEvent fileUploadEvent) {
        this.uploadedFile = fileUploadEvent.getFile();
        
        try {
			this.inputStream = fileUploadEvent.getFile().getInputStream();
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "Hubo un problema al cargar el archivo, verifica que no esté corrupto");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que permite guardar un artista
	 */
	public void guardar() {
		
		try {
			CommonUtils.guardarImagen(this.absolutePath, this.uploadedFile.getFileName(), this.inputStream);
			this.artista.setImagen(this.uploadedFile.getFileName());
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "Hubo un error al guardar la imagen del artista, favor de intentarlo más tarde o contacta con soporte");
			e.printStackTrace();
		}
		
		Artista artistaGuardado = this.adminArtistasServiceImpl.guardarArtista(this.artista);
		
		if (artistaGuardado.getIdArtista() != null) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "OK!", "El artista " + this.artista.getNombre() + " se ha guardado o actualizado exitósamente");
			PrimeFaces.current().executeScript("PF('dlgArtista').hide()");
			this.limpiarComponentes();
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "Hubo un error al guardar el artista, favor de intentarlo más tarde o contacta con soporte");
		}
		
		this.consultar();
	}
	
	/**
	 * Metodo que permite cargar un artista seleccionado del datatable para actualizar el registro
	 * @param artista
	 */
	public void cargarArtista(Artista artista) {
		this.subGeneros = this.adminArtistasServiceImpl.consultarSubGeneroPorGenero(artista.getSubGenero().getGenero().getIdGenero());

		this.artista = artista;
	}
	
	/**
	 * @return the artistas
	 */
	public List<Artista> getArtistas() {
		return artistas;
	}

	/**
	 * @param artistas the artistas to set
	 */
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	/**
	 * @return the artistasFiltrados
	 */
	public List<Artista> getArtistasFiltrados() {
		return artistasFiltrados;
	}

	/**
	 * @param artistasFiltrados the artistasFiltrados to set
	 */
	public void setArtistasFiltrados(List<Artista> artistasFiltrados) {
		this.artistasFiltrados = artistasFiltrados;
	}

	/**
	 * @return the adminArtistasServiceImpl
	 */
	public AdminArtistasService getAdminArtistasServiceImpl() {
		return adminArtistasServiceImpl;
	}

	/**
	 * @param adminArtistasServiceImpl the adminArtistasServiceImpl to set
	 */
	public void setAdminArtistasServiceImpl(AdminArtistasService adminArtistasServiceImpl) {
		this.adminArtistasServiceImpl = adminArtistasServiceImpl;
	}

	/**
	 * @return the nacionalidades
	 */
	public List<Nacionalidad> getNacionalidades() {
		return nacionalidades;
	}

	/**
	 * @param nacionalidades the nacionalidades to set
	 */
	public void setNacionalidades(List<Nacionalidad> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	/**
	 * @return the generos
	 */
	public List<Genero> getGeneros() {
		return generos;
	}

	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	/**
	 * @return the subgeneros
	 */
	public List<SubGenero> getSubGeneros() {
		return subGeneros;
	}

	/**
	 * @param subgeneros the subgeneros to set
	 */
	public void setSubGeneros(List<SubGenero> subGeneros) {
		this.subGeneros = subGeneros;
	}

	/**
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
