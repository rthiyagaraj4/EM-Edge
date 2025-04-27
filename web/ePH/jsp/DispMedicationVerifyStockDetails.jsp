<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>
		<fmt:message key="eST.StockAvailability.label" bundle="${st_labels}"/>
	</title>
</head>
<%
	String	bean_id		    =	"DispMedicationBean" ;
	String	bean_name		=	"ePH.DispMedicationBean";
	
	DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	String store_code = bean.getStoreCode();
	String drug_name  = request.getParameter("drug_name");
	String fluid_name = request.getParameter("fluid_name");
	if(drug_name == null ){drug_name="";}
	if(fluid_name == null ){fluid_name="";}
	String rf_id	  = request.getParameter("rf_id");
	if(rf_id != null || rf_id != "" ){bean.setRFItemDetails(rf_id);}
	ArrayList item_details = bean.getItemDetails();
	ArrayList rf_item_details = bean.getRFItemDetails();
	if(rf_item_details==null){
		rf_item_details = new ArrayList();
	}
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmDispMedicationVerifyStockDetails" id="frmDispMedicationVerifyStockDetails">
	<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" >
		<tr >
			<td class="label" colspan="2">&nbsp;&nbsp;</td>
		</tr>
		<tr >
			<td class="label" >
				<fmt:message key="Common.Store.label" bundle="${common_labels}"/> 
			</td>
			<td class="label" >&nbsp;&nbsp;&nbsp;<b><%=bean.getStoreDesc(store_code)%></b></td>		
		</tr>
		<tr>
			<td  class="COLUMNHEADER" colspan="2" ><fmt:message key="ePH.ItemsForDrug.label" bundle="${ph_labels}"/></td> 
		</tr>
		<tr>
			<td class="label" >
				<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
			</td>
			<td class="label" >&nbsp;&nbsp;&nbsp;<b><%=drug_name%></b></td>		
		</tr>
		<tr>
			<td class="label" >
				<fmt:message key="Common.item.label" bundle="${common_labels}"/>
			</td>
			<td >&nbsp;&nbsp;
				<select name="item_code" id="item_code" onChange="disableEnableWSItem(this)">
					<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<%
					for(int i=0;i<item_details.size();i=i+2){
				%>
					<option value="<%=item_details.get(i)%>"><%=item_details.get(i+1)%></option>
				<%
					}
				%>
				</select>
			</td>		
		</tr>
		<%
			if(fluid_name != null && ! fluid_name.equals("")){
		%>
		<tr>
			<td  class="COLUMNHEADER" colspan="2"><fmt:message key="ePH.ItemsForFluid.label" bundle="${ph_labels}"/></td> 
		</tr>
		<tr>
			<td class="label" >
				<fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/>
			</td>
			<td class="label" >&nbsp;&nbsp;&nbsp;<b><%=fluid_name%></b></td>		
		</tr>
		<%
			if(rf_item_details.size()>0){
		%>
		<tr>
			<td class="label" >
				<fmt:message key="Common.item.label" bundle="${common_labels}"/>
			</td>
			<td >&nbsp;&nbsp;
				<select name="fluid_item_code" id="fluid_item_code" onChange="disableEnableWSItem(this)">
					<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<%
					for(int i=0;i<rf_item_details.size();i=i+2){
				%>
					<option value="<%=rf_item_details.get(i)%>"><%=rf_item_details.get(i+1)%></option>
				<%
					}
				%>
				</select>
			</td>		
		</tr>
		
		<%
		}
			}
		%>
		
		<tr>
			<td colspan="2" >
				<input type="button" name="btnOk" id="btnOk" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="assignItemCode()">
				<input type="button" name="btnCancel" id="btnCancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.returnValue='';window.close()" class="button">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">
	function assignItemCode(){
		var formObj = document.frmDispMedicationVerifyStockDetails;
		if(formObj.item_code.value=="" && formObj.fluid_item_code.value==""){
			alert(getMessage("ePH.ItemSelectionismandatory.label","PH"));
			return false;
		}else if(formObj.item_code.value==""){
			window.returnValue = formObj.fluid_item_code.value+":::"+"RF";
		}else if(formObj.fluid_item_code.value==""){
			window.returnValue = formObj.item_code.value+":::"+"D";
		}
		window.close();
	}
</SCRIPT>

<%
putObjectInBean(bean_id,bean,request);
%>

