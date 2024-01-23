package com.mainproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.mainproject.dao.UserDao;
import com.mainproject.model.User;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		switch(path)
		{
		case "/login": loginValidate(request,response);
						break;
		case "/list": listUsers(request, response);
						break;
		case "/add": addUser(request,response);
						break;
		case "/insert": insertUser(request, response);
						break;
						
		case "/delete": deleteUserById(request, response);
						break;
		case "/edit": editUser(request,response);
						break;
		case "/update": updateUser(request, response);
						break;
		default :login(request,response);
						break;
		}
	}

	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		
		//read the data given in browser 
		int id = Integer.parseInt(request.getParameter("id"));
		 String name = request.getParameter("name");
		 long mobile = Long.parseLong(request.getParameter("mobile"));
		 String city = request.getParameter("city");
		 
		 //store the above data in bean object
		 User u = new User(id, name, mobile, city);
		 
		 //call dao method and pass the above object
		 UserDao.updateUser(u);
		 
		// Redirect user to list page with updated value:
		 try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	private void editUser(HttpServletRequest request, HttpServletResponse response) {
		
		// Read the data[id] from url:
		int id = Integer.parseInt(request.getParameter("id"));
		
		User u = UserDao.selectUserById(id);
		request.setAttribute("list1", u);
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
	}

	
	private void deleteUserById(HttpServletRequest request, HttpServletResponse response) {
		
		//read id from url
		int id = Integer.parseInt(request.getParameter("id"));
		//call JDBC code from Dao
		UserDao.delete(id);
		//redirect user to list page with updated value
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	private void listUsers(HttpServletRequest request, HttpServletResponse response) {
		
		// call the dao methods which return all the user data:
		ArrayList<User> display = UserDao.display();
		
		// send the above collection to jsp page:
		request.setAttribute("display", display);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		
		// Read the data from browser
		String name = request.getParameter("name");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String city = request.getParameter("city");
		// Store the above data in bean object
		User u = new User(name, mobile, city);
		//call the dao method by passing above bean object
		UserDao.insert(u);
		
		//redirect to list page
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void addUser(HttpServletRequest request, HttpServletResponse response) {

		  try { response.sendRedirect("UserForm.jsp"); } catch (IOException e) {
		  e.printStackTrace(); }	
	}

	
	//login validate with credentials
	private void loginValidate(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String validate = UserDao.loginValidate(username, password);
		if(validate.equals("success")) {
			
			try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("LoginError.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	//Login starting page
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("Login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
