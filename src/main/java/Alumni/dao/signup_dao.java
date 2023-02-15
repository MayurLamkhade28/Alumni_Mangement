package Alumni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Alumni.bo.Add_bo;
import Alumni.bo.signup_bo;

public class signup_dao {
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con =null;
		
		try {
			
			String url="jdbc:mysql://localhost:3306/alumni_management";
			String username="root";
			String password="Mayur2806@";
			con=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		return con;
	}
	
	public static int signup(signup_bo sb )
	{
		int status=0;
		
		try
		{
			
		   Connection con= signup_dao.getConnection();
		   
		   String sql ="insert into Alumni(name, email,mob,password) values(? ,? ,? ,?)";
		   
		   PreparedStatement pr= con.prepareStatement(sql);
		   
		   pr.setString(1, sb.getName());
		   pr.setString(2, sb.getEmail());
		   pr.setString(3, sb.getMob());
		   pr.setString(4, sb.getPassword());
		   
		   status = pr.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
		
	}
	
	public static  boolean userLogin(String name , String pass)
	{
		boolean status=false;
		
		try
		{
			
			  Connection con= signup_dao.getConnection();
			  
			  String sql ="select * from Alumni where  name=? and password=?";
			  
		     PreparedStatement ps = con.prepareStatement(sql);
		     
		     ps.setString(1, name);
		     ps.setString(2, pass);
		     
		   ResultSet rs= ps.executeQuery();
		   status =rs.next();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	
	
	public static int Add(Add_bo ab )
	{
		int status=0;
		try
		{
			
			  Connection con= signup_dao.getConnection();
			  
			  String query ="insert into Alumni_data( Register_No, Name, Email, Mob,Aadhar, Stream,Course, Join_year, Passout_year, Profession, Gender) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			  
		     PreparedStatement ps = con.prepareStatement(query);
		     
		     ps.setString(1, ab.getRegister_no());
		     ps.setString(2, ab.getName());
		     ps.setString(3, ab.getEmail());
		     ps.setString(4, ab.getMob());
		     ps.setString(5, ab.getAadhar());
		     ps.setString(6, ab.getStream());
		     ps.setString(7, ab.getCourse());
		     ps.setString(8, ab.getJoin_year());
		     ps.setString(9, ab.getPassout_year());
		     ps.setString(10, ab.getProfession());
		     ps.setString(11, ab.getGender());
		  
		  
		     status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return status;
	}
	
public static List viewAll()
{
	List <Add_bo> li=new ArrayList<Add_bo>(); 
	
	try
	{
		Connection con=signup_dao.getConnection();
		String query="select * from Alumni_data";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Add_bo ab=new Add_bo();
			ab.setId(rs.getInt(1));		
			ab.setRegister_no(rs.getString(2));
			ab.setName(rs.getString(3));
			ab.setEmail(rs.getString(4));
			ab.setMob(rs.getString(5));
			ab.setAadhar(rs.getString(6));
			ab.setStream(rs.getString(7));
			ab.setCourse(rs.getString(8));
			ab.setJoin_year(rs.getString(9));
			ab.setPassout_year(rs.getString(10));
			ab.setProfession(rs.getString(11));
			ab.setGender(rs.getString(12));
			
			li.add(ab);
		}
	}
	catch(Exception e)
	{
		
		System.out.println(e);
	}

   return li;
}


public static Add_bo getEmployeeById(int id) {
	 
	 Add_bo ab= new Add_bo();
	 
	   try {
	   	
		   Connection con=signup_dao.getConnection();
		   String query="select *from Alumni_data where id=?";
		   
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setInt(1, id);

		   ResultSet rs=ps.executeQuery();
		   
		   if(rs.next()) {

			    ab.setId(rs.getInt(1));		
				ab.setRegister_no(rs.getString(2));
				ab.setName(rs.getString(3));
				ab.setEmail(rs.getString(4));
				ab.setMob(rs.getString(5));
				ab.setAadhar(rs.getString(6));
				ab.setStream(rs.getString(7));
				ab.setCourse(rs.getString(8));
				ab.setJoin_year(rs.getString(9));
				ab.setPassout_year(rs.getString(10));
				ab.setProfession(rs.getString(11));
				ab.setGender(rs.getString(12));
			   
			   
		   }
		   
		   
		   
	} catch (Exception e) {
	
		System.out.println(e);
		
	}
	  
	  
	  return ab;
 }


public static int Update(Add_bo sd) {
	 int status=0;
	 
	 try {
		
		 Connection con=signup_dao.getConnection();
		 
		 String query="update Alumni_data set Register_No=?, Name=?,Email=?,Mob=?, Aadhar=?,Stream=?,Course=?, Join_year=?, Passout_year=?, Profession=?,Gender=? where id=?";
		 PreparedStatement ps=con.prepareStatement(query);
		 
		 ps.setString(1, sd.getRegister_no());
	     ps.setString(2, sd.getName());
	     ps.setString(3, sd.getEmail());
	     ps.setString(4, sd.getMob());
	     ps.setString(5, sd.getAadhar());
	     ps.setString(6, sd.getStream());
	     ps.setString(7, sd.getCourse());
	     ps.setString(8, sd.getJoin_year());
	     ps.setString(9, sd.getPassout_year());
	     ps.setString(10, sd.getProfession());
	     ps.setString(11, sd.getGender());
	     ps.setInt(12, sd.getId());
         
	     status=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 
	 return status;
}

public static int delete(int id) {
	
	int status=0;
	  try {
	
		  Connection con=signup_dao.getConnection();
		  String query="Delete from Alumni_data where id=?";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setInt(1, id);
		  status=ps.executeUpdate();
		  
	} catch (Exception e) {
	
		   System.out.println(e);
	}
	return status;

}
	
}

