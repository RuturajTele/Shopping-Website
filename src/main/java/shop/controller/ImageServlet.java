package shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String prodName = request.getParameter("prodName");

	        // TODO: Retrieve the image data (byte array) for the specified image based on the image ID.
	        byte[] imageData = getImageDataForImage(prodName);

	        if (imageData != null) {
	            // Set the content type for the image (e.g., "image/jpeg").
	            response.setContentType("/ShoppingAppProject/image"); // Change to the appropriate content type.

	            // Write the image data to the response output stream.
	            response.getOutputStream().write(imageData);
	        } else {
	            // If the image data is not found, you can display a default image or return an error image.
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	}

	private byte[] getImageDataForImage(String prodImg) {
        // Your database or data source logic to get the image data for the image goes here.
        // You may need to adjust this based on your actual data storage and retrieval method.
        // For demonstration purposes, you can hardcode image data for specific image IDs.
        if ("prodName".equals(prodImg)) {
            // Example: Convert a base64-encoded image to a byte array.
            String base64Image = "base64_encoded_image_data_here";
            return Base64.getDecoder().decode(base64Image);
        } else {
            // Handle other image IDs or return null if not found.
            return null;
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
