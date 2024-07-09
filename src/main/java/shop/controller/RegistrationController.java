package shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Dao.RegisterDao;
import shop.Dao.RegisterDapImpl;
import shop.model.Register;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=request.getParameter("emailId");
		String custName=request.getParameter("custName");
		String userName=request.getParameter("userName");
		String mobNo=request.getParameter("mobNo");
		String password=request.getParameter("password");

		Register regobj=new Register(emailId, custName, userName, mobNo, password);
		RegisterDao regdao=new RegisterDapImpl();
		List<Register> lstreg=new ArrayList<Register>();
		lstreg.add(regobj);
		int i=regdao.createRecord(lstreg);
		if(i>0) {
			response.sendRedirect("LoginView.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
