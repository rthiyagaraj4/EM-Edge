<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></title>	
	<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function showLongDescription(longdesc)
{
	
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	//var a = document.forms[0].LongDescription.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+longdesc,"",features);
}
	</script>
	</head>	
<%
	String associate_codes = java.net.URLDecoder.decode(request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes"));

%>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<form>
		&nbsp;&nbsp;&nbsp;
		<table border='1' cellpadding='3' cellspacing='0' width="100%"  align=center>
		<tr>
		<td class='columnheadercenter'   width ="15%" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' width ="85%" ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' width ="85%" >&nbsp;</td>
		</tr>
		<%
			String code = "";
			String desc ="";
			String longdesc ="";
			String splitvals = "";
			String classval ="";
			int i= 0;

			StringTokenizer str1 = new StringTokenizer(associate_codes, "|");
			if(!associate_codes.equals(""))
			{
				while(str1.hasMoreTokens())
				{
					splitvals = str1.nextToken();
					StringTokenizer str2 = new StringTokenizer(splitvals,"~");
					while(str2.hasMoreTokens())
					{
						code = str2.nextToken();
						desc = str2.nextToken();
						if(str2.hasMoreTokens())
						longdesc=str2.nextToken();
					}	
					if(i%2 == 0)
						classval = "QRYODD";
					else
						classval = "QRYEVEN";
					out.println("<tr>");
					out.println("<td class='"+classval+"' >"+code+ "</td>");
					out.println("<td class='"+classval+"' >" +desc+ "</td>");
					out.println("<td class='"+classval+"' ><input type='button' name='exclamation' id='exclamation' value= '!' class='button' onclick='showLongDescription(\""+java.net.URLEncoder.encode(longdesc)+"\")'></td></tr>");
					out.println("</tr>");
					i++;				
				}
			
			}%>	
		</table>	
		&nbsp;&nbsp;
		</form>
	</body>
</html>


