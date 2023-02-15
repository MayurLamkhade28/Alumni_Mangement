package Alumni.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni.bo.Add_bo;
import Alumni.dao.signup_dao;

/**
 * Servlet implementation class EditServelet2
 */
@WebServlet("/EditServelet2")
public class EditServelet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServelet2() {
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
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String ID =request.getParameter("id");
		
		int eid= Integer.parseInt(ID);
	
		Add_bo eb = signup_dao.getEmployeeById(eid);
		pw.print("<link rel='stylesheet' type='text/css' href='css/view.css'>");
		pw.print("<body>");
		pw.print("<center>");
		pw.print("<form  action='updatecontroller' method='get'> ");
		pw.print("<h1>..UPDATE ALUMNI DATA..<h1>");
		pw.print("<table>");
		pw.print("<tr><td>ID: </td><td><input type='text' name='id' value='"+eb.getId()+"'/></td></tr>");
		pw.print("<tr><td>Register_No: </td><td><input type='text'name='rollno' value='"+eb.getRegister_no()+"'/></td></tr>");  
		pw.print("<tr><td>Full Name:</td><td><input type='text'name='name'  value='"+eb.getName()+"'/></td></tr>");
		pw.print("<tr><td>Email: </td><td><input type='email'name='email'  value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Mobile: </td><td><input type='text'name='mob' value='"+eb.getMob()+"'/></td></tr>");
	   	pw.print("<tr><td>Aadhar:</td><td><input type='text'name='adh' value='"+eb.getAadhar()+"'/></td></tr>");
	   	pw.print("<tr><td>Stream:</td><td><input type='text'name='str' value='"+eb.getStream()+"'/></td></tr>");
	   	pw.print("<tr><td>Course: </td><td><input type='text'name='cour' value='"+eb.getCourse()+"'/></td></tr>");
	   	pw.print("<tr><td>Join year: </td><td><input type='date' name='join' value='"+eb.getJoin_year()+"'/></td></tr>");
	   	pw.print("<tr><td>Passout year: </td><td><input type='date'name='pass' value='"+eb.getPassout_year()+"'/></td></tr>");
	   	pw.print("<tr><td>Profession: </td><td><input type='text'name='pro' value='"+eb.getProfession()+"'/></td></tr>");
	   	pw.print("<tr><td>Gender: </td><td><input type='text'name='gen' value='"+eb.getGender()+"'/></td></tr>");
	   	
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		pw.print("</form>");
		pw.print("</center>");
		pw.print("</body>");
		
	
	}

}
