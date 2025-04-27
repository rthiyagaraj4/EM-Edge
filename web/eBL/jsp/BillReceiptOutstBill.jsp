<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       		  Shikha Seth
--------------------------------------------------------------------------------------------------------
-->
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="java.util.List"%>
<%@page import="eBL.billreceipt.model.BillReceiptUnbillOutst"%>
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
	String noOfDecimals = request.getParameter("noOfDecimal");
	String encounterFacilityId = request.getParameter("encounterFacilityId"); //V210129 
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	//billRequest.setFacilityId(facilityId);//V210129 Commented
	billRequest.setFacilityId(encounterFacilityId); //V210129 Added
	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptUnbillOutst> outStandingBills = billReceiptBC.getOutstandingBills(billRequest);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="../../eBL/js/BillReceipt.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		var noOfDecimals = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
				$('[id^=tdOutStdAmt_]').each(function(){
			if($.trim($(this).text() != '')){
				
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			/*else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}*/
		});
		
		$('[id^=tdRfndAmt_]').each(function(){
			
			if($.trim($(this).text() != '')){
				
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		
		$('[id^=remSlmtAmt]').each(function(){
			
			if(($(this).val() != '')&& ($(this).val() != " ")){
				
				putDecimal($(this).get(0),17,noOfDecimals);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimals);
			}
		});
		
		$('[id^=tdExemAmt]').each(function(){
			if($.trim($(this).text() != '')){
				
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		
		$('[id^=tdBillAmt]').each(function(){
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
<style>
	#foo {
		position: absolute;
		bottom: 0;
		right: 0;
	  }
</style>
</head>
<body>

<div style="float:left; width: 100%">
<table width='100%'  cellpadding='1'  cellspacing=0 >

<tr>
	<td class='LABEL' width="10%">Facility ID :</td>
	<td  class='fields'>
	<td class='LABEL'  id='facilityId' name='facilityId' style="text-align: left;"><%=facilityId%></td>

	<td width="74%" align="right"  cellspacing=0 style="padding-right: 7px;">
	<input class='button' type="button" name='btnSettlement' id='btnSettlement' value='Settlement' onclick='insertConsolidatedBill();'></td>
	<td width="08%" style="padding-right: 4px;">
	<input class='button' type="button" name='reset' id='reset' value='Reset' onclick='reset();'></td>		
</tr>	
</table>
</div>

<div style="float:left; width: 100%" >
<table class='grid' border='2' width='100%' align="left" cellpadding='1'  cellspacing=0 >
<tr>
	<td class='COLUMNHEADER' width="3%" >Select</td>
	<td class='COLUMNHEADER' width="3%" >Print Bill</td>
	<td class='COLUMNHEADER' width="4%" >Episode Type</td>
	<td class='COLUMNHEADER' width="5%" >Episode No</td>
	<td class='COLUMNHEADER' width="3%" >Visit</td>
	<td class='COLUMNHEADER' width="10%" >Bill Date</td>
	<td class='COLUMNHEADER' width="8%" >Doc Type</td>
	<td class='COLUMNHEADER' width="8%" >Bill No</td>
	<td class='COLUMNHEADER' width="10%" >Customer Code</td>
	<td class='COLUMNHEADER' width="12%" >Bill Amount</td>
	<td class='COLUMNHEADER' width="11%" >Slmt/Refund Amount</td>
	<td class='COLUMNHEADER' width="10%" >Exemption Amount</td>
	<td class='COLUMNHEADER' width="13%" >Outstanding Amount</td>
	<td class='COLUMNHEADER' width="10%" >Settlement Amount</td>		
</tr>
<%
	int indx = 1;
	String episode_type="",episode_no="",visit_id="",trx_date="",doc_type="",doc_num="",cust_code="",outstandAmt="",refundAmt="",remSlmtAmt="",exemAmt="",billAmt="",bill_print_yn="";
	
	for(BillReceiptUnbillOutst outStBill:outStandingBills){
%>
	
	<tr><%if(outStBill.getCustCode()==null) {	%>
		<td class='LABEL'>
			<input type='checkbox' id='billSelect<%=indx %>' name='billSelect<%=indx %>' onclick="checkUncheck('<%=indx %>')">
		</td>
		<%} else{%>
		
		<td class='LABEL'>
			<input type='checkbox' id='billSelect<%=indx %>' name='billSelect<%=indx %>' disabled >
		</td>
		<%} %>

		<%if(outStBill.getCustCode()==null) {%>
		<td class='LABEL'>
			<input type='checkbox' id='bill_print_yn<%=indx %>' name='bill_print_yn<%=indx %>' >
		</td>
		<%} else{%>
		
		<td class='LABEL'>
			<input type='checkbox'  id='bill_print_yn<%=indx %>' name='bill_print_yn<%=indx %>' disabled >
		</td>
		<%} %>

		<%if("O".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Outpatient";
		}
		else if("I".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Inpatient";
		}
		else if("D".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Daycare";
		}
		else if("E".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Emergency";
		}
		else if("R".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="External";
		}
		%>
		<td class='LABEL'  id='episode_type<%=indx%>' style="text-align: left;">
		<%=episode_type%>			
			
		</td>
		<td class='LABEL' id='episode_id<%=indx%>'>
			<%if("".equals(replaceNull(outStBill.getEpisodeNo()))){%>
			&nbsp;
			<%}else{ %>
			<%=replaceNull(outStBill.getEpisodeNo()) %>
			<%} %>
		</td>
		<td class='LABEL'id='visit_id<%=indx%>'>
			<%if("".equals(replaceNull(outStBill.getVisitId()))){ %>
			&nbsp;
			<%}else{ %>
			<%=replaceNull(outStBill.getVisitId()) %>
			<%} %>
		</td>
		<td class='LABEL'  nowrap  id='trx_date<%=indx%>'>
			<%=replaceNull(outStBill.getTrxDate())%>
		</td>
		<td class='LABEL'id='doc_type<%=indx%>'>
			<%=replaceNull(outStBill.getDocType())%>
		</td>
		<td class='LABEL' id='doc_num<%=indx%>'>
			<%=replaceNull(outStBill.getDocNum())%>
		</td>
		<td class='LABEL' id='cust_code<%=indx%>'>
			<%if("".equals(replaceNull(outStBill.getCustCode()))){ %>
			&nbsp;
			<%}else{ %>
			<%=replaceNull(outStBill.getCustCode()) %>
			<%} %>
		</td>
		
		<td class='LABEL' id='tdBillAmt<%=indx%>' style="text-align: right;">
			<%=replaceNull(outStBill.getBillAmt())%>
		</td>
		
		<td class='LABEL' id='tdRfndAmt_<%=indx%>' style="text-align: right;">
			<%=replaceNull(outStBill.getRefundAmt()) %>
		</td>
			
		<td class='LABEL' id='tdExemAmt<%=indx%>' style="text-align: right;">
			<%=replaceNull(outStBill.getExemAmt())%>
		</td>
		
		<td class='LABEL' id='tdOutStdAmt_<%=indx%>' style="text-align: right;">
			<%=replaceNull(outStBill.getOutStndAmt()) %>
		</td>
		
		<%if(outStBill.getCustCode()==null) {%>		
		<td width='9%' id='tdRemSlmtAmt<%=indx%>'  class='fields'  style="text-align: right;">
		<input type='text' data-id='<%=indx%>' id='remSlmtAmt<%=indx %>' name='remSlmtAmt<%=indx %>' value='<%=replaceNull(outStBill.getOutStndAmt())%>' size='20' maxlength = '17' style="text-align: right;" onkeypress='return checkAlpha(event);' onblur='return checkRemSlmtAmt(this);'></td>

		<%} else{%>
		<td width='9%' id='tdRemSlmtAmt<%=indx%>'  class='fields'  style="text-align: right;">
		<input type='text' data-id='<%=indx%>' id='remSlmtAmt<%=indx %>' name='remSlmtAmt<%=indx %>' value='<%=replaceNull(outStBill.getOutStndAmt())%>' readonly size='20' maxlength = '17' style="text-align: right;" onkeypress='return checkAlpha(event);' onblur='return checkRemSlmtAmt(this);'></td>		
		<%} %>		
	</tr>	
	
	<%
		indx++;		
	}
	%>
	<input type='hidden' id='billSelect<%=indx %>' name='billSelect<%=indx %>' >
	<input type='hidden' id='bill_print_yn<%=indx %>' name='bill_print_yn<%=indx %>' >
	<input type='hidden' name='total_records' id='total_records'  value='<%=indx %>'>
	<input type='hidden' name='facilityId' id='facilityId'  value='<%=facilityId %>'>
	<input type='hidden' name='patientId' id='patientId' value='<%=patientId %>'>
	<input type='hidden' name='queryString' id='queryString'  value='<%=queryString %>'>
	<input type='hidden' name='noOfDecimals' id='noOfDecimals' value='<%=noOfDecimals %>'>
	<input type='hidden' name='index' id='index' value='<%=indx %>'>
	<input type='hidden' name='encounterFacilityId' id='encounterFacilityId' value='<%=encounterFacilityId %>'>
	</table>
	</div>
</table>
</body>
</html>

