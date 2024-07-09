package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Dao.RegisterDao;
import shop.Dao.RegisterDapImpl;
import shop.model.Cart;
import shop.model.Product;

/**
 * Servlet implementation class CartController
 */

public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve product ID from request parameter
            int prodId = Integer.parseInt(request.getParameter("prodId"));

            // Create a new cart item
            Cart newItem = new Cart();
            newItem.setProdId(prodId);
            newItem.setQty(1);

            // Get the session
            HttpSession session = request.getSession(true);

            // Retrieve cart list from session
            List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");

            // If cart list doesn't exist in session, create a new one
            if (cartList == null) {
                cartList = new ArrayList<>();
            }

            // Add the new item to the cart list
            cartList.add(newItem);

            // Update the cart list in the session
            session.setAttribute("cartList", cartList);

            // Provide feedback to the user
            out.println("Product added to cart successfully.");
        } catch (NumberFormatException e) {
            // Handle invalid product ID
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID.");
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
