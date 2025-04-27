<!DOCTYPE html>
<!--Created by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.PreparedStatement,org.json.simple.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src='../../eMR/js/MRMaster.js' Language='JavaScript'></script>
</head>

<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>

<%	
   String facilityId = (String)session.getValue("facility_id");
   request.setCharacterEncoding("UTF-8"); 
   String requestor_type_code="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   boolean status = false;
   String requestor_type_exist_yn	="";
   boolean classification_appl_yn=false; // added by mujafar for ML-MMOH-CRF-0762 start
   String class_indicator_val="";
   String sel_val="";
   String sel_val1="";
   String sel_val2=""; // added by mujafar for ML-MMOH-CRF-0762 end

   Connection con=null;
%>
<%
try
{
	con=ConnectionManager.getConnection(request);
	classification_appl_yn	=  eCommon.Common.CommonBean.isSiteSpecific(con, "MR","CLASSIFICATION_APPL_YN"); // added by mujafar for ML-MMOH-CRF-0762 
	
	requestor_type_code=request.getParameter("requestor_type_code");
	if(requestor_type_code==null)
	{
		requestor_type_code="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		class_indicator_val=""; // added by mujafar for ML-MMOH-CRF-0762 
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		status=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else
	{
		JSONObject json	= eMR.MRCommonBean.getRequestorType(con, requestor_type_code);
		requestor_type_code  = (String) json.get("requestor_type_code");
		longdesc  = (String) json.get("long_desc");
		shortdesc  = (String) json.get("short_desc");
		effstatus  = (String) json.get("eff_status");
		class_indicator_val = (String) json.get("class_indicator_val"); // added by mujafar for ML-MMOH-CRF-0762 start
		
		if(class_indicator_val.equals("N")) sel_val="selected";
		else if(class_indicator_val.equals("P")) sel_val1="selected";
		else if(class_indicator_val.equals("O")) sel_val2="selected"; // added by mujafar for ML-MMOH-CRF-0762 end

			if(effstatus.equals("D")){
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
			}else{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
			}
		
		JSONObject json1 = eMR.MRCommonBean.getRequestorTypeExist(con, requestor_type_code, facilityId);
		requestor_type_exist_yn  = (String) json1.get("requestor_type_exist_yn");
		
		codeTextAttribute="READONLY";
		status=false;
		eventFunctionForCase="";
	}

%>

      	<form name='requestorTypeForm' id='requestorTypeForm' action='../../servlet/eMR.RequestorTypeServlet' method='post' target='messageFrame'>
      	<div align='left'>
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><br>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='requestor_type_code' id='requestor_type_code' value="<%=requestor_type_code%>" size='4' maxlength='4' onBlur="CheckNum(this);" onKeyPress="return CheckForSpecCharsInReqType(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
     		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			
			
	<%if(classification_appl_yn) // added by mujafar for ML-MMOH-CRF-0762 start
	{%>		
	<tr>
	
	<td  class=label><fmt:message key="Common.Classification.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<select name="class_indicator" id="class_indicator">
		<option value='' >----<fmt:message key="Common.Select.label" bundle="${common_labels}"/>----</option>
		
		<option value="N" <%=sel_val%> ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
		<option value="P" <%=sel_val1%> ><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
		<option value="O"  <%=sel_val2%> ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>	
	</select>
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
	
	<%}  // added by mujafar for ML-MMOH-CRF-0762 end %>	
		
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="changeReqType()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(status){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
		<input type='hidden' name='requestor_type_status' id='requestor_type_status' value='<%=requestor_type_exist_yn%>'>
		<input type='hidden' name='classification_appl_yn' id='classification_appl_yn' value='<%=classification_appl_yn%>'> <!--  added by mujafar for ML-MMOH-CRF-0762  -->
     	</form>
      	</body>
      	</html>

<%
}
catch(Exception e){
	//out.println("Exception @ RequestorTypeAddModify.jsp"+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
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

