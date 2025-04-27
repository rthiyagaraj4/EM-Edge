<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.text.*, eCommon.XSSRequestWrapper, java.net.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	
	<script language='javascript' src='../js/AdmitPatient.js'></script>
	<script language='javascript' src='../js/AdmitPatient1.js'></script>
	<script language='javascript' src='../js/AdmitPatient2.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="Common.AdmitPatient.label" bundle="${common_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	String url				= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");		
	String loginUser		= (String)session.getValue("login_user");
	String patientid		= checkForNull((String)request.getParameter("patient_id"));
	String menuid			= checkForNull((String)request.getParameter("menu_id"));
	String f_nursing_unit	= checkForNull((String)request.getParameter("f_nursing_unit"));
	/*The Patient Id Getting From NewBornRegistrationServlet.java from MP*/
	String called_from=checkForNull((String)request.getParameter("function_id"));
	//below code added for ABM CRF 643.1 ICN:36736
	String from_adv_bed_mgmt=checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
	String bedNo=checkForNull((String)request.getParameter("bedNo"));
	String nursing_unit	= checkForNull((String)request.getParameter("nursing_unit"));
	String appl_patient_class	= checkForNull((String)request.getParameter("appl_patient_class"));

	/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));

	boolean result 					= true;
	Connection con					= null;
	int adm_date_chk_days			= 0;
	ResultSet rs 					= null;
	ResultSet rs2 					= null; 
	ResultSet rset_clinic			= null;
	ResultSet rset_opr 				= null;
	//ResultSet sqlRs 				= null;
	//Statement sqlStmt				= null;
	Statement stmt					= null;
	String adm_date_chk_days_type	= "";
	String admitpatyn				= "";
	String allowed_admission_type	= "";
	String back_date				= "";
	String backdated_admission_yn	= "";
	String bkg_grace_period			= "";
	String bl_interfaced_yn			= "";
	String call_func				= "";
	String deactivate_pseudo_bed_yn	= "N";
	String max_disch_period_for_dc	= "";
	String nurs_unt_auth_val		= "";
	String oper_stn_id				= "";
	String pat_checkin_yn			= "";
	String register_pat_in_admn_yn	= "";
	String reason_reqd_Flag 		= "N"; //Added for MMS-QH-CRF-0144
	//StringBuffer operSql	= new StringBuffer();
	StringBuffer queryString= new StringBuffer();
	StringBuffer sqlSb		= new StringBuffer();
	int nurs_unit_count=0;
	String noshow_bkng_period   = "";//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	try{	
		con	= ConnectionManager.getConnection(request);
		stmt= con.createStatement();
		//rs	= stmt.executeQuery("select allowed_admission_type, max_disch_period_for_dc, start_admit_screen, pat_check_in_allowed_yn, bl_interfaced_yn, adm_date_chk_days, adm_date_chk_days_type, bkg_grace_period, deactivate_pseudo_bed_yn from IP_PARAM where facility_id='"+facilityId+"' ") ;
		/**************Modified the below query for MMS-QH-CRF-0144 - getting REASON_MANDATORY_FOR_ADMN_YN column***************/
		rs	= stmt.executeQuery("SELECT a.oper_stn_id, a.admit_pat_yn, a.register_pat_in_admn_yn, a.admit_patient_with_bed_yn, a.backdated_admission_yn,(SELECT COUNT(*) FROM AM_OS_USER_LOCN_ACCESS_VW b WHERE b.facility_id='"+facilityId+"' AND b.locn_type = 'N' AND b.oper_stn_id = a.oper_stn_id AND b.appl_user_id = '"+loginUser+"' AND b.admit_pat_yn = 'Y' ) nurs_count, b.allowed_admission_type, b.max_disch_period_for_dc, b.start_admit_screen, b.pat_check_in_allowed_yn, b.bl_interfaced_yn, b.adm_date_chk_days, b.adm_date_chk_days_type, b.bkg_grace_period, b.deactivate_pseudo_bed_yn, b.noshow_bkng_period, b.REASON_MANDATORY_FOR_ADMN_YN FROM AM_OPER_STN a, ip_param b WHERE a.facility_id = '"+facilityId+"' AND a.facility_id = b.facility_id AND a.oper_stn_id = (SELECT oper_stn_id FROM AM_USER_FOR_OPER_STN WHERE facility_id = '"+facilityId+"' AND appl_user_id = '"+loginUser+"' AND TRUNC (SYSDATE) BETWEEN eff_date_from AND NVL (eff_date_to, TRUNC (SYSDATE)))") ;// modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
		
		
		if(rs.next()){
			max_disch_period_for_dc	= checkForNull(rs.getString("max_disch_period_for_dc"));
			call_func				= checkForNull(rs.getString("start_admit_screen"));
			
			pat_checkin_yn			= checkForNull(rs.getString("pat_check_in_allowed_yn"));
			bl_interfaced_yn		= checkForNull(rs.getString("BL_INTERFACED_YN"));
			adm_date_chk_days		= rs.getInt("adm_date_chk_days");
			adm_date_chk_days_type	= checkForNull(rs.getString("adm_date_chk_days_type"));
			bkg_grace_period		= checkForNull(rs.getString("bkg_grace_period"));
			deactivate_pseudo_bed_yn= checkForNull(rs.getString("deactivate_pseudo_bed_yn"),"N");
			allowed_admission_type	= checkForNull(rs.getString("allowed_admission_type"));
			admitpatyn				= rs.getString("admit_pat_yn");
			if(admitpatyn == null) admitpatyn ="N";		
			register_pat_in_admn_yn = rs.getString("register_pat_in_admn_yn");
			nurs_unt_auth_val       = rs.getString("admit_patient_with_bed_yn");
			backdated_admission_yn	= rs.getString("backdated_admission_yn");
			oper_stn_id				= rs.getString("oper_stn_id");
			nurs_unit_count			= rs.getInt("nurs_count");
			noshow_bkng_period   = checkForNull(rs.getString("noshow_bkng_period"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			reason_reqd_Flag 	 = rs.getString("REASON_MANDATORY_FOR_ADMN_YN");  //Added for MMS-QH-CRF-0144
          
			if (sqlSb.length() > 0) sqlSb.delete(0, sqlSb.length());
			//Commented for PE By Sudhakar
			/*if(adm_date_chk_days_type.equals("H"))
				sqlSb.append("SELECT TO_CHAR(SYSDATE-"+adm_date_chk_days+"/24,'dd/mm/rrrr hh24:mi') setup_date FROM dual");
			else
				sqlSb.append("SELECT TO_CHAR(SYSDATE-"+adm_date_chk_days+",'dd/mm/rrrr hh24:mi') setup_date FROM dual");

			sqlStmt	= con.createStatement();
			sqlRs	= sqlStmt.executeQuery(sqlSb.toString());
            
			while(sqlRs.next())
			{
				back_date = sqlRs.getString("setup_date");
			}

			if(sqlRs !=null) sqlRs.close();
			if(sqlStmt !=null) sqlStmt.close();*/	

			queryString.append("bl_interfaced_yn="+bl_interfaced_yn+"&adm_date_chk_days="+adm_date_chk_days);		queryString.append("&back_date="+java.net.URLEncoder.encode(back_date)+"&adm_date_chk_days_type="+adm_date_chk_days_type+"&bkg_grace_period="+bkg_grace_period+"&pat_checkin_yn="+pat_checkin_yn+"&max_disch_period_for_dc='"+max_disch_period_for_dc);

			/*
			//Added by Devang For Operator Station & Clinic  Check
			operSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
			rset_opr  = stmt.executeQuery(operSql.toString());
			if(rset_opr!=null)
			{
				if(rset_opr.next())
				{
					oper_stn_id = rset_opr.getString("OPER_STN_ID");
					if(oper_stn_id == null) oper_stn_id ="";			
				}	
				else
				{ 
					out.println("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));</script>");
					result = false;
					if(patientid.equals("") && !menuid.equals(""))
					{
						out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}
			}
			if(rset_opr != null) rset_opr.close();

			if (!oper_stn_id.equals("") && result)
			{
				// This query is to check whether the current operator station has acces to the Admit Patient function.
				if(operSql.length() > 0)
				operSql.delete(0,operSql.length());

				operSql.append("select admit_pat_yn, register_pat_in_admn_yn  from am_oper_stn ");
				operSql.append(" where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  "); 
				operSql.append(" where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ");
				rs2 = stmt.executeQuery(operSql.toString());
				if(rs2!= null)
				{
					while(rs2.next())
					{
						admitpatyn = rs2.getString("admit_pat_yn");
						if(admitpatyn == null) admitpatyn ="";		
						register_pat_in_admn_yn	 = checkForNull(rs2.getString("register_pat_in_admn_yn"),"N");
					}
				}

				//Check whether the user have authority for bed booking or not
				if (sqlSb.length() > 0) sqlSb.delete(0, sqlSb.length());
				sqlSb.append(" SELECT ADMIT_PATIENT_WITH_BED_YN, BACKDATED_ADMISSION_YN  FROM am_os_user_locn_access_vw WHERE facility_id='"+facilityId+"' AND oper_stn_id= '"+oper_stn_id+"' AND appl_user_id = '"+loginUser+"' and LOCN_TYPE = 'N' "); 

				sqlStmt	= con.createStatement();
				sqlRs	= sqlStmt.executeQuery(sqlSb.toString());
				if(sqlRs!=null)
				{
					while(sqlRs.next())
					{
						nurs_unt_auth_val = sqlRs.getString("ADMIT_PATIENT_WITH_BED_YN");
						backdated_admission_yn = sqlRs.getString("BACKDATED_ADMISSION_YN");
					}
				}

				if(sqlRs !=null) sqlRs.close();
				if(sqlStmt !=null) sqlStmt.close();	
*/
				/*if(operSql.length() > 0)
				operSql.delete(0,operSql.length());
				//Commented for PE By Sudhakar

				operSql.append("SELECT a.oper_stn_id, a.admit_pat_yn, a.register_pat_in_admn_yn,        a.admit_patient_with_bed_yn, a.backdated_admission_yn FROM AM_OPER_STN a WHERE a.facility_id = '"+facilityId+"' AND a.oper_stn_id = (SELECT oper_stn_id FROM AM_USER_FOR_OPER_STN where facility_id = '"+facilityId+"' AND appl_user_id = '"+loginUser+"' AND TRUNC (SYSDATE) BETWEEN eff_date_from AND NVL (eff_date_to, TRUNC (SYSDATE)))/* AND EXISTS ( SELECT locn_code from AM_LOCN_FOR_OPER_STN where facility_id = '"+facilityId+"' AND oper_stn_id = a.oper_stn_id AND locn_type = 'N' ) ");
				
				rs2 = stmt.executeQuery(operSql.toString());
				
				if(rs2!= null)
				{
					while(rs2.next())
					{
						admitpatyn				= rs2.getString("admit_pat_yn");
						if(admitpatyn == null) admitpatyn ="N";		
						register_pat_in_admn_yn = rs2.getString("register_pat_in_admn_yn");
						nurs_unt_auth_val       = rs2.getString("admit_patient_with_bed_yn");
						backdated_admission_yn	= rs2.getString("backdated_admission_yn");
						oper_stn_id				= rs2.getString("oper_stn_id");
					}
				}*/

				if (oper_stn_id.equals("")){
					out.println("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));</script>");
					result = false;
					if(patientid.equals("") && !menuid.equals("")){
						out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}else if(admitpatyn.equals("Y")){
					// The following query will check whether the logged in user has access to any nursing unit, which are associated to the operator station.
					//Commented for PE By Sudhakar
					/*if(operSql.length() > 0)
					operSql.delete(0,operSql.length());
					operSql.append(" SELECT b.locn_code FROM AM_OS_USER_LOCN_ACCESS_VW b WHERE b.facility_id='"+facilityId+"' and b.locn_type = 'N' AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+loginUser+"' AND b.admit_pat_yn = 'Y' ");

					rs = stmt.executeQuery(operSql.toString());*/
					if (!(nurs_unit_count > 0)){
						if(!patientid.equals("")){
							out.println("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));window.parent.close();</script>");
						}else{
							out.println("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));</script>");
							if(patientid.equals("") && !menuid.equals("")){ 
								out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
							}
						}
					}else{
						if(!patientid.equals("")){
							if(!called_from.equals("NEWBORN_REG"))//added for  ICN 7440 12/31/2008
							source="../../eIP/jsp/AdmitPatientToolbar.jsp" ;
							/*Below line modified  for this CRF  Bru-HIMS-CRF-261*/
							%><!-- modified for MMS-QH-CRF-0144 : passing reason_reqd_Flag parameter-->
							<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod' id='f_query_add_mod' 	src="../../eIP/jsp/PaintAdmitPatient.jsp?patient_id=<%=patientid%>&oper_stn_id=<%=oper_stn_id%>&register_pat_in_admn_yn=<%=register_pat_in_admn_yn%>&P_call_func=PATREG&nurs_unt_auth_val=<%=nurs_unt_auth_val%>&backdated_admission_yn=<%=backdated_admission_yn%>&max_disch_period_for_dc=<%=max_disch_period_for_dc%>&f_nursing_unit=<%=f_nursing_unit%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&allowed_admission_type=<%=allowed_admission_type%>&called_from=<%=called_from%>&quick_admission_type=<%=quick_admission_type%>&quick_adm_referralid=<%=quick_adm_referralid%>&quick_adm=<%=quick_adm%>&ref_encounter_id=<%=ref_encounter_id%>&reason_reqd_Flag=<%=reason_reqd_Flag%>&<%=queryString.toString()%>" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe>
							<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>	
				<%		}else{
							if(call_func.equals("D")){
							
							if(from_adv_bed_mgmt.equals("Y")){
								source="../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt='Y'" ;
							}
							/*Below line modified for this CRF  Bru-HIMS-CRF-261*/
							%>	<!-- modified for MMS-QH-CRF-0144 : passing reason_reqd_Flag parameter-->
								<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
								<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eIP/jsp/PaintAdmitPatient.jsp?P_call_func=ADMIT&oper_stn_id=<%=oper_stn_id%>&nurs_unt_auth_val=<%=nurs_unt_auth_val%>&backdated_admission_yn=<%=backdated_admission_yn%>&max_disch_period_for_dc=<%=max_disch_period_for_dc%>&register_pat_in_admn_yn=<%=register_pat_in_admn_yn%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&allowed_admission_type=<%=allowed_admission_type%>&noshow_bkng_period=<%=noshow_bkng_period%>&from_adv_bed_mgmt=<%=from_adv_bed_mgmt%>&bedNo=<%=bedNo%>&nursing_unit=<%=nursing_unit%>&appl_patient_class=<%=appl_patient_class%>&quick_admission_type=<%=quick_admission_type%>&quick_adm_referralid=<%=quick_adm_referralid%>&quick_adm=<%=quick_adm%>&ref_encounter_id=<%=ref_encounter_id%>&reason_reqd_Flag=<%=reason_reqd_Flag%>&<%= queryString.toString()%>' frameborder=0 scrolling='auto' style='height:82vh;width:100vw'></iframe>
								<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
					<%		}else{	%>
								<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
								<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/BedAvailabilityChart.jsp?P_call_func=ADMIT' frameborder=0 scrolling='auto' style='height:82vh;width:100vw'></iframe>
								<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
					<%		}
						}
					} //e.o. !rs.next -- for ip clinic
				}//e.o.if Admit = "Y"
				else{
					if(!patientid.equals("")){
						out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));window.parent.close();</script>");
					}else{ 
						out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));</script>");
						if(patientid.equals("") && !menuid.equals("")){ 
							out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp'</script>");
						}
					}
				}		
		//	}// opr
		}else if(!patientid.equals("")){ 
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));window.parent.close();</script>");
		}else{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));</script>");
			if(patientid.equals("") ){
				out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
			}
		}
		if(rs!=null) 			rs.close();
		if(rs2!=null)			rs2.close();
		if(rset_opr!=null)		rset_opr.close();
		if(rset_clinic!=null)	rset_clinic.close();
		if(stmt!=null) 			stmt.close();
	}catch(Exception e){
		//out.print("Exception in AdmitPatient.jsp : "+e.toString());
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>


<%!	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}	
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

