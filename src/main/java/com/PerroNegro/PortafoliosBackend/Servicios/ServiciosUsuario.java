package com.PerroNegro.PortafoliosBackend.Servicios;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PerroNegro.PortafoliosBackend.Modelos.ModeloUsuario;
import com.PerroNegro.PortafoliosBackend.Modelos.ModeloUsuarioDTO;
import com.PerroNegro.PortafoliosBackend.Repositorios.RepositorioUsuario;

@Service
public class ServiciosUsuario {
	
	@Autowired
	RepositorioUsuario repositorioUsuario;	

	public ModeloUsuarioDTO registrarUsuario(ModeloUsuario usuario) {
		
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();
		
		try {
			
			ModeloUsuario provisorioUsuario = repositorioUsuario.findByCorreoElectronico(usuario.getCorreoElectronico());
			
			if (provisorioUsuario != null) {
				
				respuestaUsuarioDTO.setRespuesta("El correo electrónico del usuario fue registrado anteriormente en la  Base de Datos.");
				return respuestaUsuarioDTO;
			} 	
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al validar el correo electrónico : " + exception.getMessage());
			return respuestaUsuarioDTO;
		}
		
		try {
			
			LocalDate fechaRegistro = LocalDate.now();
	        Date fechaFormatoSQL = Date.valueOf(fechaRegistro);
	        usuario.setFechaRegistro(fechaFormatoSQL);	
	        usuario.setEstado("VIGENTE");
			repositorioUsuario.save(usuario);			
			respuestaUsuarioDTO.setRespuesta("El usuario fue registrado de manera exitosa en la Base de Datos.");			
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al registrar al usuario: " + exception.getMessage());				
		}
		
		return respuestaUsuarioDTO;
	};
	
	public ModeloUsuarioDTO iniciarSesion(String correoElectronico, String contrasena) {
		
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();
		
		try {
			
			String estado = "VIGENTE";
			List<ModeloUsuario> usuario = (List<ModeloUsuario>) repositorioUsuario.findByCorreoElectronicoAndContrasenaAndEstado(correoElectronico, contrasena, estado);
			
			if (usuario != null) {
				
				respuestaUsuarioDTO.setRespuesta("El usuario si está registrado en la Base de Datos.");	
				respuestaUsuarioDTO.setListaUsuarios(usuario);
				
			} else {
				
				respuestaUsuarioDTO.setRespuesta("El usuario no está registrado en la Base de Datos.");						
			}				
			
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al iniciar sesión: " + exception.getMessage());
		}
		
		return respuestaUsuarioDTO;
	};
	
	public ModeloUsuarioDTO buscarUsuarioPorId(int id) {
			
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();
		
		try {			
				
			ModeloUsuario usuario = repositorioUsuario.findById(id).orElse(null);
			List<ModeloUsuario> listaUsuarios = new ArrayList<>();
			listaUsuarios.add(usuario);
			respuestaUsuarioDTO.setListaUsuarios(listaUsuarios);
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al buscar al usuario: " + exception.getMessage());
		}
		
		return respuestaUsuarioDTO ;
	};
	
	public ModeloUsuarioDTO editarUsuario(ModeloUsuario usuario) {
		
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();
		ModeloUsuario anteriorUsuario = new ModeloUsuario();
		
		try {			
			
			anteriorUsuario = repositorioUsuario.findById(usuario.getId()).orElse(null);
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al buscar al usuario: " + exception.getMessage());
			return respuestaUsuarioDTO;
		}
		
		if (!anteriorUsuario.getCorreoElectronico().equals(usuario.getCorreoElectronico())) {
			
			try {
				
				ModeloUsuario provisorioUsuario = repositorioUsuario.findByCorreoElectronico(usuario.getCorreoElectronico());
				
				if (provisorioUsuario != null) {
					
					respuestaUsuarioDTO.setRespuesta("El correo electrónico del usuario fue registrado anteriormente en la  Base de Datos.");
					return respuestaUsuarioDTO;
				} 	
				
			} catch (Exception exception) {
				
				respuestaUsuarioDTO.setRespuesta("Se produjo un error al validar el correo electrónico : " + exception.getMessage());
				return respuestaUsuarioDTO;
			}
		}
		
		try {	
			
			repositorioUsuario.save(usuario);	
			respuestaUsuarioDTO.setRespuesta("Los datos del usuario fueron editados de manera exitosa en la Base de Datos.");	
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al editar al usuario: " + exception.getMessage());	
			
		}
		
		return respuestaUsuarioDTO;	
	}
	
	public ModeloUsuarioDTO deshabilitarUsuario(int id) {
		
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();		
				
		try {			
			
			ModeloUsuario usuario = repositorioUsuario.findById(id).orElse(null);	
			usuario.setEstado("NO VIGENTE");
			repositorioUsuario.save(usuario);
			respuestaUsuarioDTO.setRespuesta("El usuario fue deshabilitado de manera exitosa en la Base de Datos.");		
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al deshabilitar al usuario: " + exception.getMessage());	
		}
		
		return respuestaUsuarioDTO;
	}
	
	public ModeloUsuarioDTO buscarUsuarios() {
		
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();		
		
		try {			
			
			List<ModeloUsuario> usuario = (List<ModeloUsuario>) repositorioUsuario.findAll();
			respuestaUsuarioDTO.setListaUsuarios(usuario);
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al buscara los usuario: " + exception.getMessage());	
		}		
		
		return respuestaUsuarioDTO;
	}
	
	public ModeloUsuarioDTO borrarUsuario(int id) {
		
		ModeloUsuarioDTO respuestaUsuarioDTO = new ModeloUsuarioDTO();			
				
		try {			
			
			repositorioUsuario.deleteById(id);
			respuestaUsuarioDTO.setRespuesta("El usuario fue borrado de manera exitosa en la Base de Datos.");		
			
		} catch (Exception exception) {
			
			respuestaUsuarioDTO.setRespuesta("Se produjo un error al borrar al usuario: " + exception.getMessage());	
		}
		
		return respuestaUsuarioDTO;
	}
}
