<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.PrescriptionBean, ePH.Common.*, eCommon.Common.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>
<%	
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../ePH/js/PrescriptionTest.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
    String locale			          = (String)session.getAttribute("LOCALE");
    String presBean_id			      = "PrescriptionBean";
	String presBean_name		      = "ePH.PrescriptionBean";
	PrescriptionBean bean		      = (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	bean.setLanguageId(locale);
	String drug_code		          = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	
%>
		<form name='supportdrugsdetails' id='supportdrugsdetails'>
			<table border="0" align="center" width="100%" cellpadding="0" colspan =1 cellspacing="0">
			    <tr>
				     <td  width ='90%'> &nbsp;</td>
					<td class='white' >&nbsp;<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' 
					class="button" name="btnclose" onClick="formclose()"></td>
			   </tr>
			</table>
			    
				    <input type="hidden" name="bean_id" id="bean_id" value="<%=presBean_id%>">
				    <input type="hidden" name="bean_name" id="bean_name" value="<%=presBean_name%>">
        </form>
	</body>
</html>

