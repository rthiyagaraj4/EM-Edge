package eOP;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

/**
 * Host Name-: Himanshu Saxena 
 * Created-: 17-05-2023
 * Servlet implementation class UpdateQueueNumberServlet
 */
public class UpdateQueueNumberServlet extends javax.servlet.http.HttpServlet  {
	private static final long serialVersionUID = 1L;
       
   
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = ConnectionManager.getConnection(request);	
		PrintWriter out=response.getWriter();
		
			String queue_no=request.getParameter("QUEUE_NUM");
			String patientid=request.getParameter("Patient_id");
			String encntrid=request.getParameter("encntrid");
			String FACILITY_ID =request.getParameter("fac_id");
			PreparedStatement pstmt=null;
			ResultSet rs    = null; 
			int count=0;
			boolean iscount=false;
			try
			{
				String sql	= "update op_patient_queue set queue_num=? where FACILITY_ID=? and Encounter_id=? AND patient_id=?";				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,queue_no);
				pstmt.setString(2,FACILITY_ID);
				pstmt.setString(3,encntrid);
				pstmt.setString(4,patientid);
				count=pstmt.executeUpdate();
				if(count>0)
				{
					con.commit();
					out.println("ok");
				}else
				{
					out.println("Failed");
				}
				if (pstmt != null)
				pstmt.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			
			
	}

}
