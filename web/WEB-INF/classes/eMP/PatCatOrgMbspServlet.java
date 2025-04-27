/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.*;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import java.util.HashMap;
import java.util.Properties;

import com.ehis.eslp.ServiceLocator;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
public class PatCatOrgMbspServlet extends HttpServlet{
	PrintWriter out;
	Properties p;

	ResultSet rs = null;
	Connection con = null;
	PreparedStatement pstmt			= null;
	String membership_type;
	String family_org_id;
	String family_org_sub_id;
	String name_prefix;
	String relationship_code;
	String pat_cat_code;
	int error_value;
	String error;

	String patientcategoryCode;
	String longDesc ;
	String shortDesc ;
	String jobType;
	String expiry_applicable;
	String expiry_period;
	String effectiveDateFrom ;
	String effectiveDateTo ;
	String effectiveStatus ;
	String sql1;
	String facilityId ;
	String client_ip_address ;
	String addedFacilityId="";
	String locale			= "" ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
												    throws ServletException,IOException{
	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try {
			this.out = res.getWriter();
			//String operation = req.getParameter("param");
			String mode = req.getParameter("mode_hid");
			con	= ConnectionManager.getConnection(req);
			if(mode.equals("update"))
			{
				UpdatePatcat(res,req);
			}
			else{
				insertPatcat(res,req);
			}


			
		}catch (Exception e)	
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
        {
            if( con != null ) ConnectionManager.returnConnection(con,req);
        }
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		try	{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatientCategory.js'></script><script src='../eCommon/js/messages.js' language='javascript'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} catch(Exception e)	{	
			e.printStackTrace();
		}
	}

private void insertPatcat(HttpServletResponse res,HttpServletRequest req ) {

try{
			 membership_type = req.getParameter("membership");
			 family_org_id = req.getParameter("organization_hid");
			 family_org_sub_id = req.getParameter("sub_org_hid");
			 name_prefix = req.getParameter("prefix_hid");
			 relationship_code = req.getParameter("relationship");
			 pat_cat_code = req.getParameter("cat_value");
			 String sql1 = "select * from  MP_PAT_CATEGORY_DERIV_RULE where membership_type='"+membership_type+"' and family_org_id='"+family_org_id+"' and family_org_sub_id='"+family_org_sub_id+"' and name_prefix=? and pat_cat_code='"+pat_cat_code+"' and relationship_code='"+relationship_code+"'";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,name_prefix);
			rs = pstmt.executeQuery();
			if(rs.next())
		    {
			//flag1 = false;
			error_value = 0;
			java.util.Hashtable hashtable5 = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common");
			error = (java.lang.String)hashtable5.get("message");

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );

			}
			else
			{
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				 addedFacilityId=facilityId;
				String modifiedFacilityId = facilityId ;
				String addedAtWorkstation = client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;

				sql1 = "insert into mp_pat_category_deriv_rule (membership_type, family_org_id, family_org_sub_id, name_prefix, relationship_code, pat_cat_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				
				pstmt   =	con.prepareStatement(sql1);
				pstmt.setString(1,membership_type);
				pstmt.setString(2,family_org_id);
				pstmt.setString(3,family_org_sub_id);
				pstmt.setString(4,name_prefix);
				pstmt.setString(5,relationship_code);
				pstmt.setString(6,pat_cat_code);
				pstmt.setString(7,addedById);
				pstmt.setString(8,addedAtWorkstation);
				pstmt.setString(9,addedFacilityId);
				pstmt.setString(10,modifiedById);
				pstmt.setString(11,modifiedAtWorkstation);
				pstmt.setString(12,modifiedFacilityId);
				int rs2     =	pstmt.executeUpdate();

				if(rs2>0)
				{ 
				error_value = 1;
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				error = ( (String) message.get("message") ) ;
				con.commit();
				}
				else
				{
				error_value = 0;
				java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_IN_UPDATING","SM" ) ;
				error = ( (String) message.get("message") ) ;
				con.rollback();
				}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}

   }catch(Exception e)
	{
	  
	  e.printStackTrace();
	}
}

///function for updation
private void UpdatePatcat(HttpServletResponse res,HttpServletRequest req ) {

try{
			 membership_type = req.getParameter("membership");
			 family_org_id = req.getParameter("organization_hid");
			 family_org_sub_id = req.getParameter("sub_org_hid");
			 name_prefix = req.getParameter("prefix_hid");
			 relationship_code = req.getParameter("relationship");
			 pat_cat_code = req.getParameter("cat_value");
				String membership_type_code=req.getParameter("membership_type_code_up");
				String family_org_id_code=req.getParameter("family_org_id_code_up");
				String family_org_sub_id_code=req.getParameter("family_org_sub_id_code_up");
				String relationship_code1=req.getParameter("relationship_code1_up");
				String name_prefix_up=req.getParameter("name_prefix_up");
			 
			
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				 addedFacilityId=facilityId;
				String modifiedFacilityId = facilityId ;
				String addedAtWorkstation = client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;

				String sql1 = "select * from  MP_PAT_CATEGORY_DERIV_RULE where membership_type='"+membership_type+"' and family_org_id='"+family_org_id+"' and family_org_sub_id='"+family_org_sub_id+"' and name_prefix=? and pat_cat_code='"+pat_cat_code+"' and relationship_code='"+relationship_code+"'";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,name_prefix);
				if(rs!=null)rs.close();
				rs = pstmt.executeQuery();
				if(rs.next())
				{
				error_value = 0;
					java.util.Hashtable hashtable5 = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common");
					error = (java.lang.String)hashtable5.get("message");

					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );

				}
				
				else{
				String sqll="update mp_pat_category_deriv_rule set MEMBERSHIP_TYPE='"+membership_type+"', FAMILY_ORG_ID='"+family_org_id+"',FAMILY_ORG_SUB_ID='"+family_org_sub_id+"',NAME_PREFIX=?,RELATIONSHIP_CODE='"+relationship_code+"',MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where MEMBERSHIP_TYPE='"+membership_type_code+"' and FAMILY_ORG_ID='"+family_org_id_code+"' and FAMILY_ORG_SUB_ID='"+family_org_sub_id_code+"' and NAME_PREFIX=? and RELATIONSHIP_CODE='"+relationship_code1+"' and PAT_CAT_CODE='"+pat_cat_code+"'"; 
				if(pstmt!=null) pstmt.close();
				pstmt   =	con.prepareStatement(sqll);
				pstmt.setString(1,name_prefix);
				pstmt.setString(2,name_prefix_up);
				int xyz     =	pstmt.executeUpdate();
				if(xyz>0)
				{ 
				error_value = 1;
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				error = ( (String) message.get("message") ) ;
				con.commit();
				}
				else
				{
				error_value = 0;
				java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_IN_UPDATING","SM" ) ;
				error = ( (String) message.get("message") ) ;
				con.rollback();
				}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
		
if(pstmt!=null) pstmt.close();
if(rs!=null) rs.close();
}
   }catch(Exception e)
	{
	   e.printStackTrace();
	}

}
//end
}
