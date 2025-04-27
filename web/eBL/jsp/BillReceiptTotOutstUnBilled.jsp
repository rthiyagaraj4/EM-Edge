<!DOCTYPE html>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.HashMap"%>
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
			

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		var pDoc = parent.BillReceiptTab.document
		/*var unBilled = $(pDoc).find('#unBilled').val();
		var totOutSt = $(pDoc).find('#totOutSt').val();
		
		
		$('#otherOutStnd').val(totOutSt);
		$('#otherUnbill').val(unBilled);*/
		var noOfDecimal = $(pDoc).find('#noOfDecimal').val();
		
		$('input:text').each(function(){
			
			if($(this).val() != ''){
				putDecimal($(this).get(0),17,noOfDecimal);				
			}
			else{
				$(this).val('0');
				putDecimal($(this).get(0),17,noOfDecimal);
			}

		});
	});
</script>
<%
//V220512
//String patientId = replaceNull(request.getParameter("patient_id"));
String patientId="";
if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	}else{
	patientId	= replaceNull(request.getParameter("patient_id"));
}
//V220512
String episodeType = replaceNull(request.getParameter("episode_type"));
String episodeId = replaceNull(request.getParameter("episode_id"));
String visitId = replaceNull(request.getParameter("visit_id"));

BillReceiptRequest billRequest = new BillReceiptRequest();
billRequest.setPatientId(patientId);
billRequest.setEpisodeId(episodeId);
billRequest.setEpisodeType(episodeType);
billRequest.setVisitId(visitId);

BillReceiptBC bc = new BillReceiptBC();
HashMap<String,String> map = new HashMap<String,String>();
map = bc.getOutstandingUnbilled(billRequest);
%>
</head>
<body>
<br/>
<br/>
<div style="float:left; width: 10%">

</div>
<div style="float:left; width: 90%">
<table width='35%' align="left" cellpadding='3'  cellspacing=0 >
	<tr>
		<td class='COLUMNHEADER' nowrap colspan="3" align="center">Other Unbilled & Outstanding</td>
	</tr>
	<tr>
		<td class='LABEL' width="30%" align="right">Other Outstanding</td>
		<td width="10%">&nbsp;</td>
		<td class='field'  width="40%" align="left">
		<input type='text' id='otherOutStnd' name='otherOutStnd' size='12' readonly value='<%=map.get("outst") %>' style="text-align: right;">
		</td>
	</tr>
	<tr>
		<td class='LABEL' width="30%" align="right">Other Unbilled Amt</td>
		<td width="10%">&nbsp;</td>
		<td class='field'  width="40%" align="left">
		<input type='text' id='otherUnbill' name='otherUnbill' size='12' readonly value='<%=map.get("unbilled") %>' style="text-align: right;">
		</td>
	</tr>
</table>

</div>

</body>
</html>

