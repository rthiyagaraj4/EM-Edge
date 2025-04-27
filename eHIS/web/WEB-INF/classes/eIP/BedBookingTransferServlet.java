/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eIP.IPBedBookingTransfer.* ;

public class BedBookingTransferServlet extends javax.servlet.http.HttpServlet 
{


public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	PrintWriter out			= null;	
	java.util.Properties p	= null;
	HttpSession session		= null;
	session					= req.getSession(false);
	p				    	= (java.util.Properties) session.getValue( "jdbc" );
	String locale			= "";
	locale					= p.getProperty("LOCALE");
	String encounter_id		= "";
	String facilityId		= "";
	facilityId				= (String)session.getValue("facility_id");
	String patientid		= "";
	try 
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out					= res.getWriter();
		patientid						= checkForNull(req.getParameter("patient_id"));
		encounter_id                    = checkForNull(req.getParameter("encounter_id"));
		
		Connection con					= null;
		boolean proceed					= true;
		Statement entitle_stmt			= null;
		PreparedStatement entitle_pstmt = null;
		ResultSet entitle_rs			= null;
		String status					= "";
		String msg						= "";
		String entitlement_by_pat_cat_yn= "";
		try
		{
			con = ConnectionManager.getConnection(p);
			entitle_stmt = con.createStatement();
			entitle_rs = entitle_stmt.executeQuery("select entitlement_by_pat_cat_yn from MP_PARAM ") ;
			if(entitle_rs.next())
			{	
				entitlement_by_pat_cat_yn = entitle_rs.getString("entitlement_by_pat_cat_yn");
			}
			if(entitle_rs != null) entitle_rs.close();
			if(entitle_stmt != null) entitle_stmt.close();
			if(entitlement_by_pat_cat_yn.equals("Y"))
			{
				entitle_pstmt = con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy'),?,?,?,?,?,?) from dual");
				entitle_pstmt.setString(1,patientid);
				entitle_pstmt.setString(2,checkForNull(req.getParameter("admission_date")));
				entitle_pstmt.setString(3,facilityId);
				entitle_pstmt.setString(4,"N");
				entitle_pstmt.setString(5,checkForNull(req.getParameter("nursing_unit")));
				entitle_pstmt.setString(6,checkForNull(req.getParameter("patient_class")));
				entitle_pstmt.setString(7,checkForNull(req.getParameter("Splcode")));
				entitle_pstmt.setString(8,checkForNull(req.getParameter("Bedcode")));

				entitle_rs=entitle_pstmt.executeQuery();
				if(entitle_rs != null && entitle_rs.next())
				{
					status=entitle_rs.getString(1);
					if(status == null) status="";
				}
				if(entitle_rs != null) entitle_rs.close();
				if(entitle_pstmt != null) entitle_pstmt.close();
			}


			if(status.equals("0"))
			{
				proceed = true;
			}
			else if(status.equals("1"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
				msg = ((String) message.get("message"));

				if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
				out.println("<script>alert('"+msg+"');</script>");
				out.println("<script>parent.parent.document.getElementById('dialog_tag').close();</script>");
				message.clear();
			}
			else if(status.equals("2"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
				msg = ((String) message.get("message"));
				if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
				out.println("<script>alert('"+msg+"');</script>");
				message.clear();
			}
			else if(status.equals("3"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED" ,"MP");
				msg = ((String) message.get("message"));
				if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
				out.println("<script>alert('"+msg+"');</script>");
				message.clear();
			}
			else if(status.equals("4"))
			{
				proceed = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED" ,"MP");
				msg = ((String) message.get("message"));
				if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
				out.println("<script>alert('"+msg+"');</script>");
				message.clear();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
		if(proceed)
		{
			IPBedBookingTransfer(req,res, facilityId, patientid);
		}
	}catch(Exception e)	
	{
		e.printStackTrace();
	}
}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	try
	{
		doPost(req,res);
	}
	catch(Exception e)	{	}
}

private void IPBedBookingTransfer(HttpServletRequest req,HttpServletResponse res, String facilityId, String patientid) throws java.io.IOException
{
	PrintWriter out					= null;	
	java.util.Properties p			= null;
	HttpSession session				= null;
	session							= req.getSession(false);
	out								= res.getWriter();
	p								= (java.util.Properties) session.getValue( "jdbc" );
	String locale					= "";
	locale							= p.getProperty("LOCALE");
	String bl_interfaced_yn			= "N";
	String transfer_chargeable_yn	= "N";
	String surgery_reqd_yn			= "N";
	String pref_date_time			= "";
	String nursing_unit				= "";
	String encounter_id				= "";
	nursing_unit					= checkForNull(req.getParameter("nursing_unit"));
	try
	{
		bl_interfaced_yn			= checkForNull(req.getParameter("bl_interfaced_yn"));
		if((bl_interfaced_yn==null) ||(bl_interfaced_yn.equals("null")))
			bl_interfaced_yn="N";

		if(bl_interfaced_yn.equals("Y"))
		{
			transfer_chargeable_yn	=	checkForNull(req.getParameter("transfer_chargeable_yn"));
			if((transfer_chargeable_yn==null)||(transfer_chargeable_yn.equals("null")))
				transfer_chargeable_yn="N";
			surgery_reqd_yn			=	checkForNull(req.getParameter("surgery_reqd_yn"));
			if((surgery_reqd_yn==null)||(surgery_reqd_yn.equals("null")))
				surgery_reqd_yn="N";
		}

		pref_date_time	= checkForNull(req.getParameter("pref_date_time"));
		pref_date_time	= DateUtils.convertDate(pref_date_time,"DMYHM",locale,"en");
/*10/10/2008*/

//String is_reserved_bed_checked  = req.getParameter("is_reserved_bed_checked")== null ?"N":req.getParameter("is_reserved_bed_checked");


		String error				= "";
		String insert_val			= "";
		HashMap hashData			= new HashMap();
//		String transferservcharge="0.0d";
		String addnldepamt			= "0.0d";
		hashData.put("facilityId",facilityId);
		hashData.put("patientid",patientid);
		hashData.put("encounterid",checkForNull(req.getParameter("encounter_id")));
		hashData.put("confirmValue",checkForNull(req.getParameter("confirmValue")));
		hashData.put("billing_group_id",checkForNull(req.getParameter("billing_group_id")));
		hashData.put("transferdate",checkForNull(req.getParameter("transfer_date")));
		hashData.put("modify_date","");
		hashData.put("transfertype",checkForNull(req.getParameter("transfer_type")));
		hashData.put("topractitionerid",checkForNull(req.getParameter("practid")));
		hashData.put("tospecialitycode",checkForNull(req.getParameter("Splcode")));
		hashData.put("frpractitionerid",checkForNull(req.getParameter("fr_practitioner_id")));
		hashData.put("frspecialitycode",checkForNull(req.getParameter("fr_speciality_code")));
		hashData.put("tonursingunitcode",checkForNull(req.getParameter("nursing_unit")));
		hashData.put("patientgender",checkForNull(req.getParameter("patientgender")));
		hashData.put("dateofbirth",checkForNull(req.getParameter("dateofbirth")));
		hashData.put("frnursingunitcode",checkForNull(req.getParameter("fr_nursing_unit_code")));
		hashData.put("toservicecode",checkForNull(req.getParameter("service")));
		hashData.put("frservicecode",checkForNull(req.getParameter("fr_service_code")));
		hashData.put("frsub_service",checkForNull(req.getParameter("fr_subservice_code")));
		hashData.put("todailycharge","0");
		hashData.put("frbedtype",checkForNull(req.getParameter("fr_bed_type")));
		hashData.put("frbedclass",checkForNull(req.getParameter("fr_bed_class")));
		hashData.put("frroomno",checkForNull(req.getParameter("fr_room_no")));
		hashData.put("frbedno",checkForNull(req.getParameter("fr_bed_no")));
		hashData.put("totypecode",checkForNull(req.getParameter("bed_type_code")));
		hashData.put("tobedclass",checkForNull(req.getParameter("Bedcode")));
		hashData.put("bl_interfaced_yn",bl_interfaced_yn);
		hashData.put("transfer_chargeable_yn",transfer_chargeable_yn);
		hashData.put("surgery_reqd_yn",surgery_reqd_yn);
		hashData.put("addnldepamt",addnldepamt);
		hashData.put("client_ip_address",p.getProperty("client_ip_address"));
		hashData.put("priority",checkForNull(req.getParameter("priority")));
		hashData.put("pref_date_time",pref_date_time);

		hashData.put("sub_service",checkForNull(req.getParameter("sub_service")));
		hashData.put("med_team_id",checkForNull(req.getParameter("team_id")));
		hashData.put("frteamid",checkForNull(req.getParameter("fr_team_id")));
		hashData.put("transfer_req_type",checkForNull(req.getParameter("TFR_REQ_TYPE")));
		hashData.put("transfer_req_status",checkForNull(req.getParameter("TFR_REQ_STATUS")));
		hashData.put("expired_date_time",checkForNull(req.getParameter("exp_date_time")));
		hashData.put("change_bed_class_yn",checkForNull(req.getParameter("change_bed_class_yn")));
		hashData.put("oper_stn_bed_class_yn",checkForNull(req.getParameter("oper_stn_bed_class_yn")));
		hashData.put("ipparam_bed_yn", checkForNull(req.getParameter("ipparam_bed_yn")));
		hashData.put("mother_bed_status", checkForNull(req.getParameter("mother_bed_status")));
		hashData.put("bed_change", checkForNull(req.getParameter("bed_change")));
		hashData.put("bl_operational", checkForNull(req.getParameter("bl_operational")));
		hashData.put("modified_bed_type_code", checkForNull(req.getParameter("modified_bed_type_code")));
		
/*10/10/2008*/
		hashData.put("is_reserved_bed_checked",checkForNull(req.getParameter("is_reserved_bed_checked")));
		hashData.put("reason_for_reserved_bed",checkForNull(req.getParameter("reason_for_reserved_bed")));
		hashData.put("reserve_bed_no",checkForNull(req.getParameter("r_bed_no")));
		hashData.put("reserve_room_no",checkForNull(req.getParameter("r_room_no")));
		hashData.put("reserve_nurs_unit_code",checkForNull(req.getParameter("r_nursing_unit")));
		hashData.put("res_bed_no", checkForNull(req.getParameter("res_bed_no")));
		hashData.put("res_room_no", checkForNull(req.getParameter("res_room_no")));
		hashData.put("res_nursing_unit", checkForNull(req.getParameter("res_nursing_unit")));

		hashData.put("reqRadioBtn", checkForNull(req.getParameter("reqRadioBtn")));//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		
		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPBedBookingTransfer",IPBedBookingTransferHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = hashData;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = hashData.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPBedBookingTransfer",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		 boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		 error = (String) results.get("error") ;
		 if(error.lastIndexOf("<br>.")>=0)
		 error=error.substring(0,error.lastIndexOf("<br>"));
         insert_val = (String) results.get("insert_val") ;
		 
		if(inserted)
		{
			 
			 out.print("<script>alert('"+error+"');</script>");
			 if(insert_val.equals("0") )
			{ 
				doOnlineReports(req,res,encounter_id,nursing_unit,patientid,facilityId,out);
			}
			 out.print("<script>top.window.document.getElementById('dialog_tag').close();</script>");
		 }
		 else
		 {
		out.print("<script>alert('"+error+"');parent.frames[1].document.location.reload();</script>");
		out.println("<script>parent.frames[1].document.BedBookingTransfer_form.confirm.disabled=false;</script>");
						
		 }
		hashData.clear();
		results.clear();
	}catch (Exception e)
	{
		e.printStackTrace();
	}
}
private void doOnlineReports(HttpServletRequest req, HttpServletResponse res, String encounter_id,String nursing_unit,String patientid,String facilityId,PrintWriter out) throws ServletException, IOException, SQLException
    {
	    String sqlString = "";
		String clinic_type = "N";
		sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.PRINT_ON_TRANSFER_REQUEST_YN='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id order by 2 ";
		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
		String reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+patientid+"";
		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
		htmlFor.append(" </head><body class='message'>");
		htmlFor.append(" <script language = 'JavaScript'>" );
		htmlFor.append(" var dialogHeight = '25' ;");
		htmlFor.append(" var dialogWidth = '45' ;");
		htmlFor.append(" var dialogTop = 58;" );
		htmlFor.append(" var arguments	= ''; ");
		htmlFor.append(" var getUrl = '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append(" var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append(" retVal = window.showModalDialog(getUrl,arguments,features); parent.window.close();");
		htmlFor.append(" </script>" );
		out.println(htmlFor.toString());
		out.println("</body></html>");
	}


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

} 
