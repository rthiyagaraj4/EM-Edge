/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;
 
public class ReleaseBedServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String locale			= "" ;
	String messages = "" ;	
	/*Added by Dharma for AUDIT COLUMNS update Start*/
	String modified_by_id	= "";
	String modified_at_ws_no	= "";
	/*Added by Dharma for AUDIT COLUMNS update End*/
		
	PreparedStatement pstmt=null;
	//int res=0;
	Connection con=null;
	//Timestamp timestamp;	
	//int maxrecord=0;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	StringBuffer sqlSBuf = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {
	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try	{
			session 		= req.getSession(true);
			this.facilityId = checkForNull((String) session.getValue("facility_id"));
			this.p			= (java.util.Properties) session.getValue( "jdbc" ) ;
			locale			= p.getProperty("LOCALE");
			/*Added by Dharma for AUDIT COLUMNS update Start*/
			modified_by_id	= checkForNull((String) session.getValue("login_user"));
			modified_at_ws_no	= (p.getProperty("client_ip_address"))==null?"":(p.getProperty("client_ip_address"));
			/*Added by Dharma for AUDIT COLUMNS update End*/
			//messages = "" ;
			con = ConnectionManager.getConnection(p);

			//this.client_ip_address	=	p.getProperty("client_ip_address");

			modifyReleaseBed(req, res);

		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			 if(con != null)  ConnectionManager.returnConnection(con,p);
		}
	}

	private void  modifyReleaseBed(HttpServletRequest req, HttpServletResponse res){
		try{
        
			//String addedDate			= dateFormat.format( new java.util.Date() ) ;
			String addedFacilityId		= facilityId;
			String clinic			=	"";
			String treatment_area	=	"";
			String bed_no			=	"";
			StringTokenizer strToken		= null;
			int strCount					= 0;
			String tokenValue	= "";
			StringTokenizer tokenValue2=null;
			StringTokenizer validToken		= null;
			int validCount					= 0;
			int validCount1=0;
			String select_value="";
			int result=0;
			String error_value="";
			String error="";
			boolean update=false;
			sqlSBuf = new StringBuffer();
			sqlSBuf.append(" update AE_BED_FOR_TRMT_AREA set ");
			sqlSBuf.append(" current_status='A', ");
			sqlSBuf.append(" OCCUPIED_UNTIL_DATE_TIME='' ,");
			sqlSBuf.append(" OCCUPYING_PATIENT_ID='' ,");
			sqlSBuf.append(" REASON_FOR_RESERVE='', ");
			/*Added by Dharma for AUDIT COLUMNS update Start*/
			sqlSBuf.append(" MODIFIED_BY_ID='"+modified_by_id+"', ");
			sqlSBuf.append(" MODIFIED_DATE = SYSDATE ,");
			sqlSBuf.append(" MODIFIED_FACILITY_ID='"+addedFacilityId+"', ");
			sqlSBuf.append(" MODIFIED_AT_WS_NO='"+modified_at_ws_no+"' ");
			/*Added by Dharma for AUDIT COLUMNS update End*/
			sqlSBuf.append(" where facility_id=? and ");
			sqlSBuf.append(" clinic_code=? and bed_no=? and ");
			sqlSBuf.append(" treatment_area_code=? and eff_status='E' ");
			pstmt=con.prepareStatement(sqlSBuf.toString());

			String ReleaseBeds = checkForNull(req.getParameter("releasebed_hid"));
		
			if ((!ReleaseBeds.equals("")) && (!ReleaseBeds.equals(","))) 	{
				strToken	=  new StringTokenizer(ReleaseBeds, ",");
				strCount = strToken.countTokens();
			}
			for (int k=0; k<strCount; k++) {
				tokenValue = checkForNull(strToken.nextToken());
			
				validToken = new StringTokenizer(tokenValue, "^^");
				validCount = validToken.countTokens();
	
				for (int j=0; j< validCount; j++) {
					if (validToken.hasMoreTokens()) {
						select_value =	checkForNull(validToken.nextToken());
						tokenValue2 =  new StringTokenizer(select_value, "$");
						validCount1 = tokenValue2.countTokens();
						for(int i=0;i<validCount1;i++) 	{
							if(tokenValue2.hasMoreTokens())
								bed_no= checkForNull(tokenValue2.nextToken());
							if(tokenValue2.hasMoreTokens())
								clinic= checkForNull(tokenValue2.nextToken()); 
							if(tokenValue2.hasMoreTokens())
								treatment_area= checkForNull(tokenValue2.nextToken());
				                        //sqlSBuf.append(" update AE_BED_FOR_TRMT_AREA set ");
							//sqlSBuf.append(" current_status='A', ");
							//sqlSBuf.append(" OCCUPIED_UNTIL_DATE_TIME='' ,");
							//sqlSBuf.append(" OCCUPYING_PATIENT_ID='' ,");
							//sqlSBuf.append(" REASON_FOR_RESERVE='' ");
							//sqlSBuf.append(" where facility_id=? and ");
							//sqlSBuf.append(" clinic_code=? and bed_no=? and ");
							//sqlSBuf.append(" treatment_area_code=? and eff_status='E' ");

							/*sql="update AE_BED_FOR_TRMT_AREA set current_status='A', OCCUPIED_UNTIL_DATE_TIME='' ,OCCUPYING_PATIENT_ID='', REASON_FOR_RESERVE='' where facility_id=? and clinic_code=? and bed_no=? and treatment_area_code=? and eff_status='E' ";*/
							//pstmt=con.prepareStatement(sqlSBuf.toString());
							pstmt.setString(1,addedFacilityId);
							pstmt.setString(2,clinic);
							pstmt.setString(3,bed_no);
							pstmt.setString(4,treatment_area);
							result=pstmt.executeUpdate();
							if(result != 0) {
								update=true;
							} else {
								update=false;
							}
							//if(pstmt!=null) pstmt.close();
							//if((sqlSBuf != null) && (sqlSBuf.length() > 0)) {
								//sqlSBuf.delete(0,sqlSBuf.length());
							//}
     						}
					}
				}
			}
			if(result!=0 && update == true) {
				error_value		= "1" ;
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
                String msg  = ((String) mesg.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) + "&err_value=" + error_value );	
				mesg.clear();
				con.commit();
			} else  {
				error		= "APP-SM0000 Transaction Failes ....<br>" ;
				error_value		= "0" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			if(pstmt!=null) pstmt.close();
			if((sqlSBuf != null) && (sqlSBuf.length() > 0)) {
				sqlSBuf.delete(0,sqlSBuf.length());
			}
		}catch ( Exception e ) {
			e.printStackTrace();
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	} // End of the modifyParameter
	// To Handle java.lang.NullPointerException.

	public static String checkForNull(String inputString) {
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}

} // End of the Class
