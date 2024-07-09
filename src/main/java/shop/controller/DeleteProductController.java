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
 * Servlet implementation class DeleteProductController
 */
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		RegisterDao regdao=new RegisterDapImpl();
		int i=regdao.deleteRecord(prodId);
        HttpSession session=request.getSession();
		
		if(i>0)
		{
			session.setAttribute("data",regdao);
			response.sendRedirect("Deleteproduct.jsp");
			//Register reg=lstreg.get(0);
			//System.out.println(reg.getRegNo()+"\t"+reg.getCustName());
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
