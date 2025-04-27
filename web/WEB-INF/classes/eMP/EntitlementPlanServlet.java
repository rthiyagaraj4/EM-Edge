/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* Entitlement Plan Servlet
	Query Criteria for Entitlement Plan
	Created By	: Vinod Babu MV
	Last Modified Date Time : 2/9/2006 9:35 AM 

    TABLE : MP_ENTITLEMENT_CRITERIA
	PAT_CAT_CODE - Patient Category
	ENTITLEMENT_CRITERIA  - Entitlment By, 
	ENTITLEMENT_SRL_NO - Internal Generated No... max(select count from MP_ENTITLEMENT_CRITERIA where PAT_CAT_CODE='' AND ENTITLEMENT_CRITERIA='')+1, 
	ENTITLEMENT_PATIENT_CLASS - Patient Class, 
	ENTITLEMENT_FACILITY_ID - Facility ID,  
	ENTITLEMENT_CARE_LOCN_IND - Location Type, 
	ENTITLEMENT_CRITERIA_CODE - Speciality Code or Clinic Code or Nursing Unit Code or Bed Class Code 
*/

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
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Hashtable;
import java.util.HashMap;

public class EntitlementPlanServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out	= null;
    Properties p	= null;
	Connection con					= null;
	PreparedStatement pstmt		= null;
    Statement stmt					= null;
    ResultSet rset						= null;
	Hashtable message				= null;
	HttpSession session				= null;

	String client_ip_address					= "";
    String addedById							= "";
    String facility_id							= "";
	int error_value								= 0;
	String error									= "";
    String pat_cat_code  					= "";
    String entitlement_criteria  			= "";
    String entitlement_patient_class 	= "";
    String entitlement_facility_id 			= "";
    String entitlement_care_locn_ind 	= "";
    String entitlement_criteria_code 		= "";
    String appl_to_all 		= "";
	String locale			= "" ;

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response) throws  javax.servlet.ServletException,IOException
	{
		  session  =  request.getSession(false);
		  this.p	  =  (java.util.Properties) session.getValue("jdbc");
		  this.facility_id  = (String)session.getValue( "facility_id" ) ;
		  this.client_ip_address  = p.getProperty("client_ip_address");
		  locale = p.getProperty("LOCALE");
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  try
		  {
			  this.out = response.getWriter();
			  insertEntitlementPlan(request,response);
		 }
		 catch (Exception e)	
		 {
			//out.println(e.toString());
			e.printStackTrace();
		 }
		 finally
		 {
			try{	
				 if ( rset != null ) rset.close();
				 if ( stmt != null ) stmt.close();
				 if ( pstmt != null ) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace(System.out);
				//out.println("Error in Servlet: "+e.toString());
			}
		 }
	}

	private void insertEntitlementPlan(HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
		 con = ConnectionManager.getConnection(request);
		 int entitlement_srl_no = 0;
		 pat_cat_code  					=  checkForNull(request.getParameter("pat_cat_code"),"");
		 entitlement_criteria  			=  checkForNull(request.getParameter("entitlement_criteria"),"");
		 entitlement_facility_id 			=  checkForNull(request.getParameter("entitlement_facility_id"),"");
		 entitlement_care_locn_ind 	=  checkForNull(request.getParameter("entitlement_care_locn_ind"),"");
		 entitlement_patient_class		=	checkForNull(request.getParameter("entitlement_patient_class"),"");
		 appl_to_all 	=  checkForNull(request.getParameter("appl_to_all"),"");
		 String strTotalCount			=	checkForNull(request.getParameter("totalCount"),"");
		 if (strTotalCount.equals("")||(strTotalCount.equals("null"))||(strTotalCount.equals(null)))
		 {
			   strTotalCount = "1";
		 }
		 strTotalCount						=  strTotalCount.trim();
		 int totalCount						=	Integer.parseInt(strTotalCount);

		String added_by_id = p.getProperty( "login_user" ) ;
		String modified_by_id = added_by_id ;
		String added_facility_id=facility_id;
		String modified_facility_id = facility_id ;
		String added_at_ws_no = client_ip_address;
		String modified_at_ws_no = added_at_ws_no ;
		boolean inserted = true;
		StringBuffer selSql = new StringBuffer("select count(*) recCount from MP_ENTITLEMENT_CRITERIA where pat_cat_code='"+pat_cat_code+"' and entitlement_criteria='"+entitlement_criteria+"'");
		 if ( entitlement_criteria.equals("2") )
		 {
			   selSql.append(" and entitlement_facility_id='"+entitlement_facility_id+"' and entitlement_care_locn_ind='"+entitlement_care_locn_ind+"'");
		 }
		 int recCount =0;
		 stmt = con.createStatement();
		 rset = stmt.executeQuery(selSql.toString());

		 if (rset.next())
		 {
			  recCount = rset.getInt("recCount");
		 }
		 if ( rset != null ) rset.close();
		 if ( stmt != null ) stmt.close();


	 /*Delete the existing records for the specific search criteria */
	
		 if ( recCount>0 )
		 {
			 StringBuffer delSql = new StringBuffer("delete from MP_ENTITLEMENT_CRITERIA where pat_cat_code='"+pat_cat_code+"' and entitlement_criteria='"+entitlement_criteria+"'");
			  if (entitlement_criteria.equals("2"))
			 {
			   delSql.append(" and entitlement_facility_id='"+entitlement_facility_id+"' and entitlement_care_locn_ind='"+entitlement_care_locn_ind+"'");
			 }
	 		 stmt = con.createStatement();
			  stmt.executeUpdate(delSql.toString());
			 if ( stmt != null ) stmt.close();
		 }

	/* To generate the Srl No*/
		StringBuffer getSrlNo = new StringBuffer("SELECT nvl(MAX(entitlement_srl_no),0)+1 maxCount FROM mp_entitlement_criteria WHERE pat_cat_code = '"+pat_cat_code+"' AND entitlement_criteria = '"+entitlement_criteria+"'");
		
		 int maxCount =0;
		 stmt = con.createStatement();
		 rset = stmt.executeQuery(getSrlNo.toString());
		 if (rset.next())
		 {
			  maxCount = rset.getInt("maxCount");
		 }

	 /* Next Srl No for the given combination */
		 entitlement_srl_no = maxCount;
		 if ( rset != null ) rset.close();
		 if ( stmt != null ) stmt.close();
	/* END OF 'To generate the Srl No' */
	   int rs = 0;
	   String val = "";
	   String insertSql = "Insert into mp_entitlement_criteria (PAT_CAT_CODE, ENTITLEMENT_CRITERIA, ENTITLEMENT_SRL_NO, ENTITLEMENT_PATIENT_CLASS, ENTITLEMENT_FACILITY_ID, ENTITLEMENT_CARE_LOCN_IND, ENTITLEMENT_CRITERIA_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,'"+added_by_id+"',sysdate,'"+added_at_ws_no+"','"+added_facility_id+"','"+modified_by_id+"',sysdate,'"+modified_at_ws_no+"','"+modified_facility_id+"')";
	   pstmt = con.prepareStatement(insertSql);
 	/* Insert the records for the criteria*/
		if (appl_to_all.equals("Y"))
		{
			   entitlement_patient_class = checkForNull(request.getParameter("pat_class_val"),"");
			   pstmt.setString(1,pat_cat_code);
			   pstmt.setString(2,entitlement_criteria);
			   pstmt.setInt(3,entitlement_srl_no);
			   pstmt.setString(4,entitlement_patient_class);
			   pstmt.setString(5,entitlement_facility_id);
			   pstmt.setString(6,entitlement_care_locn_ind);
			   pstmt.setString(7,"*ALL");	  //entitlement_criteria_code
			   rs = pstmt.executeUpdate();
			   if (rs < 0)
			   {
				   inserted = false;
			   }
			   else
				   entitlement_srl_no++;
		}
		else
		{
		if ( entitlement_criteria.equals("1"))
		{
			for (int i=0; i<totalCount; ++i )
			{
				  val = checkForNull(request.getParameter("Incl_sp_"+i),"");
				  if ( val.equals("Y"))
				  {
					   entitlement_criteria_code =  checkForNull(request.getParameter("splty_"+i),"");
					   pstmt.setString(1,pat_cat_code);
					   pstmt.setString(2,entitlement_criteria);
					   pstmt.setInt(3,entitlement_srl_no);
					   pstmt.setString(4,entitlement_patient_class);
					   pstmt.setString(5,entitlement_facility_id);
					   pstmt.setString(6,entitlement_care_locn_ind);
					   pstmt.setString(7,entitlement_criteria_code);
					   rs = pstmt.executeUpdate();
					   if (rs < 0)
					   {
						   inserted = false;
						   break;
					   }
   					   else
						   entitlement_srl_no++;
				  }
			}
		}
		else
		if ( entitlement_criteria.equals("2"))
		{
			for (int i=0; i<totalCount; ++i )
			{
				  val = checkForNull(request.getParameter("Incl_lc_"+i),"");
				  if ( val.equals("Y"))
				  {
					   entitlement_patient_class = "";
					   entitlement_criteria_code =  checkForNull(request.getParameter("lcn_"+i),"");

					   pstmt.setString(1,pat_cat_code);
					   pstmt.setString(2,entitlement_criteria);
					   pstmt.setInt(3,entitlement_srl_no);
					   pstmt.setString(4,entitlement_patient_class);
					   pstmt.setString(5,entitlement_facility_id);
					   pstmt.setString(6,entitlement_care_locn_ind);
					   pstmt.setString(7,entitlement_criteria_code);
					   rs = pstmt.executeUpdate();
					   if (rs < 0)
					   {
						   inserted = false;
						   break;
					   }
					   else
						   entitlement_srl_no++;
				  }
			}
		}
		else
		if ( entitlement_criteria.equals("3"))
		{
			for (int i=0; i<totalCount; ++i )
			{
				  val = checkForNull(request.getParameter("Incl_bclass_"+i),"");
				  if ( val.equals("Y"))
				  {
					   entitlement_patient_class = ""; 
					   entitlement_criteria_code =  checkForNull(request.getParameter("bclass_"+i),"");

					   pstmt.setString(1,pat_cat_code);
					   pstmt.setString(2,entitlement_criteria);
					   pstmt.setInt(3,entitlement_srl_no);
					   pstmt.setString(4,entitlement_patient_class);
					   pstmt.setString(5,entitlement_facility_id);
					   pstmt.setString(6,entitlement_care_locn_ind);
					   pstmt.setString(7,entitlement_criteria_code);
					   rs = pstmt.executeUpdate();
					   if (rs < 0)
					   {
						   inserted = false;
						   break;
					   }
   					   else
						   entitlement_srl_no++;
				  }
			}
		}
	  }
		   if ( inserted)
		   {
			   message =  MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
			   error = ((String) message.get("message"));
			   error_value = 1;
			   con.commit();
		   }
		   else
		   {
			   error_value = 0;
			   message = MessageManager.getMessage( locale, "ERROR_INSERTING","SM" ) ;
			   error = ( (String) message.get("message") ) ;
			   con.rollback();
		   }
		   response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
		 if ( pstmt != null ) pstmt.close();
		}
		catch(Exception e)
		{
				
			e.printStackTrace(System.out);
			//out.println("Error in Servlet: "+e.toString());
		}
		finally
		{
			 ConnectionManager.returnConnection(con,request);
		}
	}
	public static String checkForNull(String inputStr,String defaultVal)
	{
		 return ( ((inputStr==null) || (inputStr=="null")) ?  defaultVal : inputStr );
	}
}
