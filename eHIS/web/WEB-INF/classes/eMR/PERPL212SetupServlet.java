package eMR;
import eCommon.SingleTabHandler.*;
import java.io.*;
import java.net.URLEncoder;
import java.sql.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public class PERPL212SetupServlet extends javax.servlet.http.HttpServlet 
{
	java.util.Properties p;
	HttpSession session;
	PrintWriter out;
	String facility_id					= "";
	String maxrecord					= "";
	String service_list					= "";
	String clinic_code					= "";
	String error						= "";
	String err_value					= "";
	String client_ip_address			= "";
	String inc							= "";
	String addedById					= "";
	String modifiedById					= "";
	String modifiedAtWorkstation		= "";
	String modifiedFacilityId			= "";
	String addedFacilityId				= "";
	String addedAtWorkstation			= "";
	String locale						= "";
	int cnt								= 0;
	boolean status;
	Connection con						= null;
	Statement	stmt					= null;
	PreparedStatement pstmt				= null;
	PreparedStatement preStatement		= null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		session					= request.getSession(false);

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.p					= (java.util.Properties) session.getValue("jdbc") ;
		service_list			= checkForNull(request.getParameter("service_list"));
		maxrecord				= checkForNull(request.getParameter("maxrecord"));
		this.facility_id		= checkForNull((String) session.getValue("facility_id"));
		client_ip_address		= p.getProperty("client_ip_address");
		locale					= p.getProperty("LOCALE");
		maxrecord				= maxrecord.trim();

		insertClinicData(request,response);
	}

	private void insertClinicData(HttpServletRequest request, HttpServletResponse response)
	{    
		int count = 0;
		count=Integer.parseInt(maxrecord);
		try
		{
			this.out					= response.getWriter();
			con							= ConnectionManager.getConnection(request);
			stmt						= con.createStatement();
			con.setAutoCommit(false);
			addedById					= p.getProperty("login_user");
			modifiedById				= addedById;
			addedFacilityId				= facility_id;
			modifiedFacilityId			= addedFacilityId;
			addedAtWorkstation			= client_ip_address;
			modifiedAtWorkstation		= addedAtWorkstation;
			int i = 0;
			
			try
			{
				String sqlDel = "";

				for(i=0;i<count;i++)
				{
					clinic_code			= checkForNull(request.getParameter("clinic_code"+i));
					inc                 = checkForNull(request.getParameter("inc"+i));
					
					if(inc.equals("") || inc.equals("N"))
					{
						sqlDel ="delete from mr_report_of_op_attendance where facility_id = ? and service_code = ? and clinic_code = ?";
						preStatement = con.prepareStatement(sqlDel);
						preStatement.setString(1, facility_id);
						preStatement.setString(2, service_list);
						preStatement.setString(3, clinic_code);
						
						cnt = preStatement.executeUpdate();
						if(cnt>0)
							status=true;
						if(preStatement!=null)preStatement.close();
					}

					if(inc.equals("Y"))
					{ 
						sqlDel ="delete from mr_report_of_op_attendance where facility_id = ? and service_code = ? and clinic_code = ?";
						preStatement = con.prepareStatement(sqlDel);
						preStatement.setString(1, facility_id);
						preStatement.setString(2, service_list);
						preStatement.setString(3, clinic_code);
						
						preStatement.executeUpdate();

						if(preStatement!=null)preStatement.close();

						String sql = "insert into mr_report_of_op_attendance (facility_id, service_code, clinic_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values  (?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)";

						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, service_list);
						pstmt.setString(3, clinic_code);						
						pstmt.setString(4, addedById);
						pstmt.setString(5, addedAtWorkstation);
						pstmt.setString(6, addedFacilityId);
						pstmt.setString(7, modifiedById);
						pstmt.setString(8, modifiedAtWorkstation);
						pstmt.setString(9, modifiedFacilityId);

						cnt=pstmt.executeUpdate();

						if(pstmt != null) pstmt.close();

						if(cnt>0)
							status=true;
						else
							status=false;
					}
				}
			}
			catch(Exception x){
				//out.println("Exceptioina at PERPL212SetupServlet"+x.getMessage());
				status=false;
				con.rollback();
				error=x.getMessage();
				x.printStackTrace();
			}
			if(status){
				err_value="1";
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);
				if ( hashtable1 != null ) hashtable1.clear();
			}else{
				err_value="0";
				con.rollback();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);	 	 
			}
			if(stmt!=null) stmt.close();
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				//out.println("Exception raise by servlet"+eee.toString());
				eee.printStackTrace();
			}
			//out.println(e.toString());
			e.printStackTrace();
		}
		  finally
		  {
				 if( con != null ) ConnectionManager.returnConnection(con,request);
		  }    
	}
	public static String checkForNull(String inputString)
	{
		return( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString);
	}
}