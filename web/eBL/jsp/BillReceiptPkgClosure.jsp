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
<title>Open Subscribed Packages</title>
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
	String totalGroup = replaceNull(request.getParameter("totalGroup"));
	String facilityId = (String) session.getValue("facility_id");
	String locale = (String) session.getValue("LOCALE");
	String noOfDecimal = replaceNull(request.getParameter("noOfDecimal"));
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setEpisodeType(episodeType);
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLocale(locale);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptPackageInfo>  pkgInfoList = billReceiptBC.getPackageClosureDtls(billRequest);
%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		var confirmBox='';
		var pkgSeqNo = '';
		var packageCode='';
		var noOfDecimal=<%=noOfDecimal%>;
		$('#close').click(function(){
			
			var totalCount = $('#totalCount').val();
			var dataParams = 'calledFrom=PackageClosure&totalCount='+totalCount+
							'&patientId='+$('#patientId').val()+
							'&episodeType='+$('#episodeType').val()+
							'&episodeId='+$('#episodeId').val()+
							'&visitId='+$('#visitId').val();
			for(var i=1; i<=totalCount; i++){
				dataParams += '&packageSeqNo'+i+'='+$.trim($('#seqNo'+i).text())+
							'&packageCode'+i+'='+$.trim($('#packageCode'+i).text());
				
				pkgSeqNo =pkgSeqNo+','+$.trim($('#seqNo'+i).text());
				
				packageCode =packageCode+','+$.trim($('#packageCode'+i).text());
			}
			
			
			
			if($('#totalGroup').val()==0){
				 confirmBox =window.confirm(getMessage('BL00961','BL'));
				 if(confirmBox){
					
			$.ajax({
				type:"GET",
				url:"../jsp/BillReceiptAjax.jsp",
				data:dataParams,
				dataType:"json",
				async:false,
				success: function(data){
					if(data.success=='Y'){	
						//window.returnValue = totalCount+"::"+pkgSeqNo+"::"+packageCode;
						//window.close();
						parent.document.querySelectorAll("#dialog-body")[parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = totalCount+"::"+pkgSeqNo+"::"+packageCode;
					parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();

					}
					else{
						alert($.trim(data.error));
					}
					
				},
				 error: function(data){
					 alert(data)
			      }
			});
			}
				 else{
					 /*  window.returnValue="N";
					 window.close(); */
					 
			parent.document.querySelectorAll("#dialog-body")[parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = "N";
						parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
					 
				 }
			}
			else{
				/* window.returnValue = totalCount+"::"+pkgSeqNo+"::"+packageCode;
				window.close(); */
				
				parent.document.querySelectorAll("#dialog-body")[parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = totalCount+"::"+pkgSeqNo+"::"+packageCode;
				parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
			}
		});
		
		$('#cancel').click(function(){
			/* window.returnValue="N";
			window.close(); */
			
			parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = "N";
			parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
		});
		$('[id^=pkg_amt]').each(function(){
			
					if($.trim($(this).text() != '')){
						
						putDecimal_Text($(this),17,noOfDecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noOfDecimal);
					}
				});
		$('[id^=avail_amt]').each(function(){
			
			if($.trim($(this).text() != '')){
				
				putDecimal_Text($(this),17,noOfDecimal);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimal);
			}
		});
		$('[id^=deposit_amt]').each(function(){
			
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
	<br/>
	<form id='pkgClosureFrm'>
	<table class='grid' border='1' width='100%' align="centre" cellpadding='2'  cellspacing=0 >	
	<tr>
		<td class='COLUMNHEADER' width="5%" align="left">Select</td>
		<td class='COLUMNHEADER' width="10%" align="left">Episode Type</td>
		<td class='COLUMNHEADER' width="10%" align="left">Episode Id</td>
		<td class='COLUMNHEADER' width="10%" align="left">Visit Id</td>
		<td class='COLUMNHEADER' width="10%" align="left">Package Code</td>
		<td class='COLUMNHEADER' width="15%" align="left">Package Description</td>
		<td class='COLUMNHEADER' width="15%" align="left">Package Seq No</td>
		<td class='COLUMNHEADER' width="10%" align="left">Package Amount</td>	
		<td class='COLUMNHEADER' width="10%" align="left">Availed Amount</td>	
		<td class='COLUMNHEADER' width="10%" align="left">Deposit Amount</td>					
	</tr>
	<%
		int indx = 0;
		String episode_type="";
		String pkgInfoCloseYn = "";
		for(BillReceiptPackageInfo pkgInfo:pkgInfoList){ 
			indx++;
			pkgInfoCloseYn = pkgInfo.getPkgCloseYn();
	%>
		<tr>		
			<td class='LABEL'>
				<input type='checkbox' checked name='pkgSelect<%=indx %>' id='pkgSelect<%=indx %>' onclick="checkAlways('<%=indx %>')">
			</td>
	<%if("O".equals(replaceNull(episodeType))){
		episode_type="Outpatient";
		}
		else if("I".equals(replaceNull(episodeType))){
			episode_type="Inpatient";
		}
		else if("D".equals(replaceNull(episodeType))){
			episode_type="Daycare";
		}
		else if("E".equals(replaceNull(episodeType))){
			episode_type="Emergency";
		}
		else if("R".equals(replaceNull(episodeType))){
			episode_type="External";
		}
	%>
			<td class='LABEL' id='episodeType<%=indx%>'>
				<%=episode_type %>
			</td>
			<td class='LABEL' id='episodeId<%=indx%>'>
				<%=episodeId %>
			</td>
			
			<td class='LABEL' id='visitId<%=indx%>'>
			<%if("".equals(replaceNull(visitId))){ %>
			&nbsp;
			<%}else{ %>
			<%=replaceNull(visitId) %>
			<%} %>
		</td>	
			
		<td class='LABEL' id='packageCode<%=indx%>'>
			<%=pkgInfo.getPackageCode() %>
		</td>
		
		<td class='LABEL' >
			<%=pkgInfo.getPackageDesc() %>
		</td>
		<td class='LABEL' id='seqNo<%=indx%>'>
			<%=pkgInfo.getPkgSeqNo() %>
		</td>
		<td class='LABEL' id='pkg_amt<%=indx%>' style="text-align: right;" style="white-space: nowrap">
			<%=replaceNull(pkgInfo.getPackageAmt()) %>
		</td>
		<td class='LABEL' id='avail_amt<%=indx%>' style="text-align: right;" style="white-space: nowrap">
			<%=replaceNull(pkgInfo.getUtilized()) %>
		</td>
		
		<td class='LABEL' id='deposit_amt<%=indx%>' style="text-align: right;" style="white-space: nowrap">
		<%if("".equals(pkgInfo.getDepositAmt())){ %>
		&nbsp;
		<%}else{ %>
		<%=replaceNull(pkgInfo.getDepositAmt())%>
		<%} %>
		</td>				
		</tr>
<%} %>	
		</table>
		<br/>
		<br/>
		<table width='100%'  cellpadding='0'  cellspacing=0 >
		<tr>
			<td class='LABEL' width="60%" colspan="8">
				Open Subscribed Packages are available for the Patient. Do you want to Close?
			</td>
			<td>
				<input type='button' class='button' name='close' id='close' id='close' value='Yes' >
			</td>
			<td width='25%'>
				<%if("N".equals(pkgInfoCloseYn)){%>
				<input type='button' class='button' name='cancel' id='cancel' id='cancel' value='No' disabled>
			<%	} else{	%>
				<input type='button' class='button' name='cancel' id='cancel' id='cancel' value='No' >
			<%} 
			%>
			</td>
		</tr>		
	</table>
	<input type='hidden' id='totalCount' name='totalCount' id='totalCount' value='<%=indx %>'>
	<input type='hidden' id='patientId' name='patientId' id='patientId' value='<%=patientId %>'>
	<input type='hidden' id='episodeType' name='episodeType' id='episodeType' value='<%=episodeType %>'>
	<input type='hidden' id='episodeId' name='episodeId' id='episodeId' value='<%=episodeId %>'>
	<input type='hidden' id='visitId' name='visitId' id='visitId' value='<%=visitId %>'>
	<input type='hidden' id='totalGroup' name='totalGroup' id='totalGroup' value='<%=totalGroup %>'>
	</form>
</body>
</html>

