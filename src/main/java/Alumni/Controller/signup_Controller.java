package Alumni.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni.bo.signup_bo;
import Alumni.dao.signup_dao;

/**
 * Servlet implementation class signup_Controller
 */
@WebServlet("/signup_Controller")
public class signup_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_Controller() {
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
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		String pass=request.getParameter("pass");
		
		//pw.print(name+" "+email+" "+mob+" "+pass);
		
		signup_bo sb = new signup_bo();
		
		sb.setName(name);
		sb.setEmail(email);
		sb.setMob(mob);
		sb.setPassword(pass);
		signup_dao.signup(sb);
		
		int status = signup_dao.signup(sb);
		
		if(status>0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else
		{
		     RequestDispatcher rd= request.getRequestDispatcher("signup.html");
			rd.include(request, response);
			
			pw.print("somthing wents worng!!!");
			
		}
		
	}

}
