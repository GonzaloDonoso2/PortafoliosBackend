package com.PerroNegro.PortafoliosBackend.Modelos;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "usuarios")
public class ModeloUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "correo_electronico")
	private String correoElectronico;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "estado")
	private String estado;
	
	@Transient
	private String provisoriaFechaIngreso;

	public ModeloUsuario() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProvisoriaFechaIngreso() {
		return provisoriaFechaIngreso;
	}

	public void setProvisoriaFechaIngreso(String provisoriaFechaIngreso) {
		this.provisoriaFechaIngreso = provisoriaFechaIngreso;
	}
}
