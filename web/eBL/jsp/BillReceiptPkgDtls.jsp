<!DOCTYPE html>
<%@page import="eBL.billreceipt.model.BillReceiptPackageInfo"%>
<%@page import="java.util.List"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Package Folio Window</title>
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
	
	String patientId = replaceNull(request.getParameter("patient_id"));
	String episodeType = replaceNull(request.getParameter("episode_type"));
	String episodeId = replaceNull(request.getParameter("episode_id"));
	String visitId = replaceNull(request.getParameter("visit_id"));
	String facilityId = (String) session.getValue("facility_id");
	String noOfDecimal = replaceNull(request.getParameter("noOfDecimal"));
	String locale = (String) session.getValue("LOCALE");
	
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setEpisodeType(episodeType);
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLocale(locale);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptPackageInfo>  pkgInfoList = billReceiptBC.getPackageDtls(billRequest);
%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eBL/js/BillReceipt.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script>
var noOfDecimal=<%=noOfDecimal%>

	$(document).ready(function(){
		$('#close').click(function(){
			window.close();
		});
		
		
		$('[id^=gross_amt]').each(function(){
				
				if($.trim($(this).text() != '')){
					
					putDecimal_Text($(this),17,noOfDecimal);				
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimal);
				}
			});
		$('[id^=disc_amt]').each(function(){
				
				if($.trim($(this).text() != '')){
					
					putDecimal_Text($(this),17,noOfDecimal);				
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimal);
				}
			});
		$('[id^=net_amt]').each(function(){
			
			if($.trim($(this).text() != '')){
				
				putDecimal_Text($(this),17,noOfDecimal);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimal);
			}
		});
	});
</script>
</head>
<body>
	<br/>
	<table class='grid' border='1' width='100%' align="center" cellpadding='3'  cellspacing=0 >
		
		<tr>
			<td class='COLUMNHEADER' width="7%" >Episode Type</td>
			<td class='COLUMNHEADER' width="7%" >Episode Id</td>
			<td class='COLUMNHEADER' width="8%" >Package Code</td>
			<td class='COLUMNHEADER' width="12%" >Package Description</td>
			<td class='COLUMNHEADER' width="10%" >Billing Service</td>
			<td class='COLUMNHEADER' width="12%" >Service Description</td>
			<td class='COLUMNHEADER' width="7%" >Gross Amount</td>	
			<td class='COLUMNHEADER' width="7%" >Disc Amount</td>	
			<td class='COLUMNHEADER' width="7%" >Net Amount</td>	
			<td class='COLUMNHEADER' width="7%" >Priority</td>	
			<td class='COLUMNHEADER' width="8%" >Blng Grp Id</td>	
			<td class='COLUMNHEADER' width="8%" >Customer</td>				
		</tr>
		<%
		int indx = 1;
		for(BillReceiptPackageInfo pkgInfo:pkgInfoList){ 	
		%>
		<tr>					
			<td class='LABEL'>
				<%=pkgInfo.getEpisodeType() %>
			</td>
			<td class='LABEL'>
				<%=replaceNull(pkgInfo.getEpisodeId()) %>
			</td>			
			<td class='LABEL'>
				<%=pkgInfo.getPackageCode() %>
			</td>
			
			<td class='LABEL'>
				<%=pkgInfo.getPackageDesc() %>
			</td>
			<td class='LABEL'>
				<%=pkgInfo.getBlngServCode()%>
			</td>
			<td class='LABEL'>
				<%=pkgInfo.getBlngServDesc()%>
			</td>
			<td class='LABEL' id='gross_amt'>
				<%=pkgInfo.getGrossAmt() %>
			</td>
			<td class='LABEL' id='disc_amt'>
				<%=pkgInfo.getDiscAmt() %>
			</td>
			<td class='LABEL' id='net_amt'>
				<%=pkgInfo.getNetAmt() %>
			</td>
			
			<td class='LABEL'>
				&nbsp;
			</td>
			<td class='LABEL'>
				<%=pkgInfo.getBlngGrpId() %>
			</td>
			<td class='LABEL'>
				<%if("".equals(replaceNull(pkgInfo.getCustDes()))){ %>
				&nbsp;
			<%}else{ %>
			<%=replaceNull(pkgInfo.getCustDes()) %>
			<%} %>
			</td>
			
		</tr>
		<%
		indx++;
		} %>
		
		</table>
		<br/>
	<br/>
		<table align="right">
		<tr></tr>
		<tr></tr>
			<td colspan="12" align="right">				
				<input type='button' class='button' name='close' id='close' id='close' value='Close'>
			</td>
		
	</table>
</body>
</html>

