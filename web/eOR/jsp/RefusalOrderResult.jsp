<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		request.setCharacterEncoding("UTF-8");
		String patient_id=request.getParameter("patient_id");

		String classvalue="";
		//String mode	   = request.getParameter("mode") ;
		//String function_id = request.getParameter( "function_id" ) ;
		String bean_id = "refusalOrdersBean" ;
		String bean_name = "eOR.RefusalOrdersBean";
		RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name , request) ;
				bean.setLanguageId(localeName);

		ArrayList result=(ArrayList)bean.mainResultOrders(patient_id);
	%>
<form name="refusalorderresult1" id="refusalorderresult1" >
	<table border="" cellpadding="3" cellspacing="0" width="98%" align="left" class="grid">
	<%	
	for(int recCount=0; recCount<result.size(); recCount++) {
           /* if ( recCount % 2 == 0 )
                classvalue = "QRYODD" ;
            else
                classvalue = "QRYEVEN" ;*/
				classvalue="gridData";
					String getresult[]=(String[])result.get(recCount);
					
				if(getresult.length >0)
				{
					getresult[11]=getresult[11].replace(',', '.');
					
					
			%>
		<tr>
			<td class="<%=classvalue%>" width="35%"><font size="1pt"><a class="gridLink"   href='#' onClick="return OrderResultLink('<%=getresult[0]%>','<%=getresult[1]%>','<%=getresult[2]%>','<%=getresult[3]%>','<%=getresult[4]%>','<%=getresult[5]%>','<%=getresult[6]%>','<%=getresult[7]%>','<%=getresult[8]%>','<%=getresult[9]%>','<%=getresult[10]%>','<%=getresult[11] %>','<%=getresult[12]%>','<%= getresult[13]%>');"><%=getresult[0]%></a></font></td>
			<td class="<%=classvalue%>" width="20%"><font size="1pt"><%=getresult[1]%></font></td>
			<td class="<%=classvalue%>" width="30%"><font size="1pt"><%=getresult[2]%></font></td>		<td class="<%=classvalue%>" width="15%" align='center'><font size="1pt"><a  class='gridLink'   href='#' onClick="return resultOrderComments('<%=getresult[3] %>');"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></a></font></td>	
		</tr>	

			<%
					}	
			
		}

%>
</table>

</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

