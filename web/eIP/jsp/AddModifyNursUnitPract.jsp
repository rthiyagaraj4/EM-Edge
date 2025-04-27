<!DOCTYPE html>
<!--****Master to maintain Practitioner who has admission rights to each Nursing Unit*****-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%	
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String param=request.getParameter("param");
	String facilityID=(String)session.getValue("facility_id");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../js/NursUnitPract.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>function popDynamicValues(obj){}</script>
<script>

</script>

</head>

<%if(param.equals("create")){%>
	<body onLoad='focusTxt()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%}else{%><body onMouseDown="CodeArrest()" onKeyDown="lockKey()"><%}%>

<form name='NursUnitPract_form' id='NursUnitPract_form' action='../../servlet/eIP.NursUnitPractServlet' method='post' target='messageFrame'>
<div align='left'>
<BR><BR><BR><BR><BR><BR><BR>
<BR><BR><BR><BR>
  <table border='0' cellpadding='0' cellspacing='0' width='55%' align='center'>

	<tr>
		<td width="30%" >&nbsp;</td>
  		<td width="70%" colspan="2">&nbsp;</td>
	</tr>

    	<tr>
	 	 <td width='30%' align='right' class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
	<% 
	     if(param.equals("create"))
	      {
	%> 	
	  	<td width='70%' align='left' colspan='2'>&nbsp;
		<jsp:include page="NursingUnitComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
		<img src='../../eCommon/images/mandatory.gif'align='center'></img>
	  	</td>
	 <%   } 
	      else 
	      {	
				String nursing_unit_code=request.getParameter("nursing_unit_short_desc");
				if(nursing_unit_code == null ) nursing_unit_code = "";
				String nursing_unit_code1=request.getParameter("nursing_unit_code");
				if(nursing_unit_code1 == null ) nursing_unit_code1 = "";
	 %>
			<td width='70%' align='left' colspan='2'>&nbsp;&nbsp;
			<input type=text name='nursing_unit' id='nursing_unit' value="<%=nursing_unit_code%>" size='15' maxlength=15 readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='nursing_unit_code1' id='nursing_unit_code1' value="<%=nursing_unit_code1%>");
	 	</td>
	 <%   }
	 %>
    	</tr>

	<tr>
		<td width="30%" >&nbsp;</td>
  		<td width="70%" colspan="2">&nbsp;</td>
	</tr>
    	<tr>
	  	<td width='30%' align='right' class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	  	
	<% if(param.equals("create")) 
	     {	     
	%>  	<td width='70%' align='left' colspan='2' nowrap>&nbsp;&nbsp;<jsp:include page="PractitionerComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
	 	<img src='../../eCommon/images/mandatory.gif'align='center'></img>
	<%   } 
	   else 
	     { 
	     	String  practitionername=request.getParameter("practitioner_name");
	     	if(practitionername == null ) practitionername = "";
	     	
	     	String  practitioner_id=request.getParameter("practitioner_id");
	     	if(practitioner_id == null ) practitioner_id = "";
	     	
       	%>      <td width='70%' align='left' colspan='2'>&nbsp;&nbsp;
	 	<input type=text name='practid' id='practid' value="<%=practitionername%>" size='15' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	 	<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'");
	<%   } 
	%>		
		</td>
    	</tr>
    
    	<tr>
		<td width="30%" >&nbsp;</td>
  		<td width="70%" colspan="2">&nbsp;</td>
	</tr>
</table>
</div>
	<% 	if(param.equals("create")) 
		{
	%>
		  <input type='hidden' name='function' id='function' value='insert'>
	          <input type='hidden' name='function_name' id='function_name' value='insert'>
	<% 
		} 
		else 
		{ 
	%>
		  <input type='hidden' name='function' id='function' value='modify'>
	          <input type='hidden' name='function_name' id='function_name' value='modify'>
	<% 	} 
	%> 	  <input type='hidden' name='operating_facility_id' id='operating_facility_id' value="<%=facilityID%>" >
</form>

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

