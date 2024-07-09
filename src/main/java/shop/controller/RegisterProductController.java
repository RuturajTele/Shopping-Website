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
import shop.model.Product;
import shop.model.Register;

/**
 * Servlet implementation class RegisterProductController
 */
public class RegisterProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		String prodDesc=request.getParameter("prodDesc");
		Double prodPrice=Double.parseDouble(request.getParameter("prodPrice"));
		String prodImg=request.getParameter("prodImg");
		Product regobj=new Product(prodId,prodName, prodDesc,prodPrice, prodImg);
		
		
		RegisterDao regdao=new RegisterDapImpl();
		List<Product> lstprod=new ArrayList<Product>();
		lstprod.add(regobj);
		int i=regdao.createProduct(lstprod);
		if(i>0) {
			response.sendRedirect("Products.jsp");
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
