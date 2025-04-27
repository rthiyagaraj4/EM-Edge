/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public class mpPurgeAuditServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out =null;	
	Properties p = null;	
	String addedById ="";
	String facilityId="";
	Connection con	= null;
	String purge_date	= "";	
	String error_value	= "0" ;	
			 
	HttpSession session=null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		String errors="";
		request.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();		
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc") ;
		String locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		addedById =	p.getProperty( "login_user" ) ;
		con = ConnectionManager.getConnection(request);
       
		purge_date = (String) request.getParameter( "Purge_Date" ) ;	
		if (purge_date != null)
		{
			purge_date=DateUtils.convertDate(purge_date,"DMY",locale,"en");
		}
		else
		{
			purge_date="";
		}
		
		
		String Sex_yn =  request.getParameter( "Sex_yn" )==null?"N": request.getParameter( "Sex_yn" );
		String BirthDate_yn = request.getParameter( "BirthDate_yn" )==null?"N": request.getParameter( "BirthDate_yn" );
		String LegalName_yn = request.getParameter( "LegalName_yn" )==null?"N": request.getParameter( "LegalName_yn" );
		String AliasName_yn = request.getParameter( "AliasName_yn" )==null?"N": request.getParameter( "AliasName_yn" );
		String FamilyLink_yn = request.getParameter( "FamilyLink_yn" )==null?"N": request.getParameter( "FamilyLink_yn" );
		String Oraganization_mem_yn = request.getParameter( "Oraganization_mem_yn" )==null?"N": request.getParameter( "Oraganization_mem_yn" );
		String Address_yn = request.getParameter( "Address_yn" )==null?"N": request.getParameter( "Address_yn" );
     	String OcpnEmpl_yn = request.getParameter( "OcpnEmpl_yn" )==null?"N": request.getParameter( "OcpnEmpl_yn" );
		String Nationality_hist_yn = request.getParameter( "Nationality_hist_yn" )==null?"N": request.getParameter( "Nationality_hist_yn" );
		String Category_yn = request.getParameter( "Category_yn" )==null?"N": request.getParameter( "Category_yn" );
		String NatId_yn = request.getParameter( "NatId_yn" )==null?"N": request.getParameter( "NatId_yn" );
		String BirthPlace_yn = request.getParameter( "BirthPlace_yn" )==null?"N": request.getParameter( "BirthPlace_yn" );
		String SuspendReinstate_yn = request.getParameter( "SuspendReinstate_yn" )==null?"N": request.getParameter( "SuspendReinstate_yn" );
		String InactiveActivate_yn = request.getParameter( "InactiveActivate_yn" )==null?"N": request.getParameter( "InactiveActivate_yn" );
		String RecordRevoke_yn = request.getParameter( "RecordRevoke_yn" )==null?"N": request.getParameter( "RecordRevoke_yn" );
		String alt_id1_hist_yn = request.getParameter( "alt_id1_hist_yn" )==null?"N": request.getParameter( "alt_id1_hist_yn" );
		String alt_id2_hist_yn = request.getParameter( "alt_id2_hist_yn" )==null?"N": request.getParameter( "alt_id2_hist_yn" );
		String alt_id3_hist_yn = request.getParameter( "alt_id3_hist_yn" )==null?"N": request.getParameter( "alt_id3_hist_yn" );
		String alt_id4_hist_yn = request.getParameter( "alt_id4_hist_yn" )==null?"N": request.getParameter( "alt_id4_hist_yn" );
		String patseries_yn = request.getParameter( "patseries_yn" )==null?"N": request.getParameter( "patseries_yn" );		
        //added by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
		String old_file_no_yn = request.getParameter( "oldfileNo_yn" )==null?"N": request.getParameter( "oldfileNo_yn" );	


		CallableStatement cstmt=null;
		try
		{	
						con.setAutoCommit(false);
						cstmt = con.prepareCall("{call mp_purge_change_hist_dtl(to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        cstmt.setString( 1, purge_date);
						cstmt.setString( 2, addedById);
						cstmt.setString( 3, facilityId);
						cstmt.setString( 4, Sex_yn);
						cstmt.setString( 5, patseries_yn);
						cstmt.setString( 6, BirthDate_yn);
						cstmt.setString( 7, LegalName_yn);
						cstmt.setString( 8, AliasName_yn);
						cstmt.setString( 9, Address_yn);
						cstmt.setString( 10, OcpnEmpl_yn);
						cstmt.setString( 11, SuspendReinstate_yn);
						cstmt.setString( 12, InactiveActivate_yn);
						cstmt.setString( 13, RecordRevoke_yn);	
						cstmt.setString( 14, Nationality_hist_yn);
						cstmt.setString( 15, alt_id1_hist_yn);
						cstmt.setString( 16, alt_id2_hist_yn);
						cstmt.setString( 17, alt_id3_hist_yn);
						cstmt.setString( 18, alt_id4_hist_yn);						
						cstmt.setString( 19, FamilyLink_yn);
						cstmt.setString( 20, Oraganization_mem_yn);
						cstmt.setString( 21, Category_yn);
						cstmt.setString( 22, NatId_yn);
						cstmt.setString( 23, BirthPlace_yn);						
                        //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
						cstmt.setString( 24, old_file_no_yn);
						cstmt.registerOutParameter( 25, java.sql.Types.VARCHAR);
						cstmt.execute() ;
						errors = cstmt.getString(25);
						
						if(cstmt!=null) cstmt.close();

						if(errors==null)
						{	
							java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
 							 errors = ((String) message.get("message"));
						
							//errors="APP-SM0002 Operation Completed Successfully ....";
							error_value="1";
							message.clear();
						}
						else 
							error_value="0";
						if(error_value.equals("1"))
						{

							//con.setAutoCommit(true);
							con.commit();
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errors , "UTF-8") + "&err_value=" + java.net.URLEncoder.encode( error_value ));                        
						}
						else
						{	
							//con.setAutoCommit(false);
							con.rollback();
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errors , "UTF-8") + "&err_value=" + java.net.URLEncoder.encode( error_value ));						
						}
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
}
