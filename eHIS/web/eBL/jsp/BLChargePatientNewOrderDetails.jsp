<!DOCTYPE html>

<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eBL.placeorder.model.BLChargePatientNewOrderBean"%>
<%@page import="webbeans.op.CurrencyFormat"%> 
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%!
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

private String qtydecimal(String input)
{
		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
}
%>
<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
BLChargePatientNewOrderBean chargeBean = null;
String beanId = "BLChargePatientNewOrderBean";
String beanName = "eBL.placeorder.model.BLChargePatientNewOrderBean";
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date dt = new Date();
String today = "";//sdf.format(dt);
String setServDiscount="0";
String setPatNetChargeAmt="";
String setNetChargeAmount="";

ArrayList<BLChargePatientNewOrderBean> serviceList = null;
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;
try{
	chargeBean = (BLChargePatientNewOrderBean) getObjectFromBean(beanId, beanName, session);
	serviceList = chargeBean.getServicesList();
	if(serviceList == null){
		serviceList = new ArrayList<BLChargePatientNewOrderBean>();
	}
	
	con = ConnectionManager.getConnection();
	pstmt = con.prepareStatement("Select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') today from dual");
	rst = pstmt.executeQuery();
	if(rst != null && rst.next()){
		today = rst.getString("today");
	}
}
catch(Exception e){
	System.err.println("Exception in BLChargePatientNewOrderDetails.jsp ->"+e);
}
finally{
	pstmt = null;
	rst = null;
	ConnectionManager.returnConnection(con);
}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../js/BLChargeEncounterNewOrder.js'></script>
<script language="JavaScript" src="../../eBL/js/BLChargePatient.js"></script>
<script language='javascript' src='../js/json2.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>

<script language='javascript'>
	$(document).ready(function(){
		$('td[id^=rcrdAdhiocDisc]').each(function(){
			$(this).hide();		
		});
		findTotal();	
		
		$('td[id^=rcrdAdhocDiscPP]').each(function(){
			$(this).hide();		
		});
		
		$('td[id^=rcrdAdhocDiscAR]').each(function(){
			$(this).hide();		
		});
		
		
var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();
		
		//alert("noOfDecimals "+noOfDecimals);
		
		$('[id^=rate_] ').each(function(){
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
		
		$('[id^=grossAmt_] ').each(function(){
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
	$('[id^=qty_] ').each(function(){
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
		

		$('[id^=total_] ').each(function(){
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
		

		$('[id^=patPayable_] ').each(function(){
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
		
$('[id^=patPaid_] ').each(function(){
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
		
		
		
$('[id^=addlCharges_] ').each(function(){
			
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		
	});
		
$('[id^=servDisc_] ').each(function(){
	if($(this).val() != ''){
		putDecimal($(this).get(0),17,noOfDecimals);				
	}
	else{
		$(this).val('0');
		putDecimal($(this).get(0),17,noOfDecimals);
	}

});

		
		$('[id^=net_amount]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text_WOR($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text_WOR($(this),17,noOfDecimals);
			}
		});
		
		$('[id^=pat_payable_amount]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text_WOR($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text_WOR($(this),17,noOfDecimals);
			}
		});
		
		
		

		
	});	
	
async function captureRemarks(indx){

		var dialogHeight= "23vh" ;
	    var dialogWidth      = "26vw" ;
	    var dialogTop = "200" ;
	    var center = "1" ;                                                                                              
	    var status="no";
	    var features  = "overflow:auto; scrollbars:no; dialogHeight:"+dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	    var arguments = "" ;                 
		var remarks = $('#remarksDtl_'+indx).val();
	
        var retVal =await window.showModalDialog("../../eBL/jsp/BLCaptureRemarks.jsp?remarks="+encodeURIComponent(remarks),arguments,features);   
        if(retVal != undefined){
        	$('#remarksDtl_'+indx).val(retVal);
        }

	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>

	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}		

	TD.greyedData
		{
			BACKGROUND-COLOR: #A3A3A3 ;
			FONT-SIZE: 8pt ;
			color : #FFFFFF;
		}	
		
		.label
		{
			FONT-SIZE: 8pt ;
			FONT-FAMILY : verdana;
			color : #000000;
		}
		.contextMenu
{
	border-left:1px;
	border-right:1px;
	border-top:1px;
	border-bottom:1px;
	border-color:#9C9C9C;
	border-style:solid;
	margin:0;
	background-color: #E7E7E7;
	border-collapse: collapse;
	padding-left:20px;
	padding-right:20px;
}
.contextMenuItem
{
	height:22px;			
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;			
	vertical-align:middle;
	padding-left:20px;
	padding-right:20px;
}
.selectedcontextMenuItem
{
	background-color: #D1D1D1;								
	height:22px;			
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;			
	vertical-align:middle;
	padding-left:20px;
	padding-right:20px;
}
		</style>
</head>
</head>
<body>
	<form name='newOrderDtlFrm' id='newOrderDtlFrm' method="post" action="../../servlet/eBL.BLChargePatientNewOrderServlet">
		<table width='150%' align="center" class='grid' border='1'  cellpadding='3'  cellspacing=0 id='serviceDtls'>
		<div id="tableContainer">
		<thead style="position: sticky;z-index: 1;top: 0;">
			
			<tr>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					S No
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.ServiceCode.label"></fmt:message>&nbsp;
					<a id="resizeLink" href='javascript:detailsResizeFrames()' style="visibility: visible;"><img id="resizeBtn" alt="" src="../../eOT/images/ShowLess.gif" style="visibility: visible;"> </a>
					<a id="resetLink" href='javascript:resultResetFrames()' style="visibility: hidden;"><img id="resetBtn" alt="" src="../../eOT/images/ShowMore.gif" style="visibility: hidden;"></a>				
					
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.ServiceDescription.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${common_labels }" key="Common.Date/Time.label"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message key="eBL.BILLING_SERVICE_PANEL.label" bundle="${bl_labels}"/>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message key="eBL.BL_RATE_CHARGE_TYPE.label" bundle="${bl_labels}"/>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.RATE.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.QTY.label"></fmt:message>
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.GROSS_AMT.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${bl_labels }" key="eBL.BILLING_SERVICE_DISC.label" ></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER' colspan='3' id='rcrdAdhiocDiscS1'>
					<fmt:message bundle="${bl_labels }" key="eBL.REC_ADHOC_DISC.label"></fmt:message>
				</td>
			
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER' id='rcrdAdhocDiscARL'>
					Action Reason
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					UOM
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					Pract Staff
				</td>
				
				
				<td nowrap="nowrap" class='COLUMNHEADER'>
					 Doctor Name&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				
				<td nowrap="nowrap"  class='COLUMNHEADER'>
					Pract/Staff Type
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${common_labels }" key="Common.total.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					<fmt:message bundle="${common_labels }" key="Common.PatientPayable.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER' id='rcrdAdhocDiscPPL'>
					Patient Paid
				</td>
					
				<td nowrap="nowrap" class='COLUMNHEADER'>
					Remarks
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					Pre-Approval
				</td>				
			</tr>
			<!-- <tr>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					Amount
				</td>	
				<td nowrap="nowrap" class='COLUMNHEADER'>
					Percentage
				</td>				
				<td nowrap="nowrap" class='COLUMNHEADER' id='rcrdAdhiocDiscSA1'>
					<fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER' id='rcrdAdhiocDiscSB1'>
					<fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER' id='rcrdAdhiocDiscSC1'>
					<fmt:message bundle="${common_labels }" key="Common.reason.label"></fmt:message>
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
				<td nowrap="nowrap" class='COLUMNHEADER'>
					&nbsp;
				</td>
			</tr> -->
		</thead>
		<tbody>
			<%
			int indx = 0;
			for(BLChargePatientNewOrderBean bean : serviceList){
				indx++;
				if(!("R".equals(bean.getRateIndicator()))){
					
					setPatNetChargeAmt=checkForNull(bean.getBaseChargeAmt());
					setNetChargeAmount=checkForNull(bean.getBaseChargeAmt());
					setServDiscount	= "0";
					
				}else{
					setPatNetChargeAmt=checkForNull(bean.getPatNetChargeAmt());
					setNetChargeAmount=checkForNull(bean.getNetChargeAmount());
					setServDiscount=checkForNull(bean.getServDiscount());
				}
				
			%>
			<tr id='tr_<%=indx%>' data-id='<%=indx%>'>
				<td id='tdSno_<%=indx%>' class='label' nowrap="nowrap">
					<%=indx %>
				</td>
				<td id='td_serv_code_<%=indx %>' style='cursor:pointer' onclick="newOrderTooltip(this,<%=indx %>);" onmouseover="hideToolTip();" nowrap="nowrap">
					<%=bean.getBlngServCode() %>
					<input type='hidden' id='servCode_<%=indx %>' name='servCode_<%=indx %>' value='<%=bean.getBlngServCode()%>'>		
					<input type='hidden' id='deleteFlag_<%=indx %>' name='deleteFlag_<%=indx %>' value=''>		
					<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=indx%>'>				
				</td>
				<td class='label' nowrap="nowrap">
					<%=bean.getBlngServDesc() %>
					<input type='hidden' id='servDesc_<%=indx %>' name='servDesc_<%=indx %>' value="<%=bean.getBlngServDesc()%>">
				</td>
				<td class='label' nowrap="nowrap">		
				<%if("".equals(checkForNull(bean.getDateTime()))){ 
					bean.setDateTime(today);
				}%>		
					<input type='text' data-id='<%=indx %>' name='dateTime_<%=indx %>' id='dateTime_<%=indx %>' size='15' maxlength='19' value='<%=checkForNull(bean.getDateTime()) %>' onblur='isValidDateTime(this);chkDupl(servCode_<%=indx %>,this,<%=indx %>);'/>
					<img src='../../eCommon/images/CommonCalendar.gif' id='endDate_ctrl<%=indx %>' onClick="return showCalendar('dateTime_<%=indx %>','dd/mm/yyyy','hh:mm:ss');" />										
				</td>
				<td class='label' nowrap="nowrap">
					<%
					if("S".equals(bean.getServOrPanel())){ 
						out.print("Service");
					}
					else{
						out.print("Panel");
					}
					%>
					<input type='hidden' id='servOrPanel_<%=indx %>' name='servOrPanel_<%=indx %>' value='<%=bean.getServOrPanel()%>'>
				</td>
				<td class='label' nowrap="nowrap">
					<%if("R".equals(bean.getRateIndicator())){ 
						out.print("Rate");
					}
					else{
						out.print("Charge");
					}
					%>
					<input type='hidden' id='rateInd_<%=indx %>' name='rateInd_<%=indx %>' value='<%=bean.getRateIndicator()%>'>
				</td>
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' style='text-align:right' align='right' name='rate_<%=indx %>' id='rate_<%=indx %>' id='rate_<%=indx %>' sistyle='text-align:right'ly size="10" readonly value="<%= checkForNull(bean.getRate()) %>" >
				</td>
				<%if("R".equals(bean.getRateIndicator())){ %>
					<td class='label' nowrap="nowrap" class='fields'>
						<input type='text' id='qty_<%=indx %>' name='qty_<%=indx %>' size="5"   onkeypress="" value="<%=qtydecimal(checkForNull(bean.getQuantity())) %>" onblur= ' checkZero(this); checkNegativeQtyPriv("<%=indx%>");putdecimal(this);  updateNetAmount("<%=indx%>");  '>
						<input type='hidden' name='qtyhidden_<%=indx %>' id='qtyhidden_<%=indx %>' id='qtyhidden_<%=indx %>' value="<%=qtydecimal(checkForNull(bean.getQuantity())) %>">
					
					</td>
					<td class='label' nowrap="nowrap" class='fields'>
						<input type='text' style='text-align:right' name='grossAmt_<%=indx %>' id='grossAmt_<%=indx %>' id='grossAmt_<%=indx %>' sistyle='text-align:right'ly size="10" readonly value="<%=checkForNull(bean.getBaseChargeAmt()) %>" >
					</td>
				<%} else{ %>
					<td class='label' nowrap="nowrap" class='fields'>
												<input type='text' id='qty_<%=indx %>' name='qty_<%=indx %>' size="3" maxlength="3" readonly value="<%=qtydecimal(checkForNull(bean.getQuantity())) %>" >
					</td>
					<td class='label' nowrap="nowrap" class='fields'>
						<input type='text' style='text-align:right' name='grossAmt_<%=indx %>' id='grossAmt_<%=indx %>' id='grossAmt_<%=indx %>' sistyle='text-align:right'ly size="10"  value="<%=checkForNull(bean.getBaseChargeAmt()) %>" onblur='putdecimal(this);updateNetAmountForCharge("<%=indx%>");'>
					</td>
				<%} %>
			
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' style='text-align:right' name='servDisc_<%=indx %>' id='servDisc_<%=indx %>' id='servDisc_<%=indx %>' sistyle='text-align:right'ly size="10" readonly value="<%=setServDiscount %>" >
				</td>
				
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhiocDiscDD<%=indx %>'>
					<input type='text' name='servDiscPerc_<%=indx %>' id='servDiscPerc_<%=indx %>' id='servDiscPerc_<%=indx %>' size="10" readonly value="<%=checkForNull(bean.getServDiscPerc()) %>" >
				</td>
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhiocDiscDA<%=indx %>'>
					<select name='adhocRate_<%=indx %>' id='adhocRate_<%=indx %>' id='adhocRate_<%=indx %>' onchange="changeDiscInd('<%=indx %>')">
						<option value=''  >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='A' <%="A".equals(bean.getAdhocRate())?"selected":"" %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
						<option value='P' <%="P".equals(bean.getAdhocRate())?"selected":"" %>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
					</select>					
				</td>
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhiocDiscDB<%=indx %>'>
					<input type='text' name='adhocDisc_<%=indx %>' id='adhocDisc_<%=indx %>' id='adhocDisc_<%=indx %>' size="3"  value="<%=checkForNull(bean.getAdhocPerc()) %>" onBlur="if(this.value!=''){ findPatPayable('<%=indx %>',this);}">
					<input type='hidden' name='adhocAmount_<%=indx %>' id='adhocAmount_<%=indx %>' id='adhocAmount_<%=indx %>' value='<%=checkForNull(bean.getAdhocAmount()) %>'>
				</td>
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhiocDiscDC<%=indx %>'>
					<input type='text' name='adhocReason_<%=indx %>' id='adhocReason_<%=indx %>' size="10" onblur="callCommonValidation(2,adhocReasonName_<%=indx %>,adhocReason_<%=indx %>)" value="<%=bean.getAdhocReason() %>" >&nbsp;
					<input type='hidden' name='adhocReasonName_<%=indx %>' id='adhocReasonName_<%=indx %>' value=''>
					<input type='button'  id='adhocReason_but_<%= indx%>' value='?' onclick='callCommonValidation(2,adhocReasonName_<%=indx %>,adhocReason_<%=indx %>)'>
				</td>
				<td class='label' nowrap="nowrap" class='fields'>
				<%if("Y".equals(bean.getOverrideInd())){ %>
					<Select id='policyIncl_<%=indx %>' name='policyIncl_<%=indx %>'>
						<option value='I' <%="I".equals(bean.getPolicyIncl())?"selected":"" %>>Included</option>
						<option value='E' <%="E".equals(bean.getPolicyIncl())?"selected":"" %>>Excluded</option>
					</Select>
					<input type='hidden' id='originalIncl_<%=indx %>' name='originalIncl_<%=indx %>' value='<%=checkForNull(bean.getOrgIncl()) %>'>
					<input type='hidden' id='override_<%=indx %>' name='override_<%=indx %>' value='<%=checkForNull(bean.getOverrideInd()) %>'>
				</td>
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhocDiscAR<%=indx %>'>
					<input type='text' style='text-align:right' name='addlCharges_<%=indx %>' id='addlCharges_<%=indx %>' sistyle='text-align:right'ly size="10" value="<%=checkForNull(bean.getAddlCharges()) %>" onblur="if(this.value != ''){ callCommonValidation(2,addlCharges_<%=indx %>,reasCode<%=indx %>); } else{ clearCode(reasCode<%=indx %>); }">
					<input type='hidden' id='reasCode<%=indx %>' name='reasCode<%=indx %>' value="">
					<input type='button'  id='reasBut_<%= indx%>' value='?' onclick="callCommonValidation(2,addlCharges_<%=indx %>,reasCode<%=indx %>);">
				</td>
				<%}
				else{
					
					if(!("L".equals(bean.getServOrPanel()))){
						if("I".equals(bean.getPolicyIncl())){
							out.print("Included");   
						}
						else{
							out.print("Excluded");
						}
				}
				 %>
					<input type='hidden' id='policyIncl_<%=indx %>' name='policyIncl_<%=indx %>' value='<%=checkForNull(bean.getPolicyIncl()) %>'>
					<input type='hidden' id='override_<%=indx %>' name='override_<%=indx %>' value='<%=checkForNull(bean.getOverrideInd()) %>'>
				</td>
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhocDiscAR<%=indx %>'>
					<input type='text' style='text-align:right' name='addlCharges_<%=indx %>' id='addlCharges_<%=indx %>' sistyle='text-align:right'ly size="10" readonly value="<%=checkForNull(bean.getAddlCharges()) %>" >
					<input type='hidden' id='reasCode<%=indx %>' name='reasCode<%=indx %>' value="">
					<input type='button' disabled id='reasBut_<%= indx%>' value='?' onclick="callCommonValidation(2,reasCode<%=indx %>,addlCharges_<%=indx %>)">
				</td>
				<%} %>
					
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' id='uom_<%=indx %>' name='uom_<%=indx %>' size="3" readonly value="<%=checkForNull(bean.getUomCode()) %>" >
				</td>
				<td class='label' nowrap="nowrap" class='fields'>
					<select name='practStaffInd_<%=indx %>' id='practStaffInd_<%=indx %>' id='practStaffInd_<%=indx %>' onchange="pracstaffchange('<%=indx%>');">
						<option value='P' <%="P".equals(bean.getPractStaffInd())?"selected":"" %> >Practitioner</option>
						<option value='O' <%="O".equals(bean.getPractStaffInd())?"selected":"" %>>Other Staff</option>
					</select>
				</td>
					
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' name='drName_<%=indx %>' id='drName_<%=indx %>' id='drName_<%=indx %>' size="10" onblur="if(this.value != ''){ doctorCodeValidation(1,docNam<%=indx %>,drName_<%=indx %>,practStaffInd_<%=indx %>,<%=indx %>,1); } else{clearCode(docNam<%=indx %>); clearCode(practStaffType<%=indx %>);}" value="<%=checkForNull(bean.getDrName()) %>" >&nbsp;
					<input type='text' name='docNam<%=indx %>' id='docNam<%=indx %>' id='docNam<%=indx %>' onblur="if(this.value != ''){ doctorCodeValidation(1,docNam<%=indx %>,drName_<%=indx %>,practStaffInd_<%=indx %>,<%=indx %>,2); } else{clearCode(drName_<%=indx %>); clearCode(practStaffType<%=indx %>);}"value="<%=checkForNull(bean.getPhysicianName()) %>">					
					<input type='button'  id='drName_but_<%= indx%>' value='?' onclick="doctorCodeValidation(1,docNam<%=indx %>,drName_<%=indx %>,practStaffInd_<%=indx %>,<%=indx %>,2)">
					<input type='hidden' id='hdnDoctor<%= indx%>' name='hdnDoctor<%= indx%>' value="<%=checkForNull(bean.getDrName()) %>">
				</td>
				<td class='label' nowrap="nowrap"   class='fields'>
					<input name='practStaffType<%=indx %>' id='practStaffType<%=indx %>' id='practStaffType<%=indx %>'  value='<%=checkForNull(bean.getPractStaffType()) %>' readonly></td>
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' style='text-align:right' id='total_<%=indx %>' name='total_<%=indx %>' style='text-align:right' size="10" readonly value="<%=setNetChargeAmount %>" >
				</td>
				
				
				
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='text' style='text-align:right' id='patPayable_<%=indx %>' name='patPayable_<%=indx %>' style='text-align:right' size="10" readonly  value="<%=setPatNetChargeAmt %>">
					<input type='hidden' id='hdnTotal_<%=indx %>' value='<%=checkForNull(bean.getNetChargeAmount()) %>'>
					<input type='hidden' id='hdnPatPayable_<%=indx %>' value='<%=checkForNull(bean.getPatNetChargeAmt()) %>'>
				</td>
				<td class='label' nowrap="nowrap" class='fields' id='rcrdAdhocDiscPP<%=indx %>'>
					<input type='text' style='text-align:right' id='patPaid_<%=indx %>' name='patPaid_<%=indx %>' style='text-align:right' size="3" readonly value="<%=checkForNull(bean.getPatPaidAmt()) %>" >
				</td>
				
				<td class='label' nowrap="nowrap" class='fields'>
					<span style="color: blue;" onclick="javascript:captureRemarks('<%=indx%>')">Remarks</span>
					<input type='hidden' name='remarksDtl_<%= indx%>' id='remarksDtl_<%= indx%>' id='remarksDtl_<%= indx%>' value="<%=checkForNull(bean.getRemarks())%>">
				</td>
				<td class='label' nowrap="nowrap" class='fields'>
					<input type='checkbox' name='preAppReq_<%= indx%>' id='preAppReq_<%= indx%>' id='preAppReq_<%= indx%>' <%="Y".equals(bean.getPreAppYn())?"checked":"" %> onclick="return false;">
					<input type='hidden' name='panelStr_<%= indx%>' id='panelStr_<%= indx%>' id='panelStr_<%= indx%>' value="<%=checkForNull(bean.getPanelString())%>">
				<input type='hidden' name='editPanel_<%= indx%>' id='editPanel_<%= indx%>' id='editPanel_<%= indx%>' value="<%=checkForNull(bean.getEditPanel())%>">
				</td>
				
			</tr>
			<%}
			%>
			<tr>
				<td colspan='10' align="right">
					<input type='button' value='Record' onclick='recordDetails();'>
				</td>
				<td colspan='5' class='label'>
					TOTAL AMOUNT (NET)
				</td>
				
				<td style='text-align:right' nowrap="nowrap">
					<span id='net_amount'>
					</span>
					
				</td>
				<td style='text-align:right' nowrap="nowrap">
				
					<span id='pat_payable_amount'></span></td>
			</tr>
			
		</table>
		<input type='hidden' name='rowCount' id='rowCount' id='rowCount' value='<%=indx %>'>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	
	</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:8%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					<!-- </td> -->
				</tr>
			</table>
		</div>
</body>
</TBODY>	
	
	</div>
</html>

