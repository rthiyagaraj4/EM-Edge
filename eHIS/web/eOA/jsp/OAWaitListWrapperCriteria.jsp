<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %> 
<html>  
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js' ></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language='javascript' src='../../eCommon/js/CommonLookup.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<script>
			function loadWaitListCriteria(){
				document.forms[0].b_loc_val.disabled=true;
				document.forms[0].b_loc_search.disabled=true;
				document.forms[0].practitioner_name.disabled=true;
				document.forms[0].search_resource.disabled=true;
				if(document.forms[0].rd_appt_yn.value =="Y"){
					document.forms[0].location_type.value="E";
					document.forms[0].resource_type.selectedIndex=2;
					document.forms[0].location_type.disabled=true;
					document.forms[0].resource_type.disabled=true;
					document.forms[0].location.value=document.forms[0].clinnic_code.value;
					document.forms[0].b_loc_val.value=document.forms[0].clinic_name_sec.value;
					document.forms[0].practitioner_name.disabled=false;
					document.forms[0].search_resource.disabled=false;
				}
				var specialty_code 	= document.waitlist_criteria.specialty_code.value;
				var wtListControl 	= document.waitlist_criteria.wtListControl.value;
				//url='../../eOA/jsp/WaitListMgmtQueryResult.jsp?specCode='+specialty_code+'&wtListControl='+wtListControl+"&cliniccode="+document.forms[0].clinnic_code.value+"&rd_appt_yn="+document.forms[0].rd_appt_yn.value;
				url='../../eOA/jsp/WaitListMgmtQueryResult.jsp?specCode='+specialty_code+'&wtListControl='+wtListControl+"&rd_appt_yn="+document.forms[0].rd_appt_yn.value;
				parent.frames[2].location.href=url;
			}
			function dispWaitListResult(){
				var specialty_code 	= document.waitlist_criteria.specialty_code.value;
				var clinic_type 	= document.waitlist_criteria.location_type.value;
				var cliniccode		= document.waitlist_criteria.location.value;
				var resource_type	= document.waitlist_criteria.resource_type.value;
				var practitioner	= document.waitlist_criteria.practitioner.value;
				var wtListControl 	= document.waitlist_criteria.wtListControl.value;
				url='../../eOA/jsp/WaitListMgmtQueryResult.jsp?specCode='+specialty_code+'&clinic_type='+clinic_type+'&cliniccode='+cliniccode+"&res_type="+resource_type+'&practitioner='+practitioner+'&wtListControl='+wtListControl+"&practitioner_id="+document.waitlist_criteria.practitioner_id.value+"&appt_date="+document.waitlist_criteria.appt_date.value+"&no_of_slots="+document.waitlist_criteria.no_of_slots.value;
				parent.frames[2].location.href=url;
			}
			function enable_dsiable_res(obj){
				//var specialty=document.forms[0].speciality.value;
				//document.getElementById("specialty_code1").value = specialty;
				var res_value=obj.value;
				document.forms[0].practitioner_name.value="";
				document.forms[0].practitioner.value="";
				if(res_value=="" ){
					document.forms[0].practitioner_name.disabled=true;
					document.forms[0].search_resource.disabled=true;
				}else{
					document.forms[0].resourceType1.value=res_value;
					/*document.forms[0].resourceType_1.value=res_value;
					if(document.forms[0].clinic.value==""){
						document.forms[0].location_code1.value="Y$";
					}*/
					document.forms[0].practitioner_name.disabled=false;
					document.forms[0].search_resource.disabled=false;
				}
			}
			function locationTypeChange(obj){
				document.forms[0].location.value='';
				document.forms[0].b_loc_val.value='';
				if(obj.value==''){
					document.forms[0].b_loc_val.disabled=true;
					document.forms[0].b_loc_search.disabled=true;
				}else{
					document.forms[0].b_loc_val.disabled=false;
					document.forms[0].b_loc_search.disabled=false;
				}
				/*document.forms[0].locationType.selectedIndex=0;
				document.forms[0].resourceType.value='';
				document.forms[0].practitioner_name.value='';
				document.forms[0].b_pract.value='';
				document.forms[0].practitioner_name.disabled=true;
				document.forms[0].search_pract.disabled=true;
				document.forms[0].resourceType.disabled=true;
				document.getElementById("pract_type1").innerHTML="";
				if (obj.value=='')
				{
				Obj=document.forms[0].locationType;
				while(Obj.options.length >0 ) Obj.remove(Obj.options[0]);
				opt=document.createElement('OPTION');
				opt.value='';
				opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
				Obj.add(opt);
				}
				parent.frames[2].location.href='../../eCommon/html/blank.html';*/
			}
			
			async function location_search_lookup(){	
				var location_val=document.forms[0].b_loc_val.value;
				var locn_type=document.forms[0].location_type.value;
				var care_locn_ind=document.forms[0].location_type.value;
				var specialty_code=document.forms[0].specialty_code.value;
				//var dialogTop = "60" ;
				//var dialogHeight= "37" ;
				//var dialogWidth	= "60" ;
				var dialogTop = "10px" ;
				var dialogHeight= "400px" ;
				var dialogWidth	= "700px" ;
				var status = "no";
				var arguments	= "" ;
				var tit="locn_Srch";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				var retVal="";
				retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&speciality_code="+specialty_code+"&function_id=WAIT_LIST",arguments,features);
				if(retVal!=null){	
					var rvalues=retVal.split("~");
					var clinic_code=rvalues[0];
					var desc=rvalues[1];
					var open_to_all_pract_yn=rvalues[2];
					var clinic_type=rvalues[3];
					var ident_at_checkin=rvalues[4];
					var fi_visit_type_appl_yn=rvalues[5];
					var alcn_criteria=rvalues[6];
					var STime=rvalues[7];
					var ETime=rvalues[8];
					var dur=rvalues[9];
					document.forms[0].b_loc_val.value=desc;
					document.forms[0].location.value=clinic_code;
					document.forms[0].open_to_all_pract_yn.value=open_to_all_pract_yn;
				}else{	
					document.forms[0].b_loc_val.value="";
					document.forms[0].location.value="";
					/*document.forms[0].resourceType.value="";
					document.getElementById("resourceType").disabled=true;
					document.forms[0].practitioner_name.value="";
					document.forms[0].practitioner_name.disabled=true;
					document.forms[0].search_pract.disabled=true;
					parent.frames[1].document.forms[0].resourceType.value="";
					parent.frames[1].document.getElementById("pract_type1").innerHTML="";
					var location_val=document.forms[0].b_loc_val.value;*/
				}
			}
			function location_search(obj){
				if(obj.value==null || obj.value==""){
					document.forms[0].b_loc_val.value="";
					document.forms[0].location.value="";
					document.forms[0].open_to_all_pract_yn.value="";
					/*document.forms[0].resourceType.value="";
					document.forms[0].locationType.value="";
					document.getElementById("resourceType").disabled=true;
					document.forms[0].practitioner_name.value="";
					document.forms[0].practitioner_name.disabled=true;
					document.forms[0].search_pract.disabled=true;
					parent.frames[1].document.forms[0].resourceType.value="";
					parent.frames[1].document.getElementById("pract_type1").innerHTML="";
					var location_val=document.forms[0].b_loc_val.value;*/
				}else{
					location_search_lookup()
				}
			}			
		</script>
	</head>
	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
		String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));	
		String clinnic_code		= checkForNull(request.getParameter("clinnic_code"));
		String clinic_name_sec		= checkForNull(request.getParameter("clinic_name_sec"));
		String wtListControl	= checkForNull(request.getParameter("wtListControl"),"V");
		String rd_appt_yn	= checkForNull(request.getParameter("rd_appt_yn"),"N");
		String practitioner_id		= checkForNull(request.getParameter("practitioner_id"));
		String appt_date		= checkForNull(request.getParameter("appt_date"));
		String no_of_slots		= checkForNull(request.getParameter("no_of_slots"));
		String res_type		= checkForNull(request.getParameter("res_type"));
		String clinic_type		= checkForNull(request.getParameter("clinic_type"));
		String speciality_code 	= "";
		String speciality_desc 	= "";
		try{
			conn=ConnectionManager.getConnection(request);
			String spltySQL = "select speciality_code,Long_desc speciality_desc from am_speciality_lang_vw where speciality_code =(select speciality_code from op_clinic where clinic_code=? and facility_id=?) and language_id=?";
			pstmt=conn.prepareStatement(spltySQL);
			pstmt.setString(1,clinnic_code);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,localeName);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				speciality_code = checkForNull(rs.getString("speciality_code"));
				speciality_desc = checkForNull(rs.getString("speciality_desc"));
			}
			
			String slot_appt_ctrl ="";
			String visit_limit_rule="";
			String alcn_criteria ="";
			String override_no_of_slots_yn="";
			String capture_fin_dtls_yn="";
			String noshow_ctrl_by_splty_or_clinic="";
			String min_ela_per_resc_noshow_in_day="";
			String contact_num_reqd_yn="";
			String no_of_noshow_appts_for_alert="";
			String per_chk_for_no_show_alert="";
			String rule_appl_yn="";
			String oper_stn_id ="";
			String create_wait_list_yn ="";
			String install_yn_val ="";
			String book_appt_yn ="N";
			if(wtListControl !=null && wtListControl.equals("B")){
				if(rs !=null)rs.close();
				pstmt=conn.prepareStatement("select SLOT_APPT_CTRL,VISIT_LIMIT_RULE,ALCN_CRITERIA,OVERRIDE_NO_OF_SLOTS_YN,CAPTURE_FIN_DTLS_YN,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT,PER_CHK_FOR_NO_SHOW_ALERT,RULE_APPL_YN from oa_param where module_id='OA'");
				rs 	= pstmt.executeQuery();
				if(rs !=null && rs.next()){
					slot_appt_ctrl =rs.getString("SLOT_APPT_CTRL")==null?"":rs.getString("SLOT_APPT_CTRL");
					visit_limit_rule =rs.getString("VISIT_LIMIT_RULE")==null?"":rs.getString("VISIT_LIMIT_RULE");
					alcn_criteria =rs.getString("ALCN_CRITERIA")==null?"":rs.getString("ALCN_CRITERIA");
					override_no_of_slots_yn =rs.getString("OVERRIDE_NO_OF_SLOTS_YN")==null?"":rs.getString("OVERRIDE_NO_OF_SLOTS_YN");
					capture_fin_dtls_yn =rs.getString("CAPTURE_FIN_DTLS_YN")==null?"":rs.getString("CAPTURE_FIN_DTLS_YN");
					noshow_ctrl_by_splty_or_clinic =rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC")==null?"":rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC");
					min_ela_per_resc_noshow_in_day =rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY")==null?"":rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY");
					contact_num_reqd_yn =rs.getString("CONTACT_NUM_REQD_YN")==null?"":rs.getString("CONTACT_NUM_REQD_YN");
					no_of_noshow_appts_for_alert =rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT")==null?"":rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
					per_chk_for_no_show_alert =rs.getString("PER_CHK_FOR_NO_SHOW_ALERT")==null?"":rs.getString("PER_CHK_FOR_NO_SHOW_ALERT");
					rule_appl_yn=rs.getString("RULE_APPL_YN")==null?"":rs.getString("RULE_APPL_YN");
				}
				if(rs !=null)rs.close();
				pstmt=conn.prepareStatement("SELECT (SELECT operational_yn  FROM sm_modules_facility  WHERE facility_id = ? AND module_id = 'OR') or_oper_yn,NVL (create_wait_list_yn, 'N') creat_wt_lst_yn, a.oper_stn_id,NVL (canc_appt_yn, 'N') canc_appt_yn,NVL (tfr_appt_yn, 'N') tfr_appt_yn,NVL (book_appt_yn, 'N') book_appt_yn,TO_CHAR (SYSDATE, 'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id = ?  AND a.facility_id = b.facility_id   AND a.oper_stn_id = b.oper_stn_id   AND b.appl_user_id = ?   AND TRUNC (SYSDATE) BETWEEN b.eff_date_from  AND NVL (b.eff_date_to, TRUNC (SYSDATE))");
				pstmt.setString(1,facilityid);
				pstmt.setString(2,facilityid);
				pstmt.setString(3,globaluser);
				rs 	= pstmt.executeQuery();
				if(rs !=null && rs.next()){
					oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
					create_wait_list_yn = rs.getString("creat_wt_lst_yn")==null?"":rs.getString("creat_wt_lst_yn");
					install_yn_val = rs.getString("or_oper_yn")==null?"":rs.getString("or_oper_yn");
					book_appt_yn = rs.getString("book_appt_yn")==null?"N":rs.getString("book_appt_yn");
				}
			}
	%>
	<body onLoad="loadWaitListCriteria()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='waitlist_criteria' id='waitlist_criteria'>
			<br>
			<table  border='0' cellpadding='0' cellspacing='0' width='60%' align='center'>
				<tr>
					<td class='label' colspan='3'><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></td>
					<td nowrap class=label ><b><%=speciality_desc%></b></td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name='location_type' id='location_type' onChange='locationTypeChange(this)' tabindex=2><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
						//String sql_locn="Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N') and language_id = '"+locale+"' order by 2";
						String sql_locn="Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') and language_id = ? order by 2";
						String locationType="";
						String shortDesc="";
						if(rs !=null)rs.close();
						pstmt=conn.prepareStatement(sql_locn);
						pstmt.setString(1,localeName);
						rs 	= pstmt.executeQuery();
						if (rs!=null){
							while(rs.next()){	
								locationType= rs.getString("care_locn_type_ind");
								shortDesc= rs.getString("Short_Desc");
								out.println("<option value='"+locationType+"'>"+shortDesc+"</option>");
							}
						}
						%>
					</select></td>
					<td class='label' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="location_search(this)"><input type="hidden" name="location" id="location" value=""><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="location_search_lookup()" class='button'>
					</td>
				</tr>
				<tr id='resource_part'>
					<jsp:include page="OAResourcelookupframe.jsp" >
						<jsp:param name="flush" value="true" />
						<jsp:param name ="from_page" value= "vw_book_appt_wtlist" />	
					</jsp:include>
				</tr>
				<tr>
					<td class='fields' colspan='4'>&nbsp;</td>
				</tr>
				<tr>
					<td class='fields' colspan='2'>&nbsp;</td>
					<td class='fields' >&nbsp;</td><td class='button' align='right'><input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='dispWaitListResult();' tabindex=12><input type=button name='Clear' id='Clear' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='const dialogTag = parent.parent.document.getElementById("dialog_tag"); dialogTag.close();' tabindex=13></td>
				</tr>
					<input type='hidden' name='specialty_code' id='specialty_code' value='<%=speciality_code%>'>
					<input type='hidden' name='wtListControl' id='wtListControl' value='<%=wtListControl%>'>
					<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
					<input type='hidden' name='clinnic_code' id='clinnic_code' value='<%=clinnic_code%>'>
					<input type='hidden' name='appt_date' id='appt_date' value='<%=appt_date%>'>
					<input type='hidden' name='no_of_slots' id='no_of_slots' value='<%=no_of_slots%>'>
					<input type='hidden' name='res_type' id='res_type' value='<%=res_type%>'>
					<input type='hidden' name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
					<input type='hidden' name='valfrmCrt' id='valfrmCrt' value='checkdata'>					
					<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value="<%=slot_appt_ctrl%>">
					<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value="<%=visit_limit_rule%>">
					<input type='hidden' name='alcn_criteria' id='alcn_criteria' value="<%=alcn_criteria%>">
					<input type='hidden' name='override_no_of_slots_yn' id='override_no_of_slots_yn' value="<%=override_no_of_slots_yn%>">
					<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value="<%=capture_fin_dtls_yn%>">
					<input type='hidden' name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value="<%=noshow_ctrl_by_splty_or_clinic%>">
					<input type='hidden' name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value="<%=min_ela_per_resc_noshow_in_day%>">
					<input type='hidden' name='contact_num_reqd_yn' id='contact_num_reqd_yn' value="<%=contact_num_reqd_yn%>">
					<input type='hidden' name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value="<%=no_of_noshow_appts_for_alert%>">
					<input type='hidden' name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value="<%=per_chk_for_no_show_alert%>">
					<input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value="<%=rule_appl_yn%>">
					<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>">
					<input type='hidden' name='create_wait_list_yn' id='create_wait_list_yn' value="<%=create_wait_list_yn%>">
					<input type='hidden' name='install_yn_val' id='install_yn_val' value="<%=install_yn_val%>">
					<input type='hidden' name='book_appt_yn' id='book_appt_yn' value="<%=book_appt_yn%>">
					<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value="">
					<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
					<input type='hidden' name='rd_appt_yn' id='rd_appt_yn' value="<%=rd_appt_yn%>">
					<input type='hidden' name='clinic_name_sec' id='clinic_name_sec' value="<%=clinic_name_sec%>">
		</form>
	</body>
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(conn,request);
	}%>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

