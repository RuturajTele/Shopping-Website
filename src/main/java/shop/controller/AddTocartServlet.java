package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.model.Cart;

/**
 * Servlet implementation class AddTocartServlet
 */
 @WebServlet("/add-to-cart")
public class AddTocartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out =response.getWriter()){
			ArrayList<Cart> cartList=new ArrayList<>();
			
			int prodId=Integer.parseInt(request.getParameter("prodId"));
			Cart cm=new Cart();
			cm.setProdId(prodId);
			cm.setQty(1);
			
			HttpSession session=request.getSession();
			ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-list");
			
			if(cart_list==null)
			{
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("Products.jsp");
			}else {
				cartList=cart_list;
				boolean exist=false;
				

				
				for(Cart c:cartList) {
					if(c.getProdId()==prodId) {
						exist=true;
						out.println("<h3 style='color:crimson; text-align:center'>Item already exits in cart.<a href='Cart.jsp'>Go to cart page</a></h3>");
					}
				}
				if(!exist){
					cartList.add(cm);
					response.sendRedirect("Products.jsp");
				}
			}
			
		}
			
			
			
			
		}
}


