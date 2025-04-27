<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title>Selected Gateways</title>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript">

function Message()
{
	
}															 					  


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<style>
		textarea {
		  	resize: none;
		}
	</style>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' wrap width='100%' align='center' >
<%   

String SysDefStructure  = request.getParameter("selectedGateway");
            
%>
 <tr>
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap width='30%' align='left' colspan='2'><font size='-1'><b>Selected Gateways</b></font></td></tr>
<tr>
<td  wrap width='30%' align='left' ><textarea rows="9" cols="93" readonly><%=SysDefStructure%></textarea></td>
</tr>
</table>
</body>
</html> 

