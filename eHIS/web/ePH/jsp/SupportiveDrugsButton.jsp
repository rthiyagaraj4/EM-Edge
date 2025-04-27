<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page contentType="text/html;charset=UTF-8" import="ePH.DrugMasterBean, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugMasterDetail.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String source			= request.getParameter("mode");
		String bean_id				=	"DrugMasterBean" ;
		String bean_name			=	"ePH.DrugMasterBean";
		String disable              ="";
		DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
		HashMap supportDrugs =bean.getSupportDrugs();
		if(supportDrugs.size()>0)
		      disable ="";
        else
		      disable ="disabled";
		
%>
		<form name="support_button" id="support_button" >
			<table cellpadding=0 cellspacing=0 width="80%" height="100%" align="center" border="0">
				<tr >
				 <td> </td>
				 <td> </td>
				 <td> </td>
					<td  width="60%" align='right'>
						<input type="button" class="button" value= '<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' name="delete_button"  id="delete_button"onclick="deleteDrug('<%=source%>')" <%=disable%>></input>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

