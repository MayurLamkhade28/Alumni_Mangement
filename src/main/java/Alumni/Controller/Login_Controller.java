package Alumni.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni.dao.signup_dao;

/**
 * Servlet implementation class Login_Controller
 */
@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();	
		
		String name=request.getParameter("name");	
		String pass=request.getParameter("pass");
		 
		
		
		if(signup_dao.userLogin(name , pass))
		{
			RequestDispatcher rd= request.getRequestDispatcher("Home.html");
			rd.forward(request, response);
		}
		else
			
		{

			RequestDispatcher rd= request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
			pw.print("cheack password or name");
		}
		
		
	}

}
