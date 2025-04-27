<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
";
		dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
		dummyDoc.dummy_frm.submit();
  		} else if (print=="R"){  			  	  				
  			var dummyDoc = parent.document.frames[1].document;
  			var htmlVal = "<html><body>";
  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+document.ReprotPrint.facilityId.value+"'>";
  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+document.ReprotPrint.locale.value+"'>";
  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+document.ReprotPrint.pgim_id_R.value+"'>";
  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+document.ReprotPrint.sessionId_R.value+"'>";
  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+document.ReprotPrint.pgim_date_R.value+"'>";
  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+document.ReprotPrint.pgim_id_R.value+"'>";				
  			htmlVal += "</form></body></html>";
  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
  			dummyDoc.dummy_frm.submit();
  	  	} else if (print=="A2"){  						
  			var dummyDoc =parent.document.frames[1].document;
  			var htmlVal = "<html><body>";
  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+document.ReprotPrint.facilityId.value+"'>";
  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+document.ReprotPrint.locale.value+"'>";
  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+document.ReprotPrint.pgim_id_A2.value+"'>";
  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+document.ReprotPrint.sessionId_A2.value+"'>";
  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+document.ReprotPrint.pgim_date_A2.value+"'>";
  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+document.ReprotPrint.pgim_id_A2.value+"'>";				
  			htmlVal += "</form></body></html>";
  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
  			dummyDoc.dummy_frm.submit();
  	  		} else if (print=="C"){  						
  			var dummyDoc = parent.document.frames[1].document;
  			var htmlVal = "<html><body>";
  			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
  			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+document.ReprotPrint.facilityId.value+"'>";
  			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+document.ReprotPrint.locale.value+"'>";
  			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+document.ReprotPrint.pgim_id_C.value+"'>";
  			htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+"N"+"'>";
  			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+document.ReprotPrint.sessionId_C.value+"'>";
  			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+document.ReprotPrint.pgim_date_C.value+"'>";
  			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
  			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+document.ReprotPrint.pgim_id_C.value+"'>";				
  			htmlVal += "</form></body></html>";
  			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
  			dummyDoc.dummy_frm.submit();
  	  		}
  		
  	}
  	
  	function windowClose()
  	  {
  		
  		parent.window.close();
  	  }
  	
  	</script>
<%!
 private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
String data			= request.getParameter("data")==null?"": request.getParameter("data");
String dataArr[] = data.split("::");	
String pgim_id_R = checkForNull(dataArr[0]);
String sessionId_R = checkForNull(dataArr[1]);
String pgim_date_R = checkForNull(dataArr[2]);
String pgim_id_C = checkForNull(dataArr[3]);
String sessionId_C = checkForNull(dataArr[4]);
String pgim_date_C = checkForNull(dataArr[5]);
String pgim_id_A1 = checkForNull(dataArr[6]);
String sessionId_A1 = checkForNull(dataArr[7]);
String pgim_date_A1 = checkForNull(dataArr[8]);
String pgim_id_A2 = checkForNull(dataArr[9]);
String sessionId_A2 = checkForNull(dataArr[10]);
String pgim_date_A2 = checkForNull(dataArr[11]);

%>
	<body>
	<form name='ReprotPrint' id='ReprotPrint'>
		<div id="tableContainer">
		<tr style=" border: '0';" id='trProgress'>
		<table border='0' cellpadding='25' cellspacing='0'  id='tbl' width='100%'  align='center' > 		
		<tbody>			
		<tr>
		<td class="label" >Report Options</td>	
		<td>
		<select name='print_option' id='print_option' id='print_option' onChange="">	 
		<% if(!"".equals(pgim_id_R))	{%>
		<option value='R'><fmt:message key="eBL.RECEIPT.label" bundle="${bl_labels}"/></option>
		<%}
		 if(!"".equals(pgim_id_C))	{%>	
		<option value='C'>Coupan</option>
		<%}
		 if(!"".equals(pgim_id_A1))	{%>
		<option value='A1'>Acknowledgement</option>
		<%}
		 if(!"".equals(pgim_id_A2))	{%>		
		<option value='A2'>Acknowledgement</option>
		<%}%>
		</select>
		</td>
		</tr>
		<tr ><td class="label" ><input type='button' class='button' onclick='runReport(print_option.value);' value="Run"  name='run_report' id='run_report' >
		<input type='button' class='button' onclick='windowClose();' value="Close"  name='close_report' id='close_report' >
		</td>		
		</tr>						
		</tbody>	
		</tr> 
		<input type='hidden' id='facilityId' name='facilityId' id='facilityId' value='RP'>
		<input type='hidden' id='locale' name='locale' id='locale' value='en'>
		<input type='hidden' id='pgim_id_R' name='pgim_id_R' id='pgim_id_R' value='<%=pgim_id_R %>'>
		<input type='hidden' id='sessionId_R' name='sessionId_R' id='sessionId_R' value='<%=sessionId_R %>'>
		<input type='hidden' id='pgim_date_R' name='pgim_date_R' id='pgim_date_R' value='<%=pgim_date_R %>'>		
		<input type='hidden' id='pgim_id_C' name='pgim_id_C' id='pgim_id_C' value='<%=pgim_id_C %>'>
		<input type='hidden' id='sessionId_C' name='sessionId_C' id='sessionId_C' value='<%=sessionId_C %>'>
		<input type='hidden' id='pgim_date_C' name='pgim_date_C' id='pgim_date_C' value='<%=pgim_date_C %>'>
		<input type='hidden' id='pgim_id_A1' name='pgim_id_A1' id='pgim_id_A1' value='<%=pgim_id_A1 %>'>
		<input type='hidden' id='sessionId_A1' name='sessionId_A1' id='sessionId_A1' value='<%=sessionId_A1 %>'>
		<input type='hidden' id='pgim_date_A1' name='pgim_date_A1' id='pgim_date_A1' value='<%=pgim_date_A1 %>'>		
		<input type='hidden' id='pgim_id_A2' name='pgim_id_A2' id='pgim_id_A2' value='<%=pgim_id_A2 %>'>
		<input type='hidden' id='sessionId_A2' name='sessionId_A2' id='sessionId_A2' value='<%=sessionId_A2 %>'>
		<input type='hidden' id='pgim_date_A2' name='pgim_date_A2' id='pgim_date_A2' value='<%=pgim_date_A2 %>'>
		</table>
  	</div>
  	</form>
  	</body>
  </HTML>
  

