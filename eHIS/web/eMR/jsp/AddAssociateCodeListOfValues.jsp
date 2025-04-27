<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
<%
	
	String code_indicator  = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
	String diag_desc  = request.getParameter("diag_desc")==null?"":request.getParameter("diag_desc");
	String title  = request.getParameter("title")==null?"":request.getParameter("title");
	String p_diag_code  = request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code");
	String p_diag_scheme_desc  = request.getParameter("p_diag_scheme_desc")==null?"":request.getParameter("p_diag_scheme_desc");
	String Encounter_Id  = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	String p_auth_yn  = request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");
	String cause_indicator  = request.getParameter("cause_indicator")==null?"":request.getParameter("cause_indicator");
	String Age  = request.getParameter("Age")==null?"":request.getParameter("Age");
	String Sex  = request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String Dob  = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String p_scheme  = request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme");
	String diag_code  = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String convals  = request.getParameter("convals")==null?"":request.getParameter("convals");
	String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	
	if(!associate_codes.equals(""))
	convals = associate_codes;
%>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<SCRIPT LANGUAGE="JavaScript">
<!--
function showDetails(currConVals)
{
	
	//parent.AddAssociateCodeAddModifyFrame.location.href = "../../eCA/jsp/AddAssociateCodeAddModify.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title="+encodeURIComponent('<%=title%>')+"&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=diag_code%>&currConVals=" + currConVals + "&convals=" + document.form1.convals.value + "&mode=modify";	
	
	parent.AddAssociateCodeAddModifyFrame.location.href = "../../eMR/jsp/AddAssociateCodeAddModify.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title="+encodeURIComponent('<%=title%>')+"&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=diag_code%>&currConVals=" + currConVals + "&convals=" + document.form1.convals.value + "&mode=modify&term_set_id=<%=term_set_id%>";	
}
//-->
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  class='CONTENT' onKeyDown = 'lockKey()'>
<form name="form1" id="form1">
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
			<th>
				<fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/>
			</th>
			<th>
				<fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/>
			</th>
		</tr>
<%

String code = "";
String desc ="";
String splitvals = "";
String classval ="";
int i= 0;
String longdesc="";	

StringTokenizer str1 = new StringTokenizer(convals, "|");
	{
		if(!convals.equals(""))
		{
			while(str1.hasMoreTokens())
			{
				splitvals = str1.nextToken();
				StringTokenizer str2 = new StringTokenizer(splitvals,"~");
				while(str2.hasMoreTokens())
				{
					code = java.net.URLDecoder.decode((String)str2.nextToken());
					desc = java.net.URLDecoder.decode((String)str2.nextToken());
					if(str2.hasMoreTokens())
						longdesc= java.net.URLDecoder.decode((String)str2.nextToken());
				}
				
				if(i%2 == 0)
					classval = "QRYODD";
				else
					classval = "QRYEVEN";
				out.println("<tr><td class='"+classval+"' > <a href=javascript:showDetails(\"" + java.net.URLEncoder.encode(code + "~" + desc) + "\")>" + code+ "</td>");
				out.println("<td class='"+classval+"' >" + desc+ "</td></tr>");
				i++;				
			}
		}
	}
%>
	</table>
	<input type="hidden" name="convals" id="convals" value="<%=convals%>">
</form>
</BODY>
</HTML>
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

