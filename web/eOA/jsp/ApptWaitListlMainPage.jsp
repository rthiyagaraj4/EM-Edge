<!DOCTYPE html>
<!--
	Developed by 	:	Suman
	Created on 	:	2/02/2005
	Module		:	OA
	Function	:	Create WaitList
-->

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eOA/js/ApptWaitList.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script>
function chk_val()
{
	if(document.forms[0].callingMode.value=="OP")
	{
		var ca_patient_id=document.forms[0].ca_patient_id.value;
	
		document.forms[0].patient_id.value=ca_patient_id;
		validatePatient(document.forms[0].patient_id);
		document.forms[0].patient_id.disabled=true;
		if(document.forms[0].speciality_op.value !="")
		{
			if (document.forms[0].walst_category)
			{
		document.forms[0].walst_category.disabled=false;
		document.forms[0].walst_cate_search.disabled=false;
			}
		}
		document.forms[0].search.disabled=true;
	}
}
</script>
</head>
<body onload='enable_category_gif();chk_val()' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<%
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;	
		PreparedStatement pstmt=null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");	
		String fromfacilityid="";
		String fromencounterid="";
		fromfacilityid=request.getParameter("from_facility_id");
	    fromencounterid=request.getParameter("from_encounter_id");

		String facilityId=(String) session.getValue("facility_id");
		String globaluser = (String)session.getValue("login_user");
		String fromPage=request.getParameter("from")==null?"":request.getParameter("from");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String rd_oa_integration_yn=request.getParameter("rd_oa_integration_yn")==null?"N":request.getParameter("rd_oa_integration_yn");
		String speciality_op=request.getParameter("speciality_op");
		if(speciality_op ==null) speciality_op="";
		String callingMode=request.getParameter("calling_mode");
		if(callingMode ==null)callingMode="";
		String ca_patient_id=request.getParameter("ca_patient_id");
		if(ca_patient_id ==null) ca_patient_id="";
		String care_locn_ind=request.getParameter("care_locn_ind");
		if(care_locn_ind ==null) care_locn_ind="";
		String resource_class=request.getParameter("resource_class");
		if(resource_class ==null) resource_class="";
		String i_clinic_code=request.getParameter("i_clinic_code");
		if(i_clinic_code ==null) i_clinic_code="";
		String op_practitioner=request.getParameter("op_practitioner");
		if(op_practitioner ==null )op_practitioner="";
		
		String dttm="",alcn_criteria_yn="",sql ="",speciality_code="",clinic_type="", install_yn="",clinic_short_desc="",waitlist_category_appl_yn="",invitation_list_appl_yn="", waitlist_category_reqd_yn="",restrict_wl_cat_agst_splty_yn="";
		String prd = "" ;
		String curr_month = "" ;
		String multi_speciality_yn = "N" ;
		String locale=(String)session.getAttribute("LOCALE");

		 
		alcn_criteria_yn = request.getParameter("alcn_criteria_yn");
		waitlist_category_appl_yn = request.getParameter("waitlist_category_appl_yn");
		invitation_list_appl_yn = request.getParameter("invitation_list_appl_yn");
		waitlist_category_reqd_yn = request.getParameter("waitlist_category_reqd_yn");
		restrict_wl_cat_agst_splty_yn = request.getParameter("restrict_wl_cat_agst_splty_yn");
		dttm = request.getParameter("dttm");
		prd = request.getParameter("prd");
		curr_month = request.getParameter("curr_month");
		install_yn = request.getParameter("install_yn");			
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		
try{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		
		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(conn, "OA","REMARKS_FOR_OTHERS");
		String others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
		 smartCardFunc = isSiteSpecificforBiometric(conn);//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	/*	
		if(fromPage.equals("ScheduleAppt"))
		{
			String sql_oper="SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			rs= stmt.executeQuery(sql_oper);
				if(rs !=null && rs.next())
				{
					oper_stn_id=rs.getString(1);
				}
		}
	*/
	if(rs !=null) rs.close();
%>
<form name='Bkappt_form' id='Bkappt_form' action='../../servlet/eOA.AppointmentWtListServlet' method='post' target='messageFrame'>

<table  cellpadding=0 cellspacing=0 border=0 width="100%" >	
		 
	<!-- <tr>	<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> -->
		
	<%if(rd_oa_integration_yn.equals("Y")){						 			
			String radChk = "";
	%>
				<td  class='label' ><fmt:message key="eOA.RadWaitList.label" bundle="${oa_labels}"/></td>
				<td class='fields'><input type='checkbox' name='rd_waitlist_yn' id='rd_waitlist_yn' value='<%%>'  onclick='rdWaitListAppl(this)'>
		<%}%>
		</td></tr>
	<tr>
			<td  class='label' width='19%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<%
			if(callingMode.equals("OP")) {
				 //sql = " Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status = 'E'  and Speciality_Code='"+speciality_op+"' and language_id='"+locale+"' order by 1";
				 sql = " Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status = 'E'  and Speciality_Code=? and language_id=? order by 1";
			}else{
				//sql="select short_desc, speciality_code from am_speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E') and language_id='"+locale+"' order by short_desc" ;
				sql="select short_desc, speciality_code from am_speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id=? and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=? and b.eff_status='E') and language_id=? order by short_desc" ;
			}
			//rs = stmt.executeQuery(sql);
			pstmt = conn.prepareStatement(sql);
			if(callingMode.equals("OP")) {
			pstmt.setString(1,speciality_op);
			pstmt.setString(2,locale);
			}else{
			pstmt.setString(1,facilityId);
			pstmt.setString(2,oper_stn_id);
			pstmt.setString(3,locale);
			}
			rs = pstmt.executeQuery();
	%>

			<td class='fields' width='34%'>
						
					<select name="speciality" id="speciality" onchange='enable_category(this);checkMultiSpecialityYN(this);' > 
					<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<%
				
					while(rs.next()){
					
						 speciality_code=rs.getString("Speciality_Code");
						out.println("<option value='" + rs.getString("Speciality_Code") + "' >" + rs.getString("Short_Desc")+"</option>");
					}
						if(rs !=null) rs.close();
					%>
					</select><img align=center src='../../eCommon/images/mandatory.gif'></img></td>
							<%if(waitlist_category_appl_yn.equals("Y")) {%>
			
			<td   class='label' width='24%' nowrap><fmt:message key="eOA.WaitlistCategory.label" bundle="${oa_labels}"/></td>

			<td   class='fields' width='25%' nowrap>
				<input type='text'  name='walst_category' id='walst_category' disabled value='' size='30' maxlength='30' onblur='open_lookup_one();'><input disabled type='button' class='BUTTON' name='walst_cate_search' id='walst_cate_search' value='?' onClick='open_lookup();'><img align=center src='../../eCommon/images/mandatory.gif' id='wait_lst_cat' style='visibility:hidden'></img></td>
						<%}else{%>
			<td   class='label' width='25%' nowrap>&nbsp;</td>
			<td   class='label' width='25%' nowrap>&nbsp;</td>
						<%}%>
	</tr>
	<tr>
			
<%	 
	if(install_yn.equals("Y")){ %>
				<td class='label' nowrap ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				<td  class='fields'>
					<input type=text name='or_catalogue_desc' id='or_catalogue_desc' size=30 onblur="clear_vals()"><input type='button' class='button' value='?'  name='search_or' id='search_or' onClick="callORSearch();"   tabindex=0>
					<input type="hidden" name="or_catalogue_code" id="or_catalogue_code"><img src='../../eCommon/images/mandatory.gif' align='center' id='ordCatImg' style="visibility:hidden"></img></td>
	<%} else {%>
				<td class='fields' colspan='2'></td>
						<%}%>
				<td  class='label'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				<td>
						<select name="priority" id="priority"> 
						<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
						<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="S"><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>			
						</select><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr> 
			<%if(callingMode.equals("OP"))
			{
				//sql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N') and care_locn_type_ind ='"+care_locn_ind+"' and  language_id='"+locale+"' order by 2";
				sql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N') and care_locn_type_ind =? and  language_id=? order by 2";

			}else
			{
				//sql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N')  and  language_id='"+locale+"' order by 2";
				sql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N')  and  language_id=? order by 2";
			}
			//rs = stmt.executeQuery(sql);
			pstmt = conn.prepareStatement(sql);
			if(callingMode.equals("OP")) {
			pstmt.setString(1,care_locn_ind);
			pstmt.setString(2,locale);
			}else{
			pstmt.setString(1,locale);
			}
			rs = pstmt.executeQuery();
			%>
				
	<tr>
			<td class='label'  ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class='fields' >
					<SELECT name='locationType' id='locationType' onChange='populateLocations(this);' >
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%String locn_type="";
					  String short_desc="";
						while(rs.next() && rs !=null){
							locn_type=rs.getString("care_locn_type_ind");
							short_desc=rs.getString("short_desc");
							out.println("<option value='"+locn_type+"'>"+short_desc);
						}
							if(rs !=null) rs.close();%>

					</SELECT><img  src="../../eCommon/images/mandatory.gif" align='center'></img> 
			<td class='label'  ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='fields' >
			<% 
					
					if(rs !=null) rs.close();	
		
			if(callingMode.equals("OP")) {
			//	sql="select a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.language_id='"+locale+"' and  a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+globaluser+"' and b.create_wait_list_yn='Y' and a.eff_status = 'E' and a.clinic_type=b.locn_type and a.speciality_code = '"+speciality_code+"'  and a.clinic_code = '"+i_clinic_code+"'  order by a.long_desc";			 
				sql="select a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id=? and a.language_id=? and  a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=? and b.appl_user_id=? and b.create_wait_list_yn='Y' and a.eff_status = 'E' and a.clinic_type=b.locn_type and a.speciality_code = ? and a.clinic_code = ? order by a.long_desc";			 
				//rs = stmt.executeQuery(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,locale);
				pstmt.setString(3,oper_stn_id);
				pstmt.setString(4,globaluser);
				pstmt.setString(5,speciality_code);
				pstmt.setString(6,i_clinic_code);
				rs = pstmt.executeQuery();
			%>
			
			<%
				if(rs.next() && rs !=null){
					clinic_type=rs.getString("clinic_code");
					clinic_short_desc=rs.getString("long_desc");						 
				}
				if(rs !=null) rs.close();
		 
			%>
			<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='<%=clinic_short_desc%>' onblur="ena_loc_lookup(this);"><input type="hidden" name="location" id="location" ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'>
			<%			
			} else {%>
			<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type="hidden" name="location" id="location" ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'><img align=center src='../../eCommon/images/mandatory.gif' id='locnManImg' style='visibility:hidden'></img>
			<%}%>
			</td>

	</tr>
	<tr id='resource_part'><jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name ="from_page" value= "create_wl" />
	<jsp:param name ="pract_value" value= "" />
	</jsp:include>
	<td  class='label' ><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type="text"  name="rec_date" id="rec_date" maxlength="10" size="10"   value='' onkeypress="return Valid_DT(event)" onblur="validate_date_from(this)"><img  style="cursor:pointer" name= "dob1" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].rec_date.select();return showCalendar('rec_date',null);" ></td></tr>
	<tr> 

		<!-- 	<TD class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<TD class="fields" nowrap>
						<input type="hidden" name=resourceType value="">
						<input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="callPractSearch(this,practitioner_name,'<%=locale%>');"  >
						<font  id='pract_type1'  nowrap> </font>
						</TD>

						<td class='fields'>
			<input type="text"  name="rec_date" id="rec_date" maxlength="10" size="10"   value='' onkeypress="return Valid_DT(event)" onblur="validate_date_from(this)"><img  style="cursor:pointer" name= "dob1" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].rec_date.select();return showCalendar('rec_date',null);" ></td>-->

	</tr> 
	<tr>
			<TD class="label"><fmt:message key="eOA.ReasonForCreateWaitlist.label" bundle="${oa_labels}"/></td>
			<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<TD class="fields" nowrap><input type=text name='reason_create' id='reason_create' size=20 onblur="open_create_waitlist_reason();displayRemarksForOtherReason(reason_code);"><input type='button' class='button' value='?' name='search_reason_create' id='search_reason_create' onClick="open_create_waitlist_reason();displayRemarksForOtherReason(reason_code);"   tabindex=0>
				<input type="hidden" name="reason_code" id="reason_code"><img align=center src='../../eCommon/images/mandatory.gif' id='reason_code' ></img></td>
			
			<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<td class=label id='remarks_labl' style='display:none'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" id='remarks_fld' style='display:none'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
			<!--End ML-MMOH-CRF-1114-->
			
	</tr>
	<tr>
<td  class=label width="38%"  ><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
<td width="3%" ><input type='textbox' name='wait_list_ref_no' id='wait_list_ref_no' size='15' maxlength='12' onKeyPress='return(ChkNumberInput1(this,event,0));'  ></td>

		<%if(invitation_list_appl_yn.equals("Y")) {%>
			
		<td class='label'>	
		<td  class='fields'>
			<input type='hidden' name='alcn_criteria_yn ' id='alcn_criteria_yn ' value='<%=alcn_criteria_yn%>'>
			<input type='Button' class='button' name='invitation_list' id='invitation_list' value='<fmt:message key="Common.invitationlist.label" bundle="${common_labels}"/>' onclick='invoke_invitation();'></td>
		
		<%}else {%>
		
		<td class=LABEL colspan=4>&nbsp;</td>
		
		<%}%>
	
	</tr>	
			
	
</table>
			
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >

			<td class='COLUMNHEADER' colspan=4><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<tr>
			<td >							
			<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
			</td>
			<td align='left' id='blink_text' nowrap >
			<font id='othApp'>&nbsp;</font>
			</td>
			</tr>
		<input type='hidden' name='callingMode' id='callingMode' value='<%=callingMode%>'>
		<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>'>
		<input type='hidden' name='speciality_op' id='speciality_op' value='<%=speciality_code%>'>
		<input type='hidden' name='care_locn_ind' id='care_locn_ind' value='<%=care_locn_ind%>'>
		<input type='hidden' name='clinic_type' id='clinic_type' value='<%=i_clinic_code%>'>
		<input type='hidden' name='waitlist_category_reqd_yn' id='waitlist_category_reqd_yn' value='<%=waitlist_category_reqd_yn%>'>
		<input type='hidden' name='walst_category_code' id='walst_category_code' value=''>
		<input type='hidden' name='waitlist_category_appl_yn' id='waitlist_category_appl_yn' value='<%=waitlist_category_appl_yn%>'>
		<input type='hidden' name='restrict_wl_cat_agst_splty_yn' id='restrict_wl_cat_agst_splty_yn' value='<%=restrict_wl_cat_agst_splty_yn%>'>
		<input type='hidden' name='invitation_list_appl_yn' id='invitation_list_appl_yn' value='<%=invitation_list_appl_yn%>'>
		<input type='hidden' name='style' id='style' value='<%=sStyle%>'>
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		<input type='hidden' name='install_yn' id='install_yn' value='<%=install_yn%>'>
		<input type='hidden' name='alcn_criteria_yn' id='alcn_criteria_yn' value='<%=alcn_criteria_yn%>'>
		<input type="hidden" name="hddDTTM" id="hddDTTM" value="<%=dttm%>">
		<input type="hidden" name="hddDate" id="hddDate" value="">
		<input type="hidden" name="hddBDate" id="hddBDate" value="">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="Operation" id="Operation" value="insert">
		<input type='hidden' name='from' id='from' value='<%=fromPage%>'>
		<input type='hidden' name='calling_mode' id='calling_mode' value='<%=callingMode%>'>
		<input type=hidden name='cnt' id='cnt' value=''>		 
		<input type=hidden name='prd' id='prd' value='<%=prd%>'>
		<input type=hidden name='dttm' id='dttm' value='<%=dttm%>'>
		<input type=hidden name='curr_month' id='curr_month' value='<%=curr_month%>'>

<input type='hidden' name='fromfacilityid' id='fromfacilityid' value='<%=fromfacilityid%>'>
<input type='hidden' name='fromencounterid' id='fromencounterid' value='<%=fromencounterid%>'>
<input type='hidden' name='rd_oa_integration_yn' id='rd_oa_integration_yn' value='<%=rd_oa_integration_yn%>'>
<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'>

		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>
		<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023-->
		<input type='hidden' name='smartCardFunc' id='smartCardFunc' value='<%=smartCardFunc%>'>
		

 </table>
	
	<%		
if(!speciality_code.equals("") && !locn_type.equals("") )
	{
%>	
	<script>

	if(document.forms[0].callingMode.value=="OP")
	{
		document.forms[0].speciality.value='<%=speciality_code%>';
		document.forms[0].speciality.disabled=true;
		document.forms[0].locationType.value='<%=locn_type%>';
		document.forms[0].locationType.disabled=true;
		document.forms[0].location.value='<%=clinic_type%>';		 
		if(document.forms[0].rd_oa_integration_yn.value=="Y")
			document.forms[0].rd_waitlist_yn.disabled=true;
	}
	
	</script>	
<% }
	if(rs !=null) rs.close();
	if(stmt!=null)	stmt.close();
	if(stmt!=null)	stmt.close();
	if(stmt!=null)	stmt.close();


}catch(Exception e){
	//out.print(e.toString());
	e.printStackTrace();
}finally{
if(stmt!=null)	stmt.close();
	ConnectionManager.returnConnection(conn,request);
		

}
%>
</form>
</body>
</html>
<%!
public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 		}
	 	}
	 	return function_name;
}
%>

