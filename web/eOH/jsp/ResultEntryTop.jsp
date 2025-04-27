<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="eOH.*" %>
<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style></style>
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	/* Mandatory checks start */

	String mode	= "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	String orderId = request.getParameter("orderId");
	String order_category = request.getParameter("order_category");
	String patient_details="";
	String location="";
	 StringBuffer resultReportingURL = new StringBuffer();
	 resultReportingURL.append(request.getQueryString());

	String[] allValues = new String[12];
/* Mandatory checks end */

	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	allValues = bean.viewMainDetails(orderId);
	String parent_order_id=allValues[11];
	if(parent_order_id == null) parent_order_id="";
	String sex1="";
				
				if (allValues[4].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(allValues[4].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(allValues[8].equalsIgnoreCase("C"))
	{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[8].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}else if(allValues[8].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}

	patient_details=allValues[3]+","+sex1+"/"+allValues[5]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+allValues[6];

	resultReportingURL.append("&parent_order_id="+parent_order_id);

/* Initialize Function specific end */

%>
<input type=hidden name='parent_order_id' id='parent_order_id' value='<%=parent_order_id%>'>	<!-- parent_order_id used only n the case refered from Task List-->
<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true" >
	<jsp:param name ="EncounterId"  value= "<%=allValues[10]%>" />	
</jsp:include> 
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td class='COLUMNHEADERCENTER'><font size='1'><b><%=allValues[0]%></b></font></td>
		<td class='COLUMNHEADERCENTER''><font size='1'><b><%=allValues[1]%>/<%=allValues[2]%></b></font></td>
	</tr>
</table>
</body>
<%if(order_category.equals("PH")){%>
<script>
	parent.ResultEntryReport.location.href = 'ResultEntryReport.jsp?<%=resultReportingURL%>';

	parent.ResultEntryBtn.location.href='ResultEntryBtn.jsp?<%=resultReportingURL%>';
		
	</script>
<%}%>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>



