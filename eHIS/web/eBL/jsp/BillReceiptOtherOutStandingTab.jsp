<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*, java.util.*, java.text.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<html>
<head>
<title>Charge Patient</title>
<%  
request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

 <script>
 function callOnMouseOver(obj){
		currClass = obj.className ;
			obj.className = 'CASECONDSELECTHORZ';
	}

	function callOnMouseOut(obj){
		obj.className = currClass;
	}

	function changeColor(obj,from_name)
	{
		if(from_name=="OR_BUTTONS")
			cellref = criteriaCategoryButtonFrame.document.getElementById('tab').rows[0].cells
		else if(from_name=="COMMON")
			cellref = document.getElementById('tab').rows[0].cells
		for(i=0; i<cellref.length; i++)
		{
			//if(i!=2 && i!=3)
			 cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
		obj.className = "CASECONDSELECTHORZ"
		currClass ="CASECONDSELECTHORZ";
	}
	
	function fnTotOutstUnBill(){
		changeColor(this,'COMMON');		
		var queryString = $('#queryString').val();
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesOtherOut').value;
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='8vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='62vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='6vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		//parent.BillReceiptExisOrderSearch.location.href='BillReceiptExistingOrderSearch.jsp?'+queryString;//patient_id='+patient_id+'&episode_id='+episode_id+'&visit_id='+visit_id+'&encounter_date='+encounter_date+'&encounter_id='+encounter_id+'&episode_type='+episode_type;
		parent.BillReceiptExisOrderDetails.location.href='../../eBL/jsp/BillReceiptTotOutstUnBilled.jsp?'+queryString;
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';		
	}
	
	function fnOutStBill(){
		changeColor(this,'COMMON');	
		var queryString = $('#queryString').val();
	//	parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesOtherOut').value;
	parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='8vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='62vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='6vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		//parent.BillReceiptExisOrderSearch.location.href='BillReceiptUnbillServReq.jsp?'+queryString;//patient_id='+patient_id+'&episode_id='+episode_id+'&visit_id='+visit_id+'&encounter_date='+encounter_date+'&encounter_id='+encounter_id+'&episode_type='+episode_type;
		parent.BillReceiptExisOrderDetails.location.href='../../eBL/jsp/BillReceiptOutstBill.jsp?'+queryString;
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';	
	}
	
	function fnUnBillEpis(){
		changeColor(this,'COMMON');	
		var queryString = $('#queryString').val();
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesOtherOut').value;
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='8vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='62vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='6vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderDetails.location.href='../../eBL/jsp/BillReceiptUnbilledEpisode.jsp?'+queryString;
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';	
	}
	
	function fnUnBillServReq(){
		changeColor(this,'COMMON');	
		var queryString = $('#queryString').val();
	//	parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesOtherOut').value;
	
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='68vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='5vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		//parent.BillReceiptExisOrderSearch.location.href='BillReceiptUnbillServReq.jsp?'+queryString;//patient_id='+patient_id+'&episode_id='+episode_id+'&visit_id='+visit_id+'&encounter_date='+encounter_date+'&encounter_id='+encounter_id+'&episode_type='+episode_type;
		parent.BillReceiptExisOrderDetails.location.href='../../eBL/jsp/BillReceiptUnbillServReq.jsp?'+queryString;
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';	
	}

 </script>
<%
String existing_order_class="";
String new_order_class="";
String queryString = (String) request.getQueryString();
String selectedTab=(String)request.getParameter("selectedTab");
if(selectedTab == null) selectedTab="billCumReceipt";

if(selectedTab.equalsIgnoreCase("billCumReceipt")){
	existing_order_class="CASECONDSELECTHORZ";
	new_order_class="CAFIRSTSELECTHORZ";
}else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
%>
<!-- Selected stuff should be highlighted in black use:CASECONDSELECTHORZ-->
<form name="ChargePatientEncounterTabsForm" id="ChargePatientEncounterTabsForm">
	<table id="tab" cellspacing=0 cellpadding="3" border="0" width="40%">

	<tr>
			<td id="totOutstUnBill" 	class="<%=existing_order_class%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="fnTotOutstUnBill();" nowrap>
			<a style='color:white;cursor:pointer' href="#">Tot. Outst. Unbilled</a>
			</td>
			<td id="outStBill" 	class="<%=new_order_class%>" style="display:'none'"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="fnOutStBill();" nowrap>
			<a  style='color:white;cursor:pointer' href="#">Outstanding Bills</a>
			</td>
			<td id="unBillEpis" 	class="<%=new_order_class%>" style="display:'none'"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="fnUnBillEpis();" nowrap>
			<a  style='color:white;cursor:pointer' href="#">Unbilled Episode</a>
			</td>
			
	</tr>
	</table>
	<input type='hidden' name='queryString' id='queryString' value='<%=queryString %>' >
</form>
</body>
</html> 

 

