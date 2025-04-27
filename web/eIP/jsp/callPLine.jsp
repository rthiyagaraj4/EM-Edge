<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");
	String facility_id	=(String)session.getValue("facility_id");
	String encounter_id	= request.getParameter( "encounterId" ) ;
%>

<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Facility_Id" value="<%=facility_id%>"/>
		<jsp:param name="EncounterId" value="<%=encounter_id%>"/>
	</jsp:include>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<script>

		var s = "<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> ";
			s+=	"<body onKeyDown='lockKey()'><table width='100%' cellspacing='0' cellpadding='0'><tr><td align='left' width='50%' class='CAGROUPHEADING'><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th><td width='50%' align='right' class='CAGROUPHEADING'><input type='button' value='Select' name='select' id='select' class='button' onclick='parent.frames[0].loadData()'></td></tr></table></body>"
			s+= "</html>"
		parent.frames[3].document.write(s);
		 function loadData()
		 {
			 parent.frames[5].document.forms[0].elements(0).value += parent.frames[4].document.body.innerText+"\n"
			 
		}
	</script>
	<br>
	<table width='100%' cellspacing=0 cellpadding=0>
		<tr>
			<td width ='39%' align='left' class='CAGROUPHEADING'><fmt:message key="Common.documents.label" bundle="${common_labels}"/></td>
			<td class='white' width='1%' class='CAGROUPHEADING'>&nbsp;</td>
			<td align='left' class='CAGROUPHEADING'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>' >
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

