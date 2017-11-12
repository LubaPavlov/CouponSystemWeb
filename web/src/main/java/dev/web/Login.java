package dev.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import com.project.exceptions.DAOException;
import com.project.exceptions.FacadeException;
import com.project.facade.CouponClientFacade;
import com.project.main.ClientType;
import com.project.main.CouponSystem;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponSystem system;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	// initiate CouponsSystem
	@Override
	public void init() throws ServletException {
		system = CouponSystem.getInstance();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if (session != null) {

			session.invalidate();
		}

		session = request.getSession(true); // create a new session

		// getting the parameters from the login.html form
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String clientType = request.getParameter("type");
		ClientType type = ClientType.valueOf(clientType); // convert String to ENUM

		CouponClientFacade facade = null;
		try {
			
			facade = system.login(username, password, type);
		} catch (LoginException | FacadeException | DAOException e) {
			
			response.getWriter().write(e.getMessage());
			System.out.println(e.getMessage());
		}

			if (facade != null) {

				session.setAttribute("facade", facade);
				// forward  to the right page according to the Client Type
				switch (type) {
				case ADMIN:
					
					response.sendRedirect("admin.html");
					//request.getRequestDispatcher("admin.html").forward(request, response);
					break;

				case COMPANY:
					
					//response.sendRedirect("company/company.html");
					request.getRequestDispatcher("company/company.html").forward(request, response);
					break;

				case CUSTOMER:
					request.getRequestDispatcher("customer/customer.html").forward(request, response);
					break;

				default:
					break;
				}
			}

			else {
				// return to the Login form if the user name or password are incorrect
				// request.getSession().setAttribute("facade", null);
				response.sendRedirect("login.html");
			}
	}
}
