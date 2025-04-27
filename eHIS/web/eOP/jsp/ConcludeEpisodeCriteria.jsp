<!DOCTYPE html>
<html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, java.util.*, java.text.*, webbeans.eCommon.*,com.ehis.util.*" %>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<% request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOP/js/ConcludeEpisode.js"></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String facility_id = (String) session.getValue("facility_id"); 		
	String login_user  = (String) session.getValue("login_user");
	String locale      = (String) session.getAttribute("LOCALE");	
%>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="conclude_episode_criteria" id="conclude_episode_criteria">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int patient_id_length = 0;
	String sys_date="";

	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("Select patient_id_length,to_char(SYSDATE,'DD/MM/YYYY') sys_date from mp_param where module_id='MP' ");
		rs = pstmt.executeQuery();

		if(rs != null)
		{
			if(rs.next())
			{
			patient_id_length = rs.getInt(1);
			sys_date=rs.getString("sys_date");
			}
		}		

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
%>			
	<table width="100%" cellpadding="0" cellspacing="0" border='0'>
		<tr>	
			<td class="label" width='23%'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
			<td class='fields' width='24%'><input type="text" name="visit_date" id="visit_date" maxlength="10" size="10" onblur='if(validDateObj(this,"DMY",localeName))chkWithSysDt(this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('visit_date').focus();return showCalendar('visit_date')" style="cursor='hand'"></img><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class="label" width='23%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='fields' width='30%'>
			<input type="text" name="service1" id="service1"  onblur='if(this.value!=""){callservice(this,document.forms[0].service1)}'><input type="button" name="ser_lookup" id="ser_lookup" value="?" class="button" onclick="callservice(this,document.forms[0].service1)"><img align='center' src='../../eCommon/images/mandatory.gif'></img><input type="hidden" name="service" id="service">	
			</td>
			</tr>
			<tr>
			<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<INPUT TYPE="text" name="Location1" id="Location1"  onBlur="onBlurgetLoc('<%=login_user%>','<%=locale%>','<%=facility_id%>',document.forms[0].Location1)"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=login_user%>','<%=locale%>','<%=facility_id%>',document.forms[0].Location1)" >
			<input type="hidden" name="location" id="location">
			</td>		
			<td class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type="text" name="practitioner_name" id="practitioner_name" maxlength="30" size="30" onBlur="callPractSearch(document.forms[0].practbutt,practitioner_name);" ><input type="button" class="button" name="practbutt" id="practbutt" value="?" onClick="callPractSearch(this,practitioner_name);">
				<input type="hidden" name="practitioner" id="practitioner" value="">
			</td>
			</tr>
			<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<!-- patient_id_length contains the length of the patient_id which comes from the MP_param table.  Here, the textbox size will be adjusted according the value of this patient_id_length vairable -->
				<input type="text" name="patient_id" id="patient_id" size="<%=patient_id_length%>" maxlength="<%=patient_id_length%>" onBlur="ChangeUpperCase(this);"><input type="button" class="button" name="patbutt" id="patbutt" value="?" onClick="getPatient();">
			</td>
		<td colspan='1'>&nbsp;</td>
		<td colspan='2' class="fields"><input type="button" class="button" name="search" id="search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="displayResult();"><input type="button" class="button" name="clear" id="clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="clearValues();">
		</td></tr>
 	</table> 
 <input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
 <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
 <input type='hidden' name='locale' id='locale' value='<%=locale%>'>


		<%
	}catch(Exception e)
	{	
			out.println("Exception in main Conclude criteria="+e.toString());
	}

	finally
	{
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception e){}
		if(con != null)
			ConnectionManager.returnConnection(con,request);
		
	}
%>
</form>
</body>
</html>

