<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>


<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>

<%
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");

	String patient_class	= request.getParameter("act_patient_class");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	//String serialNum		=	"";
	// serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");
	
	String form_code		=	"";
	String route_code		=	"";
	String order_type_code	=	"";

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
	String order_id			= (String)ORbean.getOrderId();
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

	HashMap hm_fluid_details = null;
	if(bean.getAmendFluidDetails()==null){
		bean.loadAmendDetails(order_id, patient_id,"");  //RUT-CRF-0062
	}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
		bean.loadAmendDetails(order_id, patient_id,"");  //RUT-CRF-0062
	}
	
	hm_fluid_details = bean.getAmendFluidDetails();

	if(order_id != null || !order_id.equals("") ){
		bean.setOrderID(order_id);		
	}
	String mode = request.getParameter("mode");
	
	String fluid_code = "";

	if(hm_fluid_details != null){
		if(hm_fluid_details.size()>0){
			fluid_code = (String)hm_fluid_details.get("DRUG_CODE");
			;
		}
	}
		
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="formIVPrescriptionDetails" id="formIVPrescriptionDetails">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	<th colspan="5"><font style="font-size:9"><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></font></th>
	<tr>
		<td   width='40%' >
			<input type="hidden" name="fluid_code" id="fluid_code" value="">
			&nbsp;<input type="text" name="fluid_name" id="fluid_name" value="" size="40" maxlength="60" onblur="checkValidDrug('F', this.value)" ><input type="button" class="button" name="fluid_search" id="fluid_search" value="?" onclick="searchIVFluid(formIVPrescriptionDetails,'D', fluid_name)" >
			<img src="../../eCommon/images/mandatory.gif" ></img>
		</td>
		<td   width='7%' class="label">&nbsp;&nbsp;<fmt:message key="Common.volume.label" bundle="${common_labels}"/>: </td>
		<input type="hidden" name="stock_uom_code" id="stock_uom_code" value="" >
		<%
		if (bean.checkForStock()) {
			if (iv_option.equals("Y")) {
		%>

			<td class='label' id='stock_display' width='10%'><b>&nbsp;</b></td>
			<input type="hidden" name="stock_value" id="stock_value" value="">

		<%
		}
		else {
		%>

			<td class='label' id='stock_display' width='10%'><b>&nbsp;</b></td>
			<input type="hidden" name="stock_value" id="stock_value" value="">

		<%
		}
		%>

			
		<%
		}
		else {
		%>

			<td class='label' id='stock_display' width='10%'><b>&nbsp;</b></td>
			
			<input type="hidden" name="stock_value" id="stock_value" value="">
		<%
		}
		%>
	
		
		</td>
		<td class='label' ><fmt:message key="Common.IVAdmixture.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="admixture" id="admixture"></td>
		</tr>
			
		</table>

		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		
		<tr>
	<th  width='35%' ><font style="font-size:9">&nbsp;<fmt:message key="ePH.Additive.label" bundle="${ph_labels}"/>/<fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/>&nbsp;</font></th>
		<th  width='40%' ><font style="font-size:9">&nbsp;&nbsp;</font></th>
		<th  width='5%'  ><font style="font-size:9">&nbsp;<fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>&nbsp;</font></th>
		<th  width='7%'	 ><font style="font-size:9">&nbsp;&nbsp;</font></th>
		<th  width='1%'  ><font style="font-size:9">&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/>&nbsp;</font></th>
		<th  width='7%'  ><font style="font-size:9">&nbsp;&nbsp;</font></th>
		<th  width='5%'  ><font style="font-size:9">&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;</font></th>

		</tr>
		<tr>
		<td  width='35%' >&nbsp;<input type="text" name="drug_name_1" id="drug_name_1" value="" size="40" maxlength="40" ><input type="button" class="button" name="drug_search_1" id="drug_search_1" value="?" onblur="checkValidDrug('D', this.value)" onclick="searchIVDrugs('D', drug_name_1,1)" >
		<input type="hidden" name="drug_code_1" id="drug_code_1" value="">
		</td>		
		<td width='40%'>&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img><img src="../../eCommon/images/mandatory.gif" ></img><img src="../../eCommon/images/mandatory.gif" ></img>&nbsp;<input class='button' type="button" value="Override">&nbsp;</td>
		<td  width='5%' > <input type="text" size="3" maxlength="5" name='dose_1' id='dose_1' value=""></td>
		<td  width='7%' id="dose_uom_1"> &nbsp;</td>
		<td  width='1%'> <input type="text" size="1" maxlength="2" name='qty_1' id='qty_1' disabled> </td>
		<td  width='7%' id="qty_uom_1"> &nbsp;</td>
		<td  width='5%' align='center'> <input type="checkbox"  name='select_1' id='select_1'> </td>
		</tr>
		<tr>
		<td  width='35%' >&nbsp;<input type="text" name="drug_name_2" id="drug_name_2" value="" size="40" maxlength="60" ><input type="button" class="button" name="drug_search_2" id="drug_search_2" value="?" onblur="checkValidDrug('D', this.value)" onclick="searchIVDrugs('D', drug_name_2,2)" >
		<input type="hidden" name="drug_code_2" id="drug_code_2" value="">
		</td>	
		<td width='40%'>&nbsp;</td>
		<td  width='5%' > <input type="text" size="3" maxlength="5" name='dose_2' id='dose_2' value=""> </td>	
		<td  width='7%' id="dose_uom_2"> &nbsp;</td>
		<td  width='1%'> <input type="text" size="1" maxlength="2" name='qty_2' id='qty_2' disabled> </td>
		<td  width='7%' id="qty_uom_2"> &nbsp;</td>
		<td  width='5%' > <input type="checkbox" size="5" maxlength="7" name='select_2' id='select_2'> </td>
		</tr>
		<tr>
		<td  width='35%' >&nbsp;<input type="text" name="drug_name_3" id="drug_name_3" value="" size="40" maxlength="60" ><input type="button" class="button" name="drug_search_3" id="drug_search_3" value="?" onblur="checkValidDrug('D', this.value)" onclick="searchIVDrugs('D', drug_name_3,3)" >
		<input type="hidden" name="drug_code_3" id="drug_code_3" value="">
		</td>		
		<td width='40%'>&nbsp;</td>
		<td  width='5%' > <input type="text" size="3" maxlength="5" name='dose_3' id='dose_3' value=""> </td>	
		<td  width='7%' id="dose_uom_3"> &nbsp;</td>
		<td  width='1%'> <input type="text" size="1" maxlength="2" name='qty_3' id='qty_3' disabled> </td>
		<td  width='7%' id="qty_uom_3"> &nbsp;</td>
		<td  width='5%' > <input type="checkbox" name='select_3' id='select_3'></td>
		</tr>
		<tr>
		<td  width='35%' >&nbsp;<input type="text" name="drug_name_4" id="drug_name_4" value="" size="40" maxlength="60" ><input type="button" class="button" name="drug_search_4" id="drug_search_4" value="?" onblur="checkValidDrug('D', this.value)" onclick="searchIVDrugs('D', drug_name_4,4)" >
		<input type="hidden" name="drug_code_4" id="drug_code_4" value="">
		</td>		
		<td width='40%'>&nbsp;</td>
		<td  width='5%' > <input type="text" size="3" maxlength="5" name='dose_4' id='dose_4' value=""> </td>	
		<td  width='7%' id="dose_uom_4"> &nbsp;</td>
		<td  width='1%'> <input type="text" size="1" maxlength="2" name='qty_4' id='qty_4' disabled> </td>
		<td  width='7%' id="qty_uom_4"> &nbsp;</td>
		<td width='5%' ><input type="checkbox" name='select_4' id='select_4'></td>
		</tr>
		<tr>
		<td  width='35%' >&nbsp;<input type="text" name="drug_name_5" id="drug_name_5" value="" size="40" maxlength="60" ><input type="button" class="button" name="drug_search_5" id="drug_search_5" value="?" onblur="checkValidDrug('D', this.value)" onclick="searchIVDrugs('D', drug_name_5,5)" >
		<input type="hidden" name="drug_code_5" id="drug_code_5" value="">
		</td>		
		<td width='40%'>&nbsp;</td>
		<td  width='5%' > <input type="text" size="3" maxlength="5" name='dose_5' id='dose_5' value=""> </td>	
		<td  width='7%' id="dose_uom_5"> &nbsp;</td>
		<td  width='1%'> <input type="text" size="1" maxlength="2" name='qty_5' id='qty_5' disabled> </td>
		<td  width='7%' id="qty_uom_1"> &nbsp;</td>
		<td  width='5%' > <input type='checkbox' name='select_5' id='select_5'></td>
		</tr>
		
		</table>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		<th align="left" colspan="11"><font style="font-size:9"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></font></th>
		<tr>
		<td class='label'><fmt:message key="ePH.InfusionRate.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td >
		<input type="text" class="number" size="2" maxlength="3" name="infusion_value" id="infusion_value" onBlur="CheckNum(this)" onKeyPress="return allowValidNumber(this,event,3,0);">
		</td>
		<td width='6%'>&nbsp;&nbsp;</td>
		<td class='label'><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td >
		<input type="text" class="number" size="2" maxlength="2" name="infusion_over" id="infusion_over" onKeyPress="return allowValidNumber(this,event,2,0);" onBlur="CheckNum(this);checkHr(infusion_over);chkDuration(this,'<%=mode%>')">
		</td>
		<td width='6%'>&nbsp;&nbsp;</td>
		<td class='label'><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>&nbsp;</td>
		<td >
		<input type="text" name="START_DATE" id="START_DATE" value="" size="12" maxlength="12" onblur="resetInfuse()"><img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('START_DATE',null,'hh:mm');return false;" >&nbsp; <img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class='label'><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>
		<input type="text" name="END_DATE" id="END_DATE" value="" size="12" maxlength="12" readonly>&nbsp; 
		</td>

		</table>
		

<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>">
<input type="hidden" name="base_uom" id="base_uom" value="">
<input type="hidden" name="eqvl_uom_code" id="eqvl_uom_code" value="">
<input type="hidden" name="eqvl_uom_value" id="eqvl_uom_value" value="">
<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
<input type="hidden" name="drug_codes" id="drug_codes" value="<%= bean.getDrugCodes() %>">
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

