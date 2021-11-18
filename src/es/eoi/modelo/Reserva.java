package es.eoi.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.eoi.servicios.Conexion;

public class Reserva {
	
	
	private  int idreserva;
	private String fecha_reserva;
	private String fecha_entrada;
	private String fecha_salida;
	private int num_personas;
	private float preciotot;
	private int cliente_id;
	private int habitacion_n;
	private String tipo;
	private String extra;
	
	
	public Reserva () {
		
	}


	public Reserva(int idreserva, String fecha_reserva, String fecha_entrada, String fecha_salida, int num_personas,
			float preciotot, int cliente_id, int habitacion_n, String tipo, String extra) {
		super();
		this.idreserva = idreserva;
		this.fecha_reserva = fecha_reserva;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.num_personas = num_personas;
		this.preciotot = preciotot;
		this.cliente_id = cliente_id;
		this.habitacion_n = habitacion_n;
		this.tipo = tipo;
		this.extra = extra;
	}


	public int getIdreserva() {
		return idreserva;
	}


	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}


	public String getFecha_reserva() {
		return fecha_reserva;
	}


	public void setFecha_reserva(String fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}


	public String getFecha_entrada() {
		return fecha_entrada;
	}


	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	public String getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public int getNum_personas() {
		return num_personas;
	}


	public void setNum_personas(int num_personas) {
		this.num_personas = num_personas;
	}


	public float getPreciotot() {
		return preciotot;
	}


	public void setPreciotot(float preciotot) {
		this.preciotot = preciotot;
	}


	public int getCliente_id() {
		return cliente_id;
	}


	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}


	public int getHabitacion_n() {
		return habitacion_n;
	}


	public void setHabitacion_n(int habitacion_n) {
		this.habitacion_n = habitacion_n;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getExtra() {
		return extra;
	}


	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Reserva [idreserva=" + idreserva + ", fecha_reserva=" + fecha_reserva + ", fecha_entrada="
				+ fecha_entrada + ", fecha_salida=" + fecha_salida + ", num_personas=" + num_personas + ", preciotot="
				+ preciotot + ", cliente_id=" + cliente_id + ", habitacion_n=" + habitacion_n + ", tipo=" + tipo
				+ ", extra=" + extra + "]";
	}

	
}