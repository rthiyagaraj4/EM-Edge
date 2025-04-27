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
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eIP.IPPatientEmergencyTransfer.* ;
import eIP.IPConfirmBedClass.* ;

public class PatientEmergencyTransferServlet extends javax.servlet.http.HttpServlet 
{
	/*PrintWriter out;
	java.util.Properties p;
	String sStyle;
	String locale				= "";
	Connection con				= null; 
    ResultSet rset				= null;
    PreparedStatement pstmt		= null;
*/
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		PrintWriter out				= null;
		java.util.Properties p	= null;
		HttpSession session			= null;
		String sStyle				= "";;
		String locale				= "";
		Connection con				= null; 
		String patientid		= "";
		session		= req.getSession(false);
		String facilityId = (String)session.getValue("facility_id") ;
		sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		
		
		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();
			con		=	null;
			boolean proceed = true;
			Statement entitle_stmt = null;
			PreparedStatement entitle_pstmt = null;
			ResultSet entitle_rs = null;

			String status = "";
			String msg = "";
			String entitlement_by_pat_cat_yn = "";

			try
			{
				con = ConnectionManager.getConnection(p);
				patientid					= checkForNull(req.getParameter("patient_id"));
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
					out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
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
					out.println("<script>if(parent.frames[1].document.Emergency_Transfer_form.confirm.disabled==true)parent.frames[1].document.Emergency_Transfer_form.confirm.disabled=false;</script>");
					message.clear();
				}
				else if(status.equals("3"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>if(parent.frames[1].document.Emergency_Transfer_form.confirm.disabled==true)parent.frames[1].document.Emergency_Transfer_form.confirm.disabled=false;</script>");
					message.clear();
				}
				else if(status.equals("4"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>if(parent.frames[1].document.Emergency_Transfer_form.confirm.disabled==true)parent.frames[1].document.Emergency_Transfer_form.confirm.disabled=false;</script>");
					message.clear();
				}
					
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}

			if(proceed)
			{
				IPPatientEmergencyTransfer(req,res, facilityId, patientid);
			}
		}catch (Exception e)	
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


	private void IPPatientEmergencyTransfer(HttpServletRequest req, HttpServletResponse res,String facilityId, String patientid)	throws java.io.IOException
	{
		java.util.Properties p			= null;
		HttpSession session				= null;
		PrintWriter out					= null;
		out								= res.getWriter();
		session							= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale=p.getProperty("LOCALE");
		String  transfer_chargeable_yn	= "N";
		String  surgery_reqd_yn				= "N";
		String  transfer_serv_charge		= "";
		String	  addnl_dep_amt				= "";
		int		  frdailycharge					= 0;
		int		  todailycharge					= 0;
		long	  encounterid					= 0;

		String eid					= checkForNull(req.getParameter("encounter_id"));
		encounterid					= Long.parseLong(eid);
		
		String frdc					= checkForNull(req.getParameter("from_daily_rate"));
		if(!frdc.equals(""))
			frdailycharge			= Integer.parseInt(frdc);

		String tonursingunitcode	= checkForNull(req.getParameter("nursing_unit"));

		String todc					= checkForNull(req.getParameter("to_daily_rate"));
		if(!todc .equals(""))
			todailycharge			= Integer.parseInt(todc);

		String change_bed_YN		= checkForNull(req.getParameter("bed_change"));
		if(!change_bed_YN.equals("Y"))
			change_bed_YN="N";
		String call_function		= checkForNull(req.getParameter("call_function"));
		String reason_request		= checkForNull(req.getParameter("reqstat"));
		String tran_type			= checkForNull(req.getParameter("tfr_type"));
		String bl_interface_yn		= checkForNull(req.getParameter("bl_interface_yn"),"N");
		
		if(bl_interface_yn.equals("Y"))
		{
			transfer_chargeable_yn	=	checkForNull(req.getParameter("transfer_chargeable_yn"),"N");
			surgery_reqd_yn			=	checkForNull(req.getParameter("surgery_reqd_yn"),"N");
			transfer_serv_charge	=	checkForNull(req.getParameter("transfer_serv_charge"));
			addnl_dep_amt			=	checkForNull(req.getParameter("addnl_dep_amt"));
		}

		try 
		{
			String error="";
			String msg1="";
			HashMap hashData = new HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("patientid",patientid);
			hashData.put("strEncid",encounterid+"");
			hashData.put("modified_date_val",checkForNull(req.getParameter("modified_date_val")));
			hashData.put("transferdate",checkForNull(req.getParameter("transfer_date")));
			hashData.put("transfertype",checkForNull(req.getParameter("transfer_type")));
			hashData.put("topractitionerid",checkForNull(req.getParameter("practid")));
			hashData.put("tospecialitycode",checkForNull(req.getParameter("Splcode")));
			hashData.put("tobedclass",checkForNull(req.getParameter("Bedcode")));
			hashData.put("tonursingunitcode",tonursingunitcode);
			hashData.put("bed_class_chk",checkForNull(req.getParameter("bed_class_chk")));
			hashData.put("billing_group_id",checkForNull(req.getParameter("billing_group_id")));
			hashData.put("toservicecode",checkForNull(req.getParameter("service")));
			hashData.put("tosubservcode",checkForNull(req.getParameter("sub_service")));
			hashData.put("tobedno",checkForNull(req.getParameter("to_bed_no")));
			hashData.put("toroomno",checkForNull(req.getParameter("to_room_no")));
			hashData.put("tobedtype",checkForNull(req.getParameter("bed_type_code")));
			hashData.put("strTodc",todailycharge+"");
			hashData.put("frpractitionerid",checkForNull(req.getParameter("fr_practitioner_id")));
			hashData.put("frspecialitycode",checkForNull(req.getParameter("fr_speciality_code")));
			hashData.put("frbedclass",checkForNull(req.getParameter("fr_bed_class")));
			hashData.put("frnursingunitcode",checkForNull(req.getParameter("fr_nursing_unit_code")));
			hashData.put("frservicecode",checkForNull(req.getParameter("fr_service_code")));
			hashData.put("frsubservcode",checkForNull(req.getParameter("fr_subservice_code")));
			hashData.put("frbedno",checkForNull(req.getParameter("fr_bed_no")));
			hashData.put("frroomno",checkForNull(req.getParameter("fr_room_no")));
			hashData.put("strFrdc",frdailycharge+"");
			hashData.put("frbedtype",checkForNull(req.getParameter("fr_bed_type")));
			hashData.put("modified_bed_type_code",checkForNull(req.getParameter("modified_bed_type_code")));
			hashData.put("addedAtWorkstation",p.getProperty("client_ip_address"));
			hashData.put("bl_interface_yn",bl_interface_yn);
			hashData.put("bl_operational",checkForNull(req.getParameter("bl_operational"),"N"));
			hashData.put("encounter_id",eid);
			hashData.put("frteamid",checkForNull(req.getParameter("fr_team_id")));
			hashData.put("toteamid",checkForNull(req.getParameter("team_id")));
			hashData.put("f_modifiedDate","");
			hashData.put("blocking_type",checkForNull(req.getParameter("blocking_type")));
			hashData.put("blocking_type_code",checkForNull(req.getParameter("blocking_type_code")));
			hashData.put("bed_blk_period",checkForNull(req.getParameter("bed_blocking_period")));
			hashData.put("blk_remark", checkForNull(req.getParameter("bed_block_remarks")));
			hashData.put("change_bed_class_yn", checkForNull(req.getParameter("change_bed_class_yn")));
			hashData.put("bed_class_allowed", checkForNull(req.getParameter("bed_class_allowed")));
			hashData.put("call_function", call_function);
			hashData.put("reason_request", reason_request);
			hashData.put("cancel_reason", checkForNull(req.getParameter("resnforrej")));
			hashData.put("tran_type", tran_type);
			hashData.put("ipparam_bed_yn", checkForNull(req.getParameter("ipparam_bed_yn")));
			hashData.put("pseudo_bed_yn", checkForNull(req.getParameter("pseudo_bed_yn")));
			hashData.put("deactivate_pseudo_bed_yn", checkForNull(req.getParameter("deactivate_pseudo_bed_yn")));
			hashData.put("mother_bed_status", checkForNull(req.getParameter("mother_bed_status")));
			hashData.put("change_bed_YN", change_bed_YN);
			hashData.put("patient_class", checkForNull(req.getParameter("patient_class")));
			hashData.put("override_yn", checkForNull(req.getParameter("override_yn")));
			hashData.put("patientgender",checkForNull(req.getParameter("open_enctr_gender")));
			hashData.put("dateofbirth",checkForNull(req.getParameter("open_enctr_age")));
			hashData.put("admission_date",checkForNull(req.getParameter("admission_date")));
			hashData.put("is_reserved_bed_checked",checkForNull(req.getParameter("is_reserved_bed_checked")));
			hashData.put("reason_for_reserved_bed",checkForNull(req.getParameter("reason_for_reserved_bed")));
			hashData.put("confirm_yn",checkForNull(req.getParameter("confirm_yn")));
			hashData.put("is_to_bed_equals_reserve_bed",checkForNull(req.getParameter("is_to_bed_equals_reserve_bed")));
			hashData.put("reserve_bed_no",checkForNull(req.getParameter("reserve_bed_no")));
			hashData.put("reserve_nurs_unit_code",checkForNull(req.getParameter("reserve_nurs_unit_code")));
			hashData.put("reserve_room_no",checkForNull(req.getParameter("reserve_room_no")));
			hashData.put("sdate",checkForNull(req.getParameter("sdate")));
			hashData.put("reserve_specialty_code",checkForNull(req.getParameter("reserve_specialty_code")));
			hashData.put("reserve_practitioner_id",checkForNull(req.getParameter("reserve_practitioner_id")));
			hashData.put("reserve_bed_type_code",checkForNull(req.getParameter("reserve_bed_type_code")));
			hashData.put("reserve_service_code",checkForNull(req.getParameter("reserve_service_code")));
			hashData.put("reserve_bed_class_code",checkForNull(req.getParameter("reserve_bed_class_code")));
			hashData.put("reserve_bed_on_tfr_yn",checkForNull(req.getParameter("reserve_bed_on_tfr_yn")));
			hashData.put("transfer_date",checkForNull(req.getParameter("transfer_date")));
			hashData.put("transfer_wo_delink_yn",checkForNull(req.getParameter("transfer_wo_delink_yn"),"N"));//Added for the CRF - HSA-CRF-0035

			/*Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 Start*/
			hashData.put("bl_adm_remarks",checkForNull(req.getParameter("bl_adm_remarks")));
			hashData.put("bl_bed_request",checkForNull(req.getParameter("bl_bed_request")));
			hashData.put("bl_bed_type_code",checkForNull(req.getParameter("bl_bed_type_code")));
			/*Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 End*/


			hashData.put("reqRadioBtn",checkForNull(req.getParameter("reqRadioBtn")));//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		
			java.util.HashMap results = new java.util.HashMap();
				boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPPatientEmergencyTransfer",IPPatientEmergencyTransferHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = hashData;
				
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = hashData.getClass();

				results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPPatientEmergencyTransfer",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			
			boolean CALL_REPORT = false;
			boolean inserted    = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			CALL_REPORT = ( ((Boolean) results.get( "call_report" )).booleanValue() ) ;
			
			error = (String) results.get("error") ;
			
			msg1 = (String) results.get("msg1") ;
			
			if(msg1==null) msg1="";

			if(error.lastIndexOf("<br>")>=0)	
				error = error.substring(0,error.lastIndexOf("<br>"));

			

			if(inserted)
			{
				String  strBLMessage ="0";
				String strBLSpecialMessage ="0";
				if (bl_interface_yn.equals("Y"))	 
				{
					try
					{
						strBLMessage = (String) results.get( "bl_message" );
						if (strBLMessage != null)
						{
							strBLMessage = strBLMessage.trim();
							if ( (strBLMessage.equals("")) || (strBLMessage.equalsIgnoreCase("null")) )
							{
								strBLMessage = "0";
							}
						}
						else
						{
							strBLMessage = "0";
						}

						strBLSpecialMessage = (String) results.get( "bl_special_message" );
						if (strBLSpecialMessage  != null)
						{
							strBLSpecialMessage  = strBLSpecialMessage.trim();
							if ( strBLSpecialMessage.equals("")) 
							{
								strBLSpecialMessage = "0";
							}
						}
						else
						{
							strBLSpecialMessage = "0";
						}

						if (!(strBLMessage.equals("0")))
						{
							out.println("<script>alert('"+strBLMessage+"')</script>");
						}

						if (!(strBLSpecialMessage.equals("0")))
						{
							out.println("<script>alert('"+strBLSpecialMessage+"')</script>");
						}
					}
					catch (Exception exceptionBL)
					{
						strBLMessage = "0";
						exceptionBL.printStackTrace();
					}
				}
				
				if (!(msg1.equals(""))) {
				out.print("<script>alert('"+msg1+"')</script>");
				}
				
				out.print("<script>alert('"+error+"')</script>");

				if(CALL_REPORT)
					doOnlineReports(req,res,eid,tonursingunitcode, facilityId, patientid);
				
				out.print("<script>top.window.document.getElementById('dialog_tag').close();</script>");
			}else{
				
				out.print("<script>alert('"+error+"');</script>");
				out.println("<script>if(parent.frames[1].document.Emergency_Transfer_form.confirm.disabled==true)parent.frames[1].document.Emergency_Transfer_form.confirm.disabled=false;</script>");
			}

			hashData.clear();
			results.clear();

		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	private void doOnlineReports(HttpServletRequest req,HttpServletResponse res,String encounter_id, String nursing_unit, String facilityId, String patientid) throws ServletException, IOException, SQLException
	{
		Connection con				= null; 
		java.util.Properties p		= null;
		HttpSession session			= null;
		PrintWriter out				= null;
		ResultSet rset				= null;
		PreparedStatement pstmt		= null;
		out									= res.getWriter();
		session						= req.getSession(false);
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		
		String locale				= "";
		String sStyle				= "";
		locale						= p.getProperty("LOCALE");
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		String sqlString = "";		
		String clinic_type = "N";
		String wristBandLbl = "";
		int n_Age = 0;
		String age = "";
		try
		{
			con = ConnectionManager.getConnection(p);
			String wristBandSql = "select calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year from MP_PATIENT where patient_id = '"+patientid+"'";
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(wristBandSql);
			rset = pstmt.executeQuery();

			if (rset != null && rset.next())
				age = checkForNull(rset.getString("year"));

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			n_Age = Integer.parseInt(age);

			if(n_Age <= 2)
				wristBandLbl = "IPBWBLBL";
			else
				wristBandLbl = "IPBINWBL";

		}catch(Exception repEx)
		{
			repEx.printStackTrace();
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}

		sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where b.language_id='"+locale+"' and a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_conform_transfer_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"' and a.report_id = b.report_id and a.report_id not in ('"+wristBandLbl+"') order by 2 ";

		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
		String reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+patientid+"";
		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language = 'JavaScript'>" );
		htmlFor.append(" async function callShowmodal() {");
		htmlFor.append("  var dialogHeight    = '25' ;");
		htmlFor.append(" var dialogWidth = '65' ;"); 
		htmlFor.append("var dialogTop = 58;" );
		htmlFor.append("  var arguments	=	''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=EMERGENCY_TRANSFER&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal			=	await window.showModalDialog(getUrl,arguments,features); parent.window.document.getElementById('dialog_tag').close();}");
		htmlFor.append(" callShowmodal()");
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
