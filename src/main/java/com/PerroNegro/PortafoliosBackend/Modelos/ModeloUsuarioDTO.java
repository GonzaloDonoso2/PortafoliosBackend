package com.PerroNegro.PortafoliosBackend.Modelos;

import java.util.List;

public class ModeloUsuarioDTO {
	
	private String respuesta;
	private List<ModeloUsuario> listaUsuarios;
	
	public ModeloUsuarioDTO() {}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public List<ModeloUsuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<ModeloUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
