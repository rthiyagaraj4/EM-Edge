<!DOCTYPE html>
<%@page import="eBL.placeorder.model.BLChargePatientExistingOrderBean"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language="JavaScript" src="../../eBL/js/BLChargePatient.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(event){
		$('#btnRecord').click(function(){
			var indicator = $('#amt_limit_ind').val();
			var grossAmt = $('#grossAmt').val();
			var discValue = $('#adhocDiscAmt').val();
			var discAmt = '';
			var retObj = {};
			if(indicator == 'P'){
				discAmt = grossAmt*discValue/100;
			}
			else{
				discAmt = discValue;
			}
			retObj.adhocDiscAmt = roundToTwo(discAmt);
			retObj.patPayable = $('#patPayable').val();
			retObj.discReason = $('#discReason').val();
			//alert(JSON.stringify(retObj))
			window.returnValue = JSON.stringify(retObj);
			window.close();
		});
		
		$('#amt_limit_ind').change(function(){
			calcPatPayable(document.getElementById("adhocDiscAmt"));
		});
		
		if($('#adhocDiscAmt').val() != ''){
			$('#amt_limit_ind').val('A');
		}
	});		
	
	
	function roundToTwo(num) {    
	    return +(Math.round(num + "e+2")  + "e-2");
	}	
	
	function calcPatPayable(obj) {
		var patPayable = '';
		var amt_limit_ind = $('#amt_limit_ind').val();
		if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	    	if(amt_limit_ind != ''){
	    		var grossAmt = $('#grossAmt').val();
	    		var servDisc = $('#servDisc').val();
	    		var discVal = obj.value;
	    		//alert(grossAmt +','+servDisc+','+discVal)
	    		if(amt_limit_ind == 'A'){
	    			patPayable = grossAmt - (parseInt(servDisc)  + parseInt(discVal));	    	    	
	    		}
	    		else{
	    			patPayable = (grossAmt - servDisc ) - (grossAmt * discVal / 100);	    	
	    		}
	    		if(patPayable<0){
		    		alert('Discount Amount should be Lesser than '+grossAmt);
		    		$('#amt_limit_ind').val('');
		    		obj.value = '0';
		    		$('#patPayable').val($('#hdnPatPayable').val());
		    	}
		    	else{
		    		patPayable = roundToTwo(patPayable);
		    		$('#patPayable').val(patPayable);
		    	}
		        return true;
	    	}
	    	else{
	    		alert('Please choose Amount / Percent Indicator');
	    		obj.value = '0';
	    		$('#patPayable').val($('#hdnPatPayable').val());
	    		return false;
	    	}
	    	
	    }
	    else {
	        if ( obj.value.length > 0 ) {

	            alert(getMessage("NUM_ALLOWED", "SM"));
	            obj.value = '';
	            return false;
	        }
	    }
	}
</script>
<style>
	TD.LABEL
	{
			FONT-SIZE: 8pt ;
			FONT-FAMILY : verdana;
			color : #000000;
	}
</style>
<%
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String beanId = "BLChargePatientExistingOrderBean" ;
String beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";
BLChargePatientExistingOrderBean serviceBean = (BLChargePatientExistingOrderBean) getObjectFromBean(beanId, beanName, session);

%>

<%!
private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body>
	<form id='amendFrm' name='amendFrm' id='amendFrm' action="../../servlet/eBL.BLExistingOrderServlet" method="post">
	<table width='90%' align="center">
		<tr>
			<td width='25%' class='LABEL'>
				<fmt:message key="Common.patientId.label" bundle="${common_labels}" />
			</td>
			<td width='25%' class='LABEL'>
				<%=serviceBean.getPatientId() %>
			</td>
			<td width='25%' class='LABEL' nowrap="nowrap">
				<fmt:message
						key="Common.encounterid.label" bundle="${common_labels}" />
			</td>
			<td width='25%' class='LABEL'>
				<%=serviceBean.getEncounterId() %>
			</td>
		</tr>
		<tr>
			<td width='25%' class='LABEL'>
				<fmt:message key="eBL.DOCTOR_NAME.label" bundle="${common_labels}" /></td>
			</td>
			<td width='25%' class='LABEL'>
				<%=replaceNull(serviceBean.getPhysicianId()) %>
			</td>
			<td width='25%' class='LABEL'>
				Transaction Date
			</td>
			<td width='25%' class='LABEL'>
				<%=sdf.format(new java.util.Date()) %>
			</td>
		</tr>
		<tr>
			<td width='25%' class="LABEL">
				<fmt:message key="eBL.EPISODE_TYPE.label" bundle="${bl_labels}"></fmt:message>
			</td>
			<td width='25%' class='LABEL'>
				<%=serviceBean.getEpisodeType() %>
			</td>
			<td width='25%' class='LABEL'>
			<fmt:message
						key="Common.episodeid.label" bundle="${common_labels}" />
			</td>
			<td width='25%' class='LABEL'>
				<%=serviceBean.getEpisodeId() %>
			</td>
		</tr>
		<tr>
			<td width='25%' class='LABEL'>
				<fmt:message key="eBL.BILLING_SERVICE_PANEL.label" bundle="${bl_labels}"></fmt:message>
			</td>
			<td width='25%' class='LABEL'>
				<%="S".equals(serviceBean.getServOrPanel())?"Service":"Panel" %>
			</td>
			<td width='25%' class='LABEL'>
			<fmt:message
						key="eBL.BL_RATE_CHARGE_TYPE.label" bundle="${bl_labels}" />
			</td>
			<td width='25%' class='LABEL'>
			</td>
		</tr>
		<tr>
			<td width='25%' class='LABEL'>
				<fmt:message bundle="${bl_labels }" key="eBL.ServiceCode.label"></fmt:message>
			</td>
			<td width='25%' class='LABEL'>
				<%=serviceBean.getServCode() %>
			</td>
			<td width='25%' class='LABEL'>
				<fmt:message bundle="${bl_labels }" key="eBL.ServiceDescription.label"></fmt:message>
			</td>
			<td width='25%' class='LABEL' id='servPanelDesc'>
				<%=serviceBean.getServDesc() %>
			</td>
		</tr>
		
		<tr>
			<td width='25%' class='LABEL'>
				Order No
			</td>
			<td width='25%' class='LABEL'>
				<%=serviceBean.getOrderId() %>
			</td>
			<td width='25%' class='LABEL'>
				Order Line No
			</td>
			<td width='25%' class='LABEL' id='servPanelDesc'>
				<%=serviceBean.getOrderLineNum() %>
			</td>
		</tr>
		
	</table>
	<br/>
	<br/>
	<table class='grid' border='1' width='90%' cellpadding='3'  cellspacing=0 align="center" id='AmendTable'>
		<tr>
			<td class='COLUMNHEADER' nowrap colspan="4">
				&nbsp;
			</td>
			<td class='COLUMNHEADER' nowrap colspan="2" align="center">
				Adhoc Discount
			</td>
			<td class='COLUMNHEADER' nowrap colspan="2">
				&nbsp;
			</td>
		</tr>
		<tr>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.RATE.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.QTY.label"></fmt:message>
				</td>			
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message key="eBL.ServiceAmount.label" 					bundle="${bl_labels}"	/>
				</td>		
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message key="eBL.SERVICE_DISC_AMT.label" 				bundle="${bl_labels}"	/>
				</td>
				
				<td class='COLUMNHEADER'  nowrap>
					<fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/>
				</td>
				<td class='COLUMNHEADER'  nowrap>
					<fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/>
				</td>
							
				<td nowrap="nowrap" class='COLUMNHEADER'>
					Reason
				</td>									
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${common_labels }" key="Common.PatientPayable.label"></fmt:message>
				</td>
		</tr>
		<tr>		
				<td nowrap="nowrap" class='fields'>
					<input type='text' name='rate' id='rate' size="10" readonly value="<%=serviceBean.getBaseRate() %>" >
				</td>		
				<td  nowrap="nowrap" class='fields'>
					<input type='text' id='qty' name='qty' id='qty' size="3" maxlength="3"  value="<%=serviceBean.getServQty() %>" readonly>
				</td>
				<td  nowrap="nowrap" class='fields'>
					<input type='text' name='grossAmt' id='grossAmt' id='grossAmt' size="10" readonly value="<%=serviceBean.getBaseChargeAmount() %>" >
				</td>	
				<td  nowrap="nowrap" class='fields'>
					<input type='text' name='servDisc' id='servDisc' id='servDisc' size="10" readonly value="<%=serviceBean.getServDiscount() %>" >
				</td>
				<td nowrap="nowrap" class='fields'>
					<select name='amt_limit_ind' id='amt_limit_ind' id='amt_limit_ind'>
						<option value=''  >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='A' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
						<option value='P' ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
					</select>
				</td>							
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' id='adhocDiscAmt' name='adhocDiscAmt' id='adhocDiscAmt' size="10"  value="<%=serviceBean.getAdhocDiscount() %>" onblur="if(this.value != ''){calcPatPayable(this); }">
				</td>
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' name='discName' id='discName' id='discName' size="10" onblur="callCommonValidation(2,discName,discReason)" value="" >&nbsp;
					<input type='hidden' name='discReason' id='discReason' id='discReason' value=''>
					<input type='button'  id='discount_but' value='?' onclick='callCommonValidation(2,discName,discReason)'>
				</td>
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' id='patPayable' name='patPayable' id='patPayable' size="10" readonly value="<%=serviceBean.getNetCharge() %>" >
					<input type='hidden' id='hdnPatPayable' name='hdnPatPayable' id='hdnPatPayable'  value="<%=serviceBean.getNetCharge() %>" >
				</td>
		</tr>
	</table>
	<br/>
	<span style="padding-left: 22px;">&nbsp;</span><input type='button' value='Record' id='btnRecord' class='button' >
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
    <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
	</form>
</body>
</html>

