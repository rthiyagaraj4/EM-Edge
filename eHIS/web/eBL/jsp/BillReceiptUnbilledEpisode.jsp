<!DOCTYPE html>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.model.BillReceiptUnbillOutst"%>
<%@page import="java.util.List"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Outstanding Unbilled</title>
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
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setFacilityId(facilityId);
	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptUnbillOutst> unbilledEpidose = billReceiptBC.getUnBilledEpisode(billRequest);

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="../../eBL/js/BillReceipt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		var noOfDecimals = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
		$('#noofdeci').val(noOfDecimals);
		
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
	});
	
</script>
</head>
<body>
<br/>
<div style="float:left; width: 10%">

</div>
<div style="float:left; width: 90%">
<table width='30%' align="left" cellpadding='3'  cellspacing=0 >
				
		
		<td class='LABEL' width="5%" >Facility ID</td>
		
		<td width="10%" class='LABEL'>
		<span id='facilityId' name='facilityId' size='3' readonly ><%=facilityId%></span>
		</td>
		
				
		
</table>
</div>
<br/>
<br/>
<div style="float:left; width: 5%">

</div>
<div style="float:left; width: 95%">
<table class='grid' border='1' width='70%' align="left" cellpadding='3'  cellspacing=0 >
	<tr>
		<td class='COLUMNHEADER' width="15%" >Episode Date</td>
		<td class='COLUMNHEADER' width="15%" >Episode Type</td>
		<td class='COLUMNHEADER' width="15%" >Episode No</td>
		<td class='COLUMNHEADER' width="10%" >Visit</td>
		<td class='COLUMNHEADER' width="15%" >Gross Amt</td>
		<td class='COLUMNHEADER' width="15%" >Disc. Amt</td>
		<td class='COLUMNHEADER' width="15%" >Net Amt</td>	
		
		<td class='COLUMNHEADER' width='15%' >Unbilled Services</td>	
	</tr>
	<%
	int indx = 1;
	String episode_type="";
	for(BillReceiptUnbillOutst bill:unbilledEpidose){ 	
		String date = "";
		System.out.println("date="+bill.getTrxDate() );
		if(bill.getTrxDate()== null) {
			date="";
		}else {
			date=bill.getTrxDate();
		}
	%>
	<tr>		
		<td class='LABEL'>
			<%=date %>
		</td>
		<%if("O".equals(replaceNull(bill.getEpisodeType()))){
		episode_type="Outpatient";
		}
		else if("I".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="Inpatient";
		}
		else if("D".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="Daycare";
		}
		else if("E".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="Emergency";
		}
		else if("R".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="External";
		}
		
		%>
		<td class='LABEL'> <span id='episode_type<%=indx%>'>
			<%=episode_type%>
					<% System.out.println("ghdusy"+bill.getEpisodeType());%>
					</span>
		</td>
		<td class='LABEL'> <span id= 'episode_id<%=indx%>'>
			<%=replaceNull(bill.getEpisodeNo())%>
			<%System.out.println("ghdusy"+bill.getEpisodeNo()); %>
			</span>
		</td>
		<td class='LABEL'><span id= 'visit_id<%=indx%>'>
			<%=replaceNull(bill.getVisitId())
			%>
			</span>
		</td>
		<td class='LABEL' id='tdGrossAmt_<%=indx%>' style="text-align: right;">
			<%=bill.getGrossAmt() %>
		</td>
		
		<td class='LABEL' id='tdDiscAmt_<%=indx%>' style="text-align: right;">
			<%=bill.getDiscountAmt() %>
		</td>
		<td class='LABEL' id='tdNetAmt_<%=indx%>' style="text-align: right;">
			<%=bill.getNetAmt() %>
		</td>
		<td class = 'button' id='UnbillServReq'  style="text-align: right;"><a  href="javascript:fnUnBillServReq('<%=indx%>');">View</a> 
		</td>
		
	</tr>
	<%
	indx++;
	} %>
	<input type="hidden" name="patient_id" id="patient_id"	  value ='<%=patientId%>'>
	<input type="hidden" name="noofdeci" id="noofdeci"	 value =''>
	
</table>
</div>

</body>
</html>

