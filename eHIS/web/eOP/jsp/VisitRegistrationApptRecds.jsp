<!DOCTYPE html>
<!--    Function Name VisitRegistration
    Created by M.Sathis Kumar on 13/12/2000 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>	
<%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-Content-Type-Options", "nosniff");

	Connection con  = null; 
	PreparedStatement pstmt=null;       
	PreparedStatement multiPrepdStmt=null;       
	ResultSet rs=null; 
	ResultSet multirset=null; 
	String q_patient_id     = "";
	String q_appt_time  = "";   
	String contact_reason_code="";
	String reason="";
	String status       = "";
	String patientName  = "";
	String location     = "";
	String practitioner     = "";
	String practitioner_id="";
	String resource_class="";
	String resource_desc="";
	String q_appt_ref_no = "";        
	String nationality = "";
	String ordering_facility_id="";
	String order_id="";
	String order_line_num="";
	String order_type_code="";
	String order_catalog_code="";
	String order_catalog_desc="";
	String referral_id="";
	String recur_wo_sec_res="";
	StringBuffer sql1=new StringBuffer();
	String ref_reg_yn="";
	String locn_type="";
	String locn_code="";
	String service_code="";
	String cur_appt_ref_no="";
	
	// Variable defined for showing Multi colors        
	String classValue   = "";
	int row_even_or_odd = 1;
	String national_id_no = "";
	String nat_id_prompt = "";
	//int maxrecds=0;
	//String retunVal = "";
	String locale=checkForNull((String)session.getAttribute("LOCALE"));
	String nbsp_disp="&nbsp;";
	int count=0;
	//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
	Boolean isSlotStartMidEndAppl = false;

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	Boolean isImproveReferralProcessAppl = false;
	StringBuffer sqlRef = new StringBuffer();
	PreparedStatement pstmtRef = null;     
	ResultSet rsRef = null;
	int ref_count = 0;
	String q_referral_id = "";
	String q_added_date = "";
	String q_preferred_date = "";
	String q_from_referral = "";
	String q_referral_priority = "";
	String q_prev_referral_priority ="";
	StringBuffer from_referral = new StringBuffer();
	from_referral.setLength(0);

try{
		con = ConnectionManager.getConnection(request);

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS");
		String selected_loc_code   = request.getParameter("selected_loc_code")==null?"":request.getParameter("selected_loc_code");

		String Facility_Id  = checkForNull((String) session.getValue("facility_id"));
		String patient_id   = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String build_episode_rule=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
		String oa_install_yn=request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
		String or_install_yn=request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
		String bl_interface_yn=request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");
		//String userid         = (String) session.getValue("login_user");
		String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
		String oper_stn_id  = (request.getParameter("oper_stn_id") == null)?"":request.getParameter("oper_stn_id");
		String register_visit_walkin=(request.getParameter("register_visit_walkin") == null)?"":request.getParameter("register_visit_walkin");
		nat_id_prompt=request.getParameter("nat_id_prompt") == null?"":request.getParameter("nat_id_prompt");
		
		String register_visit_referral=(request.getParameter("register_visit_referral") == null)?"":request.getParameter("register_visit_referral"); 
		
		String functionId=(request.getParameter("function_id") == null)?"":request.getParameter("function_id"); 
		String call_from=request.getParameter("call_from") == null?"":request.getParameter("call_from");	
		//Added the below code for SRR20056-SCF-3046.1 [IN:026060] by Suresh M on 21.01.2010
		String visit_for_inpat_yn="";
		visit_for_inpat_yn=request.getParameter("visit_for_inpat_yn") == null?"":request.getParameter("visit_for_inpat_yn");		
		//Ends
		
		String multi_speciality_yn=request.getParameter("multi_speciality_yn") == null?"N":request.getParameter("multi_speciality_yn");//Added for the CRF Bru-HIMS-CRF-0198
		String speciality_code=request.getParameter("speciality_code") == null?"":request.getParameter("speciality_code");//Added for the CRF Bru-HIMS-CRF-0198
		String Speciality=request.getParameter("speciality") == null?"":request.getParameter("speciality");//Added for MMS-DM-CRF-0223 BY KAMATCHI S
		String multi_pract_sql="";//Added for the CRF Bru-HIMS-CRF-0198

		/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		String isPractoApptYn = "N";
		String ext_appt_ref_no	= "";
		Boolean isPractoApptApplYN = CommonBean.isSiteSpecific(con,"OP","OP_AUTO_APPLY_PRACTO_APPT");
		/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
	
%>
<html>
<head>
	<meta http-equiv="Expires" content="0">
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script language='javascript' src='../../eOP/js/VisitRegistration1.js'></script>	
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	// #A0A0A0
	cur_appt_ref_no= (request.getParameter("cur_appt_ref_no") == null)?"":request.getParameter("cur_appt_ref_no");

//naren - pass from criteria page    
	/*pstmt = con.prepareStatement("select nvl(nat_id_prompt,'National ID No') nat_id_prompt from mp_param_lang_vw where language_id='"+locale+"' and  module_id='MP'");
	rs = pstmt.executeQuery();
	if (rs != null && rs.next())
		nat_id_prompt = rs.getString(1);

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();*/

		
// naren - to be removed
/*	sql1.append("select count(*) as total from oa_appt a, op_clinic b where a.facility_id='"+Facility_Id+"' and  a.patient_id = '"+patient_id+"' and trunc(a.appt_date)=trunc(sysdate) and  a.facility_id = b.facility_id and a.appt_status != 'A' and b.clinic_code = a.clinic_code ");

	if(functionId.equals("VISIT_REGISTRATION"))
	{							
		sql1.append("and b.clinic_type = 'C'");
	}
	else if(functionId.equals("PROCD_REGISTRATION"))
	{		
		sql1.append("and b.clinic_type = 'E'");
	}				

	pstmt   = con.prepareStatement(sql1.toString());						
	rs = pstmt.executeQuery();
	if(rs != null && rs.next())
	{				
		maxrecds = rs.getInt(1);				 
	}

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	sql1.setLength(0);*/

    %>
    <body class='content' onKeyDown='lockKey();' topmargin='0' bottommargin='0' onscroll='scrollTitle();' <%if(isImproveReferralProcessAppl){%>onload="displayApptRefDtls();"<%}%> >
        <form name="apptrecds" id="apptrecds">
           
			<%
			if(!patient_id.equals(""))
			{
			  
//naren - change as avbl in visitregistrationqueryresult.jsp				
		//int i=1;		
  sql1.append("SELECT   TO_CHAR(a.appt_time,  'hh24:mi') appt_time,  a.appt_status appt_status,  decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name,  NVL(a.patient_id,  '') patient_id,  OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_desc,    DECODE(a.resource_class,  'P', am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1),  'R',  a.practitioner_id,  AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2')) practitioner_name,  a.CLINIC_CODE  clinic_code,  a.practitioner_id practitioner_id,  a.appt_ref_no appt_ref_no,  a.appt_type_code,  MP_GET_DESC.MP_COUNTRY(a.country_code,'"+locale+"','3') nationality,  national_id_no,a.clinic_code,  a.care_locn_type_ind clinic_type,  a.resource_class resource_class, a.service_code service_code, a.resource_class  resource_desc,  a.recur_wo_sec_res recur_wo_sec_res,MULTI_SPECIALITY_YN,a.SPECIALITY_CODE ");
  if(or_install_yn.equals("Y"))
   {
     sql1.append(",a.ordering_facility_id ordering_facility_id,a.order_id order_id,a.order_line_num order_line_num,a.order_type_code order_type_code, a.order_catalog_code order_catlog_code,   d.short_desc order_catalog_desc ");
     } 
   
     sql1.append(",NVL(a.referral_id,'')referral_id,a.recur_wo_sec_res recur_wo_sec_res,a.care_locn_type_ind clinic_type,am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE,a.EXT_APPT_REF_NO FROM   oa_appt a");
  if(or_install_yn.equals("Y"))
   {
     sql1.append(",or_order_catalog d");  
   }
     sql1.append(" WHERE  a.facility_id = '"+Facility_Id+"' AND  a.appt_status != 'A'  AND  a.patient_id = '"+patient_id+"' AND rd_appt_yn = 'N' AND a.appt_date=TRUNC(SYSDATE)");
     if(functionId.equals("VISIT_REGISTRATION"))
	 {		
		sql1.append(" and a.care_locn_type_ind in ('C','E') ");
	 }
	 else if(functionId.equals("PROCD_REGISTRATION"))
	 {
		sql1.append(" and a.care_locn_type_ind = 'E'");
	 }
 
    sql1.append(" AND  a.clinic_code IN (SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+Facility_Id+"' AND  b1.oper_stn_id = '"+oper_stn_id+"'  AND  b1.eff_status = 'E') ");

    if(or_install_yn.equals("Y"))
     {sql1.append("AND   a.order_catalog_code=d.order_catalog_code(+) ");
     }
	 sql1.append("ORDER BY a.appt_time");
				
			/*	sql1.append("select to_char(a.appt_time,'hh24:mi') appt_time,a.appt_status appt_status, a.patient_name patient_name,");
				sql1.append("nvl(a.patient_id,'') patient_id,b.short_desc clinic_desc, decode(b.primary_resource_class,'P',c.short_name,'R',a.practitioner_id,'E',a.practitioner_id,'O',a.practitioner_id, c.practitioner_name) practitioner_name,b.clinic_code clinic_code,");
				sql1.append("a.practitioner_id practitioner_id,a.appt_ref_no appt_ref_no,a.appt_type_code,cntry.long_desc nationality, national_id_no,b.primary_resource_class resource_class,decode(b.primary_resource_class,'P','Practitioner','R','Room','E','Equipment','O','Others','Practitioner') resource_desc");
				if(or_install_yn.equals("Y"))
				{
				sql1.append(",a.ordering_facility_id ordering_facility_id,a.order_id order_id,a.order_line_num order_line_num,a.order_type_code order_type_code,a.order_catalog_code order_catlog_code,d.short_desc order_catalog_desc ");
				}
				sql1.append(",nvl(a.referral_id,'')referral_id,a.recur_wo_sec_res recur_wo_sec_res,b.clinic_type clinic_type from oa_appt a,");
				sql1.append(" op_clinic b,am_practitioner c, mp_country cntry ");
				if(or_install_yn.equals("Y"))
				{
					sql1.append(",or_order_catalog d ");
				}
				sql1.append(" where a.appt_status != 'A' and b.clinic_code = a.clinic_code ");
				sql1.append("and a.facility_id='"+Facility_Id+"' and  a.patient_id = '"+patient_id+"' and a.country_code = cntry.country_code (+) and trunc(a.appt_date)=trunc(sysdate)");

				if(functionId.equals("VISIT_REGISTRATION"))
				{
					sql1.append(" and b.clinic_type = 'C'");
				}
				else if(functionId.equals("PROCD_REGISTRATION"))
				{
					sql1.append(" and b.clinic_type = 'E'");
				}
						
				sql1.append(" and c.practitioner_id(+) = a.practitioner_id  and  a.facility_id = b.facility_id");
				sql1.append(" and a.clinic_code in (SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+Facility_Id+"' AND b1.oper_stn_id = '"+oper_stn_id+"'  AND b1.eff_status = 'E') ");
				if(or_install_yn.equals("Y"))
				{
					sql1.append(" and a.order_catalog_code=d.order_catalog_code(+)");
				}
				sql1.append(" order by appt_time "); */     
				
				

                pstmt   = con.prepareStatement(sql1.toString());			
              
				rs = pstmt.executeQuery();
				//if( rs.next()) 
				//{ //rs.previous();
				
				//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
				if(isImproveReferralProcessAppl && !selected_loc_code.equals("")){
					sqlRef.append("SELECT patient_id, to_locn_code, to_locn_type, from_locn_code, referral_priority, a.added_date created_date, referral_id, TO_CHAR (a.added_date, 'dd/mm/yyyy') added_date, TO_CHAR (preferred_treatment_date, 'dd/mm/yyyy') preferred_date, DECODE (from_ref_type, 'X', am_get_desc.am_referral (from_ref_code, '"+locale+"', 1), sm_get_desc.sm_facility_param (from_facility_id, '"+locale+"', '1') ) from_source_desc, op_get_desc.op_clinic (from_facility_id, from_locn_code, '"+locale+"', '1' ) from_locn_desc, DECODE (from_ref_type, 'X', NVL (from_pract_name, am_get_desc.am_ext_practitioner (from_pract_id, '"+locale+"', '1' ) ), am_get_desc.am_practitioner (from_pract_id, '"+locale+"', '1') ) from_pract_name FROM pr_referral_search_vw a WHERE to_facility_id = '"+Facility_Id+"' AND ( (TRUNC (preferred_treatment_date) = TRUNC (SYSDATE)) OR (preferred_treatment_date IS NULL) ) AND close_encounter_id IS NULL AND TRUNC (added_date) BETWEEN TO_DATE (TO_CHAR (SYSDATE - 30, 'DD/MM/YYYY' ), 'DD/MM/RRRR' ) AND TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy'), 'DD/MM/RRRR' ) AND to_locn_type IN ('C')  AND to_speciality_code = '"+Speciality+"' AND patient_id = '"+patient_id+"' ORDER BY referral_priority, created_date DESC, referral_id");

//Commented for MMS-DM-CRF-0223 BY KAMATCHI S
/*sqlRef.append("SELECT patient_id, to_locn_code, to_locn_type, from_locn_code, referral_priority, a.added_date created_date, referral_id, TO_CHAR (a.added_date, 'dd/mm/yyyy') added_date, TO_CHAR (preferred_treatment_date, 'dd/mm/yyyy') preferred_date, DECODE (from_ref_type, 'X', am_get_desc.am_referral (from_ref_code, '"+locale+"', 1), sm_get_desc.sm_facility_param (from_facility_id, '"+locale+"', '1') ) from_source_desc, op_get_desc.op_clinic (from_facility_id, from_locn_code, '"+locale+"', '1' ) from_locn_desc, DECODE (from_ref_type, 'X', NVL (from_pract_name, am_get_desc.am_ext_practitioner (from_pract_id, '"+locale+"', '1' ) ), am_get_desc.am_practitioner (from_pract_id, '"+locale+"', '1') ) from_pract_name FROM pr_referral_search_vw a WHERE to_facility_id = '"+Facility_Id+"' AND ( (TRUNC (preferred_treatment_date) = TRUNC (SYSDATE)) OR (preferred_treatment_date IS NULL) ) AND close_encounter_id IS NULL AND TRUNC (added_date) BETWEEN TO_DATE (TO_CHAR (SYSDATE - 30, 'DD/MM/YYYY' ), 'DD/MM/RRRR' ) AND TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy'), 'DD/MM/RRRR' ) AND to_locn_code = '"+selected_loc_code+"' AND to_locn_type IN ('E','C') AND patient_id = '"+patient_id+"' ORDER BY referral_priority, created_date DESC, referral_id");*/					
					pstmtRef = con.prepareStatement(sqlRef.toString());
              
					rsRef = pstmtRef.executeQuery();
				}

				%>

	<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->
	<%if(isImproveReferralProcessAppl){%>
	<table border='1' cellpadding='0' cellspacing='0' align='center' width='100%'>
		<tr>
			<input type="button" style='display:none' class=button name='appt_list' id='appt_list' value='<fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.List.label" bundle="${common_labels}"/>' title='Appointment List' onClick="displayApptList();"></input>
			<input type="button" style='display:none' class=button name='ref_list' id='ref_list' value='<fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.List.label" bundle="${common_labels}"/>' title='Referral List' onClick="displayRefList();"></input>
		</tr>
	</table>
	<%}%>
					
						<%						
						while( rs.next() ) 
						{if(count==0){
							%>
							
						<%if(isImproveReferralProcessAppl){%>	
						<table border='1' cellpadding='0' cellspacing='0' align='center' width='100%' id='appt_button_list' style='display:none'>
						<%}else{%>
						<table border='1' cellpadding='0' cellspacing='0' align='center' width='100%'>
						<%}%>

						<tr>
							<th align='left' nowrap colspan='10'>
							<div  id='divTitleTable' class='myClass'> <fmt:message key="eOP.todayapptfor.label" bundle="${op_labels}"/>&nbsp;<%=patient_id%></div>
							</th>
						</tr>               
						<th align='center'  width='5%' nowrap><div  id='head1' class='myClass'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></div></th>
						<th align='center'  width='5%' nowrap><div  id='head2' class='myClass'><fmt:message key="Common.time.label" bundle="${common_labels}"/></div></th>
						<th align='center'  width='13%' nowrap><div  id='head3' class='myClass'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>        
						<th align='center'  width='10%' nowrap><div  id='head4' class='myClass'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></div></th>      
						<th align='center'  width='13%' nowrap><div  id='head5' class='myClass'><%=nat_id_prompt%></div></th>
						<th align='center'  width='10%' nowrap><div  id='head6' class='myClass'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></div></th>        	
						<th align='center'  width='13%' nowrap><div  id='head7' class='myClass'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></div></th> 
						<th align='center'  width='17%' nowrap><div  id='head8' class='myClass'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></div> </th> 				
				    	 <th align='center'  width='14%' nowrap><div  id='head9' class='myClass'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></div></th>  
				    	<!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->
						 <%if(isPractoApptApplYN){%>
							 <th align='center'  width='14%' nowrap><div  id='head9' class='myClass'><fmt:message key="eOA.AppointmentSource.label" bundle="${oa_labels}"/></div></th>  
						 <%}%>
						 <!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->
							<%count++;}
							
							if (row_even_or_odd == 1)
							{
								row_even_or_odd = 2;
								classValue = "QRYODD";
							}
							else
							{
								classValue = "QRYEVEN";                 
								row_even_or_odd = 1;                    
							    }
							
							q_patient_id=(rs.getString("patient_id") == null)?"":rs.getString("patient_id");					

							q_appt_time=(rs.getString("appt_time") == null)?"":rs.getString("appt_time");
											
							status = rs.getString("appt_status");
							if(status == null ) status = "";
							
							patientName  = rs.getString("patient_name");
							if(patientName == null ) patientName = "";

							resource_class=rs.getString("resource_class");
							if(resource_class == null ) resource_class = "";

						resource_desc=rs.getString("resource_desc")==null?"":rs.getString("resource_desc");

							if(resource_desc.equals("P"))
							{
							resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
							
							
							}else if(resource_desc.equals("R"))
							{
							resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
							
							
							}else if(resource_desc.equals("E"))
							{
							resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
							}else if(resource_desc.equals("O"))
							{
						resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
							}


									
							location = rs.getString("clinic_desc");
							if(location == null ) location ="";
							
							practitioner = rs.getString("practitioner_name");
							if(practitioner == null ) practitioner = "";



							//if(resource_class.equals("P"))
							//{
								practitioner_id=rs.getString("practitioner_id");	
								
							//}
							//Added for the CRF Bru-HIMS-CRF-0198 - start
								multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");
							    
							    if(multi_speciality_yn.equals("Y")){
							    	speciality_code=rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
							    	multi_pract_sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where PRIMARY_SPECIALITY_CODE='"+speciality_code+"' and language_id='"+locale+"'";
							    	multiPrepdStmt   = con.prepareStatement(multi_pract_sql);				
							    	multirset = multiPrepdStmt.executeQuery();
							    	if(multirset!=null && multirset.next()){
							    		practitioner_id=multirset.getString("practitioner_id");							    		
							    	}
							    }
							    if(multirset!=null) multirset.close();
							    if(multiPrepdStmt!=null)multiPrepdStmt.close();
							  //Added for the CRF Bru-HIMS-CRF-0198 - End

							if(practitioner_id == null ) practitioner_id = "";
							
							q_appt_ref_no = rs.getString("appt_ref_no");
							if(q_appt_ref_no == null ) q_appt_ref_no = "";				

							nationality = rs.getString("nationality");
							if(nationality == null ) nationality = "";

							national_id_no = rs.getString("national_id_no");
							if(national_id_no == null ) national_id_no = "";
							contact_reason_code=(rs.getString("contact_reason_code") == null)?"":rs.getString("contact_reason_code");
                           reason=(rs.getString("reason") == null)?"":rs.getString("reason");
							if(or_install_yn.equals("Y"))
							{
								ordering_facility_id=(rs.getString("ordering_facility_id") == null)?"":rs.getString("ordering_facility_id");
								order_id=(rs.getString("order_id") == null)?"":rs.getString("order_id");
								order_line_num=(rs.getString("order_line_num") == null)?"":rs.getString("order_line_num");
								order_type_code=(rs.getString("order_type_code") == null)?"":rs.getString("order_type_code");	
								order_catalog_code=(rs.getString("order_catlog_code") == null)?"":rs.getString("order_catlog_code");
								order_catalog_desc=(rs.getString("order_catalog_desc") == null)?"":rs.getString("order_catalog_desc");
							        }
							

							referral_id=(rs.getString("referral_id") == null)?"":rs.getString("referral_id");

							String referral_id_dis = "";

							if(referral_id.equals(""))
								referral_id_dis = "&nbsp;";
							else
								referral_id_dis = referral_id;

							recur_wo_sec_res=(rs.getString("recur_wo_sec_res") == null)?"":rs.getString("recur_wo_sec_res");
							ref_reg_yn = "";
							locn_type=(rs.getString("clinic_type") == null)?"":rs.getString("clinic_type");
							locn_code=(rs.getString("clinic_code") == null)?"":rs.getString("clinic_code");	
							
							service_code=(rs.getString("service_code") == null)?"":rs.getString("service_code");					
							/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
							ext_appt_ref_no=(rs.getString("EXT_APPT_REF_NO") == null)?"":rs.getString("EXT_APPT_REF_NO");	
							isPractoApptYn = "N";
							if(!ext_appt_ref_no.equals(""))
								isPractoApptYn = "Y";
							/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
									
// naren - check and remove it										
					/*		cs = con.prepareCall("{call GET_ACCESS_RIGHTS_FOR_OPER_STN(?,?,?,?,?)}") ;
							cs.setString(1, Facility_Id);
							cs.setString(2, userid);    
							cs.setString(3, locn_type);    
							cs.setString(4, locn_code);    
							cs.registerOutParameter( 5,java.sql.Types.VARCHAR);
							cs.execute() ;
							if(cs.getString(5) == null || cs.getString(5).equals("null")) 
								retunVal = "";
							else
								retunVal = cs.getString(5);

							if(!retunVal.equals(""))
							   ref_reg_yn = retunVal.substring(8,9);
										
							if(cs != null)  cs.close() ;  */                            
										
							%>
						
							<tr>						
							<%

							//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
							if(isImproveReferralProcessAppl){ %>
								<td width="5%" align="left" class= "<%=classValue%>"><font size='1' nowrap>
									<a href="javascript:tab_click_add_visitapptrecds('<%=q_patient_id%>','<%=locn_code%>','<%=practitioner_id%>','<%=q_appt_ref_no%>','R','<%=rs.getString(10)%>','<%=rs.getString(8)%>','<%=resource_class%>','<%=ordering_facility_id%>','<%=order_id%>','<%=order_line_num%>','<%=order_type_code%>','<%=order_catalog_code%>','<%=order_catalog_desc%>','<%=referral_id%>','<%=ref_reg_yn%>','N','<%=recur_wo_sec_res%>','<%=q_appt_ref_no%>','<%=oper_stn_id%>','<%=functionId%>','<%=contact_reason_code%>','<%=reason%>','<%=locn_type%>','<%=service_code%>','','<%=visit_for_inpat_yn%>','<%=q_appt_time%>','<%=multi_speciality_yn%>','','<%=isPractoApptYn%>')"><%=q_appt_ref_no%></a>
								</td>
							<%
							}else{
							if(!cur_appt_ref_no.equals(q_appt_ref_no))
							{
								%>
								<td width="5%" align="left" class= "<%=classValue%>"><font size='1' nowrap>
									<a href="javascript:tab_click_add_visitapptrecds('<%=q_patient_id%>','<%=locn_code%>','<%=practitioner_id%>','<%=q_appt_ref_no%>','R','<%=rs.getString(10)%>','<%=rs.getString(8)%>','<%=resource_class%>','<%=ordering_facility_id%>','<%=order_id%>','<%=order_line_num%>','<%=order_type_code%>','<%=order_catalog_code%>','<%=order_catalog_desc%>','<%=referral_id%>','<%=ref_reg_yn%>','N','<%=recur_wo_sec_res%>','<%=q_appt_ref_no%>','<%=oper_stn_id%>','<%=functionId%>','<%=contact_reason_code%>','<%=reason%>','<%=locn_type%>','<%=service_code%>','','<%=visit_for_inpat_yn%>','<%=q_appt_time%>','<%=multi_speciality_yn%>','','<%=isPractoApptYn%>')"><%=q_appt_ref_no%></a>
								</td>
							<%
							   }
							     else
							    {
							     %>
								<td width="5%" align="left" class="apptclass" ><font size='1' nowrap><%=q_appt_ref_no%></td>
							    <%
						    	} 
							}%>

								   <% if(!q_appt_time.equals(""))
							         { %>
								   <td align='left' width='5%' class= '<%=classValue%>' nowrap><font size='1'><%=q_appt_time%></td>
							    <%} else {   %>
							   <td align='left' width='5%' class= '<%=classValue%>' nowrap><font size='1'><%=nbsp_disp%></td>
								<%}%>   
								   
								    <% if(!patientName.equals(""))
							         { %>
								   <td align='left' width='13%' class= '<%=classValue%>' nowrap><font size='1'><%=patientName%></td>
							         <%} else {   %>
							      <td align='left' width='13%' class= '<%=classValue%>' nowrap><font     size='1'><%=nbsp_disp%></td>
								 <%}%>   
								   <% if(!q_patient_id.equals(""))
							         { %>
								   <td align='left' width='10%' class= '<%=classValue%>' nowrap><font size='1'><%=q_patient_id%></td>
								   <%} else {   %>
							          <td align='left' width='10%' class= '<%=classValue%>' nowrap><font     size='1'><%=nbsp_disp%></td>
								   <%}%> 
								   
								   <% if(!national_id_no.equals(""))
							       { %>
								   <td align='left' width='13%' class= '<%=classValue%>' nowrap><font size='1'><%=national_id_no%></td>
															   
								   <%} else {   %>
							     <td align='left' width='13%' class= '<%=classValue%>' nowrap><font   size='1'><%=nbsp_disp%></td>
								 <%}%> 
								 <% if(!nationality.equals(""))
						      	 { %>
								   <td align='left' width='10%'class= '<%=classValue%>' nowrap><font size='1'><%=nationality%></td>
							       <%} else {   %>
							      <td align='left' width='10%' class= '<%=classValue%>' nowrap><font   size='1'><%=nbsp_disp%></td>
								 <%}%> 
								   
								 	<% if(!location.equals(""))
							        { %>
								    <td align='left' width='13%' class= '<%=classValue%>' nowrap><font size='1'><%=location%></td>
							          <%} else {   %>
							        <td align='left' width='13%' class= '<%=classValue%>' nowrap><font size='1'><%=nbsp_disp%></td>
							     	<%}%> 
								   <% if(!resource_desc.equals("") && !practitioner.equals(""))
							        { %>
								   <td align='left' width='17%' class= '<%=classValue%>' nowrap><font size='1'><%=resource_desc%>/<%=practitioner%></td>		   
							        <%} else {   %>
							        <td align='left' width='17%' class= '<%=classValue%>' nowrap><font size='1'><%=nbsp_disp%></td>
							     	<%}%>
                                    <td align='left' width='17%' class= '<%=classValue%>' nowrap><font    size='1'><%=referral_id_dis%></td>
									<!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->
									<!--Modified by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6-->
									<%if(isPractoApptApplYN && isSlotStartMidEndAppl){%>
                                    <td align='left' width='17%' class= '<%=classValue%>' nowrap><font    size='1'><%if(isPractoApptYn.equals("Y")){%><fmt:message key="eOA.BruHealth.label" bundle="${oa_labels}"/><%}else{%><fmt:message key="Common.EM.label" bundle="${common_labels}"/><%}%>&nbsp;</td>
									<%}else if(isPractoApptApplYN && !isSlotStartMidEndAppl){%>
                                    <td align='left' width='17%' class= '<%=classValue%>' nowrap><font    size='1'><%if(isPractoApptYn.equals("Y")){%><fmt:message key="eOA.Practo.label" bundle="${oa_labels}"/><%}else{%><fmt:message key="Common.EM.label" bundle="${common_labels}"/><%}%>&nbsp;</td>
									<%}%>
									<!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->
							         </tr>    
						
						 			   
								   <%							   
						}

						%>
									
					</table> 		
					<%
					//}	
	
				/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
				if(isImproveReferralProcessAppl && !selected_loc_code.equals("")){
					while( rsRef.next()) 
					{
						if(ref_count==0){
						%>

						<table border='1' cellpadding='0' cellspacing='0' align='center' width='100%' id='ref_button_list' style='display:none'>

						<th align='center'  width='5%' nowrap><div class='myClass'>&nbsp;</div></th>

						<th align='center'  width='20%' nowrap><div class='myClass'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></div></th>

						<th align='center'  width='20%' nowrap><div class='myClass'><fmt:message key="Common.CreatedOn.label" bundle="${common_labels}"/></div></th>

						<th align='center'  width='20%' nowrap><div class='myClass'><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></div></th>

						<th align='center'  width='35%' nowrap><div class='myClass'><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></div></th>      

						<%
						ref_count++;
						}

						if (row_even_or_odd == 1)
						{
						row_even_or_odd = 2;
						classValue = "QRYODD";
						}
						else
						{
						classValue = "QRYEVEN";                 
						row_even_or_odd = 1;                    
						}

						q_referral_id = (rsRef.getString("referral_id") == null)?"":rsRef.getString("referral_id");

						q_added_date = (rsRef.getString("added_date") == null)?"":rsRef.getString("added_date");

						q_preferred_date = (rsRef.getString("preferred_date") == null)?"":rsRef.getString("preferred_date");

						from_referral.setLength(0);

						if(rsRef.getString("from_source_desc")!=null && rsRef.getString("from_source_desc") !="")
						from_referral.append(rsRef.getString("from_source_desc")).append("<br>");

						if(rsRef.getString("from_locn_desc")!=null && rsRef.getString("from_locn_desc") !="")
						from_referral.append(rsRef.getString("from_locn_desc")).append("<br>"); 

						if(rsRef.getString("from_pract_name")!=null && rsRef.getString("from_pract_name") !="")
						from_referral.append(rsRef.getString("from_pract_name"));

						if(from_referral.toString().equals("")) from_referral.append("&nbsp;");

						q_from_referral = from_referral.toString();

						q_referral_priority = (rsRef.getString("referral_priority") == null)?"":rsRef.getString("referral_priority");
						
						if(!q_referral_priority.equalsIgnoreCase(q_prev_referral_priority)) {
						out.println("<tr>");
						out.println("<td colspan = 10 align = 'left' class='CAGROUPHEADING' nowrap><font size='1'>");

						if((q_referral_priority.equalsIgnoreCase("E"))) 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
						if((q_referral_priority.equalsIgnoreCase("L")))
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels"));
						if((q_referral_priority.equalsIgnoreCase("U"))) 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels"));
						
						out.println("</td></tr>");
						}
						q_prev_referral_priority = q_referral_priority;
						%>

						<tr>

						<td align='left' style = 'vertical-align:text-top' width='5%' class= '<%=classValue%>' nowrap><font size='1'><a href ="javascript:showRefDtls('<%=q_referral_id%>')">+</a></td>
						<td align='left' style = 'vertical-align:text-top' width='20%' class= '<%=classValue%>' nowrap><font size='1'><a href="javascript:populateLocationValues('<%=q_referral_id%>');"><%=q_referral_id%></a></td>
						<td align='left' style = 'vertical-align:text-top' width='20%' class= '<%=classValue%>' nowrap><font size='1'><%=q_added_date%></td>
						<td align='left' style = 'vertical-align:text-top' width='20%' class= '<%=classValue%>' nowrap><font size='1'><%=q_preferred_date%>&nbsp;</td>
						<td align='left' style = 'vertical-align:text-top' width='35%' class= '<%=classValue%>' nowrap><font size='1'><%=q_from_referral%></td>

						</tr>

						<%							   
					}	%>
						</table>
				<%}
				/*End MMS-DM-CRF-0187*/
					 
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sql1.setLength(0);

					if(rsRef != null) rsRef.close();
					if(pstmtRef != null) pstmtRef.close();
					sqlRef.setLength(0);
					from_referral.setLength(0);
       
				}

%>
		<input type='hidden' name='register_visit_walkin' id='register_visit_walkin' value='<%=register_visit_walkin%>'>
		<input type='hidden' name='register_visit_referral' id='register_visit_referral' value='<%=register_visit_referral%>'>
		<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='<%=bl_interface_yn%>'>
		<input type='hidden' name='build_episode_rule' id='build_episode_rule' value='<%=build_episode_rule%>'>
		<input type='hidden' name='or_install_yn' id='or_install_yn' value='<%=or_install_yn%>'>
		<input type='hidden' name='oa_install_yn' id='oa_install_yn' value='<%=oa_install_yn%>'>
		<!-- <input type='hidden' name='reason' id='reason' value='<%=reason%>'>
		<input type='hidden' name='contact_reason_code' id='contact_reason_code' value='<%=contact_reason_code%>'> -->
		
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		<input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='<%=emer_regn_allow_yn%>'>
		
		<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>
		<input type='hidden' name='practitioner' id='practitioner' value='<%=practitioner%>'>
		<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'><!-- Added for the CRF Bru-HIMS-CRF-198 -->
		<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->
		<input type='hidden' name='appt_count' id='appt_count' value='<%=count%>'>
		<input type='hidden' name='ref_count' id='ref_count' value='<%=ref_count%>'>
		
		<%
			}catch(Exception e) { out.println(e.toString());}
finally 
{
	try{
	if(rs != null)   rs.close();
	if(pstmt != null) pstmt.close();

	if(rsRef != null) rsRef.close();
	if(pstmtRef != null) pstmtRef.close();

	}catch(Exception ee){}


	if(con != null) ConnectionManager.returnConnection(con,request);
}
			%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}	
%>
    </body>
        </form>
</html>

