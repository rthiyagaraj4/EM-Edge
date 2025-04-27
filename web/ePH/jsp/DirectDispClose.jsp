<!DOCTYPE html>
 <% 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------

20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
--------------------------------------------------------------------------------------------------------------
*/%>
<%@page contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String calling_func	=	request.getParameter("called_from");
	String or_mode		=	request.getParameter("or_mode");
	if(or_mode == null){
		or_mode="";
	}

%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table  border=1 align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 
<%	
	if (calling_func.equals("refill")) { %>
	   <td  class="white" align="right">
	       <input type="button" value=' <fmt:message key="Common.close.label" bundle="${common_labels}"/> ' class="BUTTON" onClick="saveRefill();saveAndClose();">&nbsp;&nbsp;&nbsp;<!-- Modified for IN:069886 -->
	   </td>
<%	} else if(calling_func.equals("normal")) { %>
	   <td class="white" width="4%" align="right">
	        <input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="BUTTON" onClick="parent.parent.parent.window[2].document.getElementById('dialog_tag').close();">&nbsp;&nbsp;&nbsp;
	   </td>
<%	} else if(calling_func.equals("remarks")) { %>   
	<td  class="white" align="right"> 
		<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="BUTTON" onClick="saveRemarks(parent.remarks_detail.document.prescription_remarks);">
		<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' class="BUTTON" onClick="parent.parent.parent.window[2].document.getElementById('dialog-body').contentWindow.returnValue='' ;parent.parent.parent.window[2].document.getElementById('dialog_tag').close();">&nbsp;&nbsp;&nbsp;
	</td>
  <%}%>
</tr>
</table>
</body>
</html>

