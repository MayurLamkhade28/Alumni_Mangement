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
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
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
         
        
        int ID=Integer.parseInt(request.getParameter("id")); 
        
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
		
        Add_bo sd=new Add_bo();

        sd.setId(ID);
        sd.setRegister_no(Register_No);
        sd.setName(Name);
        sd.setEmail(Email);
        sd.setMob(Mob);
        sd.setAadhar(Aadhar);
        sd.setStream(Stream);
        sd.setCourse(Course);
        sd.setJoin_year(Join_year);
        sd.setPassout_year(Passout_year);
        sd.setProfession(Profession);
        sd.setGender(Gender);
        
       int status = signup_dao.Update(sd);
       
      
       if(status>0) {
    	   
     	  RequestDispatcher rd=request.getRequestDispatcher("View_Controller");
     	    rd.forward(request, response);
     	   pw.print("YOUR DATA SUCCESSFULLY UPDATED...");
	    }
       else
       {
    		  RequestDispatcher rd=request.getRequestDispatcher("updatecontroller");
       	    rd.include(request, response);
    	    pw.print("SOMTHING WENTS TO WRONG..");
       }
	
	}

}
