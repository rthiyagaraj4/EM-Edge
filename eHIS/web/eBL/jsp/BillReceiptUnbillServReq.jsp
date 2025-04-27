
<%@page import="java.util.ArrayList"%>
<%@page import="eBL.billreceipt.model.BillReceiptUnbillOutst"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unbilled Service Request-Episode </title>
<%!
	private String replaceNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			
	String queryString = request.getQueryString();
	//V220512
	//String patientId = request.getParameter("patient_id");
	String patientId="";
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}else{
		patientId	= request.getParameter("patient_id");
	}
	//V220512
	String facilityId = (String) session.getValue("facility_id");
	String locale = (String) session.getValue("LOCALE");
	String episodeId = replaceNull(request.getParameter("episode_id"));	
	String noOfDecimals = request.getParameter("noOfDecimals");	
	String visitId = replaceNull(request.getParameter("visit_id"));
	
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLocale(locale);
	billRequest.setEpisodeType(replaceNull(request.getParameter("episode_type")));
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);	
	
	BillReceiptBC billReceiptBC = new BillReceiptBC();
	HashMap<String,List<BillReceiptUnbillOutst>> unBillServMap = billReceiptBC.getUnBilledEpisodeRequest(billRequest);	
	
	List<BillReceiptUnbillOutst> dtlList = unBillServMap.get("detail");
	List<BillReceiptUnbillOutst> summList = unBillServMap.get("summary");	
	
	BillReceiptUnbillOutst summBean = null;
	if(summList != null && !summList.isEmpty()){
		summBean = summList.get(0);
		if(summBean == null){
			summBean = new BillReceiptUnbillOutst();
		}
	}
	if(dtlList == null){
		dtlList = new ArrayList<BillReceiptUnbillOutst>();
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
   <style>
	.Unprocessed{
		width: 50px;
		height: 12.5px;
		background: #52BD15;
	}
	.Unconfirmed{
		width: 50px;
		height: 12.5px;
		background: red;
	}

</style>
<script language="javascript" src="../../eCommon/js/jquery.js"></script>
<script language="javascript" src="../../eBL/js/BillReceipt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){		
		var noOfDecimals = $('#noOfDecimal').val();		
		$('[id^=tdGrossAmt_]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		
		$('[id^=tdDiscAmt_]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		
		$('[id^=tdNetAmt_]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		
		$('[id^=tdSumm_]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
	});
</script>
</head>
<body>
<br/>
<div style="float:left; width: 100%">
<table width='100%' align="left" cellpadding='3'  cellspacing=0 >
		<td class='LABEL' width="5%" >Facility ID</td>		
		<td width="10%" class='LABEL'>
		<span id='facilityId' name='facilityId' size='3' readonly ><%=facilityId%></span>
		</td>		
		<td class='LABEL' width="5%" >Episode ID</td>
		<td width="10%" class='LABEL'>
				<span id='facilityId' name='facilityId' size='3' readonly ><%=episodeId%></span>
		</td>		
		<td class='LABEL' width="5%" >Visit No</td>
		<td width="10%" class='LABEL'>
				<span id='facilityId' name='facilityId' size='3' readonly ><%=visitId%></span>
		</td>		
	</tr>	
</table>
</div>
<br/>
<br/>

<div style="float:left; width: 99%">
<table class='grid' border='1' width='100%' align="left" cellpadding='3'  cellspacing=0 >
	
	<tr>
	<td class='COLUMNHEADER' width="2%" >Status</td>
		<td class='COLUMNHEADER' width="1%" >Module</td>
		<td class='COLUMNHEADER' width="12%" >Service Date</td>
		<td class='COLUMNHEADER' width="12%" >Transaction Date</td>
		<td class='COLUMNHEADER' width="2%" >Billing Service</td>
		<td class='COLUMNHEADER' width="15%" >Description</td>
		<td class='COLUMNHEADER' width="2%" >Qty</td>
		<td class='COLUMNHEADER' width="8%" >Gross Charge</td>
		<td class='COLUMNHEADER' width="8%" >Discount</td>
		<td class='COLUMNHEADER' width="8%" >Net Charge</td>
	</tr>
	<%
	int indx = 1;
	for(BillReceiptUnbillOutst bill:dtlList){ 	

		if(bill == null){
			bill = new BillReceiptUnbillOutst();
		}

		
	%>
	<tr>
		<%if(("N".equals(bill.getConfirmed())) && ("Y".equals(bill.getProcessed()))){
			
			%>
			<td style="width: 2%;">
			<span class='Unconfirmed'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		
		<%} else if ("N".equals(bill.getProcessed())) {
		%>
		<td style="width: 2%;">
				<span class='Unprocessed'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>			
		<%}else{
			%>	
		<td style="width: 2%;">
			<span class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</td>
		<%}%>
		<td class='LABEL' width="1%" id='ModuleId<%=indx%>' >
			<%=bill.getModuleId() %>
		
		</td>
		<td class='LABEL' width="12%" id='BillDate<%=indx%>'>
			<%=bill.getBillDate() %>
			
		</td>
		<td class='LABEL' width="12%" id='TrxDate<%=indx%>'>
			<%=replaceNull(bill.getTrxDate()) %>
				
		</td>
		<td class='LABEL' width="2%" id='BlngServCode<%=indx%>'>
			<%=bill.getBlngServCode() %>
				
		</td>
		<td class='LABEL' width="15%" id= 'BlngServDesc<%=indx%>'>
			<%=replaceNull(bill.getBlngServDesc()) %>
				
		</td>
		
		<td class='LABEL' width="2%"  id= 'Qty<%=indx%>'  style="text-align: right;">
			<%=bill.getQty() %>
		</td>
		<td class='LABEL' width="8%" id='tdGrossAmt_<%=indx%>' style="text-align: right;">  
			<%=replaceNull(bill.getGrossAmt()) %>
		</td>
		<td class='LABEL' width="8%" id='tdDiscAmt_<%=indx%>' style="text-align: right;">
			<%=replaceNull(bill.getDiscountAmt() )%>
		</td>
		<td class='LABEL' width="8%" id='tdNetAmt_<%=indx%>' style="text-align: right;">
			<%=replaceNull(bill.getNetAmt()) %>
		</td>
		
	</tr>
	<%
	indx++;
	} %>
	<tr  colspan="7">
		<td>
			&nbsp;
		</td>
	</tr>
	<%if(summBean == null){
		summBean = new BillReceiptUnbillOutst();
	} %>
	<tr>
		<td  class='LABEL' colspan="7"  style="text-align: right">
			Total
		</td>
		<td  class='LABEL' width="3%" id='tdSumm_Gross' style="text-align: right">
			<%=summBean.getGrossAmt() %>
		</td>
		<td  class='LABEL' width="3%" id='tdSumm_Disc' style="text-align: right">
			<%=summBean.getDiscountAmt() %>
		</td>
		<td  class='LABEL'  width="3%" id='tdSumm_Net' style="text-align: right">
			<%=summBean.getNetAmt() %>
		</td>
	</tr>
</table>
</div>
<input type='hidden' name='noOfDecimal'  id='noOfDecimal' value='<%=noOfDecimals %>'>
</body>
</html>

