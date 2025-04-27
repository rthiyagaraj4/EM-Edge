<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false" %>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %><!--IN072524-->
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>



<html>
<head>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>



<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='detailUpperForm' id='detailUpperForm' >
<br><br>
<%

try{

	/* Mandatory checks start */
	String mode		  = request.getParameter( "mode" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";

	CareSetBean bean = (CareSetBean)getBeanObject( bean_id, bean_name , request) ;	

	ArrayList  billingRecStr =  bean.getBillingRecStr();



	String ChargeTypeApplicable_style = "display:none";
	String single_selected = "";
	String multi_selected = "";
	String order_set_selected = "";
	String orderable_selected = "";
	String ord_set_charge_pat_yn ="";
	ord_set_charge_pat_yn = (String)bean.getdefaultArrListValue(billingRecStr,0,"ord_set_charge_pat_yn","");
	String fpp_yn			=	request.getParameter( "fpp_yn" ) ;//IN072524
	String fpp_category_visible  ="";//IN072524
%>

<table border="0" cellpadding=0 cellspacing=0 width="75%" height='15%' align="center" >
	<tr>
		<td colspan='5' class="label"></td>
	</tr>
	<tr>
		<td class="label" width="25%">
			<fmt:message key="eOR.Billable.label" bundle="${or_labels}"/>
		</td> 
		<td class="fields" width="25%">
			<input type='hidden' name='bill_yn' id='bill_yn' value='<%=bean.getdefaultArrListValue(billingRecStr,0,"bill_yn","Y")%>'>
			<%
			if (bean.getdefaultArrListValue(billingRecStr,0,"bill_yn","").equalsIgnoreCase("Y"))
			{
				order_set_selected = "selected";
				orderable_selected = "";
			}
			else if (bean.getdefaultArrListValue(billingRecStr,0,"bill_yn","").equalsIgnoreCase("N"))
			{
				order_set_selected = "";
				orderable_selected = "selected";
			}
			else
			{
				order_set_selected = "selected";
				orderable_selected = "";
			}
			%>
			<select name="billable_level" id="billable_level" onChange='parent.parent.parent.showChargeTypeApplicable(this)'><option  value="S" <%=order_set_selected%>><fmt:message key="eOR.OrderSetLevel.label" bundle="${or_labels}"/></option><option  value="O" <%=orderable_selected%>><fmt:message key="eOR.OrderableLevel.label" bundle="${or_labels}"/></option></select>
		</td>
		<td class="label" width="25%">
			<fmt:message key="eOR.Chargable.label" bundle="${or_labels}"/>
		</td> 
		<td class="fields" width="25%">
			<input type="checkbox" name="chargable_yn" id="chargable_yn" value='Y' onclick='parent.parent.parent.chargableYN(this)' <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(billingRecStr,0,"ord_set_charge_pat_yn",""))%>>
		</td>
		<%
			if (bean.getdefaultArrListValue(billingRecStr,0,"bill_yn","").equalsIgnoreCase("Y"))
			{
  				ChargeTypeApplicable_style = "";
  			}
			else if(bean.getdefaultArrListValue(billingRecStr,0,"bill_yn","").equalsIgnoreCase("N"))
			{
			}
			else
			{
				ChargeTypeApplicable_style = "";
			}
		%>
	</tr>
	<tr>
		<td width="25%" id='ChargeTypeApplicable_lbl_td' class="label">
		<%
		if(ChargeTypeApplicable_style.equals(""))
		{
		%>
			<fmt:message key="eOR.chargetypeapplicable.label" bundle="${or_labels}"/>
		<%
		}
		%>
		</td>
		<td width="25%" id='ChargeTypeApplicable_td' nowrap>
		<%
		if(ChargeTypeApplicable_style.equals(""))
		{
			if(bean.getdefaultArrListValue(billingRecStr,0,"charge_type_applicable","").equals("S")||bean.getdefaultArrListValue(billingRecStr,0,"charge_type_applicable","").equals(""))
			{
				single_selected="selected";
				multi_selected="";
			}
			else
			{
				single_selected="";
				multi_selected="selected";
			}%>
			<select name="charge_type_applicable" id="charge_type_applicable"><option  value="S" <%=single_selected%> ><fmt:message key="Common.single.label" bundle="${common_labels}"/></option><option  value="M" <%=multi_selected%>><fmt:message key="eOR.Multi.label" bundle="${or_labels}"/></option></select>
		<%
		}
		%>
		</td>
		<td colspan='1'>&nbsp;</td>
	</tr>
	<!-- //IN072524 Starts -->
	<%if("selected".equals(order_set_selected)){
	fpp_category_visible = "visibility:visible";
	}else{
		fpp_category_visible="";
			
	}%>
	<%if("Y".equals(fpp_yn)){ %>
	<tr>
	  <td width='25%' id='fppCategoryApplicable_lbl_td'  class="label" style="<%=fpp_category_visible%>"><fmt:message key="eOR.FPPCATEGORYS.label" bundle="${common_labels}"/></td>
	  <TD width='25%' id='fppCategoryApplicable_td' style="<%=fpp_category_visible%>" >
	   	  <select name="fpp_category" id="fpp_category">
		   <option  value="S" <%=eHISFormatter.select(bean.getdefaultArrListValue(billingRecStr,0,"fpp_category",""),"S")%>><fmt:message key="eOR.Simple.label" bundle="${common_labels}"/></option>
		   <option  value="M" <%=eHISFormatter.select(bean.getdefaultArrListValue(billingRecStr,0,"fpp_category",""),"M")%>><fmt:message key="eOR.Medium.label" bundle="${common_labels}"/></option>
		   <option  value="C" <%=eHISFormatter.select(bean.getdefaultArrListValue(billingRecStr,0,"fpp_category",""),"C")%>><fmt:message key="eOR.Complex.label" bundle="${common_labels}"/></option>
	   </select>
	   </td>

	</tr>
	<%} %>
	<!-- //IN072524 Ends -->
	<tr>
		<td colspan='5'>&nbsp;</td>
	</tr>

</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="tabType" id="tabType" value="B">
<input type="hidden" name="ord_set_charge_pat_yn" id="ord_set_charge_pat_yn" value="<%=ord_set_charge_pat_yn%>">

</form>
<%
	 putObjectInBean(bean_id,bean,request);
%>
<%}catch(Exception e){
	e.printStackTrace();
}%>

</body>
</html>

