<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		String locale           = (String) session.getAttribute("LOCALE");
		String function_id	= checkForNull(request.getParameter("function_id"),"");
		Connection con=null;
		String patientIdLength	= "";
		String action	= "1";
		if("DISP_ARCH_APPROVAL".equals(function_id)){
			action	= "0";
		}
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../js/PatDispArchApproval.js'></script> 
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function showLookUp(val) {
		if(val == 'P') {
			var patientid=PatientSearch('','','','','','','Y','','','OTHER');
			if(patientid != null)
				 document.getElementById("PatientId").value = patientid;
			else
				 document.getElementById("PatientId").value = "";
		}
      }

function validatePatientId(obj) {
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}

	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		 if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }
		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
		}
	}
}

	  function validSplchars(obj) {				
		 var fields=new Array();
		 var names=new Array();
		 fields[0]=obj;
		 names[0]=getLabel("Common.patientId.label","Common");									
		if(SpecialCharCheck( fields, names,'',"A",''))
			return true;
		else {
			obj.select();
			obj.focus();
			return false;
		}
	}

</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="frmPatDispArchApprovalCriteria" id="frmPatDispArchApprovalCriteria" method="post" action="../../eMR/jsp/PatDispArchApprovalResults.jsp" target="resultsFrame">
<center>
<%
try	{
		con =  ConnectionManager.getConnection(request);
		patientIdLength = eCommon.Common.CommonBean.getPatIdLength(con);
		patientIdLength = checkForNull(patientIdLength,"0");
%>
<Br>


	<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
		<tr>
		
			<!--<td class="label" width="10%"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			<td width="10%" class="fields" >
				<select name="arch_disp" id="arch_disp" onchange="fnArchDispChgn(this);">
					<%if("DISP_ARCH_APPROVAL".equals(function_id)){%>
					<option value="0"><fmt:message key="eMR.Disposal.label" bundle="${mr_labels}"/></option>
					<%}else{%>
						<option value="1"><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></option>
					<%}%>
				</select>
			</td>-->
			<input type="hidden" name="arch_disp" id="arch_disp" value	= "<%=action%>" />
			

			<td class="label" width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width="15%" class="fields" >

				<input type='text' maxlength='<%=patientIdLength%>' size='20' name='PatientId' size='<%=patientIdLength%>' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);validSplchars(this);validatePatientId(this);'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')">
			</td>
			<td class="label" width="10%"><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields" >
				<input type='text' onblur='if(validDateObj(this,"DMY","<%=locale%>"))validate_date(this);' id="req_date_from" maxlength='10' size='10' name='from_date'  value=""  onkeypress="return Valid_DT(event)" > <img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].req_date_from.focus();return showCalendar('req_date_from');"><img src="../../eCommon/images/mandatory.gif"></img>
			</td>
						
			<td   width="10%" align="left">
				<INPUT TYPE="button" id="searchBtn" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%> "  onClick='callSearch()' class='BUTTON' align="left"> 
			</td>
			<td  width="25%">
				
			<%if("DISP_ARCH_APPROVAL".equals(function_id)){%><INPUT TYPE="button" id="dispApprBtn" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DisposalApproval.label","mr_labels")%> " align="left" onClick='callApply()' class='BUTTON' disabled><%}%></td>
	   </tr>	
	   <tr>
		   <td colspan='6'>&nbsp;</td>
	   </tr>
	   	<tr>
			<td colspan="6" align='center'> <img src='../../eOA/patientportal/ajax-loader.gif' alt='Loading..' align='center' id='imgLoad' style="display:none"></td>
		</tr>
	  
	</table>
	<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>" />

</form>
</center>
</body>
</html>

<%
	} catch(Exception e) {
		//out.println(e.getMessage());
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con,request);

	}
%>

<%!	
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

