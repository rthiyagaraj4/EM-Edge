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
<title>Amend Service</title>
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
			var retObj = {};
			retObj.servQty = $('#qty').val();
			retObj.patPayable = $('#patPayable').val();
			retObj.physicianId = $('#drName').val();
			//alert(JSON.stringify(retObj))
			window.returnValue = JSON.stringify(retObj);
			window.close();
		});
	});
	
	function updateNetAmount(){
		//alert('To be done');
		var srchFrm = document.amendFrm;
		var episodeType = $('#episodeType').val();
		var episodeId = $('#episodeId').val();
		var visitId = $('#visitId').val();
		var patientId = $('#patientId').val();
		var encounterId = $('#encounterId').val();
		var rateIndicator = 'R';
		var servPanelCode = $('#servCode').val();
		var servOrPanel = $('#servOrPanel').val();
		var acctSeqNo = $('#acctSeqNo').val();
		var servPanelDesc = $.trim($('#servPanelDesc').text());
		var quantity = $('#qty').val();
		$.ajax({
			type:"GET",
			url:"../jsp/BLChargePatientNewOrderPersistence.jsp",
			data:"func_mode=updateServiceDetails&servOrPanel="+servOrPanel+
					"&episodeType="+episodeType+
					"&episodeId="+episodeId+
					"&visitId="+visitId+
					"&patientId="+patientId+
					"&encounterId="+encounterId+
					"&servPanelCode="+servPanelCode+
					"&servPanelDesc="+encodeURIComponent(servPanelDesc)+
					"&rateIndicator="+rateIndicator+"&quantity="+quantity+"&acctSeqNo="+acctSeqNo,
			dataType:"json",
			success: function(responseText){
				if(responseText.Success == 'Y'){
					$('#grossAmt').val(responseText.GrossAmount);
					$('#total').val(responseText.NetChargeAmount);
					$('#patPayable').val(responseText.PatNetChargeAmount);
					$('#servDisc').val(responseText.PatDiscAmount);
					//findTotal();
				}
				else{
					alert(responseText.Error);
				}
			},
			error: function(data){
				//alert(data);
			}
			
		});
		/*var temp_jsp="../jsp/BLChargePatientNewOrderPersistence.jsp?func_mode=updateServiceDetails&servOrPanel="+servOrPanel+
					"&episodeType="+episodeType+
					"&episodeId="+episodeId+
					"&visitId="+visitId+
					"&patientId="+patientId+
					"&encounterId="+encounterId+
					"&servPanelCode="+servPanelCode+
					"&servPanelDesc="+encodeURIComponent(servPanelDesc)+"&rateIndicator="+rateIndicator+"&quantity="+quantity+"&acctSeqNo="+acctSeqNo;
		var xmlStr ="<root><SEARCH ";				
		xmlStr +=" /></root>";
		//alert(temp_jsp)
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		//alert(xmlHttp.responseText)
		var responseText=JSON.parse(xmlHttp.responseText);
		//alert(responseText);
		if(responseText.Success == 'Y'){
			$('#grossAmt').val(responseText.GrossAmount);
			$('#total').val(responseText.NetChargeAmount);
			$('#patPayable').val(responseText.PatNetChargeAmount);
			$('#servDisc').val(responseText.PatDiscAmount);
			//findTotal();
		}
		else{
			alert(responseText.Error);
		}*/
	}

	function updateNetAmountForCharge(){
		var obj = $('#grossAmt').val();
		if ( trimCheck(obj) && isNaN(obj) == false && obj >= 0) {
			 $('#total').val(obj);
			 $('#patPayable').val(obj);
	    }
	    else {
	        if ( obj.length > 0 ) {
	            alert(getMessage("NUM_ALLOWED", "SM"));
	            $('#grossAmt').val('');
	            return false;
	        }
	    }
	}
</script>
<style>
	.circle{
		border-top-le
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
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
</head>
<body>
	<form id='amendFrm' name='amendFrm' id='amendFrm' action="../servlet/eBL.BLExistingOrderServlet" method="post">
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
				<%="R".equals(serviceBean.getRateIndicator())?"Rate":"Charge" %>
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
			<td class='COLUMNHEADER' nowrap colspan="6">
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
					<fmt:message bundle="${bl_labels }" key="eBL.GROSS_AMT.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.BILLING_SERVICE_DISC.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${common_labels }" key="Common.total.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${common_labels }" key="Common.PatientPayable.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					 <fmt:message bundle="${bl_labels }" key="eBL.DrName.label"></fmt:message> 
				</td>	
		</tr>
		<tr>
				<td nowrap="nowrap" class='fields'>
					<input type='text' name='rate' id='rate' size="10" readonly value="<%=serviceBean.getBaseRate() %>" >
				</td>
				<%if("R".equals(serviceBean.getRateIndicator())){ %>
					<td  nowrap="nowrap" class='fields'>
						<input type='text' id='qty' name='qty' id='qty' size="3" maxlength="3"  value="<%=serviceBean.getServQty() %>" onblur="updateNetAmount();">
					</td>
					<td  nowrap="nowrap" class='fields'>
						<input type='text' name='grossAmt' id='grossAmt' id='grossAmt' size="10"  readonly value="<%=serviceBean.getBaseChargeAmount() %>" >
					</td>
				<%} else{ %>
					<td  nowrap="nowrap" class='fields'>
						<input type='text' id='qty' name='qty' id='qty' size="3" maxlength="3" readonly value="<%=serviceBean.getServQty() %>" >
					</td>
					<td  nowrap="nowrap" class='fields'>
						<input type='text' name='grossAmt' id='grossAmt' id='grossAmt' size="10"  value="<%=serviceBean.getBaseChargeAmount() %>" onblur="updateNetAmountForCharge();">
					</td>
				<%} %>
				
				<td class='LABEL' nowrap="nowrap" class='fields'>
					<input type='text' name='servDisc' id='servDisc' id='servDisc' size="10" readonly value="<%=serviceBean.getServDiscount() %>" >
				</td>
				<td class='LABEL' nowrap="nowrap" class='fields'>
					<input type='text' id='total' name='total' id='total' size="3" readonly value="<%=serviceBean.getBaseChargeAmount() %>" >
				</td>
				<td class='LABEL' nowrap="nowrap" class='fields'>
					<input type='text' id='patPayable' name='patPayable' id='patPayable' size="3" readonly value="<%=serviceBean.getBaseChargeAmount() %>" >
				</td>
				<td class='LABEL' nowrap="nowrap" class='fields'>
					<input type='text' name='drName' id='drName' id='drName' size="10" onblur="callCommonValidation(1,drName,docNam)" value="<%=replaceNull(serviceBean.getPhysicianId()) %>" >&nbsp;
					<input type='hidden' name='docNam' id='docNam' value="">
					<input type='button'  id='drName_but' value='?' onclick='callCommonValidation(1,drName,docNam)'>
				</td>
				
		</tr>
	</table>
	<br/>
	<span style="padding-left: 40px;">&nbsp;</span><input type='button' value='Record' id='btnRecord' class='button'>
	<input type='hidden' id='episodeType' value='<%=serviceBean.getEpisodeType() %>'>
	<input type='hidden' id='episodeId' value='<%=serviceBean.getEpisodeId() %>'>
	<input type='hidden' id='patientId' value='<%=serviceBean.getPatientId() %>'>
	<input type='hidden' id='visitId' value='<%=serviceBean.getVisitId() %>'>
	<input type='hidden' id='encounterId' value='<%=serviceBean.getEncounterId() %>'>
	<input type='hidden' id='servCode' value='<%=serviceBean.getServCode() %>'>
	<input type='hidden' id='servOrPanel' value='<%=serviceBean.getServOrPanel() %>'>
	<input type='hidden' id='acctSeqNo' value='<%=serviceBean.getAcctSeqNo() %>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
     <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
	</form>
</body>
</html>

