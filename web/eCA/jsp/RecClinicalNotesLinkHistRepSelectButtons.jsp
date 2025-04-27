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
	<title>RecClinicalNotesLinkHistRepSelectButtons.jsp</title>
	
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
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkRep.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
	<center>
	<form name='RecClinicalNotesLinkHistRepSelectButtonsnewForm' id='RecClinicalNotesLinkHistRepSelectButtonsnewForm'  method=post>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
		<tr >
<!--		<td class=label  >&nbsp;</td>
		<td class=OAYELLOW  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
		<td class=label width='22%' ><fmt:message key="eCA.ApplicableOnlyforTableFormat.label" bundle="${ca_labels}"/></td>
		<td class=label >&nbsp;</td>
		<%
		if(return_format.equals("TEXT") || "Y".equals(text_format_default_yn))   // added || condition for MO_CRF_20102[IN055439] 
		{
			textchkbox = "checked";
		}
		else
		{
			tablechkbox = "checked";
		}
		%>
		<td class=label   ><b><fmt:message key="Common.Format.label" bundle="${common_labels}"/></b>
        
	    <input type="radio" name="format" id="format" id = "chkt" class="label" value="t" onClick="chgretn(this)" <%=textchkbox%> >
		<font size='1'><fmt:message key="Common.Text.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="format" id="format" id = "chkl" class="label" value="l" onClick="chgretn(this)" <%=tablechkbox%>><font size='1'><fmt:message key="Common.Table.label" bundle="${common_labels}"/>&nbsp;&nbsp;
        </td> <!-- id added for MO_CRF_20102[IN055439] -->
		<!-- 	<%//}%> //  MO_CRF_20102[IN055439] --> 
		<td align='right'>
			<input type='BUTTON' class='BUTTON' name='select' id='select' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick="returnDataApprove()" disabled>
			<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick="parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();">
		</td>
		</tr>
		</table>
	</p>
	<input name='hist_type' id='hist_type' type=hidden value="">
	<input name='accession_num' id='accession_num' type=hidden value="">
	<input name='data_type' id='data_type' type=hidden value="">
	<input name='from' id='from' type=hidden value="">
	<input name='contr_sys_id' id='contr_sys_id' type=hidden value="">
	<input name='contr_sys_event_code' id='contr_sys_event_code' type=hidden value="">
	</form>
	</center>
</body>
</html>

