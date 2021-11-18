package es.eoi.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.eoi.servicios.Conexion;

public class OperacionesDAO {

	private static Connection con;
	private static ResultSet rs;
	private static PreparedStatement pst;
	private static PreparedStatement pst1;
	private static PreparedStatement pst2;

	private static HabitacionDAO hadao;

	// realiza la op de reserva en la bbdd
	// dara el alta del registro en la tabla de reserva y actualizara el dato en
	// tabla Habitacion

	public static int reserva(String fecha_reserva, String fecha_entrada, String fecha_salida, int num_personas,
			int cliente_id, String tipohab,String extra) throws SQLException {
		System.out.println(fecha_reserva);
		System.out.println(fecha_entrada);
		System.out.println(fecha_salida);
		System.out.println(num_personas);
		System.out.println(cliente_id);
		System.out.println(tipohab);
		System.out.println(extra);
		

		int ret = 1;
		Date fechaEntrada = null;
		Date fechaSalida = null;
		int costo;
		float preciotot = 0;
		int habitacion_n = 0;

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaEntrada = formatoDelTexto.parse(fecha_entrada);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fechaSalida = formatoDelTexto.parse(fecha_salida);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int dias = (int) ((fechaSalida.getTime() - fechaEntrada.getTime()) / 86400000);

		con = Conexion.getInstance().getConnection();
		String sql1 = "INSERT INTO reserva(fecha_reserva,fecha_entrada,fecha_salida,num_personas,preciotot,cliente_id,habitacion_n,tipo, extra)VALUES(?,?,?,?,?,?,?,?,?)";
		String sql2 = "UPDATE habitacion SET disponibilidad=? WHERE n_habitacion=?";
		String sql = "SELECT * FROM habitacion WHERE disponibilidad=? AND tipo=?";
		String sql3 = "SELECT * FROM reserva WHERE fecha_salida<=? AND tipo=?";

		

		// tabla habitacion tipo

		pst = con.prepareStatement(sql);
		pst.setString(1, "disponible");
		pst.setString(2, tipohab);

		rs = pst.executeQuery();

		// Solo se mete si hay disponibilidad
		if (rs.next()) {
			habitacion_n = rs.getInt(1);
		}
		//si NO hay habitacion disponible
		if(habitacion_n == 0){
			pst = con.prepareStatement(sql3);
			pst.setString(1, fecha_salida);
			pst.setString(2, tipohab);

			rs = pst.executeQuery();
			if(rs.next()){
				habitacion_n = rs.getInt(1);
				
			}
			
		} 
		//si si que hay habitacion disponible
		if (habitacion_n != 0) {
			
			if (tipohab.equals("individual")) {
				costo = 25;
				preciotot = (float) (costo * dias);
			} else if (tipohab.equals("matrimonial")) {
				costo = 50;
				preciotot = (float) (costo * dias);
				
			} else if (tipohab.equals("doble")) {
				costo = 55;
				preciotot = (float) (costo * dias);
			} else {
				costo = 0;
			}

			// reservas tabla

			pst1 = con.prepareStatement(sql1);
			pst1.setString(1, fecha_reserva);
			pst1.setString(2, fecha_entrada);
			pst1.setString(3, fecha_salida);
			pst1.setInt(4, num_personas);
			pst1.setFloat(5, preciotot);
			pst1.setInt(6, cliente_id);
			pst1.setInt(7, habitacion_n);
			pst1.setString(8, tipohab);
			pst1.setString(9, extra);
			
			

			ret = pst1.executeUpdate();

			// tabla habitacion
			if (ret == 1) {
				

				pst2 = con.prepareStatement(sql2);

				pst2.setString(1, "ocupada");
				pst2.setInt(2, habitacion_n);
	

				pst2.executeUpdate(); // que devuelva una fila afectada

				}
		}

		return ret;

	}

	public static boolean anularReserva(int cliente_id, int habitacion_n) throws SQLException {

		boolean anu = false;
		con = Conexion.getInstance().getConnection();

		String sql = "DELETE FROM reserva WHERE cliente_id=? AND habitacion_n=?";// borrar la reserva
		String sql1 = "UPDATE habitacion SET disponibilidad=? WHERE n_habitacion";// actualizar la bdd

		// tabla reserva borrar
		pst = con.prepareStatement(sql);
		pst.setInt(1, cliente_id);
		pst.setInt(2, habitacion_n);
		pst.executeUpdate();

		// tabla habitacion actualizando
		hadao = new HabitacionDAO();
		Habitacion hab = hadao.getHabitacion(habitacion_n);
		pst2 = con.prepareStatement(sql1);
		pst2.setString(1, hab.getDisponibilidad() + 1);
		pst2.setInt(2, habitacion_n);
		pst2.executeUpdate();

		return anu;

	}
public static List<Reserva> getReservaOfCliente(int cliente_id) throws SQLException {

		

		con = Conexion.getInstance().getConnection();

		String sql = "SELECT * FROM reserva WHERE cliente_id = ?";



		pst = con.prepareStatement(sql);

		pst.setInt(1, cliente_id);

		rs = pst.executeQuery();



		Reserva r = null;

		List<Reserva> lista = new ArrayList<Reserva>();



		while (rs.next()) {

			r = new Reserva();

			r.setFecha_reserva(rs.getString("fecha_reserva"));

			r.setFecha_entrada(rs.getString("fecha_entrada"));

			r.setFecha_salida(rs.getString("fecha_salida"));

			r.setNum_personas(rs.getInt("num_personas"));

			r.setCliente_id(rs.getInt("cliente_id"));

			r.setTipo(rs.getString("tipo"));

			r.setExtra(rs.getString("extra"));

			lista.add(r);

			

		}

		return lista;



	}
	

}