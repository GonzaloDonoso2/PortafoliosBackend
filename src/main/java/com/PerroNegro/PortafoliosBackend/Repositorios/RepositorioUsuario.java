package com.PerroNegro.PortafoliosBackend.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.PerroNegro.PortafoliosBackend.Modelos.ModeloUsuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<ModeloUsuario, Integer> {
	
	ModeloUsuario findByCorreoElectronico(String correoElectronico);	
	ModeloUsuario findByCorreoElectronicoAndContrasenaAndEstado(String correoElectronico, String contrasena, String estado);
}
