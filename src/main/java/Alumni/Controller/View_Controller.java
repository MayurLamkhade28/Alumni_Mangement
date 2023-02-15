package Alumni.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni.bo.Add_bo;
import Alumni.dao.signup_dao;

/**
 * Servlet implementation class View_Controller
 */
@WebServlet("/View_Controller")
public class View_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		
		pw.print("<center><h1>ALUMNI  ALL  DETAILS</h1></center>");
		
		pw.print("<table border ='1px' width =100% > ");
		pw.print("<link rel='stylesheet' type='text/css' href='css/view.css'>");
		
		pw.print("<tr><th>ID</th> <th>REGISTER NO</th> <th>NAME</th> <th>EMAIL</th> <th>MOBILE</th> <th>AADHAR NO</th> <th>STREAM</th> <th>COURSE</th> <th>JOIN YEAR</th> <th>PASSOUT YEAR</th> <th>PROFESSION</th> <th>GENDER</th> <th>UPDATE</th> <th>DELET</th></tr>");
           
		List<Add_bo> list= signup_dao.viewAll();
		
		
		
		for(Add_bo eb: list)
		{
			pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getRegister_no()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getMob()+"</td><td>"+eb.getAadhar()+"</td><td>"+eb.getStream()+"</td><td>"+eb.getCourse()+"</td><td>"+eb.getJoin_year()+"</td><td>"+eb.getPassout_year()+"</td><td>"+eb.getProfession()+"</td><td>"+eb.getGender()+"</td><td>"+"<a href='EditServelet2?id="+eb.getId()+"'> edit </a></td> <td><a href='DeleteServelet?id="+eb.getId()+"'>delete </a></td></tr>");
		}
		
		
		pw.print("</table><br><br>");
		
		
		pw.print("<center>");
		pw.print("<a href ='Home.html' id='aa'>Back</a>");
		pw.print("</center>");
	
	}

}
