<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%

	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNWorkSheet.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%

	String order_id		= request.getParameter("order_id");
	if(order_id == null) {order_id = "";}
	String tpn_non_std_regimen_code = request.getParameter("tpn_non_std_regimen_code");
	if(tpn_non_std_regimen_code ==  null){tpn_non_std_regimen_code = "";}

	String overage_vol	= "";
	String readOnly		= "";
	String bean_id		  = "TPNWorkSheetBean";
	String bean_name	  = "ePH.TPNWorkSheetBean";
	TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	String	bean_id1				=	"DispMedicationAllStages" ;
	String	bean_name1				=	"ePH.DispMedicationAllStages";
	DispMedicationAllStages beanAs	= (DispMedicationAllStages)getBeanObject( bean_id1, bean_name1, request);
    beanAs.setLanguageId(locale);
    String billing_interface_yn     =beanAs.checkforbillinginterface();
	overage_vol	= 	beanAs.getOverageVol();

	if(overage_vol == null || overage_vol.equals("")){ 
		overage_vol = ""; 	
		bean.setOverageVolume(order_id);
		overage_vol	= 	bean.getOverageVolume();
	}

	if(overage_vol == null || !overage_vol.equals("")){
		if(overage_vol == null) {overage_vol = "";}
		readOnly  = "readOnly"; 
	}else{
		overage_vol = beanAs.getDfltOvrgVol(tpn_non_std_regimen_code);
		if(overage_vol == null) {overage_vol = "";}
	}
  String width						=  "100%";
	if(billing_interface_yn.equals("Y")){
			width						=  "130%";
	}
%>


<!-- <BODY> -->

<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="formTPNWorkSheetHeader" id="formTPNWorkSheetHeader">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="<%=width%>" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="30%" align="left" CLASS="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><fmt:message key="ePH.OverageVolume.label" bundle="${ph_labels}"/> </b>&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="TEXT" size="1" maxlength="2" name="overage_volume" id="overage_volume" value="<%=overage_vol%>"  <%=readOnly%> onblur="calOvrgeOrdQty(this);">&nbsp;&nbsp;<label ID='overage_uom' width="20%" align='left' STYLE="font-size:9;font-weight:bold;" > </TD>
		<TD WIDTH="1%" colspan="1" STYLE="background-color:white" ></TD>
		<TD WIDTH="49%"></TD>
		<TD WIDTH="1%" STYLE="background-color:white" ></TD>
	</TR>
	<TR height=2>
		<TD ALIGN="left" WIDTH="35%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			<TH COLSPAN="4" ALIGN="left">&nbsp;&nbsp;|&nbsp;<fmt:message key="ePH.DisplaySection.label" bundle="${ph_labels}"/></Td>
			<TR>
				<td class= "COLUMNHEADER" ALIGN="left" WIDTH="2%">.</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="15%"><fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="32%">&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="Common.Actual.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.uom.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="ePH.Overrage.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="14%"><fmt:message key="ePH.AvRecQty.label" bundle="${ph_labels}"/></Td>
			</TR>
			</TABLE>
		</TD>
		<TD ALIGN="left" WIDTH="1%" colspan="1" STYLE="background-color:white">&nbsp;</TD>
		<TD ALIGN="left" WIDTH="50%">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
			 <%if(billing_interface_yn.equals("Y")){%>
			       <td class= "COLUMNHEADER" COLSPAN="6" ALIGN="left"><fmt:message key="ePH.CalculationSection.label" bundle="${ph_labels}"/></Td>
			 <%}else{%>
				   <td class= "COLUMNHEADER" COLSPAN="4" ALIGN="left"><fmt:message key="ePH.CalculationSection.label" bundle="${ph_labels}"/></Td>
			 <%}%>
			<TR>
				<td class= "COLUMNHEADER" ALIGN="right" WIDTH="68%" nowrap >&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Osmolarity.label" bundle="${ph_labels}"/>&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="14%" nowrap>&nbsp;<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="center" WIDTH="14%" nowrap>&nbsp;<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>&nbsp;</Td>
				<td class= "COLUMNHEADER" ALIGN="left" WIDTH="21%" nowrap>&nbsp;<fmt:message key="Common.IssueQuantity.label" bundle="${common_labels}"/> &nbsp;</Td>
                <%if(billing_interface_yn.equals("Y")){%>
				  <td class= "COLUMNHEADER" width="15%" ><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
		           <td class= "COLUMNHEADER" width="15%" ><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
			  <%}%>
			</TR>
			</TABLE>
		</TD>
		<TD ALIGN="left" WIDTH="2%" STYLE="background-color:white">&nbsp;</TD>
	</TR>
	</TABLE>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,beanAs,request);
%>
</FORM>
</BODY>
</HTML>

