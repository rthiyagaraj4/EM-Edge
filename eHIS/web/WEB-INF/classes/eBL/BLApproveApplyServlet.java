package eBL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eBL.Common.BlRepository;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class BLApproveApplyServlet
 */
public class BLApproveApplyServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="en";	
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BLApproveApplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;

		String patientId=request.getParameter("patient_id");
		String authorized_yn=request.getParameter("authorized_yn");
//		String auth_start_time_str=request.getParameter("auth_start_time_str");
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //commented checkstyle

		System.err.println("facilityId/patientId :: "+facilityId+"/"+patientId);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			con	=	ConnectionManager.getConnection(request);
//			Timestamp auth_start_time = new Timestamp(sdf.parse(auth_start_time_str).getTime());

			if("N".equalsIgnoreCase(authorized_yn)){
				
				String sqlBlMrAuthPatDel = BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_DELETE"); 
				pstmt=con.prepareStatement(sqlBlMrAuthPatDel);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,patientId);
				rs = pstmt.executeQuery() ;

			}
			else if("Y".equalsIgnoreCase(authorized_yn)){				

				String sqlBlMrAuthPatCheck = BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_YN");
				pstmt=con.prepareStatement(sqlBlMrAuthPatCheck);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,patientId);
				rs = pstmt.executeQuery() ;	
						
				if(rs.next()){
					
					String sqlBlMrAuthPatUpdate = BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_UPDATE"); 
					pstmt=con.prepareStatement(sqlBlMrAuthPatUpdate);
					pstmt.setString(1,login_user);
					pstmt.setString(2,client_ip_address);
					pstmt.setString(3,facilityId);
					pstmt.setString(4,facilityId);
					pstmt.setString(5,patientId);
						
					rs = pstmt.executeQuery() ;
					System.err.println("sqlBlMrAuthPatUpdate :: "+sqlBlMrAuthPatUpdate);
					
				}else{
					
					String sqlBlMrAuthPatInsert = BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_INSERT"); 
					pstmt=con.prepareStatement(sqlBlMrAuthPatInsert);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,patientId);
					pstmt.setString(3,login_user);
					pstmt.setString(4,client_ip_address);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,login_user);
					pstmt.setString(7,client_ip_address);
					pstmt.setString(8,facilityId);
					
					rs = pstmt.executeQuery() ;
					System.err.println("sqlBlMrAuthPatInsert :: "+sqlBlMrAuthPatInsert);

				}
			}
			con.commit();

			System.out.println("rs=="+rs);
		}catch(Exception e)
		{
			System.err.println("Exception in BLApproveApplyServlet :: "+e);
			e.printStackTrace();
		}
		finally
		{
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}			

			ConnectionManager.returnConnection(con);
		}	 
	}

}
