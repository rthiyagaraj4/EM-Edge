/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
import com.ehis.util.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import eIP.IPTransferPatientIn.* ;

public class TransferPatientInServlet extends javax.servlet.http.HttpServlet
{
	

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		PrintWriter out			= null;
		Properties p			= null;
		HttpSession session		= null;
		String facilityId		= "";
		String sStyle			= "";
		String locale			= "" ;
		boolean proceed			= true;
		Connection con			= null;
		Statement entitle_stmt  = null;
		PreparedStatement entitle_pstmt = null;
		ResultSet entitle_rs	= null;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		out						= res.getWriter();
		p						= (Properties) session.getValue( "jdbc" ) ;
		facilityId				= (String) session.getValue( "facility_id" ) ;
		String patientid		= "";
		String eid				= "";
		String status			= "";
		String msg				= "";
		String entitlement_by_pat_cat_yn = "";
		try
		{
			locale				= p.getProperty("LOCALE");
			patientid			= checkForNull(req.getParameter("patient_id"));
			eid					= checkForNull(req.getParameter("encounter_id"));
			
			try
			{
				con = ConnectionManager.getConnection(req);
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
					entitle_pstmt.setString(5,checkForNull(req.getParameter("nursing_unit_code")));
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
					out.println("<script>alert(\""+msg+"\");parent.document.getElementById('dialog_tag').close();</script>");
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
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}				


			if(proceed)
			{
				IPTransferPatientIn(req,res, eid, patientid);
			}
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

	private void IPTransferPatientIn(HttpServletRequest req, HttpServletResponse res, String eid, String patientid)throws java.io.IOException	
	{	
		PrintWriter out					= null;
		Properties p					= null;
		HttpSession session				= null;
		String facilityId				= "";
		String sStyle					= "";
		String locale					= "" ;
		out								= res.getWriter();
		session							= req.getSession(false);
		sStyle							= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		p								= (Properties) session.getValue( "jdbc" ) ;
		facilityId						= (String) session.getValue( "facility_id" ) ;
		//boolean proceed					= true;
		//Statement entitle_stmt			= null;
		//PreparedStatement entitle_pstmt = null;
		//ResultSet entitle_rs			= null;
		Connection con					= null;
		String transfer_chargeable_yn	= "";
		String surgery_reqd_yn			= "";
		String transfer_serv_charge		= "";
		String addnl_dep_amt			= "";
		String tobedtype				= "";
		String frdc						= "";
		String frdailycharge			= "";
		String todc						= "";
		String todailycharge			= "";
		String Bedcode					= "";
		String bl_interface_yn			= "";
		String transferdate				= "";
		String info_date_time			= "";
		String auth_date_time			= "";
		String trn_in_date				= "";
		String year						= ""; 
		String transfer_in_status		= "";
		String tonursingunitcode		= "";
		String arrival_date_time        = ""; // added by mujafar for ML-MMOH-CRF-1136
		String isArrivalDateAppl        = "";
		locale							= p.getProperty("LOCALE");
		tonursingunitcode				= checkForNull(req.getParameter("nursing_unit_code"));
		tobedtype						= checkForNull(req.getParameter("to_bed_type"));
		if(tobedtype.equals(""))
			tobedtype					= checkForNull(req.getParameter("hid_bed_type"));

		frdc							= req.getParameter("from_daily_rate")==null?"0":req.getParameter("from_daily_rate");
		frdailycharge					= frdc;
		todc							= checkForNull(req.getParameter("to_daily_rate"));
		todailycharge					= todc;
		transfer_in_status				= checkForNull(req.getParameter("transfer_status"));

		Bedcode							= checkForNull(req.getParameter("Bedcode"));
		if(Bedcode.equals(""))
			Bedcode						= checkForNull(req.getParameter("hid_bed_code"));

		bl_interface_yn					= checkForNull(req.getParameter("bl_interface_yn"),"N");
		if((bl_interface_yn==null) ||(bl_interface_yn.equals("null")))bl_interface_yn="N";
		if(bl_interface_yn.equals("Y"))
		{
			transfer_chargeable_yn		=	req.getParameter("transfer_chargeable_yn");
			surgery_reqd_yn				=	req.getParameter("surgery_reqd_yn");
			transfer_serv_charge		=	req.getParameter("transfer_serv_charge");
			addnl_dep_amt				=	req.getParameter("addnl_dep_amt");

			if((transfer_chargeable_yn==null) ||(transfer_chargeable_yn.equals("null")))
				transfer_chargeable_yn="N";
			if((surgery_reqd_yn==null) ||(surgery_reqd_yn.equals("null")))
				surgery_reqd_yn="N";
			if((transfer_serv_charge==null) ||(transfer_serv_charge.equals("null")))
				transfer_serv_charge="";
			if((addnl_dep_amt==null) ||(addnl_dep_amt.equals("null")))
				addnl_dep_amt="";
		}
		
		transferdate					=	checkForNull(req.getParameter("transfer_date"));
		transferdate					= DateUtils.convertDate(transferdate,"DMYHM",locale,"en");
		
		info_date_time					= checkForNull(req.getParameter("info_date_time"));
		info_date_time					= DateUtils.convertDate(info_date_time,"DMYHM",locale,"en");
		
		auth_date_time					= checkForNull(req.getParameter("auth_date_time"));
		auth_date_time					= DateUtils.convertDate(auth_date_time,"DMYHM",locale,"en");
		//String is_reserved_bed_checked = checkForNull(req.getParameter("is_reserved_bed_checked"));
		//String reserve_bed_no = checkForNull(req.getParameter("reserve_bed_no"));
		//String reserve_nurs_unit_code = checkForNull(req.getParameter("reserve_nurs_unit_code"));
		//String reserve_room_no = checkForNull(req.getParameter("reserve_room_no"));
		trn_in_date						= checkForNull(req.getParameter("pref_date"));
		trn_in_date						= DateUtils.convertDate(trn_in_date,"DMYHM",locale,"en");
		year							= checkForNull(req.getParameter("year"));
		arrival_date_time               = checkForNull(req.getParameter("arrival_date"));  // added by mujafar for ML-MMOH-CRF-1136
		arrival_date_time               = DateUtils.convertDate(arrival_date_time,"DMYHM",locale,"en");
		isArrivalDateAppl               = checkForNull(req.getParameter("isArrivalDateAppl"));
		
	try 
	{
		con = ConnectionManager.getConnection(req);
		String error="";
		HashMap hashData = new HashMap();
		hashData.put("modified_date_val", checkForNull(req.getParameter("modified_date_val")));
		hashData.put("tfr_req_type", checkForNull(req.getParameter("tfr_req_type")));
		hashData.put("facilityId",facilityId);
		hashData.put("patientid",patientid);
		hashData.put("encounterid",eid);
		hashData.put("transferdate",transferdate);
		hashData.put("transfertype",checkForNull(req.getParameter("transfer_type")));
		hashData.put("topractitionerid",checkForNull(req.getParameter("practid")));
		hashData.put("tospecialitycode",checkForNull(req.getParameter("Splcode")));
		hashData.put("tobedclass",checkForNull(req.getParameter("Bedcode")));
		hashData.put("tonursingunitcode",checkForNull(req.getParameter("nursing_unit_code")));
		hashData.put("tonursingunittype",checkForNull(req.getParameter("to_nursing_unit_locn_type")));
		hashData.put("tobedno",checkForNull(req.getParameter("to_bed_no")));
		hashData.put("tobedtype",tobedtype);
		hashData.put("toroomno",checkForNull(req.getParameter("to_room_no")));
		hashData.put("todailycharge",todailycharge);
		hashData.put("frbedclass",checkForNull(req.getParameter("fr_bed_class")));
		hashData.put("frnursingunitcode",checkForNull( req.getParameter("fr_nursing_unit_code")));
		hashData.put("frbedno",checkForNull(req.getParameter("fr_bed_no")));
		hashData.put("frroomno",checkForNull(req.getParameter("fr_room_no")));
		hashData.put("frdailycharge",frdailycharge);
		hashData.put("frbedtype",checkForNull(req.getParameter("fr_bed_type")));
		hashData.put("modified_bed_type_code",checkForNull(req.getParameter("modified_bed_type_code")));
		hashData.put("confirmorcancel",checkForNull(req.getParameter("confirm_or_cancel")));
		hashData.put("bookingrefno",checkForNull(req.getParameter("booking_ref_no")));
		hashData.put("patientgender",checkForNull(req.getParameter("patient_gender")));
		hashData.put("addedAtWorkstation",p.getProperty("client_ip_address"));
		hashData.put("bl_interface_yn",bl_interface_yn);
		hashData.put("bl_operational",checkForNull(req.getParameter("bl_operational"),"N"));
		hashData.put("encounter_id",eid);
		hashData.put("admission_date",checkForNull(req.getParameter("admission_date")));
		hashData.put("admission_type",checkForNull(req.getParameter("admission_type")));
		hashData.put("transfer_in_status",checkForNull(req.getParameter("transfer_status")));
		hashData.put("priority",checkForNull(req.getParameter("priority")));
		hashData.put("nursing_unit_desc",checkForNull(req.getParameter("nursing_unit_desc")));
		hashData.put("nursing_unit",checkForNull(req.getParameter("nursing_unit_code")));
		hashData.put("service",checkForNull(req.getParameter("service")));
		hashData.put("sub_service",checkForNull(req.getParameter("sub_service")));
		hashData.put("Bedcode",Bedcode);
		hashData.put("Splcode_desc",checkForNull(req.getParameter("Splcode_desc")));
		hashData.put("Splcode",checkForNull(req.getParameter("Splcode")));
		hashData.put("practid",checkForNull(req.getParameter("practid")));
		hashData.put("pract_desc",checkForNull(req.getParameter("pract_desc")));
		hashData.put("practid_desig",checkForNull(req.getParameter("practid_desig")));
		hashData.put("team_id",checkForNull(req.getParameter("team_id")));
		hashData.put("info_pat_relatives",checkForNull(req.getParameter("info_pat_relatives")));
		hashData.put("block_date_time",checkForNull(req.getParameter("block_date_time"),"0"));
		hashData.put("inform_to",checkForNull(req.getParameter("inform_to")));
		hashData.put("info_date_time",info_date_time);
		hashData.put("informed_name",checkForNull(req.getParameter("info_pat_name")));
		hashData.put("auth_date_time",auth_date_time);
		hashData.put("port_received_yn",checkForNull(req.getParameter("port_received_yn1")));
		hashData.put("port_remarks",checkForNull(req.getParameter("port_remarks1")));
		hashData.put("received",checkForNull(req.getParameter("received1")));
		hashData.put("cancel_reason",checkForNull(req.getParameter("cancel_reason")));
		hashData.put("porterage_hid",checkForNull(req.getParameter("porterage_hid")));
		hashData.put("frservicecode",checkForNull(req.getParameter("fr_service_code")));
		hashData.put("fr_sub_service_code",checkForNull(req.getParameter("fr_sub_service_code")));
		hashData.put("fr_speciality_code",checkForNull(req.getParameter("fr_speciality_code")));
		hashData.put("fr_practitioner_id",checkForNull(req.getParameter("fr_practitioner_id")));
		hashData.put("fr_team_id",checkForNull(req.getParameter("fr_team_id")));
		hashData.put("block_type_code",checkForNull(req.getParameter("blocking_type_code")));
		hashData.put("deactivate_pseudo_bed_yn", checkForNull(req.getParameter("deactivate_pseudo_bed_yn")));
		hashData.put("mother_bed_status", checkForNull(req.getParameter("mother_bed_status")));
		hashData.put("bed_block_remark",checkForNull(req.getParameter("blocking_remarks")));
		hashData.put("patient_class", checkForNull(req.getParameter("patient_class")));
		hashData.put("dateofbirth", checkForNull(req.getParameter("age")));
		hashData.put("DOB", checkForNull(req.getParameter("DOB")));
		hashData.put("is_reserved_bed_checked",checkForNull(req.getParameter("is_reserved_bed_checked")));
		hashData.put("reason_for_reserved_bed",checkForNull(req.getParameter("reason_for_reserved_bed")));
		hashData.put("confirm_yn",checkForNull(req.getParameter("confirm_yn")));
		hashData.put("is_to_bed_equals_reserve_bed",checkForNull(req.getParameter("is_to_bed_equals_reserve_bed")));
		hashData.put("reserve_bed_no",checkForNull(req.getParameter("reserve_bed_no")));
		hashData.put("reserve_nurs_unit_code",checkForNull(req.getParameter("reserve_nurs_unit_code")));
		hashData.put("reserve_room_no",checkForNull(req.getParameter("reserve_room_no")));
		hashData.put("sdate",checkForNull(req.getParameter("sysdate")));
		hashData.put("reserve_specialty_code",checkForNull(req.getParameter("reserve_specialty_code")));
		hashData.put("reserve_practitioner_id",checkForNull(req.getParameter("reserve_practitioner_id")));
		hashData.put("reserve_bed_type_code",checkForNull(req.getParameter("reserve_bed_type_code")));
		hashData.put("reserve_service_code",checkForNull(req.getParameter("reserve_service_code")));
		hashData.put("reserve_bed_class_code",checkForNull(req.getParameter("reserve_bed_class_code")));
		hashData.put("reserve_bed_on_tfr_yn",checkForNull(req.getParameter("reserve_bed_on_tfr_yn")));
		hashData.put("blocking_period",checkForNull(req.getParameter("blocking_period")));
		hashData.put("allow_multiple_bed_for_resv_yn",checkForNull(req.getParameter("allow_multiple_bed_for_resv_yn")));
		hashData.put("exp_discharge_date_time",checkForNull(req.getParameter("exp_discharge_date_time")));
		hashData.put("transfer_wo_delink_yn",checkForNull(req.getParameter("transfer_wo_delink_yn"),"N"));//Added for the CRF - HSA-CRF-0035
		hashData.put("arrival_date_time",arrival_date_time);  // added by mujafar for ML-MMOH-CRF-1136
		hashData.put("isArrivalDateAppl",isArrivalDateAppl);
		
		

		boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPTransferPatientIn",IPTransferPatientInHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = hashData;
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = hashData.getClass();
		HashMap results = (HashMap)(busObj.getClass().getMethod("insertIPTransferPatientIn",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue()) ;
		error = (String) results.get("error") ;
		
				if(inserted)
				{

					if(error.lastIndexOf("<br>") >= 0)
					error = error.substring(0,error.lastIndexOf("<br>"));

					// Added by jithesh
					// MOD#02
					// Billing Logic for the Message **/
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
					}//End of BL interface
					// End of MOD#02
					// End Add
					out.println("<script>alert('"+error+"')</script>");
					if(transfer_in_status.equals("01"))
					{
						doOnlineReports(req,res,eid, tonursingunitcode, con, patientid,year);
					}
					out.println("<script>parent.parent.document.getElementById('dialog_tag').close();</script>");

				} 
				else
				{
					
					if(!bl_interface_yn.equals("Y"))
					{
						if(error.indexOf("<br>")!=-1)
						error = error.substring(0,error.indexOf("<br>"));
						out.print("<script>alert('"+error+"')</script>");
						//out.println("<script>parent.frames(2).document.forms(0).button_s.disabled = false;</script>");
						out.println("<script>parent.frames[5].button_s.disabled = false;</script>");
					}
					else
					{
						out.print("<script>alert('"+error+"')</script>");
						out.println("<script>parent.frames[5].button_s.disabled = false;</script>");
					}

					out.println("<script>parent.document.getElementById('dialog_tag').close();</script>");
				}
		hashData.clear();
		results.clear();
		} catch ( Exception e ) {

			
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con,req);
		}
	}

	private void doOnlineReports(HttpServletRequest req, HttpServletResponse res,String encounter_id, String nursing_unit_val, Connection connection, String patientid,String year ) throws ServletException, IOException, SQLException
	{
		PrintWriter out					= null;
		Properties p					= null;
		HttpSession session				= null;
		String facilityId				= "";
		String sStyle					= "";
		String locale					= "" ;
		out								= res.getWriter();
		session							= req.getSession(false);
		sStyle							= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		p								= (Properties) session.getValue( "jdbc" ) ;
		facilityId						= (String) session.getValue( "facility_id" ) ;
		String wristBandLbl				= "";
		locale							= p.getProperty("LOCALE");
		try
		{
			int n_Age = 0;
			/*
			String wristBandSql = "select calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year from MP_PATIENT where patient_id = '"+patientid+"'";

			pstmt = connection.prepareStatement(wristBandSql);
			rset = pstmt.executeQuery();

			if (rset != null && rset.next())
				age = checkForNull(rset.getString("year"));

			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			*/
			n_Age = Integer.parseInt(year);
			if(n_Age <= 2)
				wristBandLbl = "IPBWBLBL";
			else
				wristBandLbl = "IPBINWBL";

		}catch(Exception repEx)
		{
			repEx.printStackTrace();
		}

		String sqlString = "";	
		String clinic_type = "N";
		sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where b.language_id='"+locale+"' and  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_conform_transfer_yn='Y' and a.nursing_unit_code ='"+nursing_unit_val+"'  and a.report_id = b.report_id and a.report_id not in ('"+wristBandLbl+"') order by 2 ";
		
		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
		String reportParamValues = ""+encounter_id+","+nursing_unit_val+","+clinic_type+","+patientid+"";

		StringBuffer htmlFor = new StringBuffer();
		
		htmlFor.append( " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append( "</head><body class='message'>");
		htmlFor.append( "<script language = 'JavaScript'>" );
		htmlFor.append( "  var dialogHeight    = '25' ;");
		htmlFor.append(  " var dialogWidth = '65' ;");
		htmlFor.append(  "var dialogTop = 58;" );
		htmlFor.append( "  var arguments	=	''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append( "  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=TRANSFER_PATIENT_IN&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_val+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append( " var features  = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append( "  retVal			=	window.showModalDialog(getUrl,arguments,features); parent.document.getElementById('dialog_tag').close();");
		htmlFor.append( "</script>" );
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
 
