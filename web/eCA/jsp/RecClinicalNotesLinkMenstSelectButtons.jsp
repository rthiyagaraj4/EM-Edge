<%
/*
---------------------------------------------------------------------------------------------------------
Date		 Edit History	     Name		 Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
29/10/2024         70704	   Gunasekar R     								   ML-MMOH-CRF-1759
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title></title>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String textchkbox="";
    String tablechkbox="";
	String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	String text_format_default_yn = "";
    CAEncounterList caEncList = (CAEncounterList)getObjectFromBean("caEncList","eCA.CAEncounterList",session);
	text_format_default_yn = caEncList.getTextFormatDefaultYN();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMenstHistDtl.js'></script> 

	</head>	
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' >
	<center>
	<form name='RecClinicalNotesLinkMenstSelectButtonsForm' id='RecClinicalNotesLinkMenstSelectButtonsForm'>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'  align='center'>
		<tr >
		<td class=label width='25%' >&nbsp;</td>		
        <%
		if(return_format.equals("TEXT") || "Y".equals(text_format_default_yn)) 
		{
			textchkbox = "checked";
        }
		else
	    {
		   tablechkbox = "checked";
		}  
		%>
	    <td class=label width='25%' colspan=2 ><b><fmt:message key="Common.Format.label" bundle="${common_labels}"/></b>
		<input type="radio" name="format" id="format" id = "chkt"  class="label" value="t" onClick="chgretn(this)" <%=textchkbox%> >
		<font size='1'><fmt:message key="Common.Text.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="format" id="format" id = "chkl" class="label" value="l" onClick="chgretn(this)" <%=tablechkbox%>><font size='1'><fmt:message key="Common.Table.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td width='25%' ></td>
		<td  width='25%' align='right'>
			<input type='BUTTON' class='BUTTON' name='select' id='select' disabled value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick="returnDataApprove()">&nbsp;
			<input type='BUTTON' class='BUTTON' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick = "clearFormApprove()">&nbsp;
			<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='parent.window.close();'>&nbsp;&nbsp;
		</td>
		</tr>
		</table>
	</p>
	</form>
	</center>
</body>
</html>

