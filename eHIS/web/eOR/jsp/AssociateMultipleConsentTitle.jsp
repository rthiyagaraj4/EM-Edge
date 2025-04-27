<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<title>
<fmt:message key="eOR.ConsentRequiredfor.label" bundle="${or_labels}"/>- <%=request.getParameter("order_catalog_desc")%>
</title>
<style>
TD.QRYEVEN1{
    BACKGROUND-COLOR: #F0F0F2;  
	FONT-SIZE: 9pt ;
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	

       }

TD.QRYODD1{
	FONT-SIZE: 9pt ;
    BACKGROUND-COLOR: #E2E3F0;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	
	
    }
</style>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_catalog_code = request.getParameter("order_catalog_code");
	order_catalog_code		  = (order_catalog_code == null) ? "":order_catalog_code;
	String order_id			  = request.getParameter("order_id");
	order_id				  = (order_id == null) ? "":order_id;
	String order_line_num	  = request.getParameter("order_line_num");
	order_line_num			  = (order_line_num == null) ? "1":order_line_num;
	String practitioner_id	  = (String)session.getAttribute("ca_practitioner_id");	
	ArrayList multiConsentList	 = new ArrayList();
	String[] multiConsentValues  = null;
	String[] multiConsentDtls	 = null;
	String consent_req_bef_order = "";//added for SRR20056-SCF-2009  Id:  3736 05/06/2008
	String consent_req_bef_regn = ""; //added for SRR20056-SCF-2009  Id:  3736 05/06/2008
	

	String bean_id	 = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	
	multiConsentDtls		= bean.MultiListDtls(order_catalog_code, practitioner_id);
/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
	String multiConsentLine[] = new String[4];
	multiConsentLine=bean.MultiListConsentsLine(order_id,order_line_num);	
	multiConsentList	 = bean.MultiListConsentsdtl(order_catalog_code,order_id,order_line_num, practitioner_id);
/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/
	if(multiConsentList == null || multiConsentList.size()==0)
	{// added for SRR20056-SCF-2009  Id:  3736 05/06/2008
	multiConsentList		= bean.MultiListConsents(order_catalog_code,order_id,order_line_num, practitioner_id);
	consent_req_bef_order = (String) multiConsentDtls[1];
	consent_req_bef_regn = (String) multiConsentDtls[2];
	}else{
		consent_req_bef_order = (String) multiConsentLine[2];
		consent_req_bef_regn = (String) multiConsentLine[3];
	}//added for SRR20056-SCF-2009  Id:  3736  05/06/2008


%>
<form method="post" name="multiple_consent_form" id="multiple_consent_form">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
	<!-- Fixed List Case -->
<%
	if(multiConsentDtls != null){	
	////if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 &&( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1) || (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) > 1) ) ){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
	if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 &&( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn) > 1) ) ){
		for(int i=0;i<multiConsentList.size();i++){
			multiConsentValues = (String[])multiConsentList.get(i);
			if(multiConsentValues[6].equals("F")){%>
				<script>
					//parent.document.getElementById("multiConsentframe").rows='0%,*%,10%';
parent.document.getElementById("multi_title").style.height="12vh";
parent.document.getElementById("multi_detail").style.height="78vh";
parent.document.getElementById("multi_btn").style.height="10vh";

				</script>
			<%}
			if(multiConsentDtls[0].equals("V")){%> 
				<!-- Variable List Case -->
				<!-- Multiple Consent Required Case --><!-- Associated List Exists -->
				<%if(i==0){
					//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008 - multiConsentDtls[1] to consent_req_bef_order and multiConsentDtls[2] to consent_req_bef_regn
					%>
				<tr>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px' colspan=''><B>Required Count :</B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' align='center' colspan=''><B><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=consent_req_bef_order%></label></B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-left:0px' align='left' colspan=''><B><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/>:&nbsp;<label id='before_regist'><%=consent_req_bef_regn%></label></B></td>
				</tr>	
				<tr>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></th>
				</tr>
				<%}
			} break;
		}
		
	}else if( multiConsentDtls[0].equals("V") && ((Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1)||(Integer.parseInt(consent_req_bef_order)+ Integer.parseInt(consent_req_bef_regn) > 1) )){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
	%>
		<!-- Associated List not Exists  -->
			<tr>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px' colspan=''><B><fmt:message key="eOR.RequiredCount.label" bundle="${or_labels}"/>:</B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' align='center' colspan='' nowrap><B><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/>&nbsp;<label id='before_release'><%=consent_req_bef_order%></label></B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-left:0px' align='center' colspan=''><B><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/>&nbsp;<label id='before_regist'><%=consent_req_bef_regn%></label></B></td>
							
			</tr>	
		<script>
		//window.dialogHeight = "8";
		parent.document.getElementById("multiConsentframe").rows='6%,*%,10%';
	</script>	
<%	}else{%>
		<!-- end -->
		<!-- Single Consent Required Case -->
		<tr>
			<td class='CAHIGHERLEVELCOLOR' colspan='3'><B><fmt:message key="eOR.ConsentFormforBeforeOrder.label" bundle="${or_labels}"/> <%=multiConsentDtls[4]%></B></td>
		</tr>
				
	
	<script>
	window.dialogHeight = "8";
	parent.document.getElementById("multiConsentframe").rows='14%,*%,22%';
	</script>
	<% 
		}%>
	
	
		<script>
				parent.multi_detail.location.href = "../../eOR/jsp/AssociateMultipleConsentForms.jsp?<%=request.getQueryString()%>"
		</script>
	<%
	}else{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')); window.close()</script>");
		
	}//end 
	%>	
</table>


</form>
</body>

</html>
	
<%
	putObjectInBean(bean_id,bean,request);

}catch(Exception e){
	//out.println(e.toString());//COMMON-ICN-0181
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
	
	
%>

