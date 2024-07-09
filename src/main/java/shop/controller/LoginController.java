package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Dao.RegisterDao;
import shop.Dao.RegisterDapImpl;



/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        RegisterDao regdao = new RegisterDapImpl();
        boolean isAuthenticated = regdao.validateUser(userName, password);
        HttpSession session = request.getSession();
        if (isAuthenticated) {
            // Set attribute to indicate successful login
            session.setAttribute("authenticated", true);
            // Redirect to Home.jsp page
            response.sendRedirect("Home.jsp");
        } else {
            // Redirect to login page with parameter indicating login failure
            response.sendRedirect("LoginView.jsp?loginFailed=true");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

