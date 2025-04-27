<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
24/05/2016	  IN055439		 Karthi L										MO_CRF_20102
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %><!-- MO_CRF_20102[IN055439]   -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!-- MO_CRF_20102[IN055439]   -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title>RecClinicalNotesLink.jsp</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String textchkbox="";
    String tablechkbox="";

	String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	String text_format_default_yn = ""; //  MO_CRF_20102[IN055439] 
    CAEncounterList caEncList = (CAEncounterList)getObjectFromBean("caEncList","eCA.CAEncounterList",session); //  MO_CRF_20102[IN055439] 
	text_format_default_yn = caEncList.getTextFormatDefaultYN(); //  MO_CRF_20102[IN055439] 
	
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMed.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<center>
	<form name='RecClinicalNotesLinkMedSelectButtonsForm' id='RecClinicalNotesLinkMedSelectButtonsForm'>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
		<tr >
		
		<td class=label width='25%' >&nbsp;</td>
		
        <%
		if(return_format.equals("TEXT") || "Y".equals(text_format_default_yn))    // added || condition for MO_CRF_20102[IN055439] 
		{
			textchkbox = "checked";
        }
		else
	    {
			tablechkbox = "checked";
		}
		%>
	    <td class =label width='25%'  ><b><fmt:message key="Common.Format.label" bundle="${common_labels}"/>&nbsp;&nbsp;</b>
		<input type="radio" name="chk" class="label" id = "chkt" value="t" onClick="chgretn(this)" <%=textchkbox%> >
		<font size='1'><fmt:message key="Common.Text.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="chk" id = "chkl"  class="label" value="l" onClick="chgretn(this)" <%=tablechkbox%>><font size='1'><fmt:message key="Common.Table.label" bundle="${common_labels}"/>&nbsp;&nbsp;
        </td>		<!-- id added for MO_CRF_20102[IN055439] -->
		<!-- 	<%//}%> //  MO_CRF_20102[IN055439] --> 
		
		<td width='25%' align='right' >
			<input type='BUTTON' class='BUTTON' name='select' id='select' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' disabled onClick="returnDataApprove()">
			<input type='BUTTON' class='BUTTON' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick = "clearFormApprove()">
			<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='parent.window.close();'>
		</td>
		</tr>
		</table>
	</p>
	</form>
	</center>
</body>
</html>

