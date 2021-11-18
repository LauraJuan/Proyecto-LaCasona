package es.eoi.controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import es.eoi.modelo.*;

/**
 * 
 * Servlet implementation class Altas
 * 
 */
@WebServlet("/Altas")
public class Altas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public Altas() {
		super();
	}
	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteDAO cdao = new ClienteDAO();
		
		
		String opcion = request.getParameter("opcion");
		String pagina = "login.jsp";
		HttpSession sesion = request.getSession();
		String msginfo = "";

		try {
			

				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String dni = request.getParameter("dni");
				int tel = Integer.parseInt(request.getParameter("tel"));
				String email = request.getParameter("email");
				String rol = request.getParameter("rol");
				String pass = request.getParameter("pass");

				Cliente clie = new Cliente();
				clie.setNombre(nombre);
				clie.setApellidos(apellidos);
				clie.setDni(dni);
				clie.setTel(tel);
				clie.setEmail(email);
				clie.setRol(rol);
				clie.setPass(pass);

				cdao.addCliente(clie);

				msginfo = "Alta de cliente " + clie.getNombre() + " " + clie.getApellidos() + " - " + clie.getRol()
						+ " OK";

				request.setAttribute("msginfo", msginfo);
				
				
				
				

		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);

	}

}