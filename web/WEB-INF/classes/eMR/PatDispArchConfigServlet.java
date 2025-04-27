package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.URLEncoder;
import com.ehis.util.*;

import webbeans.eCommon.*;

public class PatDispArchConfigServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	String facilityId;
	HttpSession session; 
	Properties p;
	String client_ip_address; 

	boolean inserted		= false; 
	String mode;
	String arch_disp;     
	String selectedSpecialityLists;    
    Connection con;
 
                                      
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config); 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		    req.setCharacterEncoding("UTF-8");
	        res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
		try	{

			session 						= req.getSession(true);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
			this.facilityId = (String) session.getValue( "facility_id" ) ;
						//System.err.println("facilityId==>"+facilityId);

            
			arch_disp 	=  checkForNull(req.getParameter("arch_disp"));
			//System.err.println("arch_disp==>"+arch_disp);
			selectedSpecialityLists		=   checkForNull(req.getParameter("selectedSpecialityLists"));
			//System.err.println("selectedSpecialityLists==>"+selectedSpecialityLists);
			updateDispArchConfig(req,res);

		}catch(Exception e){
			e.printStackTrace();
		}
	} //End of doPost

	 private void  updateDispArchConfig(HttpServletRequest req, HttpServletResponse res){
//System.err.println("Here 60");
		  try{
			con = ConnectionManager.getConnection(req);
			String modifiedById	      = p.getProperty( "login_user" ) ;
			String locale = p.getProperty("LOCALE");
			String modifiedAtWorkstation  = client_ip_address ;
			int result	= 0;
			int executableCount	= 0;
			//System.err.println("Here 69");
			//System.err.println("arch_disp 69-->"+arch_disp);

//System.err.println("facilityId==>"+facilityId);


			String sql1	="update MP_ARCH_DISP_CRITERIA set cut_off_period = '' where arch_disp =? ";
				//System.err.println("sql1 == >"+sql1);
			PreparedStatement prep1 =  con.prepareStatement(sql1);
			prep1.setString(1,arch_disp);
			prep1.executeUpdate();
			con.commit();


			String sql	="update MP_ARCH_DISP_CRITERIA set cut_off_period = ?,MODIFIED_DATE = sysdate ,MODIFIED_BY_ID = ?,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID=?  where arch_disp =? and SPECIALITY_CODE =? ";
			PreparedStatement prep =  con.prepareStatement(sql);
			StringTokenizer strTok = null;
			if(!"".equals(selectedSpecialityLists)){
				strTok = new StringTokenizer(selectedSpecialityLists,",");
				while(strTok.hasMoreTokens()) {
					String specailty_code	= strTok.nextToken();
					String cut_off_period	= checkForNull(req.getParameter(specailty_code));
					int i=1;
					prep.setString(i++, cut_off_period);
					prep.setString(i++, modifiedById);
					prep.setString(i++, modifiedAtWorkstation);
					prep.setString(i++, facilityId);
					prep.setString(i++, arch_disp);
					prep.setString(i++, specailty_code);
					//System.err.println("arch_disp==>"+arch_disp+"==>specailty_code==>"+specailty_code+"====>cut_off_period==>"+cut_off_period);

					prep.addBatch();
					executableCount++;
				}
				if(executableCount>0){
					int[] no = prep.executeBatch();
					result	 = no.length;
				}
				prep.close();
				prep1.close();
			}
			//System.err.println("result==>"+result);
			if(result > 0){ 
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					String error =((String) message.get("message"));
					//System.err.println("error==>"+error);
				//	out.println("<script>parent.frames(3).document.location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script>");
				    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=1" );

			}else{
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));
				//System.err.println("error==>"+error);
				//out.println("<html><script>parent.frames(3).document.location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");
				  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=0" );
			}

		}catch ( Exception e ){

			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, req);
		}
	} 

		 

		private String checkForNull(String inputString) {
			return (inputString==null)	?	""	:	inputString;
		}

		public static String checkForNull(String inputString, String defaultValue) {
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}



} // End of the Class
