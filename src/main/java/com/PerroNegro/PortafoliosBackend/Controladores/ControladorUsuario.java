package com.PerroNegro.PortafoliosBackend.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.PerroNegro.PortafoliosBackend.Modelos.ModeloUsuario;
import com.PerroNegro.PortafoliosBackend.Modelos.ModeloUsuarioDTO;
import com.PerroNegro.PortafoliosBackend.Servicios.ServiciosUsuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/usuarios"})
public class ControladorUsuario {
	
	@Autowired
	ServiciosUsuario serviciosUsuario;
		
	@PostMapping()
	public ModeloUsuarioDTO registrarUsuario(@RequestBody ModeloUsuario usuario) {
		
		ModeloUsuarioDTO respuesta = this.serviciosUsuario.registrarUsuario(usuario);
		return respuesta;		
	}
	
	@PostMapping("/iniciarsesion")
	public ModeloUsuarioDTO iniciarSesion(String correoElectronico, String contrasena) {
	    ModeloUsuarioDTO respuesta = this.serviciosUsuario.iniciarSesion(correoElectronico, contrasena);
	    return respuesta;
	}

	
	@GetMapping(path = {"/{id}"})
	public ModeloUsuarioDTO obtenerUsuario(@PathVariable("id") int id) {
		
		ModeloUsuarioDTO respuesta = this.serviciosUsuario.buscarUsuarioPorId(id);
		return respuesta;
	}	
		
	@PutMapping()
	public ModeloUsuarioDTO editarUsuario(@RequestBody ModeloUsuario usuario) {
		
		ModeloUsuarioDTO respuesta = this.serviciosUsuario.editarUsuario(usuario);
		return respuesta;		
	}
	
	@PutMapping(path = {"/{id}"})
	public ModeloUsuarioDTO desahabilitarUsuario(@PathVariable("id") int id) {
		
		ModeloUsuarioDTO respuesta = this.serviciosUsuario.deshabilitarUsuario(id);
		return respuesta;
	}	
	
	@GetMapping()
	public ModeloUsuarioDTO obtenerUsuarios() {
		
		ModeloUsuarioDTO respuesta = this.serviciosUsuario.buscarUsuarios();	
		return respuesta;
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ModeloUsuarioDTO borrarUsuario(@PathVariable("id") int id) {
		
		ModeloUsuarioDTO respuesta = this.serviciosUsuario.borrarUsuario(id);
		return respuesta;
	}	
}
