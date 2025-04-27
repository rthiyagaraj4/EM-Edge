<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.*, java.util.*, java.text.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<html>
<head>
<title>Charge Patient</title>
<%  
request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String bl_install_yn = (String)session.getValue("bl_operational") == null ? "" : (String)session.getValue("bl_operational");
String user = (String) session.getValue("login_user");
String facilityId = (String) session.getValue("facility_id");
System.out.println("Bl Install YN ,BLChargePatientEncounterTabs.jsp->"+bl_install_yn);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



</head>

 <script>
 if($('#showBillDtl').val() == 'Y'){
	 $('#finImg').hide();
 }
 $('#finImg').click(function(){
	  var retVal  =          new String();
      var episode1  ="";
      var dialogTop = "200";
      var dialogHeight = "42" ; 
      var dialogWidth = "70" ; 
      var features = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
      var arguments  = "" ;
      var search_desc  =""; 
      var title =getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	    var column_sizes = escape("");               
      var column_descriptions ="";       
      var param =            "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episodeid="+
      episodeid+"&"+"visitid="+visitid+"&"+"patientid="+patientid+"&episode1="+episode1;
      retVal=window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);
 });
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
			cellref = criteriaCategoryButtonFrame.document.getElementById("tab").rows[0].cells
		else if(from_name=="COMMON")
			cellref = document.getElementById("tab").rows[0].cells
		for(i=0; i<cellref.length; i++)
		{
			if(i!=2 && i!=3)
			 cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
		obj.className = "CASECONDSELECTHORZ"
		currClass ="CASECONDSELECTHORZ";
	}
	
	function existingOrders(){
		changeColor(this,'COMMON');
		var frm = parent.BLChargePatientEncounterTabPage.document.forms[0];
		var patient_id = frm.patient_id.value;
		var episode_id = frm.episode_id.value;
		var visit_id = frm.visit_id.value;
		var encounter_date = frm.encounter_date.value;
		var encounter_id = frm.encounter_id.value;
		var episode_type = frm.episode_type.value;
		var queryString = frm.queryString.value;
		//<input type='hidden' id='allFramesExisting' name='allFramesExisting'  value='7%,0%,0%,6%,25%,28%,28%,0%,4%'>
		//parent.document.getElementById('BL_mainFrame').rows = parent.parent.document.getElementById('allFramesExisting').value;
		parent.document.getElementById("pline").style.height = "7vh";
		parent.document.getElementById('BillingBanner').style.height = "0vh";
		parent.document.getElementById('BillingMenu').style.height = "0vh";
		parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
		parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "25vh";
		parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "24vh";
		parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "25vh";
		parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "0vh";
		parent.document.getElementById('messageFrame1').style.height = "4vh";
		parent.BLChargePatientEncounterTabPage.location.href='BLChargePatientEncounterExistingOrder.jsp?'+queryString+"&encoded=Y";//patient_id='+patient_id+'&episode_id='+episode_id+'&visit_id='+visit_id+'&encounter_date='+encounter_date+'&encounter_id='+encounter_id+'&episode_type='+episode_type;
		parent.BLChargePatientExisOrderTraverse.location.href='../../eCommon/html/blank.html';
		parent.BLChargePatientExisOrderServDetails.location.href='../../eCommon/html/blank.html';
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';
		parent.BLChargePatientExisOrderServEdit.location.href = "../../eCommon/html/blank.html";
	}
	
	function newOrders(){
		if($('#enterServiceRequest').val() != 'Y'){
			alert(getMessage('BL1178','BL'));
			return false;
		}
		changeColor(this,'COMMON');	
		var frm = parent.BLChargePatientEncounterTabPage.document.forms[0];
		var patient_id = frm.patient_id.value;
		var episode_id = frm.episode_id.value;
		var visit_id = frm.visit_id.value;
		var encounter_date = frm.encounter_date.value;
		var encounter_id = frm.encounter_id.value;
		var episode_type = frm.episode_type.value;
		var queryString = frm.queryString.value;
		parent.BLChargePatientEncounterTabPage.location.href='BLChargePatientEncounterNewOrder.jsp?'+queryString;//patient_id='+patient_id+'&episode_id='+episode_id+'&visit_id='+visit_id+'&encounter_date='+encounter_date+'&encounter_id='+encounter_id+'&episode_type='+episode_type;
		parent.BLChargePatientExisOrderTraverse.location.href='../../eCommon/html/blank.html';
		parent.BLChargePatientExisOrderServDetails.location.href='../../eCommon/html/blank.html';
		//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';
		parent.BLChargePatientExisOrderServEdit.location.href = "../../eCommon/html/blank.html";
	}
	/*function futureOrder(){
		var frm = parent.BLChargePatientEncounterTabPage.document.forms[0];
		var patient_id = frm.patient_id.value;
		var episode_id = frm.episode_id.value;
		var visit_id = frm.visit_id.value;
		
		var episode_type = frm.episode_type.value;
		var facility_id=frm.facility_id.value;
		alert(facility_id);
		
		$.ajax({
			type:"POST",
			url:"../jsp/BLFutureOrder.jsp",
			data:" &patient_id="+patient_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&facility_id="+facility_id,	
			success: function(data){	
			var arr= data.split("::");
			alert(arr);
				if(arr[0]=='Y'){
					
					alert(getMessage(arr[1],'BL'));
					return;
				}
			},
			 error: function(data){
		alert("error");
		     }
		});

			
			}*/
 </script>
<%
	String existing_order_class="";
	String new_order_class="";
	String selectedTab=(String)request.getParameter("selectedTab");
	PlaceOrderBC placeOrderBC = new PlaceOrderBC();
	String[] privelege = placeOrderBC.getPrivilegeForUser(user, facilityId);
	String enterServiceRequest = privelege[1];
	String confirmServiceRequest = privelege[2];
	String cancelConfirmedService = privelege[3];
	String cancelSelfEntered = privelege[4];
	String cancelIndirect = privelege[5];
	String enterNegative = privelege[7];

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String noOfDecimals = "";
	try{
		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
		rst = pstmt.executeQuery();
		if(rst != null && rst.next()){
			noOfDecimals = rst.getString("no_of_decimal");
			System.err.println("noOfDecimals "+noOfDecimals);
		}
	}
	catch(Exception eX){	
		noOfDecimals = "2";
		System.err.println("Exception in getting Charge Logic YN ->"+eX);
	}
	finally{
		pstmt = null;
		rst = null;
		ConnectionManager.returnConnection(con);
	}
	if(selectedTab.equalsIgnoreCase("ExistingOrder")){
		existing_order_class="CASECONDSELECTHORZ";
		new_order_class="CAFIRSTSELECTHORZ";
	}else if(selectedTab.equalsIgnoreCase("NewOrder")){
		existing_order_class="CAFIRSTSELECTHORZ";
		new_order_class="CASECONDSELECTHORZ";
	}
%>
<!-- Selected stuff should be highlighted in black use:CASECONDSELECTHORZ-->

<form name="ChargePatientEncounterTabsForm" id="ChargePatientEncounterTabsForm">
	<table id="tab" cellspacing=0 cellpadding="3" border="0" width="20%">

	<tr>
			<td id="ExistingOrder" 	class="<%=existing_order_class%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="existingOrders();" nowrap>
			<a style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.EXISTING_ORDERS.label" bundle="${bl_labels}"/></a>
			</td>
			<!--added against MOHE-CRF-0039--> 
			<td id="NewOrder" 	class="<%=new_order_class%>" style=""  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="newOrders();" nowrap>
			<a  style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.NEW_ORDERS.label" bundle="${bl_labels}"/></a>
			</td>			
	</tr>
	</table>
	<input type='hidden' name='enterServiceRequest' id='enterServiceRequest'  value='<%=enterServiceRequest %>' >
	<input type='hidden' name='confirmServiceRequest' id='confirmServiceRequest'  value='<%=confirmServiceRequest %>' >
	<input type='hidden' name='cancelConfirmedService' id='cancelConfirmedService'  value='<%=cancelConfirmedService %>' >
	<input type='hidden' name='cancelSelfEntered' id='cancelSelfEntered'  value='<%=cancelSelfEntered %>' >
	<input type='hidden' name='cancelIndirect' id='cancelIndirect'  value='<%=cancelIndirect %>' >
	<input type='hidden' name='enterNegative' id='enterNegative'  value='<%=enterNegative %>' >	
	<input type='hidden' name='noOfDecimals' id='noOfDecimals' value='<%=noOfDecimals %>' >
</form>
</body>
</html> 

