package Alumni.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni.bo.Add_bo;
import Alumni.dao.signup_dao;

/**
 * Servlet implementation class Add_Controller
 */
@WebServlet("/Add_Controller")
public class Add_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String Register_No = request.getParameter("rollno");
		String Name = request.getParameter("name");
		String Email= request.getParameter("email");
		String Mob= request.getParameter("mob");
		String Aadhar= request.getParameter("adh");
		String Stream= request.getParameter("str");
		String Course= request.getParameter("cour");
		String Join_year= request.getParameter("join");
		String Passout_year= request.getParameter("pass");
		String Profession= request.getParameter("pro");
		String Gender= request.getParameter("gen");
		
		
		
		Add_bo ab =new Add_bo( Register_No, Name, Email, Mob, Aadhar, Stream, Course, Join_year, Passout_year, Profession, Gender); 
		
			int status = signup_dao.Add(ab);
			
			if(status>0)
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("View_Controller");
				rd.forward(request, response);
			}
			else
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("addstudent.html");
				rd.include(request, response);
			}
				
				
	
	}

}
