<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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

String convals  = request.getParameter("convals")==null?"":request.getParameter("convals");
String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");

if(!associate_codes.equals(""))
	convals = associate_codes;
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
function showDetails(currConVals)
{
	parent.AddAssociateCodeAddModifyFrame.location.href = "../../eCA/jsp/AddAssociateCodeAddModify.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title=<%=title%>&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=diag_code%>&currConVals=" + currConVals + "&convals=" + document.form1.convals.value + "&mode=modify";	
}
//-->
function showLongDescription(longdesc)
{
	
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	//var a = document.forms[0].LongDescription.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+longdesc,"",features);
}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<form name="form1" id="form1">
	<table border="1" width="100%" cellspacing='0' cellpadding='3'>
		<tr>
			<td class='columnHeadercenter'>
				<fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeadercenter'>
				<fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/>
			</td>
			<td class='columnHeadercenter'>
				&nbsp;
			</td>
		</tr>
<%

String code = "";
String desc ="";
String splitvals = "";
String classval ="";
String long_desc="";
int i= 0;
	

StringTokenizer str1 = new StringTokenizer(convals, "|");
	//if(str1.toString().indexOf("~") != -1)
	{
		if(!convals.equals(""))
		{
			while(str1.hasMoreTokens())
			{
				splitvals = str1.nextToken();
				StringTokenizer str2 = new StringTokenizer(splitvals,"~");
				while(str2.hasMoreTokens())
				{
					code = (String)str2.nextToken();
					desc = (String)str2.nextToken();
					if(str2.hasMoreTokens())
					long_desc = (String)str2.nextToken();
					
					
				}
				
				if(i%2 == 0)
					classval = "QRYODD";
				else
					classval = "QRYEVEN";
				out.println("<tr><td class='"+classval+"' > <a href=javascript:showDetails(\"" + java.net.URLEncoder.encode(code + "~" + desc +"~"+long_desc) + "\")>" + code+ "</td>");
				out.println("<td class='"+classval+"' >" + desc+ "</td>");
				out.println("<td class='"+classval+"' ><input type='button' name='exclamation' id='exclamation' value= '!' class='button' onclick='showLongDescription(\""+java.net.URLEncoder.encode(long_desc)+"\")'></td></tr>");
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

