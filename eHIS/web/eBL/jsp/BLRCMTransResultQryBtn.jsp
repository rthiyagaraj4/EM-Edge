<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eBL/js/RCMTransactions.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
		System.err.println("Query String in Btn.jsp:"+request.getQueryString());
		
		String disabled = "";
		String facilityId = (String)session.getAttribute("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		String listOfApprDocNum = checkForNull(request.getParameter("listOfApprDocNum"));
		String p_ins_status = checkForNull(request.getParameter("p_ins_status"));
		String p_level_of_srch = checkForNull(request.getParameter("p_level_of_srch"));
%>


<body>
<form name='BLRCMTransResultQryBtn' id='BLRCMTransResultQryBtn'>

<table cellpadding='3' cellspacing='0'  width="100%">
	<tr>

		<td width="70%"  class='labels' colspan=5></td>
		<td width="30%" class='fields'>
		<% if(!(p_ins_status.equals("P") || p_ins_status.equals("C") || p_ins_status.equals("**"))){ 
				disabled = "disabled";
			}
		%>
			<input type='button' name="send_to_insurance" id="send_to_insurance" id="send_to_insurance" value="Send to Insurance" class='button' onclick='saveUserData();' 
			<%=disabled%>>
			<input type='button' name="export_to_excel" id="export_to_excel" id="export_to_excel" value="Export to Excel" class='button' onclick="generateExcel('E');" >

			<input type="hidden" name="p_ins_status" id="p_ins_status" id="p_ins_status" value="<%=p_ins_status%>" />
			<input type="hidden" name="p_level_of_srch" id="p_level_of_srch" id="p_level_of_srch" value="<%=p_level_of_srch%>" />
			<input type="hidden" name="p_sel_appr_doc_ref_no" id="p_sel_appr_doc_ref_no" id="p_sel_appr_doc_ref_no" value="<%=listOfApprDocNum%>" />
			<input type="hidden" name='p_facility_id' id='p_facility_id' id='p_facility_id' value='<%=facilityId%>'>
			<input type="hidden" name='locale' id='locale' value='<%=locale %>'>
			<input type = "hidden" id = "p_action_id" name = "p_action_id" value = "" >			
			
		</td>
	</tr>
</table>
</form>
</body>
</html>

