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

import eIP.IPConfirmCancelTransfer.* ;

public class ConfirmCancelTransferServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	java.util.Properties p; 
	String facilityId;
	String sStyle;
	String bookingrefno			="";
	String locale				= "" ;
	

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
		sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");

		try 
		{
			this.out = res.getWriter();
			String patientid						= checkForNull(req.getParameter("patient_id"));
			Connection con					= null;
			boolean proceed					= true;
			Statement entitle_stmt			= null;
			PreparedStatement entitle_pstmt = null;
			ResultSet entitle_rs			= null;

			Statement stmt					= null;
			ResultSet rs					= null;

			String status					= "";
			String msg						= "";
			String entitlement_by_pat_cat_yn= "";
		    bookingrefno			= checkForNull(req.getParameter("booking_ref_no"));
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
					message.clear();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				String tfr_req_status="";

				String function  = checkForNull(req.getParameter("confirm_or_cancel"));
				String modified_date_val = checkForNull(req.getParameter("modified_date_val"));
					String encounter_id = checkForNull(req.getParameter("encounter_id"));
					StringBuffer strBuffer = new StringBuffer();
					strBuffer.append(" select TFR_REQ_STATUS,TO_CHAR(modified_date, 'dd/mm/rrrr hh24:mi') modified_date FROM IP_TRANSFER_REQUEST where facility_id = '");
					strBuffer.append(facilityId);
					strBuffer.append("' and encounter_id = '");
					strBuffer.append(encounter_id);
					strBuffer.append("' ");
					strBuffer.append(" and tfr_req_ref_no = '"+bookingrefno+"' ");

					stmt = con.createStatement();
					rs = stmt.executeQuery(strBuffer.toString());
					String modifiedDate_value = "";
					if (rs.next())
					{
						modifiedDate_value = checkForNull(rs.getString("modified_date"));
						tfr_req_status = checkForNull(rs.getString("TFR_REQ_STATUS"));
					}
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				if(function.equals("Confirm") && proceed)
				{
					if(tfr_req_status.equals("1"))
					{
						proceed=false;
						java.util.Hashtable errMsg = MessageManager.getMessage(locale,"REQUEST_CONFIRMED","IP");
						msg = (String)errMsg.get("message");
						if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("<script>alert('"+msg+"')</script>");
						out.println("<script>top.window.document.getElementById('dialog_tag').close(); </script>");
						errMsg.clear();
					}
					else
						proceed=true;
					if(modifiedDate_value.equals(modified_date_val) && proceed)
					{
						proceed = true;
					}
					else
					{
						proceed = false;
						java.util.Hashtable errMsg = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
						msg = (String)errMsg.get("message");
						if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("<script>alert('"+msg+"')</script>");
						out.println("<script>top.window.document.getElementById('dialog_tag').close(); </script>");
						errMsg.clear();
					}
				}
				else{
					if(tfr_req_status.equals("0"))
					{
						proceed=true;
					}
					else
					{
						proceed = false;
						java.util.Hashtable errMsg = MessageManager.getMessage(locale,"REQUEST_CANCELLED","IP");
						msg = (String)errMsg.get("message");
						if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("<script>alert('"+msg+"')</script>");
						out.println("<script>top.window.document.getElementById('dialog_tag').close(); </script>");
						errMsg.clear();
					}
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
				IPConfirmCancelTransfer(req, res, patientid);
			}
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}

	private void IPConfirmCancelTransfer(HttpServletRequest req, HttpServletResponse res, String patientid)	
	{
		Connection con	= null;
		String bl_interface_yn =	checkForNull(req.getParameter("bl_interfaced_yn"),"N");
/*
		if(bl_interface_yn.equals("Y"))
		{
			//	transfer_chargeable_yn	=	checkForNull(req.getParameter("transfer_chargeable_yn"),"N");
			//	surgery_reqd_yn			=	checkForNull(req.getParameter("surgery_reqd_yn"),"N");
			//	transfer_serv_charge	=	checkForNull(req.getParameter("transfer_serv_charge"));
			//	addnl_dep_amt			=	checkForNull(req.getParameter("addnl_dep_amt"));
			//	if(!transfer_serv_charge.equals(""))
			//		transferservcharge			= transfer_serv_charge;
			//	if(!addnl_dep_amt.equals(""))
			//		addnldepamt				= addnl_dep_amt;
		}
*/
		String todailycharge = "0";
		String frdailycharge = "0";

		String bookingrefnum			= checkForNull(req.getParameter("booking_ref_no"));
		String frdc						= checkForNull(req.getParameter("from_daily_rate"));
		if(!frdc.equals(""))
			frdailycharge			= frdc;

		String todc					= checkForNull(req.getParameter("to_daily_rate"));
		if(!todc .equals(""))	
			todailycharge				= todc;
			
			
		try 
		{
			con = ConnectionManager.getConnection(req);
			String error="";
			HashMap hashData = new HashMap();
			
			hashData.put("facilityId",facilityId);
			hashData.put("patientid",patientid);
			hashData.put("encounter_id",checkForNull(req.getParameter("encounter_id")));
			hashData.put("transferdate",checkForNull(req.getParameter("transfer_date")));
			hashData.put("transfertype",checkForNull(req.getParameter("transfer_type")));
			hashData.put("fr_practitioner_id",checkForNull(req.getParameter("fr_practitioner_id")));
			hashData.put("tospecialitycode",checkForNull(req.getParameter("Splcode")));
			hashData.put("tobedclass",checkForNull(req.getParameter("Bedcode")));
			hashData.put("tonursingunitcode",checkForNull(req.getParameter("nursing_unit")));
			hashData.put("tonursingunittype",checkForNull(req.getParameter("to_nursing_unit_type")));
			hashData.put("tobedno",checkForNull(req.getParameter("to_bed_no")));
			hashData.put("tobedtype",checkForNull(req.getParameter("bed_type_code")));
			hashData.put("toroomno",checkForNull(req.getParameter("to_room_no")));
			hashData.put("todailycharge",todailycharge);
			hashData.put("frbedclass",checkForNull(req.getParameter("fr_bed_class")));
			hashData.put("frnursingunitcode",checkForNull(req.getParameter("fr_nursing_unit_code")));
			hashData.put("frbedno",checkForNull(req.getParameter("fr_bed_no")));
			hashData.put("frroomno",checkForNull(req.getParameter("fr_room_no")));
			hashData.put("frdailycharge",frdailycharge);
			hashData.put("frbedtype",checkForNull(req.getParameter("fr_bed_type")));
			hashData.put("modified_bed_type_code",checkForNull(req.getParameter("modified_bed_type_code")));
			hashData.put("confirmorcancel",checkForNull(req.getParameter("confirm_or_cancel")));
			hashData.put("bookingrefno",bookingrefnum.trim());
			hashData.put("patientgender",checkForNull(req.getParameter("patient_gender")));
			hashData.put("client_ip_address",p.getProperty("client_ip_address"));
			hashData.put("bl_interface_yn",bl_interface_yn);
			hashData.put("bl_operational",checkForNull(req.getParameter("bl_operational"),"N"));
			hashData.put("fr_service_code",checkForNull(req.getParameter("fr_service_code")));
			hashData.put("to_practitioner_id",checkForNull(req.getParameter("to_practitioner_id")));
			hashData.put("fr_specialty_code",checkForNull(req.getParameter("fr_specialty_code")));
			hashData.put("to_service_code",checkForNull(req.getParameter("to_service_code")));
			hashData.put("pri_target",checkForNull(req.getParameter("pri_target")));
			hashData.put("priority_code",checkForNull(req.getParameter("priority_code")));
			hashData.put("blocktype","");
			hashData.put("authorized_practid",checkForNull(req.getParameter("authorized_practid")));
			hashData.put("reason_for_cancelation",checkForNull(req.getParameter("reason_for_cancelation")));
			hashData.put("block_bed_period",checkForNull(req.getParameter("bed_block_periond"),"0"));
			hashData.put("override",checkForNull(req.getParameter("override")));
			hashData.put("blocking_remarks",checkForNull(req.getParameter("blocking_remarks")));
			//Maheshwaran added for GHL-CRF-0362
			hashData.put("toservice",checkForNull(req.getParameter("service")));
			hashData.put("tonursing_unit",checkForNull(req.getParameter("nursing_unit")));
			hashData.put("tosub_service",checkForNull(req.getParameter("sub_service")));
			hashData.put("toSplcode",checkForNull(req.getParameter("Splcode")));
			hashData.put("topractid",checkForNull(req.getParameter("practid4")));
			hashData.put("team_id",checkForNull(req.getParameter("team_id")));
			hashData.put("bed_change",checkForNull(req.getParameter("bed_change")));
			hashData.put("ipparam_bed_yn",checkForNull(req.getParameter("ipparam_bed_yn")));
			hashData.put("bl_operational", checkForNull(req.getParameter("bl_operational")));
			hashData.put("oper_stn_bed_class_yn",checkForNull(req.getParameter("change_bed_class_yn")));
			
			//End

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPConfirmCancelTransfer",IPConfirmCancelTransferHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPConfirmCancelTransfer",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = (((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
//			error = error.substring(0,error.indexOf("<br>"));

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
					}catch (Exception exceptionBL)
					{
						strBLMessage = "0";
						exceptionBL.printStackTrace();
					}
				}//End of BL interface
			
				out.println("<script>alert('"+error+"')</script>");
				out.println("<script>top.window.document.getElementById('dialog_tag').close(); </script>");
			}
			else
			{
				if(error.indexOf("Exception") == -1)
				{
					out.println("<script>parent.frames[1].document.forms[0].confirm_or_cancel.disabled = false;</script>");
				}
				out.print("<script>alert('"+error+"')</script>");
			}
			hashData.clear();
			results.clear();
		} catch ( Exception e ) 
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}

	private void doOnlineReports(String encounter_id, String nursing_unit, String patientid) throws ServletException, IOException, SQLException
	{
		String sqlString = "";		
		String clinic_type = "N";
		sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where b.language_id='"+locale+"' and a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_conform_transfer_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id order by 2 ";

		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
		String reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+patientid+"";

		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>" );
		htmlFor.append("  var dialogHeight    = '25' ;");
		htmlFor.append(" var dialogWidth = '65' ;");
		htmlFor.append("var dialogTop = 58;" );
		htmlFor.append("  var arguments	=	''; ");
		htmlFor.append("  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal			=	window.showModalDialog(getUrl,arguments,features); parent.window.close();");
		htmlFor.append(" </script>"  );
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
