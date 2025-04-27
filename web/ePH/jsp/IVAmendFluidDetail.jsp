<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<HTML>
<HEAD>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>

<%

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");

	String patient_class	= request.getParameter("act_patient_class");
	
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String order_id			= (String)ORbean.getOrderId();
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

	HashMap hm_fluid_details = null;
	if(bean.getAmendFluidDetails()==null){
		bean.loadAmendDetails(order_id, patient_id,"");   // RUT-CRF-0062
	}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
		bean.loadAmendDetails(order_id, patient_id,"");  // RUT-CRF-0062
	}
	
	hm_fluid_details = bean.getAmendFluidDetails();

	if(order_id != null || !order_id.equals("") ){
		bean.setOrderID(order_id);		
	}

	String fluid_code = "";
	String fluid_name = "";
	String disableField="";
	String stock_uom_code = "";
	String stock_value ="";
	//String stock_uom   ="";
	//String infuse_over	= "";
	//String infuse_over_unit	= "";

	//String or_mode	=	"";
	String route_code = "";
	String form_code  = "";
	String order_type_code = "";
	if(hm_fluid_details != null){
		if(hm_fluid_details.size()>0){
			disableField = "disabled";
			fluid_code = (String)hm_fluid_details.get("DRUG_CODE");
			fluid_name = (String)hm_fluid_details.get("CATALOG_DESC");
			stock_value	= (String)hm_fluid_details.get("ORDER_QTY");
			//stock_uom   = (String)hm_fluid_details.get("SHORT_DESC");
			//infuse_over	=	(String)hm_fluid_details.get("INFUSE_OVER");
			//infuse_over_unit = (String)hm_fluid_details.get("INFUSE_OVER_UNIT");

			//or_mode = "or_amend";
			route_code = (String)hm_fluid_details.get("ROUTE_CODE");
			form_code  = (String)hm_fluid_details.get("FORM_CODE");
			order_type_code = (String)hm_fluid_details.get("ORDER_TYPE_CODE");
		}
	}
		
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="formIVPrescriptionDetails" id="formIVPrescriptionDetails">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<th align="left" colspan="5"><font style="font-size:9"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></font></th>
	<tr>
		<td   width='45%' align="left">
			<input type="hidden" name="fluid_code" id="fluid_code" VALUE="<%=fluid_code%>">
			&nbsp;<input type="text" name="fluid_name" id="fluid_name" VALUE="<%=fluid_name%>" size="40" maxlength="60" onblur="checkValidDrug('F', this.value)" <%=disableField%>><input type="button" class="button" name="fluid_search" id="fluid_search" value="?" onclick="searchIVFluid(formIVPrescriptionDetails,'D', fluid_name)" <%=disableField%>>
			<img src="../../eCommon/images/mandatory.gif" ></img>
		</td>
		<td   width='8%' align="left" class="label">&nbsp;&nbsp;<fmt:message key="Common.volume.label" bundle="${common_labels}"/>: </td>
		<input type="hidden" name="stock_uom_code" id="stock_uom_code" VALUE="<%=stock_uom_code%>" >
		<%
		if (bean.checkForStock()) {
			if (iv_option.equals("Y")) {
		%>

			<td class='label' align='left' id='stock_display' width='22%'><b></b></td>
			<input type="hidden" name="stock_value" id="stock_value" VALUE="<%=stock_value%>">

		<%
		}
		else {
		%>

			<td class='label' align='left' id='stock_display' width='22%'><b></b></td>
			<input type="hidden" name="stock_value" id="stock_value" VALUE="<%=stock_value%>">

		<%
		}
		%>

			
		<%
		}
		else {
		%>

			<td class='label' align='left' id='stock_display' width='22%'><b></b></td>
			
			<input type="hidden" name="stock_value" id="stock_value" VALUE="<%=stock_value%>">
		<%
		}
		%>
	
		
		</td>
		<td class='label' align='center' width='25%'><fmt:message key="Common.IVAdmixture.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="admixture" id="admixture" onClick="setAdmixtureValue(formIVPrescriptionDetails);"></td>
		</tr>
		<th align="left" colspan="5"><font style="font-size:9">Additive(s)/Drug(s)</font></th>
			
		
	
		</table>
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>">
<input type="hidden" name="base_uom" id="base_uom" value="">

<input type="hidden" name="eqvl_uom_value" id="eqvl_uom_value" value="">
<input type="hidden" name="ORDER_TYPE_CODE" id="ORDER_TYPE_CODE" value="<%=order_type_code%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
<input type="hidden" name="STOCK_VALUE" id="STOCK_VALUE" value="">
<input type="hidden" name="STOCK_UOM_CODE" id="STOCK_UOM_CODE" value="">

<!--<input type="hidden" name="drug_codes" id="drug_codes" value="<%= bean.getDrugCodes() %>">-->
</FORM>
</HTML>
<%
	if(fluid_code!=null && !fluid_code.equals("")){
%>
		<script>
			var bean_id			= document.getElementById("bean_id").value;
			var bean_name		= document.getElementById("bean_name").value;
			var qryString		= bean_id+"&bean_name="+bean_name+"&validate=STOCKDETAILS&drug_code=<%=fluid_code%>&base_uom=MLL";
			submitXML(qryString, "");
		</script>
<%
	}
%>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);
%>

