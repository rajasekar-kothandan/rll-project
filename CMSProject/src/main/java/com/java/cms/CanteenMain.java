package com.java.cms;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CanteenMain {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println(" O P T I O N S");
			System.out.println(" -------------");
			System.out.println("1. Show Restaurant");
			System.out.println("2. Search by Restaurant Id");
			System.out.println("3. Show Menu");
			System.out.println("4. Search Menu");
			System.out.println("5. Show Vendor");
			System.out.println("6. Search Vendor");
			System.out.println("7. Show Customer");
			System.out.println("8. Search Customer");
			System.out.println("9. Search Wallet by C.id");
			System.out.println("10. Search Wallet by W.id");
			System.out.println("11. Place Order");
			System.out.println("12. Accept Or Reject Order");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
				case 1 :
					showRestaurant();
					break;
				case 2 :
				try {
					searchRestaurant();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 3 : 
					showMenu();
					break;
				case 4 :
				try {
					searchMenu();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 5 :
					showVendor();
					break;
				case 6 : 
				try {
					searchVendor();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 7 :
					showCustomer();
					break;
				case 8 :
				try {
					searchCustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 9 :
				try {
					searchWalletbycid();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 10 :
				try {
					searchWalletbywid();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
				case 11 : 
				try {
					placeOrder();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				case 12 : 
				try {
					acceptOrReject();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			
			
			
		}while(choice!=13);
		
	}
	
	public static void acceptOrReject() throws ClassNotFoundException, SQLException {
		int vendorId;
		int orderId;
		String status;
		System.out.println("Enter Vendor Id   ");
		vendorId = sc.nextInt();
		System.out.println("Enter Order Id   ");
		orderId = sc.nextInt();
		System.out.println("Enter Status   ");
		status =sc.next();
		System.out.println(new OrdersDAO().acceptOrRejectOrder(orderId, vendorId, status));
	}
	public static void searchRestaurant() throws ClassNotFoundException, SQLException {
		int rid;
		System.out.println("Enter Restaurant id   ");
		rid = sc.nextInt();
		Restaurant restaurant = new RestaurantDAO().searchRestaurant(rid);
		System.out.println(restaurant);
	}
	public static void showRestaurant() {
		try {
			List<Restaurant> restaurantList = new RestaurantDAO().showRestaurant();
			for (Restaurant restaurant : restaurantList) {
				System.out.println(restaurant);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showMenu() {
		int restaurantId;
		System.out.println("Enter Restaurant Id");
		restaurantId = sc.nextInt();
		try {
		List<Menu> menuList = new MenuDAO().showMenu(restaurantId);
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}

		public static void searchMenu() throws ClassNotFoundException, SQLException {
			int menuid;
			System.out.println("Enter Menu id   ");
			menuid = sc.nextInt();
			Menu menu = new MenuDAO().searchMenu(menuid);
			System.out.println(menu);
		}
		
		public static void showVendor() {
			
			try {
				List<Vendor> vendorList;
				vendorList = new VendorDAO().showVendor();
				for (Vendor vendor : vendorList) {
					System.out.println(vendor);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public static void searchVendor() throws ClassNotFoundException, SQLException {
		int vendorid;
		System.out.println("Insert Vendor ID  ");
		vendorid= sc.nextInt();
		Vendor vendor = new VendorDAO().searchVendor(vendorid);
		System.out.println(vendor);
		
		}
		
		public static void showCustomer() {
			try {
				List<Customer> customerList;
				customerList = new CustomerDAO().showCustomer();
				for (Customer customer : customerList) {
					System.out.println(customer);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		public static void placeOrder() throws ClassNotFoundException, SQLException {
			Orders order = new Orders();
			System.out.println("Enter Customer Id   ");
			order.setCustomerId(sc.nextInt());
			System.out.println("Enter Vendor Id  ");
			order.setVendorId(sc.nextInt());
			System.out.println("Enter Menu Id  ");
			order.setMenuId(sc.nextInt());
			System.out.println("Enter Wallet Id  ");
			order.setWalletId(sc.nextInt());
			System.out.println("Enter Quantity Ordered  ");
			order.setQuantityOrdered(sc.nextInt());
			System.out.println("Enter Comments  ");
			order.setOrderComments(sc.next());
			OrdersDAO dao = new OrdersDAO();
			System.out.println(dao.placeOrder(order));
		}
		public static void searchCustomer() throws ClassNotFoundException, SQLException {
			int customerid;
			System.out.println("Insert Customer Id   ");
			customerid = sc.nextInt();
			Customer customer = new CustomerDAO().searchCustomer(customerid);
			System.out.println(customer);
		}
		public static void searchWalletbycid() throws ClassNotFoundException, SQLException {
			int customerid;
			System.out.println("Enter customer Id to search wallet  ");
			customerid = sc.nextInt();
			List<Wallet> wallet = new WalletDAO().searchByCustomerId(customerid);
			System.out.println(wallet);
			
		}
		public static void searchWalletbywid() throws ClassNotFoundException, SQLException {
			int walletid;
			System.out.println("Enter wallet Id to search wallet  ");
			walletid = sc.nextInt();
			Wallet wallet = new WalletDAO().searchByWalletId(walletid);
			System.out.println(wallet);
			
		}
		
		
		
		
}
