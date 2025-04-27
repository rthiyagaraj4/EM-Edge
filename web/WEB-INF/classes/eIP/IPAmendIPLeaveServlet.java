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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eIP.IPAmendIPLeave.* ;

public class IPAmendIPLeaveServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
PrintWriter out;

java.util.Properties p;
String sStyle;
String facility_id;
String client_ip_address ;
String patient_id		= "";
String locale			= "" ;


public void init(ServletConfig config) throws ServletException  
{
    super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
    HttpSession session = req.getSession(false);
    this.facility_id = (String)session.getValue("facility_id") ;
	sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
    this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	locale = p.getProperty("LOCALE");

	try 
	{
		this.out = res.getWriter();
		updateIPAmendLeave(req);
    }
    catch (Exception e) {e.printStackTrace();	}
}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	try
	{
		doPost(req,res);
	}
	catch(Exception e)	{	}
}

private void updateIPAmendLeave(HttpServletRequest req)    
{
	patient_id = "";
	try 
	{

		String error="";
		patient_id                            =req.getParameter("patient_id") ;
		String leave_status                   =req.getParameter("trans_type") ;
		String encounter_id                   =req.getParameter("encounter_id") ;
		String new_nursing_unit_code		   =req.getParameter("nursing_unit");
		String new_bed_no                      =req.getParameter("bed_no") ;
		String new_to_daily_rate               ="" ;
		String new_practitioner_id             ="" ;
		String new_speciality_code             ="" ;
		String occupied_until_date_time        =checkForNull(req.getParameter("occupied_until_date_time"));
		String qry_str = java.net.URLDecoder.decode(req.getParameter("query_string"));
		String amend_remarks					= checkForNull(req.getParameter("amend_remarks")) ;
		String leave_remarks					= checkForNull(req.getParameter("leave_remarks"));
		String reported_to						= checkForNull(req.getParameter("reported_to"));
		
		String to_date							= checkForNull(req.getParameter("to_date"));
		to_date	= DateUtils.convertDate(to_date,"DMYHM",locale,"en");
		
		String from_date						= checkForNull(req.getParameter("from_date"));
		from_date = DateUtils.convertDate(from_date,"DMYHM",locale,"en");
		
		String returned_date_time				= checkForNull(req.getParameter("returned_date_time"));
		returned_date_time = DateUtils.convertDate(returned_date_time,"DMYHM",locale,"en");
		
		String AbsDate							= checkForNull(req.getParameter("AbsDate"));
		AbsDate = DateUtils.convertDate(AbsDate,"DMYHM",locale,"en");
		
		String informed_date					= checkForNull(req.getParameter("informed_date"));
		informed_date = DateUtils.convertDate(informed_date,"DMYHM",locale,"en");
		
		Connection con = null;
		Statement stmt = null;

		try
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			stmt = con.createStatement() ;

			StringBuffer sql = new StringBuffer();
			sql.append(" select specialty_code, attend_practitioner_id, to_char(exp_discharge_date_time,'dd/mm/rrrr hh24:mi') exp_discharge_date_time from ip_open_encounter where facility_id = '"+ facility_id +"' and encounter_id ="+ encounter_id +"" ); 
			
			// removed and accessing with encounter_id
			// nursing_unit_code='"+new_nursing_unit_code +"' and bed_no = '"+ new_bed_no +"' " );

			java.sql.ResultSet rs = stmt.executeQuery ( sql.toString() ) ;

			 if(rs != null)
				if(rs.next())
				{
					new_speciality_code = checkForNull(rs.getString("specialty_code"));
					new_practitioner_id  = checkForNull(rs.getString("attend_practitioner_id")) ;
					occupied_until_date_time = checkForNull(rs.getString("exp_discharge_date_time"));
				}
				if(rs!=null )       rs .close();
				if(stmt!=null ) stmt .close();
				
				/* merged with above query for PE - 13/05/2010

				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select to_char(exp_discharge_date_time,'dd/mm/rrrr hh24:mi') from pr_encounter_other_detail where encounter_id ="+ encounter_id +" and operating_facility_id = '"+facility_id+"'" );
				rs = stmt.executeQuery ( sql.toString()) ;

				if(rs != null)
				if(rs.next())
				{
					occupied_until_date_time = (rs.getString(1) ==null ? "" : rs.getString(1));
				}

				if(rs!=null )       rs .close();
				if(stmt!=null ) stmt .close();
				*/
		
		}catch ( Exception e ) {e.printStackTrace();}
		finally
		{
			  ConnectionManager.returnConnection(con,req);
		}
			java.util.HashMap hashData = new java.util.HashMap();
			hashData.put("leave_status",leave_status);
			hashData.put("facility_id",facility_id);
			hashData.put("encounter_id",encounter_id);
			hashData.put("srl_no",req.getParameter("srl_no"));
			hashData.put("patient_id",patient_id);
			hashData.put("trn_type",req.getParameter("trn_type") == null ?"":req.getParameter("trn_type"));
			hashData.put("trn_code",req.getParameter("trn_code") == null ?"":req.getParameter("trn_code"));
			hashData.put("old_nursing_unit_code",req.getParameter("old_nursing_unit_code"));
			hashData.put("old_room_no",req.getParameter("old_room_no"));
			hashData.put("old_bed_no",req.getParameter("old_bed_no"));
			hashData.put("old_bed_class_code",req.getParameter("old_bed_class_code"));
			hashData.put("old_bed_type_code",req.getParameter("old_bed_type_code"));
			hashData.put("old_to_daily_rate",req.getParameter("old_to_daily_rate"));
			hashData.put("old_practitioner_id",req.getParameter("old_practitioner_id"));
			hashData.put("old_speciality_code",req.getParameter("old_speciality_code"));
			hashData.put("new_nursing_unit_code",new_nursing_unit_code);
			hashData.put("new_room_no",req.getParameter("disp_room_no"));
			hashData.put("new_bed_no",new_bed_no);
			hashData.put("new_bed_class_code",req.getParameter("bed_cls_code"));
			hashData.put("fr_service_code",req.getParameter("fr_service_code"));
			hashData.put("to_service_code",req.getParameter("to_service_code"));
			//hashData.put("new_bed_type_code",new_nursing_unit_code);
			hashData.put("new_bed_type_code",req.getParameter("bed_typ_code"));
			hashData.put("new_to_daily_rate",new_to_daily_rate);
			hashData.put("new_practitioner_id",new_practitioner_id);
			hashData.put("new_speciality_code",new_speciality_code);

			hashData.put("leave_to_date",to_date);
			hashData.put("occupied_until_date_time",occupied_until_date_time);
			hashData.put("amend_remarks",amend_remarks);
			hashData.put("leave_remarks",leave_remarks);
			hashData.put("old_release_bed_yn",req.getParameter("old_release_bed_yn"));
			hashData.put("new_release_bed_yn",req.getParameter("release_bed") == null ? "N":req.getParameter("release_bed"));
			hashData.put("client_ip_address",client_ip_address);
			hashData.put("leave_fr_date",from_date);
			hashData.put("returned_date_time",returned_date_time);
			hashData.put("generate_pseudo_bed",req.getParameter("generate_pseudo_bed"));
			hashData.put("bedclass",req.getParameter("bed_cls_code")==null?"":req.getParameter("bed_cls_code"));
			hashData.put("bedtype",req.getParameter("bed_typ_code")==null?"":req.getParameter("bed_typ_code"));
			hashData.put("roomnum",req.getParameter("old_room_no")==null?"":req.getParameter("old_room_no"));
			hashData.put("pseudo_bed",req.getParameter("pseudo_bed")==null?"":req.getParameter("pseudo_bed"));
			hashData.put("setup_bl_dtls_in_ip_yn",req.getParameter("setup_bl_dtls_in_ip_yn")==null?"N":req.getParameter("setup_bl_dtls_in_ip_yn"));
			hashData.put("Absconding_yn",req.getParameter("Absconding_yn")==null?"N":req.getParameter("Absconding_yn"));
			hashData.put("AbsDate",AbsDate);
			hashData.put("reported_to",reported_to);
			hashData.put("inform_to",req.getParameter("inform_to")==null?"":req.getParameter("inform_to"));
			hashData.put("informed_name",req.getParameter("informed_name")==null?"":req.getParameter("informed_name"));
			hashData.put("informed_date",informed_date);
			hashData.put("pol_rep_no",req.getParameter("pol_rep_no")==null?"":req.getParameter("pol_rep_no"));
			hashData.put("pol_stn_id",req.getParameter("pol_stn_id")==null?"":req.getParameter("pol_stn_id"));
			hashData.put("pol_id",req.getParameter("pol_id")==null?"":req.getParameter("pol_id"));
			hashData.put("peudobed_val",req.getParameter("hdd_peudobed_val")==null?"":req.getParameter("hdd_peudobed_val"));
			hashData.put("deactivate_pseudoBed",req.getParameter("deactivate_pseudoBed")==null?"":req.getParameter("deactivate_pseudoBed"));
			hashData.put("pseudoBed_yn",req.getParameter("pseudo_bed_yn")==null?"":req.getParameter("pseudo_bed_yn"));
			hashData.put("Abscond_chk",req.getParameter("leave_stat")==null?"":req.getParameter("leave_stat"));
			hashData.put("patient_class",req.getParameter("patient_class")==null?"":req.getParameter("patient_class"));
			hashData.put("admission_date_time",req.getParameter("admdate")==null?"":req.getParameter("admdate"));
			hashData.put("modified_date_val",req.getParameter("modified_date_val")==null?"":req.getParameter("modified_date_val"));

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home		= com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPAmendIPLeave",IPAmendIPLeaveHome.class,local_ejbs);
			Object busObj	= (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			 
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateIPAmendLeave",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			 error = (String) results.get("error") ;
			
		if ( inserted )
		{
			error = (String) results.get("message") ;
			if(error.indexOf("<br>")!=-1)
			{
				error = error.substring(0,error.indexOf("<br>"));
			}
			out.println("<script>alert('"+error+"')</script>");
			if(leave_status.equals("1"))
			doOnlineReports(encounter_id,new_nursing_unit_code);
			out.println("<script>parent.document.getElementById('dialog_tag').close();</script>") ;
		}
		else
		{
			String err= (String) results.get("error") ;
			if(err.indexOf("Exception") == -1)
			{
				if(err.indexOf("APP-IP0196") != -1)
				{
					out.println("<script>alert(\""+err+"\");</script>");
					out.println("<script>parent.document.getElementById('dialog_tag').close();</script>") ;
				}else
				{
					out.println("<script>parent.frames[1].location.href = '../eIP/jsp/addModifyAmentInpatientLeave.jsp?"+qry_str+"'</script>");
				}
			}
			else if(err.indexOf("<br>")!=-1)
			{
				err = err.substring(0,err.indexOf("<br>"));
				out.println("<script>alert(\""+err+"\");</script>");
			}
			else 
			{
				out.println("<script>alert(\""+err+"\");</script>");
			}
			
		  }
			hashData.clear();
			results.clear();

	}catch ( Exception e ) {   e.printStackTrace();  }
}

    private String convertString(String val)
    {
       /* if(val == null) val = "" ;

        if(!val.equals(""))
        {
            String dup_val = val ;
            int i = 0 ;

            StringBuffer stringbuffer = new StringBuffer(dup_val);
            for(int j = 0; dup_val.indexOf('\'', i) != -1; j++)
            {
                i = dup_val.indexOf('\'', i);
                stringbuffer.insert(i + j, "'");
                i++;
            }
            val = stringbuffer.toString() ;

        }
        return val ;
		*/
		if(val == null) val = "" ;
		 return val.replaceAll("'","''");
    }

	private void doOnlineReports(String encounter_id,String nursing_unit)throws ServletException, IOException, SQLException
    {
		StringBuffer sqlString = new StringBuffer();
		String clinic_type = "N";

		sqlString.append("SELECT report_id , report_desc report_desc,1 no_of_copies , module_id FROM sm_report_lang_vw  WHERE  language_id='"+locale+"' and module_id = 'IP' AND report_id = 'IPBLVPAS'");

		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
		String reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+patient_id+"";

		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>" );
		htmlFor.append("  var dialogHeight    = '25' ;");
		htmlFor.append(" var dialogWidth = '65' ;");
		htmlFor.append("var dialogTop = 58;" );
		htmlFor.append("  var arguments	=	''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=AMEND_LEAVE&step=1&sqlString="+java.net.URLEncoder.encode(sqlString.toString())+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal			=	window.showModalDialog(getUrl,arguments,features); parent.document.getElementById('dialog_tag').close();");
		htmlFor.append(" </script>"  );
		out.println(htmlFor.toString());
		out.println("</body></html>");
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
