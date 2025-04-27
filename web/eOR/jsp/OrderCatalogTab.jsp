<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
10/05/2019  IN068926       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1290																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
-------------------------------------------------------------------------------------------------------------------------------
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*, java.sql.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mndatory declarations end --%>
<%
Connection conlCon		= null;
boolean site = false;
%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css'></link>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function ChangeTabClass(obj,tabName){
	
	document.getElementById("setupTab").className = "normal" ;
	
	if(document.getElementById("timingTab") != null)
	document.getElementById("timingTab").className = "normal";

	document.getElementById("frequencyTab").className = "normal";

	document.getElementById("reviewsTab").className = "normal" ;

	if(document.getElementById("instructionsTab") != null)
	document.getElementById("instructionsTab").className = "normal" ;

	if(document.getElementById("chartingTab") != null){
		//alert();
	document.getElementById("chartingTab").className = "normal" ;
	}

	document.getElementById("settingsTab").className = "normal" ;

	if(document.getElementById("billingTab") != null)
	document.getElementById("billingTab").className = "normal" ;

	if(document.getElementById("prepTab") != null)
	document.getElementById("prepTab").className = "normal" ;

	if(document.getElementById("turnAroundTab") != null)
	document.getElementById("turnAroundTab").className = "normal" ;

	obj.className = "clicked";
}
</script>

<% if(sStyle!=null && sStyle.equals("IeStyle.css")) { %>
<STYLE TYPE="text/css">
	A:active { 	COLOR: white; }
	A:visited { COLOR: white; }
	A:link { COLOR: white; }
</STYLE> 
<%	} %>
</head>
<%
	
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;

//out.println("<script>alert('qrystr="+request.getQueryString()+"');</script>");
	String bill_install_Yn ="N";
	String module_id =bean.checkForNull(request.getParameter("module_id"));
	String order_category =	bean.checkForNull(request.getParameter("order_category"));
	//String mode =	bean.checkForNull(request.getParameter("mode"));
	//out.println("<script>alert('mode="+mode+"');</script>");
	String click_chk_Timing				   = "normal" ;
	//String click_chk_setup				   = "Clicked";
	String StyleDefaultInstrns				   = "" ;
	try{
		
		conlCon = ConnectionManager.getConnection(request);
		site = CommonBean.isSiteSpecific(conlCon, "PH","INSTRUCTIONS_REQUIRED_YN");
		 if(module_id.trim().equalsIgnoreCase("PH") || (!module_id.trim().equalsIgnoreCase("PH") && order_category.trim().equalsIgnoreCase("PH"))){
			// click_chk_setup				   = "normal";
			 click_chk_Timing				   = "clicked" ;
			 StyleDefaultInstrns			   = "display:none" ;//Charting	is tab to be hidden
		 }


    HashMap   billingChk      = bean.getSqlResult("SQL_OR_CHECK_MODULE_INSTALL_YN");
	bill_install_Yn =(String)billingChk.get("INSTALL_YN1");

	if(bill_install_Yn == null)
		bill_install_Yn = "N";

	module_id = bean.checkForNull(request.getParameter("module_id"));
	}catch(Exception e){System.out.println(e);}
//IN068926 starts
String disable="";
String iv_prep_yn=bean.checkForNull(request.getParameter("tpn_item_yn"));//IN068926
String tpn_item_yn=(String)bean.orderCatalogHeaderStr.get("tpn_item_yn")==null?"":(String)bean.orderCatalogHeaderStr.get("tpn_item_yn");//IN068926
//if condtion added for ml-mmoh-crf-1290
if(site&&tpn_item_yn.equals("TPN")||iv_prep_yn.equals("TPN")){
	disable="disabled";
}
//IN068926 ends

%>
<body topmargin="0" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="tab" id="tab">
<table border="1" width="100%" cellspacing="1" cellpadding="3">
<tr>
		
		<td  <%=disable%> id="setupTab" class="normal" width="25%" height="20" onClick='parent.parent.display("C");ChangeTabClass(this,"C")' nowrap><a href='#' ><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></a></td><!--prathyuhsa-->
		<td  <%=disable%> id="timingTab" class="<%=click_chk_Timing%>" width="25%" height="20"  onClick='parent.parent.display("Timing");ChangeTabClass(this,"Timing");' nowrap><a href='#'><fmt:message key="eOR.Timing.label" bundle="${or_labels}"/></a></td><!--prathyuhsa-->
		<td  id="frequencyTab" class="normal"  width="25%" height="20" onClick='parent.parent.display("F");ChangeTabClass(this,"F");' nowrap><a href='#'><fmt:message key="eOR.FrequencyApplicable.label" bundle="${or_labels}"/></a></td>
		<td <%=disable%> id="reviewsTab" class="normal" width="25%" height="20" onClick='parent.parent.display("R");ChangeTabClass(this,"R");' nowrap><a href='#'><fmt:message key="eOR.OrderReviews.label" bundle="${or_labels}"/></a></td><!--prathyuhsa-->
		<td  id="settingsTab" class="normal" width="25%" height="20" onClick='parent.parent.display("Se");ChangeTabClass(this,"Se");' nowrap><a href='#'><fmt:message key="eOR.Settings.label" bundle="${or_labels}"/></a></td>


		
		<td  id="instructionsTab" class="normal" width="25%" height="20" onClick='parent.parent.display("I");ChangeTabClass(this,"I");' nowrap><a href='#'><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></a></td>
		<%--if(!module_id.equalsIgnoreCase("PH")){--%>
		<td  id="chartingTab" class="normal" style="<%=StyleDefaultInstrns%>" width="25%" height="20"  onClick='parent.parent.display("O");ChangeTabClass(this,"O");' nowrap><a href='#'><fmt:message key="Common.CHARTING.label" bundle="${common_labels}"/></a></td>
		<%--}--%>

		<!-- Bllling is hided ....to enable make x => to Y -->
		
		<%// if(bill_install_Yn.equalsIgnoreCase("X")){%>
	<!--  	<td align="center" id="billingTab" class="normal" width="15%" height="20" onClick='return ChangeTabClass(this,"B");parent.parent.display("B")' nowrap><a href='#'>Billing</a></td>-->
		<%//} 
		%> 
		<%if(!order_category.equalsIgnoreCase("PH")){if(!module_id.equalsIgnoreCase("PH")){%>
		<td  id="prepTab" class="normal" width="25%" height="20" onClick='parent.parent.display("P");ChangeTabClass(this,"P");' nowrap ><a href='#'><fmt:message key="eOR.SecondaryTaskPrep.label" bundle="${or_labels}"/></a></td>
		<td  id="turnAroundTab" class="normal" width="30%" height="20" onClick='parent.parent.display("T");ChangeTabClass(this,"T");' nowrap><a href='#'><fmt:message key="eOR.TurnAroundTimeForPriority.label" bundle="${or_labels}"/></a></td>
		<% }} %>
</tr>
</table>

<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="bill_install_Yn" id="bill_install_Yn" value="<%=bill_install_Yn%>">

</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

