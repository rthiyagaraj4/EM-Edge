/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP ;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import com.ehis.util.*;
import eIP.IPAssignBed.IPAssignBedHome;





public class AssignBedServlet extends javax.servlet.http.HttpServlet
{

    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);
            String sStyle			= "";
			PrintWriter out			= null;
			out						= res.getWriter();
			String url				= "../eCommon/jsp/commonToolbar.jsp?" ;
            String params			= req.getQueryString() ;
            String source			= url + params ;

            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }catch(Exception e)
		{
			e.printStackTrace();
		}
	}


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
    	PrintWriter out					= null;
		Properties p					= null;
		HttpSession session				= null;
		String sStyle					= "";
		/*PreparedStatement preStatement	= null;
		ResultSet resultSet				= null;
		ResultSet rset					= null;
		PreparedStatement pstmt			= null;*/
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String locale					= "" ;
		String req_no					= "";
		String patient_id				= "";
		String encounterId				= "";
		String nursing_unit_code		= "";
		String error					= "";
		String perm_fs_locn				= "";
		String facilityId				= "";
		String year						= "";
		session							= req.getSession(false);
        p								= (java.util.Properties)session.getValue("jdbc");
        facilityId						= checkForNull((String)session.getValue("facility_id"));
		sStyle							= checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
        out								= res.getWriter();
		locale							= p.getProperty("LOCALE");
		req_no							= req.getParameter("req_no");
		if (req_no == null) req_no = "";
		patient_id						= checkForNull(req.getParameter("p_patient_id"));
	    encounterId						= checkForNull(req.getParameter("encounterId"));
		nursing_unit_code				= checkForNull(req.getParameter("nursing_unit_code"));
		error							= checkForNull(req.getParameter("error"));
		perm_fs_locn					= checkForNull(req.getParameter("perm_fs_locn"));
		year							= checkForNull(req.getParameter("year"));
	
			
		try
		{
			if(req_no =="") {
				insertAssignBed(req,res, facilityId);
			}
			else
			{
				out.println("<script>alert('"+error+"')</script>");
				HashMap hashOnlineReports = new HashMap();
				hashOnlineReports.put("encounterId",encounterId);
				hashOnlineReports.put("nursing_unit_code",nursing_unit_code);
				hashOnlineReports.put("facilityId",facilityId);
				hashOnlineReports.put("facilityId",facilityId);
				hashOnlineReports.put("patient_id",patient_id);
				hashOnlineReports.put("locale",locale);
				hashOnlineReports.put("year",year);
				doOnlineReports(req,res,hashOnlineReports);
				hashOnlineReports.clear();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
	}

	private void insertAssignBed(HttpServletRequest req, HttpServletResponse res, String facilityId) throws java.io.IOException
	{
		PrintWriter out					= null;
		Properties p					= null;
		HttpSession session				= null;
		String sStyle					= "";
		Connection connection			= null;
		PreparedStatement preStatement	= null;
		ResultSet resultSet				= null;
		ResultSet rset					= null;
		PreparedStatement pstmt			= null;
		String locale					= "" ;
		session							= req.getSession(false);
        p								= (java.util.Properties)session.getValue("jdbc");
        sStyle							= checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
        out								= res.getWriter();
		locale							= p.getProperty("LOCALE");
		connection						= ConnectionManager.getConnection(p);
	    Hashtable message				= new java.util.Hashtable();
		boolean proceed					= true;
		Statement entitle_stmt			= null;
		PreparedStatement entitle_pstmt = null;
		ResultSet entitle_rs			= null;
		String status					= "";
		String error					= "";
		String msg						= "";
		String entitlement_by_pat_cat_yn= "";
		String booking_ref_no			= "";
		String dc_unit_code				= "";
		//String mr_section_code			= "";
//		String pat_file_no				= "";
		String bed_class_temp			= "";
		String pseudo_bed_yn			= "N";
		String sex_spec_ind				= "";
		String occupying_patient_id		= "";
//		String bedTypeCode				= "";
		String splty_code				= "";
		String admission_date_time		= "";
		String bed_no					= "";
		String orig_blocked_bed_no		= "";	
		String nursing_unit_code		= "";
		String service					= "";
		String patient_class			= "";
		String room_no					= "";
		String gender					= "";
		String bed_type_code			= "";
		String modified_bed_type_code	= "";
		String bedclasscode				= "";
		String bedtypecode				= "";
		String setup_bl_dtls_in_ip_yn	= "";
		String bl_operational			= "";
		String modified_date_val		= "";
		String practid					= "";
		String team_id					= "";
		String nursing_unit				= "";
		String Splcode					= "";
		String patient_gender			= "";
		String date_of_birth			= "";
		String from_nursing_unit_code	= "";
		String chg_nurs_unit_in_assign_bed_yn	= "";
		String pat_check_in_allowed_yn	= "";
		String exp_discharge_date_time	= "";
		String bedallocationdatetime	= "";
		String patient_id				= "";
		String encounterId				= "";
		String year						= "";
		admission_date_time				=	checkForNull(req.getParameter("admission_date_time"));
		bed_no							=	checkForNull(req.getParameter("to_bed_no"));
		orig_blocked_bed_no				=	checkForNull(req.getParameter("orig_blocked_bed_no"));
		nursing_unit_code				=	checkForNull(req.getParameter("nursing_unit_code"));
		service							=	checkForNull(req.getParameter("service"));
		patient_id						=	checkForNull(req.getParameter("p_patient_id"));
		patient_class					=	checkForNull(req.getParameter("patient_class"));
		room_no							=	checkForNull(req.getParameter("to_room_no"));
		gender							=	checkForNull(req.getParameter("gender"));
		encounterId						=	checkForNull(req.getParameter("encounterId"));
		bed_type_code					=	checkForNull(req.getParameter("bed_type_code"));
		modified_bed_type_code			=	checkForNull(req.getParameter("modified_bed_type_code"), bed_type_code);
		bedclasscode					=	checkForNull(req.getParameter("Bedcode"));
		bedtypecode						=	checkForNull(req.getParameter("Bedtype"));
		setup_bl_dtls_in_ip_yn			=	checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn"), "N");
		bl_operational					=	checkForNull(req.getParameter("bl_operational"),"N");
		modified_date_val				=	checkForNull(req.getParameter("modified_date_val"));
		practid							=	checkForNull(req.getParameter("practid"));
		team_id							=	checkForNull(req.getParameter("team_id"));
		nursing_unit					=	checkForNull(req.getParameter("nursing_unit"));
		Splcode							=	checkForNull(req.getParameter("Splcode"));
		patient_gender					=	checkForNull(req.getParameter("patient_gender"));
		date_of_birth					=	checkForNull(req.getParameter("date_of_birth"));
		from_nursing_unit_code			=	checkForNull(req.getParameter("from_nursing_unit_code"));
		chg_nurs_unit_in_assign_bed_yn	=	checkForNull(req.getParameter("chg_nurs_unit_in_assign_bed_yn"));
		pat_check_in_allowed_yn			=	checkForNull(req.getParameter("pat_check_in_allowed_yn"));
		exp_discharge_date_time			=	checkForNull(req.getParameter("exp_discharge_date_time"));
		bedallocationdatetime			=	checkForNull(req.getParameter("bed_alloc_date_time"));
		year							=	checkForNull(req.getParameter("year"));
		bedallocationdatetime			= DateUtils.convertDate(bedallocationdatetime,"DMYHM",locale,"en");
		StringBuffer sqlBuffer			=	new StringBuffer();
		String fm_install_yn			=   "N";
		
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
		String weight_on_admission		= checkForNull(req.getParameter("weight_on_admission"));
		String weight_on_admission_unit	= checkForNull(req.getParameter("weight_on_admission_unit"));
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		String height_on_admission		= checkForNull(req.getParameter("height_on_admission"));
		String bmi= checkForNull(req.getParameter("bmi"));
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/

		try
		{
			if(sqlBuffer.length() > 0) sqlBuffer.delete(0,sqlBuffer.length());
			//sqlBuffer.append(" select bed_class_code, pseudo_bed_yn, sex_spec_ind, occupying_patient_id, bed_type_code, specialty_code from IP_NURSING_UNIT_BED where facility_id='");
			sqlBuffer.append(" select bed_class_code,current_status, pseudo_bed_yn, sex_spec_ind, occupying_patient_id, bed_type_code, specialty_code from IP_NURSING_UNIT_BED where facility_id='");
			sqlBuffer.append(facilityId);
			sqlBuffer.append("' AND nursing_unit_code = '");
			sqlBuffer.append(nursing_unit_code);
			sqlBuffer.append("' AND bed_no = '");
			sqlBuffer.append(bed_no);
			sqlBuffer.append("' ");

			preStatement=connection.prepareStatement(sqlBuffer.toString());
			resultSet = preStatement.executeQuery();

			if((resultSet != null) && (resultSet.next()))
			{
				bed_class_temp		= checkForNull(resultSet.getString("bed_class_code"));
				pseudo_bed_yn		= checkForNull(resultSet.getString("pseudo_bed_yn"));
				sex_spec_ind		= checkForNull(resultSet.getString("sex_spec_ind"));
				occupying_patient_id= checkForNull(resultSet.getString("occupying_patient_id"));
				//bedTypeCode			= checkForNull(resultSet.getString("bed_type_code"));
				splty_code			= checkForNull(resultSet.getString("specialty_code"));
				//String current_status			= checkForNull(resultSet.getString("current_status"));
				if(modified_bed_type_code.equals(""))
					modified_bed_type_code = bedtypecode;
			}
			else
			{
				if(!chg_nurs_unit_in_assign_bed_yn.equals("Y"))
				{
					proceed = false;
					message = MessageManager.getMessage(locale,"BED_NURS_UNIT_MISMATCH","IP");
					error = (String) message.get("message");
					message.clear();
				}
			}

			if(proceed)
			{
				if(!occupying_patient_id.equals(""))
				{
					proceed = false;
					message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP");
					error = (String) message.get("message");
					message.clear();
				}
				else if (!splty_code.equals("") && !splty_code.equals(Splcode))
				{
					proceed = false;
					message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP");
					error = (String) message.get("message");
					message.clear();
				}
				else if ((!sex_spec_ind.equals(""))&&(!sex_spec_ind.equals(gender)))
				{
					proceed = false;
					message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP");
					error = (String) message.get("message");
					message.clear();
				}

				if(proceed == false)
				{
					if(error.lastIndexOf("<br>")>=0)
						error=error.substring(0,error.lastIndexOf("<br>"));
					out.println("<script>var shomodalFrame = top.window.document.getElementById('dialog-body').contentWindow;  shomodalFrame.frames[1].document.forms[0].record.disabled=false;</script>");
					out.println("<script>alert('"+error+"')</script>");
					}
			}
			if(resultSet!=null) resultSet.close();
			if(preStatement!= null) preStatement.close();
		}catch( Exception ex )
		{
			ex.printStackTrace();
		}

		try
		{
			if(bl_operational.equals("Y") && !bedclasscode.equals(bed_class_temp) && proceed)
			{
				String mess = "";
				message.clear();
				message = MessageManager.getMessage(locale,"BED_CLASS_MISMATCH","IP");
				mess = (String) message.get("message");
				mess = mess.substring(0,mess.lastIndexOf("<br>"));
				out.println("<script>alert('"+mess+"');</script>");				
				out.println("<script>var shomodalFrame = top.window.document.getElementById('dialog-body').contentWindow;  shomodalFrame.frames[1].document.forms[0].record.disabled=false;</script>");
				message.clear();
			}
			else if(proceed)
			{
				facilityId              = convertString(facilityId);
				bed_no                  = convertString(bed_no);
				orig_blocked_bed_no     = convertString(orig_blocked_bed_no);
				nursing_unit_code       = convertString(nursing_unit_code);
				service					= convertString(service);
				patient_class           = convertString(patient_class);
				room_no                 = convertString(room_no);
				gender                  = convertString(gender);
				encounterId             = convertString(encounterId);
				bed_type_code           = convertString(bed_type_code);
				modified_bed_type_code  = convertString(modified_bed_type_code);
				bedclasscode            = convertString(bedclasscode);
				patient_id              = convertString(patient_id);
				setup_bl_dtls_in_ip_yn  = convertString(setup_bl_dtls_in_ip_yn);
				bl_operational			= convertString(bl_operational);
				modified_date_val		= convertString(modified_date_val);
				practid					= convertString(practid);
				team_id					= convertString(team_id);
				nursing_unit			= convertString(nursing_unit);
				Splcode					= convertString(Splcode);
				patient_gender			= convertString(patient_gender);
				date_of_birth			= convertString(date_of_birth);
				from_nursing_unit_code	= convertString(from_nursing_unit_code);
				chg_nurs_unit_in_assign_bed_yn	= convertString(chg_nurs_unit_in_assign_bed_yn);
				pat_check_in_allowed_yn	= convertString(pat_check_in_allowed_yn);
				bedallocationdatetime	= convertString(bedallocationdatetime);
				exp_discharge_date_time	= convertString(exp_discharge_date_time);

				try
				{
					entitle_stmt = connection.createStatement();
					entitle_rs = entitle_stmt.executeQuery("select entitlement_by_pat_cat_yn,(select install_yn from sm_module where module_id = 'FM')install_yn from MP_PARAM where module_id='MP'");
					if(entitle_rs.next())
					{
						entitlement_by_pat_cat_yn = entitle_rs.getString("entitlement_by_pat_cat_yn");
						fm_install_yn = checkForNull(entitle_rs.getString("install_yn"),"N");
					}
					if(entitle_rs != null) entitle_rs.close();
					if(entitle_stmt != null) entitle_stmt.close();
					if(entitlement_by_pat_cat_yn.equals("Y"))
					{
						entitle_pstmt = connection.prepareStatement(" select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy'),?,?,?,?,?,?) from dual");
						entitle_pstmt.setString(1,patient_id);
						entitle_pstmt.setString(2,admission_date_time);
						entitle_pstmt.setString(3,facilityId);
						entitle_pstmt.setString(4,"N");
						entitle_pstmt.setString(5,nursing_unit_code);
						entitle_pstmt.setString(6,patient_class);
						entitle_pstmt.setString(7,Splcode);
						entitle_pstmt.setString(8,bedclasscode);

						entitle_rs=entitle_pstmt.executeQuery();
						if(entitle_rs != null && entitle_rs.next())
						{
							status=entitle_rs.getString(1);
							if(status == null) status="";
						}
						if(entitle_rs != null) entitle_rs.close();
						if(entitle_pstmt != null) entitle_pstmt.close();
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}

				if(status.equals("0"))
				{
					proceed = true;
				}
				else if(status.equals("1"))
				{
					proceed = false;
					message.clear();
					message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
					msg = ((String) message.get("message"));

					if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");
					message.clear();
				}
				else if(status.equals("2"))
				{
					proceed = false;
					message.clear();
					message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>var shomodalFrame = top.window.document.getElementById('dialog-body').contentWindow;  shomodalFrame.frames[1].document.forms[0].record.disabled=false;</script>");
					message.clear();
				}
				else if(status.equals("3"))
				{
					proceed = false;
					message.clear();
					message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>var shomodalFrame = top.window.document.getElementById('dialog-body').contentWindow;  shomodalFrame.frames[1].document.forms[0].record.disabled=false;</script>");
					message.clear();
				}
				else if(status.equals("4"))
				{
					proceed = false;
					message.clear();
					message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
					msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>var shomodalFrame = top.window.document.getElementById('dialog-body').contentWindow;  shomodalFrame.frames[1].document.forms[0].record.disabled=false;</script>");
					message.clear();
				}

				if(proceed)
				{
					HashMap paramHashTab	=	new HashMap();
					paramHashTab.put("facilityId", facilityId);
					paramHashTab.put("bed_no", bed_no);
					paramHashTab.put("orig_blocked_bed_no",orig_blocked_bed_no);
					paramHashTab.put("nursing_unit_code", nursing_unit_code);
					paramHashTab.put("service", service);
					paramHashTab.put("patient_class", patient_class);
					paramHashTab.put("room_no", room_no);
					paramHashTab.put("gender", gender);
					paramHashTab.put("encounterId", encounterId);
					paramHashTab.put("bed_type_code", bed_type_code);
					paramHashTab.put("modified_bed_type_code", modified_bed_type_code);
					paramHashTab.put("bedtypecode", bedtypecode);
					paramHashTab.put("bed_class_code", bedclasscode);
					paramHashTab.put("patient_id", patient_id);
					paramHashTab.put("setup_bl_dtls_in_ip_yn", setup_bl_dtls_in_ip_yn);
					paramHashTab.put("bl_operational", bl_operational);
					paramHashTab.put("client_ip_address", checkForNull(p.getProperty("client_ip_address")));
					paramHashTab.put("modified_date_val", modified_date_val);
					paramHashTab.put("practid", practid);
					paramHashTab.put("team_id", team_id);
					paramHashTab.put("nursing_unit", nursing_unit);
					paramHashTab.put("Splcode", Splcode);
					paramHashTab.put("patient_gender", patient_gender);
					paramHashTab.put("date_of_birth", date_of_birth);
					paramHashTab.put("from_nursing_unit_code", from_nursing_unit_code);
					paramHashTab.put("chg_nurs_unit_in_assign_bed_yn", chg_nurs_unit_in_assign_bed_yn);
					paramHashTab.put("pat_check_in_allowed_yn", pat_check_in_allowed_yn);
					paramHashTab.put("bed_allocation_date_time", bedallocationdatetime);
					paramHashTab.put("exp_discharge_date_time", exp_discharge_date_time);
					paramHashTab.put("pseudo_bed_yn", pseudo_bed_yn);
					paramHashTab.put("fm_install_yn", fm_install_yn);
					
					/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
					paramHashTab.put("weight_on_admission", weight_on_admission);
					paramHashTab.put("weight_on_admission_unit", weight_on_admission_unit);
					/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
					
					/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
					paramHashTab.put("height_on_admission", height_on_admission);
					paramHashTab.put("bmi", bmi);
					/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/
					
					boolean local_ejbs = false;

					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPAssignBed",IPAssignBedHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = paramHashTab;

					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = paramHashTab.getClass();

					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAssignBed",paramArray)).invoke(busObj,argArray);

					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					boolean inserted	= (((Boolean)results.get( "status" )).booleanValue());
					error				= (String) results.get("error") ;
					String closeWindow	= (String) results.get("closeWindow");
					if(inserted)
					{
						/// Added by Sridhar R on 05/26/2005 ...
						/// If AutoRequest is set for nursing unit then we should accept the file number from user.,
					
						if(error.lastIndexOf("<br>")>=0)
						error=error.substring(0,error.lastIndexOf("<br>"));

						String open_enctr_Sql = " Select booking_ref_no, dc_unit_code from IP_OPEN_ENCOUNTER where facility_id = '"+facilityId+"' and patient_id = '"+patient_id+"' and ENCOUNTER_ID = '"+encounterId+"' ";

						if(rset!=null) rset.close();
						if(pstmt !=null) pstmt.close();
						pstmt = connection.prepareStatement(open_enctr_Sql);
						rset = pstmt.executeQuery();

						if (rset!=null && rset.next())
						{
							booking_ref_no = rset.getString("booking_ref_no");
							if(booking_ref_no == null ) booking_ref_no = "";
							dc_unit_code = rset.getString("dc_unit_code");
							if(dc_unit_code == null ) dc_unit_code = "";
						}
						// Commenetd as part of PE By Sudhakar
						/*String mr_Sql =  "";
						if (patient_class.equals("IP"))
						{
							mr_Sql = "Select mr_section_code, mr_section_type from ip_nursing_unit where facility_id = '"+facilityId+"' and NURSING_UNIT_CODE = '"+nursing_unit_code+"' ";
						}
						else
						{
							mr_Sql = "Select mr_section_code, mr_section_type from op_clinic where facility_id = '"+facilityId+"' and clinic_code = '"+dc_unit_code+"' ";
						}
						if(rset!=null) rset.close();
						if(pstmt !=null) pstmt.close();
						pstmt = connection.prepareStatement(mr_Sql);
						rset = pstmt.executeQuery();

						if (rset!=null && rset.next())
						{
							mr_section_code = checkForNull(rset.getString("mr_section_code"));
						}*/

						/*String installSql = "select install_yn from sm_module where module_id = 'FM'";
						//String fm_install_yn			=   "N";
						if(rset!=null) rset.close();
						if(pstmt !=null) pstmt.close();
						pstmt = connection.prepareStatement(installSql);
						rset = pstmt.executeQuery();

						if (rset.next())
							fm_install_yn = checkForNull(rset.getString(1));*/

						if(fm_install_yn.equals("Y"))
						{
/*							String FileSql ="";

							if(!mr_section_code.equals(""))
								FileSql = "select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patient_id+"' and MR_SECTION_CODE  = '"+mr_section_code+"'";
							else
								FileSql = "select FILE_NO  from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+patient_id+"'" ;

							if(rset!=null) rset.close();
							if(pstmt !=null) pstmt.close();

							pstmt = connection.prepareStatement(FileSql);
							rset = pstmt.executeQuery();
							if (rset != null && rset.next())
							pat_file_no = checkForNull(rset.getString(1));
*/
//							if( !bed_no.equals("") && pat_file_no != "" && booking_ref_no.equals(""))
							if( !bed_no.equals("") && booking_ref_no.equals(""))
							{
								//out.println("<script>parent.window.close();</script>");
							
							HashMap hashResults = new HashMap();
							
							hashResults.put("nursing_unit_code",nursing_unit_code);
							hashResults.put("fm_install_yn",fm_install_yn);
							hashResults.put("patient_id",patient_id);
							hashResults.put("facilityId",facilityId);
							hashResults.put("encounterId",encounterId);
							hashResults.put("error",error);
							hashResults.put("year",year);
							requestfile(req,res,connection,hashResults);
							hashResults.clear();
							}
						}

						
						out.println("<script>alert('"+error+"')</script>");
						out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
						HashMap hashOnlineReports = new HashMap();
						hashOnlineReports.put("encounterId",encounterId);
						hashOnlineReports.put("nursing_unit_code",nursing_unit_code);
						hashOnlineReports.put("facilityId",facilityId);
						hashOnlineReports.put("facilityId",facilityId);
						hashOnlineReports.put("patient_id",patient_id);
						hashOnlineReports.put("locale",locale);
						hashOnlineReports.put("year",year);
						doOnlineReports(req,res, hashOnlineReports);
						hashOnlineReports.clear();
						String  strBLMessage ="0";
						try
						{
							if(bl_operational.equals("Y"))
							{
								strBLMessage = (String) results.get( "bl_message" );
								if (strBLMessage != null)
								{
									strBLMessage = strBLMessage.trim();
									if (strBLMessage.equals(""))
										strBLMessage = "0";
								}
								else
								{
									strBLMessage = "0";
								}

								if (!(strBLMessage.equals("0")))
								{
									out.println("<script>alert('"+strBLMessage+"')</script>");
								}
							}
						}
						catch (Exception exceptionBL)
						{
							strBLMessage = "0";
							exceptionBL.printStackTrace();
						}// End of MOD#01
					}
					else
					{
						if(error.lastIndexOf("<br>")>=0)
						error=error.substring(0,error.lastIndexOf("<br>"));
						out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>alert(\""+error+"\")</script>");
						out.println("<script>var frameObj = top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow;" +
								"if(!frameObj)frameObj=parent; frameObj.frames[1].document.forms[0].record.disabled=false;</script>");
						if(pat_check_in_allowed_yn.equals("Y"))
						{
								out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>" +
										"var frameObj = top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow;" +
										"if(!frameObj)frameObj=parent;" +
										"frameObj.frames[1].document.forms[0].Bedcode.disabled=true;frameObj.frames[1].document.forms[0].Bedtype.disabled=true;</script>");
						}

						if(closeWindow.equals("Y"))
						{
							out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>window.close();</script>");
						}
					}
					paramHashTab.clear();
					results.clear();
					}
				}
			if(resultSet!=null) resultSet.close();
			if(preStatement!= null) preStatement.close();

		}catch( Exception e )
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(connection != null)      ConnectionManager.returnConnection(connection,p);
		}
	}//E.o.Method InsertAssignBed


    private String convertString(String val)
    {
        /*if(val == null) val = "" ;
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
            val = stringbuffer.toString();

        }
        return val;
		*/
		if(val == null) val = "" ;
		return val.replaceAll("'","''");
    }


	private void requestfile(HttpServletRequest req, HttpServletResponse res,Connection con,HashMap hashResults) throws java.io.IOException
	{
		PrintWriter out						= null;
		//PreparedStatement preStatement		= null;
		//ResultSet resultSet					= null;
		ResultSet rset						= null;
		PreparedStatement pstmt				= null;
		Properties p						= null;
		HttpSession session					= null;
		out									= res.getWriter();
		session           					= req.getSession(false) ;
		p									= (java.util.Properties)session.getValue("jdbc");
		String sStyle						= "";
		sStyle								= checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		String sql							= "";
		String curr_file_status				= "";
		String sql1							= "";
		String nursingUnitCode				= "";
		String patient_id					= "";
		String facilityId					= "";
		String fm_install_yn				= "";
		String eId							= "";
		String error						= "";
		String year							= "";
		try
		{	
			nursingUnitCode					= (String)hashResults.get("nursing_unit_code");
			fm_install_yn					= (String)hashResults.get("fm_install_yn");
			patient_id						= (String)hashResults.get("patient_id");
			facilityId						= (String)hashResults.get("facilityId");
			eId								= (String)hashResults.get("encounterId");
			error							= (String)hashResults.get("error");
			year							= (String)hashResults.get("year");

			sql = "select fs_locn_code,online_mr_notfn_yn from ip_nursing_unit where facility_id = '"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"' ";
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			String online_mr_notfn_yn = "N" ;
			String fs_locn_code		= "N" ;
			if(fm_install_yn.equals("Y"))
			{
				if (rset.next())
				{
					fs_locn_code	   = checkForNull(rset.getString(1));
					online_mr_notfn_yn = checkForNull(rset.getString(2));
				}

				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if (online_mr_notfn_yn==null) online_mr_notfn_yn = "N";
				if (fs_locn_code==null) fs_locn_code="";

				   sql1 = "select curr_file_status from fm_curr_locn where facility_id = '"+facilityId+"' and  patient_id='"+patient_id+"' ";
				  if(rset!=null) rset.close();
			      if(pstmt!=null) pstmt.close();
			      pstmt = con.prepareStatement(sql1);
			      rset = pstmt.executeQuery();
				if (rset.next())
				{
				 curr_file_status=checkForNull(rset.getString("curr_file_status"));
				}

				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(curr_file_status==null) curr_file_status="";
				if(online_mr_notfn_yn.equals("Y"))
				{
					if(curr_file_status.equals("I"))
					{
					StringBuffer htmlFor = new StringBuffer();
					htmlFor.append(" <html><head><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
					htmlFor.append("<script language = 'JavaScript'>");
					htmlFor.append("async function showModal(){ ");
					htmlFor.append("var jsp_name = '../../eCommon/blank.html';");
					htmlFor.append(" jsp_name = '../eFM/jsp/FMAcceptFileTypeVolumeNoFrame.jsp?patient_id="+patient_id+"&encounter_id="+eId+"&fs_locn_code="+fs_locn_code+"&online_mr_notfn_yn="+online_mr_notfn_yn+"&req_locn_id="+nursingUnitCode+"';");
					htmlFor.append("var retVal = '';");
					htmlFor.append(" var dialogHeight	= '400px';");
					htmlFor.append(" var dialogWidth	= '700px';" );
					htmlFor.append(" var dialogTop		= '185';" );
					htmlFor.append(" var dialogLeft		= '250';" );
					htmlFor.append("var  center			= '0';" );
					htmlFor.append("var status			= 'no';");
					htmlFor.append("var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; center: ' + center + '; status: ' + status + '; dialogTop :' + dialogTop + ';dialogLeft:' + dialogLeft+';scroll=no';");
					htmlFor.append("var arguments		= '';");
					htmlFor.append("retValue		= await window.showModalDialog(jsp_name,arguments, features );");
					htmlFor.append("if(retValue== null)  retValue = 'N';");
					htmlFor.append("var ret = retValue.split('&');");
					htmlFor.append("document.all.req_no.value =ret[0]; ");				
					htmlFor.append("document.all.perm_fs_locn.value =ret[1]; ");				
					htmlFor.append("document.form1.submit();}");
					htmlFor.append("</script>");
					htmlFor.append("</head><body class='message'>");
					htmlFor.append("<form name='form1' method='post' action='../servlet/eIP.AssignBedServlet' target='messageFrame'>");
					htmlFor.append("<input type='hidden' name='req_no'></input>");
					htmlFor.append("<input type='hidden' name='perm_fs_locn'></input>");
					htmlFor.append("<input type='hidden' name='facilityId' value='"+facilityId+"'></input>");
					htmlFor.append("<input type='hidden' name='nursing_unit_code' value='"+nursingUnitCode+"'></input>");
					htmlFor.append("<input type='hidden' name='encounterId' value='"+eId+"'></input>");
					htmlFor.append("<input type='hidden' name='error' value='"+error+"'></input>");
					htmlFor.append("<input type='hidden' name='p_patient_id' value='"+patient_id+"'></input>");
					htmlFor.append("<input type='hidden' name='year' value='"+year+"'></input>");
					htmlFor.append("</form>");
					htmlFor.append("<script>");
				//	htmlFor.append("if("+showModal+")showModal();");
				//	htmlFor.append("else {document.form1.submit();}");
				//	htmlFor.append("document.form1.submit();");
					htmlFor.append("showModal();");
					htmlFor.append("</script>");	
					out.println("</body></html>");
					out.println(htmlFor.toString());
					}
				}
			}
		hashResults.clear();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
	}

	private void doOnlineReports(HttpServletRequest req,HttpServletResponse res, HashMap hashOnlineReports) throws ServletException, IOException, SQLException
	{
		PrintWriter out						= null;
		HttpSession session					= null;
		session           					= req.getSession(false) ;
		out									= res.getWriter();
		String sqlString					= "";
		String req_no						= "";
		String perm_fs_locn					= "";
		String sStyle						= "";
		sStyle								= checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		String encounter_id					= "";
		String nursing_unit					= "";
		String patient_id					= "";
		String facilityId					= "";
		String locale						= "";
		String clinic_type					= "N";
		int age								= 0;
		String wristBandLabel				= "";
		String patFileReq					= "";
		String year							= "" ;
		req_no								= req.getParameter("req_no") ;
		if(req_no==null)req_no				= "";
		perm_fs_locn						=	checkForNull(req.getParameter("perm_fs_locn"));
		String reportParamNames				= "";
		String reportParamValues			= "";
		String p_call_from					= "WALKIN";
		patient_id							= (String)hashOnlineReports.get("patient_id");
		encounter_id						= (String)hashOnlineReports.get("encounterId");
		nursing_unit						= (String)hashOnlineReports.get("nursing_unit_code");
		facilityId							= (String)hashOnlineReports.get("facilityId");
		locale								= (String)hashOnlineReports.get("locale");
		year								= (String)hashOnlineReports.get("year");
		try
		{
			age = Integer.parseInt(year);
			if(age <= 2)
				wristBandLabel = "IPBWBLBL";
			else
				wristBandLabel = "IPBINWBL";
			patFileReq			= "FMFLRQSL";
		}catch (Exception e) {	e.printStackTrace();}
		if(req_no.equals("") || req_no.equals("N"))
		{
			sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where b.language_id='"+locale+"' and  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_bed_assigned_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id and a.report_id not in ('"+wristBandLabel+"') order by 2 ";
			reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
			reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+patient_id+"";
		}else
		{
			sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where b.language_id='"+locale+"' and  a.module_id in ('IP','FM') and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_bed_assigned_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id and a.report_id not in ('"+wristBandLabel+"') order by 2 ";

			reportParamNames = "p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_req_no";
			reportParamValues = ""+encounter_id+","+p_call_from+","+nursing_unit+","+clinic_type+","+patient_id+","+req_no+"";
		}
		//reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id";
		//reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+patient_id+"";
		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>");
		htmlFor.append("function showModal(){ ");
		htmlFor.append("  var dialogHeight    = '550px' ;");
		htmlFor.append(" var dialogWidth = '800px' ;");
		htmlFor.append("var dialogTop = 58;" );
		htmlFor.append("  var arguments	=	''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=ASSIGN_BED&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&perm_fs_locn_code="+perm_fs_locn+"';");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append(" var retVal			=	window.showModalDialog(getUrl,arguments,features); parent.document.getElementById('dialog_tag').close();}");
		htmlFor.append("showModal()");
		htmlFor.append(" </script>"  );
		out.println(htmlFor.toString());
		out.println("</body></html>");
	}

	// By Annadurai 2/4/2004., to Handle NullPointerException.,
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	// By Annadurai 2/4/2004., ends.
}
