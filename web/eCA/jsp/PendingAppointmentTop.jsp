<!DOCTYPE html>
<!-- CosignOrdersTop.jsp -->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.PendingAppointmentbean"/> 

<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- onLoad='populateLocation(document.cosign_order.location_type)' -->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%   bean.setLanguageId(localeName);
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_PendingAppointmentbean" ;
	String bean_name = "eOR.PendingAppointmentbean";
	//String disabled = "" ;
//	ConsignOrders bean = (ConsignOrders)getBeanObject( bean_id,bean_name ,request  ) ;

   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String frmSum=request.getParameter("frmSum");	
	if(frmSum == null || frmSum.equals("null")) frmSum =""; else frmSum = frmSum.trim();
	Properties properties =(Properties) session.getValue( "jdbc" );
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String curr_week_date  = "";
	String last_week_date  = "";
	/*Thai date validations 14/02/2007 start*/
	/*ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		curr_week_date =  (String)sysdate.get(1);
		//curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	}
	

/*out.println("<BR>"+(String)session.getValue("security_level"));
out.println("<BR>"+(String)session.getValue("practitioner_type"));
out.println("<BR>"+(String)session.getValue("ca_practitioner_id"));
out.println("<BR>"+(String)session.getValue("ca_resp_id"));
out.println("<BR>"+(String)session.getValue("facility_id"));*/

	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength(properties);

	last_week_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";
	curr_week_date	= com.ehis.util.DateUtils.minusDate(last_week_date,"DMY",localeName,7,"d");

    /*Thai date validations 14/02/2007 end*/ 

	String  temp_curr_week_date=curr_week_date;
    String temp_last_week_date=last_week_date;
%>
<form name='cosign_order' id='cosign_order' target='CosignOrderBottom' action='PendingAppointmentBottom.jsp'>
<table cellpadding=3 cellspacing=0 border=0 width="100%"  align=center>
	
	<tr>
		<td class='label'  ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td  class="fields"><SELECT name="location_type" id="location_type" > <!--onChange='populateLocation(this)'-->
			<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> 
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/> 
			<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/> 
			<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/> 
			<option value="W"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> 
			<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/> 
		</SELECT><Input name='locn_desc' id='locn_desc' type='text' value='All'  size="15" onBlur="populateLoaction(locn_desc);" ><input  class='button' type=button name=search value='?'  class=button onClick="populateLoaction(locn_desc)" size='15'><input type='hidden' name='locn' id='locn' value=''>
		</td>
		<td class=label ><fmt:message key="Common.Period.label" bundle="${common_labels}"/> </td>
		<td class='fields' ><input type="text" name="period_from" id="period_from" value="<%=curr_week_date%>"  size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type=text name='period_to' id='period_to' value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'cosign_order');" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
		</tr>
		
	 <td  class='label' id='id_locn'  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	 <td class="fields" >
			<input type='text'  name='patientId' id='patientId' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>" ><input class='button' type=button name=search value='?'  class=button tabIndex="3" onClick="callPatientSearch()"></td>
		
		<td  colspan=2 class="button" align="right">
		<INPUT TYPE="button" name='search_btn' id='search_btn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='populateValues()'><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='resetValues()'>
		</td>
		
		
		</tr>
		
	
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="location_sql" id="location_sql" value="<%= OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id %>">
<input type="hidden" name="facility_id" id="facility_id" value="<%= facility_id %>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<input type="hidden" name="frmSum" id="frmSum" value="<%=frmSum %>">
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>
</body>
<script>

	document.cosign_order.search_btn.disabled = true;

    document.cosign_order.submit();

</script>

</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>

