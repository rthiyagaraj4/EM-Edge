<!DOCTYPE html>

<%@ page import="java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.net.*,java.lang.*,ecis.utils.OnlineReport,ecis.utils.OnlineReports" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../js/BLReprintReportReceipt.js'></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>	
<script type="text/javascript">
function removeAllRecord(){		
	
	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var lastindx =  $(trlast).attr('indexval');
	var i=1;
	
	for(i=1;i<=lastindx;i++) {
	
		var docTypeCode =  $.trim($('#doc_typ_code'+i).val());
		var docNum = $.trim($('#doc_num'+i).val());
		var uniqueReceiptId = docTypeCode+"_"+docNum;
		var dataArray = selectedReceipt.split('####');
		dataArray.splice($.inArray(uniqueReceiptId, dataArray),1);
		selectedReceipt = dataArray.join('####');		
		$('#row'+i).remove();
	}	
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
<%!
private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding ->"+e);
	}
	return output;
}
%>
	var selectedReceipt = window.parent.selectedFrame.selectedReceipt;// '';
	$(document).ready(function(){
		$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
				e.preventDefault();
				
		    }
		});
	
		
		if(document.ReprotPrint.modeType.value=='R'  ){
			var dataArr = (document.ReprotPrint.retVal.value).split("::");	
		
			var pgim_id_R = dataArr[0];
		
			var sessionId_R = dataArr[1];
			var pgim_date_R = (dataArr[2]);
			var pgim_id_C = (dataArr[3]);
			var sessionId_C = (dataArr[4]);
			var pgim_date_C = (dataArr[5]);
			var pgim_id_A1 = (dataArr[6]);
			var sessionId_A1 = (dataArr[7]);
			var pgim_date_A1 = (dataArr[8]);
			var pgim_id_A2 = (dataArr[9]);
			var sessionId_A2 = (dataArr[10]);
			var pgim_date_A2 = (dataArr[11]);
			var print_option = dataArr[15];
			var facilityId = dataArr[16];
			var language_id = dataArr[17];
		
			if(print_option=='R'){
				if(pgim_id_R != null && pgim_id_R != "") {
									
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_R+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_R+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}else if(pgim_id_C != null && pgim_id_C != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_C+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_C+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}
			}else if (print_option == 'A') {
				if(pgim_id_A1 != null && pgim_id_A1 != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_A1+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_A1+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}else if(pgim_id_A2 != null && pgim_id_A2 != "") {
					var dummyDoc = parent.messageFrame.document;
		  			var htmlVal = "<html><body>";
		  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facilityId+"'>";
		  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+language_id+"'>";
		  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgim_id_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
		  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+sessionId_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgim_date_A2+"'>";
		  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
		  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgim_id_A2+"'>";				
		  			htmlVal += "</form></body></html>";
		  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		  			dummyDoc.dummy_frm.submit();
				}
			}else if(print_option == 'B'){			 
					 var dialogHeight    = '8' ;
					 var dialogWidth = '20' ;	
					 var dialogTop = '100' ;	 
					 var center    = '1'  ;	
					 var arguments =   '';
					 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';		
					 var param="data="+document.ReprotPrint.retVal.value;
					
					 var getUrl1  = "../../eBL/jsp/BLReceiptMultipleReport.jsp?"+param;
					 var retVal = window.showModalDialog(getUrl1,arguments,features);	
					 window.returnValue = 'Y';
					 window.close();	
				}
		} else if(document.ReprotPrint.modeType.value=='C'  && document.ReprotPrint.succ.value == 'Y' ){	
			var errors = document.ReprotPrint.Status.value.split("<<");			
			var allError="";
			var i=0;		
			
			for(i=0;i<(errors.length);i++){				
				allError+=errors[i]+"\n";						
			}		
			
			parent.search_hdr.document.BLReceiptReprint.search_but.click();
			alert(allError);
			//alert(document.ReprotPrint.Status.value);
			parent.selectedFrame.location.href="../../eBL/jsp/BLReprintReceiptSelected.jsp";	
			parent.buttonFrame.location.href="../../eBL/jsp/BLReprintReceiptBtn.jsp";
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			
		}else if(document.ReprotPrint.modeType.value=='C'  && document.ReprotPrint.succ.value == 'N' ){			
			var errors = document.ReprotPrint.Status.value.split("<<");			
			var allError="";
			var i=0;		
			
			for(i=0;i<(errors.length)-1;i++){
				if(errors[i]!='10'){
				allError+=errors[i]+"\n";
				}				
			}			
			if(errors[errors.length-2]=='10') {
				parent.search_hdr.document.BLReceiptReprint.search_but.click();
				
				parent.selectedFrame.location.href="../../eBL/jsp/BLReprintReceiptSelected.jsp";	
				parent.buttonFrame.location.href="../../eBL/jsp/BLReprintReceiptBtn.jsp";
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			}else{
				alert(allError);
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			}
			
		}		
	});
</script>
</head>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<%!
public String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";	
	}
	return input;
}
%>
	<% 
	request.setCharacterEncoding("UTF-8");
	String retValue = decodeParam(request.getParameter("retValue"));
	System.err.println("retValue->"+retValue);
	String dataArr[] = retValue.split("::");
	String type = replaceNull(dataArr[0]);
	String succ= replaceNull(dataArr[1]);
//	String warning= replaceNull(dataArr[2]);	
	 if ("C".equals(type)) {
		System.out.println("in c");
		String mes="";	
		
		if("Y".equals(succ) ) {
			if(!dataArr[2].equals("N")){	
				mes = dataArr[2];
			}
			mes = mes+"APP-SM0070 Operation Completed Successfully ....";	
			
			// mes =  "APP-SM0070 Operation Completed Successfully ....";				
			System.out.println("cancel success mes="+mes);
		}else if("N".equals(succ)) {
			mes=dataArr[2];
			System.out.println("cancel error "+dataArr[2]);
		}%>
		<form name='ReprotPrint' id='ReprotPrint'>
		<input type='hidden' id='Status' name='Status' id='Status' value='<%=mes%>'>	
		<input type='hidden' id='modeType' name='modeType' id='modeType' value='<%=type%>'>	
		<input type='hidden' id='succ' name='succ' id='succ' value='<%=succ%>'>
							
		</form >
		<% }else {
				type="R";%>
				<form name='ReprotPrint' id='ReprotPrint'>
					
				<input type='hidden' id='modeType' name='modeType' id='modeType' value='<%=type%>'>	
				<input type='hidden' id='retVal' name='retVal' id='retVal' value='<%=retValue%>'>	
					
				</form >
		<%	} %>
</body>
</html>

