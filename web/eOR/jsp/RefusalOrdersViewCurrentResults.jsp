<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
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

	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String from_dt=request.getParameter("from_dt")==null?"":request.getParameter("from_dt");
	String to_dt=request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String ord_cat_code=request.getParameter("ord_cat_code")==null?"":request.getParameter("ord_cat_code");
	String refusal_type=request.getParameter("refusal_type")==null?"":request.getParameter("refusal_type");
	String practitioner_type = (String)session.getValue("practitioner_type");
	//patient_id="LD00033065";
	
	String classvalue="";
	//String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name , request) ;
	bean.setLanguageId(localeName);
	
	 ArrayList 
	 result=(ArrayList)bean.mainSearchResultOrders(from_dt,to_dt,patient_id,ord_cat_code,refusal_type,practitioner_type);
	//ArrayList result=(ArrayList)bean.mainResultOrders(patient_id);
	
	if( result.size() == 0)
	{ 
%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))</script>
<%
	}
	else
	{
%>	
		<form name="refusalorderresult1" id="refusalorderresult1" >
		<table border="" cellpadding="3" cellspacing="0" width="100%" align="CENTER" class="grid">
<%	
		for(int recCount=0; recCount<result.size(); recCount++) 
		{
			classvalue="gridData";
			String getresult[]=(String[])result.get(recCount);
						
			if(getresult.length >0)
			{
				getresult[11]=getresult[11].replace(',', '.');		
					
%>
				<!-- <tr>
					<td class="<%=classvalue%>" width="35%"><font size="1pt" class="HYPERLINK" onmouseover="changeCursor(this);" onClick="return OrderResultLink('<%=getresult[0]%>','<%=getresult[1]%>','<%=getresult[2]%>','<%=java.net.URLEncoder.encode(getresult[3])%>','<%=getresult[4]%>','<%=getresult[5]%>','<%=getresult[6]%>','<%=getresult[7]%>','<%=getresult[8]%>','<%=getresult[9]%>','<%=getresult[10]%>','<%=getresult[11] %>','<%=getresult[12]%>','<%= getresult[13]%>');"><%=getresult[0]%></font></td>
					<td class="<%=classvalue%>" width="20%"><font size="1pt"><%=getresult[1]%></font></td>
					<td class="<%=classvalue%>" width="30%"><font size="1pt"><%=getresult[2]%></font></td>		<td class="<%=classvalue%>" width="15%" align='center'><font size="1pt"  class='HYPERLINK'  onmouseover="changeCursor(this);" onClick="return resultOrderComments('<%=java.net.URLEncoder.encode(getresult[3]) %>');">Reason</font></td>	
				</tr> -->	

				<tr>
					<td class="<%=classvalue%>" width="20%"><font size="1pt"><%=com.ehis.util.DateUtils.convertDate(getresult[1],"DMYHM","en",localeName)%></font></td>
					<td class="<%=classvalue%>" width="20%"><font size="1pt"><%=(getresult[0]==null?"&nbsp;":getresult[0])%></font></td>
					<td class="<%=classvalue%>" width="20%"><font size="1pt"><a href='#'  class='gridLink'  onClick="return resultOrderComments('<%=java.net.URLEncoder.encode(getresult[3],"UTF-8" ) %>');"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></a></font></td>
					<td class="<%=classvalue%>" width="20%"><font size="1pt"><%=getresult[2]%></font></td>
					<td class="<%=classvalue%>" width="20%" align='center'><font size="1pt"><a class='gridLink'  href='#' onClick="return viewDetails('Or_ReprintFormsBean','eOR.ReprintFormsBean','<%=getresult[8]%>','<%=getresult[9]%>','<%=getresult[10]%>','<%=getresult[13]%>','S');"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></a></font></td>	
				</tr>
<%
			}				
		}
	}

%>
</table>
<script>
if(parent.refusal_main_search){
	parent.refusal_main_search.document.getElementById('search').disabled = false;
	//parent.refusal_main_search.document.refusalsearch_form.search.disabled = false;
}
</script>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

