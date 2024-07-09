package shop.Dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shop.model.Cart;
import shop.model.Product;
import shop.model.Register;

public interface RegisterDao {
	int createRecord(List<Register> lst);
	boolean validateUser(String userName,String password);
	int createProduct(List<Product> lst);
	List<Product> DisplayAll();
	int deleteRecord(int prodId);
	List<Cart> getCartprod(ArrayList<Cart> cartlist);

}