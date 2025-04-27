/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.SingleThreadModel;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eIP.IPDischargePatient.IPDischargePatientHome;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public class DischargePatientServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter		out;
	Properties		p;
	String sStyle				= "";
	String locale				= "" ;
	boolean refMsgChangeAppl;     // added by mano

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	{
		Connection connection	= null;
		HttpSession session		= req.getSession(false);
		Statement stmt			= null;
		ResultSet rs			= null;
		String dis_adv_status	= "";
		String dis_Adv_Srl_No	= "";
		String encounterid		= "";
		String patientid		= "";
		String adt_status		= "";
		String facilityId		= checkForNull((String)session.getValue("facility_id"));
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue 
	req= new XSSRequestWrapper(req); 
	res.addHeader("X-XSS-Protection", "1; mode=block");
	res.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue


		try 
		{
			connection					    = ConnectionManager.getConnection(req);
			refMsgChangeAppl =eCommon.Common.CommonBean.isSiteSpecific(connection, "OP","REF_REQUIRED_PATIENT"); //added by mano
			this.out						= res.getWriter();
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callDischargePatientServeltHTML() { ");
			patientid						= checkForNull(req.getParameter("patient_id"));
			encounterid						= checkForNull(req.getParameter("encounter_id"));
			
			String sql=" select a.dis_adv_status, a.dis_Adv_Srl_No, b.adt_status from IP_DISCHARGE_ADVICE a, pr_encounter b where a.facility_id = '"+facilityId+"' and a.encounter_id = '"+encounterid+"' and a.dis_adv_srl_no = ( select max(dis_Adv_Srl_No) from IP_DISCHARGE_ADVICE where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ) and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id";
			stmt	    = connection.createStatement();
			rs		    = stmt.executeQuery(sql);
			if(rs.next())
			{
			   dis_adv_status	= checkForNull(rs.getString("dis_adv_status"));
			   dis_Adv_Srl_No	= checkForNull(rs.getString("dis_Adv_Srl_No"));
			   adt_status		= checkForNull(rs.getString("adt_status"));
			}
			
			if(rs != null) rs.close();
			if(stmt!=null) stmt.close();

			/* merged with above query for PE - 13/05/2010
			String adt_status  ="";
			rs	= stmt.executeQuery(" select adt_status from PR_ENCOUNTER where encounter_id = '"+encounterid+"' and facility_id = '"+facilityId+"' ");
			if(rs != null && rs.next())
			{
				adt_status = rs.getString("adt_status");
				if(adt_status == null) adt_status = "";
			}

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();*/

			if(dis_adv_status.equals("9"))
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ADV_CANCELLED_CANT_DISG","IP");
				String error1 = ((String) message.get("message"));
				if(error1.lastIndexOf("<br>") >= 0)
				error1=error1.substring(0,error1.lastIndexOf("<br>"));
				out.println("alert('"+error1+"');");
				out.print("window.parent.close();");
				//out.print("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
				message.clear();
			}
			else if(adt_status.equals("08"))			
			{
				java.util.Hashtable msg = MessageManager.getMessage(locale,"PATIENT_DISCHARGED","IP");
				String error1 = ( (String) msg.get("message"));
				if(error1.lastIndexOf("<br>") >= 0)
				error1=error1.substring(0,error1.lastIndexOf("<br>"));
				out.println("alert('"+error1+"');");
				out.print("window.parent.close();");
				//out.print("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
				msg.clear();
			}
			else
			{  
				IPDischargePatient(req, res, encounterid, patientid, facilityId, dis_Adv_Srl_No);
			}
			out.println("} callDischargePatientServeltHTML();</script></body></html>");
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
				ConnectionManager.returnConnection(connection,req);
		}
	}

	private void IPDischargePatient(HttpServletRequest req, HttpServletResponse res, String encounterid, String patientid, String facilityId, String dis_Adv_Srl_No)	
	{  
		Connection connection	= null;
		Statement statement		=	null;
		ResultSet resultSet		=	null; 
		Statement from_stmt		=	null;
		ResultSet from_rs		=	null;	
		connection							= ConnectionManager.getConnection(req);
		String dischargetype				= checkForNull(req.getParameter("discharge_type"));
		//added on 3-07-08 for SCR 3228
		String dischargestatus				= checkForNull(req.getParameter("discharge_stat"));//

		String indicator					= checkForNull(req.getParameter("indicator"));
		String nursingunitcode				= checkForNull(req.getParameter("nursing_unit_code"));
		String practid						= checkForNull(req.getParameter("practid"));
		String cnt_vals						= checkForNull(req.getParameter("cnt_vals"));
		String dcharge						= checkForNull(req.getParameter("dly_charge"));
		String DECEASED_DATE_TIME			= checkForNull(req.getParameter("DECEASED_DATE_TIME"));
		String referred						= checkForNull(req.getParameter("referred"), "N");
		String maternal_death_yn			= checkForNull(req.getParameter("maternal_death_yn"),"N");
		String bl_interfaced_yn				= checkForNull(req.getParameter("bl_interfaced_yn"),"N");
		String function_id 				=  checkForNull(req.getParameter("function_id"));
		

		String isModifyDiscTypeStatusAppl = req.getParameter("isModifyDiscTypeStatusAppl"); // added by mujafar for ML-MMOH-CRF-0659
		String absconding_date =""; // added by mujafar for ML-MMOH-CRF-0659
		String allow_modify_disc_yn = req.getParameter("allow_modify_disc_yn");
	

		
		String daycare_unit_code =  checkForNull(req.getParameter("daycare_unit_code")); //Added for this CRF HSA-CRF-0306.1
		/*Below line Added for this CRF HSA-CRF-0263.1*/
		String allow_muti_bedside_review_yn=checkForNull(req.getParameter("allow_muti_bedside_review_yn"),"N");
		
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
		String weight_on_admission		= checkForNull(req.getParameter("weight_on_admission"));
		String weight_on_admission_unit	= checkForNull(req.getParameter("weight_on_admission_unit"));
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
		
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		String height_on_admission		= checkForNull(req.getParameter("height_on_admission"));
		String bmi	= checkForNull(req.getParameter("bmi"));
		String discharge_to=checkForNull(req.getParameter("discharge_to"));
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
		
		// if the ageValue is less than 2 and greater than -1 then 
		// An online report should be printed for such type of discharges for claim purpose.
		
		String SickLeaveRecordFlag		= checkForNull(req.getParameter("SickLeaveRecordFlag"));
		String SickLeaveDetails			= java.net.URLDecoder.decode(checkForNull(req.getParameter("SickLeaveDetails")));

		String LeaveFrom					=	"";
		String LeaveTo						=	"";
		String FitForDuty					=	"";
		String FitonDuty					=	"";
		String CertIssued					=	"";
		String AuthorizedById				=	"";
		String remarks						=	"";
		// To perform Neo-natal Discharge if the patient is less than two days old End.
		String from_patient_id				= "";
		String from_locn_type				= "";
		String from_service_code			= "";
		String from_specialty_code			= "";
		String from_practitioner_id			= "";
		String from_practitioner_name		= ""; 
		String from_nursing_unit_code		= "";
		String from_nursing_unit_short_desc	= "";

		if (SickLeaveRecordFlag.equals("Y"))
		{
			StringTokenizer token1	= new StringTokenizer(SickLeaveDetails, "||");
			if (token1.hasMoreTokens())
			{
				LeaveFrom			= checkForNull(token1.nextToken());
				LeaveTo				= checkForNull(token1.nextToken());
				FitForDuty			= checkForNull(token1.nextToken());
				CertIssued			= checkForNull(token1.nextToken());
				AuthorizedById		= checkForNull(token1.nextToken());
				remarks				= checkForNull(token1.nextToken());
					if (remarks.equals("||")) remarks="";
				FitonDuty			= checkForNull(token1.nextToken());
					if (FitonDuty.equals("^}")) FitonDuty="";
			}
		}

		try 
		{
			
			String error				=	"";
			StringBuffer From_Sql = new StringBuffer();
//			From_Sql.append("SELECT LOCN_TYPE, facility_id, gender, patient_name,patient_id, citizen_yn, legal_yn, service_code,AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc, specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name, nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc FROM ip_open_encounter_vw WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' ");

			From_Sql.append(" SELECT 'N' LOCN_TYPE, a.facility_id, b.sex gender, b.patient_name,a.patient_id, b.citizen_yn, b.legal_yn, a.service_code,AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_short_desc, a.specialty_code, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc, a.ATTEND_PRACTITIONER_ID practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,'"+locale+"','1') practitioner_name, a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc FROM ip_open_encounter a, mp_patient b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+encounterid+"' and a.patient_id=b.patient_id ");

			from_stmt	= connection.createStatement();
			from_rs		= from_stmt.executeQuery(From_Sql.toString());

			if(from_rs != null)
			{
				while(from_rs.next())
				{
					from_patient_id				= from_rs.getString("patient_id");
					from_locn_type				= from_rs.getString("LOCN_TYPE");
					from_service_code			= from_rs.getString("service_code");
					from_specialty_code			= from_rs.getString("specialty_code");
					from_practitioner_id		= from_rs.getString("practitioner_id");
					from_practitioner_name		= from_rs.getString("practitioner_name");
					from_nursing_unit_code		= from_rs.getString("nursing_unit_code");
					from_nursing_unit_short_desc=from_rs.getString("nursing_unit_short_desc");
				}
			}

			if(from_rs != null)		from_rs.close();
			if(from_stmt!= null)	from_stmt.close();
			String discharge_date_time = checkForNull(req.getParameter("discharge_date_time"));
			String discharge_date_time_display = "";
			if(discharge_date_time =="" || discharge_date_time.equals("null"))
				discharge_date_time_display = "";
			else
				discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM",locale,"en");
			
			String deceased_date_time_display = "";
			if(DECEASED_DATE_TIME == "" || DECEASED_DATE_TIME.equals("null"))
				deceased_date_time_display = "";
			else
				deceased_date_time_display = DateUtils.convertDate(DECEASED_DATE_TIME,"DMYHM",locale,"en");

			String body_released_date = checkForNull(req.getParameter("body_released_date"));
			String body_released_date_display = "";
			if(body_released_date == "" || body_released_date.equals("null"))
				body_released_date_display = "";
			else
				body_released_date_display = DateUtils.convertDate(body_released_date,"DMYHM",locale,"en");


			String bed_block_until =  checkForNull(req.getParameter("bed_block_until"));
			String bed_block_until_display = "";
			if(bed_block_until == "" || bed_block_until.equals("null"))
				bed_block_until_display = "";
			else
				bed_block_until_display = DateUtils.convertDate(bed_block_until,"DMYHM",locale,"en");

			HashMap paramHashTab = new HashMap();
			paramHashTab.put("facilityId",  facilityId);                  
			paramHashTab.put("patientid",  patientid);                   
			paramHashTab.put("patient_status",  checkForNull(req.getParameter("patient_status")));
			paramHashTab.put("isModifyDiscTypeStatusAppl",  isModifyDiscTypeStatusAppl);  // added by mujafar for ML-MMOH-CRF-0659 start
			paramHashTab.put("allow_modify_disc_yn",  allow_modify_disc_yn);
			if(isModifyDiscTypeStatusAppl.equals("true") && allow_modify_disc_yn.equals("Y"))
			{
				 absconding_date = checkForNull(req.getParameter("absconding_date"));
				if(absconding_date.equals(""))
					absconding_date = "";
				else
					absconding_date = DateUtils.convertDate(absconding_date,"DMYHM",locale,"en");
					
			paramHashTab.put("absconded_date",  absconding_date);
			paramHashTab.put("absconded_yn",  checkForNull(req.getParameter("abscon_yn")));
			paramHashTab.put("reported_to", checkForNull(req.getParameter("absconding_rep_to")));
			} // added by mujafar for ML-MMOH-CRF-0659 end

			paramHashTab.put("encounterid", encounterid);                 
			paramHashTab.put("dischargedate", discharge_date_time_display);               
			paramHashTab.put("dischargetype", dischargetype); 
			//added on 3-7-08 for SCR 3228
			paramHashTab.put("dischargestatus", dischargestatus); //
			paramHashTab.put("practitionerid", checkForNull(req.getParameter("practitioner_id")));              
			paramHashTab.put("specialitycode", checkForNull(req.getParameter("specialty_code")));              
			paramHashTab.put("patienttype", checkForNull(req.getParameter("patient_type_code")));                 
			paramHashTab.put("bedclasscode", checkForNull(req.getParameter("bed_class_code")));                
			paramHashTab.put("nursingunitcode", nursingunitcode);             
			paramHashTab.put("servicecode", checkForNull(req.getParameter("service_code")));                 
			paramHashTab.put("bedno", checkForNull(req.getParameter("bed_no")));                       
			paramHashTab.put("roomno", checkForNull(req.getParameter("room_no")));                      
			paramHashTab.put("dailyrate", dcharge);                   
			paramHashTab.put("dischargeremarks", checkForNull(req.getParameter("discharge_remarks")));            
			paramHashTab.put("blockuntildate", bed_block_until_display );              
			paramHashTab.put("admissiondatetime", checkForNull(req.getParameter("admission_date_time")));           
			paramHashTab.put("bedtypecode", checkForNull(req.getParameter("bed_type_code")));                 
			paramHashTab.put("patientgender", checkForNull(req.getParameter("gender")));               
			paramHashTab.put("deceasedyn", checkForNull(req.getParameter("deceased_yn"), "N"));                  
			paramHashTab.put("postmortemrequest", checkForNull(req.getParameter("post_mortem_request"), "N"));           
			paramHashTab.put("dischargesummarysigned", checkForNull(req.getParameter("discharge_summary_signed"), "N"));      
			paramHashTab.put("newmedicine", checkForNull(req.getParameter("new_medicine"), "N"));                 
			paramHashTab.put("client_ip_address", checkForNull(p.getProperty("client_ip_address")));           
			paramHashTab.put("bl_interfaced_yn", bl_interfaced_yn);            
			paramHashTab.put("referred", referred);                    
			paramHashTab.put("referral_type", checkForNull(req.getParameter("referral_type")));               
			paramHashTab.put("referred_to", checkForNull(req.getParameter("referred_to")));                 
			paramHashTab.put("priority", checkForNull(req.getParameter("priority")));                    
			paramHashTab.put("preferred_date", checkForNull(req.getParameter("preferred_date")));              
			paramHashTab.put("speciality", checkForNull(req.getParameter("speciality")));                  
			paramHashTab.put("service", checkForNull(req.getParameter("service")));                     
			paramHashTab.put("location0", checkForNull(req.getParameter("location0")));                   
			paramHashTab.put("location1", checkForNull(req.getParameter("location1")));                   
			paramHashTab.put("location2", checkForNull(req.getParameter("location2")));                   
			paramHashTab.put("practitioner", checkForNull(req.getParameter("practitioner")));                
			paramHashTab.put("pract_name", checkForNull(req.getParameter("pract_name")));                  
			paramHashTab.put("practitioner1", checkForNull(req.getParameter("practitioner1")));               
			paramHashTab.put("hcare_setting_type_desc", checkForNull(req.getParameter("hcare_setting_type_desc")));     
			paramHashTab.put("hcare_setting_type", checkForNull(req.getParameter("hcare_setting_type")));          
			paramHashTab.put("open_to_all_pract_yn",  checkForNull(req.getParameter("open_to_all_pract_yn")));        
			paramHashTab.put("from_hcare_setting_type_code", checkForNull(req.getParameter("from_hcare_setting_type_code")));
			paramHashTab.put("eid", encounterid);                         
			paramHashTab.put("SickLeaveRecordFlag", SickLeaveRecordFlag);         
			paramHashTab.put("LeaveFrom", LeaveFrom);                   
			paramHashTab.put("LeaveTo", LeaveTo);                     
			paramHashTab.put("FitForDuty", FitForDuty);                  
			paramHashTab.put("FitonDuty", FitonDuty);                   
			paramHashTab.put("CertIssued", CertIssued);                  
			paramHashTab.put("AuthorizedById", AuthorizedById);              
			paramHashTab.put("remarks", remarks);                     
			paramHashTab.put("practid", practid);                     
			paramHashTab.put("DECEASED_DATE_TIME", deceased_date_time_display);          
			paramHashTab.put("body_released", body_released_date_display );             
			paramHashTab.put("dischg_practid", checkForNull(req.getParameter("dischg_practid")));              
			paramHashTab.put("ref_for_ip", checkForNull(req.getParameter("ref_for_ip")));                  
			paramHashTab.put("inform_to", checkForNull(req.getParameter("inform_to")));                   
			paramHashTab.put("informed_date", checkForNull(req.getParameter("informed_date")));               
			paramHashTab.put("informed_name", checkForNull(req.getParameter("informed_name")));               
			paramHashTab.put("medico_legal", checkForNull(req.getParameter("medico_legal"),"N"));
			paramHashTab.put("police_rep_no", checkForNull(req.getParameter("pol_rep_no")));               
			paramHashTab.put("police_station", checkForNull(req.getParameter("pol_stn_id")));              
			paramHashTab.put("police_id", checkForNull(req.getParameter("pol_id")));        
			paramHashTab.put("accomp_person", checkForNull(req.getParameter("accomp_person"), "N")); 
			paramHashTab.put("witness_id", checkForNull(req.getParameter("witness_id")));
			paramHashTab.put("cnt_values", checkForNull(req.getParameter("cnt_vals")));
			paramHashTab.put("bed_blocking_period", checkForNull(req.getParameter("bed_blocking_period")));
			paramHashTab.put("blocking_type_code", checkForNull(req.getParameter("blocking_type_code")));
			paramHashTab.put("override_yn", checkForNull(req.getParameter("override_yn"),"N"));
			paramHashTab.put("bed_block_remarks", checkForNull(req.getParameter("bed_block_remarks")));
			paramHashTab.put("deactivate_pseudo_bed_yn", checkForNull(req.getParameter("deactivate_pseudo_bed_yn")));
			paramHashTab.put("mother_bed_status", checkForNull(req.getParameter("mother_bed_status")));
			paramHashTab.put("bl_operational",checkForNull(req.getParameter("bl_operational"),"N"));
			paramHashTab.put("body_risk_yn",checkForNull(req.getParameter("body_risk"),"N"));
			paramHashTab.put("patient_class",checkForNull(req.getParameter("patient_class_value")));
			paramHashTab.put("dis_Adv_Srl_No",dis_Adv_Srl_No);
			paramHashTab.put("subservice_code",checkForNull(req.getParameter("subservice_code")));
			paramHashTab.put("locn_type",checkForNull(req.getParameter("location_type")));
			paramHashTab.put("function_id",function_id);
			//CRF-30276 
			paramHashTab.put("other_late_discharge_reason",checkForNull(req.getParameter("other_late_discharge_reason")));
			paramHashTab.put("late_discharge_reason",checkForNull(req.getParameter("late_discharge_reason")));
			
			/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
			paramHashTab.put("weight_on_admission",weight_on_admission);
			paramHashTab.put("weight_on_admission_unit",weight_on_admission_unit);
			/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
			
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			paramHashTab.put("height_on_admission",height_on_admission);
			paramHashTab.put("bmi",bmi);
			paramHashTab.put("discharge_to",discharge_to);
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/
			
			//Added for this CRF HSA-CRF-0263.1
			paramHashTab.put("allow_muti_bedside_review_yn",allow_muti_bedside_review_yn);
			//Added for this CRF HSA-CRF-0306.1
			paramHashTab.put("daycare_unit_code",daycare_unit_code); 

			boolean local_ejbs = false;
				
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPDischargePatient",IPDischargePatientHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = paramHashTab;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = paramHashTab.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPDischargePatient",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;

			String referral_id		=	"";
			String mesg				=	"";
			if (referred.equals("Y"))
				referral_id = (String) results.get("referral_id") ; 
			String sl_ref_no   = (String) results.get("sl_ref_no") ; 
			if(inserted)
			{
				out.println("alert('"+error.substring(0,error.length()-5)+"');");
				doOnlineReports(encounterid, nursingunitcode, indicator, referred, CertIssued, maternal_death_yn, sl_ref_no, referral_id, patientid, facilityId);
				if(!indicator.equals("DS") && !indicator.equals("AB") && !indicator.equals("NS") && !indicator.equals("LE"))
				{
					if(!cnt_vals.equals("0"))
					{	
							
						//out.print("<html><head><script src='../eCommon/js/messages.js' language='javascript'></script><script>var msg=getMessage('UPDATE_PAT_VAL','common');var truthBeTold = window.confirm(msg); if(truthBeTold){var dialogHeight = '22'; var dialogWidth = '50'; var dialogTop = '70'; var arguments = '';var getUrl = '../eMR/jsp/PatientValuablesMain.jsp?encounterId="+encounterid+"&patientId="+patientid+"&facility_Id="+facilityId+"&splty_code="+from_specialty_code+"&locn_code="+from_nursing_unit_code+"'; var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+'; status=no;' ;  retVal = window.showModalDialog(getUrl,arguments,features);}</script><html><head>");
						/*Thursday, February 18, 2010 19464 , Message format was not proper*/
						java.util.Hashtable message = MessageManager.getMessage(locale,"UPDATE_PAT_VAL","Common");
						mesg = ((String) message.get("message"));
						if(mesg.lastIndexOf("<br>") >= 0)
						mesg=mesg.substring(0,mesg.lastIndexOf("<br>"));

						out.print("var truthBeTold = window.confirm(\""+mesg+"\"); if(truthBeTold){var dialogHeight = '22'; var dialogWidth = '50'; var dialogTop = '70'; var arguments = '';var getUrl = '../../eMR/jsp/PatientValuablesMain.jsp?encounterId="+encounterid+"&patientId="+patientid+"&facility_Id="+facilityId+"&splty_code="+from_specialty_code+"&locn_code="+from_nursing_unit_code+"'; var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+'; status=no;' ;  retVal =await window.showModalDialog(getUrl,arguments,features);}");
						message.clear();
					}

					if(!indicator.equals("ED"))
					{  /*Below change aganist ML-MMOH-CRF-0611 by Mano */
				       if(refMsgChangeAppl)
						{
						
						java.util.Hashtable message = MessageManager.getMessage(locale,"REFER_REQ_PAT","Common");
						String ref_error = (String) message.get("message") ;

						out.print("var truthBeTold = window.confirm(\""+ref_error+"\");");			
						out.print("if(!truthBeTold)parent.window.close();");
						//out.print("if(!truthBeTold)parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
						message.clear();
                          /* End of CRF-0611 */
					   } 
					    else
						{
						java.util.Hashtable message = MessageManager.getMessage(locale,"REG_REFERRAL","Common");
						String ref_error = (String) message.get("message") ;

						out.print("var truthBeTold = window.confirm(\""+ref_error+"\");");			
						out.print("if(!truthBeTold)parent.window.close();");
						//out.print("if(!truthBeTold)parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
						message.clear();
						}
					    }
					/*Below line modified for this CRF HSA-CRF-0263.1*/
					RegisterMoreReferral(encounterid,patientid,from_patient_id,from_locn_type,from_service_code,from_specialty_code,from_practitioner_id,from_practitioner_name,from_nursing_unit_code,from_nursing_unit_short_desc, indicator,allow_muti_bedside_review_yn);
				}

				
			}
			else
			{
				if(error.lastIndexOf("<br>")>=0)	
					error=error.substring(0,error.lastIndexOf("<br>"));
				error = error.replace('\n',' ');
				out.println("alert(\""+error+"\");");
			}

			//out.println("window.close();");
			out.print("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
			out.println("parent.frames[2].document.location.reload();");
			out.println("parent.frames[3].document.location.href='../eCommon/jsp/error.jsp';");
			paramHashTab.clear();
			results.clear();
		}catch ( Exception e ) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if (resultSet != null) resultSet.close();
			if(from_rs != null)		from_rs.close();
			if (statement != null) statement.close();
			if(connection!=null)
				ConnectionManager.returnConnection(connection,req);
			
			}catch(Exception e){e.printStackTrace();}
		}  
	}

	private void doOnlineReports(String encounter_id, String nursingunitcode, String indicator, String 	referred, String CertIssued, String maternal_death_yn, String sl_ref_no, String referral_id, String patientid, String facilityId) throws ServletException, IOException, SQLException
	{
		StringBuffer htmlFor = new StringBuffer();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, ");
		sqlBuffer.append("a.module_id from ip_online_report a, sm_report_lang_vw b  where  b.language_id='"+locale+"' and a.module_id = 'IP' ");
		sqlBuffer.append("and b.internal_request_yn='Y' and a.facility_id='");
		sqlBuffer.append(facilityId);
		//sqlBuffer.append("' and a.print_on_discharge_yn='Y' and b.report_id NOT IN ('IPBBDYTG','IPBAORFR','IPBMDNOT') and a.nursing_unit_code ='");
		/*Thursday, January 28, 2010  18637 */
		sqlBuffer.append("' and a.print_on_discharge_yn='Y' " );

			if(indicator.equals("DS"))
			{
				if(maternal_death_yn.equals("Y"))
					sqlBuffer.append(" and b.report_id NOT IN ('IPBAORFR') ");
				else
					sqlBuffer.append(" and b.report_id NOT IN ('IPBAORFR','IPBMDNOT') ");	
			}
			
			else if(indicator.equals("AO"))
				sqlBuffer.append(" and b.report_id NOT IN ('IPBBDYTG','IPBMDNOT') ");
			else
				sqlBuffer.append(" and b.report_id NOT IN ('IPBBDYTG','IPBAORFR','IPBMDNOT') ");
		sqlBuffer.append(" and a.nursing_unit_code ='"+nursingunitcode+"'");
		sqlBuffer.append("  and a.report_id = b.report_id ");
		// Added by ksihore on 10/9/2004
		// calling this report for if the patient is deceased
		/*Thursday, January 28, 2010  18637 
		if(indicator.equals("DS"))
			sqlBuffer.append(" union select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where language_id='"+locale+"' and  module_id = 'IP' AND REPORT_ID = 'IPBBDYTG'");
		else if(indicator.equals("AO"))
			sqlBuffer.append(" union select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where language_id='"+locale+"' and module_id = 'IP' AND REPORT_ID = 'IPBAORFR'");
		else*/ if (referred.equals("Y"))
			sqlBuffer.append(" union select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where language_id='"+locale+"' and module_id = 'AM' AND REPORT_ID = 'AMRFLETR'");
		else if (CertIssued.equals("Y"))
			sqlBuffer.append(" union select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where language_id='"+locale+"' and module_id = 'OP' AND REPORT_ID = 'OPBMEDCR'");
		/*Thursday, January 28, 2010 18637 
		if (maternal_death_yn.equals("Y"))
			sqlBuffer.append(" union select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where language_id='"+locale+"' and module_id = 'IP' AND REPORT_ID = 'IPBMDNOT'");
			*/

		sqlBuffer.append(" order by 2 ");

		String locn_type = "N";
		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_referral_id,P_SL_REF_NO,p_facilityId";
		String reportParamValues = ""+encounter_id+","+nursingunitcode+","+locn_type+","+patientid+","+referral_id+","+sl_ref_no+","+facilityId+"";

		htmlFor.append(" var dialogHeight    = '50vh' ;");
		htmlFor.append(" var dialogWidth = '50vw' ;");
		htmlFor.append("var dialogTop = 5;" );
		htmlFor.append("  var arguments =   ''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=DISCHARGE_PATIENT&step=1&sqlString="+java.net.URLEncoder.encode(sqlBuffer.toString())+"&EncounterId="+encounter_id+"&dest_locn_type="+locn_type+"&dest_locn_code="+nursingunitcode+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal            = await  top.window.showModalDialog(getUrl,arguments,features); ");
		out.println(htmlFor.toString());
	} 
	
/// Added by Sridhar R on 6 Sep 2004
/// This function will open a modal window which alows the user to Register multiple referrals...
   /*Below line modified for this CRF HSA-CRF-0263.1*/
	private void RegisterMoreReferral(String encounterid, String patientid, String from_patient_id, String from_locn_type, String from_service_code, String from_specialty_code, String from_practitioner_id, String from_practitioner_name, String from_nursing_unit_code, String from_nursing_unit_short_desc, String discharge_indicator,String allow_muti_bedside_review_yn)throws ServletException, IOException
	{
		String Transaction_type = "DP";
		try
		{
			StringBuffer htmlFor = new StringBuffer();
			htmlFor.append(" var dialogHeight	= '90vh';");
			htmlFor.append(" var dialogWidth	= '90vw';");
			htmlFor.append(" var dialogTop		= '7';");
			htmlFor.append(" var arguments		= ''  ;");
			/*Below line modified for this CRF HSA-CRF-0263.1*/
			htmlFor.append(" var getUrl = '../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounterid+"&Transaction_type="+Transaction_type+"&patient_id="+patientid+"&from_patient_id="+from_patient_id+"&from_locn_type="+from_locn_type+"&from_service_code="+from_service_code+"&from_specialty_code="+from_specialty_code+"&from_practitioner_id="+from_practitioner_id+"&from_practitioner_name="+from_practitioner_name+"&from_nursing_unit_code="+from_nursing_unit_code+"&from_nursing_unit_short_desc="+from_nursing_unit_short_desc+"&discharge_indicator="+discharge_indicator+"&allow_muti_bedside_review_yn="+allow_muti_bedside_review_yn+" ';");
			htmlFor.append(" var features = 'dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+'; status=no;' ;");
			htmlFor.append("  retVal = await top.window.showModalDialog(getUrl,arguments,features);");
			out.println(htmlFor.toString());
		
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
} 
