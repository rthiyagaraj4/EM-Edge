<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

	Connection con 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				=null;
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String pat_name_as_multipart_yn	= "";
	String first_name_length 	= "";
	String second_name_length 	= "";
	String third_name_length 	= "";
	String family_name_length 	= "";
	String file_type_appl_yn 	= "";
	String errFlag				= "";
%>

	<html>
	<head>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
		<script language='javascript' src='../../eOA/js/PatientGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="GroupSearchCriteria" id="GroupSearchCriteria">
	<table cellpadding='1' cellspacing='1' width='100%' border='0'>
		<tr>
		<td class = 'label'  width = '10%' nowrap><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
					<td width='10%' class='fields'>
						<input type="hidden" name="group_id" id="group_id" >	
						<input type="hidden" name="min_patient" id="min_patient" id="min_patient" >
						<input type="hidden" name="max_patient" id="max_patient" id="max_patient" >	
						<input type="hidden" name="Existing_Group_Members" id="Existing_Group_Members" id="Existing_Group_Members" >	
						<input type="hidden" name="group_location_id" id="group_location_id" id="group_location_id" >			
						<input type="text" name="group_name" id="group_name" id="group_name"  onblur='if(this.value!=""){callgroupname(this,document.forms[0].group_name,"delete")}else{clearValues("delete","document");}'><input type="button" name="group_name_lookup" id="group_name_lookup" value="?" class="button" onclick="callgroupname(this,document.forms[0].group_name,'delete')"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td width='80%' id="TdLocationResult"></td>
		</tr>
		<tr></tr>
		<tr></tr>
			
	</table>

	</form> 
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</body>
</html>

