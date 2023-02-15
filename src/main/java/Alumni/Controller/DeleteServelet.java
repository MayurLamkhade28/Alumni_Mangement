package Alumni.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni.dao.signup_dao;

/**
 * Servlet implementation class DeleteServelet
 */
@WebServlet("/DeleteServelet")
public class DeleteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServelet() {
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
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//int status = Emp_dao.delete(id);
		
		int status=signup_dao.delete(id);
		
		if(status > 0)
		{
			System.out.println("Data is deleted");
			
			response.sendRedirect("View_Controller");
		}
	
	}

}
