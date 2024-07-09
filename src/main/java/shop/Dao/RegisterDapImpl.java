package shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shop.Db.ShopDbConnection;
import shop.model.Cart;
import shop.model.Product;
import shop.model.Register;

public class RegisterDapImpl implements RegisterDao {

	ShopDbConnection shopdao=new ShopDbConnection();
	
	public int createRecord(List<Register> lstreg) {

		Register regobj=lstreg.get(0);
		int i=0;
		Connection con=null;
		try {
			con=shopdao.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("insert into Registershop (Email_id,Cust_name,User_name,Mob_No,Password) values(?,?,?,?,?)");
			pstate.setString(1,regobj.getEmailId());
			pstate.setString(2,regobj.getCustName());
			pstate.setString(3,regobj.getUserName());
			pstate.setString(4,regobj.getMobNo());
			pstate.setString(5,regobj.getPassword());
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return i;
	}

	@Override
	public boolean validateUser(String userName, String password) {
	    Connection con = shopdao.getDbConnection();
	    boolean isValidUser = false;
	    try {
	        PreparedStatement pstate = con.prepareStatement("SELECT * FROM registershop WHERE User_name=? AND Password=?");
	        pstate.setString(1, userName);
	        pstate.setString(2, password);
	        ResultSet result = pstate.executeQuery(); 
	        if (result.next()) {
	            isValidUser = true;
	        }
	    } catch (SQLException e) {
	        // Handle SQLException (printing stack trace for now)
	        e.printStackTrace();
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            // Handle SQLException (printing stack trace for now)
	            e.printStackTrace();
	        }
	    }
	    return isValidUser;
	}



	
	@Override
	public int createProduct(List<Product> lst) {

		Product regprod=lst.get(0);
		int i=0;
		Connection con=null;
		try {
			con=shopdao.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("INSERT INTO products (product_id, product_name, product_description, product_price, product_image) VALUES (?,?,?,?,?)");
			pstate.setInt(1,regprod.getProdId());
			pstate.setString(2,regprod.getProdName());
			pstate.setString(3,regprod.getProdDesc());
			pstate.setDouble(4,regprod.getProdPrice());
			pstate.setString(5,regprod.getProdImg());

			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return i;
	}

	

	public List<Product> DisplayAll() {
		Connection con = null;
		List<Product> lst=null;
		Product prod = null;


		try {
			lst = new LinkedList<Product>();
			con =shopdao.getDbConnection();
			String str = "select * from products";
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery(str);
			while(result.next())
			{
				prod =new Product(result.getInt(1),result.getString(2),result.getString(3),result.getDouble(4),result.getString(5));
				lst.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lst;
	}

	public int deleteRecord(int prodId) {
		Connection con=shopdao.getDbConnection();
		int i=0;
		
		try {
			PreparedStatement pstate=con.prepareStatement("delete products where product_id=?");
			pstate.setInt(1,prodId);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public List<Cart> getCartprod(ArrayList<Cart> cartlist) {
		Connection con=null;
		List<Cart> products=new ArrayList<Cart>();
		
		try {
			if(cartlist.size()>0) {
				for(Cart item:cartlist) {
					con=shopdao.getDbConnection();
					PreparedStatement pstate=con.prepareStatement("select * from products where product_id=?");
					pstate.setInt(1,item.getProdId());
					ResultSet result = pstate.executeQuery();
					while(result.next())
					{
						Cart row=new Cart();
						row.setProdId(result.getInt("PRODUCT_ID"));
						row.setProdName(result.getString("PRODUCT_NAME"));
						row.setProdDesc(result.getString("PRODUCT_DESCRIPTION"));
						row.setProdPrice(result.getDouble("PRODUCT_PRICE")*item.getQty());
						row.setQty(item.getQty());
						products.add(row);
						
						
						
					}
				}
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

	
}


