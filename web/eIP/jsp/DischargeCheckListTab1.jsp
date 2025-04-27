<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
Connection con				= null;
PreparedStatement pstmt		= null;
ResultSet rset				= null;
ResultSet rset1  = null; 
PreparedStatement pstmt1	= null;
String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String facilityId			= (String)session.getAttribute("facility_id");
String call_function		= request.getParameter("call_function")==null?"":request.getParameter("call_function");
String disable_fld			= "";

if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
	disable_fld = "disabled";
}
 
String informed_to			= "";
String informed_name		= "";
String informed_date_time	= "";
String informed_date_time_display = "";
String mc_no				= "";
String event_status			= "";
String accession_num		= "";
String performed_by_name	= "";
String ca_install_yn		= "N";
StringBuffer SqlSB			= new StringBuffer();
String cert_num  = "";
String cert_from_date  = "";
String cert_to_date  = "";
String duration  = "";
String duration_dmy  = "";
Boolean isAutoPopDurationApplyn = false;  
String deli_cert_num="";

//Added by Ashwini on 02-Aug-2018 for ML-MMOH-CRF-1048
Boolean isRenameCertificateAppl = false;
//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
Boolean isItemOnLoanOthersDisableDateAppl = false;
Boolean isChareablelegendAppl = false;

try
{
	con		= ConnectionManager.getConnection(request);
	/*below added aganist ML-MMOH-CRF-1049 by Mano */
	 isAutoPopDurationApplyn = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AUTO_POPULATE_DURATION");
     Boolean isDeliveryCertAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","DELIVERY_CERFT_NUM"); //Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050

	 isRenameCertificateAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "RENAME_CERTIFICATE"); //Added by Ashwini on 02-Aug-2018 for ML-MMOH-CRF-1048
	 isItemOnLoanOthersDisableDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "ADD_ITEMS_AND_DISBL_DATE"); //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
	 isChareablelegendAppl          =eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "CHARRGEABLE_ITEM_LEGEND");//Added by Chandra for MMS-KH-CRF-0052.1

    SqlSB.append(" select to_char(a.informed_date_time,'dd/mm/rrrr hh24:mi')INFORMED_DATE_TIME, a.INFORMED_NAME, a.INFORMED_TO,(SELECT install_yn FROM sm_module WHERE module_id = 'CA')install_yn,(select mc_no from PR_SICK_LEAVE_REGISTER where facility_id = a.facility_id and encounter_id = a.encounter_id and patient_id = a.patient_id)mc_no ");
	SqlSB.append(" from ip_discharge_advice a where a.facility_id = ? and a.encounter_id = ? and a.patient_id = ? ");
	pstmt = con.prepareStatement(SqlSB.toString());
	pstmt.setString(1,facilityId);
	pstmt.setString(2,encounter_id);
	pstmt.setString(3,patient_id);
	rset = pstmt.executeQuery();
	while(rset.next())
	{
		informed_date_time	= checkForNull(rset.getString("INFORMED_DATE_TIME"));
		informed_name		= checkForNull(rset.getString("INFORMED_NAME"));
		informed_to			= checkForNull(rset.getString("INFORMED_TO"));
		ca_install_yn		= rset.getString("install_yn");
			if(ca_install_yn  == null) ca_install_yn ="N";
		mc_no				= checkForNull(rset.getString("mc_no"));
		
	}
	
	if(informed_date_time == "" || informed_date_time.equals("null"))
		informed_date_time_display = "&nbsp;";
	else
		informed_date_time_display = DateUtils.convertDate(informed_date_time,"DMYHM","en",locale);

		
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();

	if(ca_install_yn.equals("Y"))
	{
		if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" SELECT a.accession_num, a.note_type, b.note_type_desc,a.service_code,A.EVENT_STATUS,DECODE(A.EVENT_STATUS,'1','In Progress','2','Transcribted','3','Unauthorized','4','Authorized','5','Modified','9','In Error') status,a.event_status ,	(CASE WHEN a.service_code IS NOT NULL THEN (am_get_desc.am_service(a.service_code,'"+locale+"',2)) END ) service_name , to_char(a.event_date_time,'dd/mm/rrrr hh24:mi') event_date_time ,a.performed_by_id ,d.practitioner_name performed_by_name ,a.authorized_by_id ,e.practitioner_name  authorized_by_name, a.note_content FROM ca_encntr_note a, ca_note_type b, am_practitioner d ,am_practitioner e WHERE b.note_type=a.note_type  and a.event_status in ('3','4','5','9') and  d.practitioner_id=a.performed_by_id and e.practitioner_id(+)=a.authorized_by_id and a.ENCOUNTER_ID = ? and a.FACILITY_ID=? and a.note_type in  (select note_type from ca_note_group ia, ca_note_type ib where ia.APPL_TASK_ID='DISCHARGE_SUMMARY' and ib.note_group_id=ia.note_group )" );

		pstmt = con.prepareStatement(SqlSB.toString());
		pstmt.setString(1,encounter_id); 
		pstmt.setString(2,facilityId);
		rset = pstmt.executeQuery();
		
		while(rset.next())
		{
			event_status = checkForNull(rset.getString("EVENT_STATUS"));
			accession_num = checkForNull(rset.getString("accession_num"));
			performed_by_name = checkForNull(rset.getString("performed_by_name"));
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}

	if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());

	//Added by Ashwini on 13-Feb-2016

	String sqlQuery1 = "Select CERTIFICATE_NUM, to_char(CERT_FROM_DATE,'dd/mm/yyyy')CERT_FROM_DATE, to_char(CERT_TO_DATE,'dd/mm/yyyy')CERT_TO_DATE, DURATION,DURATION_DMY,DELI_CERT_NUM from IP_DISCHARGE_CHECKLIST where facility_id = ? and encounter_id = ?";

		pstmt1 = con.prepareStatement(sqlQuery1.toString());
		pstmt1.setString(1,facilityId); 
		pstmt1.setString(2,encounter_id);
		rset1 = pstmt1.executeQuery();

		if(rset1.next())
		{
			 cert_num  = checkForNull(rset1.getString("CERTIFICATE_NUM"));
			 cert_from_date  = checkForNull(rset1.getString("CERT_FROM_DATE"));
			 cert_to_date  = checkForNull(rset1.getString("CERT_TO_DATE"));
			 duration  = checkForNull(rset1.getString("DURATION"));
			 duration_dmy  = checkForNull(rset1.getString("DURATION_DMY"));
			 deli_cert_num = checkForNull(rset1.getString("DELI_CERT_NUM"));
		}
		if(rset1!=null) rset1.close();
		if(pstmt1!=null) pstmt1.close();
%>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
</head>

<!--onLoad Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' <%if(isItemOnLoanOthersDisableDateAppl){%>onLoad='enableDisableDateField();'<%}%>>
<form name='DischargeCheckListTab1' id='DischargeCheckListTab1'>
<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></td>
	<td class='fileds' width='25%'><input type='checkbox' name='dis_medication' id='dis_medication' onclick="setValue_tab1(this);" <%=disable_fld%>></td>
	<td class='label' width='25%'></td>
	<td class='label' width='25%'></td>
	
</tr>
<%
	    if(isChareablelegendAppl){//Added if condition by chandra for MMS-KH-CRF-0052.1
%>
<tr>
	<td class='label' ><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='checkbox' name='chargeable_item_yn' id='chargeable_item_yn' onclick="setValue_tab1(this);" <%=disable_fld%>></td>
	</td>
	<td class='label' ></td>
	<td class='label' ></td>	
</tr>
<%
}else{
%>
<tr>
	<td class='label' ><fmt:message key="eIP.ExistingMedication.label" bundle="${ip_labels}"/></td>
	<td class='label' ></td>
	<td class='label' ></td>
	<td class='label' ></td>
	<input type='hidden' name='chargeable_item_yn' id='chargeable_item_yn' value=""><!-- Added for MMS-KH-CRF-0052.1 -->
	
</tr>

<% } %>
<tr>
	<td class='label' ><fmt:message key="eIP.DiscSummaryPrepared.label" bundle="${ip_labels}"/></td>
	<td class='fileds' >
	<% if(event_status.equals("4")||event_status.equals("5")){%>
	<input type='checkbox' name='dis_summ_prep' id='dis_summ_prep' value='Y' checked disabled>
	<% }else{%>
	<input type='checkbox' name='dis_summ_prep' id='dis_summ_prep' value='N' disabled>
	<% }%>
	</td>
	<td class='label' ><fmt:message key="Common.PreparedBy.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='dis_summ_prep_by' id='dis_summ_prep_by' size='20' maxlength='30' value='<%=performed_by_name%>' readonly></td>
</tr>
<tr>
	<td class='label' style='cursor:pointer'>
	<% if(!accession_num.equals("")){ %>
	<a href ="javascript:call_discharge_summary_tab1()"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></a>
	<% } %>
	</td>
	<td class='label' ></td>
	<td class='label' ></td>
	<td class='label' ></td>
</tr>
	<tr><td class='COLUMNHEADER' colspan=4><fmt:message key="eIP.InformedDetails.label" bundle="${ip_labels}"/></td></tr>
	<tr>
		<td class='label' nowrap ><fmt:message key="eIP.InformedTo.label" bundle="${ip_labels}"/></td>
		<td nowrap class='fileds' ><SELECT name='inform_to' id='inform_to' onChange="enableInformName_tab1()" <%=disable_fld%> ><option value="" selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option><option value="01" ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option><option value="02" ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></option><option value="03" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		</SELECT><script>document.forms[0].inform_to.value ="<%=informed_to%>";</script><img id="Ttype" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" ></td>
		<td class='label' ></td>
		<td class='label' ></td>
	</tr>
	<tr>
		<td nowrap class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td nowrap class='fields' ><input type='text' name='informed_name' id='informed_name' value='<%=informed_name%>' size='20' maxlength='200' readOnly></td>
		<td class='label' nowrap><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		<td nowrap class='fields' ><input type='text' name='informed_date' id='informed_date'  value='<%=informed_date_time_display%>' id="inform_date" disabled   onKeyPress='return(ChkNumberInput1_tab1(this,event,2));' size='15' maxlength='16'  onblur="datefun_tab1(this);compareSystemDate1(this);"><input type="image"  name="infocalimg" id="infocalimg"  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('informed_date',null,'hh:mm');" tabindex=-1 disabled=true><img id="im" src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></td>
	</tr>

	<!--Modified by Ashwini on 02-Aug-2018 for ML-MMOH-CRF-1048-->
	<tr><td class='COLUMNHEADER' colspan=4><%if(isRenameCertificateAppl){%><fmt:message key="Common.medical.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.certificate.label" bundle="${common_labels}"/><%}else{%><fmt:message key="Common.certificate.label" bundle="${common_labels}"/><%}%></td></tr>
	<tr><td class='label' colspan='4'></td></tr>
	<!--<tr>
			<td class='label' ><fmt:message key="eIP.CertificateNumber.label" bundle="${ip_labels}"/></td>
			<td class='label' ><b><%=mc_no%></b></td>
<%	if(!mc_no.equals(""))
	{	%>
			<td class='label' ><a href ="javascript:vwMedicalCertificate_tab1('<%=patient_id%>', '<%=encounter_id%>')"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></a></td>
	<%	}  
		else 
		{	%>
			<td class='label' ></td>
	<%	}	%>
			<td class='label' ></td>
	</tr>
	-->

	<!--Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620-->
	<tr>
		<!--Modified by Ashwini on 02-Aug-2018 for ML-MMOH-CRF-1048 and ML-MMOH-CRF-1218-->
		<td nowrap class='label' ><%if(isRenameCertificateAppl){%><fmt:message key="eIP.MedicalCertificateNumber.label" bundle="${ip_labels}"/><%}else{%><fmt:message key="eIP.CertificateNumber.label" bundle="${ip_labels}"/><%}%></td>
		<td nowrap class='fields' ><input type='text' name='cert_num' id='cert_num' value='<%=cert_num%>' size='30' maxlength='30' onKeyPress="return SpCharChkForCertificate(event);" <%if(isItemOnLoanOthersDisableDateAppl){%>onBlur='enableDisableDateField();'<%}%>></td>
	</tr>
	<tr>
		<td  width='40%' class="label" align='right' nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	
		<%if(isAutoPopDurationApplyn){%>
		<td class="fields" width='20%' align='left'>
		<input type=text id="p_date_from" name='cert_from_date' id='cert_from_date' value='<%=cert_from_date%>'  onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();calculateDuration(this);' size="10" maxlength="10" ><%if(!("VIEW_DISCHARGE_CHECKLIST").equals(call_function)){%><img type="image" id="cert_from_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"></img><img id="cert_from_date_mand" src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
		</td>
		<%}else{%>
		<td class="fields" width='20%' align='left'>
		<input type=text id="p_date_from" name='cert_from_date' id='cert_from_date' value='<%=cert_from_date%>'  onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();' size="10" maxlength="10" ><%if(!("VIEW_DISCHARGE_CHECKLIST").equals(call_function)){%><img type="image" id="cert_from_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"></img><%}%>
		</td>
		<%}%>
		<td  width='40%' class="label" align='right' nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<%if(isAutoPopDurationApplyn){%>
		<td class="fields" width='40%' align='left'>
		<input type=text id="p_date_to"  name='cert_to_date' id='cert_to_date' value='<%=cert_to_date%>'  onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();calculateDuration(this);' size="10" maxlength="10" ><%if(!("VIEW_DISCHARGE_CHECKLIST").equals(call_function)){%><img type="image" id="cert_to_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"></img><img id="cert_to_date_mand" src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
		</td>
		<%}else{%>
		<td class="fields" width='40%' align='left'>
		<input type=text id="p_date_to"  name='cert_to_date' id='cert_to_date' value='<%=cert_to_date%>'  onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();' size="10" maxlength="10" ><%if(!("VIEW_DISCHARGE_CHECKLIST").equals(call_function)){%><img type="image" id="cert_to_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"></img><%}%>
		</td>
		<%}%>
	</tr>
	<tr>
		<td nowrap class='label' ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
		<%if(isAutoPopDurationApplyn){%>
		<td nowrap class='fields' ><input type='text' name='duration' id='duration' value='<%=duration%>' id= "duration" disabled size='1' maxlength='3' onKeyPress="return NumChkForCertificate(event);" onBlur="ZeroChkForCertificate(this);calculateDuration(this);">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>
		<%}else{%>
		<td nowrap class='fields' ><input type='text' name='duration' id='duration' value='<%=duration%>' size='1' maxlength='2' onKeyPress="return NumChkForCertificate(event);" onBlur="ZeroChkForCertificate(this);" >

		<SELECT name='duration_dmy' id='duration_dmy' >
		<%if(!duration.equals("")){%>
		<option value="D" <%if(duration_dmy.equals("D")){%>selected<%} %>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
		<option value="M" <%if(duration_dmy.equals("M")){%>selected<%} %>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
		<option value="Y" <%if(duration_dmy.equals("Y")){%>selected<%} %>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
		<%}else{%>
		<option value="D" selected><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
		<option value="M" ><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
		<option value="Y" ><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
		<%}%>
		</SELECT>
		</td>
		<%}%>
	</tr>
	<!--ML-MMOH-CRF-0620 End-->
<!--Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050-->
<%
String Gender=eIP.IPCommonBean.getGender(con,patient_id);
String deliveryDate=eIP.IPCommonBean.getDelivaryDate(con,patient_id);
%>
<%if(isDeliveryCertAppl && Gender.equals("F")){%>

<tr><td class='columnheader' colspan=4><fmt:message key="Common.DeliveryCertificate.label" bundle="${common_labels}"/></td> 
     <tr>
		<td nowrap class='label'><fmt:message key="eIP.CertificateNumber.label" bundle="${ip_labels}"/></td>
		<td nowrap class='fields' ><input type='text' name='deli_cert_num' id='deli_cert_num' value='<%=deli_cert_num%>' size='30' maxlength='30' onKeyPress="return SpCharChkForCertificate(event);" <%=disable_fld%>></td>
	 </tr> 
	
	<tr>
		<td nowrap class='label' ><fmt:message key="eMP.DeliveryDate.label" bundle="${common_labels}"/></td>
		    <td class='label'><%=deliveryDate%></td>
	
		 
	</tr>
</tr>
	<%}%>
	
<!--ENDS-->
</table>
<input type='hidden' name='informed_to' id='informed_to'>
<input type='hidden' name='cert_no' id='cert_no'>
<input type='hidden' name='event_status' id='event_status'>
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='hidden' name='accession_num' id='accession_num' value="<%=accession_num%>">
<input type='hidden' id='isAutoPopDurationApplyn' value="<%=isAutoPopDurationApplyn%>"/>
<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->
<input type='hidden' id='call_function' value="<%=call_function%>"/>

</form>
<%
}catch(Exception e) 
{
	e.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>
<script>
if(document.forms[0])
{
	if(document.forms[0].dis_medication)
	{
		if(parent.parent.DischargeCheckList_frame1.document.forms[0])
		{
			document.forms[0].dis_medication.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_dis_medication.value;
			if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_dis_medication.value == 'Y')
			document.forms[0].dis_medication.checked = true;
			if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_dis_medication.value != '')
			document.forms[0].dis_medication.disabled = true;
		}
	}
}
if(document.forms[0])
{//Adding start by Chandra for MMS-KH-CRF-0052.1
	if(document.forms[0].chargeable_item_yn)
	{
		if(parent.parent.DischargeCheckList_frame1.document.forms[0])
		{
			document.forms[0].chargeable_item_yn.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_chargeable_item_yn.value;
			if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_chargeable_item_yn.value == 'Y')
			document.forms[0].chargeable_item_yn.checked = true;
			if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_chargeable_item_yn.value == 'Y')
			document.forms[0].chargeable_item_yn.disabled = true;
			
		}
	}
}//Adding end for MMS-KH-CRF-0052.1
if(document.forms[0].dis_summ_prep)
{
	if(parent.parent.DischargeCheckList_frame1.document.forms[0])
	{
	}
}

var informed_yn = "<%=informed_to%>";
if(informed_yn == "") 
{
	if(document.forms[0].inform_to)
	{
		if(parent.parent.DischargeCheckList_frame1.document.forms[0])
		{
			if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_inform_to.value!= "")
			document.forms[0].inform_to.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_inform_to.value;
		}
	}

	if(document.forms[0].informed_date)
	{
		if(parent.parent.DischargeCheckList_frame1.document.forms[0])
		{
			document.forms[0].informed_date.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_informed_date.value;
		}
	}

	if(document.forms[0].informed_name)
	{
		if(parent.parent.DischargeCheckList_frame1.document.forms[0])
		{
			document.forms[0].informed_name.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_informed_name.value;
		}
	}

	var call_function = "<%=call_function%>";
	if(parent.parent.DischargeCheckList_frame1.document.forms[0])
	{
		if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_inform_to.value!="")
		{
			if(call_function!="VIEW_DISCHARGE_CHECKLIST")
			{
				document.getElementById('im').style.visibility			= 'visible';
				document.getElementById('im2').style.visibility			= 'visible';
				document.forms[0].informed_date.disabled	= false;
				document.getElementById("infocalimg").disabled			= false;
				document.forms[0].informed_name.readOnly	= false;
			}
		}
	}
}

if(document.forms[0].dis_summ_prep_by)
{
	if(parent.parent.DischargeCheckList_frame1.document.forms[0])
	{

	}
}

var informed_yn = "<%=informed_to%>";
var cert_yn = "<%=mc_no%>";

if(informed_yn!='') 
	document.forms[0].informed_to.value='Y';
else 
	document.forms[0].informed_to.value='N';

if(cert_yn!='') 
	document.forms[0].cert_no.value='Y';
else 
	document.forms[0].cert_no.value='N';

if(informed_yn!='') 
{
	document.forms[0].inform_to.disabled = true;
	document.forms[0].informed_date.disabled = true;
	document.forms[0].informed_name.readonly = true;
}

//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620

var call_function = "<%=call_function%>";
var isAutoPopDurationApplyn = document.forms[0].isAutoPopDurationApplyn.value;
if(call_function=="VIEW_DISCHARGE_CHECKLIST")
{
document.forms[0].cert_num.disabled=true;
document.forms[0].cert_from_date.disabled=true;
document.forms[0].cert_to_date.disabled=true;
document.forms[0].duration.disabled=true;
if(isAutoPopDurationApplyn !="true")
document.forms[0].duration_dmy.disabled=true;
}

// End ML-MMOH-CRF-0620


</script>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

