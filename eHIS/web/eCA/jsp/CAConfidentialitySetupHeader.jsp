<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
6/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
24/12/2013	  IN045950		 Karthi L	 CA-when specialty with special characters is selected again at lookup in confidentiality Setup, getting query caused no records message
--------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="BatchBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	StringBuffer sql = null;
	String hist_rec_type	=	"";
	String long_desc = "";
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	int cnt=0;

	try
	{		
		con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="Javascript"></script>
<script src="../../eCommon/js/CommonResult.js" language="Javascript"></script>
<script src='../../eCA/js/ConfidentialitySetUpHeader.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<form name='confidentiality_setup_header' id='confidentiality_setup_header'  method='post' target='messageFrame'>
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >

<table border=0 cellspacing=0 cellpadding=3 width='100%' align='center'>	
	<tr> 
		<td class=label><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name='hist_rec_type' id='hist_rec_type' onChange='disableWhenHTChange();contrsystempop2();'>
				<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>	
<%
			    sql = new StringBuffer();	
				sql.append("SELECT HIST_REC_TYPE, SHORT_DESC FROM CR_HIS_RECTYP_LNG_VW WHERE HIST_REC_TYPE NOT IN('ALGY','MEDN','NBDT','FEVT','DIAG','DIET','MGCL','DSSM','FDOC') AND LANGUAGE_ID = 'en' ORDER BY 2 ASC");
		
				stmt = con.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
		
				while(rs.next())
				{
					hist_rec_type = rs.getString("HIST_REC_TYPE");
					long_desc = rs.getString("SHORT_DESC");
%>
					<option value='<%=hist_rec_type%>'><%=long_desc%></option>
<%				}
					
				if(rs!=null) 
					rs.close();

				if(stmt!=null)
					stmt.close();	
			%>
			</select><img src='../../eCommon/images/mandatory.gif'>
		</td>							
		<td class=label style='visibility:hidden' id = 'event_type_label'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>			
		<td class='fields' id = 'event_type_data' style='visibility:hidden'>
			<select name='eventType' id='eventType' onchange='enableFilterBasedOn();'>
				<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>		
		<td class=label style='visibility:hidden' id = 'filter_based_label'><fmt:message key="eCA.filterbasedon.label" bundle="${ca_labels}"/></td>
		<td class='fields' id = 'filter_based_data' style='visibility:hidden'>
			<select name='filter_based_on' id='filter_based_on' onchange = 'getDisplayMode();' >
					<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
			</select><img src='../../eCommon/images/mandatory.gif'>
		</td>	
	</tr>
	<tr id = 'event_data' style='display:none'>
		<td class=label><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
		
		<td class='fields' id ='event_code_box' ><input type='text'  name='event_desc' id='event_desc' value=''   onBlur='populateEventCodeOnBlur(event_desc,event_codes)' size='20' maxlength='20'><input type='button' name='eventCodeSearch' id='eventCodeSearch' value='?' class='button' onClick="if(document.forms[0].event_desc.value == '')populateEventCodeValue(event_desc,event_codes)"><input type="hidden" name="event_codes" id="event_codes" value=''> <img src='../../eCommon/images/mandatory.gif'></td> <!-- IN045950 -->
		
		<!-- <td class='fields'>
			<select name='event_codes' id='event_codes' onchange = 'dispPrivButtons();' >
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			</select><img src='../../eCommon/images/mandatory.gif'>
		</td>	-->
	</tr>
	<tr id = 'privilege_buttons'  style='display:none'>	
		<td colspan="2">
			<input type = 'button' name 'Practitioner' id = 'Practitioner' value = <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> onClick = "searchClick('P')" class = 'button' /> 
			<input type = 'button' name 'Speciality' id = 'Speciality' value = <fmt:message key="Common.Specialty.label" bundle="${common_labels}"/> onClick = "searchClick('S')" class = 'button'/>
			<input type = 'button' name 'Responsibility' id = 'Responsibility' value = <fmt:message key="Common.responsibility.label" bundle="${common_labels}"/>  onClick = "searchClick('R')" class = 'button'/>		
		</td>
	</tr>
	<tr id = 'privilege_responsibility' stye = 'display:none'>
		<td class=label ><label id = "title_type" style ="display:none" ></label></td>
		<td class='fields' id ='priv_text_box' style = 'display:none'><input type='text'  name='priv_resp_desc' id='priv_resp_desc' value=''   onBlur='populateValueOnBlur(priv_resp_desc,priv_resp_code)' size='20' maxlength='20'><input type='button' name='privRespSearch' id='privRespSearch' value='?' class='button' onClick="if(document.forms[0].priv_resp_desc.value == '') populateValue(priv_resp_desc,priv_resp_code)"><input type="hidden" name="priv_resp_code" id="priv_resp_code" value=''> <img src='../../eCommon/images/mandatory.gif'></td>	<!-- IN045950 -->	
		<td class=label id = 'viewlistlabel' style='display:none'><fmt:message key="eCA.viewlist.label" bundle="${ca_labels}"/></td>
		<td class='fields' id = 'view_list_code' style='display:none'>
			<select name='view_list_code' id='view_list_code' onchange = "reLoadSearchResultFrame('E');">
				<option value = "Z"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value = "M"><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
			</select>
		</td>		
		<td class=label id = 'basedonlabel' style='display:none'><fmt:message key="eCA.basedon.label" bundle="${ca_labels}"/></td>
		<td class='fields' id = 'based_on_code' style='display:none'>
			<select name='based_on_code' id='based_on_code'  onchange = "reLoadSearchResultFrame('E');">
				<option value = "E"><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></option>
				<option value = "A"><fmt:message key="eCA.authorizedorordered.label" bundle="${ca_labels}"/>
				<option value = "B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			</select>
		</td>		
		<td class=label id = 'viewbylabel' style='display:none'><fmt:message key="eCA.ViewBy.label" bundle="${ca_labels}"/></td>
		<td class='fields' id = 'view_by_code' style='display:none'>
			<select name='view_by_code' id='view_by_code' onchange = "reLoadSearchResultFrame('E');" >
				<option value = "P"><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></option>
				<option value = "S"><fmt:message key="eCA.secondaryspeciality.label" bundle="${ca_labels}"/>
				<option value = "B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			</select>
		</td>		
	</tr>
</table>
<input type='hidden' name='hist_rec_type1' id='hist_rec_type1' value='<%=hist_rec_type%>'>
<input type='hidden' name='event_type_code' id='event_type_code' value=''>
<input type='hidden' name='filter_when_click' id='filter_when_click' value =''>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='selectedDataCount' id='selectedDataCount' value=''>
<input type='hidden' name='filter_based_desc' id='filter_based_desc' value=''>
<input type='hidden' name='countOfRows' id='countOfRows' value='<%=cnt%>'>
<input type='hidden' name='filter_based_indicator' id='filter_based_indicator' value=''>
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		//out.println("From ClinicalRepMastMainEvent.jsp" + e.toString());//COMMON-ICN-0181
		System.err.println("CAConfidentialitySetupHeader.jsp,141,message=>"+e.getMessage());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) 
			rs.close();
					
		if(stmt!=null) 
			stmt.close();

		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	}
%>

